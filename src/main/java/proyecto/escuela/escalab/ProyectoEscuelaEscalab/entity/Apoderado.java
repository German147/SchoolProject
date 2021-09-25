package proyecto.escuela.escalab.ProyectoEscuelaEscalab.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "apoderado")
public class Apoderado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_apoderado")
    private Integer id;

    @Column(name = "nombres", length = 50)
    @Size(min = 4, max = 50, message = "Debes ingresar un Nombre válido")
    @NotEmpty
    private String nombres;

    @Column(name = "apellidos", length = 50)
    @Size(min = 4, max = 50, message = "Debes ingresar ambos Apellidos")
    @NotEmpty
    private String apellidos;

    @Column(name = "parentesco", length = 50)
    @Size(min = 4, max = 50, message = "Debes ingresar un Parentesco válido")
    @NotEmpty
    private String parentesco;

    @Column(name = "fecha_nacimiento")
    @NotNull
    private LocalDate fechaNacimiento;

    @Column(name = "dni", length = 10)
    @Size(min = 9, max = 10, message = "Debes ingresar un Dni válido")
    @NotEmpty
    private String dni;

    @Column(name = "direccion", length = 50)
    @Size(min = 4, max = 50, message = "Debes ingresar una Dirección válida")
    @NotEmpty
    private String direccion;

    @Column(name = "telefono", length = 12)
    @Size(min = 9, max = 12, message = "Debes ingresar un Teléfono válido")
    @NotEmpty
    private String telefono;

    @Column(name = "email", length = 50)
    @Size(min = 4, max = 50, message = "Debes ingresar un email válido")
    @Email(message = "Debes ingresar un tipo de Email válido")
    @NotEmpty
    private String email;

    @ManyToOne
    @JoinColumn(name = "id_alumno", nullable = false)
    private Alumno alumno;

}
