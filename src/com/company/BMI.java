package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class BMI {
    private JTextField textField;
    private JFrame frame;

    public BMI(){
        textField = new JTextField(10);
        frame = new JFrame("محاسبه گر BMI");
    }

    public static void main(String[] args) {
        BMI bmi = new BMI();
        bmi.getBMI();

    }

    public void getBMI(){

        // frame settings
        frame.setBounds(200,200,300,200);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);

        // high

        // labels settings
        JLabel label = new JLabel("قد خود را وارد کنید");
        label.setFont(new Font("label", Font.PLAIN , 15));
        JLabel label2 = new JLabel("cm");
        label2.setFont(new Font("font" ,Font.BOLD, 17));

        // button settings
        JButton button = new JButton("Ok");
        button.setBounds(210,120,50,35);


        // panel settings
        JPanel panel = new JPanel();
        panel.add(label);
        panel.add(textField);
        panel.add(label2);

        // weight
        JLabel label3 = new JLabel("وزن خود را وارد کنید");
        label3.setFont(new Font("label", Font.PLAIN , 15));
        JLabel label4 = new JLabel("kg");
        label4.setFont(new Font("font" ,Font.BOLD, 17));

        JTextField textField2 = new JTextField(10);
        panel.add(label3);
        panel.add(textField2);
        panel.add(label4);


        // frame settings2
        frame.add(button);
        frame.add(panel);
        frame.setVisible(true);


        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame jFrame = new JFrame("result");
                jFrame.setBounds(300,300,250,200);

                if (textField.getText().length() > 0 && textField2.getText().length() > 0) {
                    double high = Double.parseDouble(textField.getText()) / 100;
                    double weight = Double.parseDouble(textField2.getText());
                    double bmi = weight / (high * high);
                    DecimalFormat format = new DecimalFormat("#.###");
                    JLabel jLabel = new JLabel(" BMI  = " + format.format(bmi));
                    jLabel.setFont(new Font("bold",Font.PLAIN ,20));
                    JButton jButton = new JButton("Ok");
                    jButton.setBounds(170, 110, 50, 35);

                    JPanel jPanel = new JPanel();
                    jPanel.add(jLabel);
                    jFrame.add(jButton);
                    jFrame.add(jPanel);

                    jFrame.setVisible(true);

                    jButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            jFrame.setVisible(false);
                        }
                    });
                }

                else {
                    JLabel label3 = new JLabel("Try again!");
                    jFrame.add(label3);
                    jFrame.setVisible(true);
                }
            }
        });
    }
}
