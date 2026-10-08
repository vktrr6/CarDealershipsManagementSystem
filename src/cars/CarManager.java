package cars;

import dealership.Dealership;

import java.util.ArrayList;
import java.util.List;

public class CarManager {

    private List<Car> carsStorage = new ArrayList<>();



    public void add(Car car, Dealership dealership) {

        dealership.getCars().add(car);
        carsStorage.add(car);
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

        if (car != null) {
            car.setBrand(brand);
        }
    }

    public void editModel(int id, String model) {

        Car car = search(id);

        if (car != null) {
            car.setModel(model);
        }
    }

    public void editYear(int id, int year) {

        Car car = search(id);

        if (car != null) {
            car.setYear(year);
        }
    }

    public void editFuelType(int id, String fuelType) {

        Car car = search(id);

        if (car != null) {
            car.setFuelType(fuelType);
        }
    }

    public void remove(int id, Dealership dealership) {

        dealership.getCars().removeIf(c -> c.getId() == id);
        carsStorage.removeIf(c -> c.getId() == id);
    }

    public List<Car> getAll() {

        return carsStorage;
    }
}