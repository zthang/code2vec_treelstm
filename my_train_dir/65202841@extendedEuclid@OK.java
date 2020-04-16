public Name extendedEuclid(long a, long b) {
    if (b == 0)
        return new Name(a, 1, 0);
    Name n1 = extendedEuclid(b, a % b);
    Name n2 = new Name(n1.d, n1.y, n1.x - (long) Math.floor((double) a / b) * n1.y);
    return n2;
}