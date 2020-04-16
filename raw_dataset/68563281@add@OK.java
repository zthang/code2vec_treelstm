public void add(long X, int from, int to) {
    assert (from >= this.from && to <= this.to && from < to);
    if (from == this.from && to == this.to)
        this.X += X;
    else {
        if (from < m)
            L.add(X, from, min(to, m));
        if (to > m)
            R.add(X, max(from, m), to);
    }
}