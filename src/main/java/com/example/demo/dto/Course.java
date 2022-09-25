package com.example.demo.dto;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "course")
public class Course {

	
//	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Id
	@Column(name = "cid")
	private int cid;
	private String name;
	
	@Transient
	private boolean isselected;
	// @ManyToMany(targetEntity = StudentRes.class ,mappedBy = "courseres")
	// private List<StudentRes> stud;

}
