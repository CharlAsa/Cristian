package formulario;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import javax.swing.ImageIcon;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Charles
 */
public class formXX extends javax.swing.JFrame {
    
    protected void mudarCor(int i){
        //JOptionPane.showMessageDialog(null, this.getContentPane().getForeground().toString());
        //51,51,51
        
        //255, 221, 204
        
        if(i == 0){//preto
            float[] c = Color.RGBtoHSB(0, 0, 0, null);
            this.getContentPane().setBackground(Color.getHSBColor(c[0], c[1], c[2]));
            
            lblIP.setForeground(Color.WHITE);
            lblPorta.setForeground(Color.WHITE);
            
            
        }
        else if(i == 1){ //Original
            float[] c = Color.RGBtoHSB(240, 240, 240, null);
            this.getContentPane().setBackground(Color.getHSBColor(c[0], c[1], c[2]));
            
            lblIP.setForeground(Color.BLACK);
            lblPorta.setForeground(Color.BLACK);

        }
        else if(i == 2){//laranja
            float[] c = Color.RGBtoHSB(255, 221, 204, null);
            this.getContentPane().setBackground(Color.getHSBColor(c[0], c[1], c[2]));
            
            lblIP.setForeground(Color.BLACK);
            lblPorta.setForeground(Color.BLACK);
            
        }
        else if(i == 3){ ///amarelo
            float[] c = Color.RGBtoHSB(255, 255, 179, null);
            this.getContentPane().setBackground(Color.getHSBColor(c[0], c[1], c[2]));
            
            lblIP.setForeground(Color.BLACK);
            lblPorta.setForeground(Color.BLACK);
            
        }
        else if(i == 4){ //Azul
            float[] c = Color.RGBtoHSB(128, 223, 255, null);
            this.getContentPane().setBackground(Color.getHSBColor(c[0], c[1], c[2]));
            
            lblIP.setForeground(Color.BLACK);
            lblPorta.setForeground(Color.BLACK);
            
        }
    }
    
    /**
     * Creates new form formXX
     */
    
    private void mensagem(String m){
        boolean flag = false;
        boolean n1 = false, n2 = false, n3 = false, n4 = false, n5 = false;
        int x = 0, y = 70, xx = 250;

        for (char letra : m.toCharArray()){
        
            if(letra == '<' && flag == false){
                flag = true;
                n1 = true;
                continue;
            }
            else if(letra == '>' && flag == true){
                if(n4){
                   if(x > xx){
                        xx = x;
                   }
                   x = 0;
                   y+=16; 
                }
                flag = false;
                n1 = false;
                n2 = false;
                n3 = false;
                n4 = false;
                n5 = false;
                continue;
            }
            
            if(n1){
                if(n2){
                    if(n3){
                        if(letra == '/'){
                            n4 = true;
                        }
                        else{
                            n1 = false;
                            n2 = false;
                            n3 = false;
                        }
                        continue;
                    }
                    if(letra == 'r'){
                        n3 = true;
                    }
                    else{
                        n1 = false;
                        n2 = false;
                    }
                    continue;
                }
                if(letra == 'b'){
                    n2 = true;
                }
                else{
                    n1 = false;
                }
                continue;
            }
            
            if(!flag){
                x+=8;
            }
        }
        
        if(x < xx){
            x = xx;
        }
        
        //formMensagem fff = new formMensagem(m, n);
        //fff.setSize(x, y);
        //fff.setVisible(true);
        
        if(fff != null){
            fff.dispose();
        }
        fff = new formMensagem(m, n);
        fff.setSize(x, y);
        fff.setVisible(true);
    }
    
