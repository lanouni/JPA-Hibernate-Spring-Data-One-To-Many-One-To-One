package emsi.G2.hopital;

import emsi.G2.hopital.entities.*;
import emsi.G2.hopital.repository.ConsultationRepository;
import emsi.G2.hopital.repository.MedecinRepository;
import emsi.G2.hopital.repository.PatientRepository;
import emsi.G2.hopital.repository.RendezVousRepository;
import emsi.G2.hopital.service.IHospitalService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.persistence.Id;
import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class HopitalApplication {

	public static void main(String[] args) {
		SpringApplication.run(HopitalApplication.class, args);
	}

	@Bean
	CommandLineRunner start(IHospitalService hospitalService,PatientRepository patientRepository
							,MedecinRepository medecinRepository,
							RendezVousRepository rendezVousRepository
//							ConsultationRepository consultationRepository
	){
		return args -> {
			Stream.of("souhayl","khawla","lanouni").forEach(name ->{
					Pat patient = new Pat();
					patient.setNom(name);
					patient.setDateNaissance (new Date());
					patient.setMalade (false);
					//patientRepository.save(patient);
					hospitalService.savePat(patient);
			});
			Stream.of("mohamed","achraf","lanouni").forEach(name ->{
				Medecin medecin = new Medecin();
				medecin.setNom(name);
				medecin.setSpecialite ("cardio");
				medecin.setEmail(name+"@gmail.com");
				hospitalService.saveMedecin(medecin);
				//medecinRepository.save(medecin);
			});

			Pat pat = patientRepository.findById(1L).orElse(null);
			Pat pat1 = patientRepository.findByNom("souhayl");

			Medecin medecin = medecinRepository.findByNom("achraf");
//			Pat pat = patientRepository.findById(1L).orElse(null);
//			Pat pat1 = patientRepository.findByNom("souhayl");
//
//			Medecin medecin = medecinRepository.findByNom("achraf");


			RendezVous rendezVous=new RendezVous();
			rendezVous.setDate(new Date());
			rendezVous.setAnnule(StatusRDV.PENDING);
			rendezVous.setMedecin(medecin);
			rendezVous.setPatient(pat);
			rendezVousRepository.save((rendezVous));

			RendezVous rendezVous1=rendezVousRepository.findById(1L).orElse(null);
			Consultation consultation = new Consultation();
			consultation.setDateConsultation(new Date());
			consultation.setRendezVous(rendezVous);
			consultation.setRapport("rapport de consultation");
			hospitalService.savConsultation(consultation);
		};
	}
}
