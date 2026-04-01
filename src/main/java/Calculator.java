
public class Calculator {
    private Adder adder;

    public Calculator(Adder adder) {
        this.adder = adder;
    }

    public int add(int a, int b) {
        return adder.add(a, b);
    }

    public int subtract(int a, int b) {
        return adder.add(a, -b);
    }

    public int multiply(int a, int b) {
        int result = 0;
        if (b < 0) {
            b = -b;
            a = -a;
        }
        for (int i = 0; i < b; i = adder.add(i, 1)) {
            result = adder.add(result, a);
        }
        return result;
    }

    public int divide(int a, int b) {
        int result = 0;
        if (b == 0) {
            throw new ArithmeticException("Divide by zero");
        }

        while(a > 0) {
            result = adder.add(result, 1);
            System.out.println(a);
            a = adder.add(a, -b);
        }
        if(a==0) result = adder.add(result, 1);
        return adder.add(result, -1);
    }
}