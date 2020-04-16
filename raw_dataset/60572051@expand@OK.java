void expand(int newCapacity) {
    long[] data = this.data;
    int oldCapacity = data.length;
    if (oldCapacity >> 2 < newCapacity) {
        this.data = resize(data, Integer.highestOneBit(newCapacity - 1) << 3);
    }
}