/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cisaje.visual;

import javax.swing.JButton;

/**
 *
 * @author LUIZ FELIPE
 */
public class DecoraComponentes {

    public void PersonalizaBotao(JButton novo, JButton visualizar, JButton excluir, JButton salvar) {

        novo.setBorder(new RoundedBorder(6));
        visualizar.setBorder(new RoundedBorder(6));
        excluir.setBorder(new RoundedBorder(6));
        salvar.setBorder(new RoundedBorder(3));

    }

}
