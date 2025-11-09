/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucb.aplicativo.model;

/**
 *
 * @author Usuário
 */
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class Pedido {
        
    private Long id;
    private Long usuarioId;
    private LocalDateTime dataPedido;
    private BigDecimal valorTotal;
    private String statusPedido; 
    //private List<ItemPedido> itens
            
     // Construtor Padrão 
    public Pedido() {
        this.dataPedido = LocalDateTime.now();
        this.valorTotal = BigDecimal.ZERO; // Inicializa o total como 0
        this.statusPedido = "PENDENTE"; // Status inicial
    }
    
    // Construtor para Novo Pedido
    public Pedido(Long usuarioId, List<ItemPedido> itens) {
        this.usuarioId = usuarioId;
        //this.itens = itens;
        this.dataPedido = LocalDateTime.now();
        this.statusPedido = "PENDENTE";
        // this.valorTotal = calcularValorTotal(itens); 
    }
        
     // Construtor Completo
    public Pedido(Long id, Long usuarioId, LocalDateTime dataPedido, BigDecimal valorTotal, String statusPedido, List<ItemPedido> itens) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.dataPedido = dataPedido;
        this.valorTotal = valorTotal;
        this.statusPedido = statusPedido;
        //this.itens = itens;
    }
    
    //Métodos Getters e Setters 
    public Long getId() { 
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Long getUsuarioId() { 
        return usuarioId; 
    }
    public void setUsuarioId(Long usuarioId) { 
        this.usuarioId = usuarioId; 
    }

    public LocalDateTime getDataPedido() {
        return dataPedido; 
    }
    public void setDataPedido(LocalDateTime dataPedido) {
        this.dataPedido = dataPedido;
    }

    public BigDecimal getValorTotal() { 
        return valorTotal; 
    }
    public void setValorTotal(BigDecimal valorTotal) { 
        this.valorTotal = valorTotal;
    }

    public String getStatusPedido() { 
        return statusPedido;
    }
    public void setStatusPedido(String statusPedido) {
        this.statusPedido = statusPedido; 
    }
    
    @Override
    public String toString() {
        return "Pedido {" +
                "id=" + id +
                ", usuarioId=" + usuarioId +
                ", dataPedido=" + dataPedido +
                ", valorTotal=" + valorTotal +
                ", status='" + statusPedido + '\'' +
                '}';
    }

}
