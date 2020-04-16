public static Double[] solveQuadratic(double a, double b, double c) {
    double result = (b * b) - 4.0 * a * c;
    double r1;
    if (result > 0.0) {
        r1 = ((double) (-b) + Math.pow(result, 0.5)) / (2.0 * a);
        double r2 = ((double) (-b) - Math.pow(result, 0.5)) / (2.0 * a);
        return new Double[] { r1, r2 };
    } else if (result == 0.0) {
        r1 = (double) (-b) / (2.0 * a);
        return new Double[] { r1, r1 };
    } else {
        return new Double[] { null, null };
    }
}