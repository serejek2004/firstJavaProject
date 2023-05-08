package ua.lviv.iot.spring.first.rest.service;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import ua.lviv.iot.spring.first.rest.model.PetrolDrone;
import ua.lviv.iot.spring.first.rest.repository.PetrolRepository;

import java.util.LinkedList;
import java.util.List;

@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)

public final class PetrolDroneService {

    private final PetrolRepository petrolRepository = new PetrolRepository();

    public List<PetrolDrone> getAllPetrolDrones() {
        return new LinkedList<>((petrolRepository.getAllPetrolDronesFromRepository()));
    }

    public PetrolDrone getById(final int id) {
        return petrolRepository.getByIdFromRepository(id);
    }

    public void setById(final PetrolDrone petrolDrone, final int id) {
        petrolRepository.setByIdFromRepository(petrolDrone, id);
    }

    public boolean existDroneWithId(final int id) {
        return petrolRepository.existDroneWithIdInRepository(id);
    }

    public void spawnDrone(final @RequestBody PetrolDrone petrolDrone) {
        petrolRepository.spawnDroneInRepository(petrolDrone);
    }

    public void deleteDrone(final int id) {
        petrolRepository.deleteDroneInRepository(id);
    }
}
