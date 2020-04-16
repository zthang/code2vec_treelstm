@Override
public int compareTo(Edge other) {
    if (this.cost > other.cost) {
        return 1;
    } else if (this.cost < other.cost) {
        return -1;
    }
    return 0;
}