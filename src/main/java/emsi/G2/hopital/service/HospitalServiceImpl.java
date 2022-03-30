package emsi.G2.hopital.service;

import emsi.G2.hopital.entities.Consultation;
import emsi.G2.hopital.entities.Medecin;
import emsi.G2.hopital.entities.Pat;
import emsi.G2.hopital.entities.RendezVous;
import emsi.G2.hopital.repository.ConsultationRepository;
import emsi.G2.hopital.repository.MedecinRepository;
import emsi.G2.hopital.repository.PatientRepository;
import emsi.G2.hopital.repository.RendezVousRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class HospitalServiceImpl implements IHospitalService {
    private PatientRepository patientRepository;
    private MedecinRepository medecinRepository;
    private RendezVousRepository rendezVousRepository;
    private ConsultationRepository consultationRepository;

    public HospitalServiceImpl(PatientRepository patientRepository, MedecinRepository medecinRepository, RendezVousRepository rendezVousRepository, ConsultationRepository consultationRepository) {
        this.patientRepository = patientRepository;
        this.medecinRepository = medecinRepository;
        this.rendezVousRepository = rendezVousRepository;
        this.consultationRepository = consultationRepository;
    }


    @Override
    public Pat savePat(Pat patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Medecin saveMedecin(Medecin medecin) {
        return medecinRepository.save(medecin);
    }

    @Override
    public RendezVous saveRDV(RendezVous rendezVous) {
        return rendezVousRepository.save(rendezVous);
    }

    @Override
    public Consultation savConsultation(Consultation consultation) {
        return consultationRepository.save(consultation);
    }
}