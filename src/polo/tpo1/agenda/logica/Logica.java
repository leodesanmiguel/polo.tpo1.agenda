package polo.tpo1.agenda.logica;

import Interfaz.Agenda;
import java.time.*;
// Se usará este paquete java.time que mejora el uso de fechas.
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Leo Martinez
 * @version 1.0 Solo usa una clase Logica
 */

public class Logica {

    // Indica la cantidad de PERSONAS. 
    private static final int PERSONAS = 10;

    /** 
     *  Utilizo variables staticas para que me conserven 
     *  el valor en todo el proceso. Se necesitó reemplazar
     *  la referencia "this" por el nombre de la clase.
     *  en este ejemplo, la clase es usada en la instancia 
     *  agenda llamada en main.
     *   
     * 
     *  LOS VECTORES FUNCIONAN COMO BASE DE DATOS
     *  Define los vectores para cada datos de las PERSONAS
     * 
     */
    private static long[] dniv = new long[PERSONAS];
    private static String[] namesv = new String[PERSONAS];
    private static String[] lastnamesv = new String[PERSONAS];
    private static String[] phonesv = new String[PERSONAS];
    private static String[] addressv = new String[PERSONAS];
    private static LocalDate[] datebornv = new LocalDate[PERSONAS];

    // Define las variables que contienen 
    // los valores de las PERSONAS
    private static long dniP;
    private static String nameP = "";
    private static String lastnameP = "";
    private static String phoneP = "";
    private static String addressP = "";
    private static LocalDate datebornP = null;

    // puntero marca en donde está el indice
    private static int puntero = 0;

    // **************************************
    // **************************************
    public static void main(String[] args) {
        Agenda ag = new Agenda();
        ag.setVisible(true);
        ag.setLocationRelativeTo(null);
    }
    // **************************************
    // **************************************
    
    
    //  Iniciar los vectores a nada.
    public void iniciarV() {
        for (int i = 0; i < dniv.length; i++) {
            dniv[i] = 0;
            namesv[i] = "";
            lastnamesv[i] = "";
            phonesv[i] = "";
            addressv[i] = "";
            datebornv[i] = fechaVacia();

        }
    }

    //  Guardar la persona en el indice del Vector
    public void guardarPersona() {
        dniv[puntero] = dniP;
        namesv[puntero] = nameP;
        lastnamesv[puntero] = lastnameP;
        phonesv[puntero] = phoneP;
        addressv[puntero] = addressP;
        datebornv[puntero] = datebornP;
    }

    // Posiciona a una Persona según el indice
    public void puntearPersona() {
        dniP = dniv[puntero];
        nameP = namesv[puntero];
        lastnameP = lastnamesv[puntero];
        phoneP = phonesv[puntero];
        addressP = addressv[puntero];
        datebornP = datebornv[puntero];
    }

    //  Mover a el indice para ADELANTE 
    public int avanzarPuntero(boolean adelante) {

        if (adelante && puntero < PERSONAS - 1) {
            puntero++;
        }
        return puntero;
    }

    //  Mover a el indice para ATRAS 
    public int atrazarPuntero(boolean atrasar) {

        if (atrasar && puntero > 0) {
            puntero--;
        }
        return puntero;
    }

    public void limpiarPersona(int nroP) {
        dniv[nroP] = 0;
        namesv[nroP] = "";
        lastnamesv[nroP] = "";
        phonesv[nroP] = "";
        addressv[nroP] = "";
        namesv[nroP] = "";
        datebornv[nroP] = fechaVacia();

    }

    // Validación de DNI
    public String getDniP() {
        String dniStr;
        if (dniP != 0) {
            return dniStr = dniP + "";
        } //  si es ditinto de cero lo agrega
        return dniStr = ""; // Sino nada.
    }

    
    public void setDniP(String dniStr) {
        if (!dniStr.equals("")) {
            dniP = Long.parseLong(dniStr);
        } else {
            dniP = 0;
        }
    }

    // Validación de Nombre (tal cual)
    public String getNameP() {
        return nameP;
    }
    
 
    public void setNameP(String nameP) {
        Logica.nameP = nameP;  
            // this es reeplazada por Logica
    }

    // Validación de Apellido (tal cual)
    public String getLastnameP() {
        return lastnameP;
    }

    public void setLastnameP(String lastnameP) {
        Logica.lastnameP = lastnameP;
    }

    // Validación de Telefono (tal cual)
    public String getPhoneP() {
        return phoneP;
    }

    public void setPhoneP(String phoneP) {
        Logica.phoneP = phoneP;
    }

    // Validación de Dirección (tal cual)
    public String getAddressP() {
        return addressP;
    }

    public void setAddressP(String addressP) {
        Logica.addressP = addressP;
    }

    // Validación de la fecha
    public String getDatebornP() {
        if (Logica.datebornP == null) {
            return "";
        } // Si no es NULA pone la fecha con formato

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        String fecha = Logica.datebornP.format(formato);
        return fecha;

    }

    public void setDatebornP(String fechaNacio) {
        try {
            if (!fechaNacio.equals("")) {
                // Colocar la fecha que encuentra.
                // indica que va a usar el formato dd/MM/yyyy
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                Logica.datebornP = LocalDate.parse(fechaNacio, formatter);

            } else {  // Sino pone null 
                Logica.datebornP = null;
            }
        } catch (Exception e) {
            System.out.println("Error al querer usar SetDAteBorn: \n" + e);
        }
    }

    private LocalDate fechaVacia() {
        LocalDate fv = null;
        // Si necesitamos que tenga otra validacion podriamos 
        // agregar esto:
        //LocalDate fv = LocalDate.parse("1/1/1900", 
        //        DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        return fv;
    }

    public LocalDate hoy() {
        LocalDate a = LocalDate.now();
        return a;
    }

    // Valida el puntero ... Veremos que pasa
    public String getPuntero() {
        return puntero + "";
    }

    public void setPuntero(int puntero) {
        Logica.puntero = puntero;
    }

}
