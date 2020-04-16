void shrink() {
    long[] data = this.data;
    int oldCapacity = data.length;
    if (oldCapacity > 4 && oldCapacity >> 3 >= size) {
        this.data = resize(data, max(Integer.highestOneBit(size - 1) << 3, 4));
    }
}