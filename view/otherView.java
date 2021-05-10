package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import controller.Application;
import model.Button;
import model.otherModel;

public class otherView {
	
	public static boolean click_o = false;
	
    
	public Button [] otherButtons = {new Button(0, 50, 255, 25,""), new Button(140, 130, 200, 50,"Box"),
			new Button(140, 190, 200, 50,"Gauss"), new Button(140, 250, 200, 50,"Sharpen"),
			new Button(140, 310, 200, 50,"Max"),
			new Button(140, 370, 200, 50,"Mediana"),
			new Button(140, 430, 200, 50,"Min"),
			new Button(260, 500, 200, 20, "")};
	
	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		
        g2d.setColor(new Color(154, 154, 210));
        g2d.fillRect(0, 0, Application.WIDTH, Application.HEIGHT);
        
        Font f = new Font("Didot",Font.ITALIC, 20);
		g2d.setFont(f);
		g2d.setColor(new Color(221,238,229));
		g2d.drawString("Choose image", 120, 45);
		g2d.drawString("MENU", 180, 518);
		g2d.drawString("Choose mode", 215, 120);
        
		g2d.drawImage(imagesLoad.img2, 5, 230, null);
		
        for (Button i :otherButtons) {
        	i.setSizeF(35);
			i.draw(g2d);
		}
        
        g2d.drawImage(imagesLoad.img3, 40, 10, null);
        
        g2d.setColor(new Color(221,238,229));
		g2d.fillRect(0, 510, 400, 1);
		
        g2d.drawImage(imagesLoad.home, 300, 485, null);
        
    }
}
