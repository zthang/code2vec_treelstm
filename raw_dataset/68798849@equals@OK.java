public boolean equals(Object o) {
    if (o instanceof pair) {
        pair p = (pair) o;
        return p.x - x == 0 && p.y - y == 0;
    }
    return false;
}