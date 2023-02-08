import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws Exception {
//   Read source data

        System.out.println("введите выражение вида 2 + 3");
        String input = new Scanner(System.in).nextLine();

//   Processing

        System.out.println(calc(input));


//   Display results

    }

    // Метод по заданию
    public static String calc(String input) throws Exception {
// Приводим строку к верхнему регистру и убираем пробелы

        input = input.toUpperCase();
        input = input.replaceAll(" ", "");
        int number1;
        int number2;
        boolean isNumber = true;

        // Делим строку по оператору
        String[] expressionParts = input.split("[+\\-*/]");
//        System.out.println("первый "+expressionParts[0]+"второй "+expressionParts[1]+"длина "+expressionParts.length);

        if (expressionParts.length < 2) throw new Exception("Введите не менее двух чисел");

        else if (expressionParts.length > 2) throw new Exception("Введите не более двух чисел");

        else if (expressionParts.length == 2) {

            try {
                // Проверяем полученные операнды на принадлежность
                // к арабским цифрам
                number1 = Integer.decode((expressionParts[0]));
                number2 = Integer.decode((expressionParts[1]));
            } catch (NumberFormatException e) {
                System.out.println("это не арабские цифры точно");
                isNumber = false;
            }
            if (isNumber) {
                //   выполняем арифметическое действие над числами
//            в арабском формате
                System.out.println("арабские " + input);//+"  " + number1 + "  " + number2);
                number1 = Integer.decode((expressionParts[0]));
                number2 = Integer.decode((expressionParts[1]));

//                Проверяем на сооответствие интервалу от 0до 10
                if (0 < number1 & number1 <= 10 & 0 < number2 & number2 <= 10) {
/*              Возввращаем результат
                    if (input.contains("+")) {
                        System.out.println("плюс " + input + " First " + number1 + " Second " + number2);

                        return String.valueOf(number1 + number2);
                    } else if (input.contains("-")) {
                        System.out.println("минус  " + input + " First " + number1 + " Second " + number2);
                        return String.valueOf(number1 - number2);
                    } else if (input.contains("*")) {
                        System.out.println("умножить " + input + " First " + number1 + " Second " + number2);
                        return String.valueOf(number1 * number2);
                    } else if (input.contains("/")) {
                        System.out.println("делить " + input + " First " + number1 + " Second " + number2);
                        return String.valueOf(number1 / number2);
                    } else {
                        throw new Exception("\"этого не может быть =)))\"");
                    }*/
                    return arabOperation(number1, number2, input);
                } else {
                    throw new Exception("\"используйте числа от 1 до 10 включительно\"");
                }

            } else if (Arrays.asList("I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X").contains(expressionParts[0])) {
//                Проверяем, не римские ли это цифры
                if (Arrays.asList("I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X").contains(expressionParts[1])) {
                    return romanOperation(expressionParts, input);
                } else throw new Exception("введите выражение вида 2 + 3 или IV + X");

            } else throw new Exception("введите выражение вида 2 + 3 или IV + X");

        } else {

            throw new Exception("введите выражение вида 2 + 3");

        }

    }

    public static String romanOperation(String[] expressionParts, String input) throws Exception {

        String[] romanDigits = {
                "0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"
        };
        if (expressionParts[0].equals(romanDigits[0]) | (expressionParts[1].equals(romanDigits[0])) {
            throw new Exception("Римляне не знали нуля");
        }else {

            
        }
    }
        return input;
}


    public static String arabOperation(int number1, int number2, String input) throws Exception {
//        int number1;
//        int number2;


        if (0 < number1 & number1 <= 10 & 0 < number2 & number2 <= 10) {
//              Возввращаем результат
            if (input.contains("+")) {
                System.out.println("плюс " + input + " First " + number1 + " Second " + number2);

                return String.valueOf(number1 + number2);
            } else if (input.contains("-")) {
                System.out.println("минус  " + input + " First " + number1 + " Second " + number2);
                return String.valueOf(number1 - number2);
            } else if (input.contains("*")) {
                System.out.println("умножить " + input + " First " + number1 + " Second " + number2);
                return String.valueOf(number1 * number2);
            } else if (input.contains("/")) {
                System.out.println("делить " + input + " First " + number1 + " Second " + number2);
                return String.valueOf(number1 / number2);
            } else {
                throw new Exception("\"этого не может быть =)))\"");

            }

        }
        return input;
    }
}




