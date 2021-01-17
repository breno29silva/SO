package trabalhoso03;

import java.util.ArrayList;
import java.util.List;

public class FibValues {

    private List<Integer> values;

    public FibValues() {
        values = new ArrayList();
    }

    public void getValues() {
        for (int value : values) {
            System.out.print(value + " ");
        }
        System.out.println("");
    }

    public void set(int value) {
        values.add(value);
    }
}