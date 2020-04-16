static void add(int index, int val) {
    while (index < BIT.length) {
        BIT[index] = BIT[index] + val;
        index = index + (index & (-index));
    }
}