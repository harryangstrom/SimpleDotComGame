import java.util.ArrayList;

public class SimpleDotCom {

    //private int[] location;
    private ArrayList<Integer> location = new ArrayList<>();
    private int hits = 0;
    private String name;
    private int value;
    private Integer cellToRemove;

    String checkYourself(String guess) {
        try {
            value = Integer.parseInt(guess);
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException: " + e);
            return ("NotNumber");
        }

        boolean hit = false;
        for (Integer cell : location) {
            if (value == cell) {
                hits++;
                cellToRemove = cell;
                hit = true;
            }
        }
        if (!hit) {
            return ("miss");
        } else {
            location.remove(cellToRemove);
            System.out.println("Localización: " + location.toString());
            if (location.isEmpty()) {
                return ("kill");
            } else {
                return ("hit");
            }
        }
    }



    void setLocationCells(ArrayList<Integer> location) {
        this.location = location;
    }
}

