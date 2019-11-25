package composite;

import java.util.ArrayList;
import java.util.List;

public class Folder implements Component {
	private List<Component> list = null;
	private String name;
	
	public Folder(String name) {
		this.name = name;
		this.list = new ArrayList<>();
	}
	
	public String getName() {
		return name;
	}
	public void add(Component c) {
		list.add(c);
	}
	public void remove(Component c) {
		list.remove(c);
	}
	public void print() {
		System.out.println("[folder]: " + name);
		for(Component sub : list) {
			sub.print();
		}
	}
}
