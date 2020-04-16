void toNextChar() {
    if (++curr == end)
        reloadBuffer();
}