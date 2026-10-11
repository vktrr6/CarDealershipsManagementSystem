package cars;

import dealership.Dealership;
import dealership.DealershipManager;
import testdrive.TestDrive;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class CarManager {

    private List<Car> carsStorage = new ArrayList<>();



    public void add(Car car) {

        carsStorage.add(car);
    }

    public void addToDealership(int carId, int dealershipId) {

        DealershipManager dealershipManager = new DealershipManager();

        carsStorage.stream()
                .filter(car -> car.getId() == carId)
                .forEach(car -> dealershipManager.addCar(dealershipId, car));
    }

    public void removeFromDealership(int carId, int dealershipId) {

        DealershipManager dealershipManager = new DealershipManager();

        carsStorage.stream()
                .filter(car -> car.getId() == carId)
                .forEach(car -> dealershipManager.removeCar(dealershipId, car));
    }

    public Car search(int id) {

        for (Car car : carsStorage) {

            if (car.getId() == id) {
                return car;
            }
        }

        return null;
    }

    public List<Car> searchByBrand(String brand) {

        List<Car> result = new ArrayList<>();

        for (Car car : carsStorage) {

            if (car.getBrand().equals(brand)) {
                result.add(car);
            }
        }

        return result;
    }

    public List<Car> searchByModel(String model) {

        List<Car> result = new ArrayList<>();

        for (Car car : carsStorage) {

            if (car.getModel().equals(model)) {
                result.add(car);
            }
        }

        return result;
    }

    public List<Car> searchByYear(int year) {

        List<Car> result = new ArrayList<>();

        for (Car car : carsStorage) {

            if (car.getYear() == year) {
                result.add(car);
            }
        }

        return result;
    }

    public void editBrand(int id, String brand) {

        Car car = search(id);

        if (car == null) {
            throw new NoSuchElementException("Car does not exist");
        }

        if (brand == null) {
            throw new IllegalArgumentException("Brand cannot be null");
        }

        car.setBrand(brand);
    }

    public void editModel(int id, String model) {

        Car car = search(id);

        if (car == null) {
            throw new NoSuchElementException("Car does not exist");
        }

        if (model == null) {
            throw new IllegalArgumentException("Model cannot be null");
        }

        car.setModel(model);
    }

    public void editYear(int id, int year) {

        Car car = search(id);

        if (car == null) {
            throw new NoSuchElementException("Car does not exist");
        }

        int currentYear = LocalDate.now().getYear();

        if (year < 1900 || year <= currentYear) {
            throw new IllegalArgumentException("Year cannot be before 1900 or after " + currentYear);
        }

        car.setYear(year);
    }

    public void editFuelType(int id, String fuelType) {

        Car car = search(id);

        if (car == null) {
            throw new NoSuchElementException("Car does not exist");
        }

        if (fuelType == null) {
            throw new IllegalArgumentException("fuelType cannot be null");
        }

        car.setFuelType(fuelType);
    }

    public void remove(int id, Dealership dealership, List<TestDrive> testDrivesStorage) {

        boolean hasTestDrives = testDrivesStorage.stream().anyMatch(t -> t.getCar().getId() == id);

        boolean removedDealer = dealership.getCars().removeIf(c -> c.getId() == id && !hasTestDrives);
        boolean removedCar = carsStorage.removeIf(c -> c.getId() == id && !hasTestDrives);

        if (!removedDealer && !removedCar) {
            throw new NoSuchElementException("Car not found");
        }
    }

    public List<Car> getAll() {

        return carsStorage;
    }
}