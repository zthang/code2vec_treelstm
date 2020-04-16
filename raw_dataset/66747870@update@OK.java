public void update(int i, Key key) {
    if (i < 0 || i >= maxN)
        throw new IllegalArgumentException();
    if (!contains(i)) {
        this.add(i, key);
    } else {
        keys[i] = key;
        up(qp[i]);
        down(qp[i]);
    }
}