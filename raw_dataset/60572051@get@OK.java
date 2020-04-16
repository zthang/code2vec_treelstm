long get(long key, long default_) {
    if (key == EMPTY) {
        throw new IllegalArgumentException();
    }
    for (int mask = data.length - 2, i = hash(key) & mask; ; i = (i - 1) & mask) {
        long cur = data[i];
        if (cur == key) {
            return data[i + 1];
        } else if (cur == EMPTY) {
            return default_;
        }
    }
}