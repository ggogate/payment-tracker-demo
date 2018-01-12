package com.syntel.apps.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "public", name = "users")
public class User {

	@Id
	@GeneratedValue
	@Column(name="id")
	private String id;
	@Column(name="password")
	private String password;
	@Column(name="role")
	private String role;
	@Column(name="merchantid")
	private String merchantid;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getMerchantid() {
		return merchantid;
	}
	public void setMerchantId(String merchantid) {
		this.merchantid = merchantid;
	}
}
