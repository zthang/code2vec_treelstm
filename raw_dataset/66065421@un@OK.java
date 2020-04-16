static boolean un(int a, int b) {
    int ra = gr(a);
    int rb = gr(b);
    if (ra == rb)
        return false;
    if (weight[rb] > weight[ra]) {
        weight[rb] += weight[ra];
        baap[ra] = rb;
    } else {
        weight[ra] += weight[rb];
        baap[rb] = ra;
    }
    return true;
}