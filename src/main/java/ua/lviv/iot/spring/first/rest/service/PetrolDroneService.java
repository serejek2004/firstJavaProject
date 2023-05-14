package ua.lviv.iot.spring.first.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private PetrolRepository petrolRepository;

    public List<PetrolDrone> getAllPetrolDrones() {
        return new LinkedList<>((petrolRepository.getAllPetrolDronesFromRepository()));
    }

    public PetrolDrone getPetrolDroneById(final int id) {
        return petrolRepository.getPetrolDroneByIdFromRepository(id);
    }

    public void setPetrolDroneById(final PetrolDrone petrolDrone, final int id) {
        petrolRepository.setPetrolDroneByIdFromRepository(petrolDrone, id);
    }

    public boolean checkDroneWithIdExists(final int id) {
        return petrolRepository.checkDroneWithIdExistsInRepository(id);
    }

    public void spawnDrone(final @RequestBody PetrolDrone petrolDrone) {
        petrolRepository.spawnDroneInRepository(petrolDrone);
    }

    public void deleteDroneById(final int id) {
        petrolRepository.deleteDroneByIdInRepository(id);
    }
}
