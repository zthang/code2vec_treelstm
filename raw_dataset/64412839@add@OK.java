public void add(int index, double val) {
    rangeCheckAdd(index);
    shift(index, 1);
    arr[index] = val;
}