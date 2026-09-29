import java.util.ArrayList;

public class Dealership {

    private static int nextId = 1;

    private int id;
    private String name;
    private String city;
    private ArrayList<Car> cars;

    public Dealership(String name, String city) {
        this.id = nextId++;
        this.name = name;
        this.city = city;
        this.cars = new ArrayList<>();
    }



    //Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public ArrayList<Car> getCars() {
        return cars;
    }



   //Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setCity(String city) {
        this.city = city;
    }



    public void addCar(Car car) {
        cars.add(car);
    }



    @Override
    public String toString() {
        return String.format("%d. %s - %s - %d автомобила", id, name, city, cars.size());
    }
}