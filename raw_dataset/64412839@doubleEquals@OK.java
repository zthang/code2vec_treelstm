public static boolean doubleEquals(double a, double b) {
    return a == b || (Double.isNaN(a) && Double.isNaN(b));
}