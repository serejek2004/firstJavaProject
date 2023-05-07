package ua.lviv.iot.spring.first.rest.service;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import ua.lviv.iot.spring.first.rest.model.PetrolDrone;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
@Setter
@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)

public final class PetrolDroneService {
    private Map<Integer, PetrolDrone> petrolDroneMap = new HashMap<>();

    private final AtomicInteger idCounter = new AtomicInteger();

    private AtomicInteger availableId = new AtomicInteger();

    private Integer nextAvailableId = 1;

    public Integer getNextAvailableId() {
        availableId.set(1);

        while (petrolDroneMap.containsKey(availableId.get())) {
            availableId.incrementAndGet();
        }

        return availableId.get();
    }

    public List<PetrolDrone> getAll() {
        return new LinkedList<>(getPetrolDroneMap().values());
    }

    public ResponseEntity<PetrolDrone> getById(Integer droneId) {
        if (!petrolDroneMap.containsKey(droneId)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return new ResponseEntity<>(
                petrolDroneMap.get(droneId), HttpStatus.OK);
    }

    public PetrolDrone spawnDrone(final @RequestBody PetrolDrone petrolDrone) {

        if (idCounter.get() != nextAvailableId) {
            idCounter.set(nextAvailableId);
            petrolDrone.setId(idCounter.get());
            petrolDroneMap.put(petrolDrone.getId(), petrolDrone);
            return petrolDrone;
        }

        petrolDrone.setId(getNextAvailableId());
        petrolDroneMap.put(petrolDrone.getId(), petrolDrone);
        return petrolDrone;

    }

    public ResponseEntity<PetrolDrone> deletePetrolDrone(
            final Integer droneId) {

        if (petrolDroneMap.remove(droneId) == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        petrolDroneMap.remove(droneId);
        setNextAvailableId(droneId);
        return ResponseEntity.status(HttpStatus.OK).build();

    }

    public ResponseEntity<PetrolDrone> updatePetrolDrone(
            final @RequestBody PetrolDrone petrolDrone,
            final Integer droneId) {

        if (!petrolDroneMap.containsKey(droneId)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        petrolDrone.setId(droneId);
        petrolDroneMap.put(droneId, petrolDrone);
        return ResponseEntity.status(HttpStatus.OK).build();

    }
}
