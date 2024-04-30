package br.com.fiap.vendaCRUD.model;


import br.com.fiap.vendaCRUD.dto.enderecoDto.AtualizacaoEnderecoDto;
import br.com.fiap.vendaCRUD.dto.enderecoDto.CadastroEnderecoDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name="endereco")
@EntityListeners(AuditingEntityListener.class)
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "endereco")
    @SequenceGenerator(name = "endereco", sequenceName = "seq_endereco", allocationSize = 1)
    @Column(name="id_endereco")
    private Long id;

    @Column(name="rua", length = 100,  nullable = false)
    private String rua;

    @Column(name="numero", length = 10,  nullable = false)
    private String numero;

    @Column(name="cidade", length = 50,  nullable = false)
    private String cidade;

    @Column(name="estado", length = 50, nullable = false)
    private String estado;

    @Column(name="cep", length = 20,  nullable = false)
    private String cep;

    public Endereco(CadastroEnderecoDto enderecoDto) {
        rua = enderecoDto.rua();
        numero = enderecoDto.numero();
        cidade =enderecoDto.cidade();
        estado = enderecoDto.estado();
        cep = enderecoDto.cep();
    }

    public void atualizarInformacoesEndereco(AtualizacaoEnderecoDto dto) {
        if (dto.rua() != null)
            rua = dto.rua();
        if (dto.numero() != null)
            numero = dto.numero();
        if (dto.cidade() != null)
            cidade = dto.cidade();
        if (dto.estado() != null)
            estado = dto.estado();
        if (dto.cep() != null)
            cep = dto.cep();
    }


}
