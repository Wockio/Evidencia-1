abstract class identificador {
    public int ID;

    public int getID() {
        return ID;
    }
    public void setID(int ID) {
        this.ID = ID;
    }
}

class doctor extends identificador {
    private String doctorNombre;
    private String doctorTipo;

    public doctor (int ID, String doctorNombre, String doctorTipo) {
        this.ID = ID;
        this.doctorNombre = doctorNombre;
        this.doctorTipo = doctorTipo;
    }

    public String getDoctorNombre() {
        return doctorNombre;
    }
    public void setDoctorNombre(String doctorNombre) {
        this.doctorNombre = doctorNombre;
    }

    public String getDoctorTipo() {
        return doctorTipo;
    }
    public void setDoctorTipo(String doctorTipo) {
        this.doctorTipo = doctorTipo;
    }
}

class paciente extends identificador {
    private String pacienteNombre;

    public paciente (int ID, String pacienteNombre) {
        this.ID = ID;
        this.pacienteNombre = pacienteNombre;
    }

    public String getPacienteNombre() {
        return pacienteNombre;
    }
    public void setPacienteNombre(String pacienteNombre) {
        this.pacienteNombre = pacienteNombre;
    }
}

class cita extends identificador {
    private String citaFecha;
    private String citaHora;
    private String citaMotivo;

    public cita (int ID, String citaFecha, String citaHora, String citaMotivo) {
        this.ID = ID;
        this.citaFecha = citaFecha;
        this.citaHora = citaHora;
        this.citaMotivo = citaMotivo;
    }

    public String getCitaFecha() {
        return citaFecha;
    }
    public void setCitaFecha(String citaFecha) {
        this.citaFecha = citaFecha;
    }

    public String getCitaHora() {
        return citaHora;
    }
    public void setCitaHora(String citaHora) {
        this.citaHora = citaHora;
    }

    public String getCitaMotivo() {
        return citaMotivo;
    }
    public void setCitaMotivo(String citaMotivo) {
        this.citaMotivo = citaMotivo;
    }
}

public class Ev1 {

    public static void main(String[] args) {

    }
}
