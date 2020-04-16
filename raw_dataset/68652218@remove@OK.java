void remove(int v) {
    int ct = mp.getOrDefault(v, 0);
    if (ct == 0)
        return;
    sz1--;
    if (ct == 1) {
        mp.remove(v);
    } else {
        mp.put(v, ct - 1);
    }
}