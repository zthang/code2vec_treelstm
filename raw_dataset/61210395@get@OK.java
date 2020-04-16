public long get(int index) {
    long result = 0;
    while (index > 0) {
        result += data[index];
        index -= (index & (-index));
    }
    return result;
}