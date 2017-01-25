package org.changeforgood.service;

import org.changeforgood.domain.*;
import org.changeforgood.repository.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service
public class ChangeForGoodService {
@Autowired
ActivityRepository activityRepository;

@Autowired
CauseRepository causeRepository;

@Autowired
MemberRepository memberRepository;

@Autowired
MemberActivityRepository memberActivityRepository;

@Autowired
PledgeRepository pledgeRepository;

@Autowired
CheckInRepository checkInRepository;

//start of Activity Services
public Activity processActivity(Activity activity)
{
	if (!validateActivity(activity))
		return activity;
	
	return saveActivity(activity);
}

public List<Activity> findAllActivities()
{
	return activityRepository.findAll();
}

public Activity findByActivityID(long activityID)
{
	return activityRepository.findByActivityID(activityID);
}

public boolean validateActivity(Activity activity)
{
	//To-do: placeholder for future edits
	return true;
}

public Activity saveActivity(Activity activity)
{
	return activityRepository.saveAndFlush(activity);
}

public void deleteActivity(Activity activity)
{
	activityRepository.delete(activity);
}
//end of Activity Services


//Start of Cause Services
public Cause processCause(Cause cause)
{
	if (!validateCause(cause))
		return cause;
	
	return saveCause(cause);
}

public List<Cause> findAllCauses()
{
	return causeRepository.findAll();
}

public Cause findByCauseID(long causeID)
{
	return causeRepository.findByCauseID(causeID);
}

public boolean validateCause(Cause cause)
{
	//To-do: placeholder for future edits
	return true;
}

public Cause saveCause(Cause cause)
{
	return causeRepository.saveAndFlush(cause);
}
//End of Cause Services

//Start of Member Services
public Member processMember(Member member)
{
	if (!validateMember(member))
		return member;
	
	return saveMember(member);
}

public List<Member> findAllMembers()
{
	return memberRepository.findAll();
}

public Member findByMemberID(long memberID)
{
	return memberRepository.findByMemberID(memberID);
}

public boolean validateMember(Member member)
{
	//To-do: placeholder for future edits
	return true;
}

public Member saveMember(Member member)
{
	return memberRepository.saveAndFlush(member);
}
//end of Member services

//Start of MemberActivity Services
public MemberActivity processMemberActivity(MemberActivity memberActivity)
{
	if (!validateMemberActivity(memberActivity))
		return memberActivity;
	
	return saveMemberActivity(memberActivity);
}

public List<MemberActivity> findAllMemberActivities()
{
	return memberActivityRepository.findAll();
}

public MemberActivity findByMemberActivityID(long memberActivityID)
{
	return memberActivityRepository.findByMemberActivityID(memberActivityID);
}

public List<MemberActivity> findActivitiesForMember(long memberID)
{
	return memberActivityRepository.findByMemberID(memberID);
}

public boolean validateMemberActivity(MemberActivity memberActivity)
{
	//To-do: placeholder for future edits
	return true;
}

public MemberActivity saveMemberActivity(MemberActivity memberActivity)
{
	return memberActivityRepository.saveAndFlush(memberActivity);
}
//end of MemberActivity services

//Start of Pledge Services
public Pledge processPledge(Pledge pledge)
{
	if (!validatePledge(pledge))
		return pledge;
	
	return savePledge(pledge);
}

public List<Pledge> findAllPledges()
{
	return pledgeRepository.findAll();
}

public Pledge findByPledgeID(long pledgeID)
{
	return pledgeRepository.findByPledgeID(pledgeID);
}

public boolean validatePledge(Pledge pledge)
{
	//To-do: placeholder for future edits
	return true;
}

public Pledge savePledge(Pledge pledge)
{
	return pledgeRepository.saveAndFlush(pledge);
}
//end of Pledge services

//Start of CheckIn Services
public CheckIn processCheckIn(CheckIn checkIn)
{
	if (!validateCheckIn(checkIn))
		return checkIn;
	
	return saveCheckIn(checkIn);
}

public List<CheckIn> findAllCheckIns()
{
	return checkInRepository.findAll();
}

public List<CheckIn> findAllCheckInsForPledge(long pledgeID)
{
	return checkInRepository.findByCheckInPledgeID(pledgeID);
}

public CheckIn findByCheckInID(long checkInID)
{
	return checkInRepository.findByCheckInID(checkInID);
}

public boolean validateCheckIn(CheckIn checkIn)
{
	//To-do: placeholder for future edits
	return true;
}

public CheckIn saveCheckIn(CheckIn checkIn)
{
	return checkInRepository.saveAndFlush(checkIn);
}
//end of CheckIn services

//start of MemberInfo methods
public MemberInfo loadMemberInfo(long memberID)
{
	Member member = memberRepository.findByMemberID(memberID);
	
	List<MemberActivity> memberActivityList = memberActivityRepository.findByMemberID(memberID);
	List<Activity> memberActivities = new ArrayList<Activity>();
	List<Pledge> allPledges = new ArrayList<Pledge>();
	
	Iterator<MemberActivity> iterator = memberActivityList.iterator();
	
	while (iterator.hasNext())
	{
		MemberActivity memberActivity = iterator.next();
		Activity activity = activityRepository.findByActivityID(memberActivity.getActivityID());
		activity.setValue(memberActivity.getValue());
		memberActivities.add(activity);
		int id = (int)memberActivity.getMemberActivityID();
		List<Pledge> pledges = pledgeRepository.findByPledgeMemberActivityId(id);
		Iterator<Pledge> pledgeIterator = pledges.iterator();
		
		while (pledgeIterator.hasNext())
		{
			Pledge pledge = pledgeIterator.next();
			pledge.setActivity(activity);
			
			Date today = new Date();
			
			if (pledge.getPledgeEndDate().compareTo(today) < 0)
			{
				pledge.setActive(false);
			}
			else
			{
				pledge.setActive(true);
			}
			
			Cause cause = causeRepository.findByCauseID(pledge.getPledgeCauseId());
			pledge.setCauseName(cause.getCauseName());
			
			List<CheckIn> checkInsForPledge = checkInRepository.findByCheckInPledgeID(pledge.getPledgeID());
			
			Iterator<CheckIn> checkInIterator = checkInsForPledge.iterator();
			int earnedValue = 0;
			int completedUnits = 0;
			while (checkInIterator.hasNext())
			{
				CheckIn checkIn = checkInIterator.next();
				int checkInValue = memberActivity.getValue() * checkIn.getCheckInUnits();
				checkIn.setCheckInValue(checkInValue);
				earnedValue += checkInValue;
				completedUnits += checkIn.getCheckInUnits();
				
			}
			pledge.setCheckInsForPledge(checkInsForPledge);
			pledge.setEarnedValue(earnedValue);
			pledge.setCompletedUnits(completedUnits);
		}
		
		allPledges.addAll(pledges);
		
		
	}
	
	
	return new MemberInfo(member, memberActivities, allPledges);
}
//end of MemberInfor methods
}//end of class