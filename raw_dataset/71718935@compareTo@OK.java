@Override
public int compareTo(Pair o) {
    if (x > o.x) {
        return 1;
    }
    if (x < o.x) {
        return -1;
    }
    if (y > o.y) {
        return 1;
    }
    if (y < o.y) {
        return -1;
    }
    return 0;
}