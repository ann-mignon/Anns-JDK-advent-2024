package aoc24.luckor;

import aoc24.misc.MastgruppDelton;

public class lucka_8b extends lucka_8_bas<MastgruppDelton> {

    public String svar() {
        mastRef = MastgruppDelton.class;
        return String.valueOf(summeraResonans());
    }
}
