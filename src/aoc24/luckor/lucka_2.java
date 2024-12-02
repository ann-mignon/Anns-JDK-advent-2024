package aoc24.luckor;

import aoc24.Losning;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static aoc24.Util.splitta;
import static aoc24.Util.toIntegerList;

public class lucka_2 extends Losning {
    static final int TROSKEL = 3;
    protected List<Integer>[] rapporter;

    protected static Boolean checker(List<Integer> rapp) {
        int adiff, i = 1, rlen = rapp.size(), cdiff = rapp.get(1) - rapp.get(0);
        if (cdiff == 0 || Math.abs(cdiff) > TROSKEL) return null;
        boolean asc = cdiff < 0;

        while (++i < rlen) {
            adiff = rapp.get(i) - rapp.get(i - 1);
            if (adiff < 0 != asc || adiff == 0 || Math.abs(adiff) > TROSKEL)
                return null;
        }

        return true;
    }

    protected void sammanstall() {
        rapporter = Arrays.stream(inputLines)
                .map(l -> toIntegerList(splitta(l, " ")))
                .toArray(List[]::new);
    }

    public String svar() {
        sammanstall();

        Boolean[] rinc = Arrays.stream(rapporter)
                            .map(lucka_2::checker)
                            .toArray(Boolean[]::new);

        return String.valueOf(Arrays.stream(rinc).filter(Objects::nonNull).count());
    }
}
