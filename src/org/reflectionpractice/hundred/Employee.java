package org.reflectionpractice.hundred;

import java.util.Objects;

public class Employee {

	private String name;
	private String companyName;
	private int id;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(String name, String companyName, int id) {
		super();
		this.name = name;
		this.companyName = companyName;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(companyName, id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(companyName, other.companyName) && id == other.id && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", companyName=" + companyName + ", id=" + id + "]";
	}

}
