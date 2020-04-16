public int removeFirst() {
    int ans = data[bpos];
    bpos = next(bpos);
    return ans;
}