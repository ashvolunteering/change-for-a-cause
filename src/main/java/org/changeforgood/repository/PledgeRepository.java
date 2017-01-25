package org.changeforgood.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.changeforgood.domain.*;
import java.util.List;

public interface PledgeRepository extends JpaRepository<Pledge, Long> {
	public Pledge findByPledgeID(long id);
	
	public List<Pledge> findByPledgeMemberActivityId(int id);

}
