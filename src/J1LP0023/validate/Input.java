package J1LP0023.validate;

import J1LP0022.validate.Validator;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.*;
import java.util.function.Predicate;
/**
 * Uyen Nguyễn
 * */
public class Input {
    Input() {
    }

    ;
    static Scanner sc = new Scanner(System.in);
    private static final String ERR_MESSAGE = "Wrong Input ! Please Re-enter ";
    private static final String REGEX_NOT_MATCH = "Input Not Valid ! Please Re-enter ";

    public static String enterString(String mess) {
        String str;
        while (true) {
            System.out.println("Enter " + mess + " :");
            try {
                str = sc.nextLine().trim();

            } catch (NoSuchElementException e) {

                System.out.println(ERR_MESSAGE);
                continue;
            }

            return str;

        }
    }

     public static String enterString(String mess, String regex) {
        String str;
        while (true) {
            System.out.println("Enter " + mess + " :");
            try {
                str = sc.nextLine().trim();

            } catch (NoSuchElementException e) {

                System.out.println(ERR_MESSAGE);
                continue;
            }

            boolean isTrue = Validator.checkRegex(str, regex);
            if (isTrue) {
                return str;
            } else {
                System.out.println(REGEX_NOT_MATCH);
            }

        }
    }
    public static String enterRank(String mess, String[] validValues) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter " + mess + " Rank: ");
        String input = scanner.nextLine();

        while (!Arrays.asList(validValues).contains(input)) {
            System.out.println("Invalid rank. Please try again.");
            System.out.print("Enter " + mess + " Rank: ");
            input = scanner.nextLine();
        }

        return input;
    }

    public static String enterDate(String mess) {
        while (true) {
            System.out.println("Enter " + mess + " :");
            try {
                String dateStr = sc.nextLine().trim();
                if (Validator.isValidDate(dateStr)) {
                    return dateStr;
                }
            } catch (NoSuchElementException e) {
                System.out.println(ERR_MESSAGE);
                continue;

            }
        }
    }

    static public String enterString(String mess, String regex, Predicate<String> duplicate) {
        String str;
        while (true) {
            System.out.println("Enter " + mess + " :");
            try {
                str = sc.nextLine().trim();

            } catch (NoSuchElementException e) {

                System.out.println(ERR_MESSAGE);
                continue;
            }

            boolean isTrue = Validator.checkRegex(str, regex);
            if (isTrue) {
                if (!duplicate.test(str)) {
                    return str;
                } else {
                    System.out.println(mess + " has exist");
                }
            } else {
                System.out.println(REGEX_NOT_MATCH);
            }

        }
    }

    public static int enterInt(String mess, boolean check, Predicate<Integer> duplicate) {
        int intVar;
        while (true) {
            System.out.println("Enter " + mess + " :");
            try {
                intVar = Integer.parseInt(sc.nextLine().trim());

            } catch (NumberFormatException e) {
                System.out.println(ERR_MESSAGE);
                continue;
            }
            if (check) {
                if (intVar < 0) {
                    System.out.println(mess + " must greater than 0");
                } else {
                    if (duplicate.test(intVar)) {
                        System.out.println(mess + " has exist");
                    } else {
                        return intVar;

                    }
                }
            } else {
                return intVar;
            }
        }
    }

    public static int enterInt(String mess, int min,int max) {
        int intVar;
        while (true) {
            System.out.println("Enter " + mess + " :");
            try {
                intVar = Integer.parseInt(sc.nextLine().trim());

            } catch (NumberFormatException e) {
                System.out.println(ERR_MESSAGE);
                continue;
            }
                if (intVar < min || intVar >max) {
                    System.out.println(mess + " must greater than " + min+ " must less than " + max );
                } else {

                    return intVar;

                }
            }
        }


    public static float enterFloat(String Mess, boolean check) {
        float floatVar;
        while (true) {
            System.out.println("Enter " + Mess + " :");
            try {
                floatVar = Float.parseFloat(sc.nextLine().trim());

            } catch (NumberFormatException e) {
                System.out.println(ERR_MESSAGE);
                continue;
            }
            if (check) {
                if (floatVar < 0) {
                    System.out.println(Mess + " must greater than 0");
                } else {
                    return floatVar;
                }
            } else {
                return floatVar;
            }
        }
    }

    public static LocalDate enterDate(String mess, String pattern) {
        LocalDate result;
        while (true) {
            System.out.println("Enter " + mess + ":");
            try {
                String dateStr = sc.nextLine().trim();
                if (!Validator.isValidDate(dateStr)) {
                    throw new ParseException("Invalid Date Format", 0);
                }

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
                formatter.withResolverStyle(ResolverStyle.STRICT);
                LocalDate date = LocalDate.parse(dateStr, formatter);
                result = date;
            } catch (ParseException e) {
                System.out.println(REGEX_NOT_MATCH);
                continue;
            } catch (NoSuchElementException e) {
                System.out.println(ERR_MESSAGE);
                continue;
            } catch (DateTimeParseException e) {
                e.printStackTrace();
                continue;
            }
            return result;
        }
    }

    public static long enterLong(String mess, boolean check) {
        long longVar;
        while (true) {
            System.out.println("Enter " + mess + " :");
            try {
                longVar = Long.parseLong(sc.nextLine().trim());

            } catch (NumberFormatException e) {
                System.out.println(ERR_MESSAGE);
                continue;
            }
            if (check) {
                if (longVar < 0) {
                    System.out.println(mess + " must greater than 0");
                } else {

                    return longVar;

                }
            } else {
                return longVar;
            }
        }
    }
    public static boolean checkInputYN() {
        while (true) {
            String result = sc.nextLine();
            if (result.matches(Validator.REGEX_QUESTION)) {
                return result.equalsIgnoreCase("n");
            }
            System.err.println("Please input y/Y or n/N.");
            System.out.print("Enter again: ");
        }
    }


}

