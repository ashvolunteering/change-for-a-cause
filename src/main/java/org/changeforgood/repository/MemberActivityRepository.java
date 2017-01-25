package org.changeforgood.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.changeforgood.domain.MemberActivity;
import java.util.List;

public interface MemberActivityRepository extends JpaRepository<MemberActivity, Long>{
	public MemberActivity findByMemberActivityID(long id);
	
	public List<MemberActivity> findByMemberID(long id);
	
}
