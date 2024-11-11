public class Message {
    private static Message instance = null;
    private String message = "";
    private boolean empty = true;
    private Message() {



    }
    public static synchronized Message getInstance() {
                if (instance == null) {
                    instance = new Message();
                }

        return instance;
    }
    public synchronized void insert(String msg) {
        while (!empty) {
            try {
                instance.wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        this.message = msg;
        this.empty = false;
        System.out.println("Inserted message: " + message);
        instance.notify();
    }
    public synchronized String remove() {
        while (empty) {
            try {
                instance.wait();  // Wait until message is inserted by producer
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        empty = true;
        String msg = message;
        message = "";
        System.out.println("Removed message: " + msg);
        instance.notify();  // Notify producer that the slot is now available
        return msg;
    }
}

