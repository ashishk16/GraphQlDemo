package com.example.Controllers;

import ch.qos.logback.classic.spi.LoggerRemoteView;
import com.example.DataFetcher.AllPeopleDataFetcher;
import com.example.DataFetcher.PersonDataFetcher;
import graphql.ExecutionResult;
import graphql.GraphQL;
import graphql.schema.DataFetcher;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;

//import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;
import static graphql.GraphQL.*;
import static graphql.schema.idl.RuntimeWiring.*;

@RestController
public class QueryController {

    @Value("classpath:person.graphqls")
    private Resource schemaResource;

    private GraphQL graphQL;

    @Autowired
    private AllPeopleDataFetcher allPeopleDataFetcher;
    @Autowired
    private PersonDataFetcher personDataFetcher;
//    @Autowired
//    private AddressDataFetcher addressDataFetcher;

    @PostConstruct
    public void loadSchema() throws IOException {
        File schemaFile = schemaResource.getFile();
        TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(schemaFile);
        RuntimeWiring wiring = buildRuntimeWiring();
        GraphQLSchema schema = new SchemaGenerator().makeExecutableSchema(typeRegistry, wiring);
        graphQL = newGraphQL(schema).build();
    }

    private RuntimeWiring buildRuntimeWiring() {
        return newRuntimeWiring()
                .type("Query", typeWiring ->  typeWiring.dataFetcher("allPeople", allPeopleDataFetcher)
                        .dataFetcher("person", personDataFetcher))
//                .type("Person", typeWiring -> typeWiring.dataFetcher("addresses", addressDataFetcher))
                .build();
    }

    @RequestMapping(value = "/query", method = RequestMethod.POST)
    public ResponseEntity query(@RequestBody String query){
        ExecutionResult result = graphQL.execute(query);
//        LOGGER.info(String.valueOf(result.getErrors()));
        return ResponseEntity.ok(result.getData());
    }


}
