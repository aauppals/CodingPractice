import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import static java.lang.Integer.parseInt;

public class CallCenter {

    static BlockingQueue<Call> respondantQueue = new ArrayBlockingQueue<>(20);
    static BlockingQueue<Call> directorQueue = new ArrayBlockingQueue<>(20);

    static List<Manager> managers = Arrays.asList(new Manager("Manager - 1"), new Manager("Manager - 2"));

    public static void main(String[] args) throws Exception {
        new CallCenter().operate();
    }

    void operate() throws InterruptedException {
        Arrays.asList(new Director("The Director"));

        System.out.println("Enter values representing call in the format: 0,25.");
        System.out.println("First value is level required, second value is call duration.");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String s = scanner.nextLine();
            if ("q".equals(s)) {
                break;
            }
            String[] split = s.split(",");
            Call call = new Call(parseInt(split[0]), parseInt(split[1]));
            dispatchCall(call);
        }
        scanner.close();
        System.exit(0);
    }

    private void dispatchCall(Call call) throws InterruptedException {
        respondantQueue.put(call);
    }
}

class Call {

    static int idCounter = 0;

    int id;
    int durationInSeconds;
    int level;

    public Call(int level, int durationInSeconds) {
        this.level = level;
        this.durationInSeconds = durationInSeconds;
        this.id = idCounter++;
    }

    @Override
    public String toString() {
        return "Call{" + "id=" + id + ", duration(sec)=" + durationInSeconds + ", level=" + level + '}';
    }
}

class Respondant {
    String name;
    volatile boolean isBusy = false;


    public Respondant(String name) {
        this.name = name;
        new Thread(() -> {
            while (true) {
                try {
                    Call call = CallCenter.respondantQueue.take();
                    isBusy = true;
                    if (call.level == 0) {
                        System.out.println(name + " handling call: " + call);
                        Thread.sleep(call.durationInSeconds * 1000);
                    } else {
                        boolean managerHandled = false;
                        for (Manager manager : CallCenter.managers) {
                            if (!manager.isBusy) {
                                manager.acceptCall(call);
                                managerHandled = true;
                                break;
                            }
                        }
                        if (!managerHandled) {
                            CallCenter.directorQueue.put(call);
                        }
                    }
                } catch (InterruptedException ignored) {
                }
            }
        }).start();
    }
}

class Manager {
    String name;
    volatile boolean isBusy;

    public Manager(String name) {
        this.name = name;
    }

    void acceptCall(Call call) {
        new Thread(() -> {
            try {
                isBusy = true;
                if (call.level == 1) {
                    System.out.println(name + " handling call: " + call);
                    Thread.sleep(call.durationInSeconds * 1000);
                } else {
                    CallCenter.directorQueue.put(call);
                }
                isBusy = false;
            } catch (InterruptedException ignored) {
            }
        }).start();
    }
}

class Director {
    String name;

    public Director(String name) {
        this.name = name;
        new Thread(() -> {
            while (true) {
                try {
                    Call call = CallCenter.directorQueue.take();
                    System.out.println(name + " handling call: " + call);
                    Thread.sleep(call.durationInSeconds * 1000 / 4); // Director handles calls 4 times faster!
                } catch (InterruptedException ignored) {
                }
            }
        }).start();
    }
}