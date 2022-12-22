package com.oop.collections.polynomials;

import java.util.Objects;

public abstract class AbstractPoly implements Poly {

    public AbstractPoly() {
    }

    double[] derive() {
        if (degree() == 0) {
            return new double[]{0};
        }
        double[] diff = new double[degree()];
        for (int i = 0; i < degree(); i++) {
            diff[i] = coefficient(i + 1) * (i + 1);
        }
        return diff;
    }

    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (!(o instanceof AbstractPoly abstractPoly)) {
            return false;
        }
        if (abstractPoly.degree() != degree()) {
            return false;
        }
        for (int i = 0; i <= degree(); i++) {
            if (coefficient(i) != abstractPoly.coefficient(i)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        return Objects.hashCode(coefficients());
    }

    public String toString() {
        String s = "Poly[";
        for (int i = 0; i < degree(); i++) {
            if (coefficient(i) != 0) {
                if (i == 0) {
                    s += coefficient(i);
                } else {
                    if (s.charAt(s.length() - 1) != '[') {
                        if (coefficient(i) > 0) {
                            s += " + ";
                        } else {
                            s += " - ";
                        }
                    }
                    s += Math.abs(coefficient(i));
                    if (i == 1) {
                        s += "x";
                    } else {
                        s += "x^" + i;
                    }
                }
            }
        }
        s += "]";
        return s;
    }
}
