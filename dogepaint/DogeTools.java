/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dogepaint;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;

/**
 *
 * @author breno
 */
public interface DogeTools 
{   
     public void dragAction(MouseEvent objEvt, Graphics2D g2D, Color objCor);
     public void clickAction(MouseEvent objEvt, Graphics2D g2D, Color objCor);
     public void mouseReleaseAction(MouseEvent objEvt, Graphics2D g2D, Color objCor);
}
