package br.com.fiap.checkpoint1.service;

import br.com.fiap.checkpoint1.model.Pedido;
import br.com.fiap.checkpoint1.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository repository;

    public List<Pedido> listarPedidos() {
        return repository.findAll();
    }

    public Optional<Pedido> buscarPedidoPorId(Long id) {
        return repository.findById(id);
    }

    public Pedido salvarPedido(Pedido pedido) {
        return repository.save(pedido);
    }

    public Pedido atualizarPedido(Long id, Pedido pedidoAtualizado) {
        if (repository.existsById(id)) {
            pedidoAtualizado.setId(id);
            return repository.save(pedidoAtualizado);
        }
        throw new RuntimeException("Pedido não encontrado.");
    }

    public void deletarPedido(Long id) {
        repository.deleteById(id);
    }
}
