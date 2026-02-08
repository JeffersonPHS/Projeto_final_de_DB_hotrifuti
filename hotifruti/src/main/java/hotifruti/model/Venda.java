package hotifruti.model;

import java.time.LocalDateTime; // <--- Import obrigatório

public class Venda {
    private int idVenda;
    private String idCliente; // Mudado de int para String (VARCHAR no banco)
    private LocalDateTime dataHora; // Mudado de DATETIME para LocalDateTime

    // Construtor Vazio (Boa prática)
    public Venda() {
        this.dataHora = LocalDateTime.now();
    }

    // Construtor Cheio
    public Venda(int idVenda, String idCliente, LocalDateTime dataHora) {
        this.idVenda = idVenda;
        this.idCliente = idCliente;
        this.dataHora = dataHora;
    }

    // --- Getters e Setters ---

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    // CPF deve ser String em tudo!
    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    // Data agora é LocalDateTime
    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }
}
