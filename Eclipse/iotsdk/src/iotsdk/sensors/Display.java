package iotsdk.sensors;

import java.awt.Color;
import java.awt.Font;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JTextField;

import iotsdk.Sensor;

public class Display extends Sensor {
	private JTextField tf;
	public static String desc = "This device displays the string passed in input. Il there is a string different from \"0\" displayed, the output value is 1";

	public Display(String id,String name) throws IOException {
		super(id, "Display", "2",name);
		tf = new JTextField();
		tf.setHorizontalAlignment(JTextField.CENTER);
		tf.setEditable(false);
		tf.setBounds(0,20,120,30);
		tf.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.GRAY));
		tf.setBackground(Color.BLACK);
		tf.setForeground(Color.WHITE);
		tf.setFont(new Font("PT Mono", Font.PLAIN, 12));
		super.getGuiPanel().add(tf);
	}

	@Override
	public void updateGui() {
		if(isTurnedOn()) {
			tf.setText(super.getInput());
			if(!tf.getText().equals("0")) {
				writeOutput("1");
			}
		} else {
			tf.setText("-");
			writeOutput("0");
		}
	}

}
