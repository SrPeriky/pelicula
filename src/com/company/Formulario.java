package com.company;
import javax.swing.*;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import javax.swing.JScrollPane;

public class Formulario extends JFrame {
    private JPanel panel1;
    private JTextField nombre;
    private JTextArea descripcion;
    private JTextField fecha;
    private JButton saveMovie;
    private JTable table1;
    private JScrollPane scrollPane;
    private Object[][] DatosTabla;
    Pelicula Todo= new Pelicula();

    public Formulario () {
        super("Peliculas");
        setContentPane(panel1);
        this.loadTable();
        saveMovie.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(nombre.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "INGRESE NOMBRE", "ERROR", JOptionPane.ERROR_MESSAGE);
                }else if(descripcion.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "INGRESE DESCRIPCION", "ERROR", JOptionPane.ERROR_MESSAGE);
                }else if(fecha.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "INGRESE FECHA", "ERROR", JOptionPane.ERROR_MESSAGE);
                }else if(JOptionPane.showConfirmDialog(null, "CONFIRMAR REGISTRO", "ACEPTAR", 1)==0){
                    if(!nombre.equals("") && !descripcion.equals("") && !fecha.equals("")){
                        if(Todo.IngresarCliente(nombre.getText(), descripcion.getText(), fecha.getText())){

                        }
                        JOptionPane.showMessageDialog(null, "REGISTRO EXITOSO");
                        nombre.setText("");
                        descripcion.setText("");
                        fecha.setText("");
                        loadTable();
                    }else{
                        JOptionPane.showMessageDialog(null, "ERROR");
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "DEBES CONFIRMAR EL FORMULARIO");
                }
            }
        });

    }

    public void loadTable () {
        String [] Columnas={"Valor", "Nombre","Descripcion","Fecha"};
        DatosTabla = Todo.ConsulMovie();

        table1.setModel(new DefaultTableModel(DatosTabla,Columnas));
        scrollPane = new JScrollPane(table1);
        this.add(scrollPane);
    }

}
