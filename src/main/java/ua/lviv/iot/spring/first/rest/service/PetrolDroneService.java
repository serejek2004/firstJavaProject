package ua.lviv.iot.spring.first.rest.service;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import ua.lviv.iot.spring.first.rest.model.PetrolDrone;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)

public final class PetrolDroneService {
    private final Map<Integer, PetrolDrone> petrolDroneMap = new HashMap<>();

    private final AtomicInteger availableId = new AtomicInteger();

    public Integer getNextAvailableId() {
        availableId.set(1);

        while (petrolDroneMap.containsKey(availableId.get())) {
            availableId.incrementAndGet();
        }

        return availableId.get();
    }

    public List<PetrolDrone> getAllPetrolDrones() {
        return new LinkedList<>(petrolDroneMap.values());
    }

    public PetrolDrone getById(final int id) {
        return petrolDroneMap.get(id);
    }

    public void setById(final PetrolDrone petrolDrone,
                        final int id) {
        petrolDroneMap.put(id, petrolDrone);
    }

    public boolean existDroneWithId(final int id) {
        return petrolDroneMap.containsKey(id);
    }

    public void spawnDrone(final @RequestBody PetrolDrone petrolDrone) {
        petrolDrone.setId(getNextAvailableId());
        petrolDroneMap.put(petrolDrone.getId(), petrolDrone);
    }

    public void deleteDrone(final int id) {
        petrolDroneMap.remove(id);
    }
}
