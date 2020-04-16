void merge(Arr a) {
    for (int i = sz; i < a.sz + sz; i++) {
        arr[i] = a.arr[i - sz];
    }
    sz += a.sz;
}