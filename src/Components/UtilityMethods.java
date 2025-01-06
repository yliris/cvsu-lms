/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Components;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
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

    public static void TransparentField2(JTextField... fields) {
        for (JTextField f : fields) {
            f.setForeground(new Color(102, 102, 102, 100));
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

    public static void DefaultText2(JTextField field, String defaultText, DefaultFocus enumFocus) {
        if (enumFocus == DefaultFocus.GAINED) {
            if (field.getText().equals(defaultText)) {
                field.setText("");
                field.setForeground(new Color(102, 102, 102, 255));
            }
        } else if (enumFocus == DefaultFocus.LOST) {
            if (field.getText().equals("")) {
                field.setText(defaultText);
                field.setForeground(new Color(102, 102, 102, 100));
            }
        }
    }

    public static int getUserID(String column_return, String table_name, String fetch_column, String fetch_string) {
        String query = "SELECT " + column_return + " FROM " + table_name + " WHERE " + fetch_column + " = " + fetch_string;
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lms_project", "root", "")) {
            PreparedStatement pst = con.prepareStatement(query);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                return rs.getInt(column_return);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), "Database connection failed: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        return 0;
    }

}
