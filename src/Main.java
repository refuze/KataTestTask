import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(calc(reader.readLine()));
    }

    public static String calc(String input) throws Exception {
        String[] splitedInput = input.split(" ");

        if (splitedInput.length != 3){
            throw new Exception();
        }

        int firstNumber;
        int secondNumber;

        try {
            firstNumber = Integer.parseInt(splitedInput[0]);
            secondNumber = Integer.parseInt(splitedInput[2]);
            if(firstNumber > 0 && firstNumber < 10 && secondNumber > 0 && secondNumber < 10){
                return calculation(firstNumber, secondNumber, splitedInput[1]);
            }
        } catch (NumberFormatException e) {
            try {
                firstNumber = Roman.valueOf(splitedInput[0]).getIndex();
                secondNumber = Roman.valueOf(splitedInput[2]).getIndex();
                return Roman.valueOfInt(Integer.parseInt(calculation(firstNumber, secondNumber, splitedInput[1]))).name();
            } catch (Exception b){
                throw new Exception();
            }
        }

        throw new Exception();
    }

    private static String calculation(int firstNumber, int secondNumber, String operand) throws Exception {
        switch (operand){
            case ("/") : return String.valueOf(firstNumber / secondNumber);
            case ("*") : return String.valueOf(firstNumber * secondNumber);
            case ("+") : return String.valueOf(firstNumber + secondNumber);
            case ("-") : return String.valueOf(firstNumber - secondNumber);
        }
        throw new Exception();
    }
}