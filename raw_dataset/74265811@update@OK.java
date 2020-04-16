static void update(int[] bit, int max, int ind, int val) {
    while (ind <= max) {
        bit[ind] += val;
        ind += ind & (-ind);
    }
}