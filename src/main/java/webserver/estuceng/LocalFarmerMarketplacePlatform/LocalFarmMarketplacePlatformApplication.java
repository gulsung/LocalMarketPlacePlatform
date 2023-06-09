package webserver.estuceng.LocalFarmerMarketplacePlatform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

@SpringBootApplication
public class LocalFarmMarketplacePlatformApplication {

	@Value("${spring.datasource.url}")
	private String databaseServer;

	@Value("${spring.datasource.username}")
	private String userName;

	@Value("${spring.datasource.password}")
	private String password;

	public static void main(String[] args) {
		SpringApplication.run(LocalFarmMarketplacePlatformApplication.class, args);


		try {
			DatabaseConnection connection = new DatabaseConnection(databaseServer, userName, password);

			// Execute a query
			ResultSet results = connection.executeQuery("SELECT * FROM USERS");
			while (results.next()) {
				String name = results.getString("name");
				String email = results.getString("email");
				System.out.println(name + " (" + email + ")");
			}

			// Execute an update
			int numUpdated = connection.executeUpdate("UPDATE USERS SET name = 'John Smith' WHERE email = 'john.smith@example.com'");
			System.out.println("Updated " + numUpdated + " rows");

			connection.close();
		} catch (SQLException e) {
			System.err.println("Error executing SQL: " + e.getMessage());
		}
	}


}
