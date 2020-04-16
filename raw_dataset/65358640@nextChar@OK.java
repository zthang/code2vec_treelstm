char nextChar() throws IOException {
    int c;
    for (c = scan(); c <= 32; c = scan()) ;
    return (char) c;
}