static void debug(Object... args) {
    StringJoiner j = new StringJoiner(" ");
    for (Object arg : args) {
        if (arg instanceof int[])
            j.add(Arrays.toString((int[]) arg));
        else if (arg instanceof long[])
            j.add(Arrays.toString((long[]) arg));
        else if (arg instanceof double[])
            j.add(Arrays.toString((double[]) arg));
        else if (arg instanceof Object[])
            j.add(Arrays.toString((Object[]) arg));
        else
            j.add(arg.toString());
    }
    System.err.println(j.toString());
}