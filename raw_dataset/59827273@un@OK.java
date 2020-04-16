static boolean un(int a, int b) {
    int ra = gr(a);
    int rb = gr(b);
    if (ra == rb)
        return false;
    curr -= (1L * weight[ra] * (weight[ra] - 1)) / 2;
    curr -= (1L * weight[rb] * (weight[rb] - 1)) / 2;
    if (weight[rb] > weight[ra]) {
        weight[rb] += weight[ra];
        baap[ra] = rb;
        curr += (1L * weight[rb] * (weight[rb] - 1)) / 2;
    } else {
        weight[ra] += weight[rb];
        baap[rb] = ra;
        curr += (1L * weight[ra] * (weight[ra] - 1)) / 2;
    }
    return true;
}