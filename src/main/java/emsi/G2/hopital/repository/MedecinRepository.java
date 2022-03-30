package emsi.G2.hopital.repository;

import emsi.G2.hopital.entities.Medecin;

import emsi.G2.hopital.entities.Pat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedecinRepository extends JpaRepository<Medecin,Long> {
    Medecin findByNom(String name);
}
