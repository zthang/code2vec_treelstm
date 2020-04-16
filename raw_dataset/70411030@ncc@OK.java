private char ncc() {
    int b;
    while ((b = readByte()) != -1 && !(b >= 32 && b <= 126)) ;
    return (char) b;
}