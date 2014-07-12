package dogepaint;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.font.TextAttribute;
import java.awt.image.BufferedImage;
import java.text.AttributedString;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JPanel;
import javax.swing.event.MouseInputAdapter;

public class DrawingArea extends JPanel
{
    private Color corSelecionada;
    private int intOpcao;
    private ArrayList<String> lstTextos;
    
    protected BufferedImage image;
    protected Graphics2D g2D;
    
    private Lapis tlLapis;
    private Linha tlLinha;
    private Circulo tlCirculo;
    private Quadrado tlQuadrado;
    private Borracha tlBorracha;
    private Preencher tlPreencher;
    private Triangulo tlTriangulo;
    
    public DrawingArea()
    {
        corSelecionada = Color.BLACK;
        setBackground(Color.WHITE);
        intOpcao = 1;
        
        tlLapis = new Lapis();
        tlLinha = new Linha();
        tlQuadrado = new Quadrado();
        tlCirculo = new Circulo();
        tlPreencher = new Preencher();
        tlBorracha = new Borracha();
        tlTriangulo = new Triangulo();
    
        DrawingAreaMouseListener ml = new DrawingAreaMouseListener();
        addMouseMotionListener(ml);
        addMouseListener(ml);
        
        lstTextos = new ArrayList<String>();
        lstTextos.add("much doge");
        lstTextos.add("such square");
        lstTextos.add("doge s2");
        lstTextos.add("lol");
        lstTextos.add("wow");
        lstTextos.add("such paint");
        lstTextos.add("many points");
        lstTextos.add("amazing");
        lstTextos.add("wow wow");
        lstTextos.add("very draw");
        lstTextos.add("such art");
        lstTextos.add("many skils");
        lstTextos.add("so art");
        lstTextos.add("Wow");
        lstTextos.add("so lazy");
        lstTextos.add("Breno Pires");
        lstTextos.add("so amazing");
        lstTextos.add("Lais Carvalho");
        lstTextos.add("much pencil");
        lstTextos.add("so eraser");
        lstTextos.add("many squares");
        lstTextos.add("amazing skils");
        lstTextos.add("many pixels");
        lstTextos.add("doge s2");
        lstTextos.add("very nostalgic");
        lstTextos.add("cool");
        lstTextos.add("MsDoge");
        lstTextos.add("Doge Paint");
        lstTextos.add("Breno Pires"); 
        lstTextos.add("so super");
        lstTextos.add("much programs");
        lstTextos.add("very programing skyls");
        lstTextos.add("hey");
        lstTextos.add("so cute");
        lstTextos.add("so printed");
        lstTextos.add("very realism");
        lstTextos.add("java s2");
        lstTextos.add("doge s2");
    }
    
    public void setCor(Color cor)
    {
        corSelecionada = cor;
    }
    
    public void setOpcao(int opcao)
    {
        intOpcao = opcao;
    }
    
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        if (image == null)
            createEmptyImage();
        
        g.drawImage(image, 0, 0, null);
    }
    
    private void createEmptyImage()
    {
        image = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
        g2D = (Graphics2D)image.getGraphics();
    }
    
    public void clear()
    {
        createEmptyImage();
        repaint();
    }
    
    private void dogefy()
    {
        Random rand = new Random();
        int x = rand.nextInt(image.getWidth());
        int y = rand.nextInt(image.getHeight());

        float r = rand.nextFloat();
        float g = rand.nextFloat();
        float b = rand.nextFloat();
        
        AttributedString as = new AttributedString(getText());
        as.addAttribute(TextAttribute.FOREGROUND, new Color(r, g, b));
        as.addAttribute(TextAttribute.FONT, new Font("Comic Sans MS", Font.PLAIN, 20));
        
        g2D.drawString(as.getIterator(), x, y);
    }
    
    private String getText()
    {
        Random rand = new Random();
        return lstTextos.get(rand.nextInt(lstTextos.size()));
    }

    class DrawingAreaMouseListener extends MouseInputAdapter
    {
        @Override
        public void mousePressed(MouseEvent e)
        {
            boolean blnRepaint = true;
           
            switch(intOpcao)
            {
                case 2:
                    tlLinha.clickAction(e, g2D, corSelecionada);
                    break;
                    
                case 3:
                    tlQuadrado.clickAction(e, g2D, corSelecionada);
                    break;
                    
                case 4:
                    tlCirculo.clickAction(e, g2D, corSelecionada);
                    break;
                    
                case 5:
                    tlTriangulo.clickAction(e, g2D, corSelecionada);
                    break;
                    
                case 7:
                    tlPreencher.setImage(image);
                    tlPreencher.clickAction(e, g2D, corSelecionada);
                    break;
     
                case 8:
                    dogefy();
                    break;
                    
                default:
                    blnRepaint = false;
                    break;
            }
            
            if(blnRepaint)
                repaint();
        }

        @Override
        public void mouseDragged(MouseEvent e)
        {
            boolean blnRepaint = true;
            
            switch(intOpcao)
            {
                case 1:
                   tlLapis.dragAction(e, g2D, corSelecionada);
                    break;
                    
                case 2:
                   tlLinha.dragAction(e, g2D, corSelecionada);
                    break;
                    
                case 3:
                   tlQuadrado.dragAction(e, g2D, corSelecionada);
                    break;
                    
                case 4:
                   tlCirculo.dragAction(e, g2D, corSelecionada);
                    break;
                    
                case 5:
                   tlTriangulo.dragAction(e, g2D, corSelecionada);
                    break;
                    
                case 6:
                   tlBorracha.dragAction(e, g2D, corSelecionada);
                    break;
            
                default:
                    blnRepaint = false;
                    break;
            }
            
            if(blnRepaint)
                repaint();
        }

        @Override
        public void mouseReleased(MouseEvent e)
        {
            boolean blnRepaint = true;
            
            switch(intOpcao)
            {
                case 2:
                    tlLinha.mouseReleaseAction(e, g2D, corSelecionada);
                    break;
                    
                case 3:
                    tlQuadrado.mouseReleaseAction(e, g2D, corSelecionada);
                    break;
                    
                case 4:
                    tlCirculo.mouseReleaseAction(e, g2D, corSelecionada);
                    break;
                    
                case 5:
                    tlTriangulo.mouseReleaseAction(e, g2D, corSelecionada);
                    break;
                    
                default:
                    blnRepaint = false;
            }
            
            if(blnRepaint)
                repaint();
        }
    }    
}
