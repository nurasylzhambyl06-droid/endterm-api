package patterns.singleton;

public class DatabaseConfig {

    private static DatabaseConfig instance;

    private final String url = "jdbc:postgresql://localhost:5433/Pharmacy";
    private final String user = "postgres";
    private final String password = "nur@syl2439";

    private DatabaseConfig() {}

    public static DatabaseConfig getInstance() {
        if (instance == null) {
            instance = new DatabaseConfig();
        }
        return instance;
    }

    public String getUrl() { return url; }
    public String getUser() { return user; }
    public String getPassword() { return password; }
}
