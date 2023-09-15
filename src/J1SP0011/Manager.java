package J1SP0011;
/**
 * Uyen Nguyễn
 * */
public class Manager extends Menu {
    public static final char[] hexDigits = {
            '0', '1', '2', '3', '4', '5', '6', '7',
            '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'
    };

    public Manager() {
        super("Main Menu", new String[]{"Convert From Binary", "Convert From Decimal", "Convert From Hexa", "Exit"});
    }

    @Override
    public boolean execute(int choice) {
        switch (choice) {
            case 1:
                convertFromBinary();
                break;
            case 2:
                convertFromDecimal();
                break;
            case 3:
                convertFromHexa();
                break;
            case 4:
                return true;
        }
        return false;
    }

    public static int displayConvert(String from, String toCase1, String toCase2) {
        System.out.println("1. Convert form " + from + " to " + toCase1);
        System.out.println("2. Convert form " + from + " to " + toCase2);
        System.out.print("Enter your choice: ");
        int result = Validate.checkInputIntLimit(1, 2);
        return result;
    }

    public void convertFromBinary() {
        String binary = Validate.checkInputBinary();
        int choice = displayConvert("binary", "decimal", "hexadecimal");
        switch (choice) {
            case 1:
                System.out.println("Decimal: " + convertBinaryToDecimal(binary));
                break;
            case 2:
                System.out.println("Hexadecimal: " + convertBinaryToHexa(binary));
                break;
        }
    }

    public void convertFromDecimal() {
        String decimal = Validate.checkInputDecimal();
        int choice = displayConvert("decimal", "binary", "hexadecimal");
        switch (choice) {
            case 1:
                System.out.println("Binary: " + convertDecimalToBinary(decimal));
                break;
            case 2:
                System.out.println("Hexadecimal: " + convertDecimalToHexa(decimal));
                break;
        }
    }

    public void convertFromHexa() {
        String hexa = Validate.checkInputHexaDecimal();
        int choice = displayConvert("hexa", "binary", "decimal");
        switch (choice) {
            case 1:
                System.out.println("Binary: " + convertHexaToBinary(hexa));
                break;
            case 2:
                System.out.println("Decimal: " + convertHexaToDecimal(hexa));
                break;
        }
    }

    public static String convertBinaryToDecimal(String binary) {
        int decimal = Integer.parseInt(binary, 2);
        return Integer.toString(decimal);
    }

    public static String convertBinaryToHexa(String binary) {
        String decimal = convertBinaryToDecimal(binary);
        String hexa = convertDecimalToHexa(decimal);
        return hexa;
    }

    public static int convertHexaToDecimal(String hexadecimal) {
        int decimal = Integer.parseInt(hexadecimal, 16);
        return decimal;
    }

    public static String convertHexaToBinary(String hexadecimal) {
        String binary = Integer.toBinaryString(convertHexaToDecimal(hexadecimal));
        return binary;
    }

    public static String convertDecimalToBinary(String decimal) {
        String binary = Integer.toBinaryString(Integer.parseInt(decimal));
        return binary;
    }

    public static String convertDecimalToHexa(String decimal) {
        String hexa = "";
        int deci = Integer.parseInt(decimal);
        while (deci != 0) {
            hexa = hexDigits[deci % 16] + hexa;
            deci /= 16;
        }
        return hexa;
    }


}
