// void lazyPropagation() {
// if(lazy != 0) {
// if(left != null) {
// left.setLazy(this.time, this.lazy);
// right.setLazy(this.time, this.lazy);
// }
// else {
// val = lazy;
// }
// }
// }
// void setLazy(int time, int lazy) {
// if(this.time != 0 && this.time <= time)
// return;
// this.time = time;
// this.lazy = lazy;
// }
int querySize(int ll, int rr, int l, int r) {
    // lazyPropagation();
    if (noIntersection(ll, rr, l, r))
        return 0;
    if (covered(ll, rr, l, r))
        return size;
    int mid = (l + r) / 2;
    int leftSize = left.querySize(ll, rr, l, mid);
    int rightSize = right.querySize(ll, rr, mid + 1, r);
    return leftSize + rightSize;
}