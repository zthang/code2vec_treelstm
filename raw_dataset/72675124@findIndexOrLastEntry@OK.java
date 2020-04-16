private int findIndexOrLastEntry(int s, long x) {
    int iter = slot[s];
    while (keys[iter] != x) {
        if (next[iter] != 0) {
            iter = next[iter];
        } else {
            return iter;
        }
    }
    return iter;
}