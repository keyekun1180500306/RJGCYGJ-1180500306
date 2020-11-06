package resultUI;

import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ResultGUI extends JFrame {
	private String message;
	public ResultGUI(String message) {
		this.message = message;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 875, 875);
		JPanel contentPane = new JPanel();
		


		JLabel lblNewLabel = new JLabel("结果展示");
		lblNewLabel.setFont(new Font("楷体", Font.PLAIN, 27));
		lblNewLabel.setBounds(430, 28, 263, 55);
		contentPane.add(lblNewLabel);

		
		JTextArea textArea = new JTextArea(39,79);
		textArea.setBounds(590, 119, 54, 24);
		textArea.setEditable(false);
		textArea.setText(message);
		textArea.setFont(new Font("楷体", Font.PLAIN, 20));
		contentPane.add(textArea);
		setContentPane(contentPane);
	}
	


}
