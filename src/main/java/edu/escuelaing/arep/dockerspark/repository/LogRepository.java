package edu.escuelaing.arep.dockerspark.repository;

import edu.escuelaing.arep.dockerspark.entities.Cadena;
import org.springframework.data.mongodb.repository.MongoRepository;

public class LogRepository extends MongoRepository<Cadena,String> {
}
