public String[] getStringArray(int size) throws Exception {
    String[] ar = new String[size];
    for (int i = 0; i < size; ++i) ar[i] = next();
    return ar;
}