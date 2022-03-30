package emsi.G2.hopital.web;

import emsi.G2.hopital.entities.Pat;
import emsi.G2.hopital.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PatientRestController {
    @Autowired
    private PatientRepository patientRepository;

    @GetMapping("/patients")
    public List<Pat> patientList(){
        return patientRepository.findAll();
    }
}