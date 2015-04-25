package br.com.magmadoctor.modelo.categoria;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class CategoriaTabelModel extends AbstractTableModel {

    private ArrayList<Categoria> linhas;
    private String[] colunas = new String[]{"CODIGO", "NOME"};

    public CategoriaTabelModel() {
        linhas = new ArrayList<Categoria>();
    }

    public CategoriaTabelModel(ArrayList<Categoria> lista) {
        linhas = new ArrayList<Categoria>(lista);
    }

    /* Retorna a quantidade de colunas. */
    @Override
    public int getColumnCount() {
        // Está retornando o tamanho do array "colunas".  
        return colunas.length;
    }

    /* Retorna o nome da coluna no índice especificado. 
     * Este método é usado pela JTable para saber o texto do cabeçalho. */
    @Override
    public String getColumnName(int columnIndex) {
        // Retorna o conteúdo do Array que possui o nome das colunas  
        // no índice especificado.  
        return colunas[columnIndex];
    }

    /* Retorna a classe dos elementos da coluna especificada. 
     * Este método é usado pela JTable na hora de definir o editor da célula. */
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    /* Retorna a quantidade de linhas. */
    @Override
    public int getRowCount() {
        // Retorna o tamanho da lista de Funcionarios.  
        return linhas.size();
    }

    /* Retorna o valor da celula especificada pelos indices da   
     * linha e da coluna.*/
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Categoria categoria = linhas.get(rowIndex);

        // Retorna o campo referente a coluna especificada.  
        // Aqui é feito um switch para verificar qual é a coluna  
        // e retornar o campo adequado. As colunas são as mesmas  
        // que foram especificadas no array "colunas".  
        switch (columnIndex) {
            case 0:
                return categoria.getCodigo();
            case 1:
                return categoria.getNome();
            default:
                // Se o índice da coluna não for válido, lança um  
                // IndexOutOfBoundsException (Exceção de índice fora dos limites).  
                // Não foi necessário verificar se o índice da linha é inválido,  
                // pois o próprio ArrayList lança a exceção caso seja inválido.  
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
        }
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        //pega o categoria da linha  
        Categoria categoria = linhas.get(rowIndex);

        //verifica qual valor vai ser alterado  
        switch (columnIndex) {
            case 0: // Primeira coluna é o codigo.  
                categoria.setCodigo(Integer.parseInt(aValue.toString()));
                break;
            case 1: // Segunda coluna é o nome.  
                categoria.setNome(aValue.toString());
                break;
        }
        //avisa que os dados mudaram  
        fireTableDataChanged();
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        //no nosso caso todas vão ser editáveis, entao retorna true pra todas  
        return false;
    }

    public void setLinhas(ArrayList<Categoria> linhas) {
        this.linhas = linhas;
    }

}
