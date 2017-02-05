/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.mariuszczarny.hibernateSample.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author mariusz
 */
@Entity
@Table(name = "my_user")
@NamedQueries({
    @NamedQuery(name = "MyUser.findAll", query = "SELECT m FROM MyUser m")
    , @NamedQuery(name = "MyUser.findByIduser", query = "SELECT m FROM MyUser m WHERE m.iduser = :iduser")
    , @NamedQuery(name = "MyUser.findByFirstname", query = "SELECT m FROM MyUser m WHERE m.firstname = :firstname")
    , @NamedQuery(name = "MyUser.findByLastname", query = "SELECT m FROM MyUser m WHERE m.lastname = :lastname")
    , @NamedQuery(name = "MyUser.findBySalary", query = "SELECT m FROM MyUser m WHERE m.salary = :salary")
    , @NamedQuery(name = "MyUser.findByAddress", query = "SELECT m FROM MyUser m WHERE m.address = :address")})
public class MyUser implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iduser")
    private Integer iduser;
    @Column(name = "firstname")
    private String firstname;
    @Column(name = "lastname")
    private String lastname;
    @Column(name = "salary")
    private Integer salary;
    @Column(name = "address")
    private String address;
    @JoinColumn(name = "role_iduser", referencedColumnName = "iduser")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Role roleIduser;

    public MyUser() {
    }

    public MyUser(Integer iduser) {
        this.iduser = iduser;
    }

    public Integer getIduser() {
        return iduser;
    }

    public void setIduser(Integer iduser) {
        this.iduser = iduser;
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

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Role getRoleIduser() {
        return roleIduser;
    }

    public void setRoleIduser(Role roleIduser) {
        this.roleIduser = roleIduser;
    }

    @Override
    public String toString() {
        return "db.MyUser[ iduser=" + iduser + " ]";
    }
    
}
