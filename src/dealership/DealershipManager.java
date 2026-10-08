package dealership;

import cars.Car;

import java.util.ArrayList;
import java.util.List;

public class DealershipManager {

    private List<Dealership> dealerships = new ArrayList<>();



    public void add(Dealership dealership) {

        dealerships.add(dealership);
    }

    public void showAll() {

        for (Dealership dealership : dealerships) {
            System.out.println(dealership.toString());
        }
    }

    public void show(int id) {

        for (Dealership dealership : dealerships) {

            if (dealership.getId() == id) {

                System.out.printf("%s - %s: \n", dealership.getName(), dealership.getCity());

                for (Car car : dealership.getCars()) {
                    System.out.println(car.toString());
                }
            }
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

        if (dealership != null) {
            dealership.setName(name);
        }
    }

    public void editCity(int id, String city) {

        Dealership dealership = search(id);

        if (dealership != null) {
            dealership.setCity(city);
        }
    }

    public void remove(int id) {

        dealerships.removeIf(d -> d.getId() == id);
    }

    public List<Dealership> getAll() {

        return dealerships;
    }
}