package numricalanalysis.Maths;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import numricalanalysis.listeners.ChangeColorListner;

public class RoundANumber extends JPanel {

    private JButton[] nums = new JButton[10];
    public JButton jbcalculate;
    public JButton jbclear;
    private JButton dot;
    private JButton leftArrow;
    private JButton rightArrow;
    private JButton backSpace;
    private JTextField jtfInputNumber;
    private JTextField jtfInputRoundingNumber;
    private JTextField jtfOuputNumber;
    private JLabel jlInputNumber;
    private JLabel jlInputRoundingNumber;
    private JLabel jlOuputNumber;
    private boolean up = true;

    public RoundANumber() {
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel(new GridLayout(3, 2, 10, 60));
        setPreferredSize(new Dimension(720, 290));
        p1.setPreferredSize(new Dimension(720, 350));
        setSize(new Dimension(720, 290));
        p1.setSize(new Dimension(420, 530));
        p1.setLayout(new GridLayout(4, 4, 10, 10));
        setPreferredSize(new Dimension(720, 290));
        p2.setPreferredSize(new Dimension(720, 280));
        setSize(new Dimension(720, 290));
        p2.setSize(new Dimension(420, 530));
        p2.setBackground(Color.decode("#ece5dd"));

        for (int i = 0; i < nums.length; i++) {
            nums[i] = new JButton(Integer.toString(i));
            p1.add(nums[i]);
            nums[i].setBackground(Color.decode("#dcf8c6"));
            nums[i].addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton b = (JButton) e.getSource();
                    String s = b.getText();
                    if (up) {
                        jtfInputNumber.setText(jtfInputNumber.getText() + b.getText());
                    } else {
                        jtfInputRoundingNumber.setText(jtfInputRoundingNumber.getText() + s);
                    }
                }
            });
            nums[i].addMouseListener(new ChangeColorListner());
        }
        dot = new JButton(".");
        dot.addMouseListener(new ChangeColorListner());
        dot.setBackground(Color.decode("#dcf8c6"));
        dot.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JButton b = (JButton) e.getSource();
                String s = b.getText();
                if (up) {
                    jtfInputNumber.setText(jtfInputNumber.getText() + ".");
                } else {
                    jtfInputRoundingNumber.setText(jtfInputRoundingNumber.getText() + s);
                }
            }
        });

        jbcalculate = new JButton("solve");
        jbcalculate.setBackground(Color.decode("#dcf8c6"));
        jbcalculate.addMouseListener(new ChangeColorListner());
        jbcalculate.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                jtfOuputNumber.setText(solve(jtfInputNumber.getText(), jtfInputRoundingNumber.getText()));
            }
        });
        jbclear = new JButton("clear");
        jbclear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (up) {
                    jtfInputNumber.setText("");
                } else {
                    jtfInputRoundingNumber.setText("");
                }
            }
        });
        jbclear.setBackground(Color.decode("#dcf8c6"));
        jbclear.addMouseListener(new ChangeColorListner());
        setBackground(Color.decode("#ece5dd"));
        p1.setBackground(Color.decode("#ece5dd"));
        leftArrow = new JButton("previous");
        leftArrow.addMouseListener(new ChangeColorListner());
        leftArrow.setBackground(Color.decode("#dcf8c6"));
        leftArrow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                up = true;
            }
        });

        rightArrow = new JButton("next");
        rightArrow.addMouseListener(new ChangeColorListner());
        rightArrow.setBackground(Color.decode("#dcf8c6"));
        rightArrow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                up = false;
            }
        });

        backSpace = new JButton("BS");
        backSpace.addMouseListener(new ChangeColorListner());
        backSpace.setBackground(Color.decode("#dcf8c6"));
        backSpace.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jtfInputNumber.setText(jtfInputNumber.getText().substring(0, jtfInputNumber.getText().length() - 1));
            }
        });
        p1.add(leftArrow);
        p1.add(rightArrow);
        p1.add(dot);
        p1.add(backSpace);
        p1.add(jbclear);
        p1.add(jbcalculate);
        jtfInputNumber = new JTextField();
        jtfInputRoundingNumber = new JTextField();
        jtfOuputNumber = new JTextField();
        jlInputNumber = new JLabel("InputNumber");
        jlInputRoundingNumber = new JLabel("InputRoundingNumber");
        jlOuputNumber = new JLabel("OuputNumber");
        p2.add(jlInputNumber);
        p2.add(jtfInputNumber);
        p2.add(jlInputRoundingNumber);
        p2.add(jtfInputRoundingNumber);
        p2.add(jlOuputNumber);
        p2.add(jtfOuputNumber);
        setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        add(p2);
        add(p1);

    }

    private static String solve(String inputNumber, String inputRounding) {
        //----------------------------------------------------------//
        // Significant digit//
        StringBuilder number = new StringBuilder();
        char[] zero = new char[inputNumber.length()];
        int i;
        for (i = 0; i < inputNumber.length(); i++) {
            if (inputNumber.charAt(i) == '0' && (inputNumber.charAt(i + 1) == '0'
                    || inputNumber.charAt(i + 1) == '.')) {
                zero[i] = inputNumber.charAt(i);
            } else if (inputNumber.charAt(i) == '.' && inputNumber.charAt(i + 1) == '0') {
                zero[i] = inputNumber.charAt(i);
            } else if ((inputNumber.charAt(i) == '0' || inputNumber.charAt(i) == '.')
                    && inputNumber.charAt(i + 1) != '0') {
                zero[i] = inputNumber.charAt(i);
                break;
            } else {
                break;
            }
        }
        String zeros = String.valueOf(zero);
        if (i == 0) {
            if (zero[i] == '0') {
                number.append(inputNumber.substring(1));
            } else {
                number.append(inputNumber.substring(i));
            }
        } else {
            number.append(inputNumber.substring(i + 1));
        }
        String number1 = number.toString();
        //---------------------------------------------------------------//
        //ROUNDING NUMBER//
        int InputRounding = Integer.parseInt(inputRounding);
        if (number1.contains(".")) {
            if (number.charAt(InputRounding - 1) == '.') {
                if (number.charAt(InputRounding + 1) == '0' || number.charAt(InputRounding + 1) == '1'
                        || number.charAt(InputRounding + 1) == '2' || number.charAt(InputRounding + 1) == '3'
                        || number.charAt(InputRounding + 1) == '4') {
                    return zeros.concat(number.substring(0, InputRounding + 1));
                } else {
                    int num = Integer.parseInt(String.valueOf(number.charAt(InputRounding)));
                    num++;
                    if (num != 10) {
                        number.insert(InputRounding, String.valueOf(num + 1));
                        return zeros.concat(number.substring(0, InputRounding + 1));
                    } else {
                        number.insert(InputRounding, String.valueOf(num + 1));
                        return zeros.concat(number.substring(0, InputRounding + 1)) + "0";
                    }
                }
            } else {
                if (number.charAt(InputRounding + 1) == '0' || number.charAt(InputRounding + 1) == '1'
                        || number.charAt(InputRounding + 1) == '2' || number.charAt(InputRounding + 1) == '3'
                        || number.charAt(InputRounding + 1) == '4') {
                    return zeros.concat(number.substring(0, InputRounding + 1));
                } else {
                    int num = Integer.parseInt(String.valueOf(number.charAt(InputRounding)));
                    num++;
                    if (num != 10) {
                        number.insert(InputRounding, String.valueOf(num));
                        return zeros.concat(number.substring(0, InputRounding));
                    } else {
                        number.insert(InputRounding, String.valueOf(num));
                        return zeros.concat(number.substring(0, InputRounding + 1)) + "0";
                    }
                }
            }
        } else {
            if (number.charAt(InputRounding) == '0' || number.charAt(InputRounding) == '1'
                    || number.charAt(InputRounding) == '2' || number.charAt(InputRounding) == '3'
                    || number.charAt(InputRounding) == '4') {
                return zeros.concat(number.substring(0, InputRounding));
            } else {
                int num = Integer.parseInt(String.valueOf(number.charAt(InputRounding - 1)));
                num++;
                if (num != 10) {
                    number.insert(InputRounding - 1, String.valueOf(num));
                    return zeros.concat(number.substring(0, InputRounding));
                } else {
                    number.insert(InputRounding - 1, String.valueOf(num));
                    return zeros.concat(number.substring(0, InputRounding + 1)) + "0";
                }
            }
        }
    }
}
