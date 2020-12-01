import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.util.Random;

public class Apple {

	int x1, y1;
	Random r;
//----------------------------------------------------------

	public Apple() {
		r = new Random();
		x1 = r.nextInt(483);
		y1 = r.nextInt(460);
	}
//----------------------------------------------------------

	public void paintComponent(Graphics h) {
		h.setColor(Color.RED);
		h.fillRect(x1, y1, 10, 10);
	}
//----------------------------------------------------------

	public void actionPerformed(ActionEvent e) {

		// System.out.println(Snake.x+" "+Snake.y);

		if ((Snake.x[0] < 9 + x1 && Snake.x[0] > x1 - 9) && (Snake.y[0] < 9 + y1 && Snake.y[0] > y1 - 9)) {
			Snake.addBody();
			x1 = r.nextInt(483);
			y1 = r.nextInt(460);
		}

	}

}
