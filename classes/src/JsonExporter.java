import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

class JsonExporter implements DataExporter {
    public boolean supports(String format) { return "json".equalsIgnoreCase(format); }
    public void export(List<DataRecord> records, String path) throws Exception {
        StringBuilder sb = new StringBuilder("[\n");
        for (int i = 0; i < records.size(); i++) {
            DataRecord r = records.get(i);
            sb.append(String.format("  {\"id\":\"%s\", \"val\":%.2f}", r.id(), r.value()));
            if (i < records.size() - 1) sb.append(",");
            sb.append("\n");
        }
        sb.append("]");
        Files.writeString(Paths.get(path), sb.toString());
    }
}