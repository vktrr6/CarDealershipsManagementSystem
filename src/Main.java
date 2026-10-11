import cars.Car;
import cars.CarManager;
import dealership.Dealership;
import dealership.DealershipManager;
import testdrive.TestDrive;
import testdrive.TestDriveManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Managers
        DealershipManager dealershipManager = new DealershipManager();
        CarManager carManager = new CarManager();
        TestDriveManager testDriveManager = new TestDriveManager();



        boolean isRunning = true;

        while (isRunning) {

            mainMenu();

            int command = Integer.parseInt(scanner.nextLine());

            switch (command) {

                case 0 -> {
                    System.out.println("Напускане на програмата...");
                    isRunning = false;
                }

                case 1 -> {

                    boolean dealershipMenu = true;

                    while (dealershipMenu) {

                        System.out.println();

                        dealershipMenu();

                        command = Integer.parseInt(scanner.nextLine());

                        switch (command) {
                            //back
                            case 0 -> dealershipMenu = false;
                            //add
                            case 1 -> {

                                System.out.print("Въведете име на автосалона: ");
                                String dealershipName = scanner.nextLine();

                                System.out.print("Въведете град на автосалона: ");
                                String dealershipCity = scanner.nextLine();

                                Dealership dealership = new Dealership(dealershipName, dealershipCity);
                                dealershipManager.add(dealership);
                            }
                            //printAll
                            case 2 -> {
                                dealershipManager.printAll();
                            }
                            //search
                            case 3 -> {

                                System.out.print("Въведете ID на автосалона: ");
                                int id = Integer.parseInt(scanner.nextLine());

                                dealershipManager.print(id);
                            }
                            //searchByName/City
                            case 4 -> {

                                System.out.print(
                                        "По какво искате да търсите:\n" +
                                        "1. По име\n" +
                                        "2. По град\n" +
                                        "\n" +
                                        "Изберете опция: ");

                                int option = Integer.parseInt(scanner.nextLine());

                                switch (option) {

                                    case 1 -> {

                                        System.out.print("Въведете име: ");
                                        String dealershipName = scanner.nextLine();

                                        List<Dealership> result = dealershipManager.searchByName(dealershipName);

                                        for (Dealership dealership : result) {
                                            System.out.println(dealership.toString());
                                        }
                                    }

                                    case 2 -> {

                                        System.out.print("Въведете град: ");
                                        String dealershipCity = scanner.nextLine();

                                        dealershipManager.searchByName(dealershipCity);

                                        List<Dealership> result = dealershipManager.searchByCity(dealershipCity);

                                        for (Dealership dealership : result) {
                                            System.out.println(dealership.toString());
                                        }
                                    }
                                }
                            }
                            //edit
                            case 5 -> {

                                System.out.print("Въведете ID на автосалона: ");
                                int id = Integer.parseInt(scanner.nextLine());

                                dealershipManager.print(id);

                                System.out.print(
                                        "Какво искате да промените:\n" +
                                        "1. Име\n" +
                                        "2. Град\n" +
                                        "\n" +
                                        "Изберете опция: ");

                                int option = Integer.parseInt(scanner.nextLine());

                                switch (option) {

                                    case 1 -> {

                                        System.out.print("Въведете ново име: ");
                                        String dealershipName = scanner.nextLine();

                                        dealershipManager.editName(id, dealershipName);
                                    }

                                    case 2 -> {

                                        System.out.print("Въведете нов град: ");
                                        String dealershipCity = scanner.nextLine();

                                        dealershipManager.editName(id, dealershipCity);
                                    }
                                }
                            }
                            //remove
                            case 6 -> {

                                System.out.print("Въведете ID на автосалона: ");
                                int id = Integer.parseInt(scanner.nextLine());

                                dealershipManager.remove(id);
                            }
                            //addCarToDealership
                            case 7 -> {

                                System.out.print("Въведете ID на колата: ");
                                int carId = Integer.parseInt(scanner.nextLine());

                                System.out.print("Въведете ID на салона: ");
                                int dealershipId = Integer.parseInt(scanner.nextLine());

                                carManager.addToDealership(carId, dealershipId);
                            }
                            //removeCarFromDealership
                            case 8 -> {

                                System.out.print("Въведете ID на колата: ");
                                int carId = Integer.parseInt(scanner.nextLine());

                                System.out.print("Въведете ID на салона: ");
                                int dealershipId = Integer.parseInt(scanner.nextLine());

                                carManager.removeFromDealership(carId, dealershipId);
                            }
                        }
                    }
                }

                case 2 -> {

                    boolean carsMenu = true;

                    while (carsMenu) {

                        carsMenu();

                        command = Integer.parseInt(scanner.nextLine());

                        switch (command) {
                            //back
                            case 0 -> carsMenu = false;
                            //add
                            case 1 -> {}
                            //printAll
                            case 2 -> {}
                            //search
                            case 3 -> {}
                            //edit
                            case 4 -> {}
                            //remove
                            case 5 -> {}
                        }
                    }
                }

                case 3 -> {

                    boolean testDriveMenu = true;

                    while (testDriveMenu) {

                        testDriveMenu();

                        command = Integer.parseInt(scanner.nextLine());

                        switch (command) {

                            case 0 -> testDriveMenu = false;

                            case 1 -> {}

                            case 2 -> {}

                            case 3 -> {}

                            case 4 -> {}

                            case 5 -> {}

                            case 6 -> {}
                        }
                    }
                }

                case 4 -> {//Справки}

                }
            }
        }
    }

    private static void mainMenu() {
        System.out.print(
                "================================\n" +
                "     AUTO DEALERSHIP SYSTEM\n" +
                "================================\n" +
                "\n" +
                "1. Управление на автосалони\n" +
                "2. Управление на автомобили\n" +
                "3. Управление на тест-драйвове\n" +
                "4. Справки\n" +
                "0. Изход\n" +
                "\n" +
                "Изберете опция: ");
    }

    private static void dealershipMenu() {
        System.out.print(
                "===== АВТОСАЛОНИ =====\n" +
                "\n" +
                "1. Добави автосалон\n" +
                "2. Покажи всички автосалони\n" +
                "3. Покажи автосалон\n" +
                "4. Търси автосалон\n" +
                "5. Промени автосалон\n" +
                "6. Изтрий автосалон\n" +
                "7. Добави автомобил към автосалон\n" +
                "8. Премахни автомобил от автосалон\n" +
                "0. Назад\n" +
                "\n" +
                "Изберете опция: ");
    }

    public static void carsMenu() {
        System.out.print(
                "===== АВТОМОБИЛИ =====\n" +
                "\n" +
                "1. Добави автомобил\n" +
                "2. Покажи всички автомобили\n" +
                "3. Търси автомобил\n" +
                "4. Промени автомобил\n" +
                "5. Изтрий автомобил\n" +
                "0. Назад\n" +
                "\n" +
                "Изберете опция: ");
    }

    public static void testDriveMenu() {
        System.out.print(
                "===== ТЕСТ-ДРАЙВОВЕ =====\n" +
                "\n" +
                "1. Добави тест-драйв\n" +
                "2. Покажи всички тест-драйвове\n" +
                "3. Покажи тест-драйв\n" +
                "4. Търси тест-драйв\n" +
                "5. Промени тест-драйв\n" +
                "6. Изтрий тест-драйв\n" +
                "0. Назад" +
                "\n" +
                "Изберете опция: ");
    }

    public static void reference() {}
}