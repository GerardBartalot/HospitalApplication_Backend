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
		return (List<Nurse>) nurseRepository.findAll();
	}

	@GetMapping("/name/{name}")
	public ResponseEntity<Nurse> findByName(@PathVariable String name) {
		Nurse nurse = nurseRepository.findByName(name);
		if (nurse.getName().equalsIgnoreCase(name)) {
			return ResponseEntity.ok(nurse); // 200
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); // 404
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<String> updateNurse(@PathVariable int id, @RequestBody Nurse updatedNurse) {
		Optional<Nurse> existingNurse = nurseRepository.findById(id);

		if (existingNurse.isPresent()) {
			Nurse nurse = existingNurse.get();

			if (updatedNurse.getName() != null) {
				nurse.setName(updatedNurse.getName());
			}
			if (updatedNurse.getUsername() != null) {
				nurse.setUsername(updatedNurse.getUsername());
			}
			if (updatedNurse.getPassword() != null) {
				nurse.setPassword(updatedNurse.getPassword());
			}

			nurseRepository.save(nurse);
			return new ResponseEntity<>("Nurse updated successfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Nurse not found", HttpStatus.NOT_FOUND);
		}

	}
}