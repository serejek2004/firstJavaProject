package ua.lviv.iot.spring.first.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;

@Getter

public final class PetrolDrone extends AbstractDrone {
    private final double fuelCapacity;
    private final double consumptionFuel;
    private double currentMaxFlyingDistance;
    private double currentFuelLevel;
    private Integer id;

    public void setId(final int availableId) {
        id = availableId;
    }

    public PetrolDrone(final double fuelCapacity,
                       final double currentFuelLevel,
                       final double consumptionFuel,
                       final double currentSpeed,
                       final double currentAltitude) {
        super(currentSpeed, currentAltitude);
        this.fuelCapacity = fuelCapacity;
        this.consumptionFuel = consumptionFuel;
        this.currentFuelLevel = currentFuelLevel;
    }

    public double getCurrentFuelLevel() {
        return currentFuelLevel;
    }

    public void refuel(final double amount) {
        if (currentFuelLevel < fuelCapacity) {
            currentFuelLevel += amount;
        }
        if (currentFuelLevel > fuelCapacity) {
            currentFuelLevel -= amount;
        }
    }

    public void useFuel(final double amount) {
        if (currentFuelLevel > amount) {
            currentFuelLevel -= amount;
        }
    }

    @Override
    public void flyAt(final double speedMetersPerMinute,
                      final double altitude) {
        setCurrentSpeed(speedMetersPerMinute);
        setCurrentAltitude(altitude);
    }

    @Override
    public void calculateMaxFlyingDistanceAtCurrentSpeed() {
        final int formulaNumber = 100;
        currentMaxFlyingDistance =
                (currentFuelLevel / consumptionFuel)
                        * formulaNumber;
    }

    @JsonIgnore
    @Override
    public String getHeaders() {
        return super.getHeaders()
                + ",currentFuelLevel,fuelCapacity,consumptionFuel,currentMaxFlyingDistance";
    }

    @Override
    public String toCSV() {
        return super.toCSV()
                + currentFuelLevel + ","
                + fuelCapacity + ","
                + consumptionFuel + ","
                + currentMaxFlyingDistance;
    }
}


