package lab8.task1;

public class Student implements Comparable<Student> {
    private String name;
    private String surname;
    private long id;
    private double averageGrade;

    public Student(String name, String surname, long id, double averageGrade) {
        this.name = name;
        this.surname = surname;
        this.id = id;
        this.averageGrade = averageGrade;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public long getId() {
        return id;
    }

    public double getAverageGrade() {
        return averageGrade;
    }

    @Override
    public int compareTo(Student arg0) {
        if (averageGrade > arg0.averageGrade)
            return 1;
        else if (averageGrade < arg0.averageGrade)
            return -1;

        int cmpSurname = surname.compareTo(arg0.surname);

        if (cmpSurname != 0)
            return cmpSurname;

        return name.compareTo(arg0.name);
    }

    @Override
    public String toString() {
        return "Student [name=" + name + ", surname=" + surname + ", id=" + id + ", averageGrade=" + averageGrade + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((surname == null) ? 0 : surname.hashCode());
        result = prime * result + (int) (id ^ (id >>> 32));
        long temp;
        temp = Double.doubleToLongBits(averageGrade);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Student other = (Student) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (surname == null) {
            if (other.surname != null)
                return false;
        } else if (!surname.equals(other.surname))
            return false;
        if (id != other.id)
            return false;
        if (Double.doubleToLongBits(averageGrade) != Double.doubleToLongBits(other.averageGrade))
            return false;
        return true;
    }
}
