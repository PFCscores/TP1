package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import entitites.Equipe;

@Repository 
public interface EquipeRepository extends JpaRepository <Equipe, Long>{
	


}
