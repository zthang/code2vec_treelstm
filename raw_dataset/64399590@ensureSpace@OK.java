private void ensureSpace(int need) {
    int req = size + need;
    if (req > cap) {
        while (cap < req) {
            cap = Math.max(cap + 10, 2 * cap);
        }
        data = Arrays.copyOf(data, cap);
    }
}