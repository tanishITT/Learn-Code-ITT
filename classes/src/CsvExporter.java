import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

class CsvExporter implements DataExporter {
    public boolean supports(String format) { return "csv".equalsIgnoreCase(format); }
    public void export(List<DataRecord> records, String path) throws Exception {
        List<String> lines = new ArrayList<>();
        lines.add("ID,NAME,VALUE,DATE,DOUBLED,SQUARED");
        records.forEach(r -> lines.add(String.format("%s,%s,%.2f,%s,%.2f,%.2f",
                r.id(), r.name(), r.value(), r.date(), r.doubledValue(), r.squaredValue())));
        Files.write(Paths.get(path), lines);
    }
}