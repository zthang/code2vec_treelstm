public boolean equals(Object o) {
    if (o instanceof pair) {
        pair p = (pair) o;
        return p.x.equals(x) && p.y.equals(y);
    }
    return false;
}