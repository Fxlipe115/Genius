package genius.types;

import java.awt.Dimension;

public enum ScreenSize {
	_640x480(new Dimension(640, 480), "640x480"),
	_800x600(new Dimension(800, 600), "800x600"),
	_1024x768(new Dimension(1024, 768), "1024x768"),
	_1280x960(new Dimension(1280, 960), "1280x960"),
	_1400x1050(new Dimension(1400, 1050), "1400x1050"),
	_1600x1200(new Dimension(1600, 1600), "1600x1200");

	private Dimension dimension;
	private String name;
	
	ScreenSize(Dimension dimension, String name){
		this.dimension = dimension;
		this.name = name;
	}
	
	public Dimension getValue(){
		return dimension;
	}

	@Override
	public String toString() {
		return name;
	}
	
}
