package task2;

import java.util.function.BiFunction;

class Fraction {
    int num, den;

    Fraction(int num, int den) {
        this.num = num;
        this.den = den;
    }

    Fraction add(Fraction other) {
        int newNum = this.num * other.den + other.num * this.den;
        int newDen = this.den * other.den;
        return simplify(new Fraction(newNum, newDen));
    }

    Fraction subtract(Fraction other) {
        int newNum = this.num * other.den - other.num * this.den;
        int newDen = this.den * other.den;
        return simplify(new Fraction(newNum, newDen));
    }

    Fraction multiply(Fraction other) {
        return simplify(new Fraction(this.num * other.num, this.den * other.den));
    }

    Fraction divide(Fraction other) {
        return simplify(new Fraction(this.num * other.den, this.den * other.num));
    }

    private Fraction simplify(Fraction f) {
        int gcd = gcd(Math.abs(f.num), f.den);
        f.num /= gcd;
        f.den /= gcd;
        if (f.den < 0) {
            f.num = -f.num;
            f.den = -f.den;
        }
        return f;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    @Override
    public String toString() {
        return num + "/" + den;
    }
}

public class Task2 {
    public static void main(String[] args) {
        Fraction f1 = new Fraction(1, 2);
        Fraction f2 = new Fraction(1, 3);

        BiFunction<Fraction, Fraction, Fraction> sum = Fraction::add;
        System.out.println("Сумма " + f1 + " + " + f2 + " = " + sum.apply(f1, f2));

        BiFunction<Fraction, Fraction, Fraction> diff = Fraction::subtract;
        System.out.println("Разность " + f1 + " - " + f2 + " = " + diff.apply(f1, f2));

        BiFunction<Fraction, Fraction, Fraction> mul = Fraction::multiply;
        System.out.println("Произведение " + f1 + " * " + f2 + " = " + mul.apply(f1, f2));

        BiFunction<Fraction, Fraction, Fraction> div = Fraction::divide;
        System.out.println("Деление " + f1 + " / " + f2 + " = " + div.apply(f1, f2));
    }
}
