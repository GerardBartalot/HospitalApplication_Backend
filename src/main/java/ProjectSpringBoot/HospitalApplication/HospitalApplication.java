package ProjectSpringBoot.HospitalApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Scanner;

@SpringBootApplication
public class HospitalApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(HospitalApplication.class, args);

        NurseController nurseController = context.getBean(NurseController.class);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresa el nombre del enfermero:");
        String nurseName = scanner.nextLine();

        var foundNurse = nurseController.findByName(nurseName);
        if (foundNurse.getBody() != null) {
            System.out.println("Enfermero encontrado: \n" + foundNurse.getBody());
        } else {
            System.out.println("Enfermero no encontrado");
        }
        
    }
}