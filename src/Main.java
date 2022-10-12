import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(calc(reader.readLine()));
    }

    public static String calc(String input) throws Exception {
        Converter converter = new Converter();

        String[] splitedInput = input.split(" ");

        if (splitedInput.length != 3){
            throw new Exception();
        }

        int firstNumber;
        int secondNumber;
        int result;

        try {
            firstNumber = Integer.parseInt(splitedInput[0]);
            secondNumber = Integer.parseInt(splitedInput[2]);
            if(firstNumber > 0 && firstNumber < 11 && secondNumber > 0 && secondNumber < 11){
                result = calculation(firstNumber, secondNumber, splitedInput[1]);
                return String.valueOf(result);
            }
        } catch (NumberFormatException e) {
            try {
                firstNumber = converter.romanToInt(splitedInput[0]);
                secondNumber = converter.romanToInt(splitedInput[2]);
                result = calculation(firstNumber, secondNumber, splitedInput[1]);
                return converter.intToRoman(result);
            } catch (Exception b){
                throw new Exception();
            }
        }
        throw new Exception();
    }

    private static int calculation(int firstNumber, int secondNumber, String operand) throws Exception {
        switch (operand){
            case ("/") : return firstNumber / secondNumber;
            case ("*") : return firstNumber * secondNumber;
            case ("+") : return firstNumber + secondNumber;
            case ("-") : return firstNumber - secondNumber;
        }
        throw new Exception();
    }
}