package br.com.fiap.vendaCRUD.model;

import br.com.fiap.vendaCRUD.dto.produtoDto.AtualizacaoProdutoDto;
import br.com.fiap.vendaCRUD.dto.produtoDto.CadastroProdutoDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name="produto")
@EntityListeners(AuditingEntityListener.class)
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "produto")
    @SequenceGenerator(name = "produto", sequenceName = "seq_produto", allocationSize = 1)
    @Column(name="id_produto")
    private Long id;

    @Column(name="nome", length = 100, nullable = false)
    private String nome;

    @Column(name="descricao", length = 500,  nullable = false)
    private String descricao;

    @Column(name="preco", nullable = false)
    private Double preco;

    @Enumerated(EnumType.STRING)
    @Column(name="tipo_produto",  nullable = false)
    private TipoProduto tipoProduto;

    public Produto(CadastroProdutoDto produtoDto) {
        nome = produtoDto.nome();
        descricao = produtoDto.descricao();
        preco = produtoDto.preco();
        tipoProduto = produtoDto.tipoProduto();
    }

    public void atualizarInformacoesProduto(AtualizacaoProdutoDto dto) {
        if (dto.nome() != null)
            nome = dto.nome();
        if (dto.descricao() != null)
            descricao = dto.descricao();
        if (dto.preco() != null)
            preco = dto.preco();
        if (dto.tipoProduto() != null)
            tipoProduto = dto.tipoProduto();
    }


}
