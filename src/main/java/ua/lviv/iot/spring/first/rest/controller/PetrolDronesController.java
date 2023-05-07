package ua.lviv.iot.spring.first.rest.controller;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.spring.first.rest.model.PetrolDrone;
import ua.lviv.iot.spring.first.rest.service.PetrolDroneService;

import java.util.List;

@Getter
@Setter
@RequestMapping("/drones")
@RestController

public final class PetrolDronesController {

    @Autowired
    private PetrolDroneService droneService;

    @GetMapping(path = "get/{id}")
    public ResponseEntity<PetrolDrone> getDroneById(
            final @PathVariable("id") int droneId) {

        if (!droneService.existDroneWithId(droneId)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return new ResponseEntity<>(droneService.getById(droneId), HttpStatus.OK);

    }

    @GetMapping(path = "getall")
    public List<PetrolDrone> getAllDrone() {

        return droneService.getAllPetrolDrones();

    }

    @PostMapping
    public ResponseEntity<PetrolDrone> spawnDrone(final @RequestBody PetrolDrone petrolDrone) {

        droneService.spawnDrone(petrolDrone);

        return ResponseEntity.status(HttpStatus.OK).build();

    }

    @DeleteMapping(path = "delete/{id}")
    public ResponseEntity<PetrolDrone> deletePetrolDrone(
            final @PathVariable("id") int droneId) {

        if (!droneService.existDroneWithId(droneId)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        droneService.deleteDrone(droneId);
        droneService.setNextAvailableId(droneId);

        return ResponseEntity.status(HttpStatus.OK).build();

    }

    @PutMapping(path = "update/{id}")
    public ResponseEntity<PetrolDrone> updatePetrolDrone(
            final @RequestBody PetrolDrone petrolDrone,
            final @PathVariable("id") int droneId) {

        if (!droneService.existDroneWithId(droneId)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        petrolDrone.setId(droneId);
        droneService.setById(petrolDrone, droneId);

        return ResponseEntity.status(HttpStatus.OK).build();

    }
}
