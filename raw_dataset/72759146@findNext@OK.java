int findNext(int last, int[] cur) {
    for (int i = last; i >= 0; i--) {
        if (cur[i] != 0) {
            return i;
        }
    }
    return -1;
}