package ProjectSpringBoot.HospitalApplication;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HospitalApplication {
    public static void main(String[] args) {
        SpringApplication.run(HospitalApplication.class, args);

        NurseController nurseController = new NurseController();
        List<Nurse> nurses = nurseController.getAll();
        for (Nurse nurse : nurses) {
            System.out.println(nurse);
        }
    }
}
