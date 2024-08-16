import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GeneralGameWindow extends JFrame implements ActionListener {
    private static String userName;
    private static int userWins = 0;
    private static int gameCounter = 0;
    private static int userLooses = 0;
    static String pathToResources = "resources/images/";
    static String pathToResourcesAudio = "resources/sound/";

    JLabel Stone;
    JLabel Scissors;
    JLabel Paper;
    JLabel showScore;

    static void setUsersWin() {
        userWins += 1;
    }

    static void setGameCounter() {
        gameCounter += 1;
    }

    static void setUserLooses() {
        userLooses += 1;
    }

    static void setNamer(String n) {
        userName = n;
    }

    static String getNamer() {
        return userName;
    }

    static int getScoreCounter() {
        return gameCounter;
    }

    static int getScoreUser() {
        return userWins;
    }

    static int getScoreBot() {
        return userLooses;
    }

    GeneralGameWindow(String title) {
        super(title);
        int width = 647;
        int height = 405;
        int posX = 500;
        int posY = 500;
        setBounds(posX, posY, width, height);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        ImageIcon img = new ImageIcon(pathToResources + "icon.jpg");
        setIconImage(img.getImage());
        setContentPane(new Background(pathToResources + "bg.jpg"));
        setLayout(null);
        setResizable(false);

        new Thread(() -> AudioPlayer.playBackgroundMusic(pathToResourcesAudio + "gamebg.wav")).start();

        ImageIcon imgLink = new ImageIcon(pathToResources + "draw.png");
        JLabel jResult = new JLabel(imgLink);
        jResult.setBounds(200, 80, 239, 246);
        jResult.setVisible(false);
        add(jResult);

        showScore = new JLabel("Партий: 0 | " + getNamer() + ": 0 | Бот: 0");
        showScore.setBounds(350, 10, 300, 30);
        showScore.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 15));
        showScore.setForeground(Color.WHITE);
        add(showScore);

        ImageIcon imgStone = new ImageIcon(pathToResources + "imgStone.png");
        Stone = new JLabel(imgStone);
        Stone.setBounds(10, 10, 118, 120);
        Stone.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                String uLink = new ChoiceAndCompare().compare("камень");
                jResult.setIcon(new ImageIcon(pathToResources + uLink));
                jResult.setVisible(true);
                showScore.setText("Партий: " + getScoreCounter() + " | " + getNamer() + ": " + getScoreUser() + " | Бот: " + getScoreBot());

                Timer timer = new Timer(3000, (event) -> jResult.setVisible(false));
                timer.setRepeats(false);
                timer.start();

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                ImageIcon xc = new ImageIcon(pathToResources + "imgStone2.png");
                Stone.setIcon(xc);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                Stone.setIcon(imgStone);
            }
        });
        add(Stone);

        ImageIcon imgScissors = new ImageIcon(pathToResources + "imgScissors.png");
        Scissors = new JLabel(imgScissors);
        Scissors.setBounds(10, Stone.getHeight() + 20, 142, 95);
        Scissors.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                String uLink = new ChoiceAndCompare().compare("ножницы");
                jResult.setIcon(new ImageIcon(pathToResources + uLink));
                jResult.setVisible(true);
                showScore.setText("Партий: " + getScoreCounter() + " | " + getNamer() + ": " + getScoreUser() + " | Бот: " + getScoreBot());
                Timer timer = new Timer(3000, (event) -> jResult.setVisible(false));
                timer.setRepeats(false);
                timer.start();

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                ImageIcon xc = new ImageIcon(pathToResources + "imgScissors2.png");
                Scissors.setIcon(xc);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                ImageIcon xc = new ImageIcon(pathToResources + "imgScissors.png");
                Scissors.setIcon(xc);
            }
        });

        add(Scissors);


        JLabel author = new JLabel("© Разработчик: Чиркунов Александр");
        author.setBounds(350, 330, 300, 30);
        author.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 15));
        author.setForeground(Color.WHITE);
        author.setVisible(true);
        add(author);

        Timer authT = new Timer(3000, (event) -> author.setVisible(false));
        authT.setRepeats(false);
        authT.start();

        ImageIcon imgPaper = new ImageIcon(pathToResources + "imgPaper.png");
        Paper = new JLabel(imgPaper);
        Paper.setBounds(10, Scissors.getHeight() + Stone.getHeight() + 40, 138, 100);
        Paper.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                String uLink = new ChoiceAndCompare().compare("бумага");
                jResult.setIcon(new ImageIcon(pathToResources + uLink));
                jResult.setVisible(true);
                showScore.setText("Партий: " + getScoreCounter() + " | " + getNamer() + ": " + getScoreUser() + " | Бот: " + getScoreBot());

                Timer timer = new Timer(3000, (event) -> jResult.setVisible(false));
                timer.setRepeats(false);
                timer.start();

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                ImageIcon xc = new ImageIcon(pathToResources + "imgPaper2.png");
                Paper.setIcon(xc);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                ImageIcon xc = new ImageIcon(pathToResources + "imgPaper.png");
                Paper.setIcon(xc);
            }
        });

        add(Paper);
        setLocationRelativeTo(null);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
