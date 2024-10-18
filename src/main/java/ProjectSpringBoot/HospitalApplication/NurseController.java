package ProjectSpringBoot.HospitalApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

	@GetMapping("/find")
	public ResponseEntity<Nurse> findByName(@RequestParam String name) {
		Nurse nurse = nurseRepository.findByName(name);
			if (nurse.getName().equalsIgnoreCase(name)) {
				return ResponseEntity.ok(nurse); // 200
			}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); // 404
	}

}