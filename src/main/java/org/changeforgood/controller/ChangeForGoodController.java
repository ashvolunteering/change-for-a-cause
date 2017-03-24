package org.changeforgood.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.changeforgood.domain.*;
import org.changeforgood.service.*;

@CrossOrigin
@RestController
public class ChangeForGoodController {
	@Autowired
	ChangeForGoodService service;
	
	final static Logger logger = Logger.getLogger(ChangeForGoodController.class);
	
	//start of methods for Activity
	@RequestMapping(method = RequestMethod.POST, value ="/activity")
	public @ResponseBody ResponseEntity<?> processActivity(@RequestBody Activity activity)
	{
		Activity activityResponse = service.processActivity(activity);
		
		return ResponseEntity.status(HttpStatus.OK)
				.body(activityResponse);
		
	}
	
	@RequestMapping(method = RequestMethod.PUT, value ="/activity/{id}")
	public @ResponseBody ResponseEntity<?> updateActivity(@PathVariable("id") long id, @RequestBody Activity activity)
	{
		Activity activityResponse = service.processActivity(activity);
		
		return ResponseEntity.status(HttpStatus.OK)
				.body(activityResponse);
		
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value ="/activity/{id}")
	public @ResponseBody ResponseEntity<?> deleteActivity(@PathVariable("id") long id)
	{
		System.out.println("In Delete");
		Activity activity = service.findByActivityID(id);
		service.deleteActivity(activity);
		
		return ResponseEntity.status(HttpStatus.OK)
				.body("Activity Deleted");
		
	}
	
	@RequestMapping(method = RequestMethod.GET, value ="/activity")
	public @ResponseBody ResponseEntity<?> findAllActivities()
	{
		List<Activity> activityList = service.findAllActivities();
		
		return ResponseEntity.status(HttpStatus.OK)
				.body(activityList);
	}
	
	@RequestMapping(method = RequestMethod.GET, value ="/activity", params={"activityID"})
	public @ResponseBody ResponseEntity<?> findByActivityID(HttpServletRequest request, @RequestParam("activityID") String activityID)
	{
		long id = Integer.parseInt(activityID);
		Activity activity = service.findByActivityID(id);
		//To-do: Need to check for null object and return error instead of empty string?
		return ResponseEntity.status(HttpStatus.OK)
				.body(activity);
	}
	
	
	//end of methods for Activity
	
	//start methods for Cause
	@RequestMapping(method = RequestMethod.POST, value ="/cause")
	public @ResponseBody ResponseEntity<?> processCause(@RequestBody Cause cause)
	{
		Cause causeResponse = service.processCause(cause);
		
		return ResponseEntity.status(HttpStatus.OK)
				.body(causeResponse);
		
	}
	
	@RequestMapping(method = RequestMethod.GET, value ="/cause")
	public @ResponseBody ResponseEntity<?> findAllCauses()
	{
		List<Cause> causeList = service.findAllCauses();
		
		return ResponseEntity.status(HttpStatus.OK)
				.body(causeList);
	}
	
	@RequestMapping(method = RequestMethod.GET, value ="/cause", params={"causeID"})
	public @ResponseBody ResponseEntity<?> findByCauseID(HttpServletRequest request, @RequestParam("causeID") String causeID)
	{
		long id = Integer.parseInt(causeID);
		Cause cause = service.findByCauseID(id);
		//To-do: Need to check for null object and return error instead of empty string?
		return ResponseEntity.status(HttpStatus.OK)
				.body(cause);
	}
	
	//end of methods for Cause
	
	//start methods for Member
		@RequestMapping(method = RequestMethod.POST, value ="/member")
		public @ResponseBody ResponseEntity<?> processMember(@RequestBody Member member)
		{
			Member memberResponse = service.processMember(member);
			
			return ResponseEntity.status(HttpStatus.OK)
					.body(memberResponse);
			
		}
		
		@RequestMapping(method = RequestMethod.GET, value ="/member")
		public @ResponseBody ResponseEntity<?> findAllMembers()
		{
			List<Member> memberList = service.findAllMembers();
			
			return ResponseEntity.status(HttpStatus.OK)
					.body(memberList);
		}
		
		@RequestMapping(method = RequestMethod.GET, value ="/member", params={"memberID"})
		public @ResponseBody ResponseEntity<?> findByMemberID(HttpServletRequest request, @RequestParam("memberID") String memberID)
		{
			long id = Integer.parseInt(memberID);
			Member member = service.findByMemberID(id);
			//To-do: Need to check for null object and return error instead of empty string?
			return ResponseEntity.status(HttpStatus.OK)
					.body(member);
		}
		
		//end of methods for Member
		
		//start methods for MemberActivity
				@RequestMapping(method = RequestMethod.POST, value ="/member-activity")
				public @ResponseBody ResponseEntity<?> processMemberActivity(@RequestBody MemberActivity memberActivity)
				{
					MemberActivity memberActivityResponse = service.processMemberActivity(memberActivity);
					
					return ResponseEntity.status(HttpStatus.OK)
							.body(memberActivityResponse);
					
				}
				
