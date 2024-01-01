package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pangkat extends JFrame {
    private JLabel labelAngka, labelPangkat, labelHasil;
    private JTextField textFieldAngka, textFieldPangkat, textFieldHasil;
    private JButton buttonHitung, buttonReset;

    public Pangkat() {
        setTitle("Program Hitung Pangkat");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        labelAngka = new JLabel("Masukkan Angka:");
        labelPangkat = new JLabel("Masukkan Pangkat:");
        labelHasil = new JLabel("Hasil:");

        textFieldAngka = new JTextField();
        textFieldPangkat = new JTextField();
        textFieldHasil = new JTextField();
        textFieldHasil.setEditable(false);

        buttonHitung = new JButton("Hitung");
        buttonReset = new JButton("Reset");

        setLayout(new GridLayout(4, 2));

        add(labelAngka);
        add(textFieldAngka);
        add(labelPangkat);
        add(textFieldPangkat);
        add(labelHasil);
        add(textFieldHasil);
        add(buttonHitung);
        add(buttonReset);

        buttonHitung.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hitungPangkat();
            }
        });

        buttonReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetFields();
            }
        });
    }

    private void hitungPangkat() {
        try {
            double angka = Double.parseDouble(textFieldAngka.getText());
            double pangkat = Double.parseDouble(textFieldPangkat.getText());

            double hasil = Math.pow(angka, pangkat);
            textFieldHasil.setText(String.valueOf(hasil));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Masukkan angka yang valid", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void resetFields() {
        textFieldAngka.setText("");
        textFieldPangkat.setText("");
        textFieldHasil.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Pangkat().setVisible(true);
            }
        });
    }
}
