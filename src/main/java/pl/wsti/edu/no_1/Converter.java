package pl.wsti.edu.no_1;

public class Converter extends Dialog {
    public Converter(String title) {
        super(title);
    }

    public enum NUMBER_SYSTEM {
        BINARY(2),
        OCTAL(8),
        HEXADECIMAL(16);

        public final int value;

        NUMBER_SYSTEM(int value) {
            this.value = value;
        }
    }

    public Converter setResult() {
        int number = getInteger();

        setMessage(
            "\nDEC: " + number +
            "\nBIN: 0b" + convert(number, NUMBER_SYSTEM.BINARY) +
            "\nOCT: 0" + convert(number, NUMBER_SYSTEM.OCTAL) +
            "\nHEX: 0x" + convert(number, NUMBER_SYSTEM.HEXADECIMAL)
        );

        return this;
    }

    public static String convert(int number, NUMBER_SYSTEM system) {
        if (number == 0) {
            return "0";
        }

        int index = (int) (Math.log(number) / Math.log(system.value)) + 1;
        char[] chars = new char[index--];

        String table =
            (system == NUMBER_SYSTEM.HEXADECIMAL)
                ? "0123456789ABCDEF"
                : "01234567";

        while (number > 0) {
            chars[index--] = table.charAt(number % system.value);
            number /= system.value;
        }

        return new String(chars);
    }
}
