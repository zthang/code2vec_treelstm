public int peekIdx() {
    if (n == 0)
        throw new NoSuchElementException("Priority queue underflow");
    return pq[1];
}