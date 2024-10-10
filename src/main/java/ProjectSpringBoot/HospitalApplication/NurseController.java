package ProjectSpringBoot.HospitalApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/nurse")
public class NurseController {
    private List<Nurse> nurseList;

    public NurseController() {
        this.nurseList = new ArrayList<>();
        completeList();
    }

    private void completeList() {
        nurseList.add(new Nurse("Nil", "nilarroyo43", "contraseña0"));
        nurseList.add(new Nurse("Gerard", "geryb", "contraseña1"));
        nurseList.add(new Nurse("Sergio", "sejuma21", "contraseña2"));
        nurseList.add(new Nurse("Carla", "carla14", "contraseña3"));
        nurseList.add(new Nurse("Joan", "jachias21", "contraseña4"));
        nurseList.add(new Nurse("Juan", "juan_", "pass7"));
        nurseList.add(new Nurse("Maria", "maria.nurse", "pass8"));
        nurseList.add(new Nurse("Daniel", "naranjo43","pass10"));
        nurseList.add(new Nurse("Juan Pérez", "juan.perez", "pass1"));
        nurseList.add(new Nurse("Maria Lopez", "maria.lopez", "pass2"));
        nurseList.add(new Nurse("Antonio Garrido", "antonio.garrido", "pass3"));
        nurseList.add(new Nurse("Carlos Gonzalez", "carlos.gonzalez", "pass4"));
        nurseList.add(new Nurse("Sandra Castillo", "sandra.castillo", "pass5"));     
    }
  
  
    @PostMapping("/login")
    public @ResponseBody ResponseEntity<Boolean> login(@RequestBody Nurse inputNurse) {
        for (Nurse nurse : nurseList) {
        	System.out.println(nurse);
            if (inputNurse.getUser().equals(nurse.getUser()) && inputNurse.getPassword().equals(nurse.getPassword())) {
                return ResponseEntity.ok(true);
            }
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(false);
    }

    @GetMapping("/getAll")
    public List<Nurse> getAll() {
        return nurseList;
    }
  
  
    @GetMapping("/find")
    public ResponseEntity<Nurse> findByName(@RequestParam String name) {
        for (Nurse nurse : nurseList) {
            if (nurse.getName().equalsIgnoreCase(name)) {
                return ResponseEntity.ok(nurse); 
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); 
    }

}