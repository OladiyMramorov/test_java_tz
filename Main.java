import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static char znak;
    static int num1, num2;
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        //String [] znak = {"+","-","*","/"};
        System.out.println("Введите выражение: ");
        String userInput = scanner.nextLine();
        //int num1, num2;
        /*int znakIn = -1;
        for (int i = 0; i < znak.length; i++) {
            if (userInput.contains(znak[i])){
                znakIn = i;
                break;
            }
        }
        if (znakIn==-1){
            throw new Exception("строка не является математической операцией");
        }*/

        char[] oper_char = new char[5];
        for (int i = 0; i < userInput.length(); i++) {
            oper_char[i] = userInput.charAt(i);
            if (oper_char[i] == '+') {
                znak = '+';
            }
            if (oper_char[i] == '-') {
                znak = '-';
            }
            if (oper_char[i] == '*') {
                znak = '*';
            }
            if (oper_char[i] == '/') {
                znak = '/';
            }

        }

       // String [] regznak = {"\\+","-","\\*","/"};
        //String oper_charString = String.valueOf(oper_char);

        String [] signs = userInput.split("[+-/*]");
        String a = signs[0];
        String b = signs[1];
        int result;
        num1 = romanToNumber(a);
        num2 = romanToNumber(b);
        if (num1 < 0 && num2 < 0) {
            result =0;}
        else {
            result = calc(num1, num2, znak);
            String resultRoman = convertNumToRoman(result);
            System.out.println(a + " " + znak + " " + b + " = " + resultRoman);
        }
        num1 = Integer.parseInt(a);
        num2 = Integer.parseInt(b);
        if (num1>10 || num2>10)
        {
            throw new Exception("Формат математической операции не удовлетворяет заданию");
        }
        result = calc(num1, num2, znak);
        System.out.println(num1 + " " + znak + " " + num2 + " = " + result);
    }



    private static String convertNumToRoman (int numArabian) {
        String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
        };
        final String s = roman[numArabian];

        return s;
    }


    private static int romanToNumber (String roman) {
        try {
            switch (roman) {
                case "I":
                    return 1;
                case "II":
                    return 2;
                case "III":
                    return 3;
                case "IV":
                    return 4;
                case "V":
                    return 5;
                case "VI":
                    return 6;
                case "VII":
                    return 7;
                case "VIII":
                    return 8;
                case "IX":
                    return 9;
                case "X":
                    return 10;
            }
        } catch (InputMismatchException e) {
            throw new InputMismatchException("Неверный формат данных");
        }
        return -1;
    }

    public static int calc (int num1, int num2, char op) {
        int result = 0;
        switch (op) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                try {
                    result = num1 / num2;
                } catch (ArithmeticException | InputMismatchException e) {
                    System.out.println("Exception : " + e);
                    System.out.println("Допускаются только целые числа");

                    break;
                }
                break;

        }
        return result;
    }
}


