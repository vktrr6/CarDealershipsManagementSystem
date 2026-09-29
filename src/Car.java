public class Car {

    private String brand;
    private String model;
    private int year;
    private String fuelType;

    public Car(String brand, String model, int year, String fuelType) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.fuelType = fuelType;
    }

    @Override
    public String toString() {
        return String.format("%s - %s - %d - %s", brand, model, year, fuelType);
    }
}