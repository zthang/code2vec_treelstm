public static String Doubleformate(double a) {
    DecimalFormat f = new DecimalFormat("#.00");
    return f.format(a);
}