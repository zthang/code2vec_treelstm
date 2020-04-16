boolean have(long key) {
    if (key == EMPTY) {
        throw new IllegalArgumentException();
    }
    for (int mask = data.length - 2, i = hash(key) & mask; ; i = (i - 1) & mask) {
        long cur = data[i];
        if (cur == key) {
            return true;
        } else if (cur == EMPTY) {
            return false;
        }
    }
}