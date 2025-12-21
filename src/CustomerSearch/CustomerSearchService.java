class CustomerSearchService
{
    private readonly Database db;

    public CustomerSearchService(Database database)
    {
        db = database;
    }

    private List<Customer> Search(Func<Customer, bool> predicate)
    {
        return db.Customers
                .Where(predicate)
                .OrderBy(c => c.CustomerID)
                .ToList();
    }

    public List<Customer> SearchByCountry(string country) =>
    Search(c => c.Country.Contains(country));

    public List<Customer> SearchByCompanyName(string company) =>
    Search(c => c.CompanyName.Contains(company));

    public List<Customer> SearchByContact(string contact) =>
    Search(c => c.ContactName.Contains(contact));
}
