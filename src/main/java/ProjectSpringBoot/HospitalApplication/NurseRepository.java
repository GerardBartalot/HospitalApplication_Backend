package ProjectSpringBoot.HospitalApplication;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NurseRepository extends CrudRepository<Nurse, Integer> {
    Nurse findByUsername(String username);
    Nurse findByName(String name);
    List<Nurse> findByNameContainingIgnoreCase(String name);
}
