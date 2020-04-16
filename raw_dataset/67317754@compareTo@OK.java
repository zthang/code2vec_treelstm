@Override
public int compareTo(point o) {
    if (o.x == this.x)
        return Integer.compare(o.y, this.y);
    return Integer.compare(o.x, this.x);
}