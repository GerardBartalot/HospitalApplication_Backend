package ProjectSpringBoot.HospitalApplication;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NurseRepository extends CrudRepository<Nurse, Integer> {
	Nurse findByUsernameAndPassword(String username, String password);
	Nurse findByName(String name);
	List<Nurse> findByNameContainingIgnoreCase(String name);
}
