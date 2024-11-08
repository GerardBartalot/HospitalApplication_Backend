package ProjectSpringBoot.HospitalApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import java.util.Scanner;

@SpringBootApplication
public class HospitalApplication {
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(HospitalApplication.class, args);
	}
}
