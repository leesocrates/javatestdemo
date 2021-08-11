package javatest.collections;

import java.util.ArrayList;

public class ArrayListTest {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(1);
        arrayList.add(2);
        System.out.println(arrayList);
        ArrayList arrayList1 = (ArrayList) arrayList.clone();
        System.out.println(arrayList1);

        CloneObject object = new CloneObject();
        object.i =2;
        object.j = 3;
        CloneObject object1 = object.clone();
        System.out.println(object.i+ " "+ object.j);
        System.out.println(object1.i+ " "+ object1.j);
    }
}

class CloneObject implements Cloneable{
    public int i;
    public int j;

    public CloneObject clone(){
        try {
            return (CloneObject) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
