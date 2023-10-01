package J1SP0052.algth;

import J1SP0052.data.Country;
import J1SP0052.data.EAC;
import J1SP0052.validate.Validate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class AlgthIn {

    public Validate val = new Validate();
    //check user input string


    //allow user input infomation of contries
    public void inputCountry(ArrayList<EAC> lc) {
        System.out.print("Enter code of contry: ");
        String countryCode = val.checkInputString();
        //check code contry exist or not
        if (!checkCountryExist(lc, countryCode)) {
            System.err.println("Country exist.");
            return;
        }
        System.out.print("Enter name of contry: ");
        String countryName = val.checkInputString();
        System.out.print("Enter total area: ");
        float countryArea = (float) val.checkInputFloat();
        System.out.print("Enter terrain of contry: ");
        String countryTerrain = val.checkInputString();
        lc.add(new EAC(countryCode, countryName,countryArea,countryTerrain));
        System.err.println("Add successful.");
    }

    //display infomation of country
    public  void printCountry(ArrayList<EAC> lc) {
        System.out.printf("%-10s%-25s%-20s%-25s\n", "ID", "Name", "Total Area",
                "Terrain");
        for (Country country : lc) {
            country.display();
        }
    }

    //display infomation sort name in ascending
    public  void printCountrySorted(ArrayList<EAC> lc) {
        Collections.sort(lc);
        System.out.printf("%-10s%-25s%-20s%-25s\n", "ID", "Name", "Total Area",
                "Terrain");
        for (Country country : lc) {
            country.display();
        }
    }

    //allow user search infomation contry by name
    public void searchByName(ArrayList<EAC> lc) {
        System.out.print("Enter the name you want to search for: ");
        String countryName = val.checkInputString();
        System.out.printf("%-10s%-25s%-20s%-25s\n", "ID", "Name", "Total Area",
                "Terrain");
        for (Country country : lc) {
            if (country.getCountryName().equalsIgnoreCase(countryName)) {
                country.display();
            }
        }
    }

    //check country exist by code
    public  boolean checkCountryExist(ArrayList<EAC> lc, String countryCode) {
        for (Country country : lc) {
            if (country.getCountryCode().equalsIgnoreCase(countryCode)) {
                return false;
            }
        }
        return true;
    }
}
