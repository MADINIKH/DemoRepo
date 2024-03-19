package com.cg.jpastart.entities;



import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity //marks class as persistent entity.Obj of this class will be stored in database
@Table(name="students")  //specifies table name for entity.here table name is students
public class Student implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	@Id  //marks the primary key of the entity
	@GeneratedValue(strategy=GenerationType.AUTO)
	//Specifies the generation stratergy for the primary key.in this case its set to GenerationType.AUTO
	//which means the persistence provider chooses an appropriate strategy for underlying database
	private int studentId;
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	private String name;
	
	@OneToOne(cascade=CascadeType.ALL) 
	//defines onetoone relationship between entities.in this case,bw Student & Address
	//specifies that operations like persist,remove..should be cascaded to the associated entity 'Address' as well
	
	@JoinColumn(name="address_id")
	//specifies the join column for the relationship
	//it indicates the column in the 'Student' table that maps to primary key of associated 'Address' table
	
	private Address address;
	
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
