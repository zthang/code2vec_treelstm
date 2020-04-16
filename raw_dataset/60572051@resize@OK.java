static long[] resize(long[] data, int newCapacity) {
    int oldCapacity = data.length;
    long[] ndata = new long[newCapacity];
    for (int i = 0; i < newCapacity; i += 2) {
        ndata[i] = EMPTY;
    }
    for (int mask = newCapacity - 2, i = 0; i < oldCapacity; i += 2) {
        long cur = data[i];
        if (cur == EMPTY) {
            continue;
        }
        for (int j = hash(cur) & mask; ; j = (j - 1) & mask) {
            if (ndata[j] == EMPTY) {
                ndata[j] = cur;
                ndata[j + 1] = data[i + 1];
                break;
            }
        }
    }
    return ndata;
}