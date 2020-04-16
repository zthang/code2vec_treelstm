void merge(Arr a) {
    if (a.sz > sz) {
        for (int i = a.sz; i < a.sz + sz; i++) {
            a.arr[i] = arr[i - a.sz];
        }
        this.arr = a.arr;
    } else {
        for (int i = sz; i < a.sz + sz; i++) {
            arr[i] = a.arr[i - sz];
        }
    }
    sz += a.sz;
}