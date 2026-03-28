import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DataTransformer {
    public DataRecord transform(String[] parts, String dateFormat) {
        double val = Double.parseDouble(parts[2]);
        String originalDate = parts.length > 3 ? parts[3] : "";

        // Date Formatting Logic
        String formattedDate = originalDate;
        try {
            LocalDate date = LocalDate.parse(originalDate);
            formattedDate = date.format(DateTimeFormatter.ofPattern(dateFormat));
        } catch (Exception ignored) {}

        return new DataRecord(
                parts[0].trim(),
                parts[1].trim().toUpperCase(),
                val,
                formattedDate,
                val * 2,
                val * val
        );
    }
}