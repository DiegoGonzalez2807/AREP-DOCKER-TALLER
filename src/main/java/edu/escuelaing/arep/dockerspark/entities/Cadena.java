package edu.escuelaing.arep.dockerspark.entities;

import org.springframework.data.annotation.Id;

import java.time.LocalDate;

/**
 * @author Diego Gonzalez
 */
public class Cadena {

    @Id
    String id;
    String cadena;

    String createdAt;

    /**
     * Constructor vacio, donde en caso que se quiera crear una cadena pero no se le de algun valor
     * Se crea una cadena con un identificador generado y con la fecha actual
     */
    public Cadena(){
        this.id = String.valueOf(Math.floor(Math.random()*10+1));
        this.createdAt = LocalDate.now().toString();
    }

    /**
     * Constructor donde se le da a la cadena un identificador y su valor de cadena
     * @param id
     * @param cadenaValue
     */
    public Cadena(String id, String cadenaValue, String createdAt){
        this.id = id;
        this.cadena = cadenaValue;
        this.createdAt = createdAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCadena() {
        return cadena;
    }

    public void setCadena(String cadena) {
        this.cadena = cadena;
    }
}
