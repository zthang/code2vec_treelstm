static int getsum(int[] bit, int ind) {
    int sum = 0;
    while (ind > 0) {
        sum += bit[ind];
        ind -= ind & (-ind);
    }
    return sum;
}