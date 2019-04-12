/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author melissamoore
 */
@Entity
@Table(name = "StudentInfo")
public class StudentInfo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "age")
    private Integer age;

    @Column(name = "phone")
    private String phone;

    @Column(name = "pianolevel")
    private String pianolevel;

    public StudentInfo() {
    }

    public StudentInfo(Integer id) {
        this.id = id;
    }

    public StudentInfo(String firstname) {
        this.firstname = firstname;
    }

    public StudentInfo(Integer id, String firstname, String lastname, Integer age, String phone, String pianolevel) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.phone = phone;
        this.pianolevel = pianolevel;
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPianolevel() {
        return pianolevel;
    }

    public void setPianolevel(String pianolevel) {
        this.pianolevel = pianolevel;
    }

    @Override
    public String toString() {
        return "StudentInfo{" + "ID=" + id + ", firstname=" + firstname + ", lastname="
                + lastname + ", age=" + age + ", phone=" + phone + "pianolevel=" + pianolevel + '}';
    }
}
