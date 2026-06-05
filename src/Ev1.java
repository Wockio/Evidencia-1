import java.util.HashSet;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

abstract class ID {
    String ID;

    public String getID() {
        return ID;
    }
    public void setID(String ID) {
        this.ID = ID;
    }

    static HashSet<Integer> listaID = new HashSet<>();

    public String generarID() {
        int nuevoID = 0;
        while (nuevoID < 100000) {
            nuevoID = (int)(Math.random()*1000000);
        }

        listaID.add(nuevoID);
        String nuevoIDString = String.valueOf(nuevoID);
        return nuevoIDString;
    }
}

class cita extends ID {
    String doctorNombre;
    String pacienteNombre;
    private String citaFecha;
    private String citaHora;
    private String citaMotivo;

    public cita(String ID, String citaFecha, String citaHora, String citaMotivo) {
        this.doctorNombre = doctorNombre;
        this.pacienteNombre = pacienteNombre;
        this.ID = ID;
        this.citaFecha = citaFecha;
        this.citaHora = citaHora;
        this.citaMotivo = citaMotivo;
    }
    public cita() {
        this.doctorNombre = doctorNombre;
        this.pacienteNombre = pacienteNombre;
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
    public String getDoctorNombre() {
        return doctorNombre;
    }
    public void setDoctorNombre(String doctorNombre) {
        this.doctorNombre = doctorNombre;
    }
    public String getPacienteNombre() {
        return pacienteNombre;
    }
    public void setPacienteNombre(String pacienteNombre) {
        this.pacienteNombre = pacienteNombre;
    }
}

class doctor extends cita {
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

    public String getDoctorTipo() {
        return doctorTipo;
    }
    public void setDoctorTipo(String doctorTipo) {
        this.doctorTipo = doctorTipo;
    }
}

class paciente extends cita {
    public paciente(String ID, String pacienteNombre) {
        this.ID = ID;
        this.pacienteNombre = pacienteNombre;
    }
    public paciente() {
        this.ID = ID;
        this.pacienteNombre = pacienteNombre;
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

        String passID = "";
        int passIDnum = 0;
        String password = "";

        do {
            System.out.print("Identificador: ");
            passID = scanner.nextLine();

            try {
                passIDnum = Integer.valueOf(passID);
            } catch (NumberFormatException e) {
                System.out.println("Ingresa un numero.");
            } finally {
                System.out.println();
            }
        } while (passIDnum < 100000);

        do {
            System.out.print("Contraseña: ");
            password = scanner.nextLine();
            System.out.println();
        } while (!password.equals("tecmilenio"));

        opcion opcion = new opcion();

        do {
            System.out.println();
            System.out.println("Indique si desea registrar a un doctor, un paciente o una cita.");
            System.out.println("Para cerrar el programa, teclee 'terminar'.");
            opcion.setOpcion(scanner.nextLine());
            switch (opcion.getOpcion()) {
                case "doctor", "Doctor":
                    doctor doctor = new doctor();
                    doctor.setID(doctor.generarID());
                    System.out.println("Teclee el nombre del doctor.");
                    doctor.setDoctorNombre(scanner.nextLine());
                    System.out.println("Teclee la especialidad del doctor.");
                    doctor.setDoctorTipo(scanner.nextLine());

                    try (FileWriter escritor = new FileWriter("db\\informacion.csv", true)) {
                        escritor.write((doctor.getID()) + "," + "Doctor" + "," + (doctor.getDoctorNombre()) + "," + (doctor.getDoctorTipo()) + "," + "\n");
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    } finally {
                        opcion.setOpcion("");
                        System.out.println();
                    }
                    break;

                case "paciente", "Paciente":
                    paciente paciente = new paciente();
                    paciente.setID(paciente.generarID());
                    System.out.println("Teclee el nombre del paciente.");
                    paciente.setPacienteNombre(scanner.nextLine());

                    try (FileWriter escritor = new FileWriter("db\\informacion.csv", true)) {
                        escritor.write((paciente.getID()) + "," + "Paciente" + "," + (paciente.getPacienteNombre()) + "," + "\n");
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    } finally {
                        opcion.setOpcion("");
                        System.out.println();
                    }
                    break;

                case "cita", "Cita":
                    cita cita = new cita();
                    cita.setID(cita.generarID());
                    System.out.println("Teclee el nombre del doctor en la cita.");
                    cita.setDoctorNombre(scanner.nextLine());
                    System.out.println("Teclee el nombre del paciente en la cita.");
                    cita.setPacienteNombre(scanner.nextLine());
                    System.out.println("Teclee la fecha de la cita.");
                    cita.setCitaFecha(scanner.nextLine());
                    System.out.println("Teclee la hora de la cita.");
                    cita.setCitaHora(scanner.nextLine());
                    System.out.println("Teclee el motivo de la cita.");
                    cita.setCitaMotivo(scanner.nextLine());

                    try (FileWriter escritor = new FileWriter("db\\informacion.csv", true)) {
                        escritor.write((cita.getID()) + "," + "Cita" + "," + (cita.getDoctorNombre()) + "," + (cita.getPacienteNombre()) + "," + (cita.getCitaFecha()) + "," + (cita.getCitaHora()) + "," + (cita.getCitaMotivo()) + "," + "\n");
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    } finally {
                        opcion.setOpcion("");
                        System.out.println();
                    }
                    break;

                case "terminar", "Terminar":
                    System.exit(0);
                    break;
            }
        } while (!opcion.getOpcion().equals("doctor") && !opcion.getOpcion().equals("paciente") && !opcion.getOpcion().equals("cita") && !opcion.getOpcion().equals("terminar") && !opcion.getOpcion().equals("Doctor") && !opcion.getOpcion().equals("Paciente") && !opcion.getOpcion().equals("Cita") && !opcion.getOpcion().equals("Terminar"));
    }
}