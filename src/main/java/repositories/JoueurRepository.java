package repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import entitites.Joueur;

public interface JoueurRepository  extends JpaRepository <Joueur, Long>{
	public List<Joueur> findByEquipeNom(String nom);

}
