package org.example.endtermapi.repository;

import org.example.endtermapi.db.DatabaseConnection;
import org.example.endtermapi.model.Medicine;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcMedicineRepository {

    // GET ALL
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

        con.close();
        return list;
    }

    // CREATE
    public void save(Medicine medicine) throws SQLException {
        Connection con = DatabaseConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(
                "INSERT INTO medicines (medicine_id, medicine_name, price) VALUES (?, ?, ?)"
        );

        ps.setInt(1, medicine.getId());
        ps.setString(2, medicine.getName());
        ps.setDouble(3, medicine.getPrice());

        ps.executeUpdate();
        con.close();
    }

    // UPDATE
    public void update(int id, Medicine medicine) throws SQLException {
        Connection con = DatabaseConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(
                "UPDATE medicines SET medicine_name = ?, price = ? WHERE medicine_id = ?"
        );

        ps.setString(1, medicine.getName());
        ps.setDouble(2, medicine.getPrice());
        ps.setInt(3, id);

        ps.executeUpdate();
        con.close();
    }

    // DELETE
    public void delete(int id) throws SQLException {
        Connection con = DatabaseConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(
                "DELETE FROM medicines WHERE medicine_id = ?"
        );

        ps.setInt(1, id);
        ps.executeUpdate();
        con.close();
    }
}
