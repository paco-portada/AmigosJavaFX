package sample;

import java.time.LocalDate;

public class Persona {
    String nombre;
    String movil;
    String email;
    String ciudad;
    LocalDate nacimiento;

    public Persona(String nombre, String movil, String email, String ciudad, LocalDate nacimiento) {
        this.nombre = nombre;
        this.movil = movil;
        this.email = email;
        this.ciudad = ciudad;
        this.nacimiento = nacimiento;
    }

    @Override
    public String toString() {
        return  "nombre='" + nombre + '\'' +
                ", movil='" + movil + '\'' +
                ", email='" + email + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", nacimiento=" + nacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMovil() {
        return movil;
    }

    public void setMovil(String movil) {
        this.movil = movil;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public LocalDate getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(LocalDate nacimiento) {
        this.nacimiento = nacimiento;
    }
}
