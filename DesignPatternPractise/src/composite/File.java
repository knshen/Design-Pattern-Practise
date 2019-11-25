package composite;

import java.util.ArrayList;

public class File implements Component {
	private String name;
	
	public File(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void print() {
		System.out.println("[File]: " + name);
	}
}
