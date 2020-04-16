public int compare(Pair a, Pair b) {
    // return (a.y)-(b.y);
    if (a.x == b.x) {
        return (a.y - b.y);
    }
    return (a.x - b.x);
}