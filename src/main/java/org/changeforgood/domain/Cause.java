package org.changeforgood.domain;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cause")
public class Cause {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cause_id")
	private long causeID;
	
	@Column(name = "cause_name")
	private String causeName;
	
	@Column(name = "cause_website")
	private String causeWebsite;

	public long getCauseID() {
		return causeID;
	}

	public void setCauseID(long causeID) {
		this.causeID = causeID;
	}

	public String getCauseName() {
		return causeName;
	}

	public void setCauseName(String causeName) {
		this.causeName = causeName;
	}

	public String getCauseWebsite() {
		return causeWebsite;
	}

	public void setCauseWebsite(String causeWebsite) {
		this.causeWebsite = causeWebsite;
	}

	
	
	

}
