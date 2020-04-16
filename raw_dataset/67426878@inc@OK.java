private void inc() {
    cBuff = java.util.Arrays.copyOf(cBuff, cBuff.length << 1);
}