package lab11.entities;

import lab11.exceptions.ExistsException;

import java.util.*;
import java.util.stream.Collectors;

public class Business {
    private final Set<Employee> employees = new HashSet<>();
    private final List<Project> projects = new ArrayList<>();

    public void addEmployee(final Employee employee) throws ExistsException {
        if (employees.contains(employee)) {
            throw new ExistsException("Employee already exists into the business.");
        }

        employees.add(employee);
    }

    public void addProject(final Project project) throws ExistsException {
        if (projects.contains(project)) {
            throw new ExistsException("Project already exists into the business.");
        }

        projects.add(project);
    }

    public Set<Employee> getEmployees() {
        return Collections.unmodifiableSet(employees);
    }

    public List<Project> getProjects() {
        return Collections.unmodifiableList(projects);
    }

    @Override
    public String toString() {
        return "Business [\n\temployees "
                + employees
                + "\n\tprojects "
                + projects.stream()
                        .map((project) -> "\n\t\t" + project.toString())
                        .collect(Collectors.toList())
                + "\n]";
    }
}
