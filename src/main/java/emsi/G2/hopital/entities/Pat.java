package emsi.G2.hopital.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Pat {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom ;
    @Temporal(TemporalType.DATE)
    private Date dateNaissance;
    private boolean Malade;
    @OneToMany(mappedBy = "patient",fetch = FetchType.LAZY)
    private Collection<RendezVous> rendezVous;
}