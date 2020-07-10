package edu.idat.dto;

public class ConsultaActorDTO {

    private Long id;
    private String apellidosActor;
    private String nombresActor;
    private String papeldeReparto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getApellidosActor() {
        return apellidosActor;
    }

    public void setApellidosActor(String apellidosActor) {
        this.apellidosActor = apellidosActor;
    }

    public String getNombresActor() {
        return nombresActor;
    }

    public void setNombresActor(String nombresActor) {
        this.nombresActor = nombresActor;
    }

    public String getPapeldeReparto() {
        return papeldeReparto;
    }

    public void setPapeldeReparto(String papeldeReparto) {
        this.papeldeReparto = papeldeReparto;
    }
}
