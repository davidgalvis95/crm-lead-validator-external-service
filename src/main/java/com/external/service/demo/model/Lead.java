package com.external.service.demo.model;

import java.time.LocalDate;


public class Lead
{
    private Integer idNumber;

    private LocalDate birthDate;

    private String firstName;

    private String lastName;

    private String email;


    public void setIdNumber( final Integer idNumber )
    {
        this.idNumber = idNumber;
    }


    public void setBirthDate( final LocalDate birthDate )
    {
        this.birthDate = birthDate;
    }


    public void setFirstName( final String firstName )
    {
        this.firstName = firstName;
    }


    public void setLastName( final String lastName )
    {
        this.lastName = lastName;
    }


    public void setEmail( final String email )
    {
        this.email = email;
    }


    public Integer getIdNumber()
    {
        return idNumber;
    }


    public LocalDate getBirthDate()
    {
        return birthDate;
    }


    public String getFirstName()
    {
        return firstName;
    }


    public String getLastName()
    {
        return lastName;
    }


    public String getEmail()
    {
        return email;
    }
}
