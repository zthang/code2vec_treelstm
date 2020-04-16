String next() {
    if (hasNext())
        return tok.nextToken();
    return null;
}