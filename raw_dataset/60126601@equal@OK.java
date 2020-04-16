public boolean equal(Query a, Query b) {
    return a.x == b.x && a.y == b.y || a.y == b.x && a.x == b.y;
}