import java.util.EmptyStackException;
import java.util.Iterator;

public class ListStack implements Stack, Iterable
{
    private ListStackNode first; // top of stack
    private int size; // number of elements in the stack

    private class ListStackNode
    {
        double item;
        ListStackNode next;
    }

    public void push(double item)
    {
        ListStackNode oldFirst = first;
        first = new ListStackNode();
        first.item = item;
        first.next = oldFirst;
        size++;
    }

    public double pop()
    {
        if (isEmpty())
        {
            throw new EmptyStackException();
        }
        double item = first.item;
        first = first.next;
        size--;
        return item;
    }


    public double peek()
    {
        //
        if (!isEmpty()) {
            return first.item;
        }
        else
        {
            throw new EmptyStackException();
        }
    }

    public boolean isEmpty()
    {
        return first == null;
    }

    public int size()
    {
        return size;
    }

    public Iterator iterator()
    {
        return new ListIterator();
    }

    private class ListIterator implements Iterator
    {
        private ListStackNode current = first;

        public boolean hasNext() {
            return current != null;
        }

        public Object next()
        {
            if (!hasNext())
            {
                throw new RuntimeException("No more items to iterate over");
            }
            double item = current.item;
            current = current.next;
            return item;
        }
    }

    public int count() {
        int count = 0;
        for (Object item : this)
        {
            count++;
        }
        return count;
    }
}
