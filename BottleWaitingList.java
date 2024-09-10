import java.util.ArrayList;
import org.json.*;

public class BottleWaitingList
{
    private final ArrayList<Bottles> list;

    public BottleWaitingList()
    {
        this.list = new ArrayList<>();
    }

    //TODO: change the rule of ID generator
    private int BottleIDGenerater(int orderID, int current_count)
    {
        return orderID + current_count + 1;
    }

    public boolean AppendListWithJson(String json_string)
    {
        JSONObject jsonObj = new JSONObject(json_string);
        int count = jsonObj.getInt("count");
        int orderID = jsonObj.getInt("orderId");
        String name = jsonObj.getString("name");

        for (int i = 0; i < count; i++)
        {
            this.list.add(
                    new Bottles(BottleIDGenerater(orderID, i),
                    name, orderID, i, count));
        }

        System.out.println("Waiting list push one queue, current size = " + this.list.size());
        return true;
    }

    public Bottles PopBottle()
    {
        if (this.list.isEmpty())
            return null;

        Bottles bottle = this.list.remove(0);
        System.out.println("Waiting list pop one, current size = " + this.list.size());
        System.out.println("Waiting list pop Bottles, name = " + bottle.name + " id = " + bottle.id);
        return bottle;
    }

    public int GetListLength()
    {
        return this.list.size();
    }

    public boolean IsEmpty()
    {
        return (this.list.isEmpty());
    }
}
