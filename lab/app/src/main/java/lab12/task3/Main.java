package lab12.task3;

import lab12.task3.logger.ConsoleLogger;
import lab12.task3.logger.EmailLogger;
import lab12.task3.logger.FileLogger;
import lab12.task3.logger.LogLevel;
import lab12.task3.logger.Logger;

import utils.TaskUnitTask;

public class Main extends TaskUnitTask {
    @Override
    public void main() {
        Logger logger1 = new ConsoleLogger();
        Logger logger2 = new EmailLogger();
        Logger logger3 = new FileLogger();

        logger1.setNext(logger2);
        logger2.setNext(logger3);

        logger1.message("Se execută metoda ProcessOrder()", LogLevel.Debug);
        logger1.message("Comanda a fost procesată cu succes", LogLevel.Info);
        logger1.message("Datele despre adresa clientului lipsesc din baza de date a filialei", LogLevel.Warning);
        logger1.message("Detele despre adresa clientului lipsesc din baza de date a organizație", LogLevel.Error);
        logger1.message("Nu se poate procesa comanda #Comanda1 datată pe 25.11.2018 pentru clientul #Clientul1",
                        LogLevel.FunctionalError);
        logger1.message("Comandă procesată", LogLevel.FunctionalMessage);

        /*
         * The output must look like below:
         *
         * [Console] Se execută metoda ProcessOrder()
         * [Console] Comanda a fost procesată cu succes
         * [Console] Datele despre adresa clientului lipsesc din baza de date a filialei
         * [File] Datele despre adresa clientului lipsesc din baza de date a filialei
         * [Console] Detele despre adresa clientului lipsesc din baza de date a organizație
         * [File] Detele despre adresa clientului lipsesc din baza de date a organizație
         * [Console] Nu se poate procesa comanda #Comanda1 datată pe 25.11.2018 pentru clientul #Clientul1
         * [Email] Nu se poate procesa comanda #Comanda1 datată pe 25.11.2018 pentru clientul #Clientul1
         * [Console] Comandă procesată
         * [Email] Comandă procesată
         *
         */
    }

    @Override
    public int getId() {
        return 3;
    }
}
