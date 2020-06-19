
package battleships;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;

public final class ImageHolder {    
    
      
    public static ImageIcon largeShipFull;      
    public static ImageIcon mediumShipFull;
    public static ImageIcon smallShipFull;
    public static ImageIcon tinyShipFull;
    
    public static ImageIcon largeShipFullV;      
    public static ImageIcon mediumShipFullV;
    public static ImageIcon smallShipFullV;
    public static ImageIcon tinyShipFullV;
    
    public static ImageIcon[] largeShipHorizontal;  
    public static ImageIcon[] mediumShipHorizontal; 
    public static ImageIcon[] smallShipHorizontal;  
    public static ImageIcon[] tinyShipHorizontal;       
    
    public static ImageIcon[] largeShipVertical;    
    public static ImageIcon[] mediumShipVertical;   
    public static ImageIcon[] smallShipVertical;
    public static ImageIcon[] tinyShipVertical;
    
    public final static int TILE_SIZE = 35;  
    
    public ImageHolder() {
                
        largeShipFull = loadImageIcon("LargeShip.png");     
        mediumShipFull = loadImageIcon("MediumShip.png");
        smallShipFull = loadImageIcon("SmallShip.png");
        tinyShipFull = loadImageIcon("TinyShip.png");
        
        largeShipFullV = new ImageIcon(rotateImage(convertToBufferedImage(largeShipFull)));     
        mediumShipFullV = new ImageIcon(rotateImage(convertToBufferedImage(mediumShipFull)));
        smallShipFullV = new ImageIcon(rotateImage(convertToBufferedImage(smallShipFull)));
        tinyShipFullV = new ImageIcon(rotateImage(convertToBufferedImage(tinyShipFull)));
        
        largeShipHorizontal = new ImageIcon[5];     
        mediumShipHorizontal = new ImageIcon[4];    
        smallShipHorizontal = new ImageIcon[3];
        tinyShipHorizontal = new ImageIcon[2];
        
        largeShipVertical = new ImageIcon[5];
        mediumShipVertical = new ImageIcon[4];
        smallShipVertical = new ImageIcon[3];
        tinyShipVertical = new ImageIcon[2];
        
        buildTiles();       
        
    }
    
    
    
    private static ImageIcon loadImageIcon(String path) {   
            return new ImageIcon(Toolkit.getDefaultToolkit().getImage(ImageHolder.class.getResource("/resources/"+path)));
    }
    
  
    public static BufferedImage rotateImage(BufferedImage input) {
        int w = input.getWidth();
        int h = input.getHeight();
        BufferedImage output = new BufferedImage(h, w, input.getType());
        for (int y = 0; y < h; y++) 
            for (int x = 0; x < w; x++) 
                output.setRGB(y,x,input.getRGB(x,y));
        return output;
    }
    
   
    public static BufferedImage resize(BufferedImage img, int newW, int newH) { 
        Image tmp = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
        BufferedImage dimg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = dimg.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();

        return dimg;
    }  
    
   
    private static BufferedImage convertToBufferedImage(ImageIcon input) {
        BufferedImage output = new BufferedImage(
                input.getIconWidth(),
                input.getIconHeight(),
                BufferedImage.TYPE_INT_ARGB);
        Graphics g = output.createGraphics();
        input.paintIcon(null, g, 0,0);
        g.dispose();
        return output;
    }
    
    
   
    private static void buildTiles() {
        
        // Horizontal
        BufferedImage largeShip = convertToBufferedImage(largeShipFull); // Change iconimage to bufferedImage
        largeShip = resize(largeShip, TILE_SIZE*5, TILE_SIZE*1);    // Resize image to fit with the tile size
        int size = largeShip.getWidth()/5;
        for (int i=0; i<5; i++)        // Fill array as sub images of the full ship image
            largeShipHorizontal[i] = new ImageIcon(largeShip.getSubimage(size*i, 0, size, largeShip.getHeight()));
        
        BufferedImage mediumShip = convertToBufferedImage(mediumShipFull);  // Process repeated for each ship size
        mediumShip = resize(mediumShip, TILE_SIZE*4, TILE_SIZE*1);
        size = mediumShip.getWidth()/4;
        for (int i=0; i<4; i++) 
            mediumShipHorizontal[i] = new ImageIcon(mediumShip.getSubimage(size*i, 0, size, mediumShip.getHeight()));
        
        BufferedImage smallShip = convertToBufferedImage(smallShipFull);
        smallShip = resize(smallShip, TILE_SIZE*3, TILE_SIZE*1);
        size = smallShip.getWidth()/3;
        for (int i=0; i<3; i++) 
            smallShipHorizontal[i] = new ImageIcon(smallShip.getSubimage(size*i, 0, size, smallShip.getHeight()));
        
        BufferedImage tinyShip = convertToBufferedImage(tinyShipFull);
        tinyShip = resize(tinyShip, TILE_SIZE*2, TILE_SIZE*1);
        size = tinyShip.getWidth()/2;
        for (int i=0; i<2; i++) 
            tinyShipHorizontal[i] = new ImageIcon(tinyShip.getSubimage(size*i, 0, size, tinyShip.getHeight()));
       
        // Vertical
        largeShip = rotateImage(largeShip);     // Same process, but now we rotate the image before cutting
        size = largeShip.getHeight()/5;
        for (int i=0; i<5; i++) 
            largeShipVertical[i] = new ImageIcon(largeShip.getSubimage(0, size*i, largeShip.getWidth(), size));
        
        mediumShip = rotateImage(mediumShip);
        size = mediumShip.getHeight()/4;
        for (int i=0; i<4; i++) 
            mediumShipVertical[i] = new ImageIcon(mediumShip.getSubimage(0, size*i, mediumShip.getWidth(), size));
        
        smallShip = rotateImage(smallShip);
        size = smallShip.getHeight()/3;
        for (int i=0; i<3; i++) 
            smallShipVertical[i] = new ImageIcon(smallShip.getSubimage(0, size*i, smallShip.getWidth(), size));
        
        tinyShip = rotateImage(tinyShip);
        size = tinyShip.getHeight()/2;
        for (int i=0; i<2; i++) 
            tinyShipVertical[i] = new ImageIcon(tinyShip.getSubimage(0, size*i, tinyShip.getWidth(), size));
        
    }
    
    
    
    public static ImageIcon getImageByID(int ID) {
        
        int orientation = ID/100;
        int shipSize = (ID%100)/10;
        int shipPart = (ID%100)%10;
        
        ImageIcon[] selected;
        
        if (orientation == 0) {
            switch (shipSize) {
                case 5:
                    selected = largeShipHorizontal;
                break;    
                case 4:
                    selected = mediumShipHorizontal;
                break;   
                case 3:
                    selected = smallShipHorizontal;
                break;   
                case 2:
                    selected = tinyShipHorizontal;
                break;   
                default:
                    selected = null;
                break;       
            }
        }
        else  {
            switch (shipSize) {
                case 5:
                    selected = largeShipVertical;
                break;    
                case 4:
                    selected = mediumShipVertical;
                break;   
                case 3:
                    selected = smallShipVertical;
                break;   
                case 2:
                    selected = tinyShipVertical;
                break;   
                default:
                    selected = null;
                break;       
            }
        }
        return selected[shipPart];
    }
}
