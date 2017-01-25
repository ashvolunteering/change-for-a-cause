package org.changeforgood.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.changeforgood.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;



public class MemberInfo {
	@Autowired
	ActivityRepository activityRepository;
	
	private Member member;
	
	private List<Activity> memberActivities;
	
	private List<Pledge> pledges;
	

	public List<Activity> getMemberActivities() {
		return memberActivities;
	}

	public void setMemberActivities(List<Activity> memberActivities) {
		this.memberActivities = memberActivities;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}
	
	public MemberInfo(Member member)
	{
		this.setMember(member);
	}
	
	public MemberInfo(Member member, List<Activity> memberActivities)
	{
		this.setMember(member);
		this.setMemberActivities(memberActivities);
	}

	public MemberInfo(Member member, List<Activity> memberActivities, List<Pledge> pledges)
	{
		this.setMember(member);
		this.setMemberActivities(memberActivities);
		this.setPledges(pledges);
	}
	
	public List<Pledge> getPledges() {
		return pledges;
	}

	public void setPledges(List<Pledge> pledges) {
		this.pledges = pledges;
	}
	
	
}
