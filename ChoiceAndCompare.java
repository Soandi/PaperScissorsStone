import java.util.ArrayList;
import java.util.Random;

public class ChoiceAndCompare {
    ArrayList<String> botOptions;

    ChoiceAndCompare() {
        botOptions = new ArrayList<>();
        botOptions.add("ножницы");
        botOptions.add("камень");
        botOptions.add("бумага");
    }

    String compare(String userSelect) {
        GeneralGameWindow.setGameCounter();

        String botOp = botOptions.get(new Random().nextInt(botOptions.size()));
        String imgShow = "";
        if (botOp.equals(userSelect)) {
            System.out.println("Ничья");
            imgShow = "draw.png";
        }
        if (botOp.equals("ножницы") && userSelect.equals("камень")) {
            imgShow = "stonebeatsscissorswin.png";
            GeneralGameWindow.setUsersWin();
        }
        if (botOp.equals("ножницы") && userSelect.equals("бумага")) {
            imgShow = "scissorsbeatspaperloose.png";
            GeneralGameWindow.setUserLooses();
        }
        if (botOp.equals("камень") && userSelect.equals("бумага")) {
            imgShow = "paperbeatsstonewin.png";
            GeneralGameWindow.setUsersWin();
        }
        if (botOp.equals("камень") && userSelect.equals("ножницы")) {
            imgShow = "stonebeatsscissorsloose.png";
            GeneralGameWindow.setUserLooses();
        }
        if (botOp.equals("бумага") && userSelect.equals("ножницы")) {
            imgShow = "scissorsbeatspaperwin.png";
            GeneralGameWindow.setUsersWin();
        }
        if (botOp.equals("бумага") && userSelect.equals("камень")) {
            imgShow = "paperbeatsstoneloose.png";
            GeneralGameWindow.setUserLooses();
        }
        return imgShow;
    }
}
