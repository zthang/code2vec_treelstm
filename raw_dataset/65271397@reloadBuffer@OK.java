void reloadBuffer() {
    try {
        while (curr == end) {
            curr = 0;
            end = in.read(buffer);
            if (end == -1) {
                eof = true;
            }
        }
    } catch (IOException e) {
    }
}