package daw2.dwes.morty1.service;

import daw2.dwes.morty1.model.Location;
import daw2.dwes.morty1.repository.LocationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LocationService {

    private final LocationRepository repository;

    public LocationService(LocationRepository repository) {
        this.repository = repository;
    }

    public List<Location> findAll() {
        return repository.findAll();
    }

    public Location findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Transactional
    public void actualizarNombre(Long id, String name) {
        repository.actualizarNombre(id, name);
    }

    @Transactional
    public Long insertarLocalizacion(
            String name,
            String type,
            String dimension) {

        repository.insertarLocalizacion(
                name,
                type,
                dimension
        );
        return null;
    }
}