int encode(String s) {
    int es = 0;
    for (int i = s.length() - 1; i >= 0; es |= 1 << (s.charAt(i) - 'a'), i--) ;
    return es;
}