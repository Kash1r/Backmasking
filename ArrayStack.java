import java.util.EmptyStackException;
public class ArrayStack implements Stack
{
    private int INITIAL_CAPACITY = 100;
    private double[] items = new double[INITIAL_CAPACITY];
    private int top = 0;

    public boolean isEmpty()
    {
        return (top == 0);
    }
    public void push(double d)
    {
        if (top == items.length)
        {
            double newArr[] = new double[2 * items.length];

            for (int i = 0; i < items.length; i++)
            {
                newArr[i] = items[i];
            }
            items = newArr;
        }
        items[top++] = d;
    }

    public double pop()
    {
        if(top == 0)
        {
            throw new EmptyStackException();
        }
        double topItem = items[top - 1];
        top--;

        return topItem;
    }

    public double peek()
    {
        if(top == 0)
        {
            throw new EmptyStackException();
        }
        double topItem = items[top - 1];

        return topItem;
    }

    public int count()
    {
        return items.length;
    }
}
