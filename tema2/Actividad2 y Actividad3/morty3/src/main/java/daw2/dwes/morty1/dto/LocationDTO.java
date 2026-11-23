package daw2.dwes.morty1.dto;

import daw2.dwes.morty1.model.Character;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter @Setter
public class LocationDTO {
    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    private String dimension;
    @NotBlank
    private String type;
    @NotEmpty
    private Set<Character> characters;


}
