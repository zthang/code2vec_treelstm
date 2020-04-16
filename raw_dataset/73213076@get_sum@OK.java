static int get_sum(int index) {
    int sum = 0;
    while (index > 0) {
        sum = sum + BIT[index];
        index = index - (index & (-index));
    }
    return sum;
}