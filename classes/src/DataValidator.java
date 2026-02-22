import java.util.Optional;

class DataValidator {
    public Optional<String> getValidationError(String[] parts) {
        if (parts.length < 3) return Optional.of("Invalid line format");
        if (parts[0].isBlank()) return Optional.of("Missing ID");
        try {
            Double.parseDouble(parts[2]);
        } catch (Exception e) { return Optional.of("Invalid numeric value"); }
        return Optional.empty();
    }
}