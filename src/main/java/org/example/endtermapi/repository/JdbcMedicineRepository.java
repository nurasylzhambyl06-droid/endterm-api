package org.example.endtermapi.repository;

import org.example.endtermapi.db.DatabaseConnection;
import org.example.endtermapi.model.Medicine;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcMedicineRepository {

    public List<Medicine> findAll() throws SQLException {
        List<Medicine> list = new ArrayList<>();

        Connection con = DatabaseConnection.getConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM medicines");

        while (rs.next()) {
            list.add(new Medicine(
                    rs.getInt("medicine_id"),
                    rs.getString("medicine_name"),
                    rs.getDouble("price")
            ));
        }

        return list;
    }
}
