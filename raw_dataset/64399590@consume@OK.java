private void consume() {
    remain = remain - 1;
    int i;
    for (i = 0; bits[i] == 1; i++) {
        bits[i] = 0;
        next -= meanings[i];
    }
    bits[i] = 1;
    next += meanings[i];
}