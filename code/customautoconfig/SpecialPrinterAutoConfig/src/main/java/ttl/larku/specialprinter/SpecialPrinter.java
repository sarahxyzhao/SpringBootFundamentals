package ttl.larku.specialprinter;

public class SpecialPrinter {

    private String prefix = "[";
    private String suffix = "]";

    public SpecialPrinter(String prefix, String suffix) {
        this.prefix = prefix;
        this.suffix = suffix;
    }

    public SpecialPrinter() {}

    public String log(String message) {
        return prefix + message + suffix;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }
}
