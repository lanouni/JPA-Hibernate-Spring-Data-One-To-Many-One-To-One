package emsi.G2.hopital.repository;

import emsi.G2.hopital.entities.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepository extends JpaRepository<Consultation,Long> {
}
