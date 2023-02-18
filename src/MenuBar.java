import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;

import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuBar extends JFrame implements ActionListener {

	JMenuItem open;
	JFileChooser fileChooser;
	File file;
	JMenuItem colorYes;
	JMenuBar menuBar;
	JMenu about;
	JMenu filef;
	JMenu edit;
	public MenuBar() {
		
		setTitle("Menu bar");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		menuBar= new JMenuBar();
		menuBar.setBackground(new Color(35,87,96));
		
		menuBar.addMouseListener(new mouseAction());
		 filef = new JMenu("File");
		edit = new JMenu("Edit");
		 about = new JMenu("About");
		filef.setFont(new Font("Dialog", Font.PLAIN,20));
		filef.setForeground(Color.white);
		
		about.addMouseListener(new mouseAction());
		filef.addMouseListener(new mouseAction());
		edit.addMouseListener(new mouseAction());
		
		edit.setFont(new Font("Dialog", Font.PLAIN,20));
		
		edit.setForeground(Color.white);
		about.setFont(new Font("Dialog", Font.PLAIN,20));
		about.setForeground(Color.white);
		
		 open= new JMenuItem("Open File");
		JMenuItem save= new JMenuItem("Save File");
		colorYes= new JMenuItem("Color Chooser");
		JMenuItem close= new JMenuItem("Exit");
		
		filef.add(open);
		filef.add(save);
		filef.add(colorYes);
		filef.add(close);
		close.addActionListener(e-> System.exit(0));
		open.addActionListener(new action());
		colorYes.addActionListener(new action());
		
		
		menuBar.add(filef);
		menuBar.setBorderPainted(true);
		menuBar.add(edit);
		menuBar.add(about);
		setJMenuBar(menuBar);
		setSize(500,500);
		setVisible(true);
		
		
	}

	// ------------------- hover -----------------
	public class mouseAction implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {

			if(e.getSource()==filef) {
				filef.setBackground(Color.green);
				filef.setOpaque(true);
			}
			
		}

		@Override
		public void mousePressed(MouseEvent e) {

			
		}

		@Override
		public void mouseReleased(MouseEvent e) {

			
		}

		@Override
		public void mouseEntered(MouseEvent e) {

			
			if(e.getSource()==about)
			{
				about.setBackground(Color.red);
				about.setOpaque(true);
			}
			if(e.getSource()==filef) {
				filef.setBackground(Color.red);
				filef.setOpaque(true);
			}
			
			if(e.getSource()==edit) {
				edit.setBackground(Color.red);
				edit.setOpaque(true);
			}
			if(e.getSource()==filef) {
				getContentPane().setBackground(null);
			}
			
			
		}

		@Override
		public void mouseExited(MouseEvent e) {

			
			if(e.getSource()==about) {
				about.setBackground(null);
			}
			if(e.getSource()==filef) {
				filef.setBackground(null);
			}
			if(e.getSource()==edit) {
				edit.setBackground(null);
			}
			
			
		}

	
		
	}
	
	
	public class action implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {

			
			if(e.getSource()==open) {
				
			
			 fileChooser= new JFileChooser();
			 fileChooser.setCurrentDirectory(new File("C:\\Users\\mahmut\\Desktop"));
			int res= fileChooser.showOpenDialog(null);
			
			if(res==JFileChooser.APPROVE_OPTION) {
				
				 String a=fileChooser.getSelectedFile().getAbsolutePath();
				  file= new File(a);
				  System.out.println(a);
				
			}
			}
			if(e.getSource()==colorYes) {
				JColorChooser choseColor=new JColorChooser();
				
				Color color=choseColor.showDialog(null, "Color chose", Color.red);
				getContentPane().setBackground(color);
			}
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {


	}

	

}
