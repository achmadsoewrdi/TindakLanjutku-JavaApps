/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tindaklanjutku.custom;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;

public class CustomTable extends JTable {

    public CustomTable() {
        // Model tabel dengan kolom contoh
        DefaultTableModel model = new DefaultTableModel(
            new Object[]{"Nama", "Usia", "Email"}, 0
        );
        setModel(model);
        
        // Konfigurasi tampilan dasar
        setAutoCreateRowSorter(true);
        setRowHeight(30);
        setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        setGridColor(new Color(220, 220, 220));
        setShowGrid(true);
        
        // Atur renderer kustom
        setDefaultRenderer(Object.class, new CustomCellRenderer());
        
        // Atur header kustom
        JTableHeader header = getTableHeader();
        header.setDefaultRenderer(new CustomHeaderRenderer());
        header.setReorderingAllowed(false);
    }

    // Renderer untuk sel tabel
    private static class CustomCellRenderer extends DefaultTableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(
            JTable table, Object value, 
            boolean isSelected, boolean hasFocus, 
            int row, int column
        ) {
            Component comp = super.getTableCellRendererComponent(
                table, value, isSelected, hasFocus, row, column
            );
            
            // Warna baris bergantian
            if (!isSelected) {
                if (row % 2 == 0) {
                    comp.setBackground(new Color(240, 248, 255)); // AliceBlue
                } else {
                    comp.setBackground(Color.WHITE);
                }
            }
            
            // Styling teks
            setHorizontalAlignment(SwingConstants.CENTER);
            setFont(new Font("Segoe UI", Font.PLAIN, 14));
            setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
            
            return comp;
        }
    }

    // Renderer untuk header tabel
    private static class CustomHeaderRenderer extends DefaultTableCellRenderer {
        public CustomHeaderRenderer() {
            setHorizontalAlignment(SwingConstants.CENTER);
            setOpaque(true);
        }
        
        @Override
        public Component getTableCellRendererComponent(
            JTable table, Object value,
            boolean isSelected, boolean hasFocus,
            int row, int column
        ) {
            super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            setBackground(new Color(70, 130, 180)); // SteelBlue
            setForeground(Color.WHITE);
            setFont(new Font("Segoe UI", Font.BOLD, 14));
            setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
            return this;
        }
    }

    // Contoh penggunaan
    public static void main(String[] args) {
        JFrame frame = new JFrame("Custom Table Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        
        CustomTable table = new CustomTable();
        
        // Tambahkan data contoh
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.addRow(new Object[]{"Budi Santoso", 25, "budi@example.com"});
        model.addRow(new Object[]{"Siti Rahayu", 30, "siti@example.com"});
        model.addRow(new Object[]{"Ahmad Fauzi", 22, "ahmad@example.com"});
        model.addRow(new Object[]{"Dewi Anggraini", 28, "dewi@example.com"});
        
        frame.add(new JScrollPane(table));
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}