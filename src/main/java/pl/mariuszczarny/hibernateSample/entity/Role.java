/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.mariuszczarny.hibernateSample.entity;

import java.io.Serializable;
import java.util.List;


/**
 *
 * @author mariusz
 */
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer iduser;
    private String rolename;
    private int isActive;
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
