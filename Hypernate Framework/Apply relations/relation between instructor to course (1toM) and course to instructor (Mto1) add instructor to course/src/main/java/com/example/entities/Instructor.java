package com.example.entities;

import java.util.List;

import jakarta.persistence.*;
@Entity
@Table(name="instructor")
public class Instructor {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    private String email;
    
    @OneToOne(cascade={CascadeType.ALL},fetch= FetchType.LAZY)
   // @OneToOne(cascade={CascadeType.ALL},fetch= FetchType.LAZY)
    @JoinColumn(name="instructor_detail_id")
    private InstructorDetails details;

    @OneToMany(mappedBy="instructor",cascade={CascadeType.PERSIST})
    private List<Course> courses;
    
    
    public Instructor(String firstName, String lastName, String email, InstructorDetails details,
			List<Course> courses) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.details = details;
		this.courses = courses;
	}



	public List<Course> getCourses() {
		return courses;
	}



	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}



	public Instructor() {
    }
    
   


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public InstructorDetails getDetails() {
		return details;
	}

	public void setDetails(InstructorDetails details) {
		this.details = details;
	}
	
	public void addCourse(Course e) {
		courses.add(e);
	}

    @Override
	public String toString() {
		return "Instructor [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", details=" + details + "]";
	}

}
