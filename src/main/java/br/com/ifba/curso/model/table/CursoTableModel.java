/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.ifba.curso.model.table;
import br.com.ifba.curso.entity.Curso;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel; 
/**
 *
 * @author Cauã
 */
public class CursoTableModel extends AbstractTableModel {

    private List<Curso> cursos;
    // Nomes das colunas da sua tabela. Certifique-se que correspondem à ordem em getValueAt.
    private String[] colunas = {"ID", "Nome", "Código", "Ativo"}; 

    public CursoTableModel() {
        this.cursos = new ArrayList<>(); // Inicializa com uma lista vazia
    }

    public CursoTableModel(List<Curso> cursos) {
        this.cursos = cursos; // Inicializa com uma lista existente de cursos
    }

    /**
     * Atualiza os dados da tabela e notifica a JTable sobre a mudança.
     * @param cursos A nova lista de objetos Curso.
     */
    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
        fireTableDataChanged(); // Notifica a JTable que os dados mudaram, fazendo-a redesenhar
    }

    /**
     * Retorna o objeto Curso correspondente a uma linha específica da tabela.
     * @param rowIndex O índice da linha selecionada.
     * @return O objeto Curso naquela linha.
     */
    public Curso getCurso(int rowIndex) {
        if (rowIndex >= 0 && rowIndex < cursos.size()) {
            return cursos.get(rowIndex);
        }
        return null; // Retorna null se o índice for inválido
    }

    @Override
    public int getRowCount() {
        return cursos.size(); // Retorna o número de linhas (quantidade de cursos)
    }

    @Override
    public int getColumnCount() {
        return colunas.length; // Retorna o número de colunas
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column]; // Retorna o nome da coluna para o cabeçalho
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Curso curso = cursos.get(rowIndex); // Obtém o objeto Curso da linha

        switch (columnIndex) { // Retorna o valor do atributo correspondente à coluna
            case 0: return curso.getId();
            case 1: return curso.getNome();
            case 2: return curso.getCodigoCurso(); // Use getCodigoCurso() se esse for o seu getter
            case 3: return curso.isAtivoNoParamenter() ? "Sim" : "Não"; // Formata o booleano para "Sim" ou "Não"
            default: return null; // Para colunas inválidas
        }
    }

    // Opcional: Ajuda a JTable a renderizar tipos de dados corretamente
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0: return Long.class;   // ID
            case 1: return String.class; // Nome
            case 2: return String.class; // Código
            case 3: return String.class; // Ativo (como String "Sim"/"Não")
            default: return Object.class;
        }
    }

    // Define se as células são editáveis diretamente na tabela.
    // Para edição em tela secundária, elas não devem ser editáveis na tabela.
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false; // Nenhuma célula da tabela será editável pelo usuário
    }
}