    public formXX() {
        initComponents();
        
        //formMensagem fff = new formMensagem("<html> A CASA É BELA A CASA É BELA aaaaaaaaaaaaaaaaaaaaaaaaaaaa aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa aaaaaaaaaaaaaaaaaaaaaaa</html>");
        //fff.setSize(100, 100);
        //fff.setVisible(true);
        mudarCor(n);
        try{
            ImageIcon img = new ImageIcon("relogio.png");
            setIconImage(img.getImage());
        }
        catch(NullPointerException e){
        }
        //mudarCor(4);
        try{
            BufferedReader br = new BufferedReader(new FileReader("info.txt"));
            try {
                StringBuilder sb = new StringBuilder();
                String line = br.readLine();
                int cont = 1;
                while (line != null) {
                    if (cont == 1){
                        if(line.length() <= 15){
                            txtIP.setText(line);
                        }
                    }
                    else if(cont == 2){
                        if(line.length() <= 5){
                            txtPorta.setText(line);
                        }
                    }
                    else{
                        break;
                    }
                    cont++;
                    sb.append(line);
                    //sb.append(System.lineSeparator());
                    line = br.readLine();
                    //JOptionPane.showMessageDialog(null, line);
                }
                //ip = sb.toString();
                br.close();
            } 
            catch(IOException e){

            }
        }
        catch (FileNotFoundException e){

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

        lblIP = new javax.swing.JLabel();
        txtIP = new javax.swing.JTextField();
        lblPorta = new javax.swing.JLabel();
        txtPorta = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SAG");
        setLocationByPlatform(true);
        setResizable(false);

        lblIP.setText("IP:");

        txtIP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIPKeyTyped(evt);
            }
        });

        lblPorta.setText("Porta:");

        txtPorta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPortaKeyTyped(evt);
            }
        });

        jButton1.setText("Conectar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jMenu1.setText("Configurações");

        jMenuItem1.setText("Opções");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);
        jMenuItem1.getAccessibleContext().setAccessibleName("");

        jMenuBar1.add(jMenu1);
        jMenu1.getAccessibleContext().setAccessibleName("");

        jMenu2.setText("Ajuda");

        jMenuItem2.setText("Créditos");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);
        jMenuItem2.getAccessibleContext().setAccessibleName("");

        jMenuBar1.add(jMenu2);
        jMenu2.getAccessibleContext().setAccessibleName("");

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lblIP)
                                .addGap(26, 26, 26))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblPorta)
                                .addGap(16, 16, 16)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtPorta)
                            .addComponent(txtIP, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(122, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(89, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIP)
                    .addComponent(txtIP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPorta)
                    .addComponent(txtPorta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(jButton1)
                .addGap(84, 84, 84))
        );

        lblIP.getAccessibleContext().setAccessibleName("");
        lblPorta.getAccessibleContext().setAccessibleName("");
        jButton1.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String ip = txtIP.getText();
        //String porta = txtPorta.getText();
        
        int porta;
        try{
            porta = Integer.parseInt(txtPorta.getText());
        }
        catch(NumberFormatException e){
            //JOptionPane.showMessageDialog(null, "A porta não é número");
            mensagem("A porta não é número");
            return;
        }
        
        if(porta > 65535){
            //JOptionPane.showMessageDialog(null, "Número de porta muito alto, limite é 65535");
            mensagem("Número de porta muito alto, limite é 65535");
            return;
        }
        
        try{
            Socket servidor = new Socket(ip, porta);
            
            PrintStream enviar = new PrintStream(servidor.getOutputStream());
        
            Scanner receber = new Scanner(servidor.getInputStream());
            //Scanner entrada = new Scanner(System.in);
            List<Long> time = new ArrayList();

            //T1
            time.add(System.currentTimeMillis());
            //enviar.println(System.currentTimeMillis());
            
            enviar.println("Olá meu nome é: " + java.net.InetAddress.getLocalHost().getHostName());
            //T2
            time.add(receber.nextLong());
            //T3
            time.add(receber.nextLong());
            //T4
            time.add(System.currentTimeMillis());

            //System.out.println(receber.hasNext() ? "Tem próximo" : "Não tem próximo");
        
            receber.close();
            enviar.close();
            servidor.close();
            
            //System.out.println("T1 = " + time.get(0));
            //System.out.println("T2 = " + time.get(1));
            //System.out.println("T3 = " + time.get(2));
            //System.out.println("T4 = " + time.get(3));
            
            //(T4 - T1) - (T3 - T2)
            try{
                BufferedReader br = new BufferedReader(new FileReader("info.txt"));
                try {
                    StringBuilder sb = new StringBuilder();
                    String line = br.readLine();
                    int cont = 1;
                    while (line != null) {
                        if (cont == 3){
                            try{
                                int t1 = Integer.parseInt(line);
                                time.set(0, time.get(0) + t1);
                            }
                            catch(NumberFormatException e){
                                
                            }
                        }
                        else if(cont == 4){
                            try{
                                int t2 = Integer.parseInt(line);
                                time.set(1, time.get(1) + t2);
                            }
                            catch(NumberFormatException e){

                            }
                        }
                        else if(cont == 5){
                            try{
                                int t3 = Integer.parseInt(line);
                                time.set(2, time.get(2) + t3);
                            }
                            catch(NumberFormatException e){

                            }
                        }
                        else if(cont == 6){
                            try{
                                int t4 = Integer.parseInt(line);
                                time.set(3, time.get(3) + t4);
                            }
                            catch(NumberFormatException e){

                            }
                        }
                        else if(cont == 7){
                            break;
                        }
                        cont++;
                        sb.append(line);
                        //sb.append(System.lineSeparator());
                        line = br.readLine();
                        //JOptionPane.showMessageDialog(null, line);
                    }
                    //ip = sb.toString();
                    br.close();
                } 
                catch(IOException e){
                }
            }
            catch (FileNotFoundException e){

            }
            
            
            time.add((time.get(3) - time.get(0)) - (time.get(2) - time.get(1)));

            //System.out.println("RTT = " + time.get(time.size() - 1));

            //T3 + RTT / 2
            time.add(time.get(2) + time.get(time.size() - 1) / 2);
            //time.set(time.size() - 1, time.get(2) + time.get(time.size() - 1) / 2);

            Date d = new Date(time.get(5));
            Calendar c = Calendar.getInstance();
            c.setTime(d);
            
            mensagem("<html>T1=" + time.get(0) + "<br/>T2=" + time.get(1) + "<br/>T3=" + time.get(2) + "<br/>T4=" + time.get(3) + "<br/>RTT=" + time.get(4) + "<br/>Cristian=" + time.get(5) + "---" + c.get(Calendar.HOUR_OF_DAY) + ":" + c.get(Calendar.MINUTE) + ":" + c.get(Calendar.SECOND) + "</html>");
            
            //System.out.println("Cristian = " + time.get(time.size() - 1));
            //JOptionPane.showMessageDialog(null, "T1 = " + time.get(0) + "\nT2 = " + time.get(1) + "\nT3 = " + time.get(2) + "\nT4 = " + time.get(3) + "\nRTT = " + time.get(4) + "\nCristian = " + time.get(5));

            //System.out.println(receber.hasNext() ? "Tem próximo" : "Não tem próximo");
            //entrada.close();

            if(save){
                try{
                    File f = new File("log.txt");
                    FileWriter fw = new FileWriter(f, true);
                    PrintWriter txt = new PrintWriter(fw);
                    
                    txt.println(" --- SIMULADOR DO ALGORITMO DE CRISTIAN --- ");
                    txt.println("T1 = " + time.get(0) + " - ");
                    txt.println("T2 = " + time.get(1));
                    txt.println("T3 = " + time.get(2));
                    txt.println("T4 = " + time.get(3));
                    txt.println("RTT = " + time.get(4));
                    txt.println("Cristian = " + time.get(5) + " " + c.get(Calendar.HOUR_OF_DAY) + ":" + c.get(Calendar.MINUTE) + ":" + c.get(Calendar.SECOND));
                    txt.println("RTT = (T4 - T1) - (T3 - T2)");
                    txt.println("Cristian = T3 + (RTT / 2);");
                    txt.println("Cliente = "+servidor.getLocalSocketAddress());
                    txt.println("Servidor = " + servidor.getRemoteSocketAddress());
                    txt.println("");
                    
                    txt.close();
                    fw.close();
                    
                }
                catch(IOException e){
                    mensagem(e.getMessage());
                }
                catch(Exception e){
                    mensagem(e.getMessage());
                    
                }
            }
        }
        catch(UnknownHostException e){
            mensagem(e.getMessage());
            //JOptionPane.showMessageDialog(null, e.getMessage());
        }
        catch(IOException e){
            mensagem(e.getMessage());
            //JOptionPane.showMessageDialog(null, e.getMessage());  
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtIPKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIPKeyTyped
        // TODO add your handling code here:
        //JOptionPane.showMessageDialog(null, evt.getKeyCode());
        if(evt.getKeyCode() != 8){
            if(txtIP.getText().length()>=15) {  
                evt.consume();
            }
        }
    }//GEN-LAST:event_txtIPKeyTyped

    private void txtPortaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPortaKeyTyped
        // TODO add your handling code here:
        if(evt.getKeyCode() != 8){
            if(txtPorta.getText().length()>=5) {  
                evt.consume();
            }
        }
    }//GEN-LAST:event_txtPortaKeyTyped

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        if(fO != null){
            fO.dispose();
        }
        fO = new formOpções(n, save);
        fO.setVisible(true);
        
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        if(fO != null){
            fO.dispose();
        }
        fO = new formCreditos(n);
        fO.setVisible(true);
        
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    /**
     * @param args the command line arguments
     */
    protected static javax.swing.JFrame fO;
    
    protected static formXX f;
    
    private static formMensagem fff;
    
    private static int n = 1;
    
    private static boolean save = false;
    
    protected void setN(int n){
        this.n = n;
    }
    
    protected void setSave(boolean valor){
        save = valor;
    }
    
    public static void main(String args[]) {
        //f = new formXX();
        
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
            java.util.logging.Logger.getLogger(formOpções.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formOpções.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formOpções.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formOpções.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new formXX().setVisible(true);
                f = new formXX();
                f.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JLabel lblIP;
    private javax.swing.JLabel lblPorta;
    private javax.swing.JTextField txtIP;
    private javax.swing.JTextField txtPorta;
    // End of variables declaration//GEN-END:variables
}
