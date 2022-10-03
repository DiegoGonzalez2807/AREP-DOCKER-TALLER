/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package edu.escuelaing.arep.dockerspark;

import static spark.Spark.*;

/**
 *
 * @author diego
 */
public class LogService {

    public static void main(String[] args) {
        System.out.println("Initializing...");
        port(getPort());
        staticFiles.location("/public");

        //Primer PATH, se encarga de la redireccion a la pagina principal
        get("/inicio", (req, res) -> {
            res.redirect("/index.html");

            return null;
        });
        //Path para consulta vacia que puede hacer la implementacion
        get("/", (req, res) -> {
            res.redirect("/index.html");

            return null;
        });

        //Segundo path -> Se encarga de enviar la cadena para poder ingresarla a
        //la base de datos MONGO

    }

    /**
     * Funcion generada para generar un puerto por defecto
     * para conectarse a la aplicacion web
     * @return
     */
    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }
}
