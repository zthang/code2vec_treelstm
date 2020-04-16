private int skip() {
    int b;
    while ((b = readByte()) != -1 && isTrash(b)) ;
    return b;
}