package J1SP0067.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Manager {

    public void display(String input) {

        HashMap<String, List<Integer>> numberResult = getNumber(input);
        HashMap<String, StringBuilder> characterResult = getCharacter(input);
        System.out.println("-----Result Analysis------");
        System.out.println("Number of characters: " + input.length());
        System.out.println("All characters: " + characterResult.get("allChars"));
        System.out.println("Uppercase characters: " + characterResult.get("upperChars"));
        System.out.println("Lowercase characters: " + characterResult.get("lowerChars"));
        System.out.println("List of numbers: " + numberResult.get("allNumbers"));
        System.out.println("List of even numbers: " + numberResult.get("evenNumbers"));
        System.out.println("List of odd numbers: " + numberResult.get("oddNumbers"));
        System.out.println("List of perfect square numbers: " + numberResult.get("squareNumbers"));
        System.out.println("Special characters: " + characterResult.get("specialChars"));
    }

    public HashMap<String, List<Integer>> getNumber(String input) {
        HashMap<String, List<Integer>> result = new HashMap<>();
        List<Integer> allNumbers = new ArrayList<>();
        List<Integer> evenNumbers = new ArrayList<>();
        List<Integer> oddNumbers = new ArrayList<>();
        List<Integer> squareNumbers = new ArrayList<>();
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            int num = Integer.parseInt(matcher.group());
            allNumbers.add(num);
            if (num % 2 == 0) {
                evenNumbers.add(num);
            } else {
                oddNumbers.add(num);
            }
            double sqrt = Math.sqrt(num);
            if (sqrt == (int) sqrt) {
                squareNumbers.add(num);
            }
        }

        result.put("allNumbers", allNumbers);
        result.put("evenNumbers", evenNumbers);
        result.put("oddNumbers", oddNumbers);
        result.put("squareNumbers", squareNumbers);
        return result;
    }

    public HashMap<String, StringBuilder> getCharacter(String input) {
        HashMap<String, StringBuilder> result = new HashMap<>();
        StringBuilder allChars = new StringBuilder();
        StringBuilder specialChars = new StringBuilder();
        StringBuilder upperChars = new StringBuilder();
        StringBuilder lowerChars = new StringBuilder();
        String charString = input.replaceAll("\\d+", "");
        allChars.append(charString);
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (!Character.isLetterOrDigit(c)) {
                specialChars.append(c);
            }
            if (Character.isUpperCase(c)) {
                upperChars.append(c);
            } else if (Character.isLowerCase(c)) {
                lowerChars.append(c);
            }
        }

        result.put("allChars", allChars);
        result.put("specialChars", specialChars);
        result.put("upperChars", upperChars);
        result.put("lowerChars", lowerChars);
        return result;
    }
}
