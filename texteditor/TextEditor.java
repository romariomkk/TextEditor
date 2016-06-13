
package texteditor;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;


public class TextEditor extends javax.swing.JFrame {

    private String filePath = null;
    private String searchText = null;
    private int selectedStartIndex = 0;
    final private String str = "Match # ";
    ArrayList<Integer> matches;
    
    public TextEditor() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fileChooser = new javax.swing.JFileChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        textPane = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        searchInput = new javax.swing.JTextField();
        execSearch = new javax.swing.JButton();
        forwardSearchBut = new javax.swing.JButton();
        backSearchBut = new javax.swing.JButton();
        countLabel = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        newFileMenu = new javax.swing.JMenuItem();
        openFileMenu = new javax.swing.JMenuItem();
        saveFileMenu = new javax.swing.JMenuItem();
        exitMenu = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        textPane.setColumns(20);
        textPane.setLineWrap(true);
        textPane.setRows(5);
        jScrollPane1.setViewportView(textPane);

        jLabel1.setText("Enter text to search:");

        searchInput.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        execSearch.setText("SEARCH");
        execSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                execSearchActionPerformed(evt);
            }
        });

        forwardSearchBut.setText("Forward");
        forwardSearchBut.setEnabled(false);
        forwardSearchBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                forwardSearchButActionPerformed(evt);
            }
        });

        backSearchBut.setText("Back");
        backSearchBut.setEnabled(false);
        backSearchBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backSearchButActionPerformed(evt);
            }
        });

        jMenu1.setText("File");

        newFileMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        newFileMenu.setText("New");
        newFileMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newFileMenuActionPerformed(evt);
            }
        });
        jMenu1.add(newFileMenu);

        openFileMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        openFileMenu.setText("Open");
        openFileMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openFileMenuActionPerformed(evt);
            }
        });
        jMenu1.add(openFileMenu);

        saveFileMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        saveFileMenu.setText("Save");
        saveFileMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveFileMenuActionPerformed(evt);
            }
        });
        jMenu1.add(saveFileMenu);

        exitMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        exitMenu.setText("Exit");
        exitMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuActionPerformed(evt);
            }
        });
        jMenu1.add(exitMenu);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(93, Short.MAX_VALUE)
                        .addComponent(backSearchBut, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(forwardSearchBut))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(searchInput)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(execSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(countLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchInput, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(execSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(countLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(forwardSearchBut)
                        .addComponent(backSearchBut))))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void exitMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuActionPerformed
        if (!textPane.getText().isEmpty())
            if (JOptionPane.showConfirmDialog(this, "Do you want to save file first?", "Exiting", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
                saveFile();        
        System.exit(0);
    }//GEN-LAST:event_exitMenuActionPerformed

    private void saveFileMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveFileMenuActionPerformed
       saveFile();
    }//GEN-LAST:event_saveFileMenuActionPerformed

    private void openFileMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openFileMenuActionPerformed
        if (fileChooser.showOpenDialog(this) != JFileChooser.APPROVE_OPTION)
            return;
        try{
            openFile(fileChooser.getSelectedFile().getPath());
        }catch(Exception exc){
            JOptionPane.showMessageDialog(this, exc.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_openFileMenuActionPerformed

    private void newFileMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newFileMenuActionPerformed
        newFile();
    }//GEN-LAST:event_newFileMenuActionPerformed

    private void execSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_execSearchActionPerformed
        selectedStartIndex = 0;
        if (!searchInput.getText().isEmpty()){
            setSearchText(searchInput.getText());
            if (!isTextFound()){
                JOptionPane.showMessageDialog(this, "No matches found!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            backSearchBut.setEnabled(true);
            forwardSearchBut.setEnabled(true);
            setSearchInfoLabel();
        }else{
            JOptionPane.showMessageDialog(this, "Empty", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_execSearchActionPerformed

    private void forwardSearchButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_forwardSearchButActionPerformed
        textPane.requestFocus();
        if (selectedStartIndex < matches.size() && selectedStartIndex >= 0){
            textPane.select(matches.get(selectedStartIndex), matches.get(selectedStartIndex++) + searchText.length());
            setSearchInfoLabel();
        }
    }//GEN-LAST:event_forwardSearchButActionPerformed

    private void backSearchButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backSearchButActionPerformed
        textPane.requestFocus();
        if (selectedStartIndex != 1)
            selectedStartIndex--;
        if (selectedStartIndex >= 1){
            textPane.select(matches.get(selectedStartIndex), matches.get(selectedStartIndex) + searchText.length());
            setSearchInfoLabel();
        }
    }//GEN-LAST:event_backSearchButActionPerformed

    private void setSearchInfoLabel(){
        countLabel.setText(str + selectedStartIndex + "/" +  matches.size());
    }
    
    private void newFile(){
        saveFile();
        textPane.setText("");
    }
    
    private void openFile(String path) throws FileNotFoundException, IOException{
        try (BufferedReader input = new BufferedReader(new FileReader(path))) {
            String sep = System.getProperty("line.separator");
            while (input.ready())
                textPane.append(input.readLine() + sep);
        }
        filePath = path;
    }
    
    private void saveFile(){
        if (filePath == null)
            saveFileAs();
        try(BufferedWriter output = new BufferedWriter(new FileWriter(filePath))) {
            output.write(textPane.getText());
        }catch(Exception exc){
            JOptionPane.showMessageDialog(this, exc.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);        
        }
    }
    
    private void saveFileAs(){
        if (fileChooser.showSaveDialog(this)!=
                JFileChooser.APPROVE_OPTION) return;
        filePath = fileChooser.getSelectedFile().getPath();
    }
    
    public boolean isTextFound(){
        matches = applyAlgo(searchText, textPane.getText());
        if (matches.isEmpty())
            return false;
        textPane.requestFocus();
        if (selectedStartIndex <= matches.size())
            textPane.select(matches.get(selectedStartIndex), matches.get(selectedStartIndex++) + searchText.length());
        return true;
    }
    
    private ArrayList<Integer> applyAlgo(String pattern, String text){
        ArrayList<Integer> prefixList = calcPrefixes(pattern);
        ArrayList<Integer> resultIndexList = new ArrayList<>(text.length());
        int size = 0;
        int index = 0;
        
        for(int i=0; i<text.length(); i++){
            while(pattern.charAt(index) != text.charAt(i) && index>0){
                index = prefixList.get(index-1);
            }
            if (pattern.charAt(index) == text.charAt(i)){
                index++;
                if (index == pattern.length()){
                    resultIndexList.add(size, i+1-index);
                    size++;
                    index = prefixList.get(index-1);
                }
            }else{
                index = 0;
            }
        }
        return resultIndexList;
    }
    
    private ArrayList<Integer> calcPrefixes(String text){
        ArrayList<Integer> prefixes = new ArrayList<>(text.length());
        prefixes.add(0, 0);
        
        for(int i=1; i<text.length(); i++){
            int index = prefixes.get(i - 1);
            while(text.charAt(index) != text.charAt(i) && index > 0){
                index = prefixes.get(index-1);
            }
            if (text.charAt(index) == text.charAt(i)){
                prefixes.add(0, index+1);
            }else{
                prefixes.add(i, 0);
            }
        }
        return prefixes;
    }
    
    public void setSearchText(String text){
        searchText = text;
    }
    
    public static void main(String args[]) {

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
            java.util.logging.Logger.getLogger(TextEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TextEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TextEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TextEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TextEditor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backSearchBut;
    private javax.swing.JLabel countLabel;
    private javax.swing.JButton execSearch;
    private javax.swing.JMenuItem exitMenu;
    private javax.swing.JFileChooser fileChooser;
    private javax.swing.JButton forwardSearchBut;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem newFileMenu;
    private javax.swing.JMenuItem openFileMenu;
    private javax.swing.JMenuItem saveFileMenu;
    private javax.swing.JTextField searchInput;
    private javax.swing.JTextArea textPane;
    // End of variables declaration//GEN-END:variables
}
