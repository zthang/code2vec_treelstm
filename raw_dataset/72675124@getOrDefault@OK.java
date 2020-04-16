public V getOrDefault(long x, V def) {
    int h = hash(x);
    int s = h & mask;
    if (slot[s] == 0) {
        return def;
    }
    int index = findIndexOrLastEntry(s, x);
    return keys[index] == x ? (V) values[index] : def;
}