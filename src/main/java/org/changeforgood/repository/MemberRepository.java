package org.changeforgood.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.changeforgood.domain.Member;
import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long>{
	
	public List<Member> findAll();
	
	public Member findByMemberID(long id);

}//end of Interface
