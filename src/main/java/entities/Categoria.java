package entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "categorias")
@Getter
@Setter
@NamedQueries({
        @NamedQuery(name = "categorias.All", query = "SELECT c FROM Categoria c"),
})
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private Long id;

    @Column(name = "nombre", length = 100, nullable = false)
    private String nombre;
}
