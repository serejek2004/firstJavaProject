package ua.lviv.iot.spring.first.rest.service;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import ua.lviv.iot.spring.first.rest.model.PetrolDrone;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
@Setter
@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)

public final class PetrolDroneService {
    private Map<Integer, PetrolDrone> petrolDroneMap = new HashMap<>();

    private AtomicInteger availableId = new AtomicInteger();

    private Integer nextAvailableId = 1;

    public Integer getNextAvailableId() {
        availableId.set(1);

        while (petrolDroneMap.containsKey(availableId.get())) {
            availableId.incrementAndGet();
        }

        return availableId.get();
    }

    public Map<Integer, PetrolDrone> getPetrolDroneMap() {
        return petrolDroneMap;
    }
}
