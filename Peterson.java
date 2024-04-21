class Peterson {
    private volatile boolean[] flag = new boolean[2];
    private volatile int turn = 0;

    public void lock(int id) {
        int other = 1 - id;
        flag[id] = true;
        turn = other;
        while (flag[other] && turn == other);
    }

    public void unlock(int id) {
        flag[id] = false;
    }
}

class Process implements Runnable {
    private Peterson peterson;
    private int id;

    public Process(Peterson peterson, int id) {
        this.peterson = peterson;
        this.id = id;
    }

    public void run() {
        peterson.lock(id);
        // Sección crítica
        System.out.println("Proceso " + id + " entrando en la sección crítica.");
        try {
            Thread.sleep(1000); // Simula actividad en la sección crítica
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Proceso " + id + " saliendo de la sección crítica.");
        peterson.unlock(id);
    }
}

