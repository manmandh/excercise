import java.util.ArrayList;
import java.util.Scanner;
public class MainBank {

    public static void DisplayMenu() {
        System.out.println("-----------Please choose function------------");
        System.out.println(" 1.  Add User.     ");
        System.out.println(" 2.  Add money into Account.  ");
        System.out.println(" 3.  Translate Money.   ");
        System.out.println(" 4.  Check Balance.  ");
        System.out.println(" 5.  Withdraw Money.    ");
        System.out.println(" 6.  Sort By Balance.  ");
        System.out.println(" 7.  Total Money.  ");
        System.out.println(" 8.  Create Bank.  ");
        System.out.println(" 9.  Quit.  ");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Handle handle = new Handle();
        ArrayList<Bank> listBank = new ArrayList<>();
        Bank bank;
        User user;
        Scanner scanner = new Scanner(System.in);
        boolean programme = true;
        while (programme){
            MainBank.DisplayMenu();
            int choice = Integer.parseInt(scanner.nextLine());
            try {
                switch (choice) {
                    case 1:
                        handle.addUser(listBank);
                    case 2:
                        bank = handle.chooseBank(listBank);
                        user = handle.getUser(bank, sc);
                        user.addMoney();

                    case 3:
                        bank = handle.chooseBank(listBank);
                        user = handle.getUser(bank, sc);
                        user.convertMoney(bank.getListUser(), listBank, handle);

                    case 4:
                        bank = handle.chooseBank(listBank);
                        user = handle.getUser(bank, sc);
                        user.checkMoney();

                    case 5:
                        bank = handle.chooseBank(listBank);
                        user = handle.getUser(bank, sc);
                        user.getMoneyFromBank();

                    case 6:
                        bank = handle.chooseBank(listBank);
                        sortByMoney(bank.getListUser());

                    case 7:
                        bank = handle.chooseBank(listBank);
                        bank.calTotalMoney();

                    case 8:
                        handle.createBank(listBank);

                    case 9:
                        System.out.println("See you again!!!");
                }
            }
            catch(Exception e){
                System.out.println("Error!! Please restart Menu");
            }
        }
    }
    public static void sortByMoney(ArrayList<User> l) {
        l.sort((o1, o2) -> Long.compare(o2.getMoney(), o1.getMoney()));
        for(User user : l) {
            System.out.println(user);
        }
    }
}
