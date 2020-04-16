public void update(int index, long value) {
    while (index < data.length) {
        data[index] += value;
        index += (index & (-index));
    }
}