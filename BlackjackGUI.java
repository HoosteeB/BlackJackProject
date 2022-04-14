import java.awt.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class BlackjackGUI extends JPanel {
	public static final int FRAME_WIDTH = 800;
	public static final int FRAME_HEIGHT = 600;
	
	public GameManager game;
	
	public BlackjackGUI(GameManager game) {
		this.game = game;
	
			try {
				JFrame frame = new JFrame("Blackjack");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
				frame.setTitle("Blackjack");
				frame.setLocationRelativeTo(null);

				///////////////////////////////////////////////////////////////////////////////////
				// get a screen size and put a frame on the center of screen
				Dimension screenSize = new Dimension(Toolkit.getDefaultToolkit().getScreenSize());
				frame.setLocation(new Point((int) (screenSize.width / 2.0), (int) (screenSize.height / 2.0)));
				///////////////////////////////////////////////////////////////////////////////////


				//JPanels for Border Layout
				frame.setLayout(new BorderLayout());
				JPanel north = new JPanel(new FlowLayout());
				JPanel south = new JPanel(new FlowLayout());
				JPanel center = new JPanel(new FlowLayout());

				
				///////////////////////////////////////////////////////////////////////////////////////
				//Dimension sizes and background colors
				
				
				north.setPreferredSize(new Dimension (40,250));
				north.setBackground(new Color(0,153,0));

				center.setBackground(new Color(0,153,0));

				south.setPreferredSize(new Dimension (40,45));
				south.setBackground(new Color(0,100,0));

				
				////////////////////////////////////////////////////////////////////////////////////////
				//Center Panel or Player's Panel


			
				BufferedImage img3 = ImageIO.read(new File("AceOfSpades.png"));
				JLabel pic3 = new JLabel(new ImageIcon(img3));

				
				BufferedImage img4 = ImageIO.read(new File("4OfHearts.png"));
				JLabel pic4 = new JLabel(new ImageIcon(img4));
				
		
				
				center.add(pic4);
				center.add(pic3);
				
				

				//////////////////////////////////////////////////////////////////////////////////////
				//North Panel or Dealer's Panel


				
				BufferedImage img = ImageIO.read(new File("BacksideOfCard.png"));
				JLabel pic = new JLabel(new ImageIcon(img));
				
				
				BufferedImage img2 = ImageIO.read(new File("2OfDiamonds.png"));
				JLabel pic2 = new JLabel(new ImageIcon(img2));
				
				//int dealerTotal = 21;
				//pic is put right of the pic2
				north.add(pic2);
				north.add(pic);


				////////////////////////////////////////////////////////////////////////////////////////
				//South Panel


				JButton hitBtn = new JButton();
				hitBtn.setFont(new Font("Plain", Font.BOLD, 20));
				hitBtn.setText("Hit");
				hitBtn.setBackground(Color.WHITE);
				hitBtn.addActionListener(new ActionListener() {
	
					public void actionPerformed(ActionEvent e) {
						//hitProcess();
					} } ); 

				JButton doubleBtn = new JButton();
				doubleBtn.setFont(new Font("Plain", Font.BOLD, 20));
				doubleBtn.setText("Double");
				doubleBtn.setBackground(Color.WHITE);
				doubleBtn.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
						//doubleProcess();
					} } );

				JButton standBtn = new JButton();
				standBtn.setFont(new Font("Plain", Font.BOLD, 20));
				standBtn.setText("Stand");
				standBtn.setBackground(Color.WHITE);
				standBtn.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
						
					} } );

				south.add(hitBtn);
				south.add(doubleBtn);
				south.add(standBtn);

				/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
				//Adding all the changes to the panel to the frame
				frame.add(north, BorderLayout.NORTH);
				frame.add(center, BorderLayout.CENTER);
				frame.add(south, BorderLayout.SOUTH);
				
				
				frame.setVisible(true);
				
			} 
			catch (IOException e) {
				e.printStackTrace();
			}
	}
	
	


	

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
	}

}
