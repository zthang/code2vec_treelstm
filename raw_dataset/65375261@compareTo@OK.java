@Override
public int compareTo(Pair p) {
    if (this.w != p.w) {
        return this.w - p.w;
    }
    return this.id - p.id;
}