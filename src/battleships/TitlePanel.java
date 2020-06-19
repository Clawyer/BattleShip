
package battleships;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

class TitlePanel extends JPanel {
    
  
    private JLabel titleLabel;
    private JLabel subtitleLabel;
    
    public TitlePanel() {
        
        super();    
        this.setLayout(new BorderLayout()); 
        this.setBorder(BorderFactory.createEtchedBorder());  
        
        titleLabel = new JLabel("Bataille Navale");     
        titleLabel.setFont(new Font("Calibri", 20,20));     
        titleLabel.setHorizontalAlignment(JLabel.CENTER);   
        
        subtitleLabel = new JLabel("Placer vos navires sur le champ de bataille, clic gauche pour placer votre navire, et clic droit pour changer l'orientation."); 
        subtitleLabel.setHorizontalAlignment(JLabel.CENTER); 
        
        this.add(titleLabel, BorderLayout.NORTH);   
        this.add(subtitleLabel, BorderLayout.CENTER);   
        
    }
}
