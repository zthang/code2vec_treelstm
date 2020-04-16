private char getChar() {
    while (bId == size) {
        try {
            size = in.read(buf);
        } catch (Exception e) {
            return NC;
        }
        if (size == -1)
            return NC;
        bId = 0;
    }
    return (char) buf[bId++];
}