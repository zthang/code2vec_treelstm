void push_down() {
    if (this.lazy != 0) {
        lt.sum += lazy;
        rt.sum += lazy;
        lt.max += lazy;
        lt.min += lazy;
        rt.max += lazy;
        rt.min += lazy;
        lt.lazy += this.lazy;
        rt.lazy += this.lazy;
        this.lazy = 0;
    }
}