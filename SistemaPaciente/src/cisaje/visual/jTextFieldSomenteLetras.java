/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cisaje.visual;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTextField;

/**
 *
 * @author LUIZ FELIPE
 */
public class jTextFieldSomenteLetras extends JTextField {

    private int maximoCaracteres = -1;

    public jTextFieldSomenteLetras() {
        super();
        addKeyListener(new KeyAdapter() {

            public void keyTyped(KeyEvent evt) {
                jTextFieldKeyTyped(evt);
            }
        });
    }

    public jTextFieldSomenteLetras(int maximo) {
        super();
        setMaximoCaracteres(maximo);

        addKeyListener(new KeyAdapter() {

            public void keyTyped(KeyEvent evt) {
                jTextFieldKeyTyped(evt);
            }
        });
    }

    private void jTextFieldKeyTyped(KeyEvent evt) {

        String caracteres = " abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZçÇéáíúóÁÉÓÍÚãõÃÕ";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }

        if (getText().length() >= getMaximoCaracteres() && (getMaximoCaracteres() != -1)) {
            evt.consume();
            setText(getText().substring(0, getMaximoCaracteres()));
        }
    }

    public int getMaximoCaracteres() {
        return maximoCaracteres;
    }

    public void setMaximoCaracteres(int maximoCaracteres) {
        this.maximoCaracteres = maximoCaracteres;
    }

}
