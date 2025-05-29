/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.tindaklanjutku;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author shaeh
 */
public class Koneksi {

    /**
     * @param args the command line arguments
     */
    
    public static Connection konfig;
    
    public static Connection configDB() throws SQLException{
        try {
//        inisialisasi variable untuk nama db
        String url = "jdbc:mysql://localhost/tindak_lanjutku";
        
//        Driver        
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        
//        Membuat Koneksi
        konfig = DriverManager.getConnection(url, "root", "");
        
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return konfig;
    }
    
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        Connection penghubung = (Connection)Koneksi.configDB();
    }
    
}
