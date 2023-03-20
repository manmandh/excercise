import java.util.ArrayList;
import java.util.Scanner;

public class User implements IUser {

    private static int id = 1;
    private String idBank, numberAccount;
    private String name, date;
    private long money;
    private String address;
    private boolean closeness;
    private final Scanner scanner = new Scanner(System.in);

    public User() {

    }

    public User(String idBank, String numberAccount, String name, String date, String address) {
        id++;
        this.idBank = idBank;
        this.numberAccount = numberAccount;
        this.name = name;
        this.date = date;
        this.money = 0;
        this.address = address;
        this.closeness = false;
    }

    @Override
    public void addMoney() {
        while (true) {
            System.out.println("The money what you need to recharge?");
            System.out.print("Enter money: ");
            try {
                long moneyAdd = Long.parseLong(scanner.nextLine());
                if (moneyAdd < 0 || moneyAdd % 1000 != 0) {
                    throw new NumberFormatException();
                } else {
                    this.money += moneyAdd;
                    System.out.println("Recharge money sucessfully!");
                    checkCloseness(this.money);
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid money!! Please recharge again");
            }
        }
    }

    @Override
    public void convertMoney(ArrayList<User> list, ArrayList<Bank> listBank, Handle handle) {
        System.out.println("Choose BankUser");
        Bank otherBank = handle.chooseBank(listBank);
        System.out.print("Enter balance that you need ");
        String account = scanner.nextLine();
        for (User u : otherBank.getListUser()) {
            if (u.getNumberAccount().equals(account)) {
                System.out.print("Enter money that you need ");
                long moneyConvert = 0;
                while (true) {
                    try {
                        moneyConvert = Long.parseLong(scanner.nextLine());
                        if (moneyConvert < 10000 || moneyConvert % 1000 != 0) {
                            throw new NumberFormatException();
                        } else {
                            if(!isCloseness()) {
                                moneyConvert += 2000;
                            }
                            if(this.money - moneyConvert < 50000) {
                                System.out.println("Your account needs at least 50k to maintain the card");
                                if(this.money < moneyConvert) {
                                    System.out.println("Your account does not have enough funds to trade");
                                }
                                return;
                            }
                            this.money -= moneyConvert;
                            u.setMoney(u.getMoney() + moneyConvert);
                            System.out.println("Transfer completed");
                            checkCloseness(this.money);
                            return;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid Money!! Please enter again");
                    }
                }
            }
        }
    }

    @Override
    public void getMoneyFromBank() {
        if(this.money >= 50000) {
            System.out.println("Enter money you need withdraw: ");
            System.out.println("| 1 - 50.000");
            System.out.println("| 2 - 100.000");
            System.out.println("| 3 - 100.000");
            System.out.println("| 4 - 200.000");
            System.out.println("| 5 - 500.000");
            System.out.println("| 6 - 1.000.000");
            System.out.print("Rút: ");
            while (true) {
                int ans = Integer.parseInt(scanner.nextLine());
                long moneyGet;
                switch (ans) {
                    case 1 -> moneyGet = 50000;
                    case 2 -> moneyGet = 100000;
                    case 3 -> moneyGet = 200000;
                    case 4 -> moneyGet = 500000;
                    case 5 -> moneyGet = 1000000;
                    default -> {
                        System.out.println("Invalid!");
                        moneyGet = 0;
                    }
                }
                if(moneyGet != 0) {
                    this.money -= moneyGet;
                    checkCloseness(this.money);
                    break;
                }
            }
        }
        System.out.println("Balance " + this.money);
    }

    @Override
    public void checkMoney() {
        System.out.println("Balance is: " + this.money);
    }

    public void checkCloseness(long money) {
        if (money > 10000000) {
            System.out.println("Membership?");
            setCloseness(true);
        } else {
            System.out.println("Not membership?");
            setCloseness(false);
        }
    }

    @Override
    public String toString() {
        return "Name: " + this.name + "\n" + "Adress: " + this.address + "\n" + "Balance: " + this.money;
    }

    public String getIdBank() {
        return idBank;
    }

    public void setIdBank(String idBank) {
        this.idBank = idBank;
    }

    public String getNumberAccount() {
        return numberAccount;
    }

    public void setNumberAccount(String numberAccount) {
        this.numberAccount = numberAccount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public long getMoney() {
        return money;
    }

    public void setMoney(long money) {
        this.money = money;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isCloseness() {
        return closeness;
    }

    public void setCloseness(boolean closeness) {
        this.closeness = closeness;
    }

    public Scanner getScanner() {
        return scanner;
    }
}
