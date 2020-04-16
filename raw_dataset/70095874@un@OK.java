static boolean un(int a, int b) {
    int ra = gr(a);
    int rb = gr(b);
    if (ra == rb)
        return false;
    ans -= (forced[ra] == -1 ? min(red_count[ra], blue_count[ra]) : forced[ra] == 0 ? red_count[ra] : blue_count[ra]);
    ans -= (forced[rb] == -1 ? min(red_count[rb], blue_count[rb]) : forced[rb] == 0 ? red_count[rb] : blue_count[rb]);
    if (weight[rb] > weight[ra]) {
        weight[rb] += weight[ra];
        baap[ra] = rb;
        blue_count[rb] += blue_count[ra];
        red_count[rb] += red_count[ra];
        if (forced[rb] == -1) {
            forced[rb] = forced[ra];
        }
        ans += (forced[rb] == -1 ? min(red_count[rb], blue_count[rb]) : forced[rb] == 0 ? red_count[rb] : blue_count[rb]);
    } else {
        weight[ra] += weight[rb];
        baap[rb] = ra;
        blue_count[ra] += blue_count[rb];
        red_count[ra] += red_count[rb];
        if (forced[ra] == -1) {
            forced[ra] = forced[rb];
        }
        ans += (forced[ra] == -1 ? min(red_count[ra], blue_count[ra]) : forced[ra] == 0 ? red_count[ra] : blue_count[ra]);
    }
    return true;
}