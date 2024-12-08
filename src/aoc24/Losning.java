package aoc24;

import static aoc24.Util.splitta;

public abstract class Losning {
    protected String input = "";
    protected String[] inputLines;
    protected String linearInput;
    protected int len;
    public int wlen;

    public void setInput(String input) {
        this.input = input;
        this.inputLines = splitta(this.input, "\n");
        this.linearInput = input.replaceAll("\n", "");
        this.len = inputLines.length;
        this.wlen = inputLines.length > 0 ? inputLines[0].length() : 0;
    }

    public abstract String svar();
}
