package edu.escuelaing.arep.dockerspark.Connection;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import static com.mongodb.client.model.Aggregates.limit;
import static com.mongodb.client.model.Sorts.*;

public class DBConnection {

    public static MongoClient mongoClient;

    public static void connect() {
        // Conexión a base de datos mongodb

        //URL para Atlasdb en la nube
        String connstr = "mongodb+srv://admin:admin@arep-docker-taller1.z39iyuv.mongodb.net/?retryWrites=true&w=majority";

        //URL para conexión local
        //String connstr ="mongodb://localhost:40000/?retryWrites=true&w=majority";

        //Crea objeto de tipo ConnectionString
        ConnectionString connectionString = new ConnectionString(connstr);

        //Crea objeto con configuraciones para el cliente mongo
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .serverApi(ServerApi.builder()
                        .version(ServerApiVersion.V1)
                        .build())
                .build();

        //Crea una instancia del cliente mongo conectado a la base de datos
        mongoClient = MongoClients.create(settings);

    }

    /**
     * Funcion generada para insertar valores de la cadena dentro de la base de datos Atlas
     */
    public static void insertIntoDB(String valueChain) {
        MongoDatabase database = mongoClient.getDatabase("AREP-DOCKER-TALLER1");
        MongoCollection<Document> chains = database.getCollection("cadenas");

        //Crea un documento BSON con el cliente
        Document chain = new Document("_id", new ObjectId());
        chain.append("Value", valueChain);
        chain.append("createdAt", LocalDateTime.now());

        //Agrega el nuevo cliente a la colección
        chains.insertOne(chain);

        //Creacion del orden de la coleccion
        Bson orderBySort = orderBy(descending("createdAt"));
        //Impresion de cadenas
        printChains(chains,orderBySort);
    }

    /**
     * Funcion generada para imprimir los ultimos 10 registros de la coleccion cadenas
     * @param chains
     */
    public static void printChains(MongoCollection<Document> chains,Bson ordeBySort){
        FindIterable<Document> iterable = chains.find().sort(ordeBySort).limit(10);
        for (Document d : iterable) {
            System.out.println(d);
        }
    }
}
