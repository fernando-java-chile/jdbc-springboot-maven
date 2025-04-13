package InterSystemIrisData.com.example.jdbc_springboot_maven;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.sql.DataSource;

import InterSystemIrisData.com.example.jdbc_springboot_maven.Tables.TableCreatorFHIR_PACIENT_CL_1_9_2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JdbcSpringbootMavenApplication implements CommandLineRunner {

	@Autowired
	DataSource dataSource;

	public static void main(String[] args) {
		SpringApplication.run(JdbcSpringbootMavenApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		try (Connection dbconnection = dataSource.getConnection()) {
			// Verificar si la tabla existe
			boolean tableExists = false;
			try (PreparedStatement checkStmt = dbconnection.prepareStatement(
					"SELECT 1 FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_NAME = ?"
			)) {
				checkStmt.setString(1, "webinar");
				try (ResultSet rs = checkStmt.executeQuery()) {
					if (rs.next()) {
						tableExists = true;
					}
				}
			}

			// Crear la tabla solo si no existe
			if (!tableExists) {
				try (PreparedStatement createStmt = dbconnection.prepareStatement(
						"CREATE TABLE webinar (WebinarID int, Creador varchar(255), Fecha datetime)"
				)) {
					createStmt.execute();
					System.out.println("Tabla 'webinar' creada.");
				}
			} else {
				System.out.println("La tabla 'webinar' ya existe.");
			}

			// Insertar datos en la tabla
			/*
			for (int i = 0; i < 20; i++) {
				try (PreparedStatement insertStmt = dbconnection.prepareStatement(
						"INSERT INTO SQLUser.webinar (WebinarID, Creador, Fecha) VALUES (?, 'LUIS', CURRENT_TIMESTAMP)"
				)) {
					insertStmt.setInt(1, i);
					insertStmt.execute();
				}
			}
			 */
			TableCreatorFHIR_PACIENT_CL_1_9_2 tableCreator = new TableCreatorFHIR_PACIENT_CL_1_9_2(dbconnection);
			tableCreator.createFhirPacientTable();
			System.out.println("Datos insertados correctamente.");

		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
