public int readString(byte[] data, int offset) {
    skipBlank();
    int originalOffset = offset;
    while (next > 32) {
        data[offset++] = (byte) next;
        next = read();
    }
    return offset - originalOffset;
}