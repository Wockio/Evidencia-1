import java.util.Scanner;
import java.io.*;

abstract class identificador {
    public String ID;

    public String getID() {
        return ID;
    }
    public void setID(String ID) {
        this.ID = ID;
    }

    public String generarID() {
        int numero = (int)(Math.random()*101010);
        return String.valueOf(numero);
    }
}

class doctor extends identificador {
    private String doctorNombre;
    private String doctorTipo;

    public doctor(String ID, String doctorNombre, String doctorTipo) {
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

    public paciente(String ID, String pacienteNombre) {
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

    public cita(String ID, String citaFecha, String citaHora, String citaMotivo) {
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
        File archivo = new File("db\\info.csv");

        do {
            System.out.println("Indique si desea registrar a un doctor, un paciente o una cita.");
            opcion.setOpcion(scanner.nextLine());
            switch (opcion.getOpcion()) {
                case "doctor", "Doctor":
                    doctor doctor = new doctor();
                    doctor.setID(doctor.generarID());
                    System.out.println(doctor.getID());
                    System.out.println("Teclee el nombre del doctor.");
                    doctor.setDoctorNombre(scanner.nextLine());
                    System.out.println("Teclee la especialidad del doctor.");
                    doctor.setDoctorTipo(scanner.nextLine());

                    try (FileWriter escritor = new FileWriter("db\\info.csv")) {
                        escritor.write(doctor.getID());
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                        opcion.setOpcion("");
                    }
                    break;

                case "paciente", "Paciente":
                    paciente paciente = new paciente();
                    numero = (int)(Math.random()*101010);
                    paciente.setID(numero);
                    System.out.println("Teclee el nombre del paciente.");
                    paciente.setPacienteNombre(scanner.nextLine());
                    break;

                case "cita", "Cita":
                    cita cita = new cita();
                    numero = (int)(Math.random()*101010);
                    cita.setID(numero);
                    System.out.println("Teclee la fecha de la cita.");
                    cita.setCitaFecha(scanner.nextLine());
                    System.out.println("Teclee la hora de la cita.");
                    cita.setCitaHora(scanner.nextLine());
                    System.out.println("Teclee el motivo de la cita.");
                    cita.setCitaMotivo(scanner.nextLine());
                    break;

                default:
                    System.out.println("Vuelva a intentarlo.");
                    opcion.setOpcion(scanner.nextLine());
                    break;
            }
        } while (!opcion.getOpcion().equals("doctor") && !opcion.getOpcion().equals("paciente") && !opcion.getOpcion().equals("cita") && !opcion.getOpcion().equals("Doctor") && !opcion.getOpcion().equals("Paciente") && !opcion.getOpcion().equals("Cita"));
    }
}