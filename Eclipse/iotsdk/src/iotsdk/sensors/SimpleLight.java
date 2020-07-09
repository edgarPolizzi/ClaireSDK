package iotsdk.sensors;

import java.awt.Color;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

import iotsdk.Sensor;

public class SimpleLight extends Sensor {
	private static final long serialVersionUID = -2693959476765346634L;
	public static String desc = "The light is off when input is 0, else is on. The output is 0 if the light is off, else is 1";
	
	private JLabel light = new JLabel("");

	public SimpleLight(String id, String name) throws IOException {
		super(id, "Light","0",name);
		light.setOpaque(true);
		getGuiPanel().add(light);
		light.setBounds(32, 20, 60, 60);
		light.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		updateGui();
	}

	@Override
	public void updateGui() {
		if(isTurnedOn()) {
			try {
				long num = Math.round(Double.valueOf(getInput()));
				if(num==0) {
					light.setBackground(Color.BLACK);
					writeOutput("0");
				} else {
					light.setBackground(Color.WHITE);
					writeOutput("1");
				}
			} catch(Exception e) {
				light.setBackground(Color.LIGHT_GRAY);
			}
		} else {
			light.setBackground(Color.LIGHT_GRAY);
		}
	}

}
