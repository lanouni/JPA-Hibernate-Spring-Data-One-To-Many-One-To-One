package emsi.G2.hopital.service;

import emsi.G2.hopital.entities.Consultation;
import emsi.G2.hopital.entities.Medecin;
import emsi.G2.hopital.entities.Pat;
import emsi.G2.hopital.entities.RendezVous;

public interface IHospitalService {
    Pat savePat(Pat patient);
    Medecin saveMedecin(Medecin medecin);
    RendezVous saveRDV(RendezVous rendezVous);
    Consultation savConsultation(Consultation consultation);
}
