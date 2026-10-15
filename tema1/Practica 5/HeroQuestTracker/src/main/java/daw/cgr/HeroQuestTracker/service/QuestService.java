package daw.cgr.HeroQuestTracker.service;

import daw.cgr.HeroQuestTracker.model.Quest;
import daw.cgr.HeroQuestTracker.repository.QuestRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class QuestService {
    private final QuestRepository repository;

    public QuestService(QuestRepository repository){this.repository = repository;}

    public List<Quest> getAllQuests(){
        return repository.findAll();
    }
    public Quest findById(long id){
        return  repository.findById(id).orElse(null);
    }

    public void createRandomQuest(Quest quest){
        quest.setTitle(generateTitle());
        repository.save(quest);
    }

    public void markQuestAsSolved(long id){
        Quest quest = findById(id);
        quest.setSolved(true);
        repository.save(quest);
    }
    public void failQuest(long id){
        Quest quest = findById(id);
        repository.delete(quest);
    }






    private static final List adjectives = List.of( "Lost", "Forbidden", "Ancient", "Cursed", "Hidden", "Glorious", "Frozen", "Burning" );
    private static final List nouns = List.of( "Temple", "Blade", "Forest", "Scroll", "Beast", "Crown", "Crypt", "Dragon" );
    private static final List actions = List.of( "Rescue", "Defeat", "Recover", "Explore", "Protect", "Destroy", "Uncover", "Seal" );
    private static final Random random = new Random();
    private static String generateTitle() {
        String adjective = adjectives.get(random.nextInt(adjectives.size())).toString();
        String noun = nouns.get(random.nextInt(nouns.size())).toString();
        String action = actions.get(random.nextInt(actions.size())).toString();
        return action + " the " + adjective + " " + noun;
    }
}
