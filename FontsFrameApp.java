import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class FontsFrame extends JFrame{
	public FontsFrame(){
		setTitle("Fonts Display");
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension d = tk.getScreenSize();
		int width = 500;
		int height = 175;
		setBounds((int)(d.width - width)/2, (int)(d.height - height)/2, width, height);
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		FontsPanel panel = new FontsPanel();
		add(panel);
	}
}
public class FontsFrameApp{
	public static void main(String[] args){
		FontsFrame frame = new FontsFrame();
		frame.setVisible(true);
	}
}
