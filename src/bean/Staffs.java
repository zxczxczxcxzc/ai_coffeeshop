package bean;
import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name = "staffs")
public class Staffs implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String fullname;
	private String email;
	private String gender;
	private String dateOfBirth;
	private String phone;

	public Staffs() {
		super();
	}

	public Staffs(String id, String fullname, String email, String gender, String dateOfBirth, String phone) {
		super();
		this.id = id;
		this.fullname = fullname;
		this.email = email;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.phone = phone;
	}

	public String getId() {
		return id;
	}
	@XmlElement
	public void setId(String id) {
		this.id = id;
	}

	public String getFullname() {
		return fullname;
	}
	@XmlElement
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getEmail() {
		return email;
	}
	@XmlElement
	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}
	@XmlElement
	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}
	@XmlElement
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getPhone() {
		return phone;
	}
	@XmlElement
	public void setPhone(String phone) {
		this.phone = phone;
	}

}
