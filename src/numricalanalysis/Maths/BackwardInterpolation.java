package numricalanalysis.Maths;

import guicomponents.InterplationPanel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class BackwardInterpolation extends InterplationPanel {

    @Override
    public void solve() {
        int numberOf_Y = this.y - 1;
        int size = 0;
        for (int i = numberOf_Y; i > 0; i--) {
            if (YNumbers.get(i - 1) < 0) {
                double sub = YNumbers.get(i) + (YNumbers.get(i - 1) * -1);
                ouyputNumber.add(sub);
            } else {
                double sub = YNumbers.get(i) - YNumbers.get(i - 1);
                ouyputNumber.add(sub);
            }
            size++;
        }
        numberOf_Y--;
        int z = 0;
        while (true) {
            for (int i = 0; i < numberOf_Y; i++) {
                if (ouyputNumber.get(z) > 0) {
                    double sub = ouyputNumber.get(z) - ouyputNumber.get(z + 1);
                    ouyputNumber.add(sub);
                } else {
                    double sub = ouyputNumber.get(z) + (ouyputNumber.get(z + 1) * -1);
                    ouyputNumber.add(sub);
                }
                size++;
                z++;
            }
            z++;
            numberOf_Y--;
            if (numberOf_Y == 0) {
                break;
            }
        }
        int y1 = 1;
        int y2 = this.y - 1;
        int y3 = size - 1;
        for (int i = y2 + 1; i >= 2; i--) {
            for (int j = 0; j < y1; j++) {
                JLabel temp = new JLabel(String.valueOf(ouyputNumber.get(y3)), SwingConstants.CENTER);
                temp.setBackground(Color.decode("#128c7e"));
                temp.setForeground(Color.decode("#ece5dd"));
                temp.setOpaque(true);
                temp.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));
                panels.get(i).add(temp);
                y3--;
            }
            y1++;
        }
        if (y3 == -1) {
            this.y = 0;
        }
        this.XNumbers.trimToSize();
        for (int i = 0; i < this.XNumbers.size(); i++) {
            JLabel temp = new JLabel(String.valueOf(XNumbers.get(i)), SwingConstants.CENTER);
            temp.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));
            temp.setBackground(Color.decode("#128c7e"));
            temp.setOpaque(true);
            temp.setForeground(Color.decode("#ece5dd"));
            panels.get(0).add(temp);
        }
        for (int i = 0; i < this.XNumbers.size(); i++) {
            JLabel temp = new JLabel(String.valueOf(YNumbers.get(i)), SwingConstants.CENTER);
            temp.setForeground(Color.decode("#ece5dd"));
            temp.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));
            temp.setBackground(Color.decode("#128c7e"));
            temp.setOpaque(true);
            panels.get(1).add(temp);
        }
    }
}
