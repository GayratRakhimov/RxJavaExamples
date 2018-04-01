package com.gayratrakhimov.rxjavaexamples.examples.introduction.pattern;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.gayratrakhimov.rxjavaexamples.R;

import java.util.ArrayList;
import java.util.List;

public class ObserverPatternActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_observer_pattern);

        // This example is taken from Java Design Patterns by Vaskaran Sarcar

        System.out.println("***Observer Pattern Demo***\n"); Observer o1 = new Observer();
        Subject sub1 = new Subject(); sub1.register(o1); System.out.println("Setting Flag = 5 ");
        sub1.setFlag(5); System.out.println("Setting Flag = 25 "); sub1.setFlag(25);
        sub1.unregister(o1);

        sub1.setFlag(50);

    }

    class Observer {
        public void update() {
            System.out.println("flag value changed in Subject");
        }
    }

    interface ISubject {
        void register(Observer o);

        void unregister(Observer o);

        void notifyObservers();
    }

    class Subject implements ISubject {
        List<Observer> observerList = new ArrayList<Observer>();
        private int _flag;

        public int getFlag() {
            return _flag;
        }

        public void setFlag(int _flag) {
            this._flag = _flag;
            notifyObservers();
        }

        @Override
        public void register(Observer o) {
            observerList.add(o);
        }

        @Override
        public void unregister(Observer o) {
            observerList.remove(o);
        }

        @Override
        public void notifyObservers() {
            for (int i = 0; i < observerList.size(); i++) {
                observerList.get(i).update();
            }
        }
    }

}
