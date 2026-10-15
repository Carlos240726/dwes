package daw.cgr.HeroQuestTracker.repository;

import daw.cgr.HeroQuestTracker.model.Quest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestRepository extends JpaRepository<Quest, Long> {
}
