package testdrive;

import cars.Car;
import dealership.Dealership;

import java.time.LocalDateTime;

public class TestDrive {

    private static int nextId = 1;

    private int id;
    private String clientName;
    private Car car;
    private Dealership dealership;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public TestDrive(String clientName, Car car, Dealership dealership, LocalDateTime startTime, LocalDateTime endTime) {
        this.id = nextId++;
        this.clientName = clientName;
        this.car = car;
        this.dealership = dealership;
        this.startTime = startTime;
        this.endTime = endTime;
    }



    //Getters
    public int getId() {
        return id;
    }

    public String getClientName() {
        return clientName;
    }

    public Car getCar() {
        return car;
    }

    public Dealership getDealership() {
        return dealership;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }



    //Setters
    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void setDealership(Dealership dealership) {
        this.dealership = dealership;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }



    @Override
    public String toString() {
        return String.format("Client %s has a test drive with ID: %d. in %s with %s from %s to %s.",clientName, id, dealership.getName(), car.toString(), startTime, endTime);
    }
}