public static <T> int verboseCopy(T[] src, int srcFromIndex, int srcToIndex, T[] dest, int destFromIndex) {
    int length = srcToIndex - srcFromIndex;
    if (length < 0) {
        length += src.length;
        int copied = verboseCopy(src, srcFromIndex, src.length, dest, destFromIndex);
        return copied + verboseCopy(src, 0, srcToIndex, dest, destFromIndex + copied);
    } else {
        System.arraycopy(src, srcFromIndex, dest, destFromIndex, length);
        return length;
    }
}