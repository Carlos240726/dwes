package daw2.dwes.morty1.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "characters")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Character {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "character_name", nullable = false, length = 255)
        private String name;

        @Column(name = "status", length = 50)
        private String status;

        @Column(name = "species", length = 100)
        private String species;

        @Column(name = "character_type", length = 255)
        private String type;

        @Enumerated(EnumType.STRING)
        private Gender gender;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "location_id")
        private Location location;

        @Column(name = "image_URL", length = 255)
        private String image;

        @Column(name = "weight")
        private Float weight;

        @Column(name = "height")
        private Float height;
}
