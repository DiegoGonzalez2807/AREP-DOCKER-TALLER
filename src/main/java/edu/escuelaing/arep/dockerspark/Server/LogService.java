/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package edu.escuelaing.arep.dockerspark.Server;

import static spark.Spark.*;

import edu.escuelaing.arep.dockerspark.Connection.DBConnection;


import java.io.IOException;


public class LogService {
    public static void main(String[] args) throws IOException {
        port(getPort());
        //Conexion con base de datos
        staticFiles.location("/public");
        System.out.println("Initializing...");

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
        //Path encargado de retornar las 10 ultimas cadenas insertadas en la coleccion
        get("/insert/:cadenaValue", (req, res) -> {
            res.status(200);
            res.header("Access-Control-Allow-Origin", "*");
            DBConnection.connect();
            return DBConnection.insertIntoDB(req.params(":cadenaValue"));
        });
    }

    /**
     * Funcion generada para generar un puerto por defecto
     * para conectarse a la aplicacion web
     * @return
     */
    public static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }
}
