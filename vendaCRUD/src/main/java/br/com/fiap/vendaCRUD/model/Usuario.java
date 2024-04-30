package br.com.fiap.vendaCRUD.model;


import br.com.fiap.vendaCRUD.dto.usuarioDto.AtualizacaoUsuarioDto;
import br.com.fiap.vendaCRUD.dto.usuarioDto.CadastroUsuarioDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name="usuario")
@EntityListeners(AuditingEntityListener.class)
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario")
    @SequenceGenerator(name = "usuario", sequenceName = "seq_usuario", allocationSize = 1)
    @Column(name="id_usuario")
    private Long id;

    @Column(name="nome", length = 100,  nullable = false)
    private String nome;

    @Column(name="email", length = 100,  nullable = false)
    private String email;

    @Column(name="senha", length = 50,  nullable = false)
    private String senha;

    public Usuario(CadastroUsuarioDto usuarioDto) {
        nome = usuarioDto.nome();
        email = usuarioDto.email();
        senha = usuarioDto.senha();
    }

    public void atualizarInformacoesUsuario(AtualizacaoUsuarioDto dto) {
        if (dto.nome() != null)
            nome = dto.nome();
        if (dto.email() != null)
            email = dto.email();
        if(dto.email() != null)
            senha = dto.senha();
    }


}
