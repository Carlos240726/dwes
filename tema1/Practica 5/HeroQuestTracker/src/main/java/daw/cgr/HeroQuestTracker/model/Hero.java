package daw.cgr.HeroQuestTracker.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "Heroes")
public class Hero {

    @Id
    @Column(name = "name")
    private String name;

    @Column(name = "class")
    private String clase;

    @Column(name = "nivel")
    private int nivel;

    @Column(name = "experience")
    private float experience;

    @OneToMany(mappedBy = "hero")
    private List<Quest> quests;

    public void lvlup(Hero hero){
        int lvl = hero.getNivel();
        if (hero.getExperience() >= 10){
            float currentXp = hero.getExperience();
            hero.setExperience(currentXp-10);
            hero.setNivel(lvl + 1);
        }
    }
}
