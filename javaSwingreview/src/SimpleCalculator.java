import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleCalculator {
    private static String operator = "";
    private static double num1 = 0;
    private static double num2 = 0;
    private static boolean start = true;

    public static void main(String[] args) {
        JFrame frame = new JFrame("简单计算器");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);

        JTextField textField = new JTextField();

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4));

        String[] buttons = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", ".", "=", "+"
        };

        for (String text : buttons) {
            JButton button = new JButton(text);
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String buttonText = e.getActionCommand();

                    if (buttonText.equals("=")) {
                        if (!operator.isEmpty()) {
                            num2 = Double.parseDouble(textField.getText());
                            double result = CalculatorLogic.calculate(num1, num2, operator);
                            textField.setText(Double.toString(result));
                            operator = "";
                            start = true;
                        }
                    } else if (buttonText.matches("[+-/*]")) {
                        num1 = Double.parseDouble(textField.getText());
                        operator = buttonText;
                        textField.setText(textField.getText() + buttonText);
                        start = true;
                    } else {
                        if (start) {
                            textField.setText(buttonText);
                            start = false;
                        } else {
                            textField.setText(textField.getText() + buttonText);
                        }
                    }
                }
            });
            panel.add(button);
        }

        frame.add(textField, BorderLayout.NORTH);
        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    public static class CalculatorLogic {
        public static double calculate(double num1, double num2, String operator) {
            switch (operator) {
                case "+":
                    return num1 + num2;
                case "-":
                    return num1 - num2;
                case "*":
                    return num1 * num2;
                case "/":
                    if (num2 != 0) {
                        return num1 / num2;
                    } else {
                        throw new IllegalArgumentException("Cannot divide by zero");
                    }
                default:
                    throw new IllegalArgumentException("Invalid operator");
            }
        }
    }
}