@Override
public int compareTo(Main.Edge other) {
    return Long.compare(this.cost, other.cost);
}