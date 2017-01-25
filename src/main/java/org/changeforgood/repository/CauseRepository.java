package org.changeforgood.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.changeforgood.domain.Cause;
import java.util.List;

public interface CauseRepository extends JpaRepository<Cause, Long> {
	public List<Cause> findAll();
	
	public Cause findByCauseID(long id);
}