import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
// Get data
        System.out.println("введите выражение вида 2 + 3 или X * VII");
        String input = new Scanner(System.in).nextLine();

//   Processing

        System.out.println(calc(input));


//   Display results

    }

    public static String calc(String input) throws Exception {
// Приводим строку к верхнему регистру и убираем пробелы

        input = input.toUpperCase();
        input = input.replaceAll(" ", "");
        int number1;
        int number2;
        boolean isNumber = true;

        // Делим строку по оператору
        String[] expressionParts = input.split("[+\\-*/]");

        if (expressionParts.length < 2) throw new Exception("Введите не менее двух чисел");
        else if (expressionParts.length > 2) throw new Exception("Введите не более двух чисел");
        else if (expressionParts.length == 2) {
            try {
                // Проверяем полученные операнды на принадлежность
                // к арабским цифрам
                number1 = Integer.decode((expressionParts[0]));
                number2 = Integer.decode((expressionParts[1]));
            } catch (NumberFormatException e) {
//                System.out.println("это не арабские цифры точно");
                isNumber = false;
            }
            if (isNumber) {
//           Если арабские выполняем арифметическое действие над числами
//            в арабском формате
                number1 = Integer.decode((expressionParts[0]));
                number2 = Integer.decode((expressionParts[1]));

//                Проверяем на сооответствие интервалу от 0до 10
                if (0 < number1 & number1 <= 10 & 0 < number2 & number2 <= 10) {
                    return arabOperation(number1, number2, input);
                } else {
                    throw new Exception("\"используйте числа от 1 до 10 включительно\"");
                }
//                Проверяем, не римские ли это цифры в первом операнде
            } else if (Arrays.asList("I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X").contains(expressionParts[0])) {
//                Проверяем, не римские ли это цифры во втором операнде
                if (Arrays.asList("I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X").contains(expressionParts[1])) {
                    return romanOperation(expressionParts, input);
                } else throw new Exception("введите выражение вида 2 + 3 или IV + X");
            } else throw new Exception("введите выражение вида 2 + 3 или IV + X");
        } else {
            throw new Exception("введите выражение вида 2 + 3");
        }
    }

    public static String romanOperation(String[] expressionParts, String input) throws Exception {
        int number1 = 0;
        int number2 = 0;
        String romanResult = null;
        String[] romanDigits = {"0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",
                "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX",
                "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L",
                "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
        };
        if (expressionParts[0].equals(romanDigits[0]) | expressionParts[1].equals(romanDigits[0])) {
            throw new Exception("Римляне не знали нуля");
        } else {
            for (int i = 1; i < 11; i++) {
                if (expressionParts[0].equals(romanDigits[i])) {
                    number1 = i;
                }
                if (expressionParts[1].equals(romanDigits[i])) {
                    number2 = i;
                }
            }
        }
        if (input.contains("+")) {
            romanResult = romanDigits[number1 + number2];
        } else if (input.contains("-")) {
            if (number1 - number2 >= 1) romanResult = romanDigits[number1 - number2];
            else throw new Exception("\"У римлян были только натуральные числа\"");
        } else if (input.contains("/")) {
            if (number1 / number2 >= 1) romanResult = romanDigits[number1 / number2];
            else throw new Exception("\"Результат меньше единицы. У римлян дробей не было\"");
        } else if (input.contains("*")) {
            romanResult = romanDigits[number1 * number2];
        } else {
            throw new Exception("\"этого не может быть =)))\"");
        }
        return romanResult;
    }


    public static String arabOperation(int number1, int number2, String input) throws Exception {
        if (0 < number1 & number1 <= 10 & 0 < number2 & number2 <= 10) {
            if (input.contains("+")) {
                return String.valueOf(number1 + number2);
            } else if (input.contains("-")) {
                return String.valueOf(number1 - number2);
            } else if (input.contains("*")) {
                return String.valueOf(number1 * number2);
            } else if (input.contains("/")) {
                return String.valueOf(number1 / number2);
            } else {
                throw new Exception("\"этого не может быть =)))\"");
            }
        }
        return input;
    }
}