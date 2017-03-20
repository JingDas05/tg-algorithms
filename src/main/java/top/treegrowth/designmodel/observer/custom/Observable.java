package top.treegrowth.designmodel.observer.custom;

import java.util.Vector;

/**
 * 被观察的人
 *
 * @author wusi
 * @version 2017/3/20 9:12
 */
public abstract class Observable {

    private Vector<Observer> observers = new Vector<>();

    void addObserver(Observer observer) {
        this.observers.add(observer);
    }

    void removeObserver(Observer observer) {
        this.observers.remove(observer);
    }

    void notifyObserver() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}
