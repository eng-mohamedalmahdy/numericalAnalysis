/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numricalanalysis.Maths;

import guicomponents.InterplationPanel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 *
 * @author Mohamed
 */
public class ForwardInterpolition extends InterplationPanel {

    @Override
    protected void solve() {
        int numberOf_Y = this.y - 1;
        for (int i = 0; i < numberOf_Y; i++) {
            if (YNumbers.get(i) < 0) {
                double sub = YNumbers.get(i + 1) + (YNumbers.get(i) * -1);
                ouyputNumber.add(sub);
            } else {
                double sub = YNumbers.get(i + 1) - YNumbers.get(i);
                ouyputNumber.add(sub);
            }
        }
        numberOf_Y--;
        int z = 0;
        while (true) {
            for (int i = 0; i < numberOf_Y; i++) {
                if (ouyputNumber.get(z) > 0) {
                    double sub = ouyputNumber.get(z + 1) - ouyputNumber.get(z);
                    ouyputNumber.add(sub);
                } else {
                    double sub = ouyputNumber.get(z + 1) + (ouyputNumber.get(z) * -1);
                    ouyputNumber.add(sub);
                }
                z++;
            }
            z++;
            numberOf_Y--;
            if (numberOf_Y == 0) {
                break;
            }
        }
        int y1 = this.y - 1;
        int y2 = this.y - 1;
        int y3 = 0;
        for (int i = 2; i < (y2 + 2); i++) {
            for (int j = 0; j < y1; j++) {
                JLabel temp = new JLabel(String.valueOf(ouyputNumber.get(y3)), SwingConstants.CENTER);
                temp.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));
                temp.setOpaque(true);
                temp.setForeground(Color.decode("#ece5dd"));
                temp.setBackground(Color.decode("#128c7e"));
                panels.get(i).add(temp);
                y3++;
            }
            y1--;
        }
        if (y1 == 0) {
            this.y = 0;
        }
        this.XNumbers.trimToSize();
        for (int i = 0; i < this.XNumbers.size(); i++) {
            JLabel temp = new JLabel(String.valueOf(XNumbers.get(i)), SwingConstants.CENTER);
            temp.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));
            temp.setOpaque(true);
            temp.setBackground(Color.decode("#128c7e"));
            temp.setForeground(Color.decode("#ece5dd"));
            panels.get(0).add(temp);
        }
        for (int i = 0; i < this.XNumbers.size(); i++) {
            JLabel temp = new JLabel(String.valueOf(YNumbers.get(i)), SwingConstants.CENTER);
            temp.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));
            temp.setOpaque(true);
            temp.setForeground(Color.decode("#ece5dd"));
            temp.setBackground(Color.decode("#128c7e"));
            panels.get(1).add(temp);
        }

    }
}
