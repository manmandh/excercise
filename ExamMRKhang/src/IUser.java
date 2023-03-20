import java.util.ArrayList;
public interface IUser{
    void addMoney();
    void convertMoney(ArrayList<User> list, ArrayList<Bank> listBank, Handle handle);
    void getMoneyFromBank();
    void checkMoney();
}

