package ua.lviv.iot.algo.part1.lab2;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor

public class Balloon extends AerialVehicle {
    private int temperatureBalloon;
    private int maxTemperatureBalloon;

    public int addTemperatureBalloon(int amount) {
        if (temperatureBalloon <= maxTemperatureBalloon) {
            temperatureBalloon += amount;
        }
        if (temperatureBalloon + amount > maxTemperatureBalloon) {
            return addTemperatureBalloon(amount);
        }
        System.out.println("Success");
        return temperatureBalloon;
    }

    public int reduceTemperatureBalloon(int amount) {
        if (temperatureBalloon > 0) {
            temperatureBalloon -= amount;
        }
        if (temperatureBalloon - amount < 0) {
            System.out.println("Error");
            return reduceTemperatureBalloon(amount);
        }
        return temperatureBalloon;
    }

    @Override
    public void flyAt(double speedMetersPerMinute, double altitude) {
        setCurrentSpeed(speedMetersPerMinute);
        setCurrentAltitude(altitude);
    }

    @Override
    public String toString() {
        return super.toString() + " temperatureBallon=" + temperatureBalloon + ", maxTemperatureBalloon=" + maxTemperatureBalloon;
    }
}
