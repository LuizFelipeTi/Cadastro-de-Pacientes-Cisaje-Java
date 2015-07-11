/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cisaje.visual;

import java.awt.Color;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author LUIZ FELIPE
 */
public class DecoraTabela {

    public void personalizaTabela(JTable tabela) {

        tabela.setRowHeight(20);
        tabela.setShowGrid(false);
        tabela.setRowMargin(2);

        Color corCabecalhoTabela = new Color(208, 220, 255);
        tabela.getTableHeader().setBackground(corCabecalhoTabela);

        TableColumnModel com = tabela.getColumnModel();
        com.getColumn(0).setPreferredWidth(300);
        com.setColumnMargin(5);

        com.getColumn(3).setMinWidth(0);
        com.getColumn(3).setPreferredWidth(90);
        com.getColumn(3).setMaxWidth(90);

        com.getColumn(4).setMinWidth(0);
        com.getColumn(4).setPreferredWidth(70);
        com.getColumn(4).setMaxWidth(70);

        com.getColumn(5).setMinWidth(0);
        com.getColumn(5).setPreferredWidth(0);
        com.getColumn(5).setMaxWidth(0);

        com.getColumn(6).setMinWidth(0);
        com.getColumn(6).setPreferredWidth(0);
        com.getColumn(6).setMaxWidth(0);

        DefaultTableCellRenderer esquerda = new DefaultTableCellRenderer();
        DefaultTableCellRenderer centro = new DefaultTableCellRenderer();
        DefaultTableCellRenderer direita = new DefaultTableCellRenderer();

        esquerda.setHorizontalAlignment(SwingConstants.LEFT);
        centro.setHorizontalAlignment(SwingConstants.CENTER);
        direita.setHorizontalAlignment(SwingConstants.RIGHT);

        tabela.getColumnModel().getColumn(0).setCellRenderer(esquerda);
        tabela.getColumnModel().getColumn(1).setCellRenderer(centro);
        tabela.getColumnModel().getColumn(2).setCellRenderer(centro);
        tabela.getColumnModel().getColumn(3).setCellRenderer(centro);
        tabela.getColumnModel().getColumn(4).setCellRenderer(centro);
    }

}
