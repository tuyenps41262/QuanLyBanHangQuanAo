
package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class ManHinhChaoJDialog extends javax.swing.JDialog {

    public ManHinhChaoJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setTitle("Hệ Thống Quản Lý Cửa Hàng Quần Áo");
        setLocationRelativeTo(null);
        init();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        pgb_loading = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 204));
        setForeground(new java.awt.Color(255, 255, 0));

        jLabel1.setIcon(new javax.swing.ImageIcon("D:\\DuAn1_ps39536\\src\\main\\resources\\anhCSDL\\mh.jpg")); // NOI18N

        pgb_loading.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        pgb_loading.setStringPainted(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pgb_loading, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 570, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pgb_loading, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //để có thể chạy thì phải khởi tạo đối tượng của lớp DaoDialog với 
                // tham số truyền vào đầu tiên là đối tượng cha của hộp thoai là javax.swing.frame, model true thì mới mở 
               ManHinhChaoJDialog dialog = new ManHinhChaoJDialog(new javax.swing.JFrame(), true);
               // thêm sự kiện listener để theo dõi sự kiện đóng hộp thoại
               // khi hộp thoại đóng toàn bộ chương trình sẽ thoát ra
               // hiển thị form dialog lên màn hình
               dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    
    private void init(){
        new javax.swing.Timer(20, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int value = pgb_loading.getValue();
                if (value < pgb_loading.getMaximum()) {
                    pgb_loading.setValue(value + 1); // để có dòng chạy dài ra trên jprogressBar
                } else {
                     ManHinhChaoJDialog.this.dispose();
                    new LoginJDialog(null, true).setVisible(true);
                       
                }   
            }
        }).start();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JProgressBar pgb_loading;
    // End of variables declaration//GEN-END:variables
}
