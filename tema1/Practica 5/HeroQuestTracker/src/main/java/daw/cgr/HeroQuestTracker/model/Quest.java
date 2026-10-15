package daw.cgr.HeroQuestTracker.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Quests")
public class Quest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "solved")
    private boolean solved;

    @Column(name = "experience")
    private float experience;

    @ManyToOne
    @JoinColumn(name = "hero_name")
    private Hero hero;
}
