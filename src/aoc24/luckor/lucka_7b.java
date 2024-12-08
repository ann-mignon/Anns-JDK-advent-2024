package aoc24.luckor;

import static aoc24.Util.*;
import aoc24.misc.EqCheck.eqOp;

import java.util.function.LongBinaryOperator;

public class lucka_7b extends lucka_7 {
    enum nyOps implements eqOp {
        PROD,
        SUM,
        CONC;

        static long foga(long a, long b) {
             return a * pow10(decimals(b)) + b;
        }

        public LongBinaryOperator getOperator() {
            return switch (this) {
                case PROD -> Math::multiplyExact;
                case SUM -> Long::sum;
                case CONC -> nyOps::foga;
            };
        }
    }

    public String svar() {
        return String.valueOf(check(new nyOps[]{ nyOps.PROD, nyOps.SUM, nyOps.CONC }));
    }
}
