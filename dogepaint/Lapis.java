package dogepaint;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;

public class Lapis implements DogeTools 
{
    @Override
    public void dragAction(MouseEvent objEvt, Graphics2D g2D, Color objCor) {
        int x = objEvt.getX();
        int y = objEvt.getY();
        
        g2D.setColor(objCor);
        g2D.fill(new Ellipse2D.Double(x - 4, y - 4, 8, 8));
    }

    @Override
    public void clickAction(MouseEvent objEvt, Graphics2D g2D, Color objCor) 
    {
    }
    
    @Override
    public void mouseReleaseAction(MouseEvent objEvt, Graphics2D g2D, Color objCor) {
    }
}
