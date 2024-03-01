package org.example.fuctionalInterfaceExample.staticAndNonStatic;

public class Main {
    public static void main(String[] args) {
        Test test = new Test();

        Delta delta= Test::setCode; // (Test tst, int n) -> tst.setCode(n)

        Beta beta = Test::display; // (Test tst) -> tst.display()
        // the same as:
        beta = test1 -> test1.display();
        // or:
        beta = new Beta() {
            @Override
            public void beta(Test test) {
                test.display();
            }
        };

        Gamma gamma = Test::show; // (String s) -> Test.show(s)
        // the same as:
        gamma = new Gamma() {
            @Override
            public void gamma(String s) {
                Test.show(s);
            }
        };

        // calling methods
        test.setCode(111);
        beta.beta(test);
        delta.delta(test, 333);
        test.display();
        gamma.gamma("java");




    }
}
