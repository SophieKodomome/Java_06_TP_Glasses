package connexion;

import java.sql.*;
import java.util.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

import eyeglass.*;

public class DBCon {
    public static ArrayList<Monture> getListMonture() {
        ArrayList<Monture> montureList = new ArrayList<>();
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "solo", "maso");

            Statement stmnt = con.createStatement();

            ResultSet resultatMonture = stmnt.executeQuery("SELECT * FROM Monture");

            while (resultatMonture.next()) {
                Monture monture = new Monture();
                monture.setID(resultatMonture.getInt("Id"));
                monture.setName(resultatMonture.getString("nom"));
                monture.setImgsrc(resultatMonture.getString("img"));
                monture.setPrix(resultatMonture.getInt("prix"));
                monture.setStock(resultatMonture.getInt("stock"));
                montureList.add(monture);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return montureList;
    }

    public static ArrayList<Lense> getListLense() {
        ArrayList<Lense> lenseList = new ArrayList<>();
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "solo", "maso");

            Statement stmnt = con.createStatement();

            ResultSet resultatLense = stmnt.executeQuery("SELECT * FROM Lense");

            while (resultatLense.next()) {
                Lense lense = new Lense();
                lense.setID(resultatLense.getInt("Id"));
                lense.setName(resultatLense.getString("nom"));
                lense.setImgsrc(resultatLense.getString("img"));
                lense.setPrix(resultatLense.getInt("prix"));
                lense.setStock(resultatLense.getInt("stock"));
                lenseList.add(lense);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return lenseList;
    }
}
