package aoc24;

import static aoc24.Util.splitta;

public abstract class Losning {
    protected String input = "";
    protected String[] inputLines;
    protected int len;

    public void setInput(String input) {
        this.input = input;
        this.inputLines = splitta(this.input, "\n");
        this.len = inputLines.length;
    }

    public abstract String svar();
}
