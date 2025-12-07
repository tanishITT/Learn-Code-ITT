package CountryCodeApp;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class CountryCodeRegistry {

    private static CountryCodeRegistry countryCodeRegistry;
    private static Map<String, CountryData> countryCodeMap;

    private CountryCodeRegistry(){
        addMockCountryCodes();
    }

    private void addMockCountryCodes(){
        countryCodeMap = new HashMap<>();
        countryCodeMap.put("CA", new CountryData("Canada", List.of("United States")));
        countryCodeMap.put("MX", new CountryData("Mexico", List.of("United States", "Guatemala", "Belize")));
        countryCodeMap.put("BR", new CountryData("Brazil", List.of("Argentina", "Bolivia", "Colombia", "Paraguay", "Peru", "Uruguay", "Venezuela")));
        countryCodeMap.put("AR", new CountryData("Argentina", List.of("Bolivia", "Brazil", "Chile", "Paraguay", "Uruguay")));
        countryCodeMap.put("CL", new CountryData("Chile", List.of("Argentina", "Bolivia", "Peru")));
        countryCodeMap.put("CO", new CountryData("Colombia", List.of("Brazil", "Ecuador", "Panama", "Peru", "Venezuela")));
        countryCodeMap.put("PE", new CountryData("Peru", List.of("Bolivia", "Brazil", "Chile", "Colombia", "Ecuador")));
        countryCodeMap.put("CN", new CountryData("China", List.of("Afghanistan", "Bhutan", "India", "Kazakhstan", "Kyrgyzstan", "Laos", "Mongolia", "Myanmar", "Nepal", "North Korea", "Pakistan", "Russia", "Tajikistan", "Vietnam")));
        countryCodeMap.put("KR", new CountryData("South Korea", List.of("North Korea")));
        countryCodeMap.put("KP", new CountryData("North Korea", List.of("China", "Russia", "South Korea")));
        countryCodeMap.put("IN", new CountryData("India", List.of("Bangladesh", "Bhutan", "China", "Myanmar", "Nepal", "Pakistan")));
        countryCodeMap.put("PK", new CountryData("Pakistan", List.of("Afghanistan", "China", "India", "Iran")));
        countryCodeMap.put("ID", new CountryData("Indonesia", List.of("Papua New Guinea", "Malaysia", "Timor-Leste")));
        countryCodeMap.put("TH", new CountryData("Thailand", List.of("Cambodia", "Laos", "Malaysia", "Myanmar")));
        countryCodeMap.put("VN", new CountryData("Vietnam", List.of("Cambodia", "China", "Laos")));
        countryCodeMap.put("MY", new CountryData("Malaysia", List.of("Brunei", "Indonesia", "Thailand")));
    }

    public static CountryCodeRegistry getInstance(){
        if(countryCodeRegistry == null){
            countryCodeRegistry = new CountryCodeRegistry();
        }
        return countryCodeRegistry;
    }

    public CountryData getCountry(String countryCode){
        return countryCodeMap.get(countryCode.toUpperCase());
    }
}

