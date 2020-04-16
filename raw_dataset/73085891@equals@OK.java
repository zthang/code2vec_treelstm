public boolean equals(Object o) {
    if (o instanceof pair) {
        pair p = (pair) o;
        return p.x == x && p.y == y;
    }
    return false;
}