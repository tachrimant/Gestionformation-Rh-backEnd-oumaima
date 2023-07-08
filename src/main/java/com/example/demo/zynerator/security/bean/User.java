package com.example.demo.zynerator.security.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "user_app")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class User implements UserDetails {
    public static final List<String> CATEGORIE_ROLES = Arrays.asList("OPERATEURAGENDA", "AGENDA", "OPERATEURHORAIRETRAVAILLEVALIDATION", "DEMANDERDV", "OPERATEURUNITEADMINISTRATIVE", "HOPITAL", "CAUSEREJETDEMANDERDV", "OPERATEUR", "JOURFERIE", "OPERATEURQUOTA", "TYPEPRESTATION", "UNITEADMINISTRATIVE", "PRESTATION", "TEMPLATEEMAILCONFIRMATION", "HORAIRETRAVAILLEVALIDATION", "PATIENT", "CELLULEVALIDATION", "STATUSRDV");
    public static final List<String> ROLES_BY_DOMAIN = Arrays.asList("ROLE_UPDATE_OPERATEURAGENDA", "ROLE_READ_OPERATEURAGENDA", "ROLE_CREATE_OPERATEURAGENDA", "ROLE_DELETE_OPERATEURAGENDA", "ROLE_UPDATE_AGENDA", "ROLE_READ_AGENDA", "ROLE_CREATE_AGENDA", "ROLE_DELETE_AGENDA", "ROLE_UPDATE_OPERATEURHORAIRETRAVAILLEVALIDATION", "ROLE_READ_OPERATEURHORAIRETRAVAILLEVALIDATION", "ROLE_CREATE_OPERATEURHORAIRETRAVAILLEVALIDATION", "ROLE_DELETE_OPERATEURHORAIRETRAVAILLEVALIDATION", "ROLE_UPDATE_DEMANDERDV", "ROLE_READ_DEMANDERDV", "ROLE_CREATE_DEMANDERDV", "ROLE_DELETE_DEMANDERDV", "ROLE_UPDATE_OPERATEURUNITEADMINISTRATIVE", "ROLE_READ_OPERATEURUNITEADMINISTRATIVE", "ROLE_CREATE_OPERATEURUNITEADMINISTRATIVE", "ROLE_DELETE_OPERATEURUNITEADMINISTRATIVE", "ROLE_UPDATE_HOPITAL", "ROLE_READ_HOPITAL", "ROLE_CREATE_HOPITAL", "ROLE_DELETE_HOPITAL", "ROLE_UPDATE_CAUSEREJETDEMANDERDV", "ROLE_READ_CAUSEREJETDEMANDERDV", "ROLE_CREATE_CAUSEREJETDEMANDERDV", "ROLE_DELETE_CAUSEREJETDEMANDERDV", "ROLE_UPDATE_OPERATEUR", "ROLE_READ_OPERATEUR", "ROLE_CREATE_OPERATEUR", "ROLE_DELETE_OPERATEUR", "ROLE_UPDATE_JOURFERIE", "ROLE_READ_JOURFERIE", "ROLE_CREATE_JOURFERIE", "ROLE_DELETE_JOURFERIE", "ROLE_UPDATE_OPERATEURQUOTA", "ROLE_READ_OPERATEURQUOTA", "ROLE_CREATE_OPERATEURQUOTA", "ROLE_DELETE_OPERATEURQUOTA", "ROLE_UPDATE_TYPEPRESTATION", "ROLE_READ_TYPEPRESTATION", "ROLE_CREATE_TYPEPRESTATION", "ROLE_DELETE_TYPEPRESTATION", "ROLE_UPDATE_UNITEADMINISTRATIVE", "ROLE_READ_UNITEADMINISTRATIVE", "ROLE_CREATE_UNITEADMINISTRATIVE", "ROLE_DELETE_UNITEADMINISTRATIVE", "ROLE_UPDATE_PRESTATION", "ROLE_READ_PRESTATION", "ROLE_CREATE_PRESTATION", "ROLE_DELETE_PRESTATION", "ROLE_UPDATE_TEMPLATEEMAILCONFIRMATION", "ROLE_READ_TEMPLATEEMAILCONFIRMATION", "ROLE_CREATE_TEMPLATEEMAILCONFIRMATION", "ROLE_DELETE_TEMPLATEEMAILCONFIRMATION", "ROLE_UPDATE_HORAIRETRAVAILLEVALIDATION", "ROLE_READ_HORAIRETRAVAILLEVALIDATION", "ROLE_CREATE_HORAIRETRAVAILLEVALIDATION", "ROLE_DELETE_HORAIRETRAVAILLEVALIDATION", "ROLE_UPDATE_PATIENT", "ROLE_READ_PATIENT", "ROLE_CREATE_PATIENT", "ROLE_DELETE_PATIENT", "ROLE_UPDATE_CELLULEVALIDATION", "ROLE_READ_CELLULEVALIDATION", "ROLE_CREATE_CELLULEVALIDATION", "ROLE_DELETE_CELLULEVALIDATION", "ROLE_UPDATE_STATUSRDV", "ROLE_READ_STATUSRDV", "ROLE_CREATE_STATUSRDV", "ROLE_DELETE_STATUSRDV");
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;
    protected boolean credentialsNonExpired;
    protected boolean enabled;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss.SSS")
    @Temporal(TemporalType.TIMESTAMP)
    protected Date createdAt;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss.SSS")
    @Temporal(TemporalType.TIMESTAMP)
    protected Date updatedAt;
    protected String email;
    protected boolean accountNonExpired;
    protected boolean accountNonLocked;
    protected String username;
    protected String password;
    protected String prenom;
    protected String nom;
    protected boolean passwordChanged;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_roles", joinColumns = {@JoinColumn(name = "USER_ID")}, inverseJoinColumns = {
            @JoinColumn(name = "ROLE_ID")})
    protected Collection<Role> roles = new ArrayList<>();
    @Transient
    protected Collection<Role> authorities;
    @Transient
    protected List<String> rolesByDomain;
    @Transient
    protected List<String> categorieRoles;


    public User() {
        super();
    }

    public User(String username) {
        this.username = username;
        this.password = username;
        this.prenom = username;
        this.nom = username;
        this.email = username;
    }

    public List<String> getRolesByDomain() {
        rolesByDomain = ROLES_BY_DOMAIN;
        return rolesByDomain;
    }

    public void setRolesByDomain(List<String> rolesByDomain) {
        this.rolesByDomain = rolesByDomain;
    }

    public List<String> getCategorieRoles() {
        categorieRoles = CATEGORIE_ROLES;
        return categorieRoles;
    }

    public void setCategorieRoles(List<String> categorieRoles) {
        this.categorieRoles = categorieRoles;
    }


    public boolean getCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    public boolean getEnabled() {
        return enabled;
    }

    public boolean getAccountNonExpired() {
        return accountNonExpired;
    }

    public boolean getAccountNonLocked() {
        return accountNonLocked;
    }

    public boolean getPasswordChanged() {
        return passwordChanged;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }


    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    public void setAccountNonExpired(boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public Collection<Role> getAuthorities() {
        if (this.authorities == null)
            this.authorities = this.roles;
        return authorities;
    }

    public void setAuthorities(Collection<Role> authorities) {
        this.authorities = authorities;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isPasswordChanged() {
        return passwordChanged;
    }

    public void setPasswordChanged(boolean passwordChanged) {
        this.passwordChanged = passwordChanged;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

}
