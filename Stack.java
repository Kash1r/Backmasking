// Interface for a stack of primitive doubles.
public interface Stack
{
    public boolean isEmpty();

    public int count();

    public void push(double d);

    public double pop();

    public double peek();
}
