package cars;

public class Car {

    private static int nextId = 1;

    private int id;
    private String brand;
    private String model;
    private int year;
    private String fuelType;

    public Car(String brand, String model, int year, String fuelType) {
        this.id = nextId++;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.fuelType = fuelType;
    }



    //Getters
    public int getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public String getFuelType() {
        return fuelType;
    }



    //Setters
    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }



    @Override
    public String toString() {
        return String.format("%s - %s - %d - %s", brand, model, year, fuelType);
    }
}