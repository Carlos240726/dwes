package daw.cgr.HeroQuestTracker.controller;

import daw.cgr.HeroQuestTracker.model.Quest;
import daw.cgr.HeroQuestTracker.service.QuestService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Random;

@Controller
@RequestMapping("/quests")
public class QuestController {
    private final QuestService service;
    public QuestController(QuestService service){this.service = service;}

    @GetMapping
    public String showQuests(Model model){
        model.addAttribute("quests", service.getAllQuests());
        return "quests/list";
    }

    @GetMapping("/new")
    public String newQuest(Model model){
        Random random = new Random();
        Quest quest = new Quest();
        quest.setExperience(random.nextInt(10));
        quest.setSolved(false);
        service.createRandomQuest(quest);
        return "redirect:/quests";
    }

    @GetMapping("/solve/{id}")
    public String solveQuest(@PathVariable Long id, Model model){
        service.markQuestAsSolved(id);
        return "redirect:/quests";
    }

    @GetMapping("fail/{id}")
    public String failQuest(@PathVariable Long id){
        service.failQuest(id);
        return "redirect:/quests";
    }

}
