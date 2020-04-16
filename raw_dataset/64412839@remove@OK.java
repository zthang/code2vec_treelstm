public double remove(int index) {
    rangeCheck(index);
    double prev = arr[index];
    shift(index + 1, -1);
    return prev;
}