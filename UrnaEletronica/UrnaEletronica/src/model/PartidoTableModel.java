/*
 * Projeto Final da Cadeira de POO em Java
 * IFCE 2018.2
 */
package model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;


/**
 *
 * @author Matheus
 */
public class PartidoTableModel extends AbstractTableModel{
    
    private List<Partido> dados = new ArrayList<>();
    private String[] colunas = {"Nome do partido"};


    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }
    
    @Override
    public int getRowCount() {
        return dados.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
   
        return dados.get(linha).getNome();
            
    
    }
    public void setValueAt(Object valor, int linha, int coluna){
 
         dados.get(linha).setNome((String)valor);
                 
            
     
        this.fireTableRowsUpdated(linha, linha);
    }
    
    public void addRow(Partido e){
        this.dados.add(e);
        this.fireTableDataChanged();
    }
     public void removeRow(int linha){
        this.dados.remove(linha);
        this.fireTableRowsDeleted(linha, linha);
    }
    
}
