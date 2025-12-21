class Employee {
private:
    int id;
    string name;
    string department;
    bool working;

public:
    bool isWorking() const {
        return working;
    }
};
