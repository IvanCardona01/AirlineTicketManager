package utilities;

import javax.swing.*;
import java.awt.*;

public class UtilitiesModule {

    public UtilitiesModule(){ }

    public Boolean showConfirmationMessage(String question, String title) {
        int selection = JOptionPane.showConfirmDialog(null, question, title, JOptionPane.YES_NO_OPTION, 1, getIcon("/resources/icon/exit_door.png", 50, 50));
        Boolean confirmated = selection == JOptionPane.YES_OPTION;
        return confirmated;
    }

    public void printInformativeText(String message) {
        JOptionPane.showMessageDialog(null, message, "ERROR", JOptionPane.INFORMATION_MESSAGE, getIcon("/resources/icon/warning_icon.png", 50, 50));
    }

    public Icon getIcon(String url, int width, int height){
        ImageIcon imageIcon = new ImageIcon(getClass().getResource(url));
        imageIcon = new ImageIcon(imageIcon.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
        return imageIcon;
    }
}
