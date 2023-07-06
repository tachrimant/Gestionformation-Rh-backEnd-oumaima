package com.example.demo;

import com.example.demo.zynerator.security.bean.Permission;
import com.example.demo.zynerator.security.bean.Role;
import com.example.demo.zynerator.security.bean.User;
import com.example.demo.zynerator.security.common.AuthoritiesConstants;
import com.example.demo.zynerator.security.service.facade.RoleService;
import com.example.demo.zynerator.security.service.facade.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DemoApplication {

    public static ConfigurableApplicationContext ctx;

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
                userService.save(userForAdmin);
            }
        };
    }

    private static void addPermissionForAdmin(List<Permission> permissions){
        permissions.add(new Permission("OperateurAgenda.edit"));
        permissions.add(new Permission("OperateurAgenda.list"));
        permissions.add(new Permission("OperateurAgenda.view"));
        permissions.add(new Permission("OperateurAgenda.add"));
        permissions.add(new Permission("OperateurAgenda.delete"));
        permissions.add(new Permission("Agenda.edit"));
        permissions.add(new Permission("Agenda.list"));
        permissions.add(new Permission("Agenda.view"));
        permissions.add(new Permission("Agenda.add"));
        permissions.add(new Permission("Agenda.delete"));
        permissions.add(new Permission("OperateurHoraireTravailleValidation.edit"));
        permissions.add(new Permission("OperateurHoraireTravailleValidation.list"));
        permissions.add(new Permission("OperateurHoraireTravailleValidation.view"));
        permissions.add(new Permission("OperateurHoraireTravailleValidation.add"));
        permissions.add(new Permission("OperateurHoraireTravailleValidation.delete"));
        permissions.add(new Permission("DemandeRdv.edit"));
        permissions.add(new Permission("DemandeRdv.list"));
        permissions.add(new Permission("DemandeRdv.view"));
        permissions.add(new Permission("DemandeRdv.add"));
        permissions.add(new Permission("DemandeRdv.delete"));
        permissions.add(new Permission("OperateurUniteAdministrative.edit"));
        permissions.add(new Permission("OperateurUniteAdministrative.list"));
        permissions.add(new Permission("OperateurUniteAdministrative.view"));
        permissions.add(new Permission("OperateurUniteAdministrative.add"));
        permissions.add(new Permission("OperateurUniteAdministrative.delete"));
        permissions.add(new Permission("Hopital.edit"));
        permissions.add(new Permission("Hopital.list"));
        permissions.add(new Permission("Hopital.view"));
        permissions.add(new Permission("Hopital.add"));
        permissions.add(new Permission("Hopital.delete"));
        permissions.add(new Permission("CauseRejetDemandeRdv.edit"));
        permissions.add(new Permission("CauseRejetDemandeRdv.list"));
        permissions.add(new Permission("CauseRejetDemandeRdv.view"));
        permissions.add(new Permission("CauseRejetDemandeRdv.add"));
        permissions.add(new Permission("CauseRejetDemandeRdv.delete"));
        permissions.add(new Permission("Operateur.edit"));
        permissions.add(new Permission("Operateur.list"));
        permissions.add(new Permission("Operateur.view"));
        permissions.add(new Permission("Operateur.add"));
        permissions.add(new Permission("Operateur.delete"));
        permissions.add(new Permission("JourFerie.edit"));
        permissions.add(new Permission("JourFerie.list"));
        permissions.add(new Permission("JourFerie.view"));
        permissions.add(new Permission("JourFerie.add"));
        permissions.add(new Permission("JourFerie.delete"));
        permissions.add(new Permission("OperateurQuota.edit"));
        permissions.add(new Permission("OperateurQuota.list"));
        permissions.add(new Permission("OperateurQuota.view"));
        permissions.add(new Permission("OperateurQuota.add"));
        permissions.add(new Permission("OperateurQuota.delete"));
        permissions.add(new Permission("TypePrestation.edit"));
        permissions.add(new Permission("TypePrestation.list"));
        permissions.add(new Permission("TypePrestation.view"));
        permissions.add(new Permission("TypePrestation.add"));
        permissions.add(new Permission("TypePrestation.delete"));
        permissions.add(new Permission("UniteAdministrative.edit"));
        permissions.add(new Permission("UniteAdministrative.list"));
        permissions.add(new Permission("UniteAdministrative.view"));
        permissions.add(new Permission("UniteAdministrative.add"));
        permissions.add(new Permission("UniteAdministrative.delete"));
        permissions.add(new Permission("Prestation.edit"));
        permissions.add(new Permission("Prestation.list"));
        permissions.add(new Permission("Prestation.view"));
        permissions.add(new Permission("Prestation.add"));
        permissions.add(new Permission("Prestation.delete"));
        permissions.add(new Permission("TemplateEmailConfirmation.edit"));
        permissions.add(new Permission("TemplateEmailConfirmation.list"));
        permissions.add(new Permission("TemplateEmailConfirmation.view"));
        permissions.add(new Permission("TemplateEmailConfirmation.add"));
        permissions.add(new Permission("TemplateEmailConfirmation.delete"));
        permissions.add(new Permission("HoraireTravailleValidation.edit"));
        permissions.add(new Permission("HoraireTravailleValidation.list"));
        permissions.add(new Permission("HoraireTravailleValidation.view"));
        permissions.add(new Permission("HoraireTravailleValidation.add"));
        permissions.add(new Permission("HoraireTravailleValidation.delete"));
        permissions.add(new Permission("Patient.edit"));
        permissions.add(new Permission("Patient.list"));
        permissions.add(new Permission("Patient.view"));
        permissions.add(new Permission("Patient.add"));
        permissions.add(new Permission("Patient.delete"));
        permissions.add(new Permission("CelluleValidation.edit"));
        permissions.add(new Permission("CelluleValidation.list"));
        permissions.add(new Permission("CelluleValidation.view"));
        permissions.add(new Permission("CelluleValidation.add"));
        permissions.add(new Permission("CelluleValidation.delete"));
        permissions.add(new Permission("StatusRdv.edit"));
        permissions.add(new Permission("StatusRdv.list"));
        permissions.add(new Permission("StatusRdv.view"));
        permissions.add(new Permission("StatusRdv.add"));
        permissions.add(new Permission("StatusRdv.delete"));
    }

}
