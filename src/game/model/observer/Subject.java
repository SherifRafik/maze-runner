package game.model.observer;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class Subject {
	//Observable
    private List<Observer> observers = new ArrayList<>();
    public int health , score;

    public void add(Observer o) {
        observers.add(o);
    }

    public int getHealth() {
        return health;
    }
    public int getScore() {
        return score;
    }

    public void setState(int score , int health , Graphics g) {
        this.score = score;
        this.health = health;
        notifyAllObservers(g);
    }

    private void notifyAllObservers(Graphics g) {
        for (Observer observer : observers) {
            observer.update(g);
        }
    }

}
