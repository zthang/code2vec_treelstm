static boolean un(int a, int b) {
    int ra = gr(a);
    int rb = gr(b);
    if (ra == rb)
        return false;
    if (weight[rb] > weight[ra]) {
        weight[rb] += weight[ra];
        baap[ra] = rb;
        max_in_cc[rb] = max(max_in_cc[rb], max_in_cc[ra]);
    } else {
        weight[ra] += weight[rb];
        baap[rb] = ra;
        max_in_cc[ra] = max(max_in_cc[rb], max_in_cc[ra]);
    }
    return true;
}