public boolean join(int i, int j) {
    // true if joined
    int fai = father(i);
    int faj = father(j);
    if (fai == faj)
        return false;
    disjoints--;
    if (size[fai] > size[faj]) {
        size[fai] += size[faj];
        father[faj] = fai;
        rightMost[fai] = Math.max(rightMost[fai], rightMost[faj]);
        leftMost[fai] = Math.min(leftMost[fai], leftMost[faj]);
    } else {
        size[faj] += size[fai];
        father[fai] = faj;
        rightMost[faj] = Math.max(rightMost[fai], rightMost[faj]);
        leftMost[faj] = Math.min(leftMost[fai], leftMost[faj]);
    }
    return true;
}