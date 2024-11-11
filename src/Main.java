// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
                // יצירת אובייקטים של המפיק והצרכן
                producer producer = new producer();
                Consumer consumer = new Consumer();

                // יצירת והפעלה של תהליכים (Threads) עבור המפיק והצרכן
                Thread producerThread = new Thread(producer);
                Thread consumerThread = new Thread(consumer);

                producerThread.start();
                consumerThread.start();
            }
        }



