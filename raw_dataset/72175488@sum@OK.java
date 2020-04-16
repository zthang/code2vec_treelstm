public Fraction sum(Fraction a, Fraction b) {
    Fraction c = new Fraction(a.x * b.y + a.y * b.x, a.y * b.y);
    c.norm();
    return c;
}