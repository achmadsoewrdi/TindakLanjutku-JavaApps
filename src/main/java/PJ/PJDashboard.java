/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package PJ;

import auth.SessionManager;
import com.mycompany.tindaklanjutku.Koneksi;
import com.mycompany.tindaklanjutku.tugas.loginForm;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS VIVO
 */
public class PJDashboard extends javax.swing.JFrame {

    private String username;
    private Integer id_pj;
    public PJDashboard(String username, Integer id_pj) {
        initComponents();
        this.username = username;
        this.id_pj = SessionManager.getInstance().getIdPJ();
        loadNamaPJ(this.id_pj);
        loadTaskCount(this.id_pj);
    }
    
private void loadNamaPJ(int idPJ) {
    try (Connection conn = Koneksi.configDB()) {
        String sql = "SELECT u.namaUsr FROM penanggung_jawab pj " +
                     "JOIN user u ON pj.id_user = u.id_usr " +
                     "WHERE pj.id_pj = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idPJ);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    String nama = rs.getString("namaUsr");
                    namaUsr.setText(nama); // asumsi namaUsr adalah JLabel atau komponen GUI lain
                }
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
    }
}

    
    private void loadTaskCount(int idPj) {  // Tambahkan parameter idPj
    try (Connection con = Koneksi.configDB()) {
        // Hitung tugas selesai untuk PJ tertentu
        String sqlSelesai = "SELECT COUNT(*) FROM tugas WHERE status = 'selesai' AND id_pj = ?";
        try (PreparedStatement ps = con.prepareStatement(sqlSelesai)) {
            ps.setInt(1, idPj);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    totalSelesai.setText(String.valueOf(rs.getInt(1)));
                }
            }
        }

        // Hitung tugas progress untuk PJ tertentu
        String sqlProgress = "SELECT COUNT(*) FROM tugas WHERE status = 'progres' AND id_pj = ?";
        try (PreparedStatement ps = con.prepareStatement(sqlProgress)) {
            ps.setInt(1, idPj);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    totalProgress.setText(String.valueOf(rs.getInt(1)));
                }
            }
        }

        // Hitung tugas belum dimulai untuk PJ tertentu
        String sqlBelumDimulai = "SELECT COUNT(*) FROM tugas WHERE status = 'belum' AND id_pj = ?";
        try (PreparedStatement ps = con.prepareStatement(sqlBelumDimulai)) {
            ps.setInt(1, idPj);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    totalBelum.setText(String.valueOf(rs.getInt(1)));
                }
            }
        }

        // Hitung total tugas (ini tetap global, tidak terkait PJ)
        String sqlTotalTugas = "SELECT COUNT(*) FROM tugas WHERE id_pj = ?";
        try (PreparedStatement ps = con.prepareStatement(sqlTotalTugas)) {
            ps.setInt(1, idPj);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    total.setText(String.valueOf(rs.getInt(1)));
                }
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
    }
}
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelCustom1 = new com.mycompany.tindaklanjutku.custom.panelCustom();
        labelTotal1 = new javax.swing.JLabel();
        panelCustom2 = new com.mycompany.tindaklanjutku.custom.panelCustom();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        dashboardItem = new javax.swing.JButton();
        anggota = new javax.swing.JButton();
        catatanKerjaItem = new javax.swing.JButton();
        Logout = new javax.swing.JButton();
        tugasItem1 = new javax.swing.JButton();
        cardTotal = new com.mycompany.tindaklanjutku.custom.panelCustom();
        labelTotal = new javax.swing.JLabel();
        total = new javax.swing.JLabel();
        cardBelum = new com.mycompany.tindaklanjutku.custom.panelCustom();
        lebelBelum = new javax.swing.JLabel();
        totalBelum = new javax.swing.JLabel();
        cardSelesai = new com.mycompany.tindaklanjutku.custom.panelCustom();
        labelSelesai = new javax.swing.JLabel();
        totalSelesai = new javax.swing.JLabel();
        cardProgress = new com.mycompany.tindaklanjutku.custom.panelCustom();
        labelProgress = new javax.swing.JLabel();
        totalProgress = new javax.swing.JLabel();
        namaUsr = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Dashboard PJ");
        setPreferredSize(new java.awt.Dimension(1111, 741));

        panelCustom1.setBackground(new java.awt.Color(255, 255, 255));
        panelCustom1.setPreferredSize(new java.awt.Dimension(1111, 741));
        panelCustom1.setRoundBottomLeft(8);
        panelCustom1.setRoundBottomRight(8);
        panelCustom1.setRoundTopLeft(8);
        panelCustom1.setRoundTopRight(8);

        labelTotal1.setFont(new java.awt.Font("Poppins", 1, 24)); // NOI18N
        labelTotal1.setForeground(new java.awt.Color(102, 102, 255));
        labelTotal1.setText("Selamat Datang Kembali!");

        panelCustom2.setBackground(new java.awt.Color(78, 75, 209));
        panelCustom2.setRoundBottomLeft(8);
        panelCustom2.setRoundTopLeft(8);

        jLabel2.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/list.png"))); // NOI18N
        jLabel2.setText("Tindak Lanjutku");

        jSeparator1.setForeground(new java.awt.Color(204, 204, 204));

        dashboardItem.setBackground(new java.awt.Color(78, 75, 209));
        dashboardItem.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        dashboardItem.setForeground(new java.awt.Color(255, 255, 255));
        dashboardItem.setText("Dashboard");
        dashboardItem.setBorder(null);
        dashboardItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dashboardItemActionPerformed(evt);
            }
        });

        anggota.setBackground(new java.awt.Color(78, 75, 209));
        anggota.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        anggota.setForeground(new java.awt.Color(255, 255, 255));
        anggota.setText("Anggota");
        anggota.setBorder(null);
        anggota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anggotaActionPerformed(evt);
            }
        });

        catatanKerjaItem.setBackground(new java.awt.Color(78, 75, 209));
        catatanKerjaItem.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        catatanKerjaItem.setForeground(new java.awt.Color(255, 255, 255));
        catatanKerjaItem.setText("Catatan Kerja");
        catatanKerjaItem.setBorder(null);
        catatanKerjaItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                catatanKerjaItemActionPerformed(evt);
            }
        });

        Logout.setBackground(new java.awt.Color(255, 51, 51));
        Logout.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        Logout.setForeground(new java.awt.Color(255, 255, 255));
        Logout.setText("Logout");
        Logout.setBorder(null);
        Logout.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutActionPerformed(evt);
            }
        });

        tugasItem1.setBackground(new java.awt.Color(78, 75, 209));
        tugasItem1.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        tugasItem1.setForeground(new java.awt.Color(255, 255, 255));
        tugasItem1.setText("Daftar Tugas");
        tugasItem1.setBorder(null);
        tugasItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tugasItem1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelCustom2Layout = new javax.swing.GroupLayout(panelCustom2);
        panelCustom2.setLayout(panelCustom2Layout);
        panelCustom2Layout.setHorizontalGroup(
            panelCustom2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
            .addComponent(dashboardItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(anggota, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(catatanKerjaItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Logout, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(tugasItem1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelCustom2Layout.setVerticalGroup(
            panelCustom2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCustom2Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dashboardItem, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tugasItem1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(anggota, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(catatanKerjaItem, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Logout, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        cardTotal.setBackground(new java.awt.Color(204, 204, 255));
        cardTotal.setRoundBottomLeft(16);
        cardTotal.setRoundBottomRight(16);
        cardTotal.setRoundTopLeft(16);
        cardTotal.setRoundTopRight(16);

        labelTotal.setFont(new java.awt.Font("Poppins", 1, 24)); // NOI18N
        labelTotal.setForeground(new java.awt.Color(102, 102, 255));
        labelTotal.setText("Total Tugas Di Berikan");

        total.setBackground(new java.awt.Color(102, 102, 255));
        total.setFont(new java.awt.Font("Poppins", 1, 36)); // NOI18N
        total.setForeground(new java.awt.Color(102, 102, 255));
        total.setText("0");

        javax.swing.GroupLayout cardTotalLayout = new javax.swing.GroupLayout(cardTotal);
        cardTotal.setLayout(cardTotalLayout);
        cardTotalLayout.setHorizontalGroup(
            cardTotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardTotalLayout.createSequentialGroup()
                .addContainerGap(237, Short.MAX_VALUE)
                .addGroup(cardTotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cardTotalLayout.createSequentialGroup()
                        .addComponent(labelTotal)
                        .addGap(214, 214, 214))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cardTotalLayout.createSequentialGroup()
                        .addComponent(total)
                        .addGap(339, 339, 339))))
        );
        cardTotalLayout.setVerticalGroup(
            cardTotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardTotalLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(labelTotal)
                .addGap(40, 40, 40)
                .addComponent(total)
                .addContainerGap(107, Short.MAX_VALUE))
        );

        cardBelum.setBackground(new java.awt.Color(255, 204, 204));
        cardBelum.setPreferredSize(new java.awt.Dimension(195, 289));
        cardBelum.setRoundBottomLeft(16);
        cardBelum.setRoundBottomRight(16);
        cardBelum.setRoundTopLeft(16);
        cardBelum.setRoundTopRight(16);

        lebelBelum.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        lebelBelum.setForeground(new java.awt.Color(255, 102, 102));
        lebelBelum.setText("Belum Selesai");

        totalBelum.setFont(new java.awt.Font("Poppins", 1, 24)); // NOI18N
        totalBelum.setForeground(new java.awt.Color(255, 102, 102));
        totalBelum.setText("0");

        javax.swing.GroupLayout cardBelumLayout = new javax.swing.GroupLayout(cardBelum);
        cardBelum.setLayout(cardBelumLayout);
        cardBelumLayout.setHorizontalGroup(
            cardBelumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cardBelumLayout.createSequentialGroup()
                .addContainerGap(47, Short.MAX_VALUE)
                .addComponent(lebelBelum)
                .addGap(46, 46, 46))
            .addGroup(cardBelumLayout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addComponent(totalBelum)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        cardBelumLayout.setVerticalGroup(
            cardBelumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardBelumLayout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addComponent(lebelBelum)
                .addGap(18, 18, 18)
                .addComponent(totalBelum)
                .addContainerGap(93, Short.MAX_VALUE))
        );

        cardSelesai.setBackground(new java.awt.Color(204, 255, 204));
        cardSelesai.setRoundBottomLeft(16);
        cardSelesai.setRoundBottomRight(16);
        cardSelesai.setRoundTopLeft(16);
        cardSelesai.setRoundTopRight(16);

        labelSelesai.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        labelSelesai.setForeground(new java.awt.Color(51, 204, 0));
        labelSelesai.setText("selesai");

        totalSelesai.setFont(new java.awt.Font("Poppins", 1, 24)); // NOI18N
        totalSelesai.setForeground(new java.awt.Color(51, 204, 0));
        totalSelesai.setText("0");

        javax.swing.GroupLayout cardSelesaiLayout = new javax.swing.GroupLayout(cardSelesai);
        cardSelesai.setLayout(cardSelesaiLayout);
        cardSelesaiLayout.setHorizontalGroup(
            cardSelesaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardSelesaiLayout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addGroup(cardSelesaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelSelesai)
                    .addGroup(cardSelesaiLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(totalSelesai)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        cardSelesaiLayout.setVerticalGroup(
            cardSelesaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardSelesaiLayout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(labelSelesai)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(totalSelesai)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        cardProgress.setBackground(new java.awt.Color(255, 255, 204));
        cardProgress.setRoundBottomLeft(16);
        cardProgress.setRoundBottomRight(16);
        cardProgress.setRoundTopLeft(16);
        cardProgress.setRoundTopRight(16);

        labelProgress.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        labelProgress.setForeground(new java.awt.Color(204, 204, 0));
        labelProgress.setText("Progress");

        totalProgress.setFont(new java.awt.Font("Poppins", 1, 24)); // NOI18N
        totalProgress.setForeground(new java.awt.Color(204, 204, 0));
        totalProgress.setText("0");

        javax.swing.GroupLayout cardProgressLayout = new javax.swing.GroupLayout(cardProgress);
        cardProgress.setLayout(cardProgressLayout);
        cardProgressLayout.setHorizontalGroup(
            cardProgressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cardProgressLayout.createSequentialGroup()
                .addContainerGap(79, Short.MAX_VALUE)
                .addGroup(cardProgressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelProgress)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cardProgressLayout.createSequentialGroup()
                        .addComponent(totalProgress)
                        .addGap(22, 22, 22)))
                .addGap(73, 73, 73))
        );
        cardProgressLayout.setVerticalGroup(
            cardProgressLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardProgressLayout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addComponent(labelProgress)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(totalProgress)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        namaUsr.setFont(new java.awt.Font("Poppins", 1, 24)); // NOI18N
        namaUsr.setForeground(new java.awt.Color(102, 102, 255));
        namaUsr.setText("Nama");

        javax.swing.GroupLayout panelCustom1Layout = new javax.swing.GroupLayout(panelCustom1);
        panelCustom1.setLayout(panelCustom1Layout);
        panelCustom1Layout.setHorizontalGroup(
            panelCustom1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCustom1Layout.createSequentialGroup()
                .addComponent(panelCustom2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addGroup(panelCustom1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCustom1Layout.createSequentialGroup()
                        .addComponent(labelTotal1)
                        .addGap(18, 18, 18)
                        .addComponent(namaUsr))
                    .addGroup(panelCustom1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelCustom1Layout.createSequentialGroup()
                            .addComponent(cardBelum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(cardSelesai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGap(18, 18, 18)
                            .addComponent(cardProgress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(cardTotal, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(70, Short.MAX_VALUE))
        );
        panelCustom1Layout.setVerticalGroup(
            panelCustom1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelCustom2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCustom1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(panelCustom1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTotal1)
                    .addComponent(namaUsr))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cardTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelCustom1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cardBelum, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
                    .addComponent(cardSelesai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cardProgress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(79, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelCustom1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelCustom1, javax.swing.GroupLayout.DEFAULT_SIZE, 740, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void dashboardItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dashboardItemActionPerformed
        new PJDashboard(username,id_pj).setVisible(true);
        dispose();
    }//GEN-LAST:event_dashboardItemActionPerformed

    private void anggotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anggotaActionPerformed
        new Anggota(username).setVisible(true);
        dispose();
    }//GEN-LAST:event_anggotaActionPerformed

    private void catatanKerjaItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_catatanKerjaItemActionPerformed
        new LogCatatan(username).setVisible(true);
        dispose();
    }//GEN-LAST:event_catatanKerjaItemActionPerformed

    private void LogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutActionPerformed
        try {
            // Show confirmation dialog
            int confirm = JOptionPane.showConfirmDialog(
                this,
                "Apakah Anda yakin ingin logout?",
                "Konfirmasi Logout",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
            );

            if (confirm == JOptionPane.YES_OPTION) {

                // Close current window
                this.dispose();

                // Open login form
                java.awt.EventQueue.invokeLater(() -> {
                    new loginForm().setVisible(true);
                    dispose();
                });

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                this,
                "Error saat logout: " + e.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE
            );
            e.printStackTrace();
        }
    }//GEN-LAST:event_LogoutActionPerformed

    private void tugasItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tugasItem1ActionPerformed
        new daftarTugas(id_pj,username).setVisible(true);
        dispose();
    }//GEN-LAST:event_tugasItem1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PJDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PJDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PJDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PJDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PJDashboard("achmad",3).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Logout;
    private javax.swing.JButton anggota;
    private com.mycompany.tindaklanjutku.custom.panelCustom cardBelum;
    private com.mycompany.tindaklanjutku.custom.panelCustom cardProgress;
    private com.mycompany.tindaklanjutku.custom.panelCustom cardSelesai;
    private com.mycompany.tindaklanjutku.custom.panelCustom cardTotal;
    private javax.swing.JButton catatanKerjaItem;
    private javax.swing.JButton dashboardItem;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel labelProgress;
    private javax.swing.JLabel labelSelesai;
    private javax.swing.JLabel labelTotal;
    private javax.swing.JLabel labelTotal1;
    private javax.swing.JLabel lebelBelum;
    private javax.swing.JLabel namaUsr;
    private com.mycompany.tindaklanjutku.custom.panelCustom panelCustom1;
    private com.mycompany.tindaklanjutku.custom.panelCustom panelCustom2;
    private javax.swing.JLabel total;
    private javax.swing.JLabel totalBelum;
    private javax.swing.JLabel totalProgress;
    private javax.swing.JLabel totalSelesai;
    private javax.swing.JButton tugasItem1;
    // End of variables declaration//GEN-END:variables
}
