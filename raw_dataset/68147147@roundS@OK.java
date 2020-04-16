public static String roundS(double result, int scale) {
    String fmt = String.format("%%.%df", scale);
    return String.format(fmt, result);
}