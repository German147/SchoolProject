package proyecto.escuela.escalab.ProyectoEscuelaEscalab.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel(description = "Información o propiedes del apoderado")
public class Apoderado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_apoderado")
    private Integer id;

    @Column(name = "nombres", length = 50)
    @ApiModelProperty(notes = "Se debe ingresar uno o mas nombres correspondientes al apoderado")
    @Size(min = 4, max = 50, message = "Debes ingresar un Nombre válido")
    @NotEmpty
    private String nombres;

    @Column(name = "apellidos", length = 50)
    @ApiModelProperty(notes = "Se debe ingresar uno o mas apellidos correspondientes al apoderado")
    @Size(min = 4, max = 50, message = "Debes ingresar ambos Apellidos")
    @NotEmpty
    private String apellidos;

    @Column(name = "parentesco", length = 50)
    @ApiModelProperty(notes = "El parentezco es al vinculo familiar que se tiene con el alumno (padre, tutor, padrastro, etc)")
    @Size(min = 4, max = 50, message = "Debes ingresar un Parentesco válido")
    @NotEmpty
    private String parentesco;

    @Column(name = "fecha_nacimiento")
    @ApiModelProperty(notes = "Se debe ingresarfecha de nacimiento en el siguiente formato  dia/mes/año ejemplo 24-05-200")
    @NotNull
    private LocalDate fechaNacimiento;

    @Column(name = "dni", length = 10)
    @ApiModelProperty(notes = "Se debe ingresar el Dni del alumno tal cual figura en su documento")
    @Size(min = 9, max = 10, message = "Debes ingresar un Dni válido")
    @NotEmpty
    private String dni;

    @Column(name = "direccion", length = 50)
    @ApiModelProperty(notes = "Se debe ingresar la direccion que figure en el documento")
    @Size(min = 4, max = 50, message = "Debes ingresar una Dirección válida")
    @NotEmpty
    private String direccion;

    @Column(name = "telefono", length = 12)
    @ApiModelProperty(notes = "Se debe ingresar un telefono propio o de un familiar")
    @Size(min = 9, max = 12, message = "Debes ingresar un Teléfono válido")
    @NotEmpty
    private String telefono;

    @Column(name = "email", length = 50)
    @ApiModelProperty(notes = "Se debe ingresar un mail de uso frecuente")
    @Size(min = 4, max = 50, message = "Debes ingresar un email válido")
    @Email(message = "Debes ingresar un tipo de Email válido")
    @NotEmpty
    private String email;

    @ManyToOne
    @JoinColumn(name = "id_alumno", nullable = false)
    private Alumno alumno;

}
