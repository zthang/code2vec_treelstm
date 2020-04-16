private Object conv(Object obj) {
    if (obj instanceof byte[])
        return Arrays.toString((byte[]) obj);
    else if (obj instanceof char[])
        return Arrays.toString((char[]) obj);
    else if (obj instanceof short[])
        return Arrays.toString((short[]) obj);
    else if (obj instanceof int[])
        return Arrays.toString((int[]) obj);
    else if (obj instanceof long[])
        return Arrays.toString((long[]) obj);
    else if (obj instanceof float[])
        return Arrays.toString((float[]) obj);
    else if (obj instanceof double[])
        return Arrays.toString((double[]) obj);
    else if (obj instanceof boolean[])
        return Arrays.toString((int[]) obj);
    else if (obj instanceof Object[])
        return Arrays.deepToString((Object[]) obj);
    else
        return obj;
}