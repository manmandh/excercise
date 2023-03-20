import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Handle {

    final Scanner scanner = new Scanner(System.in);

    public Handle() {
    }

    public void addUser(ArrayList<Bank> listBank) {
        if (listBank.size() == 0) {
            System.out.println("Not bank!!! Please wait for us updating as soon as possible");
        }
        String name = enterName();
        String date = enterDate();
        String address = enterAddress();
        Bank bank = chooseBank(listBank);
        User user = new User(bank.getId(), randomNumberAccount(), name, date, address);
        System.out.println("You need to recharge Money into Account");
        user.addMoney();
        bank.getListUser().add(user);

    }

    public User getUser(Bank myBank, Scanner scanner) {
        while (true) {
            System.out.println("Enter name: ");
            String name = scanner.nextLine();
            for (User user : myBank.getListUser()) {
                if (user.getName().equalsIgnoreCase(name)) {
                    System.out.println("Name : " + user.getName());
                    System.out.println("Address : " + user.getAddress());
                    System.out.println("Account number : " + user.getNumberAccount());
                    System.out.println("Check account???");
                    System.out.print("Xác nhận tài khoản(1: phải || 0: không): ");
                    while (true) {
                        try {
                            int choice = Integer.parseInt(scanner.nextLine());
                            if (choice == 1) {
                                return user;
                            } else if (choice == 0) {
                                break;
                            } else {
                                throw new NumberFormatException();
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid!! Please enter again");
                        }
                    }
                }
            }
            System.out.println("Invalid !! Not found ");
        }

    }

    public void createBank(ArrayList<Bank> listBank) {
        System.out.println("Enter BankName: ");
        String nameBank = scanner.nextLine();
        System.out.println("Enter ID:  ");
        String id = scanner.nextLine();
        Bank bank = new Bank(id, nameBank);
        listBank.add(bank);
    }

    public void showListBank(ArrayList<Bank> listBank) {
        for (int i = 0; i < listBank.size(); i++) {
            System.out.println(i + ": " + listBank.get(i).getNameBank());
        }
    }

    public Bank chooseBank(ArrayList<Bank> listBank) {
        showListBank(listBank);
        while (true) {
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                if (choice < 0 || choice >= listBank.size()) {
                    throw new NumberE("Invalid");
                } else {
                    return listBank.get(choice);
                }
            } catch (NumberE e) {
                throw new RuntimeException(e);
            }
        }
    }

    private String enterName() {
        System.out.println("Enter Name: ");
        return scanner.nextLine();
    }

    private String enterDate() {
        int year, month, day;
        while (true) {
            System.out.println("Enter name: ");
            try {
                year = Integer.parseInt(scanner.nextLine());
                if (year <= 0 || year > 2023) {
                    throw new NumberFormatException();
                } else break;
            } catch (Exception e) {
                System.out.println("Invalid!! Please enter again");
            }
        }
        while (true) {
            try {
                System.out.println("Enter month: ");
                month = Integer.parseInt(scanner.nextLine());
                if (month <= 0 || month > 12) {
                    throw new NumberFormatException();
                } else break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid!! Please enter again");
            }
        }
        while (true) {
            try {
                System.out.println("Enter day: ");
                day = Integer.parseInt(scanner.nextLine());
                if (!checkDay(year, month, day)) {
                    throw new NumberFormatException();
                } else break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid!! Please enter again");
            }
        }
        return day + "/" + month + "/" + year;
    }

    private boolean checkDay(int year, int month, int day) {
        switch (month) {
            case 1, 3, 5, 7, 8, 10, 12 -> {
                return day > 0 && day < 32;
            }
            case 4, 6, 9, 11 -> {
                return day > 0 && day < 31;
            }
            case 2 -> {
                if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
                    return day > 0 && day < 30;
                } else {
                    return day > 0 && day < 29;
                }
            }
        }
        return false;
    }

    private String enterAddress() {
        System.out.print("Enter address: ");
        return scanner.nextLine();
    }


    private String randomNumberAccount() {
        Random random = new Random();
        int t = 10;
        StringBuilder numberAccount = new StringBuilder();
        while (t > 0) {
            int num = Math.abs(random.nextInt() % 9);
            numberAccount.append(num);
            --t;
        }
        return numberAccount.toString();
    }
}
