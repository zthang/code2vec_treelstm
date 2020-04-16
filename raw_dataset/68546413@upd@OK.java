public void upd(int le, int ri, int diff) {
    prop();
    if (le >= r || ri <= l)
        return;
    if (le <= l && ri >= r) {
        propD += diff;
        min += diff;
        return;
    }
    left.upd(le, ri, diff);
    right.upd(le, ri, diff);
    min = Math.min(left.min, right.min);
    numMin = 0;
    if (left.min == min)
        numMin += left.numMin;
    if (right.min == min)
        numMin += right.numMin;
}