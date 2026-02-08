package hotifruti.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import hotifruti.model.ItemVenda;
import hotifruti.util.Conexao;

public class ItemVendaDAO {

    public ItemVendaDAO(){}

    // 1. SALVAR
    public void salvar(ItemVenda item) throws Exception {
        // CORREÇÃO: Nomes das colunas iguais ao SQL (Quantidade_Vendida, Preco_Unidade)
        String sql = "INSERT INTO ITEM_VENDA (ID_Venda, ID_Produto, Quantidade_Vendida, Preco_Unidade) VALUES (?, ?, ?, ?)";
        
        try (Connection conn = Conexao.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setInt(1, item.getIdVenda());
            ps.setInt(2, item.getIdProduto());
            ps.setInt(3, item.getQuantidadeVendida());
            ps.setBigDecimal(4, item.getPrecoUnidade()); 
            
            ps.executeUpdate();
        }
    }

    // 2. ATUALIZAR
    public void atualizar(ItemVenda item) throws Exception {
        // CORREÇÃO: Atualiza Quantidade_Vendida e Preco_Unidade
        String sql = "UPDATE ITEM_VENDA SET Quantidade_Vendida = ?, Preco_Unidade = ? WHERE ID_Venda = ? AND ID_Produto = ?";
        
        try (Connection conn = Conexao.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setInt(1, item.getQuantidadeVendida());
            ps.setBigDecimal(2, item.getPrecoUnidade());
            
            // O WHERE precisa dos dois IDs (Chave Composta)
            ps.setInt(3, item.getIdVenda());
            ps.setInt(4, item.getIdProduto());
            
            ps.executeUpdate();
        }
    }

    // 3. EXCLUIR (Item específico)
    public void excluir(int idVenda, int idProduto) throws Exception {
        String sql = "DELETE FROM ITEM_VENDA WHERE ID_Venda = ? AND ID_Produto = ?";
        
        try (Connection conn = Conexao.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setInt(1, idVenda);
            ps.setInt(2, idProduto);
            
            ps.executeUpdate();
        }
    }

    // 4. BUSCAR UM ITEM ESPECÍFICO
    public ItemVenda buscarPorId(int idVenda, int idProduto) throws Exception {
        String sql = "SELECT * FROM ITEM_VENDA WHERE ID_Venda = ? AND ID_Produto = ?";
        
        try (Connection conn = Conexao.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setInt(1, idVenda);
            ps.setInt(2, idProduto);
            
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    // CORREÇÃO: O construtor deve seguir a ordem da sua classe ItemVenda
                    return new ItemVenda(
                        rs.getInt("ID_Venda"), 
                        rs.getInt("ID_Produto"), 
                        rs.getInt("Quantidade_Vendida"), // Nome correto da coluna
                        rs.getBigDecimal("Preco_Unidade") // Nome correto da coluna
                    );
                }
            }
        }
        return null;
    }

    // 5. LISTAR TUDO (Geral)
    public List<ItemVenda> listar() throws Exception {
        String sql = "SELECT * FROM ITEM_VENDA";
        List<ItemVenda> lista = new ArrayList<>();
        
        try (Connection conn = Conexao.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                lista.add(new ItemVenda(
                    rs.getInt("ID_Venda"), 
                    rs.getInt("ID_Produto"), 
                    rs.getInt("Quantidade_Vendida"), // Nome correto
                    rs.getBigDecimal("Preco_Unidade") // Nome correto
                ));
            }
        }
        return lista;
    }

    // 6. LISTAR ITENS DE UMA VENDA (Método Extra Recomendado)
    // Esse é o método que você mais vai usar na tela de "Detalhes da Venda"
    public List<ItemVenda> listarPorVenda(int idVenda) throws Exception {
        String sql = "SELECT * FROM ITEM_VENDA WHERE ID_Venda = ?";
        List<ItemVenda> lista = new ArrayList<>();
        
        try (Connection conn = Conexao.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setInt(1, idVenda);
            
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    lista.add(new ItemVenda(
                        rs.getInt("ID_Venda"), 
                        rs.getInt("ID_Produto"), 
                        rs.getInt("Quantidade_Vendida"), 
                        rs.getBigDecimal("Preco_Unidade")
                    ));
                }
            }
        }
        return lista;
    }
}