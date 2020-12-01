import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Test {

	public JFrame f = new JFrame("Snake");
	public JFrame f2 = new JFrame("Snake");
	public JFrame f1 = new JFrame("Snake");
	// public JButton resume = new JButton("Resume");
	// public JButton quit = new JButton("Quit");
	public JPanel pt = new JPanel();
	public JPanel pb = new JPanel();
	public JPanel pb2 = new JPanel();
	// public JPanel p2 = new JPanel();
	public JLabel l = new JLabel("SNAKE GAME");
	public JLabel l1 = new JLabel("Score: " + 0);
	public JButton b = new JButton("Start");
	public JButton b2 = new JButton("Exit");
	public Snake p1 = new Snake();
	public Font fo1 = new Font("Times New Roman", Font.PLAIN, 60);
	public Font fo2 = new Font("Times New Roman", Font.PLAIN, 45);
	public Font fo3 = new Font("Times New Roman", Font.PLAIN, 50);
	public Dimension dim = new Dimension();

//-------------------------------------------------------------------------------
	public void StartGame() {

		dim = Toolkit.getDefaultToolkit().getScreenSize();

		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(600, 500);
		f.getContentPane().setBackground(Color.CYAN);
		f.setLayout(null);
		f.setLocation(dim.width / 2 - f.getWidth() / 2, dim.height / 2 - f.getHeight() / 2);

		pt.setBackground(Color.CYAN);
		pt.setBounds(100, 50, 400, 100);

		pb.setBackground(Color.CYAN);
		pb.setBounds(195, 200, 200, 100);

		pb2.setBackground(Color.CYAN);
		pb2.setBounds(195, 330, 200, 100);

		l.setBounds(235, 0, 170, 180);
		l.setFont(fo1);

		b2.setBackground(Color.CYAN);
		b2.setFont(fo3);

		b.setFont(fo2);
		b.setBackground(Color.CYAN);

		Start();
		Exit(b2);

		pt.add(l);
		pb.add(b);
		pb2.add(b2);
		f.add(pt);
		f.add(pb);
		f.add(pb2);

	}

//--------------------------------------------------------------------------------
	public void Start() {

		b.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent a) {

				f.setVisible(false);

				f1.setVisible(true);
				f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				f1.setSize(500, 500);
				f1.setLocation(dim.width / 2 - f1.getWidth() / 2, dim.height / 2 - f1.getHeight() / 2);

				p1.setBackground(Color.BLACK);

				p1.add(l1);
				f1.add(p1);

				// Game();

			}

		});

	}

//------------------------------------------------------------------------------
	public void Exit(JButton b) {
		b.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				System.exit(0);
			}
		});

	}

//-----------------------------------------------------------------------------------
	/*
	 * public void Game() {
	 * 
	 * f1.addKeyListener(new KeyListener() { public void keyTyped(KeyEvent e) {
	 * 
	 * }
	 * 
	 * public void keyReleased(KeyEvent e) {
	 * 
	 * }
	 * 
	 * public void keyPressed(KeyEvent e) { if (e.getKeyCode() ==
	 * KeyEvent.VK_ESCAPE) {
	 * 
	 * f1.setVisible(false);
	 * 
	 * f2.setVisible(true); f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 * f2.setSize(600, 500);
	 * 
	 * p2.setBackground(Color.BLACK);
	 * 
	 * p2.add(resume); p2.add(quit); f2.add(p2);
	 * 
	 * Exit(quit); }
	 * 
	 * } });
	 * 
	 * }
	 */

//-----------------------------------------------------------------------------------

}