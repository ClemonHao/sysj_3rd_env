import org.json.JSONObject;

public class Bottles
{
    public int id;
    public String name;
    private int capacity;
    public int size;
    private String ingredient;
    public int current_order_id;
    public int current_bottle_index;
    public int current_order_amount;

    Bottles(int id, String name, int order_id, int bottle_index, int order_amount)
    {
        this.id = id;
        this.name = name;
        this.current_order_id = order_id;
        this.current_order_amount = order_amount;
        this.current_bottle_index = bottle_index + 1;
    }

    public String ToJsonString()
    {
        JSONObject jsonObj = new JSONObject();

        jsonObj.put("bottleID", this.id);
        jsonObj.put("orderID", this.current_order_id);
        jsonObj.put("bottleIndex", this.current_bottle_index);
        jsonObj.put("orderAmount", this.current_order_amount);

        return jsonObj.toString();
    }
}
