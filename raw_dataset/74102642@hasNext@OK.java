public boolean hasNext() throws IOException {
    byte c;
    while ((c = read()) != -1) {
        if (c > ' ') {
            bufferPointer--;
            return true;
        }
    }
    return false;
}