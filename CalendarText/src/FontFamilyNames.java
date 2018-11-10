

import java.awt.GraphicsEnvironment;

public class FontFamilyNames{
	String allFontName[];
	public String [] getFontName(){
		GraphicsEnvironment ge=GraphicsEnvironment.getLocalGraphicsEnvironment();
		allFontName=ge.getAvailableFontFamilyNames();
		return allFontName;
   }
}