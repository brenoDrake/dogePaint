package dogepaint;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class Preencher implements DogeTools
{
    private Coordenadas[] pixels;
    private BufferedImage img;

    public void setImage(BufferedImage img)
    {
        this.img = img;
    //    JOptionPane.showMessageDialog(null, new JLabel(new ImageIcon(img)));
    }
    
    @Override
    public void dragAction(MouseEvent objEvt, Graphics2D g2D, Color objCor) {
    }

    @Override
    public void clickAction(MouseEvent objEvt, Graphics2D g2D, Color objCor) 
    {
        int index = 0;
	int intX = objEvt.getX();
        int intY = objEvt.getY();
        int corAntiga = img.getRGB(intX, intY);
        int intAltura = img.getWidth();
        int intLargura = img.getHeight();

        pixels = new Coordenadas[intAltura * intLargura];
        pixels[index] = new Coordenadas(intX, intY);
        img.setRGB(intX, intY, objCor.getRGB());
        img.flush();
        
        try 
        {
            while (index != -1) 
            {
                Coordenadas cur = pixels[index];
                --index;
                
                // Pixel abaixo
                if (cur.y + 1 < intLargura && img.getRGB(cur.x, cur.y + 1) == corAntiga) 
                {
                    img.setRGB(cur.x, cur.y + 1, objCor.getRGB());
                    ++index;
                    pixels[index] = new Coordenadas(cur.x, cur.y + 1);
                }
		
                // Pixel acima
                if (cur.y - 1 >= 0 && img.getRGB(cur.x, cur.y - 1) == corAntiga) 
                {
                    img.setRGB(cur.x, cur.y - 1, objCor.getRGB());
                    ++index;
                    pixels[index] = new Coordenadas(cur.x, cur.y - 1);
                }
			
                // Pixel a direita
                if (cur.x + 1 < intAltura && img.getRGB(cur.x + 1, cur.y) == corAntiga) 
                {
                    img.setRGB(cur.x + 1, cur.y, objCor.getRGB());
                    ++index;
                    pixels[index] = new Coordenadas(cur.x + 1, cur.y);
                }
		
                // Pixel a esquerda
                if (cur.x - 1 >= 0 && img.getRGB(cur.x - 1, cur.y) == corAntiga) 
                {
                    img.setRGB(cur.x - 1, cur.y, objCor.getRGB());
                    ++index;
                    pixels[index] = new Coordenadas(cur.x - 1, cur.y);
                }
            }
            
            img.flush();
        }
        catch (Exception e) {}
    }
    
    @Override
    public void mouseReleaseAction(MouseEvent objEvt, Graphics2D g2D, Color objCor) {
    } 
    
    /*
        Subclasse que representa as cooredenadas da imagem
    */
    class Coordenadas 
    {
	public int x;
        public int y;

	public Coordenadas(int x1, int y1) 
        {
            x = x1;
            y = y1;
	}
    }
}
