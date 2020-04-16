private void shift(int startIndex, int shift) {
    ensureCapacity(length + shift);
    if (shift > 0) {
        for (int i = length - 1; i >= startIndex; i--) {
            arr[i + shift] = arr[i];
        }
    } else if (shift < 0) {
        for (int i = startIndex; i < length; i++) {
            arr[i + shift] = arr[i];
        }
    }
    length += shift;
}