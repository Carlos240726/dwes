package daw.cgr.HeroQuestTracker.service;

import daw.cgr.HeroQuestTracker.model.Hero;
import daw.cgr.HeroQuestTracker.repository.HeroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HeroService {
    private final HeroRepository repository;
    public HeroService(HeroRepository repository){this.repository = repository;}

    public void initializaHeroes(Hero hero){
        repository.save(hero);
    }
    public List<Hero> getAllHeroes(){
        return repository.findAll();
    }
    public Hero findById(String name){
        return repository.findById(name).orElse(null);
    }
    public void addExperience(Hero hero , float xp){
        float currentXp = hero.getExperience();
        hero.setExperience(currentXp + xp);
        repository.save(hero);
    }
}
