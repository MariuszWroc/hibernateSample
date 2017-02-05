/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.mariuszczarny.hibernateSample.entity;

import java.io.Serializable;

/**
 *
 * @author mariusz
 */
public class MyUser implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer iduser;
	private String firstname;
	private String lastname;
	private Integer salary;
	private String address;
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
