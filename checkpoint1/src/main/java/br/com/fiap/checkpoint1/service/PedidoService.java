package br.com.fiap.checkpoint1.service;

import br.com.fiap.checkpoint1.model.Pedido;
import br.com.fiap.checkpoint1.repository.PedidoRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PedidoService {
    private final PedidoRepository repository;

    public PedidoService(PedidoRepository repository) {
        this.repository = repository;
    }

    public List<Pedido> listarPedidos() {
        return repository.findAll();
    }

    public Pedido buscarPedido(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
    }

    public Pedido criarPedido(Pedido pedido) {
        return repository.save(pedido);
    }

    public Pedido atualizarPedido(Long id, Pedido pedido) {
        if (!repository.existsById(id)) throw new RuntimeException("Pedido não encontrado");
        pedido.setId(id);
        return repository.save(pedido);
    }

    public void deletarPedido(Long id) {
        repository.deleteById(id);
    }
}
