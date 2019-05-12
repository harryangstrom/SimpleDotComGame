import java.util.ArrayList;

public class SimpleDotCom {

  //private int[] location;
  private ArrayList<Integer> location = new ArrayList<>();
  //private int hits = 0;
  private String name;
  private int value;
  private Integer cellToRemove;

  /**
  * Método constructor. 
  * @param name Cadena de caracteres con el nombre del dotcom.
  *
  */
  SimpleDotCom(String name) {
    this.setName(name);
  }


  /**
  * Método para comprobar si el jugador ha acertado. 
  * @param guess Cadena de caracteres con el intento del jugador.
  * @return String conteniendo el resultado del intento
  *
  */
  String checkYourself(String guess) {
    boolean hit = false;
    for (Integer cell : location) {
      if (value == cell) {
        //hits++;
        cellToRemove = cell;
        hit = true;
      }
    }
    if (!hit) {
      return ("miss");
    } else {
      location.remove(cellToRemove);
      System.out.println(name + ": Localización: " + location.toString());
      if (location.isEmpty()) {
        return ("kill");
      } else {
        return ("hit");
      }
    }
  }

  /**
  * Setter del nombre del dotcom. 
  * @param name Cadena de caracteres con el nombre del dotcom.
  *
  */  
  void setName(String name) {
    this.name = name;
  }

  /**
  * Getter del nombre del dotcom. 
  * @return String con el nombre del dotcom
  *
  */  
  String getname() {
    return name;
  }

  /**
  * Setter de la ubicación del dotcom. 
  * @param location ArrayList de integer con las ubicaciones del dotcom.
  *
  */  
  void setLocationCells(ArrayList<Integer> location) {
    this.location = location;
  }

  /**
  * Getter de la ubicación del dotcom.
  * @return ArrayList de Integer con las ubicaciones del dotcom. 
  *
  */
  ArrayList<Integer> getLocationCells() {
    return location;
  }
}

