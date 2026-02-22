import java.util.List;

interface DataExporter {
    boolean supports(String format);
    void export(List<DataRecord> records, String path) throws Exception;
}