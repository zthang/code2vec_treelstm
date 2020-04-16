private void add(int i, Key x) {
    if (i < 0 || i >= maxN)
        throw new IllegalArgumentException();
    if (contains(i))
        throw new IllegalArgumentException("index is already in the priority queue");
    n++;
    qp[i] = n;
    pq[n] = i;
    keys[i] = x;
    up(n);
}