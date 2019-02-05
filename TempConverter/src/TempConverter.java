import java.awt.BorderLayout;
import java.awt.CheckboxGroup;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JRadioButton;

public class TempConverter extends JFrame implements ItemListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private ArrayList<JCheckBox> checkboxes  = null;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private static int from = 1;
	private static int to = 5;
	public void itemStateChanged(ItemEvent e) {
		JRadioButton aRadioButton = (JRadioButton)e.getItem();
		int temp = Integer.parseInt(aRadioButton.getActionCommand());
		if((temp >= 1) && (temp <= 3)){
			TempConverter.from = temp;
	}else {
		TempConverter.to = temp;
	}
	}
	
	public boolean validatePanel(JPanel panel) {  
		int i = 0;
	    for (Component component : panel.getComponents()) {
	        if(component instanceof JCheckBox){
	            JCheckBox c = (JCheckBox) component;
	            if(c.isSelected()){
	            	++i;
	            	
	            }
	        }
	    }
	    if(i == 2) {
			return true;
		}else {
			return false;
		}
	    
	}
	
	
	
	public void buttonAction(JPanel panel, JLabel label, JTextField textField) {
		JButton button = null; 
		for (Component component : panel.getComponents()) {
		        if(component instanceof JButton){
		        	button = (JButton) component;
		        }
		}
		
		button.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	
		        	try
		        	{
		        	double temp = Double.parseDouble(textField.getText());
		        	double output = 0.0;
		        	String tempFrom = String.valueOf(TempConverter.from);
		        	String tempTo = String.valueOf(TempConverter.to);
		        	if((tempFrom.equals("1")) && (tempTo.equals("5"))) {
		        		output = temp * 1.8 + 32;
		        		label.setText(String.valueOf(output));
		        		
		        	}else if((tempFrom.equals("2")) && (tempTo.equals("4"))) {
		        		output = (temp - 32)/1.8;
		        		label.setText(String.valueOf(output));
		        		
		        	}else if((tempFrom.equals("2")) && (tempTo.equals("6"))) {
		        		output = (temp + 459.67)* 5/9;
		        		label.setText(String.valueOf(output));
		        		
		        	}else if((tempFrom.equals("3")) && (tempTo.equals("5"))) {
		        		output = temp * 9/5 - 459.67;
		        		label.setText(String.valueOf(output));
		        		
		        	}else if((tempFrom.equals("1")) && (tempTo.equals("6"))) {
		        		output = temp + 273.15;
		        		label.setText(String.valueOf(output));
		        	}else if((tempFrom.equals("3")) && (tempTo.equals("4"))) {
		        		output = temp - 273.15;
		        		label.setText(String.valueOf(output));
		        	}
		        	
		        	}
		        	catch(NumberFormatException g) {
			        	TempConverter.infoBox("Enter a numerical temperature.", "Alert");
			        }
		        }
		        
		        
		        
		        
		});
	}
	
	public static void infoBox(String infoMessage, String titleBar)
    {
        JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
    }
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TempConverter frame = new TempConverter();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TempConverter() {
		setForeground(Color.BLACK);
		setTitle("Temparature Conversion");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 785, 580);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 22));
		textField.setBounds(258, 54, 164, 47);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnConvert = new JButton("Convert");
		btnConvert.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnConvert.setBounds(300, 264, 115, 47);
		contentPane.add(btnConvert);
		
		
		
		
		
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(15, 465, 720, 43);
		contentPane.add(lblNewLabel);
		
		 
		
		 
		
		
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Celcius");
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setBounds(76, 139, 180, 29);
		rdbtnNewRadioButton.setActionCommand("1");
		rdbtnNewRadioButton.addItemListener(this);
		contentPane.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setSelected(true);
		
		JRadioButton rdbtnFahrenheit = new JRadioButton("Fahrenheit");
		rdbtnFahrenheit.setFont(new Font("Tahoma", Font.PLAIN, 20));
		buttonGroup.add(rdbtnFahrenheit);
		rdbtnFahrenheit.setBounds(258, 139, 155, 29);
		rdbtnFahrenheit.setActionCommand("2");
		rdbtnFahrenheit.addItemListener(this);
		contentPane.add(rdbtnFahrenheit);
		
		JRadioButton rdbtnKelvin = new JRadioButton("Kelvin");
		rdbtnKelvin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		buttonGroup.add(rdbtnKelvin);
		rdbtnKelvin.setBounds(464, 139, 155, 29);
		rdbtnKelvin.setActionCommand("3");
		rdbtnKelvin.addItemListener(this);
		contentPane.add(rdbtnKelvin);
		
		JRadioButton rdbtnCelcius = new JRadioButton("Celcius");
		rdbtnCelcius.setFont(new Font("Tahoma", Font.PLAIN, 20));
		buttonGroup_1.add(rdbtnCelcius);
		rdbtnCelcius.setBounds(78, 188, 155, 29);
		rdbtnCelcius.setActionCommand("4");
		rdbtnCelcius.addItemListener(this);
		contentPane.add(rdbtnCelcius);
		
		JRadioButton rdbtnFahrenheit_1 = new JRadioButton("Fahrenheit");
		rdbtnFahrenheit_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		buttonGroup_1.add(rdbtnFahrenheit_1);
		rdbtnFahrenheit_1.setBounds(267, 188, 155, 29);
		rdbtnFahrenheit_1.setActionCommand("5");
		rdbtnFahrenheit_1.addItemListener(this);
		contentPane.add(rdbtnFahrenheit_1);
		rdbtnFahrenheit_1.setSelected(true);
		
		JRadioButton rdbtnKelvin_1 = new JRadioButton("Kelvin");
		rdbtnKelvin_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		buttonGroup_1.add(rdbtnKelvin_1);
		rdbtnKelvin_1.setBounds(464, 188, 155, 29);
		rdbtnKelvin_1.setActionCommand("6");
		rdbtnKelvin_1.addItemListener(this);
		contentPane.add(rdbtnKelvin_1);
		
		buttonAction(contentPane, lblNewLabel, textField);
		
		JLabel lblNewLabel_1 = new JLabel("From");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(15, 145, 60, 20);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblTo = new JLabel("To");
		lblTo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTo.setBounds(15, 192, 60, 20);
		contentPane.add(lblTo);
	}
}
