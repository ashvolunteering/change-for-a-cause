package org.changeforgood.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.changeforgood.domain.*;
import java.util.List;


public interface ActivityRepository extends JpaRepository<Activity, Long> {
	public List<Activity> findAll();
	
	public Activity findByActivityID(long id);
}
	
	






