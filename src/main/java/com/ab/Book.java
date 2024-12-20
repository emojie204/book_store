/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.ab;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Acer
 */
public class Book extends javax.swing.JFrame {
public  String ids = "";   
    /**
     * Creates new form Book
     */
    
    
    
    
    
    
    
    
    public Book() {
        initComponents();
        getAuthorData();
        getPublisherData();
        getGenreData();
        loadData();
    }
       
        
        
        private void getAuthorData(){
            
            try{
                String sql = "Select * From author";
                Connection con = DriverManager.getConnection(CommonDb.URL,CommonDb.USERNAME,CommonDb.PASSWORD);
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(sql);
                while(rs.next()){
                    String authorName = rs.getString("name");
                    cbbAuthorName.addItem(authorName);
                }
            }
            catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
        private void getPublisherData(){
            try{
                String sql = "Select * From publisher";
                Connection con = DriverManager.getConnection(CommonDb.URL,CommonDb.USERNAME,CommonDb.PASSWORD);
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(sql);
                while(rs.next()){
                    String publisherName = rs.getString("name");
                    cbbPublisher.addItem(publisherName);
                }

            }
            catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
        private void getGenreData(){
            try{
                String sql = "Select * From genre";
                Connection con = DriverManager.getConnection(CommonDb.URL,CommonDb.USERNAME,CommonDb.PASSWORD);
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(sql);
                while(rs.next()){
                    String genreName = rs.getString("name");
                    cbbGenre.addItem(genreName);
                }

            }
            catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
        private void loadData(){
        
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Id");
        model.addColumn("Isbn Code");
        model.addColumn("Book Title");
        model.addColumn("Author Name");
        model.addColumn("Publication Year");
        model.addColumn("Publisher Name");
        model.addColumn("Price");
        model.addColumn("Genre Name");
        model.addColumn("Number Of Page");

        
        try{
        
            String sql = "";
            sql += "SELECT ";
            sql += "    book.id, book.isbn_code, book.book_title, ";
            sql += "	book.publication_year, book.price, book.num_page, ";
            sql += "	author.name as author_name, ";
            sql += "	genre.name as genre_name, ";
            sql += "	publisher.name as publisher_name ";
            sql += "FROM ";
            sql += "	book JOIN author ";
            sql += "	ON book.author_id = author.id ";
            sql += "	JOIN genre ON book.genre_id = genre.id ";
            sql += "	JOIN publisher ON book.publisher_id = publisher.id ";
            sql += "ORDER BY ";
            sql += "	book_title ASC ";

            Connection con = DriverManager.getConnection(CommonDb.URL,CommonDb.USERNAME,CommonDb.PASSWORD);

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
        while(rs.next()){
            String id = rs.getString("id");
            String isbnCode = rs.getString("isbn_code");
            String bookTitle = rs.getString("book_title");
            String publicationYear = rs.getString("publication_year");
            String price = rs.getString("price");
            String numOfPage = rs.getString("num_page");
            String authorName = rs.getString("author_name");
            String genreName = rs.getString("genre_name");
            String publisherName = rs.getString("publisher_name");
            
            model.addRow(new Object[]{id,isbnCode,bookTitle,authorName,publicationYear,publisherName,price,genreName,numOfPage});
        }
        }
         catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    tblBook.setModel(model);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblBook = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        txtCode = new javax.swing.JTextField();
        txtBookTitle = new javax.swing.JTextField();
        txtPublicationYear = new javax.swing.JTextField();
        txtNumofPage = new javax.swing.JTextField();
        txtPrice = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        cbbAuthorName = new javax.swing.JComboBox<>();
        cbbPublisher = new javax.swing.JComboBox<>();
        cbbGenre = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblBook.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblBook.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblBookMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblBook);

        jLabel1.setText("ID");

        jLabel2.setText("isbn code");

        jLabel3.setText("Book Title");

        jLabel4.setText("Author Name");

        jLabel5.setText("Publication Year");

        jLabel6.setText("Publisher Name");

        jLabel7.setText("Number of Page");

        jLabel8.setText("Genre Name");

        jLabel9.setText("Price");

        txtPublicationYear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPublicationYearActionPerformed(evt);
            }
        });

        txtPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPriceActionPerformed(evt);
            }
        });

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnSave.setText("Save");
        btnSave.setEnabled(false);
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnUpdate.setText("Update");
        btnUpdate.setEnabled(false);
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnCancel.setText("Cancel");
        btnCancel.setEnabled(false);
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.setEnabled(false);
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        cbbAuthorName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select author" }));
        cbbAuthorName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbAuthorNameActionPerformed(evt);
            }
        });

        cbbPublisher.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select publisher" }));

        cbbGenre.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Genre" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 747, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(cbbPublisher, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(txtPublicationYear))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(33, 33, 33)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtId, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                                            .addComponent(txtCode)
                                            .addComponent(txtBookTitle)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(32, 32, 32)
                                        .addComponent(cbbAuthorName, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(135, 135, 135)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addGap(73, 73, 73)
                                        .addComponent(txtPrice))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel8))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtNumofPage)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(cbbGenre, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE))))))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnEdit)
                                            .addComponent(btnAdd))
                                        .addGap(96, 96, 96))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnCancel)
                                        .addGap(82, 82, 82)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnDelete)
                                    .addComponent(btnSave)
                                    .addComponent(btnUpdate))
                                .addGap(113, 113, 113)))))
                .addGap(308, 308, 308))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel7)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNumofPage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(txtCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbGenre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel9)
                    .addComponent(txtBookTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(btnAdd)
                    .addComponent(btnSave)
                    .addComponent(cbbAuthorName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtPublicationYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEdit)
                    .addComponent(btnUpdate))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(btnCancel)
                    .addComponent(btnDelete)
                    .addComponent(cbbPublisher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPriceActionPerformed

    private void txtPublicationYearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPublicationYearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPublicationYearActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        
        
        String id = txtId.getText().toString().trim();
        String isbnCode = txtCode.getText().toString().trim();
        String bookTitle = txtBookTitle.getText().toString().trim();
        String authorName = cbbAuthorName.getSelectedItem().toString();
        int authorId = new AddAuthor().getIdAuthor(authorName);
        String publicationYear = txtPublicationYear.getText().toString().trim();
        String publisherName = cbbPublisher.getSelectedItem().toString();
        String numofPage = txtNumofPage.getText().toString().trim();
        int publisherId = new AddPublisher().getIdPublisher(publisherName);
        String genreName = cbbGenre.getSelectedItem().toString();
        int genreId = new AddGenre().getIdGenre(genreName);

        String price = txtPrice.getText().toString().trim();
        //lấy dữ liệu gán cho biến 
        
        boolean isExist = false;
        //tạo biến isExist để kiểm tra xem dữ liệu unique đã tồn tại chưa
        try{
        
            String sql = "Select * From book where book_title = '"+bookTitle+"' or isbn_code ='"+isbnCode+"'";
            //câu lệnh lấy dữ liệu từ bảng book
            Connection con = DriverManager.getConnection(CommonDb.URL,CommonDb.USERNAME,CommonDb.PASSWORD);
            //kết nối với database
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                isExist = true;
                //nêú tồn tại dữ liệu trùng thì biến isExist sẽ thành true
            }
    
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        if(isExist == true){
            JOptionPane.showMessageDialog(new JFrame(), "Book Title:"+bookTitle+" or isbn Code :"+isbnCode+" is exist",
            "Information", JOptionPane.WARNING_MESSAGE);
            //sau khi kiểm tra xem isExist là true thì sẽ báo lỗi tồn tại cho người dùng
            return;
        }
        if(id.equals("") || isbnCode.equals("")||bookTitle.equals("")
            ||authorName.equals("")||publicationYear.equals("")||publisherName.equals("")
            ||numofPage.equals("")||genreName.equals("")||price.equals("")){
            //kiểm tra xem phần điền chữ có đủ dữ liêu hay không
            //nếu không sẽ báo lỗi
            JOptionPane.showMessageDialog(new JFrame(), "Not null!",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }else{
            try{
        
                String sql = "Insert into book value ";
                sql += "("+id+","+isbnCode+",'"+bookTitle+"',"+authorId+","+publicationYear+","+genreId+","+publisherId+","+price+","+numofPage+")";
                //viết câu lệnh chèn dữ liệu
                Connection con = DriverManager.getConnection(CommonDb.URL,CommonDb.USERNAME,CommonDb.PASSWORD);
                Statement st = con.createStatement();
                System.out.println(sql);
                st.executeUpdate(sql);
        
        
                JOptionPane.showMessageDialog(new JFrame(), "Success",
                    "Information", JOptionPane.INFORMATION_MESSAGE);
                loadData();            }
            catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }       
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        btnSave.setEnabled(true);
        btnCancel.setEnabled(true);
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        String id = txtId.getText().toString().trim();
        String isbnCode = txtCode.getText().toString().trim();
        String bookTitle = txtBookTitle.getText().toString().trim();
        String authorName = cbbAuthorName.getSelectedItem().toString();
        int authorId = new AddAuthor().getIdAuthor(authorName);
        String publicationYear = txtPublicationYear.getText().toString().trim();
        String publisherName = cbbPublisher.getSelectedItem().toString();
        String numofPage = txtNumofPage.getText().toString().trim();
        int publisherId = new AddPublisher().getIdPublisher(publisherName);
        String genreName = cbbGenre.getSelectedItem().toString();
        int genreId = new AddGenre().getIdGenre(genreName);
        String price = txtPrice.getText().toString().trim();

        if(authorId==0||publisherId==0||genreId==0){
            JOptionPane.showMessageDialog(new JFrame(), "Choose full values",
                    "Information", JOptionPane.ERROR_MESSAGE);
        }else{
            try{
                String sql = "update book set  "
                + "id =  '"+id+"',"
                + "isbn_code =  '"+isbnCode+"',"
                + "book_title =  '"+bookTitle+"' ,"                        
                + "author_id =  '"+authorId+"' ,"                        
                + "publication_year =  '"+publicationYear+"' ,"                        
                + "publisher_id =  '"+publisherId+"' ,"                        
                + "genre_id =  '"+genreId+"' ,"                        
                + "price =  '"+price+"' ,"                        
                + "num_page =  '"+numofPage+"' "                        
                + "where id = "+id+"";
                Connection con = DriverManager.getConnection(CommonDb.URL,CommonDb.USERNAME,CommonDb.PASSWORD);
                Statement st = con.createStatement();
                st.executeUpdate(sql);
                JOptionPane.showMessageDialog(new JFrame(), "Update Success",
                        "Information", JOptionPane.INFORMATION_MESSAGE);
                loadData();
            }
            
            catch (Exception ex) {
               System.out.println(ex.getMessage());
           }
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
        btnUpdate.setEnabled(true);
        btnCancel.setEnabled(true);
    }//GEN-LAST:event_btnEditActionPerformed

    private void tblBookMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBookMousePressed
        // TODO add your handling code here:
        int rowIndex = tblBook.getSelectedRow();
        String id = tblBook.getModel().getValueAt(rowIndex, 0).toString();
        String isbnCode = tblBook.getModel().getValueAt(rowIndex, 1).toString();
        String bookTitle = tblBook.getModel().getValueAt(rowIndex, 2).toString();
        String authorName = tblBook.getModel().getValueAt(rowIndex, 3).toString();
        String publicationYear = tblBook.getModel().getValueAt(rowIndex, 4).toString();
        String publisherName = tblBook.getModel().getValueAt(rowIndex, 5).toString();
        String price = tblBook.getModel().getValueAt(rowIndex, 6).toString();
        String genreName = tblBook.getModel().getValueAt(rowIndex, 7).toString();
        String numOfPage = tblBook.getModel().getValueAt(rowIndex, 8).toString();
        txtId.setText(id);
        txtCode.setText(isbnCode);
        txtBookTitle.setText(bookTitle);
        cbbAuthorName.getSelectedItem().toString();
        txtPublicationYear.setText(publicationYear);
        cbbPublisher.getSelectedItem().toString();
        txtPrice.setText(price);
        cbbGenre.getSelectedItem().toString();
        txtNumofPage.setText(numOfPage);
        ids = id;
        btnDelete.setEnabled(true);
    }//GEN-LAST:event_tblBookMousePressed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        try{        
        String sql = "delete from book "
                + "where id= '"+ids+"'";        
        Connection con = DriverManager.getConnection(CommonDb.URL,CommonDb.USERNAME,CommonDb.PASSWORD);       
        Statement st = con.createStatement();
        st.executeUpdate(sql);      
        JOptionPane.showMessageDialog(new JFrame(), "Success",
                    "Information", JOptionPane.INFORMATION_MESSAGE);
        loadData();
        }
         catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void cbbAuthorNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbAuthorNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbAuthorNameActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
        btnSave.setEnabled(false);
        btnUpdate.setEnabled(false);
    }//GEN-LAST:event_btnCancelActionPerformed

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
            java.util.logging.Logger.getLogger(Book.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Book.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Book.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Book.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Book().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cbbAuthorName;
    private javax.swing.JComboBox<String> cbbGenre;
    private javax.swing.JComboBox<String> cbbPublisher;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblBook;
    private javax.swing.JTextField txtBookTitle;
    private javax.swing.JTextField txtCode;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNumofPage;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtPublicationYear;
    // End of variables declaration//GEN-END:variables
}
