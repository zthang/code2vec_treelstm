static int query(int index) {
    int sum = 0;
    for (int i = index; i > 0; i -= i & -i) sum += BIT[i];
    return sum;
}