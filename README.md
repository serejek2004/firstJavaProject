#LEVEL I

Create an abstract class AbstractDrone that will have the following fields:
currentSpeed ​​- current speed of transport;
currentAltitude - current altitude above sea level;

Implement two descendant classes: ElectroDrone and PetrolDrone.
Add the abstract method getMaxFlyingDistanceAtCurrentSpeed(); to the parent class

For all classes, you should implement the conversion of the object into a string representation (the use of the @ToString annotation from the lombok library is preferred)

Also create an DroneManager class to demonstrate how the created classes work. In the main() method, create class objects by adding them to the list (List) parameterized by type AbstractDrone and output them to the console using a for-each loop.

#LEVEL II

For the task described in the first level, you should add:

A method that allows you to add a new object in the DroneManager class, which is a descendant of the addDrone abstract class.

Two object search methods in the DroneManager class
For example, it can be a method to find all Drones that fly faster than a given speed -findAllWithSpeedGreaterThan(double currentSpeed)

Search methods should use streams and lambda expressions

#LEVEL III

Create UML diagram.