
package dogepaint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

public class Quadrado implements DogeTools
{
    // Indica se o método dragAction já foi ativado
    private boolean blnArrastado = false;

    // Coordenadas para desenhar a linha
    private int intX;
    private int intY;
    private int intXInicial;
    private int intYInicial;
   
    @Override
    public void dragAction(MouseEvent objEvt, Graphics2D g2D, Color objCor) {
        this.blnArrastado = true;
        this.intX = objEvt.getX();
        this.intY = objEvt.getY();
    }

    @Override
    public void clickAction(MouseEvent objEvt, Graphics2D g2D, Color objCor) {
        this.intXInicial = objEvt.getX();
        this.intYInicial = objEvt.getY();
    }

    @Override
    public void mouseReleaseAction(MouseEvent objEvt, Graphics2D g2D, Color objCor) {
        if(this.blnArrastado)
        {
            int temp;
            this.blnArrastado = false;
            
            if(intXInicial > intX)
            {
                temp = intX;
                intX = intXInicial;
                intXInicial = temp;
            }
            
            if(intYInicial > intY)
            {
                temp = intY;
                intY = intYInicial;
                intYInicial = temp;
            }
            
            g2D.setColor(objCor);
            g2D.setStroke(new BasicStroke(2.f));
            g2D.drawRect(intXInicial, intYInicial, intX - intXInicial, intY - intYInicial);
        }
    }
}
