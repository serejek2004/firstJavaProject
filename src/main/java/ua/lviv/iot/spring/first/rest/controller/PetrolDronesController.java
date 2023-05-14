package ua.lviv.iot.spring.first.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.spring.first.rest.model.PetrolDrone;
import ua.lviv.iot.spring.first.rest.service.PetrolDroneService;

import java.util.List;

@RequestMapping("/drones")
@RestController
public final class PetrolDronesController {

    @Autowired
    private PetrolDroneService droneService;

    @GetMapping(path = "/{id}")
    public ResponseEntity<PetrolDrone> getDroneById(
            final @PathVariable("id") int droneId) {

        if (!droneService.checkDroneWithIdExists(droneId)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return new ResponseEntity<>(droneService.getPetrolDroneById(droneId), HttpStatus.OK);

    }

    @GetMapping
    public List<PetrolDrone> getAllDrones() {

        return droneService.getAllPetrolDrones();

    }

    @PostMapping
    public ResponseEntity<PetrolDrone> spawnDrone(final @RequestBody PetrolDrone petrolDrone) {

        droneService.spawnDrone(petrolDrone);

        return ResponseEntity.status(HttpStatus.OK).build();

    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<PetrolDrone> deletePetrolDrone(
            final @PathVariable("id") int droneId) {

        if (!droneService.checkDroneWithIdExists(droneId)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        droneService.deleteDroneById(droneId);

        return ResponseEntity.status(HttpStatus.OK).build();

    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<PetrolDrone> updatePetrolDrone(
            final @RequestBody PetrolDrone petrolDrone,
            final @PathVariable("id") int droneId) {

        if (!droneService.checkDroneWithIdExists(droneId)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        petrolDrone.setId(droneId);
        droneService.setPetrolDroneById(petrolDrone, droneId);

        return ResponseEntity.status(HttpStatus.OK).build();

    }
}
