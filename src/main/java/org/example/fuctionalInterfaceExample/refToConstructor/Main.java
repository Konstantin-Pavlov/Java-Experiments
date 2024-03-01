package org.example.fuctionalInterfaceExample.refToConstructor;

public class Main {
    public static void main(String[] args) {
        ClassCreator creator = MyClass::new;

        // same:
        creator = new ClassCreator() { //  n -> new MyClass(n);
            @Override
            public MyClass create(int n) {
                return new MyClass(n);
            }
        };

        MyClass myClass = creator.create(42);
        myClass.show();
    }
}
