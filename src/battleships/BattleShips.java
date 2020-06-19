
package battleships;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class BattleShips extends JFrame {
    
    // BattleShipsApp Fields
    private ImageHolder imageHolder;    // Contient les images.
    private TitlePanel titlePanel;   // Titre
    private PlayerBoard playerBoard;   // La grille de jeu.
  
    
    
    // Constructeur
    public BattleShips() {    
        
        super("Bataille Navale");     
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        this.setLocationRelativeTo(null);  
        this.setResizable(false);       
        this.setLayout(new GridBagLayout());  
        this.addMouseListener(new MainMouseListener());  
        imageHolder = new ImageHolder();        
        
        titlePanel = new TitlePanel();
        playerBoard = new PlayerBoard();

        this.add(titlePanel, setConstraints(0, 0, 6, 1, GridBagConstraints.HORIZONTAL, 2));
        this.add(playerBoard, setConstraints(1, 1, 2, 5, GridBagConstraints.NONE, 30));

        this.pack();
        this.setVisible(true);
    }
    
    // Méthode pour organiser la grille
    private GridBagConstraints setConstraints(int gx, int gy, int gw, int gh, int fill, int i) {
        GridBagConstraints g = new GridBagConstraints();
        g.fill = fill;
        g.gridx = gx;
        g.gridy = gy;
        g.gridwidth = gw;
        g.gridheight = gh;
        g.weightx = 0.5;
        g.insets = new Insets(i,i,i,i);
        return g;
    }
    
  
    private class MainMouseListener implements MouseListener {
        
        public void mouseClicked(MouseEvent me) {}
        public void mousePressed(MouseEvent me) {}
        public void mouseEntered(MouseEvent me) {}
        public void mouseExited(MouseEvent me) {}
        
        // Change le sens du navire à placer en fonction du clic droit ou gauche
        public void mouseReleased(MouseEvent me) {
            if (SwingUtilities.isRightMouseButton(me)) {
                if (playerBoard.isPlacingShips()) {
                    playerBoard.toggleOrientation();
                    playerBoard.customCursor();
                }
            }
        }
        
    }
    
   
    public static void main(String[] args) {
        new BattleShips();  
    }
}
