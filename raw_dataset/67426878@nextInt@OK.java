public int nextInt() throws IOException {
    if (!readPRT()) {
        throw new IOException();
    } else {
        int v = 0, i = 0;
        boolean neg;
        if (cBuff[i] == D) {
            neg = true;
            i++;
        } else {
            neg = false;
        }
        while (i < itr) {
            v = (v << 3) + (v << 1) + cBuff[i++] - '0';
        }
        return neg ? -v : v;
    }
}