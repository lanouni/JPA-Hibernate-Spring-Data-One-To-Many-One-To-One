package emsi.G2.hopital.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class RendezVous {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date date;
    @Enumerated(EnumType.STRING)
    private StatusRDV annule;
    @ManyToOne
    private  Medecin medecin;
    @ManyToOne
    private Pat patient;
    @OneToOne(mappedBy = "rendezVous")
    private  Consultation consultation;
}