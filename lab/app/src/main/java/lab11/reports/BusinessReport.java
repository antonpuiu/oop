package lab11.reports;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import lab11.entities.*;

public class BusinessReport {

    public static Map<Disability, List<Employee>> getEmployeesOnSameDisability(Business business) {
        // Get employees and map them on the type of disability they possess
        Map<Disability, List<Employee>> result = new HashMap<>();

        for (Employee employee : business.getEmployees()) {
            if (!result.containsKey(employee.getDisability()))
                result.put(employee.getDisability(), new ArrayList<>());

            result.get(employee.getDisability()).add(employee);
        }

        return result;
    }

    public static long getNumberOfDifferentProjectsWorkedByCurrentFemaleEmployees(Business business) {
        // Get employees, filter by gender, get their projects without duplicates, count

        return business.getEmployees().stream()
                .filter((employee) -> employee.getGender() == Gender.FEMALE)
                .map(Employee::getProjects)
                .flatMap(List::stream)
                .collect(Collectors.toSet())
                .size();
    }

    public static Map<Religion, Map<Gender, List<Employee>>> getEmployeesOnSameReligionAndGender(Business business) {
        Map<Religion, Map<Gender, List<Employee>>> result = new HashMap<>();

        for (Employee employee : business.getEmployees()) {
            if (!result.containsKey(employee.getReligion()))
                result.put(employee.getReligion(), new HashMap<>());
            if (!result.get(employee.getReligion()).containsKey(employee.getGender()))
                result.get(employee.getReligion()).put(employee.getGender(), new ArrayList<>());

            result.get(employee.getReligion()).get(employee.getGender()).add(employee);
        }

        return result;
    }
}
