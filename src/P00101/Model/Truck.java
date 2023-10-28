package P00101.Model;

public class Truck {
    private int garbage;
    private int time;
    private int cost;
    private int count;

    public Truck(){

    }
    public Truck(int garbage, int time, int cost, int count) {
        this.garbage = garbage;
        this.time = time;
        this.cost = cost;
        this.count = count;
    }

    public int getGarbage() {
        return garbage;
    }

    public void setGarbage(int garbage) {
        this.garbage = garbage;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Track{" +
                "garbage=" + garbage +
                ", time=" + time +
                ", cost=" + cost +
                ", count=" + count +
                '}';
    }
}
