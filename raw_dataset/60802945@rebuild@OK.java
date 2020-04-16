private void rebuild(int capacity) {
    initStep(capacity);
    int[] oldValues = values;
    byte[] oldPresent = present;
    values = new int[capacity];
    present = new byte[capacity];
    size = 0;
    realSize = 0;
    for (int i = 0; i < oldValues.length; i++) {
        if ((oldPresent[i] & PRESENT_MASK) == PRESENT_MASK) {
            add(oldValues[i]);
        }
    }
}