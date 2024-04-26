package ec.edu.ups.ins.util;

public enum ReportType {
    PDF("pdf"),
    XLS("xls"),
    XLSX("xlsx"),
    CSV("csv");

    private final String value;

    private ReportType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
