public boolean hasNext() {
    if (c > 32)
        return true;
    while (true) {
        c = getChar();
        if (c == NC)
            return false;
        else if (c > 32)
            return true;
    }
}