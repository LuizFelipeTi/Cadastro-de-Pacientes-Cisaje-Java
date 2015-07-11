/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cisaje.utilitario;

import cisaje.visual.AbstractModel;
import java.util.ArrayList;
import java.util.regex.PatternSyntaxException;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;

/**
 * Classe responsável pelas filtragens das tabelas
 *
 * @author LUIZ FELIPE
 */
public class Filtros {

    public void newFilter(TableRowSorter<AbstractModel> sorter, String pesquisa, JTable tabela, int col) {
        RowFilter<AbstractModel, Object> rf = null;
        try {
            rf = RowFilter.regexFilter("(?i)" + pesquisa, col);

        } catch (PatternSyntaxException e) {
            return;
        }
        sorter.setRowFilter(rf);
        tabela.setRowSorter(sorter);

    }

    public void newFilterCombo(TableRowSorter<AbstractModel> sorter, JTable tabela, JComboBox mes) {
        RowFilter<AbstractModel, Object> rf = null;
        try {

            rf = RowFilter.regexFilter("(?i)" + mes.getSelectedItem(), 3);

        } catch (PatternSyntaxException e) {
            return;
        }
        sorter.setRowFilter(rf);
        tabela.setRowSorter(sorter);

    }

    public void newFilterAno(TableRowSorter<AbstractModel> sorter, String pesquisa, JTable tabela) {
        RowFilter<AbstractModel, Object> rf = null;
        try {
            rf = RowFilter.regexFilter("^" + pesquisa, 4);

        } catch (PatternSyntaxException e) {
            return;
        }
        sorter.setRowFilter(rf);
        tabela.setRowSorter(sorter);

    }

    public void combinaFiltros(TableRowSorter<AbstractModel> sorter, String txtPesquisa, String txtSisPrenatal, String txtCartaoSus, JComboBox mes, String sexo, JTable tabela) {
        RowFilter<AbstractModel, Object> filtraTxtPesquisa, filtraTxtSisPrenatal, filtraTxtCartaoSus, filtraSexo, filtraMes = null;
        try {

            filtraTxtPesquisa = RowFilter.regexFilter("(?i)" + txtPesquisa, 0);
            filtraTxtSisPrenatal = RowFilter.regexFilter("^" + txtSisPrenatal, 1);
            filtraTxtCartaoSus = RowFilter.regexFilter("^" + txtCartaoSus, 2);
            filtraMes = RowFilter.regexFilter("(?i)" + mes.getSelectedItem(), 3);
            //filtraAno = RowFilter.regexFilter("^" + ano, 4);
            filtraSexo = RowFilter.regexFilter("(?i)" + sexo, 6);

        } catch (PatternSyntaxException e) {
            return;
        }
        ArrayList<RowFilter<AbstractModel, Object>> andFilters = new ArrayList<RowFilter<AbstractModel, Object>>();

        andFilters.add(filtraTxtPesquisa);
        andFilters.add(filtraTxtSisPrenatal);
        andFilters.add(filtraTxtCartaoSus);
        andFilters.add(filtraMes);
        andFilters.add(filtraSexo);
       //andFilters.add(filtraAno);

        sorter.setRowFilter(RowFilter.andFilter(andFilters));

        tabela.setRowSorter(sorter);

    }

    public void combinaFiltrosAno(TableRowSorter<AbstractModel> sorter, String txtPesquisa, String txtSisPrenatal, String txtCartaoSus, JComboBox mes, String sexo, String ano, JTable tabela) {
        RowFilter<AbstractModel, Object> filtraTxtPesquisa, filtraTxtSisPrenatal, filtraTxtCartaoSus, filtraSexo, filtraMes, filtraAno = null;
        try {

            filtraTxtPesquisa = RowFilter.regexFilter("(?i)" + txtPesquisa, 0);
            filtraTxtSisPrenatal = RowFilter.regexFilter("^" + txtSisPrenatal, 1);
            filtraTxtCartaoSus = RowFilter.regexFilter("^" + txtCartaoSus, 2);
            filtraMes = RowFilter.regexFilter("(?i)" + mes.getSelectedItem(), 3);
            filtraAno = RowFilter.regexFilter("^" + ano, 4);
            filtraSexo = RowFilter.regexFilter("(?i)" + sexo, 6);

        } catch (PatternSyntaxException e) {
            return;
        }
        ArrayList<RowFilter<AbstractModel, Object>> andFilters = new ArrayList<RowFilter<AbstractModel, Object>>();

        andFilters.add(filtraTxtPesquisa);
        andFilters.add(filtraTxtSisPrenatal);
        andFilters.add(filtraTxtCartaoSus);
        andFilters.add(filtraMes);
        andFilters.add(filtraSexo);
        andFilters.add(filtraAno);

        sorter.setRowFilter(RowFilter.andFilter(andFilters));

        tabela.setRowSorter(sorter);

    }

}
