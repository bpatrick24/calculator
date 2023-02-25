import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator implements ActionListener {
	
	JFrame calcFrame;
	JTextField outputField;
	JButton[] numButtons = new JButton[10];
	JButton[] funcButtons = new JButton[8];
	JButton zeroButton, oneButton, twoButton, threeButton, fourButton, fiveButton, sixButton, sevenButton, eightButton, nineButton;
	JButton addButton, subButton, multButton, divButton, decButton, eqButton, delButton, clrButton;
	JPanel output, main, edit;
	
	Font calcFont = new Font("Roboto", Font.PLAIN, 36);
	
	double num1 = 0, num2 = 2, result = 0;
	char operator;
	
	Calculator() {
		
		calcFrame = new JFrame("Calculator");
		calcFrame.setSize(new Dimension(500,700));
		calcFrame.setLayout(new BorderLayout());
		calcFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		calcFrame.setResizable(false);
		
		
		addButton = new JButton ("+");
		subButton = new JButton ("-");
		multButton = new JButton ("*");
		divButton = new JButton ("/");
		decButton = new JButton (".");
		eqButton = new JButton ("=");
		delButton = new JButton ("Delete");
		clrButton = new JButton ("Clear");
		
		funcButtons[0] = addButton;
		funcButtons[1] = subButton;
		funcButtons[2] = multButton;
		funcButtons[3] = divButton;
		funcButtons[4] = decButton;
		funcButtons[5] = eqButton;
		funcButtons[6] = delButton;
		funcButtons[7] = clrButton;
		
		for (int i = 0; i < 8; i++) {
			funcButtons[i].setFont(calcFont);
			funcButtons[i].setFocusable(false);
			funcButtons[i].addActionListener(this);
		}
		
		for (int i = 0; i < 10; i++) {
			numButtons[i] = new JButton(String.valueOf(i));
			numButtons[i].setFont(calcFont);
			numButtons[i].setFocusable(false);
			numButtons[i].addActionListener(this);
		}
		
		//output panel
		output = new JPanel();
		output.setPreferredSize(new Dimension(700, 100));
		output.setBackground(Color.DARK_GRAY);
		output.setLayout(new GridBagLayout());
		outputField = new JTextField();
		outputField.setPreferredSize(new Dimension(250,50));
		outputField.setEditable(false);
		output.add(outputField);
		
		//main panel
		main = new JPanel();
		main.setPreferredSize(new Dimension(700, 300));
		main.setBackground(Color.DARK_GRAY);
		main.setLayout(new GridLayout(4,4));
		
		main.add(numButtons[1]);
		main.add(numButtons[2]);
		main.add(numButtons[3]);
		main.add(addButton);
		main.add(numButtons[4]);
		main.add(numButtons[5]);
		main.add(numButtons[6]);
		main.add(subButton);
		main.add(numButtons[7]);
		main.add(numButtons[8]);
		main.add(numButtons[9]);
		main.add(multButton);
		main.add(decButton);
		main.add(numButtons[0]);
		main.add(eqButton);
		main.add(divButton);
		
		//edit panel
		edit = new JPanel();
		edit.setPreferredSize(new Dimension(700, 100));
		edit.setBackground(Color.DARK_GRAY);
		
		edit.add(delButton);
		edit.add(clrButton);
		
		
		calcFrame.add(output, BorderLayout.NORTH);
		calcFrame.add(main, BorderLayout.CENTER);
		calcFrame.add(edit, BorderLayout.SOUTH);
		calcFrame.setVisible(true);
	}

	public static void main(String[] args) {
		
		Calculator calculator = new Calculator();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		for (int i = 0; i < 10; i++) {
			if(e.getSource() == numButtons[i]) {
				outputField.setText(outputField.getText().concat(String.valueOf(i)));
			}
		}
		if(e.getSource() == decButton) {
			outputField.setText(outputField.getText().concat("."));
		}
		if(e.getSource() == addButton) {
			num1 = Double.parseDouble(outputField.getText());
			operator = '+';
			outputField.setText(" ");
		}
		if(e.getSource() == subButton) {
			num1 = Double.parseDouble(outputField.getText());
			operator = '-';
			outputField.setText(" ");
		}
		if(e.getSource() == multButton) {
			num1 = Double.parseDouble(outputField.getText());
			operator = '*';
			outputField.setText(" ");
		}
		if(e.getSource() == divButton) {
			num1 = Double.parseDouble(outputField.getText());
			operator = '/';
			outputField.setText(" ");
		}
		if(e.getSource() == eqButton) {
			num2=Double.parseDouble(outputField.getText());
			
			switch(operator) {
			case'+':
				result = num1 + num2;
				break;
			case'-':
				result = num1 + num2;
				break;
			case'*':
				result = num1 * num2;
				break;
			case'/':
				result = num1 / num2;
				break;
			}
			outputField.setText(String.valueOf(result));
			num1=result;
		}
		if(e.getSource() == clrButton) {
			outputField.setText(" ");
		}
		if(e.getSource() == delButton) {
			String str = outputField.getText();
			outputField.setText("");
			for(int i = 0; i < str.length() - 1; i++) {
				outputField.setText(outputField.getText() + str.charAt(i));
			}
		}
	}

}
