package daw2.dwes.morty1.dto;

import daw2.dwes.morty1.model.Gender;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
@Getter @Setter
public class CharacterDTO {
    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    private String status;
    @NotBlank
    private String species;
    @NotBlank
    private String type;
    @NotNull
    private Gender gender;
    private String image;
    @NotNull
    @Min(value = 1)
    @Max(value = 999999)
    private Float weight;
    @NotNull
    private Float height;
    @NotNull
    @Min(value = 1)
    private Long location_id;
    @NotEmpty
    private Set<Long> episodes_id;
}
