/*
 * Classe Principal Responsável pela Execução de todo
 * o Programa.
 * 
 */
package sistemapaciente;

import cisaje.visual.Hiperdia;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author LUIZ FELIPE
 */
public class SistemaPaciente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, UnsupportedLookAndFeelException, InvocationTargetException {
        // TODO code application logic here

        //UIManager.setLookAndFeel(new UpperEssentialLookAndFeel());
        //UIManager.setLookAndFeel(new UpperEssentialLookAndFeel("C:\\Users\\LUIZ FELIPE\\Documents\\NetBeansProjects\\SistemaPaciente\\src\\UpperEssentialThemeFile.theme"));
        Hiperdia tabela = new Hiperdia();
        //UIManager.put("TabbedPane.background", Color.GRAY);
        tabela.setVisible(true);

//        ConsultaPaciente consulta = new ConsultaPaciente();
//        consulta.setAng(0);
//        consulta.setAs(0);
//        consulta.setCard(1);
//        consulta.setEndo(0);
//        consulta.setEnf(1);
//        consulta.setNefro(0);
//        consulta.setNut(0);
//        consulta.setOft(1);
//        consulta.setPsi(0);
//        
//        System.out.println(consulta);
        //System.out.println(consulta.getAng());          
    }

}
