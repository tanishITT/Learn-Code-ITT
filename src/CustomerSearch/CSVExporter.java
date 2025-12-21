class CsvExporter
{
    public string Export(List<Customer> customers)
    {
        var sb = new StringBuilder();
        foreach (var c in customers)
        {
            sb.AppendLine($"{c.CustomerID},{c.CompanyName},{c.ContactName},{c.Country}");
        }
        return sb.ToString();
    }
}
