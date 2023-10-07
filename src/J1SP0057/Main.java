package J1SP0057;

/**
 *
 * @author THAYCACAC
 */
public class Main {


    public static void main(String[] args) {
        //loop until user want to exit
        Manager manager = new Manager();
        while (true) {
            int choice = manager.menu();
            switch (choice) {
                case 1:
                    manager.createNewAccount();
                    break;
                case 2:
                    manager.loginSystem();
                    break;
                case 3:
                    return;
            }
        }
    }
}
