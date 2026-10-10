package testdrive;

import cars.Car;
import cars.CarManager;
import dealership.Dealership;
import dealership.DealershipManager;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TestDriveManager {

    private CarManager carManager = new CarManager();
    private DealershipManager dealershipManager = new DealershipManager();

    List<TestDrive> testDrivesStorage = new ArrayList<>();



    public void add(int carId, int dealershipId, LocalDateTime testDriveStartDateTime, LocalDateTime testDriveEndDateTime) throws Exception {

       List<Car> carsStorage = carManager.getAll();
       List<Dealership> dealershipsStorage = dealershipManager.getAll();

       Car userCar = carsStorage.stream().filter(c -> c.getId() == carId).findFirst().orElseThrow();
       Dealership userDealership = dealershipsStorage.stream().filter(d -> d.getId() == dealershipId).findFirst().orElseThrow();

        // check if the car is available in the car list of the dealership with id = dealershipId

        //check if the userCar is contained in the list of the userDealership cars
        //extract the dealership cars this way:
        //dealership.getCars();
        //if present continue, else throw exception

        //traverse testDrivesStorage
        // filter all test drives where the car is our userCar
        // and check if the useCar is available for the period

        TestDrive first = testDrivesStorage.getFirst();
        boolean isTestDriveStartTimeAfterTheRequested = first.getStartTime().isAfter(testDriveEndDateTime);

    }
}