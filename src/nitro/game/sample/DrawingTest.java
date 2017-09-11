package nitro.game.sample;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class DrawingTest extends MouseAdapter{
	static JFrame frame;
	public static void main(String[] arguments) {
		SwingUtilities.invokeLater(()->displayGui());
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getClickCount() == 2)
			frame.removeAll();
	}
	
	private static void displayGui() {
		frame = new JFrame();
		frame.setLayout(new GridBagLayout());
		frame.add(new TestPanel());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(500,500));
		frame.pack();
		frame.setVisible(true);
	}
}

class TestPanel extends JPanel{
	public TestPanel() {
		setBorder(BorderFactory.createLineBorder(Color.red));
		
		setPreferredSize(new Dimension(300,100));
		
		
	}
	
	@Override	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawString("Pesho", 10, 20);
		
		Graphics clone = g.create();
		clone.drawString("PeshoClone", 50, 20);
	}
	
	@Override
	public void processMouseEvent(MouseEvent e) {
		if(e.getClickCount() == 2)
		removeAll();
	}
}
