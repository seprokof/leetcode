import java.util.HashMap;
import java.util.Map;

public class Spreadsheet {

    private final Map<String, Integer> cellToVal;

    public Spreadsheet(int rows) {
        cellToVal = new HashMap<>(rows);
    }

    public void setCell(String cell, int value) {
        cellToVal.put(cell, value);
    }

    public void resetCell(String cell) {
        cellToVal.remove(cell);
    }

    public int getValue(String formula) {
        int plusIdx = formula.indexOf('+');
        int leftVal = evaluateValue(formula.substring(1, plusIdx));
        int rightVal = evaluateValue(formula.substring(plusIdx + 1));
        return leftVal + rightVal;
    }

    private int evaluateValue(String refOrVal) {
        if (Character.isLetter(refOrVal.charAt(0))) {
            return cellToVal.getOrDefault(refOrVal, 0);
        } else {
            return Integer.parseInt(refOrVal);
        }
    }

}
