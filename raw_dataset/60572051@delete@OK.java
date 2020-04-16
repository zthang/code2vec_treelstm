void delete(long key) {
    if (key == EMPTY) {
        throw new IllegalArgumentException();
    }
    long[] data = this.data;
    for (int capacity = data.length, mask = capacity - 2, i = hash(key) & mask; ; i = (i - 1) & mask) {
        long cur = data[i];
        if (cur == key) {
            for (int j = i; ; ) {
                cur = data[j = (j - 1) & mask];
                if (cur == EMPTY) {
                    data[i] = EMPTY;
                    --size;
                    return;
                }
                int k = hash(cur) & mask;
                if ((k >= i) ^ (k < j) ^ (i < j)) {
                    data[i] = cur;
                    data[i + 1] = data[j + 1];
                    i = j;
                }
            }
        } else if (cur == EMPTY) {
            return;
        }
    }
}