public void put(long x, V y) {
    int h = hash(x);
    int s = h & mask;
    if (slot[s] == 0) {
        alloc();
        slot[s] = alloc;
        keys[alloc] = x;
        values[alloc] = y;
    } else {
        int index = findIndexOrLastEntry(s, x);
        if (keys[index] != x) {
            alloc();
            next[index] = alloc;
            keys[alloc] = x;
            values[alloc] = y;
        } else {
            values[index] = y;
        }
    }
    if (rehash && size >= slot.length) {
        rehash();
    }
}