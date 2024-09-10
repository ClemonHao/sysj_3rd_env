import org.json.*;

public class LiquidIngredient
{
    private final LiquidConfig[] ingredient;

    public String[] IngredientNameList = new String[]
            {
            "LiquidA",
            "LiquidB",
            "LiquidC",
            "LiquidD",
    };

    public  LiquidIngredient()
    {
        ingredient = new LiquidConfig[IngredientNameList.length];
    }

    public LiquidIngredient(String json_string)
    {
        this.ingredient = new LiquidConfig[IngredientNameList.length];

        JSONObject jsonObj = new JSONObject(json_string);
        int count = jsonObj.getInt("count");
        JSONArray ingre =  jsonObj.getJSONArray("recipe");
        for (int i = 0; i < ingre.length(); i++)
        {
            JSONObject tmp = ingre.getJSONObject(i);
            String liqType = tmp.getString("liqType");
            int capacity = tmp.getInt("capacity");

            for (int k = 0; k < IngredientNameList.length; k++)
            {
                if (liqType.equals(IngredientNameList[k]))
                {
                    System.out.println("Liquid Config add : " + liqType);
                    this.ingredient[k] = new LiquidConfig(capacity, count);
                }
            }
        }
    }

    public LiquidConfig Get(int index)
    {
        return ingredient[index];
    }

    public boolean UpdateIngredient(String json_string)
    {
        if (json_string.length() == 0)
            return false;

        JSONObject jsonObj = new JSONObject(json_string);
        int count = jsonObj.getInt("count");
        JSONObject ingre =  jsonObj.getJSONObject("recipe");

        for (int i = 0; i < ingre.length(); i++)
        {
            String liqType = jsonObj.getString("liqType");
            int capacity = jsonObj.getInt("capacity");
            for (int k = 0; k < IngredientNameList.length; k++)
            {
                if (liqType.equals(IngredientNameList[k]))
                {
                    System.out.println("Liquid Config add : " + liqType);
                    this.ingredient[k] = new LiquidConfig(capacity, count);
                }
            }
        }
        return true;
    }

    public boolean IsFull()
    {
        return IngredientNameList.length == ingredient.length;
    }

    public int GetCapacity()
    {
        return IngredientNameList.length;
    }
}
