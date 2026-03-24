package CountryCodeApp;

public class CountryCodeController {
    public static void main(String[] args) {
        CountryCodeRegistry registry = CountryCodeRegistry.getInstance();
        CountryCodeService service = new CountryCodeService(registry);
        service.startService();
    }
}
