package lab8.task2;

import utils.TaskUnitTask;

public class Main extends TaskUnitTask {
    @Override
    public void main() {
        lab8.Main.copyStudents.sort((lhs, rhs) -> {
                if (lhs.getAverageGrade() > rhs.getAverageGrade())
                    return 1;
                else if (lhs.getAverageGrade() < rhs.getAverageGrade())
                    return -1;

                int cmpSurname = lhs.getSurname().compareTo(rhs.getSurname());

                if (cmpSurname != 0)
                    return cmpSurname;

                return lhs.getName().compareTo(rhs.getName());
            });

        System.out.println(lab8.Main.copyStudents);
    }

    @Override
    public int getId() {
        return 2;
    }
}
