package presentation.view;

import java.util.concurrent.TimeUnit;

public class MainView {

    public MainView(){

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        MainView mainView = new MainView();
    }
}
