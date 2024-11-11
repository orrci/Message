public class Consumer extends Thread{
    private Message message;

    public Consumer() {
        this.message = Message.getInstance();
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            message.remove();
            try {
                Thread.sleep(1500);  // Simulate time to consume the message
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }



    }
}



