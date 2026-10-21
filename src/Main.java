import cars.Car;
import cars.CarManager;
import dealership.Dealership;
import dealership.DealershipManager;
import testdrive.TestDriveManager;

import java.time.LocalDate;
import java.time.LocalDateTime;
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

                //back
                case 0 -> {
                    System.out.println("Напускане на програмата...");
                    isRunning = false;
                }

                //dealershipMenu
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

                                System.out.print("Избрахте този автосалон: ");
                                dealershipManager.print(id);

                                System.out.print(
                                        "Искате ли да продължите:\n" +
                                        "1. Да\n" +
                                        "2. Не" +
                                        "\n" +
                                        "Изберете опция: ");

                                int yesNo = Integer.parseInt(scanner.nextLine());

                                switch (yesNo) {

                                    case 1 -> {

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

                                                dealershipManager.editCity(id, dealershipCity);
                                            }
                                        }
                                    }

                                    case 2 -> {}
                                }
                            }

                            //remove
                            case 6 -> {

                                System.out.print("Въведете ID на автосалона: ");
                                int id = Integer.parseInt(scanner.nextLine());

                                System.out.print("Избрахте този автосалон: ");
                                dealershipManager.print(id);

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

                //carMenu
                case 2 -> {

                    boolean carsMenu = true;

                    while (carsMenu) {

                        carsMenu();

                        command = Integer.parseInt(scanner.nextLine());

                        switch (command) {

                            //back
                            case 0 -> carsMenu = false;

                            //add
                            case 1 -> {

                                System.out.print("Въведете бранда на колата: ");
                                String carBrand = scanner.nextLine();

                                System.out.print("Въведете модела на колата: ");
                                String carModel = scanner.nextLine();

                                System.out.print("Въведете годината на колата: ");
                                int carYear = Integer.parseInt(scanner.nextLine());

                                System.out.print("Въведете типа гориво на автосалона: ");
                                String carFuelType = scanner.nextLine();

                                System.out.println("В кой салон искате да я вкарате\n" + "Въведете ID на автосалона: ");
                                int dealershipId = Integer.parseInt(scanner.nextLine());

                                Car car = new Car(carBrand, carModel, carYear, carFuelType);

                                carManager.add(car);
                                carManager.addToDealership(car.getId(), dealershipId);
                            }

                            //printAll
                            case 2 -> {
                                carManager.printAll();
                            }

                            //searchByBrand/Model/Year
                            case 3 -> {

                                System.out.print(
                                        "По какво искате да търсите:\n" +
                                        "1. По бранд\n" +
                                        "2. По модел\n" +
                                        "2. По година\n" +
                                        "\n" +
                                        "Изберете опция: ");

                                int option = Integer.parseInt(scanner.nextLine());

                                switch (option) {

                                    case 1 -> {

                                        System.out.print("Въведете бранд: ");
                                        String carBrand = scanner.nextLine();

                                        List<Car> result = carManager.searchByBrand(carBrand);

                                        for (Car car : result) {
                                            System.out.println(car.toString());
                                        }
                                    }

                                    case 2 -> {

                                        System.out.print("Въведете модел: ");
                                        String carModel = scanner.nextLine();

                                        List<Car> result = carManager.searchByModel(carModel);

                                        for (Car car : result) {
                                            System.out.println(car.toString());
                                        }
                                    }

                                    case 3 -> {

                                        System.out.print("Въведете година: ");
                                        int carYear = Integer.parseInt(scanner.nextLine());

                                        List<Car> result = carManager.searchByYear(carYear);

                                        for (Car car : result) {
                                            System.out.println(car.toString());
                                        }
                                    }
                                }
                            }

                            //edit
                            case 4 -> {

                                System.out.print("Въведете ID на колата: ");
                                int id = Integer.parseInt(scanner.nextLine());

                                System.out.print("Избрахте тази кола: ");
                                carManager.print(id);

                                System.out.print(
                                        "Искате ли да продължите:\n" +
                                        "1. Да\n" +
                                        "2. Не" +
                                        "\n" +
                                        "Изберете опция: ");

                                int yesNo = Integer.parseInt(scanner.nextLine());

                                switch (yesNo) {

                                    case 1 -> {

                                        System.out.print(
                                                "Какво искате да промените:\n" +
                                                "1. Бранд\n" +
                                                "2. Модел\n" +
                                                "3. Година\n" +
                                                "4. Тип гориво\n" +
                                                "\n" +
                                                "Изберете опция: ");

                                        int option = Integer.parseInt(scanner.nextLine());

                                        switch (option) {

                                            case 1 -> {

                                                System.out.print("Въведете нов бранд: ");
                                                String carBrand = scanner.nextLine();

                                                carManager.editBrand(id, carBrand);
                                            }

                                            case 2 -> {

                                                System.out.print("Въведете нов модел: ");
                                                String carModel = scanner.nextLine();

                                                carManager.editModel(id, carModel);
                                            }

                                            case 3 -> {

                                                System.out.print("Въведете нова година: ");
                                                int carYear = Integer.parseInt(scanner.nextLine());

                                                carManager.editYear(id, carYear);
                                            }

                                            case 4 -> {

                                                System.out.print("Въведете нов тип гориво: ");
                                                String carFuelType = scanner.nextLine();

                                                carManager.editFuelType(id, carFuelType);
                                            }
                                        }
                                    }

                                    case 2 -> {}
                                }
                            }

                            //remove
                            case 5 -> {


                            }
                        }
                    }
                }

                //testDriveMenu
                case 3 -> {

                    boolean testDriveMenu = true;

                    while (testDriveMenu) {

                        testDriveMenu();

                        command = Integer.parseInt(scanner.nextLine());

                        switch (command) {

                            //back
                            case 0 -> testDriveMenu = false;

                            //add
                            case 1 -> {

                                System.out.print("Въведете име на клиент: ");
                                String clientName = scanner.nextLine();

                                System.out.print("Въведете ID на автосалона, в който искате да търсите свободни коли: ");
                                int dealershipId = Integer.parseInt(scanner.nextLine());

                                System.out.print("Избрахте този автосалон: ");
                                dealershipManager.print(dealershipId);

                                System.out.print(
                                        "Искате ли да продължите:\n" +
                                        "1. Да\n" +
                                        "2. Не" +
                                        "\n" +
                                        "Изберете опция: ");

                                int yesNo = Integer.parseInt(scanner.nextLine());

                                switch (yesNo) {

                                    case 1 -> {

                                        System.out.print("Въведете ID на автомобила, който желаете: ");
                                        int carId = Integer.parseInt(scanner.nextLine());

                                        System.out.print("Въведете начален час: ");
                                        String input1 = scanner.nextLine();
                                        LocalDateTime userStartTime = LocalDateTime.parse(input1);

                                        System.out.print("Въведете краен час: ");
                                        String input2 = scanner.nextLine();
                                        LocalDateTime userEndTime = LocalDateTime.parse(input2);

                                        testDriveManager.add(clientName, dealershipId, carId, userStartTime, userEndTime);
                                    }

                                    case 2 -> {}
                                }
                            }

                            //printAll
                            case 2 -> {
                                testDriveManager.printAll();
                            }

                            //show
                            case 3 -> {

                                System.out.print("Въведте ID на Test Drive: ");
                                int id = Integer.parseInt(scanner.nextLine());

                                testDriveManager.print(id);
                            }

                            //searchByCar/Dealership/ClientName
                            case 4 -> {

                                System.out.print(
                                        "По какво искате да търсите:\n" +
                                        "1. По кола\n" +
                                        "2. По автосалон\n" +
                                        "3. По име на клиент\n" +
                                        "4. По име на клиент\n" +
                                        "\n" +
                                        "Изберете опция: ");

                                int option = Integer.parseInt(scanner.nextLine());

                                switch (option) {

                                    case 1 -> {

                                        System.out.print("Въведете ID на колата: ");
                                        int carId = Integer.parseInt(scanner.nextLine());

                                        testDriveManager.searchByCar(carManager.search(carId));
                                    }

                                    case 2 -> {

                                        System.out.print("Въведете ID на автосалона: ");
                                        int dealershipId = Integer.parseInt(scanner.nextLine());

                                        testDriveManager.searchByDealership(dealershipManager.search(dealershipId));
                                    }

                                    case 3 -> {

                                        System.out.print("Въведете името на клиента: ");
                                        String clientName = scanner.nextLine();

                                        testDriveManager.searchByClientName(clientName);
                                    }

                                    case 4 -> {

                                        System.out.print("Въведете дата: ");
                                        String date = scanner.nextLine();
                                        LocalDate searchedDate = LocalDate.parse(date);

                                        testDriveManager.searchByDate(searchedDate);
                                    }
                                }
                            }

                            //edit
                            case 5 -> {}

                            //remove
                            case 6 -> {

                                System.out.print("Въведете ID на TestDrive: ");
                                int testDriveId = Integer.parseInt(scanner.nextLine());

                                System.out.print("Избрахте този TestDrive: ");
                                testDriveManager.print(testDriveId);

                                System.out.print(
                                        "Искате ли да продължите:\n" +
                                                "1. Да\n" +
                                                "2. Не" +
                                                "\n" +
                                                "Изберете опция: ");

                                int yesNo = Integer.parseInt(scanner.nextLine());

                                switch (yesNo) {

                                    case 1 -> {

                                        testDriveManager.remove(testDriveId);
                                    }

                                    case 2 -> {}
                                }
                            }
                        }
                    }
                }

                //reference
                case 4 -> {}

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
                "5. Изтрий тест-драйв\n" +
                "0. Назад" +
                "\n" +
                "Изберете опция: ");
    }

    public static void reference() {}
}