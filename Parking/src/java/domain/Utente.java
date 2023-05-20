/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author stefa
 */
@Entity
@XmlRootElement
public class Utente implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String mail;
    private String name;
    private String surname;
    @Temporal(TemporalType.DATE)
    private Date birthDate;

    public Utente() {
    }

    public Utente(String username, String password, String mail, String name, String surname, Date birthDate) {
        this.username = username;
        this.password = password;
        this.mail = mail;
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
    }

    public String getUser() {
        return username;
    }

    public void setUser(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
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

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
    
}
