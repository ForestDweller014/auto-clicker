import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import java.awt.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Clipboard;
import java.awt.Toolkit;
import java.io.*;

public class BGDrawer {
	public static void main(String[] args) throws Exception {
		String response = "/Users/mohammadhamzah/Desktop/fireflower.png";
		int rate = 20;
		int x = 0;
		int y = 0;
		File file = new File(response);
		BufferedImage img = ImageIO.read(file);
		Image resized =  img.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
		BufferedImage image = new BufferedImage(40, 40, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2d = image.createGraphics();
		g2d.drawImage(resized, 0, 0, null);
	    g2d.dispose();
		Robot autoclicker = new Robot();
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		Thread.sleep(2000);
		for (int i = 0; i < 1601; i++) {
			int clr = image.getRGB(x, y); 
			String hex = Integer.toHexString(clr);
			StringSelection selection = new StringSelection(hex);
		    clipboard.setContents(selection, selection);
			//Thread.sleep(rate);
			autoclicker.mouseMove(331, 343 /*330, 380*/);
			Thread.sleep(rate);
			autoclicker.mousePress(InputEvent.BUTTON1_MASK);
			Thread.sleep(rate);
			autoclicker.mouseRelease(InputEvent.BUTTON1_MASK);
			//Thread.sleep(rate);
			autoclicker.mouseMove(433, 349 /*433, 383*/);
			Thread.sleep(rate);
			autoclicker.mousePress(InputEvent.BUTTON1_MASK);
			//Thread.sleep(rate);
			autoclicker.mouseMove(367, 351 /*366, 384*/);
			Thread.sleep(rate);
			autoclicker.mouseRelease(InputEvent.BUTTON1_MASK);
			Thread.sleep(rate);
			autoclicker.keyPress(KeyEvent.VK_META);
			Thread.sleep(rate);
			autoclicker.keyPress(KeyEvent.VK_V);
			Thread.sleep(rate);
			autoclicker.keyRelease(KeyEvent.VK_V);
			Thread.sleep(rate);
			autoclicker.keyRelease(KeyEvent.VK_META);
			//Thread.sleep(rate);
			autoclicker.mouseMove(510, 350 /*511, 384*/);
			Thread.sleep(rate);
			autoclicker.mousePress(InputEvent.BUTTON1_MASK);
			Thread.sleep(rate);
			autoclicker.mouseRelease(InputEvent.BUTTON1_MASK);
			//Thread.sleep(rate);
			autoclicker.mouseMove(632+x, 376+y);
			Thread.sleep(rate);
			autoclicker.mousePress(InputEvent.BUTTON1_MASK);
			Thread.sleep(rate);
			autoclicker.mouseRelease(InputEvent.BUTTON1_MASK);
			if (x == 39) {
				y++;
				x = -1;
			}
			x++;
		}
	}
}
