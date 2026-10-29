package id.my.hendisantika.taxesdemowebflux;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.mysql.MySQLContainer;
import org.testcontainers.rabbitmq.RabbitMQContainer;

@Testcontainers
@SpringBootTest
class SpringBootTaxesDemoWebfluxApplicationTests {

    @Container
    static final MySQLContainer mysql = new MySQLContainer("mysql:9.4.0")
            .withDatabaseName("taxes_db")
            .withUsername("yu71")
            .withPassword("53cret");

    @Container
    static final GenericContainer<?> mongo = new GenericContainer<>("mongo:8")
            .withEnv("MONGO_INITDB_ROOT_USERNAME", "admin")
            .withEnv("MONGO_INITDB_ROOT_PASSWORD", "password")
            .withExposedPorts(27017);

    @Container
    static final RabbitMQContainer rabbitmq = new RabbitMQContainer("rabbitmq:4-management")
            .withAdminUser("admin")
            .withAdminPassword("password");

    @DynamicPropertySource
    static void properties(DynamicPropertyRegistry registry) {
        registry.add("r2dbc.mysql.host", mysql::getHost);
        registry.add("r2dbc.mysql.port", () -> mysql.getMappedPort(3306));
        registry.add("no-sql.mongo.host", mongo::getHost);
        registry.add("no-sql.mongo.port", () -> mongo.getMappedPort(27017));
        registry.add("spring.rabbitmq.host", rabbitmq::getHost);
        registry.add("spring.rabbitmq.port", rabbitmq::getAmqpPort);
        registry.add("rabbitmq.host", rabbitmq::getHost);
        registry.add("rabbitmq.port", rabbitmq::getAmqpPort);
    }

    @Test
    void contextLoads() {
    }

}
