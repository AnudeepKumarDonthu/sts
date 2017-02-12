package spring.rest.model;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Employee {

    private String id;
    private String name;
    private String address;

    public Employee() {

    }

    public Employee(String name, String address) {
	this.name = name;
	this.address = address;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getAddress() {
	return address;
    }

    public void setAddress(String address) {
	this.address = address;
    }

    public String getId() {
	return id;
    }

    public void setId(String id) {
	this.id = id;
    }

    @Override
    public String toString() {
	return "Employee [id=" + id + ", name=" + name + ", address=" + address + "]";
    }

}