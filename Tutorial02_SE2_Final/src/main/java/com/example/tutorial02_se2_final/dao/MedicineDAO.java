package com.example.tutorial02_se2_final.dao;

import com.example.tutorial02_se2_final.dbconnect.DBConnect;
import com.example.tutorial02_se2_final.entity.Medicine;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MedicineDAO {
    //establish DB connection
    private Connection connection;

    public MedicineDAO() {
//        connection = DBConnect.makeConnection();
    }

    public List<Medicine> selectMedicine() {
        List<Medicine> medicineList = new ArrayList<>();
        try {
            String selectSQL = "SELECT * FROM warehouse1";
            PreparedStatement preparedStatement = connection.prepareStatement(selectSQL);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int medicine_id = resultSet.getInt("medicine_id");
                int medicine_price = resultSet.getInt("medicine_price");
                String medicine_name = resultSet.getString("medicine_name");
                String medicine_brand = resultSet.getString("medicine_brand");

                Medicine medicine = new Medicine(medicine_id, medicine_brand, medicine_name, medicine_price);
                medicineList.add(medicine);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return medicineList;
    }

    public void deleteMedicine(int id) {
        try {
            Statement stmt = connection.createStatement();
            String deleteSQL = "DELETE FROM warehouse1 WHERE id=" + id + ";";
            stmt.executeUpdate(deleteSQL);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
