package guicomponents;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import numricalanalysis.listeners.AppendString;
import numricalanalysis.listeners.ChangeColorListner;

public class InputPanel extends JPanel {

    private JButton[] nums = new JButton[10];
    private JButton jbtsin;
    private JButton jbtcos;
    private JButton jbtTan;
    private JButton jbExp;
    private JButton jbLog;
    private JButton jbtAdd;
    private JButton jbtSubtract;
    private JButton jbtMultiply;
    public JButton jbcalculate;
    public JButton jbclear;

    private JButton jbvarible;
    private JButton jbpowerOfVarible;
    private JButton jbrightBracet;
    private JButton jbLn;
    private JButton dot;
    private JButton leftArrow;
    private JButton rightArrow;
    private JButton backSpace;

    private JTextField equ;

    public InputPanel(JTextField equ) {
        JPanel p1 = new JPanel();
        this.equ = equ;
        setPreferredSize(new Dimension(520, 290));
        p1.setPreferredSize(new Dimension(520, 280));
        setSize(new Dimension(520, 290));
        p1.setSize(new Dimension(220, 530));
        p1.setLayout(new GridLayout(4, 7, 5, 5));
        for (int i = 0; i < nums.length; i++) {
            nums[i] = new JButton(Integer.toString(i));
            p1.add(nums[i]);
            nums[i].setBackground(Color.decode("#dcf8c6"));
            nums[i].addActionListener(new AppendString(equ));
            nums[i].addMouseListener(new ChangeColorListner());
        }
        dot = new JButton(".");
        dot.addMouseListener(new ChangeColorListner());
        dot.setBackground(Color.decode("#dcf8c6"));
        dot.addActionListener(new AppendString(equ));
        p1.add(dot);

        jbtsin = new JButton("sin(");
        jbtsin.addMouseListener(new ChangeColorListner());
        jbtsin.addActionListener(new AppendString(equ));
        jbtsin.setBackground(Color.decode("#dcf8c6"));
        jbtcos = new JButton("cos(");
        jbtcos.addActionListener(new AppendString(equ));
        jbtcos.addMouseListener(new ChangeColorListner());
        jbtcos.setBackground(Color.decode("#dcf8c6"));
        jbtTan = new JButton("tan(");
        jbtTan.addActionListener(new AppendString(equ));
        jbtTan.setBackground(Color.decode("#dcf8c6"));
        jbtTan.addMouseListener(new ChangeColorListner());
        jbExp = new JButton("e");
        jbExp.addActionListener(new AppendString(equ));
        jbExp.setBackground(Color.decode("#dcf8c6"));
        jbExp.addMouseListener(new ChangeColorListner());
        jbLog = new JButton("log(");
        jbLog.addActionListener(new AppendString(equ));
        jbLog.setBackground(Color.decode("#dcf8c6"));
        jbLog.addMouseListener(new ChangeColorListner());
        jbcalculate = new JButton("solve");
        jbcalculate.setBackground(Color.decode("#dcf8c6"));
        jbcalculate.addMouseListener(new ChangeColorListner());
        jbclear = new JButton("/");
        jbclear.addActionListener(new AppendString(equ));
        jbclear.setBackground(Color.decode("#dcf8c6"));
        jbclear.addMouseListener(new ChangeColorListner());
        jbtAdd = new JButton("+");
        jbtAdd.addActionListener(new AppendString(equ));
        jbtAdd.addMouseListener(new ChangeColorListner());
        jbtAdd.setBackground(Color.decode("#dcf8c6"));
        jbtSubtract = new JButton("-");
        jbtSubtract.addActionListener(new AppendString(equ));
        jbtSubtract.setBackground(Color.decode("#dcf8c6"));
        jbtSubtract.addMouseListener(new ChangeColorListner());
        jbtMultiply = new JButton("*");
        jbtMultiply.addActionListener(new AppendString(equ));
        jbtMultiply.setBackground(Color.decode("#dcf8c6"));
        jbtMultiply.addMouseListener(new ChangeColorListner());
        jbvarible = new JButton("X");
        jbvarible.addActionListener(new AppendString(equ));
        jbvarible.setBackground(Color.decode("#dcf8c6"));
        jbvarible.addMouseListener(new ChangeColorListner());
        jbpowerOfVarible = new JButton("^(");
        jbpowerOfVarible.addActionListener(new AppendString(equ));
        jbpowerOfVarible.setBackground(Color.decode("#dcf8c6"));
        jbpowerOfVarible.addMouseListener(new ChangeColorListner());
        jbrightBracet = new JButton(")");
        jbrightBracet.addActionListener(new AppendString(equ));
        jbrightBracet.setBackground(Color.decode("#dcf8c6"));
        jbrightBracet.addMouseListener(new ChangeColorListner());
        jbLn = new JButton("ln");
        jbLn.addActionListener(new AppendString(equ));
        jbLn.setBackground(Color.decode("#dcf8c6"));
        jbLn.addMouseListener(new ChangeColorListner());
        setBackground(Color.decode("#ece5dd"));
        p1.setBackground(Color.decode("#ece5dd"));

        p1.add(jbtsin);
        p1.add(jbtcos);
        p1.add(jbtTan);
        p1.add(jbExp);
        p1.add(jbLog);
        p1.add(jbtAdd);
        p1.add(jbtSubtract);
        p1.add(jbtMultiply);
        p1.add(jbclear);
        p1.add(jbvarible);
        p1.add(jbpowerOfVarible);
        p1.add(jbLn);
        p1.add(jbrightBracet);

        leftArrow = new JButton("<=");
        leftArrow.addMouseListener(new ChangeColorListner());
        leftArrow.setBackground(Color.decode("#dcf8c6"));
        leftArrow.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                equ.requestFocus();

            }
        });
        p1.add(leftArrow);
        rightArrow = new JButton("=>");
        rightArrow.addMouseListener(new ChangeColorListner());
        rightArrow.setBackground(Color.decode("#dcf8c6"));
        rightArrow.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                equ.requestFocus();

            }
        });
        p1.add(rightArrow);

        backSpace = new JButton("BS");
        backSpace.addMouseListener(new ChangeColorListner());
        backSpace.setBackground(Color.decode("#dcf8c6"));
        backSpace.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JButton b = (JButton) e.getSource();
                
                equ.setText(equ.getText().substring(0, equ.getText().length() - 1));

            }
        });
        p1.add(backSpace);
        p1.add(jbcalculate);
        add(p1);

    }

}
