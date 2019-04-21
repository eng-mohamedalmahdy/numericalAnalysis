/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guicomponents;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JTextField;

public abstract class EquationsPanel extends JPanel {

    protected TextArea result = new TextArea();
    protected JTextField equationField = new JTextField();
    protected InputPanel input = new InputPanel(equationField);

    public EquationsPanel() {
        setBackground(Color.decode("#ece5dd"));
        equationField.setEditable(true);
        equationField.setSize(400, 50);
        equationField.setPreferredSize(new Dimension(400, 50));
        equationField.setBackground(Color.WHITE);
        result.setEditable(false);
        result.setFont(new Font(Font.DIALOG, Font.BOLD, 13));
        input.jbcalculate.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                result.setText(solve(equationField.getText()));
            }

        });
        setLayout(new BorderLayout(10, 10));
        add(input, BorderLayout.SOUTH);
        add(result, BorderLayout.CENTER);
        add(equationField, BorderLayout.NORTH);
    }

    protected abstract String solve(String text);

}
