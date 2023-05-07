package ua.lviv.iot.spring.first.rest.controller;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
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
            final @PathVariable("id") Integer droneId) {

        return droneService.getById(droneId);

    }

    @GetMapping(path = "getall")
    public List<PetrolDrone> getAllDrone() {

        return droneService.getAll();

    }

    @PostMapping
    public PetrolDrone spawnDrone(final @RequestBody PetrolDrone petrolDrone) {

        return droneService.spawnDrone(petrolDrone);

    }

    @DeleteMapping(path = "delete/{id}")
    public ResponseEntity<PetrolDrone> deletePetrolDrone(
            final @PathVariable("id") Integer droneId) {

        return droneService.deletePetrolDrone(droneId);

    }

    @PutMapping(path = "update/{id}")
    public ResponseEntity<PetrolDrone> updatePetrolDrone(
            final @RequestBody PetrolDrone petrolDrone,
            final @PathVariable("id") Integer droneId) {

        return droneService.updatePetrolDrone(petrolDrone, droneId);

    }
}
