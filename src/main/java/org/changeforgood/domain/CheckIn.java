package org.changeforgood.domain;
import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
@Table(name = "check_in")
public class CheckIn {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "check_in_id")
	private long checkInID;
	
	@Column(name = "check_in_date")
	@JsonFormat(pattern="yyyy-MM-dd", timezone="UTC")
	private Date checkInDate;
	
	@Column(name = "check_in_units")
	private int checkInUnits;
	
	@Column(name = "check_in_comments")
	private String checkInComments;
	
	@Column(name = "check_in_pledge_id")
	private long checkInPledgeID;

	@Transient
	private int checkInValue;
	
	public long getCheckInID() {
		return checkInID;
	}

	public void setCheckInID(long checkInID) {
		this.checkInID = checkInID;
	}

	public Date getCheckInDate() {
		return checkInDate;
	}

	public void setCheckInDate(Date checkInDate) {
		this.checkInDate = checkInDate;
	}

	public int getCheckInUnits() {
		return checkInUnits;
	}

	public void setCheckInUnits(int checkInUnits) {
		this.checkInUnits = checkInUnits;
	}

	public String getCheckInComments() {
		return checkInComments;
	}

	public void setCheckInComments(String checkInComments) {
		this.checkInComments = checkInComments;
	}

	public long getCheckInPledgeID() {
		return checkInPledgeID;
	}

	public void setCheckInPledgeID(long checkInPledgeID) {
		this.checkInPledgeID = checkInPledgeID;
	}

	public int getCheckInValue() {
		return checkInValue;
	}

	public void setCheckInValue(int checkInValue) {
		this.checkInValue = checkInValue;
	}

	

	
	
}
