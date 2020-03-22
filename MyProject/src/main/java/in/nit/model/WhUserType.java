package in.nit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="whtab")
public class WhUserType {
	
	@Id
	@GeneratedValue
	@Column(name="wid")
	private Integer whId;
	
	@Column(name="utype")
	private String userType;
	@Column(name="ucode")
	private String userCode;
	
	//@Column(name="ufor")
	//private String userFor;
	
	@Column(name="email")
	private String userEmail;
	@Column(name="contact")
	private Integer userContact;
	@Column(name="uidtype")
	private String userIdType;
	
	@Column(name="uidothertype")
	private String userIdTypeOther;
	@Column(name="uidnumber")
	private Long userIdNumber;
	
	
	public Integer getWhId() {
		return whId;
	}
	public void setWhId(Integer whId) {
		this.whId = whId;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public Integer getUserContact() {
		return userContact;
	}
	public void setUserContact(Integer userContact) {
		this.userContact = userContact;
	}
	public String getUserIdType() {
		return userIdType;
	}
	public void setUserIdType(String userIdType) {
		this.userIdType = userIdType;
	}
	public String getUserIdTypeOther() {
		return userIdTypeOther;
	}
	public void setUserIdTypeOther(String userIdTypeOther) {
		this.userIdTypeOther = userIdTypeOther;
	}
	public Long getUserIdNumber() {
		return userIdNumber;
	}
	public void setUserIdNumber(Long userIdNumber) {
		this.userIdNumber = userIdNumber;
	}
	@Override
	public String toString() {
		return "WhUserType [whId=" + whId + ", userType=" + userType + ", userCode=" + userCode + ", userEmail="
				+ userEmail + ", userContact=" + userContact + ", userIdType=" + userIdType + ", userIdTypeOther="
				+ userIdTypeOther + ", userIdNumber=" + userIdNumber + "]";
	}
	public WhUserType() {
		super();
	}
	public WhUserType(Integer whId) {
		super();
		this.whId = whId;
	}
	
	
	
	

}
