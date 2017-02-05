/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.mariuszczarny.hibernateSample.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 *
 * @author mariusz
 */
@Entity
@Table(name = "role")
@NamedQueries({
    @NamedQuery(name = "Role.findAll", query = "SELECT r FROM Role r")
    , @NamedQuery(name = "Role.findByIduser", query = "SELECT r FROM Role r WHERE r.iduser = :iduser")
    , @NamedQuery(name = "Role.findByRolename", query = "SELECT r FROM Role r WHERE r.rolename = :rolename")
    , @NamedQuery(name = "Role.findByIsActive", query = "SELECT r FROM Role r WHERE r.isActive = :isActive")})
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iduser")
    private Integer iduser;
    @Basic(optional = false)
    @Column(name = "rolename")
    private String rolename;
    @Basic(optional = false)
    @Column(name = "is_active")
    private int isActive;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "roleIduser", fetch = FetchType.EAGER)
    private List<MyUser> myUserList;

    public Role() {
    }

    public Role(Integer iduser) {
        this.iduser = iduser;
    }

    public Role(Integer iduser, String rolename, int isActive) {
        this.iduser = iduser;
        this.rolename = rolename;
        this.isActive = isActive;
    }

    public Integer getIduser() {
        return iduser;
    }

    public void setIduser(Integer iduser) {
        this.iduser = iduser;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public int getIsActive() {
        return isActive;
    }

    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }

    public List<MyUser> getMyUserList() {
        return myUserList;
    }

    public void setMyUserList(List<MyUser> myUserList) {
        this.myUserList = myUserList;
    }

    @Override
    public String toString() {
        return "db.Role[ iduser=" + iduser + " ]";
    }
    
}
