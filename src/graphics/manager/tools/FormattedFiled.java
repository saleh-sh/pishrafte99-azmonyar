package manager.tools;

import java.util.function.UnaryOperator;
import java.util.regex.Pattern;
import javafx.scene.control.TextFormatter;
import javafx.util.StringConverter;

public class FormattedFiled {

    public TextFormatter getDoubleFormatter() {
        return textFormatter;
    }

    

    Pattern validEditingState = Pattern.compile("-?(([1-9][0-9]*)|0)?(\\.[0-9]*)?");

    StringConverter<Double> converter = new StringConverter<Double>() {
        @Override
        public Double fromString(String s) {
            if (s.isEmpty() || "-".equals(s) || ".".equals(s) || "-.".equals(s)) {
                return 0.0;
            } else {
                return Double.valueOf(s);
            }
        }

        @Override
        public String toString(Double d) {
            return d.toString();
        }
    };
    UnaryOperator<TextFormatter.Change> filter = c -> {
        String text = c.getControlNewText();
        if (validEditingState.matcher(text).matches()) {
            return c;
        } else {
            return null;
        }
    };
    TextFormatter<Double> textFormatter = new TextFormatter<>(converter, 0.0, filter);
}
