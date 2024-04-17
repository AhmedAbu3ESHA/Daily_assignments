
package com.example.entities;
import jakarta.persistence.*;

@Entity
@Table(name="instructor_details")
public class InstructorDetails {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private int id ;
	
	@Column(name = "yotube_channel")
	private String yotubeChannel ;
	
	@Column(name = "hoopy")
	private String  hoopy;
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getYotubeChannel() {
		return yotubeChannel;
	}

	public void setYotubeChannel(String yotubeChannel) {
		this.yotubeChannel = yotubeChannel;
	}

	public String getHoopy() {
		return hoopy;
	}

	public void setHoopy(String hoopy) {
		this.hoopy = hoopy;
	}

	public InstructorDetails(int id, String yotubeChannel, String hoopy) {
		super();
		
		this.yotubeChannel = yotubeChannel;
		this.hoopy = hoopy;
	}

	@Override
	public String toString() {
		return "InstructorDetails [id=" + id + ", yotubeChannel=" + yotubeChannel + ", hoopy=" + hoopy + ", getId()="
				+ getId() + ", getYotubeChannel()=" + getYotubeChannel() + ", getHoopy()=" + getHoopy()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	

}
