public static DynamicMST.LCTNode larger(DynamicMST.LCTNode a, DynamicMST.LCTNode b) {
    return a.weight >= b.weight ? a : b;
}