@Override
public int compareTo(Pair o) {
    if (x > o.x) {
        return 1;
    }
    if (x < o.x) {
        return -1;
    }
    return -(y - o.y);
}