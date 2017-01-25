package org.changeforgood.domain;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "member")
public class Member {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "member_id")
	private long memberID;
	
	@Column(name = "member_name")
	private String memberName;
	
	@Column(name = "member_facebook_id")
	private String memberFaceBookId;
	
	@Column(name = "member_email")
	private String memberEmail;
	
	@Column(name = "member_registered_date")
	@JsonFormat(pattern="yyyy-MM-dd hh:mm")
	private Date memberRegisteredDate;
	
	@Column(name = "member_last_active_date")
	@JsonFormat(pattern="yyyy-MM-dd hh:mm")
	private Date memberLastActiveDate;
	
	@Column(name = "member_currency")
	private String memberCurrency;

	public long getMemberID() {
		return memberID;
	}

	public void setMemberID(long memberID) {
		this.memberID = memberID;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberFaceBookId() {
		return memberFaceBookId;
	}

	public void setMemberFaceBookId(String memberFaceBookId) {
		this.memberFaceBookId = memberFaceBookId;
	}

	public String getMemberEmail() {
		return memberEmail;
	}

	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}

	public Date getMemberRegisteredDate() {
		return memberRegisteredDate;
	}

	public void setMemberRegisteredDate(Date memberRegisteredDate) {
		this.memberRegisteredDate = memberRegisteredDate;
	}

	public Date getMemberLastActiveDate() {
		return memberLastActiveDate;
	}

	public void setMemberLastActiveDate(Date memberLastActiveDate) {
		this.memberLastActiveDate = memberLastActiveDate;
	}

	public String getMemberCurrency() {
		return memberCurrency;
	}

	public void setMemberCurrency(String memberCurrency) {
		this.memberCurrency = memberCurrency;
	}
	
	

}
