package controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import entitites.Equipe;
import entitites.Joueur;
import repositories.EquipeRepository;
import repositories.JoueurRepository;

@RestController
@RequestMapping("rh")
public class JoueurController {
    @Autowired
    JoueurRepository joueurRepository;
    @Autowired
    EquipeRepository equipeRepository;

    @PostMapping("equipes/{idEquipe}/joueurs")
    public Joueur addJoueur(@RequestBody Joueur joueur, @PathVariable Long idEquipe) {
        Optional<Equipe> equipe = equipeRepository.findById(idEquipe);
        if (equipe.isPresent()) {
            joueur.setEquipe(equipe.get());
            return joueurRepository.save(joueur);
        }
        return null;
    }

    @GetMapping("joueurs")
    public List<Joueur> getAllJoueurs() {
        return joueurRepository.findAll();
    }

    @GetMapping("equipes/{nomEquipe}/joueurs")
    public List<Joueur> getAllJoueursOfEquipe(@PathVariable String nomEquipe) {
        return joueurRepository.findByEquipeNom(nomEquipe);
    }

    @GetMapping("joueurs/{id}")
    public Optional<Joueur> getJoueurById(@PathVariable Long id) {
        return joueurRepository.findById(id);
    }

    @DeleteMapping("joueurs/{id}")
    public void deleteJoueurById(@PathVariable Long id) {
        joueurRepository.deleteById(id);
    }

    @DeleteMapping("joueurs")
    public void deleteJoueur(@RequestBody Joueur joueur) {
        joueurRepository.delete(joueur);
    }
}
