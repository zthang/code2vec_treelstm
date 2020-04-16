@Override
public int compareTo(Action o) {
    return Long.compare(this.cost, o.cost);
}