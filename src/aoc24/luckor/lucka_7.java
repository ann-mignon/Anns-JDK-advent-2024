package aoc24.luckor;

import aoc24.Losning;
import aoc24.luckor.misc.EqCheck;
import aoc24.luckor.misc.EqCheck.eqOp;

import java.util.Arrays;
import java.util.function.LongBinaryOperator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static aoc24.Util.splitta;
import static aoc24.Util.toLongArray;

public class lucka_7 extends Losning {
    enum basicOps implements aoc24.luckor.misc.EqCheck.eqOp {
        PROD,
        SUM;
        
        public LongBinaryOperator getOperator() {
            return switch (this) {
                case PROD -> Math::multiplyExact;
                case SUM -> Long::sum;
            };
        }
    }

    protected long check(eqOp[] ops) {
        Matcher m = eqrx.matcher(input);

        return Arrays.stream(
                m.results().map(r ->
                new EqCheck(Long.parseLong(r.group(1)),
                            toLongArray(splitta(r.group(2), " ")),
                            ops)
                    ).toArray(EqCheck[]::new)).filter(EqCheck::check).mapToLong(e -> e.toCheck).sum();
    }

    final Pattern eqrx = Pattern.compile("^(\\d+): ((?:\\d+ )+\\d+)$", Pattern.MULTILINE);

    public String svar() {
        return String.valueOf(check(new basicOps[]{ basicOps.PROD, basicOps.SUM }));
    }
}
