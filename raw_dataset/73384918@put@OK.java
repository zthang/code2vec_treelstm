public void put(int x, int y, boolean cover) {
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
        } else if (cover) {
            values[index] = y;
        }
    }
    if (rehash && size >= slot.length) {
        rehash();
    }
}