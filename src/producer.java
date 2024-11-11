public class producer extends Thread {
    private Message message;

    public producer() {
        this.message = Message.getInstance();
    }

    @Override
    public void run() {
        String[] messages = {"Message 1", "Message 2", "Message 3", "Message 4", "Message 5"};
        for (String msg : messages) {
            message.insert(msg);
            try {
                Thread.sleep(1000);  // Simulate time to create a message
             } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
              }
            }
        }
    }

