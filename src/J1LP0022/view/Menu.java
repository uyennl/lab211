package J1LP0022.view;

import J1LP0022.control.Manager;

/**
 * Uyen Nguyễn
 * */
public class Menu extends MenuGenaric {
    public Menu(String title, String[] s) {
        super(title, s);
    }

    Manager manager = new Manager();

    @Override
    public boolean execute(int choice) {
        switch (choice) {
            case 1:
                manager.addCandidate(0);
                break;
            case 2:
                manager.addCandidate(1);
                break;
            case 3:
                manager.addCandidate(2);
                break;
            case 4:
                manager.searchCandidate();
                break;
            case 5:
                return true;
            default:
                break;
        }
        return false;
    }

//    Menu menuSearch = new Menu("SEARCH CANDIDATE", new String[]{"Experience", "Fresh", "Internship"}) {
//        @Override
//        public boolean execute(int choice) {
//            switch (choice) {
//                case 1:
//
//                    break;
//                case 2:
//                    break;
//                case 3:
//                    break;
//                case 4:
//                    return true;
//                default:
//                    break;
//            }
//            return false;
//        }
//    };
}