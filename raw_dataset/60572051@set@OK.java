void set(long key, long value) {
    if (key == EMPTY) {
        throw new IllegalArgumentException();
    }
    long[] data = this.data;
    for (int capacity = data.length, mask = capacity - 2, i = hash(key) & mask; ; i = (i - 1) & mask) {
        long cur = data[i];
        if (cur == key) {
            data[i + 1] = value;
            return;
        } else if (cur == EMPTY) {
            data[i] = key;
            data[i + 1] = value;
            if (++size > capacity >> 2) {
                this.data = resize(data, capacity << 1);
            }
            return;
        }
    }
}