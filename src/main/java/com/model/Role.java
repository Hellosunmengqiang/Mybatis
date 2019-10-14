package com.model;

public class Role {
    private Integer id;

    private String roleName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

	/* （非 Javadoc）
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Role [id=" + id + ", roleName=" + roleName + "]";
	}
    
}