package aoc24.luckor;

import aoc24.Losning;
import aoc24.misc.CharGrid;

public class lucka_8 extends Losning {

    record Mastgrupp( char id, int[] mast, int[] par ){
        public int[] fmut() {
            int[] fmut = new int[]{};

            return fmut;
        }
    }

    protected static final char nojs = '.';

    protected int[] fmGrid;

    public String svar() {
        CharGrid gridObj    = new CharGrid(input);
        int[] mIdn          = new int[]{};

        fmGrid = new int[len * wlen];


        return "";
    }
}
