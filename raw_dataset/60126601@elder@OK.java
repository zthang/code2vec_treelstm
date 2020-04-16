public static LCTNode elder(LCTNode a, LCTNode b) {
    return a.dieTime < b.dieTime ? a : b;
}