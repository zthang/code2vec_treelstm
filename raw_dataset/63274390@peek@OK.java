public Key peek() {
    if (isEmpty())
        throw new NoSuchElementException("Priority queue underflow");
    return keys[pq[1]];
}