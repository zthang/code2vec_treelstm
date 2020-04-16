public void norm() {
    long gcd = gcd(x, y);
    x /= gcd;
    y /= gcd;
}