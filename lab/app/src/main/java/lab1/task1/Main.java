package lab1.task1;

import utils.TaskUnitTask;

public class Main extends TaskUnitTask {
        @Override
        public void main() {
                VeterinaryReport vr = new VeterinaryReport();
                VeterinaryReport vr2 = new VeterinaryReport();

                vr.cats = 99;
                vr.dogs = 199;
                vr2.dogs = 2;

                vr.displayStatistics();
                vr2.displayStatistics();

                System.out.println("The first class method says there are " + vr.getAnimalsCount() + " animals");
                System.out.println("The second class method says there are " + vr2.getAnimalsCount() + " animals");
        }

        @Override
        public int getId() {
                return 1;
        }
}