				@RequestMapping(method = RequestMethod.GET, value ="/member-activity")
				public @ResponseBody ResponseEntity<?> findAllMemberActivities()
				{
					List<MemberActivity> memberActivityList = service.findAllMemberActivities();
					
					return ResponseEntity.status(HttpStatus.OK)
							.body(memberActivityList);
				}
				
				@RequestMapping(method = RequestMethod.GET, value ="/member-activity", params={"memberActivityID"})
				public @ResponseBody ResponseEntity<?> findByMemberActivityID(HttpServletRequest request, @RequestParam("memberActivityID") String memberActivityID)
				{
					long id = Integer.parseInt(memberActivityID);
					MemberActivity memberActivity = service.findByMemberActivityID(id);
					//To-do: Need to check for null object and return error instead of empty string?
					return ResponseEntity.status(HttpStatus.OK)
							.body(memberActivity);
				}
				
				@RequestMapping(method = RequestMethod.GET, value ="/member-activity", params={"memberID"})
				public @ResponseBody ResponseEntity<?> findActivitiesForMember(HttpServletRequest request, @RequestParam("memberID") String memberID)
				{
					long id = Integer.parseInt(memberID);
					List<MemberActivity> memberActivitiesList = service.findActivitiesForMember(id);
					
					//To-do: Need to check for null object and return error instead of empty string?
					return ResponseEntity.status(HttpStatus.OK)
							.body(memberActivitiesList);
				}
				//end of methods for MemberActivity
				
				//start methods for Pledge
				@RequestMapping(method = RequestMethod.POST, value ="/pledge")
				public @ResponseBody ResponseEntity<?> processMember(@RequestBody Pledge pledge)
				{
					Pledge pledgeResponse = service.processPledge(pledge);
					
					return ResponseEntity.status(HttpStatus.OK)
							.body(pledgeResponse);
					
				}
				
				@RequestMapping(method = RequestMethod.GET, value ="/pledge")
				public @ResponseBody ResponseEntity<?> findAllPledges()
				{
					List<Pledge> pledgeList = service.findAllPledges();
					logger.info(pledgeList.get(0).getPledgeStartDate());
					logger.info(pledgeList.get(0).getPledgeEndDate());
					return ResponseEntity.status(HttpStatus.OK)
							.body(pledgeList);
				}
				
				@RequestMapping(method = RequestMethod.GET, value ="/pledge", params={"pledgeID"})
				public @ResponseBody ResponseEntity<?> findByPledgeID(HttpServletRequest request, @RequestParam("pledgeID") String pledgeID)
				{
					long id = Integer.parseInt(pledgeID);
					Pledge pledge = service.findByPledgeID(id);
					//To-do: Need to check for null object and return error instead of empty string?
					return ResponseEntity.status(HttpStatus.OK)
							.body(pledge);
				}
				
				//end of methods for Pledge
				
				//start methods for CheckIn
				@RequestMapping(method = RequestMethod.POST, value ="/checkIn")
				public @ResponseBody ResponseEntity<?> processMember(@RequestBody CheckIn checkIn)
				{
					CheckIn checkInResponse = service.processCheckIn(checkIn);
					
					return ResponseEntity.status(HttpStatus.OK)
							.body(checkInResponse);
					
				}
				
				@RequestMapping(method = RequestMethod.GET, value ="/checkIn")
				public @ResponseBody ResponseEntity<?> findAllCheckIns()
				{
					List<CheckIn> checkInList = service.findAllCheckIns();
					
					return ResponseEntity.status(HttpStatus.OK)
							.body(checkInList);
				}
				
				@RequestMapping(method = RequestMethod.GET, value ="/checkIn", params={"checkInID"})
				public @ResponseBody ResponseEntity<?> findByCheckInID(HttpServletRequest request, @RequestParam("checkInID") String checkInID)
				{
					long id = Integer.parseInt(checkInID);
					CheckIn checkIn = service.findByCheckInID(id);
					//To-do: Need to check for null object and return error instead of empty string?
					return ResponseEntity.status(HttpStatus.OK)
							.body(checkIn);
				}
				
				@RequestMapping(method = RequestMethod.GET, value ="/checkIn", params={"pledgeID"})
				public @ResponseBody ResponseEntity<?> findCheckInsByPledgeID(HttpServletRequest request, @RequestParam("pledgeID") String pledgeID)
				{
					//tbd: need to make sure we get long and not int
					long id = Integer.parseInt(pledgeID);
					List<CheckIn> checkInsByPledge = service.findAllCheckInsForPledge(id);
					//To-do: Need to check for null object and return error instead of empty string?
					return ResponseEntity.status(HttpStatus.OK)
							.body(checkInsByPledge);
				}
				//end of methods for Pledge
				
				//start of MemberInfo methods
				@RequestMapping(method = RequestMethod.GET, value ="/member-info", params={"memberID"})
				public @ResponseBody ResponseEntity<?> loadMemberInfo(HttpServletRequest request, @RequestParam("memberID") String memberID)
				{
					long id = Integer.parseInt(memberID);
					MemberInfo memberInfo = service.loadMemberInfo(id);
					
					//To-do: Need to check for null object and return error instead of empty string?
					return ResponseEntity.status(HttpStatus.OK)
							.body(memberInfo);
				}

				
				//end of MemberInfo methods
				
}
