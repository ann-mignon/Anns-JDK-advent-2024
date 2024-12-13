package aoc24.luckor;

import aoc24.Losning;
import aoc24.misc.CharGrid;
import aoc24.misc.Point;

import java.util.*;

public class lucka_12 extends Losning {

    CharGrid cg;
    private final int[][] gendir = new int[][]{{0, -1}, {1, 0}, {0, 1}, {-1, 0}};
    Deque<Integer> stack = new ArrayDeque<>();
    Set<Integer> area = new HashSet<>();

    record Region(int[] area, int perim) {}

    List<Region> regioner = new ArrayList<>();

    protected int addAtIx(int p) {
        int count = 0, upos = p - wlen, npos = p + wlen, hpos = p + 1, vpos = p - 1;
        char c = cg.getCharAt(p);
        if (upos < 0 || cg.getCharAt(upos) != c)                ++count;
        if (p % wlen == 0 || cg.getCharAt(vpos) != c)           ++count;
        if (p % wlen == wlen - 1 || cg.getCharAt(hpos) != c)    ++count;
        if (npos >= inputSize || cg.getCharAt(npos) != c)       ++count;

        return count;
    }

    protected boolean checkE(Point p, Point m) {
        if (!cg.inGrid(p)) return false;
        return !area.contains(cg.getIx(p)) && cg.getCharAt(p) == cg.getCharAt(m);
    }

    boolean isContained(int p) {
        return regioner.stream()
                .anyMatch(r -> Arrays.stream(r.area).anyMatch(a -> p == a));
    }

    public void setInput(String input) {
        super.setInput(input);
        cg = new CharGrid(input);
    }

    public String svar() {
        int px = 0;

        while (px < inputSize) {
            if(!isContained(px)) {
                regioner.add(regionAt(px));
            }
            ++px;
        }
        return String.valueOf(regioner.stream().mapToInt(r -> r.area.length * r.perim).sum());
    }

    Region regionAt(int p) {
        // todo: bryt ut dfs? (upprepning lucka 10)
        int cur, k, perim = 0;
        Point mpoint = new Point(-1, -1), npoint = new Point(-1, -1);

        stack.clear();
        area.clear();

        stack.push(p);

        while (!stack.isEmpty()) {
            cur = stack.pop();
            area.add(cur);

            mpoint.x = cur % wlen; mpoint.y = cur / wlen;

            k = 0;
            while (k < 4) {
                npoint.x = mpoint.x + gendir[k][0];
                npoint.y = mpoint.y + gendir[k][1];

                if (checkE(npoint, mpoint)) {
                    stack.push(cg.getIx(npoint));
                }
                ++k;
            }
        }

        for (int j : area) {
            perim += addAtIx(j);
        }

        return new Region(area.stream().mapToInt(Integer::intValue).toArray(), perim);
    }
}
