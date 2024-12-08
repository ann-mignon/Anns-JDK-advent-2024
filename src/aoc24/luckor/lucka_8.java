package aoc24.luckor;

import aoc24.misc.Mastgrupp;

public class lucka_8 extends lucka_8_bas<Mastgrupp> {

    public String svar() {
        mastRef = Mastgrupp.class;
        return String.valueOf(summeraResonans());
    }
}
