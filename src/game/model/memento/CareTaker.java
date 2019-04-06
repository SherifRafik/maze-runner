package game.model.memento;

import java.util.ArrayList;
import java.util.List;

public class CareTaker {
	
	private List<Memento> mementoList = new ArrayList<Memento>();
	
	public void add(Memento state) {
		mementoList.add(state);
	}
	
	public void get(int index) {
		mementoList.get(index);
	}
}
