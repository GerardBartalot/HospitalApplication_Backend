package ProjectSpringBoot.HospitalApplication;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.ArrayList;
import ProjectSpringBoot.HospitalApplication.NurseController;
import java.util.Scanner;
@SpringBootApplication


public class HospitalApplication {
    public static void main(String[] args) {
        SpringApplication.run(HospitalApplication.class, args);
      NurseController nurseController = new NurseController();
        List<Nurse> nurses = nurseController.getAll();
        for (Nurse nurse : nurses) {
            System.out.println(nurse);
      
		Scanner scanner = new Scanner(System.in);
		System.out.println("Ingresa el nombre del enfermero:");
		String nurseName = scanner.nextLine();
		
		ResponseEntity<Nurse> foundNurse = nurseController.findByName(nurseName);
	    if (foundNurse != null) {
	        System.out.println("Enfermero encontrado: " + foundNurse);
	    } else {
	        System.out.println("Enfermero no encontrado");
	    }
        }
   
   }
}