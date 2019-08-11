/**
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 */
public class PowerOfNumber {
    double powerWithExponent(double base, int exponent) {
        if (exponent == 0) return 1;
        if (exponent == 1) return base;
        double r = powerWithExponent(base, exponent >> 1);
        r *= r;
        if ((exponent & 0x1) == 1) {
            r *= base;
        }

        return r;
    }

    public double Power(double base, int exponent) {
        if (exponent == 0) return 1;
        int e = Math.abs(exponent);
        double r = powerWithExponent(base, e);

        if (exponent < 0) {
            r = 1 / r;
        }

        return r;
    }

    public static void main(String[] args) {
        System.out.println(new PowerOfNumber().Power(2.0, 3));
        System.out.println(new PowerOfNumber().Power(2.0, -3));
        System.out.println(new PowerOfNumber().Power(2.0, 0));
        System.out.println(new PowerOfNumber().Power(4.0, 2));
        System.out.println(new PowerOfNumber().Power(5.0, 3));
    }
}
