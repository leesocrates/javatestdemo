package javatest.GenericTest.inherit;

public class HkPresenter extends BasePresenterAbsImp {
    private HkView hkView;

    public HkPresenter(HkView view){
        super(view);
        this.hkView = view;
        this.hkView.printHk();
    }

}
