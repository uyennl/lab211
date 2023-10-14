
package J1SP0059.common;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import J1SP0059.model.Person;


public class Library {

    Validate validate = new Validate();

    //allow user find person info
    public void findPersonInfo() {
        ArrayList<Person> lp = new ArrayList<>();
        if (lp == null) {
            return;
        }
        String pathFile = validate.checkInputPathFile();
        lp = getListPerson(pathFile);
        double money = validate.checkInputMoney();
        printListPerson(lp, money);
    }

    //allow user copy text to new file
    public void coppyNewFile() {
        String pathFileInput = validate.checkInputPathFile();
        String pathFileOutput = validate.checkInputPathFile();
        String content = getNewContent(pathFileInput);
        System.out.println(content);
        writeNewContent(pathFileOutput, content);
    }

    //get list person by path file
    public ArrayList<Person> getListPerson(String pathFile) {
        ArrayList<Person> lp = new ArrayList<>();
        File file = new File(pathFile);
        //check file exist or not and path must be file
        if (!file.exists() || !file.isFile()) {
            System.err.println("Path doesn't exist");
            return null;
        }
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferReader.readLine()) != null) {
                String[] infoPerson = line.split(";");
                lp.add(new Person(infoPerson[0], infoPerson[1],
                        getSalary(infoPerson[2])));

            }
        } catch (Exception e) {
            System.err.println("Can't read file.");
        }
        return lp;
    }

    //get salary 
    public double getSalary(String salary) {
        double salaryResult = 0;
        try {
            salaryResult = Double.parseDouble(salary);
        } catch (NumberFormatException e) {
            salaryResult = 0;
        } finally {
            return salaryResult;
        }
    }

    //display list person
    public static void printListPerson(ArrayList<Person> lp, double money) {
        System.out.printf("%-20s%-20s%-20s\n", "Name", "Address", "Money");
        for (Person person : lp) {
            if (person.getMoney() >= money) {
                System.out.printf("%-20s%-20s%-20.1f\n", person.getName(),
                        person.getAddress(), person.getMoney());
            }
        }
        Collections.sort(lp);
        System.out.println("Max: " + lp.get(0).getName());
        System.out.println("Min: " + lp.get(lp.size() - 1).getName());
    }

    //get new content
    public String getNewContent(String pathFileInput) {
        ArrayList<String> words = getNewContentAsList(pathFileInput);
        StringBuilder content = new StringBuilder();
        for (String word : words) {
            content.append(word).append(" ");
        }
        return content.toString();
    }

    public ArrayList<String> getNewContentAsList(String pathFileInput) {
        ArrayList<String> newContent = new ArrayList<>();
        File file = new File(pathFileInput);
        try {
            Scanner input = new Scanner(file);
            while (input.hasNext()) {
                String word = input.next();
                newContent.add(word);
            }
        } catch (FileNotFoundException ex) {
            System.err.println("Can't read file");
        }
        return newContent;
    }



    //write new content to file
    public void writeNewContent(String pathFileOutput, String content) {
        FileWriter fileWriter = null;
        File file = new File(pathFileOutput);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        try {
            fileWriter = new FileWriter(file);
            BufferedWriter bufferWriter = new BufferedWriter(fileWriter);
            bufferWriter.write(content);
            bufferWriter.close();
            System.err.println("Write successful");
        } catch (IOException ex) {
            System.err.println("Can’t write file");
        } finally {
            try {
                fileWriter.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }



}
