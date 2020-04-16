public int compare(Pair a, Pair b) {
    // return (a.y)-(b.y);
    if (a.y == b.y) {
        return -1 * (a.z - b.z);
    }
    return (a.y - b.y);
}