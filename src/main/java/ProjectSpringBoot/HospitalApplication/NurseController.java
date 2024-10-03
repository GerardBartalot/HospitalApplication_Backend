package ProjectSpringBoot.HospitalApplication;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

public class NurseController {
	private List<Nurse> nurses;

	public NurseController(List<Nurse> nurses) {
		this.nurses = nurses;
	}

	public Nurse findByName(String name) {
		for (Nurse nurse : nurses) {
			if (nurse.getName().equalsIgnoreCase(name)) {
				return nurse;
			}
		}
		return null;
	}
	
	/*
	private ResponseEntity<Nurse> findByName2(@PathVariable String name){
		//return ResponseEntity.ok("{}");
		for (Nurse nurse : nurses) {
			System.out.println(nurse);
			if (name.equals(nurse.name())) {
				return ResponseEntity.ok(nurse);
			}
		}
		return ResponseEntity.notFound().build();

	}
	*/
}
