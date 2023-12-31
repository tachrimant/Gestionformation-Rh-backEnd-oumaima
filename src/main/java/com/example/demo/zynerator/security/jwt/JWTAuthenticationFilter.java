package com.example.demo.zynerator.security.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.demo.DemoApplication;
import com.example.demo.zynerator.security.bean.User;
import com.example.demo.zynerator.security.common.SecurityParams;
import com.example.demo.zynerator.security.service.facade.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;


public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private final AuthenticationManager authenticationManager;

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }


    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try {
            User myUser = new ObjectMapper().readValue(request.getInputStream(), User.class);
            System.out.println(myUser.getUsername());
            System.out.println(myUser.getPassword());
            return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(myUser.getUsername(), myUser.getPassword()));
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response,
                                            FilterChain chain, Authentication authResult) throws IOException, ServletException {
        User user = (User) authResult.getPrincipal();

        UserService userService = DemoApplication.getCtx().getBean(UserService.class);

        User myUser = userService.findByUsernameWithRoles(user.getUsername());

        Collection<String> roles = new ArrayList<>();
        if (myUser.getAuthorities() != null) {
            myUser.getAuthorities().forEach(a -> roles.add(a.getAuthority()));
        }
        Boolean passwordChanged = myUser.isPasswordChanged();
        if (passwordChanged == null) {
            passwordChanged = Boolean.FALSE;
        }

        String[] categorieRoles = user.getCategorieRoles().stream().toArray(String[]::new);
        String[] rolesByDomain = user.getRolesByDomain().stream().toArray(String[]::new);

        String jwt = JWT.create()
                .withIssuer(request.getRequestURI())
                .withSubject(user.getUsername())
                .withSubject(user.getPrenom())
                .withSubject(user.getNom())
                .withArrayClaim("roles", roles.toArray(new String[roles.size()]))
                .withExpiresAt(new Date(System.currentTimeMillis() + SecurityParams.EXPIRATION))
                .withClaim("passwordChanged", passwordChanged)
/*                .withArrayClaim("categorieRoles", categorieRoles)
                .withArrayClaim("rolesByDomain",rolesByDomain)*/
                .sign(Algorithm.HMAC256(SecurityParams.SECRET));
        response.addHeader(SecurityParams.JWT_HEADER_NAME, SecurityParams.HEADER_PREFIX + jwt);
        //response.addHeader(SecurityParams.JWT_HEADER_NAME,jwt);
        System.out.println(jwt);

        HashMap<String, Object> idToken = new HashMap<String, Object>();
        idToken.put("access_token", jwt);

        idToken.put("expires_in", SecurityParams.EXPIRATION);
        idToken.put("token_type", "Bearer");
        idToken.put("roles", roles.toArray(new String[roles.size()]));
        idToken.put("user",user.getId());
        new ObjectMapper().writeValue(response.getOutputStream(),idToken);
    }

}
