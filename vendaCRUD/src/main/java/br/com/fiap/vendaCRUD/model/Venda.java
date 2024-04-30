package br.com.fiap.vendaCRUD.model;

import br.com.fiap.vendaCRUD.dto.vendaDto.AtualizacaoVendaDto;
import br.com.fiap.vendaCRUD.dto.vendaDto.CadastroVendaDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name="venda")
@EntityListeners(AuditingEntityListener.class)
public class Venda{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "venda")
    @SequenceGenerator(name = "venda", sequenceName = "seq_venda", allocationSize = 1)
    @Column(name="id_venda")
    private Long id;

    @Column(name="quantidade",  nullable = false)
    private Integer quantidade;

    @Column(name="data_venda",  nullable = false)
    private LocalDate dataVenda;


    public Venda(CadastroVendaDto vendaDto) {
        quantidade = vendaDto.quantidade();
        dataVenda = vendaDto.dataVenda();
    }

    public void atualizarInformacoesVenda(AtualizacaoVendaDto dto) {
        if (dto.quantidade() != null)
            quantidade = dto.quantidade();
        if (dto.dataVenda() != null)
            dataVenda = dto.dataVenda();
    }

}
