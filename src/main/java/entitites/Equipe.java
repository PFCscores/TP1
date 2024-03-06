package entitites;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor @Data @Entity
public class Equipe {
	@Id
	Long id;
	String nom;
	double salaire;
	@OneToMany(mappedBy = "equipe")
	@JsonIgnore
	List<Joueur> employes;


}
