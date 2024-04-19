package com.examples.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="course")
public class Course {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="title")
	private String title;
	
	@ManyToOne
	@JoinColumn(name = "instructor_id")
	private Instructor instructor;
	
	@ManyToMany(cascade = {
			CascadeType.DETACH,
			CascadeType.MERGE,
			CascadeType.PERSIST,
			CascadeType.REFRESH
	})
	@JoinTable(
		name="course_student"
	    ,joinColumns = @JoinColumn(name="course_id")
		,inverseJoinColumns = @JoinColumn(name="student_id")
	)
	private List<Student> students;
	
	public Course() {
		
	}

	public Course(String title) {
		this.title = title;
	}
	
	public void addStudent(Student st) {
		if(students == null) {
			students = new ArrayList<>();
		}
		
		students.add(st);
	}
	
	public Course(String title, Instructor instructor) {
		this.title = title;
		this.instructor = instructor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", title=" + title + ", instructor=" + instructor + "]";
	}
	
	
	

}
