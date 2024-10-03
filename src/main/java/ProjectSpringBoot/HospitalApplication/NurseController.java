package ProjectSpringBoot.HospitalApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
class NurseController {

    private List<Nurse> nurses = new ArrayList<>();

    @Autowired
    public NurseController() {
        nurses.add(new Nurse("Juan Pérez", "juan.perez", "pass1"));
        nurses.add(new Nurse("Maria Lopez", "maria.lopez", "pass2"));
        nurses.add(new Nurse("Antonio Garrido", "antonio.garrido", "pass3"));
        nurses.add(new Nurse("Carlos Gonzalez", "carlos.gonzalez", "pass4"));
        nurses.add(new Nurse("Sandra Castillo", "sandra.castillo", "pass5"));
    }

    @PostMapping("/nurse/login")
    public @ResponseBody ResponseEntity<Boolean> login(@RequestBody Nurse inputNurse) {
        for (Nurse nurse : nurses) {
        	System.out.println(nurse);
            if (inputNurse.getUsername().equals(nurse.getUsername()) && inputNurse.getPassword().equals(nurse.getPassword())) {
                return ResponseEntity.ok(true);
            }
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(false);
    }
}
