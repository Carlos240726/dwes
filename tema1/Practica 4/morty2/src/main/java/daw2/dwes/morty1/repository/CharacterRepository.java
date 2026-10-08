package daw2.dwes.morty1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import daw2.dwes.morty1.model.Character;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CharacterRepository extends JpaRepository<Character, Long> {
    // Aquí puedes añadir consultas personalizadas si lo necesitas, por defecto se crean
    //
    @Modifying
    @Query("DELETE FROM Character c WHERE c.id = :id")
    void borrarPersonaje(@Param("id") Long id);

    @Modifying
    @Query(value = "INSERT INTO characters (character_name, status, species, character_type, gender, location_id, image_url, weight, height) VALUES (:name, :status, :species, :type, :gender, :locationId, :image, :weight, :height)", nativeQuery = true)
    void insertarPersonaje(@Param("name") String name, @Param("status") String status, @Param("species") String species, @Param("type") String type, @Param("gender") String gender, @Param("locationId") Long locationId, @Param("image") String image, @Param("weight") Float weight, @Param("height") Float height);

    @Query("select c from Character c where c.height >= 1.70")
    List<Character>findByHeight(@Param("height") Float height);
    List<Character> findCharacterByName(String name);



}



