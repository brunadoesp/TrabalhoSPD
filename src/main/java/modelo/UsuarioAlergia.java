package modelo;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "usuarios_alergias")
public class UsuarioAlergia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "alergia_id")
    private Alergia alergia;

    public UsuarioAlergia() {
    }

    public UsuarioAlergia(Usuario usuario, Alergia alergia) {
        this.usuario = usuario;
        this.alergia = alergia;
    }

    public int getId() {
        return id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Alergia getAlergia() {
        return alergia;
    }

    public void setAlergia(Alergia alergia) {
        this.alergia = alergia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsuarioAlergia that = (UsuarioAlergia) o;
        return id == that.id &&
                Objects.equals(usuario, that.usuario) &&
                Objects.equals(alergia, that.alergia);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, usuario, alergia);
    }
}
