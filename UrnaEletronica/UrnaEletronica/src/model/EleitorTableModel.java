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
public class EleitorTableModel extends AbstractTableModel{

    private List<Eleitor> dados = new ArrayList<>();
    private String[] colunas = {"Nome","CPF","CEP","Rua","Bairro","Número"};


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
        switch(coluna){
            case 0:
                return dados.get(linha).getNomeEleitor();
            case 1:
                return dados.get(linha).getCpf();
            case 2:
                return dados.get(linha).getCep();
            case 3:
                return dados.get(linha).getRua();
            case 4:
                return dados.get(linha).getBairro();
            case 5:
                return dados.get(linha).getNumero();
            
        }
        return null;
    }
    public void setValueAt(Object valor, int linha, int coluna){
        switch(coluna){
            case 0:
                 dados.get(linha).setNomeEleitor((String)valor);
                 break;
            case 1:
                 dados.get(linha).setCpf((String)valor);
                 break;
            case 2:
                 dados.get(linha).setCep((String)valor);
                 break;
            case 3:
                 dados.get(linha).setRua((String)valor);
                 break;
            case 4:
                 dados.get(linha).setBairro((String)valor);
                 break;
            case 5:
                 dados.get(linha).setNumero ((String)valor);
                 break;
            
        } 
        this.fireTableRowsUpdated(linha, linha);
    }
    
    public void addRow(Eleitor e){
        this.dados.add(e);
        this.fireTableDataChanged();
    }
     public void removeRow(int linha){
        this.dados.remove(linha);
        this.fireTableRowsDeleted(linha, linha);
    }    
    
}
