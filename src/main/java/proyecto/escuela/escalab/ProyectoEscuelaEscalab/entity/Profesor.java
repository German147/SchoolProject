package proyecto.escuela.escalab.ProyectoEscuelaEscalab.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "profesor")
@ApiModel(description = "Información o propiedes del Profesor")
public class Profesor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_profesor")
    private Integer id;

    @Column(name = "nombres", length = 50)
    @ApiModelProperty(notes = "Se debe ingresar uno o mas nombres correspondientes al profesor")
    @Size(min = 4, max = 50, message = "Debes ingresar ambos Nombres")
    @NotEmpty
    private String nombres;

    @Column(name = "apellidos", length = 50)
    @ApiModelProperty(notes = "Se debe ingresar uno o mas apellidos correspondientes al profesor")
    @Size(min = 4, max = 50, message = "Debes ingresar ambos Apellidos")
    @NotEmpty
    private String apellidos;

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
    @ApiModelProperty(notes = "Se debe ingresar un telefono propio o de un familiar al profesor")
    @Size(min = 9, max = 12, message = "Debes ingresar un Teléfono válido")
    @NotEmpty
    private String telefono;

    @Column(name = "email", length = 50)
    @ApiModelProperty(notes = "Se debe ingresar un mail de uso frecuente")
    @Size(min = 4, max = 50, message = "Debes ingresar un Nombre válido")
    @Email(message = "Debes ingresar un tipo de Email válido")
    @NotEmpty
    private String email;

    @Column(name = "imagen")
    @ApiModelProperty(notes = "Se debe ingresar una imagen actualizada del profesor")
    private String imagen;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}
