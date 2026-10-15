package daw.cgr.HeroQuestTracker.repository;

import daw.cgr.HeroQuestTracker.model.Hero;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HeroRepository extends JpaRepository<Hero, String>{

}
