import java.util.ArrayList;
public class Bank {
    private String id;
    private String nameBank;
    private ArrayList<User> listUser;

    public Bank() {

    }

    public Bank(String id, String nameBank) {
        this.id = id;
        this.nameBank = nameBank;
        this.listUser = new ArrayList<>();
    }

    public void calTotalMoney() {
        long totalMoney = 0;
        for(User u : listUser) {
            totalMoney += u.getMoney();
        }
        System.out.println("Total Money " + totalMoney);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNameBank() {
        return nameBank;
    }

    public void setNameBank(String nameBank) {
        this.nameBank = nameBank;
    }

    public ArrayList<User> getListUser() {
        return listUser;
    }

    public void setListUser(ArrayList<User> listUser) {
        this.listUser = listUser;
    }
}
