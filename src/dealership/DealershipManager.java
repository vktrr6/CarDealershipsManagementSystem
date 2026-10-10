package dealership;

import cars.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class DealershipManager {

    private List<Dealership> dealerships = new ArrayList<>();



    public void add(Dealership dealership) {

        dealerships.add(dealership);
    }

    public void printAll() {

        for (Dealership dealership : dealerships) {
            System.out.println(dealership.toString());
        }
    }

    public void print(int id) {

        Dealership dealership = search(id);

            if (dealership == null) {
                throw new NullPointerException("Dealership not found");
            }

        System.out.printf("%s - %s: %n", dealership.getName(), dealership.getCity());

        for (Car car : dealership.getCars()) {
            System.out.println(car.toString());
        }
    }

    public Dealership search(int id) {

        for (Dealership dealership : dealerships) {

            if (dealership.getId() == id) {
                return dealership;
            }
        }

        return null;
    }

    public List<Dealership> searchByName(String name) {

        List<Dealership> result = new ArrayList<>();

        for (Dealership dealership : dealerships) {

            if (dealership.getName().equals(name)) {
                result.add(dealership);
            }
        }

        return result;
    }

    public List<Dealership> searchByCity(String city) {

        List<Dealership> result = new ArrayList<>();

        for (Dealership dealership : dealerships) {

            if (dealership.getCity().equals(city)) {
                result.add(dealership);
            }
        }

        return result;
    }

    public void editName(int id, String name) {

        Dealership dealership = search(id);

        if (dealership == null) {
            throw new NoSuchElementException("Dealership not found");
        }

        if (name == null) {
            throw new IllegalArgumentException("Name cannot be null");
        }

        dealership.setName(name);
    }

    public void editCity(int id, String city) {

        Dealership dealership = search(id);

        if (dealership == null) {
            throw new NoSuchElementException("Dealership not found");
        }

        if (city == null) {
            throw new IllegalArgumentException("City cannot be null");
        }

        dealership.setCity(city);
    }

    public void remove(int id) {

        boolean removed = dealerships.removeIf(d -> d.getId() == id);

        if (!removed) {
            throw new NoSuchElementException("Dealership not found");
        }
    }

    public List<Dealership> getAll() {

        return dealerships;
    }
}