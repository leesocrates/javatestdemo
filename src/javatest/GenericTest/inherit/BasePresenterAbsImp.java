package javatest.GenericTest.inherit;

public abstract class BasePresenterAbsImp implements BasePresenter {
    private BaseView baseView;
    public BasePresenterAbsImp(BaseView view){
        this.baseView = view;
        this.baseView.printBase();
    }
}
