/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guicomponents;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import numricalanalysis.listeners.ChangeColorListner;

/**
 *
 * @author Mohamed
 */
public abstract class InterplationPanel extends JPanel {

    JLabel xLabel = new JLabel("X : ");
    JTextField xField = new JTextField();
    JLabel yLabel = new JLabel("Y : ");
    JTextField yField = new JTextField();
    JPanel sol = new JPanel();
    JButton calculate = new JButton("calculate");
    protected ArrayList<Double> YNumbers = new ArrayList<>();
    protected ArrayList<Double> XNumbers = new ArrayList<>();
    protected ArrayList<JPanel> panels = new ArrayList<>();
    protected LinkedList<Double> ouyputNumber = new LinkedList();
    protected int y = 0;

    public InterplationPanel() {
        yField.setSize(700, 30);
        setBackground(Color.decode("#ece5dd"));
        yField.setPreferredSize(new Dimension(700, 30));
        xField.setSize(700, 30);
        xField.setPreferredSize(new Dimension(700, 30));
        sol.setBackground(Color.decode("#25d366"));
        sol.setPreferredSize(new Dimension(720, 550));
        sol.setSize(720, 580);
        calculate.addMouseListener(new ChangeColorListner());
        calculate.setBackground(Color.decode("#25d366"));
        calculate.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (xField.getText().split(",").length == yField.getText().split(",").length) {
                    buildPanel();
                } else {
                    JOptionPane.showMessageDialog(null, "the x's must equal y's");
                }
                XNumbers = new ArrayList<>();
                YNumbers = new ArrayList<>();

            }
        });
        add(xLabel);
        add(xField);
        add(yLabel);
        add(yField);
        add(calculate);
        add(sol);

    }

    private void buildPanel() {
        this.YNumbers.removeAll(this.YNumbers);
        String xs = xField.getText();
        String[] xnumbers = xs.split(",");
        sol.removeAll();
        String[] numbers = yField.getText().split(",");
        for (int i = 0; i < numbers.length; i++) {
            this.YNumbers.add(Double.valueOf(numbers[i]));
            this.XNumbers.add(Double.valueOf(xnumbers[i]));
            y++;
        }
        this.YNumbers.trimToSize();

        sol.setLayout(new GridLayout(1, this.YNumbers.size() + 1, 10, 10));

        panels = new ArrayList<>();

        repaint();
        revalidate();

        panels.add(new JPanel(new GridLayout(this.YNumbers.size(), 1, 10, 10)));
        for (int i = 0; i < this.YNumbers.size(); i++) {
            panels.add(new JPanel(new GridLayout(this.YNumbers.size() - i, 1, 10, 10)));
        }
        for (int i = 0; i < panels.size(); i++) {
            JPanel temp = panels.get(i);
            temp.setBackground(Color.decode("#25d366"));
            sol.add(temp);
        }
        solve();
        repaint();
        revalidate();
    }

    protected abstract void solve();
}
