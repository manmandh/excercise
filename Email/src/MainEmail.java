import java.util.Scanner;
public class MainEmail {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Input email:  ");
                String email = scanner.nextLine();
                if(!email.matches("^[a-zA-Z0-9]+(@)+([a-zA-Z0-9]+)+((\\.)+([a-z])+)+$")) {
                    throw new EmailException("Invalid Email!!!");
                }
                else {
                    System.out.println("Valid Email!!! ");
                    try {
                        System.out.println("Do you want to update?(y/n)");
                        String check = scanner.nextLine();
                        if(check.equalsIgnoreCase("n")) {
                            System.out.println("See you again!");
                            return;
                        } else if(!check.equalsIgnoreCase("y")){
                            throw new EmailReponse();
                        }
                    } catch (EmailReponse checkE) {
                        System.out.println(checkE.getMessage());
                    }
                }
            } catch (EmailException emailException) {
                System.out.println(emailException.getMessage());
            }
        }
    }
}

