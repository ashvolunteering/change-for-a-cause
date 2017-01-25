package org.changeforgood.domain;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "member_activity")
public class MemberActivity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "member_activity_id")
	private long memberActivityID;
	
	@Column(name = "member_id")
	private long memberID;
	
	@Column(name = "activity_id")
	private long activityID;
	
	@Column(name = "value_per_unit")
	private int value;
	
	@Column(name = "comments")
	private String comments;

	public long getMemberActivityID() {
		return memberActivityID;
	}

	public void setMemberActivityID(long memberActivityID) {
		this.memberActivityID = memberActivityID;
	}

	public long getMemberID() {
		return memberID;
	}

	public void setMemberID(long memberID) {
		this.memberID = memberID;
	}

	public long getActivityID() {
		return activityID;
	}

	public void setActivityID(long activityID) {
		this.activityID = activityID;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}
	

}
