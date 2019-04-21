package guicomponents;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.SwingConstants;
import numricalanalysis.Maths.BackwardInterpolation;
import numricalanalysis.Maths.CalcError;
import numricalanalysis.Maths.FalsePosition;
import numricalanalysis.Maths.ForwardInterpolition;
import numricalanalysis.Maths.IterationMethod;
import numricalanalysis.Maths.PiSectionMethod;
import numricalanalysis.Maths.RoundANumber;

/**
 *
 * @author mahdy
 */
public class GUI extends JFrame {

    CardLayout c = new CardLayout();
    JPanel IO = new JPanel(c);
    JPanel UserManual = new JPanel(new FlowLayout(FlowLayout.LEFT));
    DefaultListModel listModel = new DefaultListModel();
    JList<PopupMenu> operations = new JList(listModel);
    JPopupMenu equationsPopupMenu = new JPopupMenu();
    JPopupMenu interplationPopupMenu = new JPopupMenu();
    JPanel errorPanel = new CalcError();
    JPanel roundingPanel = new RoundANumber();
    EquationsPanel piPanel = new PiSectionMethod();
    EquationsPanel itPanel = new IterationMethod();
    EquationsPanel falsePanel = new FalsePosition();
    JPanel forinterpol = new ForwardInterpolition();
    JPanel backinterpol = new BackwardInterpolation();
    JMenuItem piSectionMenuItem = new JMenuItem("Pi section method");
    JMenuItem iterationMenuItem = new JMenuItem("Iteration method");
    JMenuItem falsePositionMenuItem = new JMenuItem("False Position method");
    JMenuItem newtonPanel = new JMenuItem("Newton Raphson method");
    JMenuItem forwardInterpolation = new JMenuItem("Forward Interpolation method");
    JMenuItem backwardInterpolation = new JMenuItem("Backward Interpolation method");

    JLabel intro = new JLabel();

    public GUI() {
        setVisible(true);
        setSize(new Dimension(900, 710));
        setPreferredSize(new Dimension(900, 710));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER));
        setResizable(true);

        setLabel();
        c.first(IO);
        setOperations();
        setIO();
        getContentPane().setBackground(Color.decode("#25d366"));
        initcomponents();

    }

    private void initcomponents() {
        add(operations);
        add(IO);
    }

    private void setOperations() {

        listModel.addElement("Calculate error");
        listModel.addElement("Round a number");
        listModel.addElement("Solve equation");
        listModel.addElement("interpoltion");
        listModel.addElement("User manual");
        operations.setPreferredSize(new Dimension(130, 660));
        operations.setBackground(Color.decode("#128c7e"));
        operations.setForeground(Color.WHITE);
        
        DefaultListCellRenderer renderer = (DefaultListCellRenderer) operations.getCellRenderer();
        renderer.setHorizontalAlignment(SwingConstants.CENTER);
        operations.setCellRenderer(renderer);
        operations.setFixedCellHeight(40);
        operations.setSelectionBackground(Color.decode("#dcf8c6"));

        operations.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {

                if (operations.getSelectedIndex() == 0 && me.getClickCount() >= 2) {
                    c.show(IO, "1");
                } else if (operations.getSelectedIndex() == operations.getLastVisibleIndex() && me.getClickCount() >= 2) {
                    c.show(IO, "2");
                } else if (operations.getSelectedIndex() == operations.getLastVisibleIndex() && me.getClickCount() >= 2) {
                    c.show(IO, "3");
                } else if (operations.getSelectedIndex() == 1 && me.getClickCount() >= 2) {
                    c.show(IO, "6");
                } else if (!operations.isSelectionEmpty() && 2 == operations.getSelectedIndex() && me.getClickCount() >= 2) {       //   inside selected item bounds
                    setEquationsPopMenu();
                    equationsPopupMenu.show(operations, operations.getBounds().x + 122, operations.getSelectedIndex() * 40 - 1);

                } else if (!operations.isSelectionEmpty() && 3 == operations.getSelectedIndex() && me.getClickCount() >= 2) {       //   inside selected item bounds
                    setInterplitionMenu();
                    interplationPopupMenu.show(operations, operations.getBounds().x + 122, operations.getSelectedIndex() * 40 - 1);

                }
            }
        });

    }

    private void setEquationsPopMenu() {
        equationsPopupMenu = null;
        equationsPopupMenu = new JPopupMenu();
        equationsPopupMenu.setBackground(Color.decode("#128c7e"));

        piSectionMenuItem.setBackground(Color.decode("#dcf8c6"));
        piSectionMenuItem.setForeground(Color.black);
        piSectionMenuItem.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                c.show(IO, "3");

            }
        });

        iterationMenuItem.setBackground(Color.decode("#dcf8c6"));
        iterationMenuItem.setForeground(Color.black);
        iterationMenuItem.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                c.show(IO, "4");
            }
        });

        falsePositionMenuItem.setBackground(Color.decode("#dcf8c6"));
        falsePositionMenuItem.setForeground(Color.black);
        falsePositionMenuItem.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                c.show(IO, "5");
            }
        });

        newtonPanel.setBackground(Color.decode("#dcf8c6"));
        newtonPanel.setForeground(Color.black);

        if (operations.getSelectedIndex() == 2) {
            equationsPopupMenu.add(piSectionMenuItem);
            equationsPopupMenu.add(iterationMenuItem);
            equationsPopupMenu.add(falsePositionMenuItem);
            equationsPopupMenu.add(newtonPanel);

        }

    }

    private void setInterplitionMenu() {
        interplationPopupMenu = null;
        interplationPopupMenu = new JPopupMenu();
        interplationPopupMenu.setBackground(Color.decode("#128c7e"));

        forwardInterpolation.setBackground(Color.decode("#dcf8c6"));
        forwardInterpolation.setForeground(Color.black);
        forwardInterpolation.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                c.show(IO, "7");
            }
        });

        backwardInterpolation.setBackground(Color.decode("#dcf8c6"));
        backwardInterpolation.setForeground(Color.black);
        backwardInterpolation.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                c.show(IO, "8");
            }
        });

        interplationPopupMenu.add(forwardInterpolation);
        interplationPopupMenu.add(backwardInterpolation);

    }

    private void setIO() {
        IO.setPreferredSize(new Dimension(735, 660));
        IO.setBackground(Color.decode("#ece5dd"));
        IO.add("1", errorPanel);
        IO.add("2", UserManual);
        IO.add("3", piPanel);
        IO.add("4", itPanel);
        IO.add("5", falsePanel);
        IO.add("6", roundingPanel);
        IO.add("7", forinterpol);
        IO.add("8", backinterpol);

    }

    private void setLabel() {

        intro.setFont(new Font(Font.DIALOG, Font.BOLD, 15));
        intro.setPreferredSize(new Dimension(540, 650));
        intro.setHorizontalTextPosition(SwingConstants.LEADING);
        intro.setHorizontalAlignment(SwingConstants.LEADING);
        intro.setBackground(Color.decode("#ece5dd"));
        intro.setVerticalAlignment(SwingConstants.TOP);
        intro.setText("<html>this is the Numrical analysis project <br/>"
                + "you can use it by selecting one of the operations on the left <br/>"
                + "______________________________________________________<br/>"
                + "fuctions overview : <br/><br/>"
                + "1- Calculate the several types of errors between two values <br/>the true one and aproximated one<br/><br/>"
                + "2- Rounding decimal and floating point numbers"
                + "</html>");

        UserManual.setBackground(Color.decode("#ece5dd"));
        UserManual.add(intro);
        revalidate();
        repaint();

    }

}
