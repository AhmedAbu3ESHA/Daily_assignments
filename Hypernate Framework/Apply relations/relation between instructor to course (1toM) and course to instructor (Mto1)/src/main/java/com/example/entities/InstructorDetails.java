
package com.example.entities;
import jakarta.persistence.*;

@Entity
@Table(name="instructor_detail")
public class InstructorDetails {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private int id ;
	
	@Column(name = "youtube_channel")
	private String youtubeChannel ;
	
	@Column(name = "hobby")
	private String  hobby;
	
	@OneToOne(mappedBy="details")
	private Instructor instructor;

	public Instructor getInstructor() {
		return instructor;
	}


	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}


	public InstructorDetails(String youtubeChannel, String hobby, Instructor instructor) {
		super();
		this.youtubeChannel = youtubeChannel;
		this.hobby = hobby;
		this.instructor = instructor;
	}


	public InstructorDetails() {
	
	}


	public String getYoutubeChannel() {
		return youtubeChannel;
	}

	public void setYoutubeChannel(String youtubeChannel) {
		this.youtubeChannel = youtubeChannel;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}


	@Override
	public String toString() {
		return "InstructorDetails [id=" + id + ", youtubeChannel=" + youtubeChannel + ", hobby=" + hobby + "]";
	}




}
