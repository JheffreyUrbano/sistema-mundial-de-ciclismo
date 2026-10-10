/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

/**
 *
 * @author Daniel
 */

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import modelo.*;

public class VistaMundial extends JFrame {
    private JTextField txtNombre = new JTextField(10);
    private JTextField txtEdad = new JTextField(10);
    private JTextField txtPais = new JTextField(10);
    private JTextField txtRanking = new JTextField(10);
    private JTextField txtEstatura = new JTextField(10);
    private JTextField txtPeso = new JTextField(10);
    private JTextField txtPuntos = new JTextField(8);
    private JCheckBox chkMedalla = new JCheckBox("Ganó medalla");
    private JButton btnAgregar = new JButton("Agregar");
    private JButton btnLimpiar = new JButton("Limpiar");
    private JButton btnActualizar = new JButton("Actualizar ranking");

    private DefaultTableModel modelo = new DefaultTableModel(
            new String[]{"#", "Nombre", "Edad", "País", "Ranking", "Estatura", "Peso"}, 0) {
        @Override
        public boolean isCellEditable(int fila, int columna) {
            return false;
        }
    };
    private JTable tabla = new JTable(modelo);

    public VistaMundial() {
        super("Mundial - Competidores");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout(8, 8));

        // Formulario
        JPanel form = new JPanel(new GridLayout(3, 4, 6, 6));
        form.setBorder(BorderFactory.createTitledBorder("Datos del competidor"));
        form.add(new JLabel("Nombre:"));       form.add(txtNombre);
        form.add(new JLabel("Edad:"));         form.add(txtEdad);
        form.add(new JLabel("País:"));         form.add(txtPais);
        form.add(new JLabel("Ranking:"));      form.add(txtRanking);
        form.add(new JLabel("Estatura (m):")); form.add(txtEstatura);
        form.add(new JLabel("Peso (kg):"));    form.add(txtPeso);

        JPanel botones = new JPanel(new FlowLayout(FlowLayout.CENTER));
        botones.add(btnAgregar);
        botones.add(btnLimpiar);

        JPanel norte = new JPanel(new BorderLayout());
        norte.add(form, BorderLayout.CENTER);
        norte.add(botones, BorderLayout.SOUTH);

        // Panel para actualizar ranking
        JPanel sur = new JPanel(new FlowLayout(FlowLayout.CENTER));
        sur.setBorder(BorderFactory.createTitledBorder("Actualizar ranking del seleccionado"));
        sur.add(new JLabel("Puntos:"));
        sur.add(txtPuntos);
        sur.add(chkMedalla);
        sur.add(btnActualizar);

        tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        add(norte, BorderLayout.NORTH);
        add(new JScrollPane(tabla), BorderLayout.CENTER);
        add(sur, BorderLayout.SOUTH);

        setSize(760, 520);
        setLocationRelativeTo(null);
    }

    public void cargarTabla(Competidor[] lista, int cantidad) {
        modelo.setRowCount(0);
        for (int i = 0; i < cantidad; i++) {
            Competidor c = lista[i];
            modelo.addRow(new Object[]{i + 1, c.getNombre(), c.getEdad(), c.getPais(),
                    c.getRanking(), c.getEstatura(), c.getPeso()});
        }
    }

    public void limpiarFormulario() {
        txtNombre.setText("");
        txtEdad.setText("");
        txtPais.setText("");
        txtRanking.setText("");
        txtEstatura.setText("");
        txtPeso.setText("");
        txtPuntos.setText("");
        chkMedalla.setSelected(false);
    }

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }

    public String getNombre() { return txtNombre.getText(); }
    public String getEdad() { return txtEdad.getText(); }
    public String getPais() { return txtPais.getText(); }
    public String getRanking() { return txtRanking.getText(); }
    public String getEstatura() { return txtEstatura.getText(); }
    public String getPeso() { return txtPeso.getText(); }
    public String getPuntos() { return txtPuntos.getText(); }
    public boolean isMedalla() { return chkMedalla.isSelected(); }
    public int getFilaSeleccionada() { return tabla.getSelectedRow(); }
    public JButton getBtnAgregar() { return btnAgregar; }
    public JButton getBtnActualizar() { return btnActualizar; }
    public JButton getBtnLimpiar() { return btnLimpiar; }
}