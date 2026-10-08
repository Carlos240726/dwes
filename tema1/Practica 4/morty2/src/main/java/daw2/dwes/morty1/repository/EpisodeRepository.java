package daw2.dwes.morty1.repository;

import daw2.dwes.morty1.model.Episode;
import org.hibernate.sql.Insert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface EpisodeRepository extends JpaRepository<Episode, Long> {
    @Modifying
    @Query(value = "INSERT INTO episodes (episode_name, air_date, episode_code) VALUES (:name, :airDate, :episodeCode)", nativeQuery = true)
    void insertarEpisode(@Param("name") String name, @Param("airDate") LocalDate airDate, @Param("episodeCode") String episodeCode);

    @Query("select e from Episode e where year(e.airDate) > 2015")
    List<Episode> findByAirDate(@Param("airDate")Date airDate);


    @Query("select count(e) from Episode e")
    long countEpisode();
}