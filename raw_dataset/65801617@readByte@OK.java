public int readByte() {
    if (ptrbuf >= lenbuf) {
        return -1;
    }
    return inbuf[ptrbuf++];
}