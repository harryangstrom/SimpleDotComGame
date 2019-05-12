import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class GameHelper {

  private static final int SIZEBLOCK = 7;

  private ArrayList<Integer> cellsOccupied = new ArrayList<>();

  /**
  * Método para recoger el intento del jugador. 
  * @param prompt Cadena de caracteres con el mensaje al jugador.
  * @return String 
  *
  */
  public String getUserInput(String prompt) {
    String inputLine = null;
    System.out.print(prompt + " ");
    try {
      BufferedReader is = new BufferedReader(
                    new InputStreamReader(System.in));
      inputLine = is.readLine();
      if (inputLine.length() == 0) {
        return null;
      }
    } catch (IOException e) {
      System.out.println("IOException: " + e);
    }
    try {
      Integer.parseInt(inputLine);
    } catch (NumberFormatException e) {
      System.out.println("NumberFormatException: " + e);
      return ("NotNumber");
    }
    return inputLine;
  }

  /**
  * Método para calcular la ubicación de los elementos en el grid 7. 
  * @param size Tamaño del elemento a colocar.
  * @return ArrayList of Integer con la ubicación de los size elementos 
  *
  */
  public ArrayList<Integer> getLocation7(int size) {
    int max = SIZEBLOCK - size + 1;
    int startLocation = (int) Math.floor(Math.random() * max + 1);
    ArrayList<Integer> location = new ArrayList<>();
    for (int i = 0; i < size; i++) {
      location.add(startLocation + i);
    }
    return location;
  }

  /**
  * Método para calcular la ubicación de los elementos en el grid 7x7. 
  * @param size Tamaño del elemento a colocar.
  * @return ArrayList of Integer con la ubicación de los size elementos 
  *
  */
  public ArrayList<Integer> getLocation49(int size) {
    boolean isValid = false;
    ArrayList<Integer> location = new ArrayList<>();
    while (!isValid) {
      int startLocation = (int) Math.floor(Math.random() * SIZEBLOCK * SIZEBLOCK + 1);
      System.out.println("Valor startLocation: " + startLocation);
      if (cellsOccupied.contains(startLocation)) {
        System.out.println("Celda ocupada inicio. Continua.");
        continue;
      } else {
        if (startLocation % SIZEBLOCK != 0 && startLocation % SIZEBLOCK + size - 1 <= SIZEBLOCK) {
          //rellenamos en horizontal
          for (int i = 1; i < size; i++) {
            if (cellsOccupied.contains(startLocation + i)) {
              System.out.println("Celda ocupada horizontal. Break.");
              isValid = false;
              break;
            }
            System.out.println("hago isValid = true horizontal");
            isValid = true;
          }
          if (!isValid) {
            System.out.println("!isValid horizontal");
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
                System.out.println("Celda ocupada vertical. Break.");
                isValid = false;
                break;
              }
              isValid = true;
            }
            if (!isValid) {
              System.out.println("!isValid vertical");
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
    System.out.println("Celdas ocupadas: " + cellsOccupied.toString());
    return location;
  }
}
