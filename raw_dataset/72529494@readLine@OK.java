public String readLine(boolean ignoreEmptyLines) {
    if (ignoreEmptyLines) {
        return readLine();
    } else {
        return readLine0();
    }
}