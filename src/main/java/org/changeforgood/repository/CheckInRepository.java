package org.changeforgood.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.changeforgood.domain.CheckIn;


import java.util.List;

public interface CheckInRepository extends JpaRepository<CheckIn, Long>{
	public CheckIn findByCheckInID(long checkInID);
	
	public List<CheckIn> findByCheckInPledgeID(long pledgeID);
}
