public void addAll(int index, double[] val) {
    rangeCheckAdd(index);
    shift(index, val.length);
    for (int i = 0; i < val.length; i++) {
        arr[index + i] = val[i];
    }
}