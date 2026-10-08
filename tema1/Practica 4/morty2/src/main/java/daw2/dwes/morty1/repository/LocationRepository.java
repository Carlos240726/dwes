package daw2.dwes.morty1.repository;

import daw2.dwes.morty1.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LocationRepository extends JpaRepository<Location, Long> {
    @Modifying
    @Query("UPDATE Location l SET l.name = :name WHERE l.id = :id")
    void actualizarNombre(@Param("id") Long id, @Param("name") String name);

    @Modifying
    @Query(value = "INSERT INTO locations (location_name, location_type, dimension_name) VALUES (:name, :type, :dimension)", nativeQuery = true)
    void insertarLocalizacion(@Param("name") String name, @Param("type") String type, @Param("dimension") String dimension);

    @Query("select l.name, l.dimension from Location l inner join Character c on c.location = Location where c.species = 'Human'")
    List<Location> findAllLocations();
}

