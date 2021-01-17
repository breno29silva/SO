package trabalhoso03;

public class Fibonacci {

    public static void main(String[] args) {

        if (args.length != 1) {
            System.err.println("Usage Driver <integer>");
            System.exit(0);
        }

        int elements = Integer.parseInt(args[0]);
        FibValues fibValues = new FibValues();
        Thread worker = new Thread(new CalcFib(elements, fibValues));
        worker.start();

        try {
            worker.join();
        } catch (InterruptedException e) {
            e.getStackTrace();
        }
        System.out.print("The first " + elements + " elements are: ");
        fibValues.getValues();
    }
}