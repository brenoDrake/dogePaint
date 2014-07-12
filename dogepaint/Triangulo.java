/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dogepaint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

/**
 *
 * @author breno
 */
public class Triangulo implements DogeTools
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
            g2D.setStroke(new BasicStroke(2.f));
            this.blnArrastado = false;
            g2D.setColor(objCor);
            
            g2D.draw(new Line2D.Double(intXInicial, intYInicial, intXInicial, intY));
            g2D.draw(new Line2D.Double(intXInicial, intYInicial, intX, intY));
            g2D.draw(new Line2D.Double(intXInicial, intY, intX, intY));
        }
    }
}
