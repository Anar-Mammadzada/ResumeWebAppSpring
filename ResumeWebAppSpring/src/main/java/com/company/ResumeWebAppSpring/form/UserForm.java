/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.ResumeWebAppSpring.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Anar
 */
public class UserForm {
    @NotNull
    @NotEmpty
    private String name;
    
    
    @NotNull
    @NotEmpty
    private String surname;
    
    private Integer nationalityId;

    public UserForm() {
    }

    public UserForm(String name, String surname, Integer nationalityId) {
        this.name = name;
        this.surname = surname;
        this.nationalityId = nationalityId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getNationalityId() {
        return nationalityId;
    }

    public void setNationalityId(Integer nationalityId) {
        this.nationalityId = nationalityId;
    }
    
    
}
