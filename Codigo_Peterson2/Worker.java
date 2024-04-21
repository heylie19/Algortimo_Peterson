class Worker implements Runnable {
    private static Peterson peterson = new Peterson();
    private int id;

    public Worker(int id) {
        this.id = id;
    }

    public void run() {
        peterson.lock(id);
        System.out.println("Trabajador " + id + " entrando en la sección crítica.");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Trabajador " + id + " saliendo de la sección crítica.");
        peterson.unlock(id);
    }
}
