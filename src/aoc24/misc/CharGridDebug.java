package aoc24.misc;

import java.awt.color.ICC_ColorSpace;
import java.util.Arrays;

import static aoc24.Util.putln;

public class CharGridDebug extends CharGrid {

    public CharGridDebug(String txt) {
        super(txt);
    }

    public void draw() {
        putln(toString());
    }

    public void draw3(int[] dr) {
        putln(new String(Arrays.toString(dr)));
    }
}
