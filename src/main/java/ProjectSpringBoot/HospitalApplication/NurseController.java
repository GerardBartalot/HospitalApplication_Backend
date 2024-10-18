package ProjectSpringBoot.HospitalApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/nurse")
public class NurseController {

    @Autowired
    private NurseRepository nurseRepository;

    @PostMapping("/login")
    public ResponseEntity<String> validateLogin(@RequestParam String username, @RequestParam String password) {
        Nurse nurse = nurseRepository.findByUsername(username);
        if (nurse != null && nurse.getPassword().equals(password)) {
            return new ResponseEntity<>("Login Successful", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Invalid username or password", HttpStatus.UNAUTHORIZED);
        }
    }

	public ResponseEntity<Nurse> findByName(String nurseName) {
		return null;
	}

	public List<Nurse> getAll() {
		return null;
	}

    
}