package resultUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import MainInterface.Main;
import errorProblem.errorProblem;

import javax.swing.JButton;
import javax.swing.JScrollPane;

public class ResultGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	

	public ResultGUI(String message, List<String> errorProblemlist, Main main,errorProblem ep) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 875, 875);
		JPanel contentPane = new JPanel();
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("结果展示");
		lblNewLabel.setFont(new Font("楷体", Font.PLAIN, 27));
		lblNewLabel.setBounds(375, 5, 108, 32);
		contentPane.add(lblNewLabel);
		setContentPane(contentPane);

		JButton btnNewButton = new JButton("\u91CD\u65B0\u751F\u6210\u9898\u76EE");
		btnNewButton.setBounds(574, 803, 120, 23);
		contentPane.add(btnNewButton);

		// 退出
		JButton btnNewButton_1 = new JButton("\u9000\u51FA");
		btnNewButton_1.setBounds(719, 803, 93, 23);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(40, 40, 782, 753);
		contentPane.add(scrollPane);

		JTextArea textArea = new JTextArea(39, 79);
		scrollPane.setViewportView(textArea);
		textArea.setText(message);
		textArea.setFont(new Font("楷体", Font.PLAIN, 20));
		textArea.setEditable(false);

		JButton btnNewButton_2 = new JButton("\u5C06\u9519\u9898\u52A0\u5165\u9519\u9898\u672C");
		btnNewButton_2.setBounds(397, 803, 149, 23);
		btnNewButton_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ep.addErrorProblemAndNumber(errorProblemlist);
			}
		});
		contentPane.add(btnNewButton_2);

		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				main.makeButtonEnable();
				dispose();
			}
		});
	}
}
