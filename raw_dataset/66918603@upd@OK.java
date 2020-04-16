static long upd(int isMax, long a, long b) {
    return isMax == 1 ? max(a, b) : min(a, b);
}