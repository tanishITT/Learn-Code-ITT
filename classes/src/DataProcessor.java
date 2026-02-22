import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

class DataProcessor {
    private final FileService fileService;
    private final DataValidator validator;
    private final DataTransformer transformer;
    private final Logger logger;
    private final List<DataExporter> exporters;

    public DataProcessor(FileService fs, DataValidator dv, DataTransformer dt, Logger l, List<DataExporter> ex) {
        this.fileService = fs; this.validator = dv; this.transformer = dt;
        this.logger = l; this.exporters = ex;
    }

    public List<DataRecord> process(String inputPath, String dateFormat) throws Exception {
        logger.log("Starting data processing...");
        List<DataRecord> processed = new ArrayList<>();
        List<String> lines = fileService.readAllLines(inputPath);

        for (String line : lines) {
            String[] parts = line.split(",");
            Optional<String> error = validator.getValidationError(parts);

            if (error.isEmpty()) {
                processed.add(transformer.transform(parts, dateFormat));
            } else {
                logger.log("SKIPPED: " + error.get() + " -> " + line);
            }
        }
        logger.log("Processed " + processed.size() + " records.");
        return processed;
    }

    public void export(List<DataRecord> records, String path, String format) throws Exception {
        exporters.stream()
                .filter(e -> e.supports(format))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Format not supported"))
                .export(records, path);
        logger.log("Exported to " + format + " at " + path);
    }
}