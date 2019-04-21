/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numricalanalysis.listeners;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author mahdy
 */
public class DigitsOnlyKeyListener implements KeyListener {

    @Override
    public void keyTyped(KeyEvent ke) {
        if (!(Character.isDigit(ke.getKeyChar())) && ke.getKeyChar() != '-' && ke.getKeyChar() != '.') {
            ke.consume();
        }
    }

    @Override
    public void keyPressed(KeyEvent ke) {

    }

    @Override
    public void keyReleased(KeyEvent ke) {
    }

}
