import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class JMenuSysteem extends JFrame implements ActionListener{
	
	JMenuBar menubar;
	JMenu file;
	JMenu help;
	JMenu helpSubmenu;
	JMenuItem firstOption;
	JMenuItem secOption;
	JMenuItem save;
	JMenuItem exit;
	JMenuItem makeProgress;
	JProgressBar progress;
	JDialog progressDialog;
	int time;
	Timer tmr;
	
	JMenuSysteem(){
		
		setSize(300,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new FlowLayout());
		
		
		
		
		file = new JMenu("File");
		file.setMnemonic(KeyEvent.VK_F);
		help = new JMenu("Help");
		help.setMnemonic('H');
		
		firstOption = new JMenuItem("First", 'i');
		secOption = new JMenuItem("second", 's');
		
		save = new JMenuItem("Save", 'v');
		exit = new JMenuItem("Exit", 'e');
		
		makeProgress = new JMenuItem("progressBar");
		
		makeProgress.addActionListener(this);
		
		file.add(save);
		file.addSeparator();
		file.add(exit);
		file.addSeparator();
		file.add(makeProgress);
		
		help.add(firstOption);
		help.addSeparator();
		help.add(secOption);
		
		menubar = new JMenuBar();
		menubar.add(file);
		
		menubar.add(help);
		
		setJMenuBar(menubar);
		
		
		buildProgressDialog();
		
		time = 10;
		
		tmr = new Timer(1000, ae -> {
			time += 10;
			progress.setValue(time);
			
			if(time == 100){
				time = 10;
				progressDialog.setVisible(false);
			}
			
			
			
		});
		//tmr.start();
		setVisible(true);
		
	}
	
	public void buildProgressDialog(){
		progressDialog = new JDialog(this, "Progress", true);
		
		progressDialog.setSize(100, 200);
		progressDialog.setLocationRelativeTo(makeProgress);
		
		progressDialog.setLayout(new FlowLayout());
		
		progress = new JProgressBar(SwingConstants.VERTICAL, 0, 
100);
		
		progressDialog.add(progress);
		
		
	}
	
	
	
	
	public void actionPerformed(ActionEvent ae){
		
		if(ae.getActionCommand().equals("progressBar")){
			tmr.start();
			progressDialog.setVisible(true);
			
			
		
		}
		
		
	}
	
	public static void main(String[] args){
		SwingUtilities.invokeLater(() ->
		new JMenuSysteem());
	}
	
	
	
}

