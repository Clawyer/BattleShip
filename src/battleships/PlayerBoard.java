
package battleships;
import static battleships.GameBoard.HORIZONTAL;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import javax.swing.*;


public class PlayerBoard extends GameBoard {
    
    public PlayerBoard() {
        
        super();        
        addActionListener(new PlayerActionListener());  
        customCursor();     
    }
  
      
  
    private class PlayerActionListener implements ActionListener {
        
        public void actionPerformed(ActionEvent ae) {        
            JButton source = (JButton) ae.getSource();
            Point position = getButtonPosition(source);
            
            if (isPlacingShips()){              
                placeNextShip(position, true);    
        }  
        else {
        	userShoot(position);
            
        }
    } 
}
  private void userShoot(Point pos) {
        
        gridButtons[pos.y][pos.x].setEnabled(false);
        
        if (grid[pos.y][pos.x] != 0) {
            gridButtons[pos.y][pos.x].setBackground(GameBoard.SHOOT_COLOR);
            lives--;
            if(isShipFullyDestroyed(pos))
                showShip(pos);
            if (lives==0) {
                JOptionPane.showMessageDialog(null, "Vous avez gagné");
                //System.exit(0);
            }
                
        }else {
        	gridButtons[pos.y][pos.x].setBackground(GameBoard.MISS_SHOOT_COLOR);
        	
        }
        
    } 
  
  private void showShip(Point pos) {
      
      int shipId = grid[pos.y][pos.x];
      int orientation = shipId/100;
      int shipSize = (shipId%100)/10;
      int shipPart = (shipId%100)%10;
      
      Point p;
      if (orientation == 0) {
          p = new Point(pos.x-shipPart, pos.y);
          for (int i=0; i<shipSize; i++) {
              gridButtons[p.y][p.x+i].setIcon(ImageHolder.getImageByID(grid[p.y][p.x+i]));
          }
      }
      else if (orientation == 1) {
          p = new Point(pos.x, pos.y-shipPart);
          for (int i=0; i<shipSize; i++) {
              gridButtons[p.y+i][p.x].setIcon(ImageHolder.getImageByID(grid[p.y+i][p.x]));
          }
      }
  }
}
