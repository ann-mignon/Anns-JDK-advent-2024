package aoc24.luckor;

import aoc24.Losning;
import aoc24.misc.CharGrid;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class lucka_9 extends Losning {

    int[]  inData;
    int[]   block;
    int[]   filer;
    int[]   minne;

    private void layout() {
        int p = 0, gp = 0, bi = 0, counter;
        int[] coll;
        boolean semafor = true;

        while (true) {
            coll = semafor ? filer: block;
            if (gp == coll.length) break;
            counter = coll[gp];
            while (counter-- > 0) {
                minne[p++] = semafor ? gp : -1;
            }
            semafor = !semafor;
            if (++bi == 2) {
                ++gp;
                bi = 0;
            }
        }
    }

    protected void defragmentera() {
        int lptr = 0,
            rptr = minne.length - 1;

        while (lptr++ < rptr) {
            if (minne[lptr] == -1) {
                while (minne[rptr] == -1) --rptr;
                minne[lptr] = minne[rptr];
                minne[rptr--] = -1;
            }
        }
        while(minne[lptr - 1] == -1) --lptr;
    }

    private void processera() {
        boolean filSist = inData.length % 2 == 1;
        int flen = inData.length / 2 + (filSist ? 1 : 0);
        int glen = inData.length / 2;

        block = IntStream.range(0, glen).map(i -> inData[i * 2 + 1]).toArray();
        filer = IntStream.range(0, flen).map(i -> inData[i * 2]).toArray();
        minne = new int[Arrays.stream(filer).sum() + Arrays.stream(block).sum()];

        layout();
    }

    public void setInput(String input) {
        super.setInput(input);
        char[] cline = new CharGrid(this.input).getGridLine(0);
        inData = IntStream.range(0, cline.length).map(i -> (int) cline[i] - 48).toArray();
    }

    public String svar() {
        processera();
        defragmentera();
        return String.valueOf(LongStream.range(0, minne.length)
                .filter(n -> minne[(int) n] > 0)
                .map(n -> n * minne[(int) n]).sum());
    }
}
