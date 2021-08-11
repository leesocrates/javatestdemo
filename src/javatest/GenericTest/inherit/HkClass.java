package javatest.GenericTest.inherit;

public class HkClass extends BaseClass implements HkView {

    @Override
    public void initPresenter() {
        HkPresenter hkPresenter = new HkPresenter(this);
    }

    @Override
    public void printHk() {
        System.out.println("print Hk view implement");
    }

    public static void main(String[] args) {
        HkClass hkClass = new HkClass();
        hkClass.initPresenter();
    }
}
