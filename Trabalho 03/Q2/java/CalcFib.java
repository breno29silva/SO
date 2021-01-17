package trabalhoso03;

public class CalcFib implements Runnable {

    private int terms;
    private FibValues fibValues;

    public CalcFib(int terms, FibValues fibValues) {
        if (terms < 0) {
            System.err.println("Report a positive amount of terms");
            System.exit(0);
        }
        this.terms = terms;
        this.fibValues = fibValues;
    }

    @Override
    public void run() {
        for (int i = 0; i < terms; i++) {
            fibValues.set(fibonacci(i));
        }
    }

    private int fibonacci(int term) {
        if (term == 0) {
            return 0;
        } else if (term == 1){
            return 1;
        }else{
            return fibonacci(term - 1) + fibonacci(term - 2);
        }
    }    
}