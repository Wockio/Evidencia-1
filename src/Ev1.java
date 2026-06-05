import java.util.Scanner;

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

    public doctor(int ID, String doctorNombre, String doctorTipo) {
        this.ID = ID;
        this.doctorNombre = doctorNombre;
        this.doctorTipo = doctorTipo;
    }
    public doctor() {
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

    public paciente(int ID, String pacienteNombre) {
        this.ID = ID;
        this.pacienteNombre = pacienteNombre;
    }
    public paciente() {
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

    public cita(int ID, String citaFecha, String citaHora, String citaMotivo) {
        this.ID = ID;
        this.citaFecha = citaFecha;
        this.citaHora = citaHora;
        this.citaMotivo = citaMotivo;
    }
    public cita() {
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

class opcion {
    String opcion;

    public String getOpcion() {
        return opcion;
    }
    public void setOpcion(String opcion) {
        this.opcion = opcion;
    }
}

public class Ev1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        opcion opcion = new opcion();

        do {
            System.out.println("Indique si desea registrar a un doctor, un paciente o una cita.");
            opcion.setOpcion(scanner.nextLine());
            switch (opcion.getOpcion()) {
                case "doctor", "Doctor":
                    doctor doctor = new doctor();
                    int numero = (int)(Math.random()*100001);
                    doctor.setID(numero);
                    System.out.println("Teclee el nombre del doctor");
                    doctor.setDoctorNombre(scanner.nextLine());
                    System.out.println("Teclee la especialidad del doctor");
                    doctor.setDoctorTipo(scanner.nextLine());
                    break;

                case "paciente", "Paciente":
                    break;

                case "cita", "Cita":
                    break;

                default:
                    System.out.println("Vuelva a intentarlo.");
                    opcion.setOpcion(scanner.nextLine());
                    break;
            }
        } while (!opcion.getOpcion().equals("doctor") && !opcion.getOpcion().equals("paciente") && !opcion.getOpcion().equals("cita") && !opcion.getOpcion().equals("Doctor") && !opcion.getOpcion().equals("Paciente") && !opcion.getOpcion().equals("Cita"));
    }
}