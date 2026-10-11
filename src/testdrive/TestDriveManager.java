package testdrive;

import cars.Car;
import cars.CarManager;
import dealership.Dealership;
import dealership.DealershipManager;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class TestDriveManager {

    private DealershipManager dealershipManager = new DealershipManager();
    private CarManager carManager = new CarManager();

    List<TestDrive> testDrivesStorage = new ArrayList<>();



    public void add(String clientName, int dealershipId, int carId, LocalDateTime userStartTime, LocalDateTime userEndTime) {

        List<Dealership> dealershipsStorage = dealershipManager.getAll();
        List<Car> carsStorage = carManager.getAll();

       Dealership userDealership = dealershipsStorage.stream().filter(d -> d.getId() == dealershipId).findFirst().orElseThrow(() -> new NoSuchElementException("Car not found"));
       Car userCar = carsStorage.stream().filter(c -> c.getId() == carId).findFirst().orElseThrow(() -> new NoSuchElementException("Car not found"));

       boolean hasCar = userDealership.getCars().contains(userCar);

       if (!hasCar) {
           System.out.println("Car not found");
           return;
       }

       if (!userStartTime.isBefore(userEndTime)) {

           System.out.println("Invalid interval");
           return;
       }

        boolean isAvailable = testDrivesStorage.stream()
                .filter(t -> t.getCar().getId() == carId)
                .noneMatch(t -> userStartTime.isBefore(t.getEndTime()) && userEndTime.isAfter(t.getStartTime()));

        if (!isAvailable) {

            System.out.println("Car is already booked");
            return;
        }

        TestDrive testDrive = new TestDrive(clientName, userCar, userDealership, userStartTime, userEndTime);

        testDrivesStorage.add(testDrive);
    }

    public TestDrive search(int id) {

        for (TestDrive testDrive : testDrivesStorage) {
            if (testDrive.getId() == id) {
                return testDrive;
            }
        }

        return null;
    }

    public void print(int id) {

        TestDrive testDrive = search(id);

        if  (testDrive == null) {
            throw new NullPointerException("TestDrive not found");
        }

        System.out.println(testDrive.toString());
    }

    public void printAll() {

        for (TestDrive testDrive : testDrivesStorage) {
            System.out.println(testDrive.toString());
        }

        System.out.println();
    }

    public List<TestDrive> searchByCar(Car car) {

        List<TestDrive> result = new ArrayList<>();

        for (TestDrive testDrive : testDrivesStorage) {

            if (testDrive.getCar().getId() == car.getId()) {
                result.add(testDrive);
            }
        }

        return result;
    }

    public List<TestDrive> searchByDealership(Dealership dealership) {

        List<TestDrive> result = new ArrayList<>();

        for (TestDrive testDrive : testDrivesStorage) {

            if (testDrive.getDealership().getId() == dealership.getId()) {
                result.add(testDrive);
            }
        }

        return result;
    }

    public List<TestDrive> searchByClientName(String clientName) {

        List<TestDrive> result = new ArrayList<>();

        for (TestDrive testDrive : testDrivesStorage) {

            if (testDrive.getClientName().equals(clientName)) {
                result.add(testDrive);
            }
        }

        return result;
    }

    public List<TestDrive> searchByDate(LocalDate searchedDate) {

        List<TestDrive> result = new ArrayList<>();

        for (TestDrive testDrive : testDrivesStorage) {

            LocalDate date = testDrive.getStartTime().toLocalDate();

            if (date.equals(searchedDate)) {
                result.add(testDrive);
            }
        }

        return result;
    }

    public void remove(int id) {

        boolean removed = testDrivesStorage.removeIf(t -> t.getId() == id);

        if (!removed) {
            throw new NoSuchElementException("TestDrive not found");
        }
    }
}