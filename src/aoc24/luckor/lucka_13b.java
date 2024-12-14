package aoc24.luckor;

public class lucka_13b extends lucka_13 {

    public String svar() {
        prepMaskiner(10000000000000L);
        return String.valueOf(runCheck());
    }
}
