/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lms;

import java.awt.Color;
import java.awt.event.KeyEvent;
import javax.swing.JTextField;

/**
 *
 * @author JayCee
 */
public class UtilityMethods {

    public enum DefaultFocus {
        GAINED,
        LOST
    }

    public static void NumbersOnly(KeyEvent numOnly) {
        char c = numOnly.getKeyChar();

        if (!Character.isDigit(c) && c != '.' && c != KeyEvent.VK_BACK_SPACE) {
            numOnly.consume();
        }

    }

    public static void TransparentField(JTextField... fields) {
        for (JTextField f : fields) {
            f.setForeground(new Color(255, 255, 255, 100));
        }
    }

    public static void DefaultText(JTextField field, String defaultText, DefaultFocus enumFocus) {
        if (enumFocus == DefaultFocus.GAINED) {
            if (field.getText().equals(defaultText)) {
                field.setText("");
                field.setForeground(new Color(255, 255, 255, 255));
            }
        } else if (enumFocus == DefaultFocus.LOST) {
            if (field.getText().equals("")) {
                field.setText(defaultText);
                field.setForeground(new Color(255, 255, 255, 100));
            }
        }
    }
}
