import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Snake extends JPanel implements ActionListener, KeyListener {

	public Apple a = new Apple();
	public static Test T;

	public Timer time;
	public int delay = 50;

	public boolean right, left, up, down;

	public static int count = 0;
	public static int[] x = new int[1000];
	public static int[] y = new int[1000];
	public static int lengthofsnake = 1;

	// ---------------------------------------------------------------

	public Snake() {
		x[0] = 250;
		y[0] = 250;

		time = new Timer(delay, this);

		time.start();
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
	}

	// -----------------------------------------------------------------
	public static void addBody() {

		x[lengthofsnake] = x[lengthofsnake - 1];
		y[lengthofsnake] = y[lengthofsnake - 1];
		lengthofsnake++;
		T.l1.setText("score: " + (lengthofsnake - 1));

	}

	// ------------------------------------------------------------------
	public void collision() {
		for (int i = 1; i < lengthofsnake; i++)
			if (x[0] == x[i] && y[0] == y[i])
				if (lengthofsnake != 2)
					gameover();
	}

	public void gameover() {
		System.out.println("GAMEOVER");
	}

	// --------------------------------------------------------------------

	/*
	 * public void track() { System.out.println("x: " + x[0]);
	 * System.out.println("y: " + y[0]); }
	 */
	// -----------------------------------------------------------------

	public void actionPerformed(ActionEvent e) {
		a.actionPerformed(e);
		collision();
		// track();
		if (right) {
			for (int r = lengthofsnake - 1; r >= 0; r--)
				y[r + 1] = y[r];

			for (int r = lengthofsnake; r >= 0; r--) {
				if (r == 0)
					x[r] = x[r] + 11;

				else
					x[r] = x[r - 1];

				if (x[r] > 483)
					x[r] = 0;

			}

		}

		if (left) {
			for (int r = lengthofsnake - 1; r >= 0; r--)
				y[r + 1] = y[r];

			for (int r = lengthofsnake; r >= 0; r--) {
				if (r == 0)
					x[r] = x[r] - 11;

				else
					x[r] = x[r - 1];

				if (x[r] < 0)
					x[r] = 483;

			}

		}

		if (down) {
			for (int r = lengthofsnake - 1; r >= 0; r--)
				x[r + 1] = x[r];

			for (int r = lengthofsnake; r >= 0; r--) {
				if (r == 0)
					y[r] = y[r] + 11;

				else
					y[r] = y[r - 1];

				if (y[r] > 460)
					y[r] = 0;
			}
		}

		if (up) {
			for (int r = lengthofsnake - 1; r >= 0; r--)
				x[r + 1] = x[r];

			for (int r = lengthofsnake; r >= 0; r--) {
				if (r == 0)
					y[r] = y[r] - 11;

				else
					y[r] = y[r - 1];

				if (y[r] < 0)
					y[r] = 460;

			}
		}
		repaint();

	}
	// -----------------------------------------------------------------

	public void paintComponent(Graphics h) {

		super.paintComponent(h);

		a.paintComponent(h);
		h.setColor(Color.YELLOW);

		for (int i = 0; i < lengthofsnake; i++)
			h.fillRect(x[i], y[i], 10, 10);

	}

//-------------------------------------------------------------------

	public void keyPressed(KeyEvent e) {

		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			right = true;
			up = false;
			down = false;
			if (left)
				right = false;

		}

		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			left = true;
			up = false;
			down = false;
			if (right)
				left = false;

		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			up = true;
			left = false;
			right = false;

			if (down)
				up = false;

		}

		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			down = true;
			left = false;
			right = false;

			if (up)
				down = false;

		}
	}
	// -------------------------------------------------------------

	public void keyReleased(KeyEvent e) {
	}

	public void keyTyped(KeyEvent e) {
	}

	public static void main(String[] args) {

		T = new Test();
		T.StartGame();

	}

}
