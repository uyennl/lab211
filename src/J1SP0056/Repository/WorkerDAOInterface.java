package J1SP0056.Repository;

import J1SP0056.Entity.Worker;

import java.util.ArrayList;

public interface WorkerDAOInterface {
    void addWorker(Worker worker);
    void updateWorker(Worker worker);
    Worker getWorkerById(String id);
    ArrayList<Worker> getAllWorkers();
}
