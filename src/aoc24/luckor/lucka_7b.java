package aoc24.luckor;

import java.util.function.LongBinaryOperator;

public class lucka_7b extends lucka_7 {
    enum nyOps implements aoc24.luckor.misc.EqCheck.eqOp {
        PROD,
        SUM,
        CONC;

        static long foga(long a, long b) {
            return Long.parseLong("%d%d".formatted(a, b));
        }

        public LongBinaryOperator getOperator() {
            return switch (this) {
                case PROD -> Math::multiplyExact;
                case SUM -> Long::sum;
                case CONC -> nyOps::foga;
            };
        }
    }

    @Override
    public String svar() {
        return String.valueOf(check(new nyOps[]{ nyOps.PROD, nyOps.SUM, nyOps.CONC }));
    }
}
