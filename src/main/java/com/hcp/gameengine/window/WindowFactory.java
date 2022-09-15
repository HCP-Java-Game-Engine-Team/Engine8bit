package com.hcp.gameengine.window;

public class WindowFactory {

    private WindowFactory windowFactoryInstance;

    private WindowFactory() {
    }

    public WindowFactory getWindowFactoryInstance() {
        if (windowFactoryInstance == null) {
            windowFactoryInstance = new WindowFactory();
        }
        return windowFactoryInstance;
    }

    public applicationWindow getWindow(String windowType) {
        if (...) {
            return new ...;
        } else if (...) {
            return new ...;
        } else if (...) {
            return new ...;
        } else if (...) {
            return new ...;
        }
    }
}
