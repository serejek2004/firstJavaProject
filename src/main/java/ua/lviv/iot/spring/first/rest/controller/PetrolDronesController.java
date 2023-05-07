package ua.lviv.iot.spring.first.rest.controller;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.spring.first.rest.model.PetrolDrone;
import ua.lviv.iot.spring.first.rest.service.PetrolDroneService;

import java.util.Collection;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
@Setter
@RequestMapping("/drones")
@RestController

public final class PetrolDronesController {

    @Autowired
    private PetrolDroneService droneService;

    private final AtomicInteger idCounter = new AtomicInteger();

    @GetMapping(path = "get/{id}")
    public ResponseEntity<PetrolDrone> getDroneById(
            final @PathVariable("id") Integer droneId) {

        if (!droneService.getPetrolDroneMap().containsKey(droneId)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return new ResponseEntity<>(
                droneService.getPetrolDroneMap().get(droneId), HttpStatus.OK);

    }

    @GetMapping(path = "getall")
    public Collection<PetrolDrone> getAllDrone() {

        return droneService.getPetrolDroneMap().values();

    }

    @PostMapping(path = "spawn")
    public PetrolDrone spawnDrone(final @RequestBody PetrolDrone petrolDrone) {

        if (idCounter.get() != droneService.getNextAvailableId()) {
            idCounter.set(droneService.getNextAvailableId());
            petrolDrone.setId(idCounter.get());
            droneService.getPetrolDroneMap().put(petrolDrone.getId(),
                    petrolDrone);
            return petrolDrone;
        }

        petrolDrone.setId(droneService.getNextAvailableId());
        droneService.getPetrolDroneMap().put(petrolDrone.getId(), petrolDrone);
        return petrolDrone;

    }

    @DeleteMapping(path = "delete/{id}")
    public ResponseEntity<PetrolDrone> deletePetrolDrone(
            final @PathVariable("id") Integer droneId) {

        if (droneService.getPetrolDroneMap().remove(droneId) == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        droneService.getPetrolDroneMap().remove(droneId);
        droneService.setNextAvailableId(droneId);
        return ResponseEntity.status(HttpStatus.OK).build();

    }

    @PutMapping(path = "update/{id}")
    public ResponseEntity<PetrolDrone> updatePetrolDrone(
            final @RequestBody PetrolDrone petrolDrone,
            final @PathVariable("id") Integer droneId) {

        if (!droneService.getPetrolDroneMap().containsKey(droneId)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        petrolDrone.setId(droneId);
        droneService.getPetrolDroneMap().put(droneId, petrolDrone);
        return ResponseEntity.status(HttpStatus.OK).build();

    }
}
