public int readLine(char[] data, int offset) {
    int originalOffset = offset;
    while (next != -1 && next != '\n') {
        data[offset++] = (char) next;
        next = read();
    }
    return offset - originalOffset;
}