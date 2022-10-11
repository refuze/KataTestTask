import java.util.HashMap;
import java.util.Map;

enum Roman {
    I(1),
    II(2),
    III(3),
    IV(4),
    V(5),
    VI(6),
    VII(7),
    VIII(8),
    IX(9),
    X(10);

    private static Map<Integer, Roman> map = new HashMap<>();

    static {
        for (Roman roman : Roman.values()) {
            map.put(roman.getIndex(), roman);
        }
    }
    private final int index;

    Roman(int index){
        this.index = index;
    }

    public int getIndex(){
        return index;
    }

    public static Roman valueOfInt(int roman) {
        return map.get(roman);
    }
}
