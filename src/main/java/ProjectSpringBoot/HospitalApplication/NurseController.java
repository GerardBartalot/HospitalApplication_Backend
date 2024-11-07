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

	@GetMapping("/index")
	public List<Nurse> getAll() {
		return nurseRepository.findAll();
	}

	@GetMapping("/name")
	public ResponseEntity<Nurse> findByName(@RequestParam String name) {
		Nurse nurse = nurseRepository.findByName(name);
		if (nurse.getName().equalsIgnoreCase(name)) {
			return ResponseEntity.ok(nurse); // 200
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); // 404
	}

	@PutMapping("/delete/{id}")
	public ResponseEntity<String> deleteNurse(@PathVariable int id) {
		Optional<Nurse> existingNurse = nurseRepository.findById(id);
		if (existingNurse.isPresent()) {
			this.nurseRepository.deleteById(id);
			return new ResponseEntity<>("Nurse deleted", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Id not found", HttpStatus.UNAUTHORIZED);
		}
	}
}
