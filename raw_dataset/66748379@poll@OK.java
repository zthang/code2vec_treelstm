public int poll() {
    if (isEmpty())
        throw new NoSuchElementException("Priority queue underflow");
    int min = pq[1];
    exch(1, n--);
    down(1);
    assert min == pq[n + 1];
    qp[min] = -1;
    keys[min] = null;
    pq[n + 1] = -1;
    return min;
}