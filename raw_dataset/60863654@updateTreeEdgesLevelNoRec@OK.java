private void updateTreeEdgesLevelNoRec(Node cur, int k) {
    if (cur == null || cur.desptn << ~k >= 0)
        return;
    while (cur != null) {
        gctUTEL++;
        cur.desptn &= ~(1 << k);
        cur.desptn |= 1 << k + 1;
        if (cur.info.level == k && cur.from < cur.to) {
            NodeInfo info = cur.info;
            info.level++;
            cur.up = link(cur.from, cur.to, k + 1, info);
            cur.reverse.up = cur.up.reverse;
        }
        if (cur.left != null && cur.left.desptn << ~k < 0) {
            cur = cur.left;
        } else {
            Node pre = null;
            while (cur != null) {
                if (cur.right != null && cur.right != pre && cur.right.desptn << ~k < 0) {
                    cur = cur.right;
                    break;
                }
                pre = cur;
                cur = cur.parent;
            }
        }
    }
}