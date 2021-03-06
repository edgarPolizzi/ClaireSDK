package iotsdk;

import java.awt.Color;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Settings implements Serializable{
	
	private Settings() {
		super();
	}

	private static final long serialVersionUID = 1470551968403874450L;
	
	public int refreshRate = 50;
	
	private static String srcpath = System.getProperty("user.home")+"/ClaireSDK/";
	
	public String themeSelected = "light";
	public Color bkgc1 = Color.WHITE;
	public Color bkgc2 = new Color(220,220,220);
	public Color bkgc3 = new Color(200,200,200);
	public Color plainText = Color.BLACK;
	public Color plainText2 = new Color(50,50,50);
	
	public Color plainTextCode = Color.BLACK;
	public Color codebkg = new Color(220,220,220);
	public Color terminalbkg = new Color(220,220,220);
	
	public Color c1 = Color.BLUE.darker();
	public Color c2 = Color.CYAN.darker();
	public Color c3 = Color.RED.darker();
	public Color c4 = Color.YELLOW.darker();
	public Color c5 = Color.MAGENTA.darker();
	public Color c6 = Color.ORANGE.darker();
	
	private int fontSize = 15;
	private  String fontFamily = "SansSerif";
	public Font codeFont = new Font(fontFamily, Font.PLAIN, fontSize);
	
	public void changeFontSize(int fontSize) {
		this.fontSize = fontSize;
		codeFont = new Font(fontFamily, Font.PLAIN, fontSize);
	}
	
	public int getFontSize() {
		return fontSize;
	}
	
	public void setFontFamily(String fontFamily) {
		this.fontFamily = fontFamily;
		codeFont = new Font(fontFamily, Font.PLAIN, fontSize);
	}
	public String getFontFamily() {
		return fontFamily;
	}
	
	public void setLightTheme() {
		themeSelected = "Light";
		bkgc1 = Color.WHITE;
		bkgc2 = new Color(220,220,220);
		bkgc3 = new Color(200,200,200);
		plainText = Color.BLACK;
		plainText2 = new Color(50,50,50);
		plainTextCode = Color.BLACK;
		codebkg = new Color(220,220,220);
		terminalbkg = new Color(220,220,220);
		c1 = Color.BLUE.darker();
		c2 = Color.CYAN.darker();
		c3 = Color.RED.darker();
		c4 = Color.YELLOW.darker();
		c5 = Color.MAGENTA.darker();
		c6 = Color.ORANGE.darker();
	}
	
	public void setDarkTheme() {
		themeSelected = "Dark";
		bkgc1 = Color.BLACK;
		bkgc2 = new Color(60,60,60);
		bkgc3 = new Color(80,80,80);
		plainText = Color.WHITE;
		plainText2 = new Color(200,200,200);
		plainTextCode = Color.WHITE;
		codebkg = new Color(60,60,60);
		terminalbkg = new Color(60,60,60);
		c1 = Color.GREEN.brighter();
		c2 = Color.CYAN;
		c3 = Color.RED;
		c4 = Color.MAGENTA;
		c5 = Color.YELLOW.darker();
		c6 = Color.ORANGE.darker();
	}
	
	public void setBlueTheme() {
		themeSelected = "Blue";
		bkgc1 = new Color(30,30,60);
		bkgc2 = new Color(60,60,80);
		bkgc3 = new Color(80,80,100);
		plainText = Color.WHITE;
		plainText2 = new Color(200,200,200);
		plainTextCode = Color.WHITE;
		codebkg = new Color(60,60,60);
		terminalbkg = new Color(60,60,60);
		c1 = Color.GREEN.brighter();
		c2 = Color.CYAN;
		c3 = Color.RED;
		c4 = Color.MAGENTA;
		c5 = Color.YELLOW.darker();
		c6 = Color.ORANGE.darker();
	}
	
	public void setGraphiteTheme() {
		themeSelected = "Graphite";
		bkgc1 = new Color(40,40,40);
		bkgc2 = new Color(80,80,80);
		bkgc3 = new Color(100,100,100);
		plainText = Color.WHITE;
		plainText2 = new Color(200,200,200);
		plainTextCode = Color.WHITE;
		codebkg = new Color(60,60,60);
		terminalbkg = new Color(60,60,60);
		c1 = Color.GREEN.brighter();
		c2 = Color.CYAN;
		c3 = Color.RED;
		c4 = Color.MAGENTA;
		c5 = Color.YELLOW.darker();
		c6 = Color.ORANGE.darker();
	}

	
	public void save() {
		try {
			File set = new File(srcpath+"settings");
			if(!set.exists()) {
				set.createNewFile();
			}
			FileOutputStream fos = new FileOutputStream(set);
		    ObjectOutputStream oos = new ObjectOutputStream(fos);
		    oos.writeObject(this);
		    oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static Settings getSettings() {
		
		try {
			FileInputStream fis = new FileInputStream(srcpath+"settings");
		    ObjectInputStream ois = new ObjectInputStream(fis);
		    Settings s = (Settings) ois.readObject();
		    ois.close();
		    return s;
		} catch (Exception e) {
			return new Settings();
		}
	}
	
	
	public String getSrcPath() {
		return srcpath;
	}

	public void setSrcPath(String path) {
		srcpath = path;
	}

	@Override
	public String toString() {
		return "Settings [refreshRate=" + refreshRate + ", themeSelected=" + themeSelected + ", bkgc1=" + bkgc1
				+ ", bkgc2=" + bkgc2 + ", bkgc3=" + bkgc3 + ", plainText=" + plainText + ", plainText2=" + plainText2
				+ ", plainTextCode=" + plainTextCode + ", codebkg=" + codebkg + ", terminalbkg=" + terminalbkg + ", c1="
				+ c1 + ", c2=" + c2 + ", c3=" + c3 + ", c4=" + c4 + ", c5=" + c5 + ", c6=" + c6 + ", fontSize="
				+ fontSize + ", fontFamily=" + fontFamily + ", codeFont=" + codeFont + "]";
	}
	

}
