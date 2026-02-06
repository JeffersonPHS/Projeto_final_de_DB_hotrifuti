package hotifruti.dto;

import java.math.BigDecimal;
import java.nio.file.attribute.DosFileAttributeView;
import java.sql.Date; 

public class LoteDTO {

    private int idLote;
    private String nomeProduto;    
    private String nomeFornecedor; 
    private Date dataValidade;
    private Date dataEntrada;
    private BigDecimal custo;

    
    public LoteDTO(int idLote, String nomeProduto, String nomeFornecedor, Date dataValidade, Date dataEntrada, BigDecimal custo) {
        this.idLote = idLote;
        this.nomeProduto = nomeProduto;
        this.nomeFornecedor = nomeFornecedor;
        this.dataValidade = dataValidade;
        this.dataEntrada = dataEntrada;
        this.custo = custo;
    }

    

    public int getIdLote() {
        return idLote;
    }

    public void setIdLote(int idLote) {
        this.idLote = idLote;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getNomeFornecedor() {
        return nomeFornecedor;
    }

    public void setNomeFornecedor(String nomeFornecedor) {
        this.nomeFornecedor = nomeFornecedor;
    }

    public Date getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(Date dataValidade) {
        this.dataValidade = dataValidade;
    }

    public Date getDaEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public BigDecimal getCusto() {
        return custo;
    }

    public void setCusto(BigDecimal custo) {
        this.custo = custo;
    }
}
