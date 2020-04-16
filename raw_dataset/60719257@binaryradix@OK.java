public static StringBuilder binaryradix(long number) {
    StringBuilder builder = new StringBuilder();
    long remainder;
    while (number != 0) {
        remainder = number % 2;
        number >>= 1;
        builder.append(remainder);
    }
    builder.reverse();
    return builder;
}