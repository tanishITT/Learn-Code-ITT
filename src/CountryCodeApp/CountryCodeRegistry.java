package CountryCodeApp;

import java.util.HashMap;
import java.util.Map;

public class CountryCodeRegistry {

    private static CountryCodeRegistry countryCodeRegistry;
    private static Map<String, String> countryCodeMap;

    private CountryCodeRegistry(){
        addMockCountryCodes();
    }

    private void addMockCountryCodes(){
        countryCodeMap = new HashMap<>();
        countryCodeMap.put("IN", "India");
        countryCodeMap.put("US", "United States");
        countryCodeMap.put("UK", "United Kingdom");
        countryCodeMap.put("CA", "Canada");
        countryCodeMap.put("AU", "Australia");
        countryCodeMap.put("DE", "Germany");
        countryCodeMap.put("FR", "France");
        countryCodeMap.put("JP", "Japan");
        countryCodeMap.put("CN", "China");
        countryCodeMap.put("BR", "Brazil");
    }

    public static CountryCodeRegistry getInstance(){
        if(countryCodeRegistry == null){
            countryCodeRegistry = new CountryCodeRegistry();
        }
        return countryCodeRegistry;
    }

    public String getCountryName(String countryCode){
        return countryCodeMap.get(countryCode.toUpperCase());
    }
}

