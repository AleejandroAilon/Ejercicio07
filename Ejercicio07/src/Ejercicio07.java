import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ejercicio07 extends JFrame{
    private JTextField nombre;
    private JTextField edad;
    private JButton verificar;

    public Ejercicio07(){
        // Parte para configurar la ventana
        setTitle("Ejercicio en clase 07");
        setSize(350, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Apartado para ingresar la información
        JLabel nameLabel = new JLabel("Nombre: ");
        nameLabel.setBounds(10, 20, 80, 25);
        add(nameLabel);

        nombre = new JTextField();
        nombre.setBounds(13, 45, 150, 25);
        add(nombre);

        // ------------------ Edad ----------------------
        JLabel edadLabel = new JLabel("Edad: ");
        edadLabel.setBounds(10, 70, 100, 20);
        add(edadLabel);

        edad = new JTextField();
        edad.setBounds(13, 95, 150, 25);
        add(edad);

        // ---------------- Botón ---------------------------
        verificar = new JButton("Verificar");
        verificar.setBounds(110, 140, 150, 25);
        add(verificar);

        // ------------ Accion Botón --------------------
        verificar.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e){
               verificarEdad();
           }
        });
    }

    private void verificarEdad(){
        String name = nombre.getText();
        int age;

        try{
            age = Integer.parseInt(edad.getText());
        } catch (NumberFormatException e){
            JOptionPane.showMessageDialog(this, "Ingrese una edad coherente", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if(age < 0 || age > 120){
            JOptionPane.showMessageDialog(this, "Por favor ingresa una edad valida (entre 0 y 120)", "Edad no valida", JOptionPane.WARNING_MESSAGE);
        }else if(age >= 18){
            JOptionPane.showMessageDialog(this, "La persona " + name + " es mayor de edad.", "Resultado", JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(this, "La persona " + name + " es menor de edad", "Resultado", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void main(String[] args){
        Ejercicio07 frame = new Ejercicio07();
        frame.setVisible(true);
    }
}