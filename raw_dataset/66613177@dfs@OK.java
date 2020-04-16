void dfs(int node) {
    dfsStack[node] = 1;
    stack.addLast(node);
    int goTo = ptsTo[node];
    if (goTo == -1) {
        while (!stack.isEmpty()) {
            cycleMask[stack.pollLast()] = -1;
        }
    } else {
        if (dfsStack[goTo] == 1) {
            int ptr = 0, mask = 0, conflict = 0;
            while (!stack.isEmpty()) {
                int now = stack.pollLast(), val = nodeToVal.get(now), box = whichBox.get(val);
                tempList[ptr++] = now;
                if ((mask & (1 << box)) > 0)
                    conflict = 1;
                mask |= 1 << box;
                if (now == goTo)
                    break;
            }
            while (!stack.isEmpty()) {
                cycleMask[stack.pollLast()] = -1;
            }
            for (int i = 0; i < ptr; i++) {
                int now = tempList[i];
                if (conflict > 0)
                    cycleMask[now] = -1;
                else
                    cycleMask[now] = mask;
            }
        } else if (dfsStack[goTo] == 2) {
            while (!stack.isEmpty()) {
                cycleMask[stack.pollLast()] = -1;
            }
        } else {
            dfs(goTo);
        }
    }
    dfsStack[node] = 2;
}