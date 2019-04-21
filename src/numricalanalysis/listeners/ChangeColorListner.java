/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numricalanalysis.listeners;

import java.awt.Color;
import java.awt.event.MouseListener;
import javax.swing.JButton;

/**
 *
 * @author Mohamed
 */
public class ChangeColorListner implements MouseListener{

                @Override
                public void mouseClicked(java.awt.event.MouseEvent e) {
                }

                @Override
                public void mousePressed(java.awt.event.MouseEvent e) {
                }

                @Override
                public void mouseReleased(java.awt.event.MouseEvent e) {
                }

                @Override
                public void mouseEntered(java.awt.event.MouseEvent e) {
                    JButton temp = (JButton) e.getSource();
                    temp.setBackground(Color.decode("#25d366"));
                }

                @Override
                public void mouseExited(java.awt.event.MouseEvent e) {
                    JButton temp = (JButton) e.getSource();
                    temp.setBackground(Color.decode("#dcf8c6"));
                }
            }
