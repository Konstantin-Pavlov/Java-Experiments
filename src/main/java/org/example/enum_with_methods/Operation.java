package org.example.enum_with_methods;

public enum Operation implements Describable {
    ADD("add") {
        @Override
        public double calculate(double x, double y) {
            return x + y;
        }

        @Override
        public void describe() {
            System.out.println("Operation: " + getName() + " - This operation adds two numbers.");
        }
    },
    SUBTRACT("subtract") {
        @Override
        public double calculate(double x, double y) {
            return x - y;
        }

        @Override
        public void describe() {
            System.out.println("Operation: " + getName() + " - This operation subtracts the second number from the first.");
        }
    },
    MULTIPLY("multiply") {
        @Override
        public double calculate(double x, double y) {
            return x * y;
        }

        @Override
        public void describe() {
            System.out.println("Operation: " + getName() + " - This operation multiplies two numbers.");
        }
    },
    DIVIDE("divide") {
        @Override
        public double calculate(double x, double y) {
            if (y == 0) {
                throw new ArithmeticException("Cannot divide by zero");
            }
            return x / y;
        }

        @Override
        public void describe() {
            System.out.println("Operation: " + getName() + " - This operation divides the first number by the second.");
        }
    };

    private final String name;

    // Конструктор перечисления
    Operation(String name) {
        this.name = name;
    }

    // Геттер для поля name
    public String getName() {
        return name;
    }

    // Абстрактный метод для расчета операции
    public abstract double calculate(double x, double y);
}

