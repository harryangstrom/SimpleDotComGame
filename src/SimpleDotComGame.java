import java.util.ArrayList;

public class SimpleDotComGame {
    public static void main(String[] args) {
        // final int MAX = 5;
        int numberOfGuesses = 0;
        SimpleDotCom dot = new SimpleDotCom();
        GameHelper helper = new GameHelper();
        ArrayList<Integer> location = helper.getLocation49(4);
        ArrayList<Integer> location1 = helper.getLocation49(4);
        ArrayList<Integer> location2 = helper.getLocation49(4);
/*        int startLocation = (int) Math.floor(Math.random() * MAX + 1);
        ArrayList<Integer> location = new ArrayList<>();
        location.add(startLocation);
        location.add(startLocation + 1);
        location.add(startLocation + 2);*/
        //int[] cells = {startLocation, startLocation + 1, startLocation + 2};
        System.out.println("Localización: " + location.toString());
        //System.out.println("Localización: " + Arrays.toString(cells));
        //dot.setLocationCells(cells);
        dot.setLocationCells(location);
        boolean isAlive = true;

        while (isAlive) {
            String guess = helper.getUserInput("Enter a number:");
            String result = dot.checkYourself(guess);
            System.out.println("you've got a " + result);
            if (!result.equals("NotNumber")) {
                numberOfGuesses++;
            }
            if (result.equals("kill")) {
                isAlive = false;
                System.out.println("You took " + numberOfGuesses + " guesses.");
            }
        }

    }
}
