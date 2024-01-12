package lab2.task2;

import utils.TaskUnitTask;

public class Main extends TaskUnitTask {
        @Override
        public void main() {
                Student student1 = new Student(42, "Decebal", "Popescu");
                /*
                 * noi dorim sa facem o copie a obiectului student1, numita student2
                 * apoi sa modificam copia respectiva
                 */
                Student student2 = new Student(student1);

                student2.setName("Cezar");
                student2.setSurname("Ghiu");

                /*
                 * trebuie sa afiseze
                 * Name: Decebal
                 * Surname: Popescu
                 * Student ID: 42
                 */
                student1.show();

                /*
                 * trebuie sa afiseze
                 * Name: Cezar
                 * Surname: Ghiu
                 * Student ID: 42
                 */
                student2.show();
        }

        @Override
        public int getId() {
                return 2;
        }
}
