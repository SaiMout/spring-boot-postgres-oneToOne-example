package com.springboot.jpa.hibernate.dto;

//@Setter
//@Getter
//@AllArgsConstructor
//@NoArgsConstructor
public class EmployeeDto {
	public EmployeeDto() {
		super();
	}

	public EmployeeDto(Long id, String name, String role, String department, Long mmnrcId) {
		super();
		this.id = id;
		this.name = name;
		this.role = role;
		this.department = department;
		this.mmnrcId = mmnrcId;
	}

	private Long id;
    private String name;
    private String role;
    private String department;
    private Long mmnrcId;

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Long getMmnrcId() {
        return mmnrcId;
    }

    public void setMmnrcId(Long mmnrcId) {
        this.mmnrcId = mmnrcId;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	 
}

