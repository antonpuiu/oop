package lab11.reports;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import lab11.entities.Account;
import lab11.entities.Bank;
import lab11.entities.Business;
import lab11.entities.Employee;

public class BankReport {
    // Customer = Employee of the Business
    // Business = a client of the Bank
    // Customers of the Bank = all the Employees that work for the Businesses that are clients of the Bank

    public static int getNumberOfCustomers(Bank bank) {
        int result = 0;

        for (Business business : bank.getClients())
            result += business.getEmployees().size();

        return result;
    }

    public static int getNumberOfAccounts(Bank bank) {
        Set<Account> accounts = new HashSet<>();

        for (Business business : bank.getClients())
            for (Employee employee : business.getEmployees())
                accounts.addAll(employee.getAccounts());

        return accounts.size();
    }

    public static SortedSet<Employee> getCustomersSorted(Bank bank) {
        // Display the set of customers in alphabetical order
        SortedSet<Employee> result = new TreeSet<>();

        for (Business business : bank.getClients())
            result.addAll(business.getEmployees());

        return result;
    }

    public static double getTotalSumInAccounts(Bank bank) {
        // Sum of all customers' accounts balances
        double result = 0.0d;

        Set<Account> accounts = new HashSet<>();

        for (Business business : bank.getClients())
            for (Employee employee : business.getEmployees())
                accounts.addAll(employee.getAccounts());

        for (Account account : accounts)
            result += account.getBalance();

        return result;
    }

    public static SortedSet<Account> getAccountsSortedBySum(Bank bank) {
        // The set of all accounts, ordered by current account balance
        SortedSet<Account> accounts = new TreeSet<>();

        for (Business business : bank.getClients())
            for (Employee employee : business.getEmployees())
                accounts.addAll(employee.getAccounts());

        return accounts;
    }

    public static Map<Employee, Collection<Account>> getCustomerAccounts(Bank bank) {
        // Return a map of all the customers with their respective accounts
        Map<Employee, Collection<Account>> result = new HashMap<>();

        for (Business business : bank.getClients())
            for (Employee employee : business.getEmployees())
                result.put(employee, employee.getAccounts());

        return result;
    }

    public static Map<String, List<Employee>> getCustomersByCity(Bank bank) {
        // Map all the customers to their respective cities
        Map<String, List<Employee>> result = new HashMap<>();
        List<Employee> employees = new ArrayList<>();

        for (Business business : bank.getClients())
            for (Employee employee : business.getEmployees())
                employees.add(employee);

        for (Employee employee : employees) {
            if (!result.containsKey(employee.getCity()))
                result.put(employee.getCity(), new ArrayList<>());

            result.get(employee.getCity()).add(employee);
        }

        return result;
    }
}
