package ProjectSpringBoot.HospitalApplication;


import java.util.ArrayList;
import java.util.List;

public class NurseController {
    private List<Nurse> nurseList;

    public NurseController() {
        this.nurseList = new ArrayList<>();
        completeList();
    }

    private void completeList() {
        nurseList.add(new Nurse("Nil", "nilarroyo43", "contraseña0"));
        nurseList.add(new Nurse("Gerard", "gerryb", "contraseña1"));
        nurseList.add(new Nurse("Sergio", "sejuma21", "contraseña2"));
        nurseList.add(new Nurse("Carla", "carlita69", "contraseña3"));
        nurseList.add(new Nurse("Joan", "jachias21", "contraseña4"));
        nurseList.add(new Nurse("Juan", "JuanElEnfermero", "mcauto89"));
		    nurseList.add(new Nurse("Maria", "MariaNurse", "megatron777"));
		    nurseList.add(new Nurse("Gainza", "GainzaLaMaravilla","voyperro"));
		    nurseList.add(new Nurse("Daniel", "Naranjo43","halamadrid"));
        
        
      
    }

    public List<Nurse> getAll() {
        return nurseList;
    }
  public Nurse findByName(String name) {
		for (Nurse nurse : nurseList) {
			if (nurse.getName().equalsIgnoreCase(name)) {
				return nurse;
			}
		}
		return null;
	}

}
