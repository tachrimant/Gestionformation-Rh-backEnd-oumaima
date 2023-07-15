package com.example.demo;

import com.example.demo.zynerator.security.bean.Permission;
import com.example.demo.zynerator.security.bean.Role;
import com.example.demo.zynerator.security.bean.User;
import com.example.demo.zynerator.security.common.AuthoritiesConstants;
import com.example.demo.zynerator.security.service.facade.RoleService;
import com.example.demo.zynerator.security.service.facade.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DemoApplication {

    public static ConfigurableApplicationContext ctx;

    @Autowired
    @Lazy
    PasswordEncoder bCryptPasswordEncoder;

    public static ConfigurableApplicationContext getCtx() {
        return ctx;
    }

    public static void main(String[] args) {
        ctx=SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(UserService userService, RoleService roleService) {
        return (args) -> {
            if(true){
                User userForAdmin = new User("admin");

                Role roleForAdmin = new Role();
                roleForAdmin.setAuthority(AuthoritiesConstants.ADMIN);
                List<Permission> permissionsForAdmin = new ArrayList<>();
                addPermissionForAdmin(permissionsForAdmin);
                roleForAdmin.setPermissions(permissionsForAdmin);
                if(userForAdmin.getRoles()==null)
                    userForAdmin.setRoles(new ArrayList<>());

                userForAdmin.getRoles().add(roleForAdmin);
                userForAdmin.setPassword(bCryptPasswordEncoder.encode("123"));

                userService.save(userForAdmin);
            }
        };
    }

    private static void addPermissionForAdmin(List<Permission> permissions){
        permissions.add(new Permission("DemandeConge.edit"));
        permissions.add(new Permission("DemandeConge.list"));
        permissions.add(new Permission("DemandeConge.view"));
        permissions.add(new Permission("DemandeConge.add"));
        permissions.add(new Permission("DemandeConge.delete"));
        permissions.add(new Permission("EtatDemandeConge.edit"));
        permissions.add(new Permission("EtatDemandeConge.list"));
        permissions.add(new Permission("EtatDemandeConge.view"));
        permissions.add(new Permission("EtatDemandeConge.add"));
        permissions.add(new Permission("EtatDemandeConge.delete"));
        permissions.add(new Permission("DemandeMission.edit"));
        permissions.add(new Permission("DemandeMission.list"));
        permissions.add(new Permission("DemandeMission.view"));
        permissions.add(new Permission("DemandeMission.add"));
        permissions.add(new Permission("DemandeMission.delete"));
        permissions.add(new Permission("EtatDemandeMission.edit"));
        permissions.add(new Permission("EtatDemandeMission.list"));
        permissions.add(new Permission("EtatDemandeMission.view"));
        permissions.add(new Permission("EtatDemandeMission.add"));
        permissions.add(new Permission("EtatDemandeMission.delete"));
        permissions.add(new Permission("DemandeDeficheDepaie.edit"));
        permissions.add(new Permission("DemandeDeficheDepaie.list"));
        permissions.add(new Permission("DemandeDeficheDepaie.view"));
        permissions.add(new Permission("DemandeDeficheDepaie.add"));
        permissions.add(new Permission("DemandeDeficheDepaie.delete"));
        permissions.add(new Permission("EtatDemandeFicheDepaie.edit"));
        permissions.add(new Permission("EtatDemandeFicheDepaie.list"));
        permissions.add(new Permission("EtatDemandeFicheDepaie.view"));
        permissions.add(new Permission("EtatDemandeFicheDepaie.add"));
        permissions.add(new Permission("EtatDemandeFicheDepaie.delete"));
        permissions.add(new Permission("Employe.edit"));
        permissions.add(new Permission("Employe.list"));
        permissions.add(new Permission("Employe.view"));
        permissions.add(new Permission("Employe.add"));
        permissions.add(new Permission("Employe.delete"));
        permissions.add(new Permission("Projet.edit"));
        permissions.add(new Permission("Projet.list"));
        permissions.add(new Permission("Projet.view"));
        permissions.add(new Permission("Projet.add"));
        permissions.add(new Permission("Projet.delete"));
        permissions.add(new Permission("Tache.edit"));
        permissions.add(new Permission("Tache.list"));
        permissions.add(new Permission("Tache.view"));
        permissions.add(new Permission("Tache.add"));
        permissions.add(new Permission("Tache.delete"));
        permissions.add(new Permission("Tache.edit"));
        permissions.add(new Permission("Tache.list"));
        permissions.add(new Permission("Tache.view"));
        permissions.add(new Permission("Tache.add"));
        permissions.add(new Permission("Tache.delete"));

    }

}
