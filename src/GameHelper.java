import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class GameHelper {

    private ArrayList<Integer> cellsOccupied = new ArrayList<>();

    public String getUserInput(String prompt) {
        String inputLine = null;
        System.out.print(prompt + " ");
        try {
            BufferedReader is = new BufferedReader(
                    new InputStreamReader(System.in));
            inputLine = is.readLine();
            if (inputLine.length() == 0) return null;
        } catch (IOException e) {
            System.out.println("IOException: " + e);
        }
        return inputLine;
    }

    public ArrayList<Integer> getLocation7(int size) {
        final int SIZEBLOCK = 7;
        int max = SIZEBLOCK - size + 1;
        int startLocation = (int) Math.floor(Math.random() * max + 1);
        ArrayList<Integer> location = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            location.add(startLocation + i);
        }
        return location;
    }

    public ArrayList<Integer> getLocation49(int size) {
        final int SIZEBLOCK = 7;
        boolean isValid = false;
        ArrayList<Integer> location = new ArrayList<>();
        while (!isValid) {
            int startLocation = (int) Math.floor(Math.random() * SIZEBLOCK * SIZEBLOCK + 1);
            if (cellsOccupied.contains(startLocation)) {
                continue;
            } else {
                if (startLocation % SIZEBLOCK != 0 && startLocation % SIZEBLOCK + size - 1 <= SIZEBLOCK) {
                    //rellenamos en horizontal
                    for (int i = 1; i < size; i++) {
                        if (cellsOccupied.contains(startLocation + i)) {
                            break;
                        }
                        isValid = true;
                    }
                    if (!isValid) {
                        continue;
                    } else {
                        //HORIZONTAL
                        for (int i = 0; i < size; i++) {
                            //Se añaden los elementos a la derecha de startLocation, no estando ocupados
                            location.add(startLocation + i);
                            cellsOccupied.add(startLocation + i);
                        }
                    }
                } else {
                    if (startLocation + (size - 1) * SIZEBLOCK <= SIZEBLOCK * SIZEBLOCK) {
                        //rellenamos en vertical
                        for (int i = 1; i < size; i++) {
                            if (cellsOccupied.contains(startLocation + i * 7)) {
                                break;
                            }
                            isValid = true;
                        }
                        if (!isValid) {
                            continue;
                        } else {
                            //VERTICAL
                            for (int i = 0; i < size; i++) {
                                //Se añaden los elementos arriba de startLocation, no estando ocupados
                                location.add(startLocation + i * 7);
                                cellsOccupied.add(startLocation + i * 7);
                            }
                        }
                    }
                }
            }
        }
        System.out.println("Localización: " + location.toString());
        return location;
    }
}
