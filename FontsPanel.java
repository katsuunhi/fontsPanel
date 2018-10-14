import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JPanel;

class FontsPanel extends JPanel implements ItemListener{
	JComboBox fontComboBox, sizeComboBox;
	JCheckBox boldCheckBox, italicCheckBox;
	Font font;

	public FontsPanel(){
		GraphicsEnvironment ge;
		ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		fontComboBox = new JComboBox(ge.getAvailableFontFamilyNames());
		fontComboBox.setSelectedItem("SansSerif");
		fontComboBox.addItemListener(this);

		String[] sizes = {"8", "10", "12", "14", "16", "18", "20", "22", "24", "26", "28", "30"};
		sizeComboBox = new JComboBox(sizes);
		sizeComboBox.setSelectedItem("18");
		sizeComboBox.addItemListener(this);

		boldCheckBox = new JCheckBox("Bold");
		boldCheckBox.setFont(new Font("Time New Roman", Font.BOLD, 14));
		boldCheckBox.addItemListener(this);
		italicCheckBox = new JCheckBox("Italic");
		italicCheckBox.setFont(new Font("Time New Roman", Font.ITALIC, 14));
		italicCheckBox.addItemListener(this);

		JPanel northPanel = new JPanel();
		northPanel.add(fontComboBox);
		northPanel.add(sizeComboBox);
		northPanel.add(italicCheckBox);
		northPanel.add(boldCheckBox);

		setLayout(new BorderLayout());
		add(northPanel, BorderLayout.NORTH);
		font = new Font("隶书", Font.PLAIN, 18);

	}
	public void itemStateChanged(ItemEvent e){
		String fontFamily = (String)fontComboBox.getSelectedItem();
		int style = Font.PLAIN;
		String sizeInt = (String)sizeComboBox.getSelectedItem();
		int size = Integer.parseInt(sizeInt);

		if((boldCheckBox.isSelected())&&(italicCheckBox.isSelected()))
			style = Font.BOLD + Font.ITALIC;
		else if(boldCheckBox.isSelected())
			style = Font.BOLD;
		else if(italicCheckBox.isSelected())
			style = Font.ITALIC;
		font = new Font(fontFamily, style, size);
		repaint();
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setFont(font);
		String text = "我爱生活，我爱JAVA";
		g.drawString(text, 100, 80);

	}
}