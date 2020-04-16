public int count() {
    int ret = 0;
    for (int i = 0; i < parent.length; i++) {
        if (i == parent[i]) {
            ret++;
        }
    }
    return ret;
}