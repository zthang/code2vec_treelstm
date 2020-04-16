public long nextLong() throws IOException {
    if (!readPRT()) {
        throw new IOException();
    } else {
        long v = 0;
        int i = 0;
        boolean neg;
        if (cBuff[i] == D) {
            neg = true;
            i++;
        } else {
            neg = false;
        }
        while (i < itr) {
            v = (v << 3L) + (v << 1L) + cBuff[i++] - '0';
        }
        return neg ? -v : v;
    }
}