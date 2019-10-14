package com.model;

import java.util.Date;

public class User {
    private Integer id;

    private String username;

    private String pasword;

    private Integer state;

    private Date regDate;

    private Integer roleId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasword() {
        return pasword;
    }

    public void setPasword(String pasword) {
        this.pasword = pasword;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
    

	/* （非 Javadoc）
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", pasword=" + pasword + ", state=" + state + ", regDate="
				+ regDate + ", roleId=" + roleId + "]";
	}

	public User() {
		super();
	}

	public User(String username, String pasword) {
		super();
		this.username = username;
		this.pasword = pasword;
	}
    
}