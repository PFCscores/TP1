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
import repositories.EquipeRepository;



@RestController
@RequestMapping("rh")
public class EquipeController {
    @Autowired
    EquipeRepository equipeRepository;

    @PostMapping("equipes")
    public Equipe AddEquipe(@RequestBody Equipe equipe) {
        return equipeRepository.save(equipe);
    }

    @GetMapping("equipes")
    public List<Equipe> getAllEquipe(){
        return equipeRepository.findAll();
    }

    @GetMapping("equipes/{id}")
    public Optional<Equipe> getJoueurById(@PathVariable Long id) {
        return equipeRepository.findById(id);
    }

    @DeleteMapping("equipes/{id}")
    public void deleteJoueurById(@PathVariable Long id) {
        equipeRepository.deleteById(id);
    }

    @DeleteMapping("equipes")
    public void deleteJoueur(@RequestBody Equipe equipe) {
        equipeRepository.delete(equipe);
    }
}
