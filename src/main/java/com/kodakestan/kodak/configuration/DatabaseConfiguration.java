//package com.kodakestan.kodak.configuration;
//
//import com.github.mongobee.Mongobee;
//import com.kodakestan.kodak.utils.JSR310DateConverters;
//import com.mongodb.DB;
//import com.mongodb.Mongo;
//import com.mongodb.MongoClient;
//import com.mongodb.gridfs.GridFS;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
//import org.springframework.boot.autoconfigure.mongo.MongoProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Import;
//import org.springframework.core.convert.converter.Converter;
//import org.springframework.data.mongodb.config.EnableMongoAuditing;
//import org.springframework.data.mongodb.core.MongoTemplate;
//import org.springframework.data.mongodb.core.convert.MongoCustomConversions;
//import org.springframework.data.mongodb.core.mapping.event.ValidatingMongoEventListener;
//import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
//import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
//
//import javax.inject.Inject;
//import java.util.ArrayList;
//import java.util.List;
//
//
//@Configuration
//@Profile("!" + Constants.SPRING_PROFILE_CLOUD)
//@EnableMongoRepositories("com.kodakestan.kodak.dao")
//@Import(value = MongoAutoConfiguration.class)
//@EnableMongoAuditing(auditorAwareRef = "springSecurityAuditorAware")
//public class DatabaseConfiguration {
//
//    private final Logger log = LoggerFactory.getLogger(DatabaseConfiguration.class);
//
//    @Inject
//    private Mongo mongo;
//
//    @Inject
//    private MongoProperties mongoProperties;
//
//    @Value("${spring.data.mongodb.mongoAddress}")
//    private String mongoAddress;
//
//    @Value("${spring.data.mongodb.database}")
//    private String mongoDatabase;
//
//    @Value("${spring.data.mongodb.mongoPort}")
//    private Integer mongoPort;
//
//    @Value("${spring.data.mongodb.uri}")
//    private String uri;
//
//    @Bean
//    public ValidatingMongoEventListener validatingMongoEventListener() {
//        return new ValidatingMongoEventListener(validator());
//    }
//
//    @Bean
//    public LocalValidatorFactoryBean validator() {
//        return new LocalValidatorFactoryBean();
//    }
//
//
//    protected String getDatabaseName() {
//        return mongoProperties.getDatabase();
//    }
//
//
//    public Mongo mongo() throws Exception {
//        return mongo;
//    }
//
//    @Bean
//    public MongoCustomConversions customConversions() {
//        List<Converter<?, ?>> converters = new ArrayList<>();
//        converters.add(JSR310DateConverters.DateToZonedDateTimeConverter.INSTANCE);
//        converters.add(JSR310DateConverters.ZonedDateTimeToDateConverter.INSTANCE);
//        return new MongoCustomConversions(converters);
//    }
//
//
//    @Bean
//    public Mongobee mongobee(MongoClient mongoClient, MongoTemplate mongoTemplate, MongoProperties mongoProperties) {
//        log.debug("Configuring Mongobee");
//        Mongobee mongobee = new Mongobee(mongoClient);
//        mongobee.setDbName(mongoProperties.getMongoClientDatabase());
//        mongobee.setMongoTemplate(mongoTemplate);
//        // package to scan for migrations
//        mongobee.setChangeLogsScanPackage("com.kodakestan.kodak.configuration.dbmigrations");
//        mongobee.setEnabled(true);
//        return mongobee;
//    }
//
//
//    private MongoClient mongoClient = null;
//
//    @Bean
//    public MongoClient mongoClient() {
//        if (mongoClient == null)
//            mongoClient = new MongoClient(mongoAddress, mongoPort);
//        return mongoClient;
//    }
//
//    @Bean
//    public GridFS gridFS() {
//        DB db = mongoClient().getDB(mongoDatabase);
//        return new GridFS(db);
//    }
//
//
//}