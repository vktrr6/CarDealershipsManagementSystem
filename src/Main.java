import cars.Car;
import dealership.Dealership;
import testdrive.TestDrive;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Dealership> dealerships = new ArrayList<>();
        List<Car> cars = new ArrayList<>();
        List<TestDrive> testDrive = new ArrayList<>();

        boolean isRunning = true;

        while (isRunning) {

            mainMenu();

            int command = Integer.parseInt(scanner.nextLine());

            switch (command) {

                case 0 -> isRunning = false;

                case 1 -> {

                    boolean dealershipMenu = true;

                    while (dealershipMenu) {

                        dealershipMenu();

                        command = Integer.parseInt(scanner.nextLine());

                        switch (command) {

                            case 0 -> dealershipMenu = false;

                            case 1 -> {}

                            case 2 -> {}

                            case 3 -> {}

                            case 4 -> {}

                            case 5 -> {}

                            case 6 -> {}

                            case 7 -> {}

                            case 8 -> {}
                        }
                    }
                }

                case 2 -> {

                    boolean carsMenu = true;

                    while (carsMenu) {

                        carsMenu();

                        command = Integer.parseInt(scanner.nextLine());

                        switch (command) {

                            case 0 -> carsMenu = false;

                            case 1 -> {}

                            case 2 -> {}

                            case 3 -> {}

                            case 4 -> {}

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
        System.out.println(
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
        System.out.println(
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
        System.out.println(
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
        System.out.println("" +
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
}