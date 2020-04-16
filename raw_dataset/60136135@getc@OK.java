byte getc() {
    if (k >= l) {
        k = 0;
        try {
            l = in.read(bb);
        } catch (IOException e) {
            l = 0;
        }
        if (l <= 0)
            return -1;
    }
    return bb[k++];
}