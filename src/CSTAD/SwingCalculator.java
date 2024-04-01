package CSTAD;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingCalculator extends JFrame {
    private JTextField textField;
    private JButton[] numberButtons;
    private JButton[] functionButtons;
    private JButton addButton, subButton, mulButton, divButton;
    private JButton decimalButton, equalButton, deleteButton, clearButton;
    private JPanel panel;
    private double num1, num2, result;
    private char operator;

    public SwingCalculator() {
        setTitle("Swing Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 400);
        setLayout(null);

        textField = new JTextField();
        textField.setBounds(30, 30, 240, 30);
        add(textField);

        numberButtons = new JButton[10];
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
        }

        functionButtons = new JButton[7];
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decimalButton = new JButton(".");
        equalButton = new JButton("=");
        deleteButton = new JButton("Delete");
        clearButton = new JButton("Clear");

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decimalButton;
        functionButtons[5] = equalButton;
        functionButtons[6] = deleteButton;

        for (int i = 0; i < 7; i++) {
            functionButtons[i].addActionListener(new ButtonClickListener());
        }

        panel = new JPanel(new GridLayout(5, 4));
        panel.setBounds(30, 80, 240, 240);

        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);

        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);

        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);

        panel.add(decimalButton);
        panel.add(numberButtons[0]);
        panel.add(equalButton);
        panel.add(divButton);

        panel.add(deleteButton);
        panel.add(clearButton);

        add(panel);
        setVisible(true);
    }

    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JButton source = (JButton) e.getSource();
            String buttonText = source.getText();

            if (buttonText.equals("Delete")) {
                String currentText = textField.getText();
                if (!currentText.isEmpty()) {
                    textField.setText(currentText.substring(0, currentText.length() - 1));
                }
            } else if (buttonText.equals("Clear")) {
                textField.setText("");
            } else if (buttonText.equals("=")) {
                num2 = Double.parseDouble(textField.getText());

                switch (operator) {
                    case '+':
                        result = num1 + num2;
                        break;
                    case '-':
                        result = num1 - num2;
                        break;
                    case '*':
                        result = num1 * num2;
                        break;
                    case '/':
                        result = num1 / num2;
                        break;
                }

                textField.setText(String.valueOf(result));
            } else {
                textField.setText(textField.getText() + buttonText);
            }

            if (buttonText.equals("+") || buttonText.equals("-") || buttonText.equals("*") || buttonText.equals("/")) {
                num1 = Double.parseDouble(textField.getText());
                operator = buttonText.charAt(0);
                textField.setText("");
            }
        }
    }

    public static void main(String[] args) {
        new SwingCalculator();
    }
}