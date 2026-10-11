/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package principal;

/**
 *
 * @author Jurbano
 */
import javax.swing.SwingUtilities;
import controlador.ControladorMundial;
import vista.VistaMundial;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            VistaMundial vista = new VistaMundial();
            new ControladorMundial(vista);
            vista.setVisible(true);
        });
    }
}
