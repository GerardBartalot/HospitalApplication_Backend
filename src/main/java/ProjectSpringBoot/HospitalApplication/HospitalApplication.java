package ProjectSpringBoot.HospitalApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.List;
import java.util.ArrayList;
import ProjectSpringBoot.HospitalApplication.NurseController;
import java.util.Scanner;
@SpringBootApplication

public class HospitalApplication {

	public static void main(String[] args) {
		SpringApplication.run(HospitalApplication.class, args);
		
		List<Nurse> nurses = new ArrayList<>();
		nurses.add(new Nurse("Juan", "JuanElEnfermero", "mcauto89"));
		nurses.add(new Nurse("Maria", "MariaNurse", "megatron777"));
		nurses.add(new Nurse("Gainza", "GainzaLaMaravilla","voyperro"));
		nurses.add(new Nurse("Daniel", "Naranjo43","halamadrid"));
		
		NurseController nurseController = new NurseController(nurses);
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Ingresa el nombre del enfermero:");
		String nurseName = scanner.nextLine();
		
		Nurse foundNurse = nurseController.findByName(nurseName);
	    if (foundNurse != null) {
	        System.out.println("Enfermero encontrado: " + foundNurse);
	    } else {
	        System.out.println("Enfermero no encontrado");
	    }
	}
	

}
