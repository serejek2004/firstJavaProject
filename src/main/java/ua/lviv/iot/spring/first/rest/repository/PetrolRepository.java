package ua.lviv.iot.spring.first.rest.repository;

import org.springframework.web.bind.annotation.RequestBody;
import ua.lviv.iot.spring.first.rest.model.PetrolDrone;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class PetrolRepository {
    private final Map<Integer, PetrolDrone> petrolDroneMap = new HashMap<>();

    private final AtomicInteger availableId = new AtomicInteger();

    public Integer getNextAvailableId() {
        availableId.set(1);

        while (petrolDroneMap.containsKey(availableId.get())) {
            availableId.incrementAndGet();
        }

        return availableId.get();
    }

    public List<PetrolDrone> getAllPetrolDronesFromRepository() {
        return new LinkedList<>(petrolDroneMap.values());
    }

    public PetrolDrone getByIdFromRepository(final int id) {
        return petrolDroneMap.get(id);
    }

    public void setByIdFromRepository(final PetrolDrone petrolDrone,
                        final int id) {
        petrolDroneMap.put(id, petrolDrone);
    }

    public boolean existDroneWithIdInRepository(final int id) {
        return petrolDroneMap.containsKey(id);
    }

    public void spawnDroneInRepository(final @RequestBody PetrolDrone petrolDrone) {
        petrolDrone.setId(getNextAvailableId());
        petrolDroneMap.put(petrolDrone.getId(), petrolDrone);
    }

    public void deleteDroneInRepository(final int id) {
        petrolDroneMap.remove(id);
    }

}
