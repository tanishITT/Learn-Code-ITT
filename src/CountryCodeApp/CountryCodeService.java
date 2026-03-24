package CountryCodeApp;
import java.util.Scanner;

public class CountryCodeService {
    final private CountryCodeRegistry registry;
    final private Scanner scanner;
    final private String QUIT_COMMAND = "q";

    public CountryCodeService(CountryCodeRegistry registry){
        this.registry = registry;
        this.scanner = new Scanner(System.in);
    }

    public void startService(){
        System.out.println("Welcome to Country Code Service");
        while(true){
            String inputCode = getUserInput(scanner);
            if(inputCode.equals(QUIT_COMMAND)){
                System.out.println("Turning Off!");
                break;
            }
            printNeighbourNames(inputCode);
        }
    }

    private String getUserInput(Scanner scanner){
        System.out.println("Enter Country Code or press 'Q' or 'q' to quit: ");
        return scanner.nextLine().toLowerCase();
    }

    private void printNeighbourNames(String inputCode){
        CountryData country = registry.getCountry(inputCode);
        if(country == null){
            System.out.println("Country Name Not Found");
            return;
        }
        System.out.println(country.name() + ": " + country.neighbours());
    }
}
