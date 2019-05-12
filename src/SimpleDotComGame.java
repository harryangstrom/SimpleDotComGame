import java.util.ArrayList;

/**
* Clase SimpelDotComGame 
* Principal con main.
*
*/
public class SimpleDotComGame {
  
  /**
  * Main method inside the app. 
  * @param args parameters for main.
  *
  */
  public static void main(String[] args) {
    int numberOfGuesses = 0;
    ArrayList<SimpleDotCom> arrDotCom = new ArrayList<>();

    arrDotCom.add(new SimpleDotCom("pacman.com"));
    arrDotCom.add(new SimpleDotCom("galaxy.com"));
    arrDotCom.add(new SimpleDotCom("mariobros.com"));

    GameHelper helper = new GameHelper();

    for (SimpleDotCom dotCom : arrDotCom) {
      dotCom.setLocationCells(helper.getLocation49(3));
      System.out.println("Localización de " + dotCom.getname() + " es: " 
          + dotCom.getLocationCells());
    }


    //boolean isAlive = true;
    SimpleDotCom tempDotCom = null;

    while (!arrDotCom.isEmpty()) {
      String guess = helper.getUserInput("Enter a number:");
      if (!guess.equals("NotNumber")) {
        numberOfGuesses++;
      } else {
        continue;
      }
      
      //boolean isAlive = true;
      for (SimpleDotCom dotCom : arrDotCom) {
        String result = dotCom.checkYourself(guess);
        System.out.println("you've got a " + dotCom.getname() + ": " + result);

        if (result.equals("kill")) {
          tempDotCom = dotCom;
          System.out.println("You took " + numberOfGuesses + " guesses.");
        }
      }
      if (tempDotCom != null) {
        arrDotCom.remove(tempDotCom);
        tempDotCom = null;
        System.out.println("DotComs: " + arrDotCom.toString());
      }


    }

    System.out.println("You took in total " + numberOfGuesses + " guesses.");

  }
}
