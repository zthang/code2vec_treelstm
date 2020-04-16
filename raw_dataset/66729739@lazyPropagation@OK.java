void lazyPropagation() {
    if (lazy != 0) {
        if (left != null) {
            left.setLazy(this.time, this.lazy);
            right.setLazy(this.time, this.lazy);
        } else {
            val = lazy;
        }
    }
}