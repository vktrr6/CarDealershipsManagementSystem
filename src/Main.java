import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Dealership> dealerships = new ArrayList<>();

//        Dealership dealership1 = new Dealership("AutoHouse Plovdiv", "Plovdiv");
//        dealerships.add(dealership1);
//
//        Car car1 = new Car("BMW", "3", 2020, "Diesel");
//        Car car2 = new Car("Mercedes", "C-Class", 2022, "Petrol");
//        Car car3 = new Car("Toyota", "Auris", 2019, "Gas");
//
//        dealership1.addCar(car1);
//        dealership1.addCar(car2);
//        dealership1.addCar(car3);
//
//        Dealership dealership2 = new Dealership("AutoMotors Stara Zagora", "Stara Zagora");
//        dealerships.add(dealership2);
//
//        Car car4 = new Car("Toyota", "Supra", 2010, "Petrol");
//        Car car5 = new Car("Nissan", "GTR", 2012, "Petrol");
//
//        dealership2.addCar(car4);
//        dealership2.addCar(car5);
//
//        Dealership dealership3 = new Dealership("PloAuto", "Plovdiv");
//        dealerships.add(dealership3);
//
//        Car car6 = new Car("BMW", "2", 2007, "Diesel");
//
//        dealership3.addCar(car6);
//
//        showAllDealerships(dealerships);
//
//        searchByCity(dealerships, "Plovdiv");
//
//        searchByName(dealerships, "AutoMotors Stara Zagora");
    }

    public static void showAllDealerships(ArrayList<Dealership> dealerships) {

        for (Dealership dealership : dealerships) {
            System.out.println(dealership.toString());
        }
    }

    public static void searchByCity(ArrayList<Dealership> dealerships, String city) {

        for (Dealership dealership : dealerships) {

            if (dealership.getCity().equals(city)) {
                System.out.println(dealership.toString());
            }
        }
    }

    public static void searchByName(ArrayList<Dealership> dealerships, String name) {

        for (Dealership dealership : dealerships) {

            if (dealership.getName().equals(name)) {
                System.out.println(dealership.toString());
            }
        }
    }
}