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

    @GetMapping("/getAll")
    public List<Nurse> getAll() {
        return nurseRepository.findAll();
    }
  
  
    @GetMapping("/findByName")
    public ResponseEntity<Nurse> findByName(@RequestParam String name) {
        for (Nurse nurse : nurseList) {
            if (nurse.getName().equalsIgnoreCase(name)) {
                return ResponseEntity.ok(nurse); 
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); 
    }

    
}