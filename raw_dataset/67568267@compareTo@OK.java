public int compareTo(Pair p) {
    return p.t - t == 0 ? p.c - c : p.t - t;
}