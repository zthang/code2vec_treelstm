@Override
public int compareTo(Mark o) {
    // let end comes before start
    if (this.x == o.x)
        return type - o.type;
    return Long.compare(x, o.x);
}