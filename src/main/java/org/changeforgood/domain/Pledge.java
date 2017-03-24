package org.changeforgood.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "Pledge")
public class Pledge {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "pledge_id")
	private long pledgeID;
	
	@Column(name = "pledge_name")
	private String pledgeName;
	
	@Column(name = "pledge_member_activity_id")
	private int pledgeMemberActivityId;
	
	@Column(name = "pledge_cause_id")
	private int pledgeCauseId;
	
	@Column(name = "pledge_start_date")
	@JsonFormat(pattern="yyyy-MM-dd", timezone="UTC")
	//@Type(type="org.jadira.usertype.dateandtime.legacyjdk.PersistentDate")
	private Date pledgeStartDate;
	
	@Column(name = "pledge_end_date")
	@JsonFormat(pattern="yyyy-MM-dd", timezone="UTC")
	//@Type(type="org.jadira.usertype.dateandtime.legacyjdk.PersistentDate")
	private Date pledgeEndDate;
	
	@Column(name = "pledge_units")
	private int pledgeUnits;
	
	@Column(name = "pledge_comments")
	private String pledgeComments;
	
	@Transient
	private Activity activity;
	
	@Transient
	private boolean active;
	
	@Transient
	private String causeName;
	
	@Transient
	private int completedUnits = 0;
	
	@Transient
	private int earnedValue = 0;
	
	@Transient
	private List<CheckIn> checkInsForPledge;
	
	public long getPledgeID() {
		return pledgeID;
	}

	public void setPledgeID(long pledgeID) {
		this.pledgeID = pledgeID;
	}

	public String getPledgeName() {
		return pledgeName;
	}

	public void setPledgeName(String pledgeName) {
		this.pledgeName = pledgeName;
	}

	public int getPledgeMemberActivityId() {
		return pledgeMemberActivityId;
	}

	public void setPledgeMemberActivityId(int pledgeMemberActivityId) {
		this.pledgeMemberActivityId = pledgeMemberActivityId;
	}

	public int getPledgeCauseId() {
		return pledgeCauseId;
	}

	public void setPledgeCauseId(int pledgeCauseId) {
		this.pledgeCauseId = pledgeCauseId;
	}

	public Date getPledgeStartDate() {
		return pledgeStartDate;
	}

	public void setPledgeStartDate(Date pledgeStartDate) {
		this.pledgeStartDate = pledgeStartDate;
	}

	public Date getPledgeEndDate() {
		return pledgeEndDate;
	}

	public void setPledgeEndDate(Date pledgeEndDate) {
		this.pledgeEndDate = pledgeEndDate;
	}

	public int getPledgeUnits() {
		return pledgeUnits;
	}

	public void setPledgeUnits(int pledgeUnits) {
		this.pledgeUnits = pledgeUnits;
	}

	public String getPledgeComments() {
		return pledgeComments;
	}

	public void setPledgeComments(String pledgeComments) {
		this.pledgeComments = pledgeComments;
	}

	public Activity getActivity() {
		return activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public List<CheckIn> getCheckInsForPledge() {
		return checkInsForPledge;
	}

	public void setCheckInsForPledge(List<CheckIn> checkInsForPledge) {
		this.checkInsForPledge = checkInsForPledge;
	}

	public String getCauseName() {
		return causeName;
	}

	public void setCauseName(String causeName) {
		this.causeName = causeName;
	}

	public int getEarnedValue() {
		return earnedValue;
	}

	public void setEarnedValue(int earnedValue) {
		this.earnedValue = earnedValue;
	}

	public int getCompletedUnits() {
		return completedUnits;
	}

	public void setCompletedUnits(int completedUnits) {
		this.completedUnits = completedUnits;
	}
	
}
