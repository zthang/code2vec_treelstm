public DoubleTriplet Line(double x1, double y1, double x2, double y2) {
    double a = y1 - y2;
    double b = x2 - x1;
    double c = x1 * y2 - x2 * y1;
    return new DoubleTriplet(a, b, c);
}