package ProjectSpringBoot.HospitalApplication;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import ProjectSpringBoot.HospitalApplication.Nurse;
import ProjectSpringBoot.HospitalApplication.NurseController;
import ProjectSpringBoot.HospitalApplication.NurseRepository;

class NurseControllerTest {

    @Mock
    private NurseRepository nurseRepository;

    @InjectMocks
    private NurseController nurseController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testValidateLoginSuccess() {
        // Arrange
        String username = "jdoe";
        String password = "password123";
        Nurse nurse = new Nurse();
        nurse.setUsername(username);
        nurse.setPassword(password);
        when(nurseRepository.findByUsername(username)).thenReturn(nurse);

        // Act
        ResponseEntity<String> response = nurseController.validateLogin(username, password);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Login Successful", response.getBody());
    }

    @Test
    void testValidateLoginFailure() {
        // Arrange
        String username = "jdoe";
        String password = "wrongpassword";
        when(nurseRepository.findByUsername(username)).thenReturn(null);

        // Act
        ResponseEntity<String> response = nurseController.validateLogin(username, password);

        // Assert
        assertEquals(HttpStatus.UNAUTHORIZED, response.getStatusCode());
        assertEquals("Invalid username or password", response.getBody());
    }

    @Test
    void testGetAll() {
        // Arrange
        Nurse nurse1 = new Nurse();
        nurse1.setName("Jane Doe");
        Nurse nurse2 = new Nurse();
        nurse2.setName("John Smith");
        List<Nurse> nurses = Arrays.asList(nurse1, nurse2);
        when(nurseRepository.findAll()).thenReturn(nurses);

        // Act
        List<Nurse> response = nurseController.getAll();

        // Assert
        assertNotNull(response);
        assertEquals(2, response.size());
    }

    @Test
    void testFindByNameFound() {
        // Arrange
        String name = "Jane Doe";
        Nurse nurse = new Nurse();
        nurse.setName(name);
        when(nurseRepository.findByName(anyString())).thenReturn(nurse);

        // Act
        ResponseEntity<Nurse> response = nurseController.findByName(name);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(name, response.getBody().getName());
    }

    @Test
    void testFindByNameNotFound() {
        // Arrange
        when(nurseRepository.findByName(anyString())).thenReturn(null);

        // Act
        ResponseEntity<Nurse> response = nurseController.findByName("NonExistentName");

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals(null, response.getBody());
    }

    @Test
    void testUpdateNurseSuccess() {
        // Arrange
        int id = 1;
        Nurse existingNurse = new Nurse();
        existingNurse.setNurse_id(id);
        existingNurse.setName("Jane Doe");

        Nurse updatedNurse = new Nurse();
        updatedNurse.setName("Jane Smith");
        updatedNurse.setUsername("jsmith");
        updatedNurse.setPassword("newpassword");

        when(nurseRepository.findById(anyInt())).thenReturn(Optional.of(existingNurse));

        // Act
        ResponseEntity<String> response = nurseController.updateNurse(id, updatedNurse);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Nurse updated successfully", response.getBody());
    }

    @Test
    void testUpdateNurseNotFound() {
        // Arrange
        int id = 1;
        Nurse updatedNurse = new Nurse();
        updatedNurse.setName("Jane Smith");

        when(nurseRepository.findById(anyInt())).thenReturn(Optional.empty());

        // Act
        ResponseEntity<String> response = nurseController.updateNurse(id, updatedNurse);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals("Nurse not found", response.getBody());
    }
    
}