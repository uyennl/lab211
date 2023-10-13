package J1SP0056.Repository;

import J1SP0056.Entity.Worker;

import java.util.ArrayList;

public class WorkerDAO implements WorkerDAOInterface {
    private final ArrayList<Worker> workers = new ArrayList<>();

    @Override
    public void addWorker(Worker worker) {
        workers.add(worker);
    }

    @Override
    public void updateWorker(Worker worker) {
        for (Worker w : workers) {
            if (w.getId().equals(worker.getId())) {
                w.setName(worker.getName());
                w.setAge(worker.getAge());
                w.setSalary(worker.getSalary());
                w.setWorkLocation(worker.getWorkLocation());
                break;
            }
        }
    }

    @Override
    public Worker getWorkerById(String id) {
        for (Worker worker : workers) {
            if (worker.getId().equalsIgnoreCase(id)) {
                return worker;
            }
        }
        return null;
    }

    @Override
    public ArrayList<Worker> getAllWorkers() {
        return workers;
    }
}