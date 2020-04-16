void advance() {
    do {
        position += 2;
    } while (position < data.length && data[position] == EMPTY);
}