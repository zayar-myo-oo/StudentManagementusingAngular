package com.example.demo.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "student")
public class Student {

//	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Id
	@Column(name = "sid")
	private int id;
	private String name;
	private String dob;
	private String gender;
	private String phone;
	private String education;

	@Transient
	private String course;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "coursedetail", joinColumns = {
			@JoinColumn(referencedColumnName = "sid", name = "studentid")
	}, inverseJoinColumns = {
			@JoinColumn(referencedColumnName = "cid", name = "courseid")
	})
	private List<Course> courseres;

}