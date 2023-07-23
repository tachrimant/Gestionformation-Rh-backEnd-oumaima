package com.example.demo.service.implementation;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.dto.EmployeDto;

import com.example.demo.zynerator.security.bean.Role;
import com.example.demo.zynerator.security.bean.User;
import com.example.demo.zynerator.security.common.AuthoritiesConstants;
import com.example.demo.zynerator.security.service.facade.UserService;
import com.example.demo.zynerator.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.demo.service.facade.EmployeService;

import com.example.demo.dao.EmployeDao;
import com.example.demo.entities.Employe;

import java.util.Date;
import java.util.Optional;

@Service
public class EmployeServiceImplementation implements EmployeService {
    @Autowired
    private EmployeDao employeDao;

    @Autowired
    @Lazy
    PasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserService userService;

    @Override
    public void save(Employe employe) {

        if (employeDao.findEmployeByCin(employe.getCin())!= null || findEmployeByEmail(employe.getEmail())!= null){
            throw new RuntimeException("Employé avec cet Email ou CIN déjà existe. Veuillez verifier l'email ou le CIN");
        }


        Role roleForUser = new Role();
        roleForUser.setAuthority(AuthoritiesConstants.USER);
        ArrayList<Role> listrole = new ArrayList();
        listrole.add(roleForUser);
        employe.setRoles(listrole);

        employe.setPassword(employe.getPassword() != null ? bCryptPasswordEncoder.encode(employe.getPassword()):  bCryptPasswordEncoder.encode(employe.getCin()));
        employe.setUsername(employe.getUsername() != null ?employe.getUsername():employe.getNom()  + employe.getPrenom());

        userService.save(employe);

     }

    @Override
    public void edit(Employe employe) {

        Employe employe1 = findById(employe.getId());
        Employe employe2 = findEmployeByCin(employe.getCin()).get(0);
        Employe employe3 = findEmployeByEmail(employe.getEmail());

        if ((employe2 != null || employe3 != null)) {
            assert employe2 != null;
            if (!employe2.getId().equals(employe.getId()) || !employe3.getId().equals(employe.getId())) {
                throw new RuntimeException("Employé avec cet Email ou CIN déjà existe. Veuillez verifier l'email ou le CIN");
            }
        }


        if (employe1 != null){
            employe1.setCin(employe.getCin());
            employe1.setEmail(employe.getEmail());
            employe1.setNom(employe.getNom());
            employe1.setPrenom(employe.getPrenom());
            employe1.setDatenaissance(employe.getDatenaissance());
            employeDao.save(employe1);
        }
    }

    @Override
    public void deleteById(Long id) {
        employeDao.deleteById(id);
    }

    @Override
    public Employe findById(Long id) {
        return employeDao.findById(id).orElse(null);
    }

    @Override
    public List<Employe> findAll() {
        return employeDao.findAll();
    }

    @Override 
    public List<Employe> findEmployeByCin(String cin){
      return  employeDao.findEmployeByCinLike(cin );
}

        @Override 
    public Employe findEmployeByNom(String nom){
      return  employeDao.findEmployeByNom(nom );
}

        @Override 
    public Employe findEmployeByPrenom(String prenom){
      return  employeDao.findEmployeByPrenom(prenom );
}

        @Override 
    public Employe findEmployeByEmail(String email){
      return  employeDao.findEmployeByEmail(email );
}

        @Override 
    public Employe findEmployeByDatenaissance(Date datenaissance){
      return  employeDao.findEmployeByDatenaissance(datenaissance );
}

}