import java.util.TreeMap;

public class Converter {
    TreeMap<String, Integer> romanKeyMap = new TreeMap<>();
    TreeMap<Integer, String> arabianKeyMap = new TreeMap<>();

    public Converter() {
        romanKeyMap.put("I", 1);
        romanKeyMap.put("V", 5);
        romanKeyMap.put("X", 10);
        romanKeyMap.put("L", 50);
        romanKeyMap.put("C", 100);
        romanKeyMap.put("D", 500);
        romanKeyMap.put("M", 1000);

        arabianKeyMap.put(1000, "M");
        arabianKeyMap.put(900, "CM");
        arabianKeyMap.put(500, "D");
        arabianKeyMap.put(400, "CD");
        arabianKeyMap.put(100, "C");
        arabianKeyMap.put(90, "XC");
        arabianKeyMap.put(50, "L");
        arabianKeyMap.put(40, "XL");
        arabianKeyMap.put(10, "X");
        arabianKeyMap.put(9, "IX");
        arabianKeyMap.put(5, "V");
        arabianKeyMap.put(4, "IV");
        arabianKeyMap.put(1, "I");
    }

    public String intToRoman(int number) {
        String roman = "";
        int arabianKey;
        do {
            arabianKey = arabianKeyMap.floorKey(number);
            roman += arabianKeyMap.get(arabianKey);
            number -= arabianKey;
        } while (number != 0);
        return roman;


    }
    public int romanToInt(String roman) {
        int end = roman.length() - 1;
        char[] arr = roman.toCharArray();
        int arabian;
        int result = romanKeyMap.get(String.valueOf(arr[end]));
        for (int i = end - 1; i >= 0; i--) {
            arabian = romanKeyMap.get(String.valueOf(arr[i]));

            if (arabian < romanKeyMap.get(String.valueOf(arr[i + 1]))) {
                result -= arabian;
            } else {
                result += arabian;
            }
        }
        return result;
    }
}