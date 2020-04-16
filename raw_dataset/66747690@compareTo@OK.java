@Override
public int compareTo(interval t) {
    if (this.to == t.to)
        return this.from - t.from;
    return this.to - t.to;
}