/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dogepaint;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

/**
 *
 * @author breno
 */
public class Borracha implements DogeTools
{
    @Override
    public void dragAction(MouseEvent objEvt, Graphics2D g2D, Color objCor) {
        int x = objEvt.getX();
        int y = objEvt.getY();
        
        g2D.setColor(Color.WHITE);
        g2D.fill(new Ellipse2D.Double(x - 4, y - 4, 12, 12));
    }

    @Override
    public void clickAction(MouseEvent objEvt, Graphics2D g2D, Color objCor) 
    {
    }
    
    @Override
    public void mouseReleaseAction(MouseEvent objEvt, Graphics2D g2D, Color objCor) {
    }
}
