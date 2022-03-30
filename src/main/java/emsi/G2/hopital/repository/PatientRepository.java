package emsi.G2.hopital.repository;

import emsi.G2.hopital.entities.Pat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Pat,Long> {
    Pat findByNom(String name);
}
