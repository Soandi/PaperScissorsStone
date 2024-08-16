import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class UserNameInput extends JTextField {
    UserNameInput(int x, int y, int w, int h) {
        setBounds(x, y, w, h);
        setFont(new Font("Arial", Font.PLAIN, 19));
    }
}

public class AuthWindow extends JFrame implements ActionListener{
    AuthWindow(String okno) {
            super(okno);
            int width = 647;
            int height = 405;
            setLocationRelativeTo(null);
            setSize(width, height);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            ImageIcon img = new ImageIcon(GeneralGameWindow.pathToResources + "icon.jpg");
            setIconImage(img.getImage());
            setContentPane(new Background(GeneralGameWindow.pathToResources+"bg.jpg"));
            setLayout(null);
            setResizable(false);

            JLabel usNameInfo = new JLabel("Пожалуйста, введите имя Игрока");
            UserNameInput uName = new UserNameInput(180, 100, 300, 40);
            JButton usBn = new JButton("Войти в игру");


            usNameInfo.setBounds(180, 50, 300, 40);
            usNameInfo.setForeground(Color.WHITE);
            usNameInfo.setFont(new Font("Arial", Font.BOLD, 16));
            add(usNameInfo);

            add(uName);

            usBn.setBounds(230, 170, 200, 40);
            usBn.setFocusPainted(false);


            usBn.addActionListener(event -> {
                if (uName.getText() != null) {
                    GeneralGameWindow.setNamer(uName.getText());
                    dispose();
                    new GeneralGameWindow("Игра камень ножницы бумага. Игрок: " + GeneralGameWindow.getNamer());

                }
            });
            add(usBn);
            setLocationRelativeTo(null);
            setVisible(true);
        }

        @Override
        public void actionPerformed(ActionEvent e) {

        }
}
