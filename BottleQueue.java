import org.json.*;
public class BottleQueue
{
    private final Bottles[] queue;
    private int front;
    private int rear;
    private int size;
    private int capacity;
    private Bottles lastPop;
    private int elements;

    public BottleQueue(int capacity)
    {
        this.capacity = capacity;
        this.queue = new Bottles[this.capacity];
        this.front = 0;
        this.rear = -1;
        this.size = capacity;
        this.elements = 0;
    }

    public boolean enqueue(Bottles element)
    {
        if (null == element)
            return false;

        if (isFull())
        {
            System.out.println("Queue is full. Cannot enqueue " + element);
            return false;
        }

        rear = (rear + 1) % capacity;
        queue[rear] = element;
        size++;
        this.elements++;
        System.out.println("Queue push, name = " + element.name + " id = " + element.id + "queue lenth = " + this.size);
        return true;
    }

    public Bottles dequeue()
    {
        this.lastPop = queue[front];
        front = (front + 1) % capacity;
        size--;
        if (null == this.lastPop)
        {
            System.out.println("Queue pop, empty value.");
        }
        else
        {
            this.elements--;
            System.out.println("Queue pop, name = " + this.lastPop.name + "id = " + this.lastPop.id + "queue lenth = " + this.size);
        }

        return this.lastPop;
    }

    public boolean isFull()
    {
        return elements == capacity;
    }

    public boolean isEmpty()
    {
        return elements == 0;
    }

    public int getSize()
    {
        return size;
    }

    public void Display()
    {
        if (isEmpty())
        {
            return;
        }

        System.out.print("Queue elements: ");
        for (int i = 0; i < size; i++)
        {
            System.out.print(queue[(front + i) % capacity] + " ");
        }
        System.out.println();
    }

    public int GetHeadOfQueue()
    {
        if (this.size == 0)
            return -1;

        return queue[(front + size) % capacity].id;
    }

    public String GetLastPopStringJson()
    {
        if (this.size == 0)
            return null;

        JSONObject jsonObj = new JSONObject();


        //test model
        if (this.lastPop == null)
        {
            Bottles tmp = queue[(front + size) % capacity];
            jsonObj.put("bottleID", tmp.id);
            jsonObj.put("orderID", tmp.current_order_id);
            jsonObj.put("bottleIndex", tmp.current_bottle_index);
            jsonObj.put("orderAmount", tmp.current_order_amount);
        }
        else
        {
            jsonObj.put("bottleID", this.lastPop.id);
            jsonObj.put("orderID", this.lastPop.current_order_id);
            jsonObj.put("bottleIndex", this.lastPop.current_bottle_index);
            jsonObj.put("orderAmount", this.lastPop.current_order_amount);
        }

        System.out.println("Last Pop String: " + jsonObj.toString());
        return jsonObj.toString();
    }

}
