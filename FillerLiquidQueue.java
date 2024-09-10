import java.util.LinkedList;
import java.util.Queue;

public class FillerLiquidQueue
{
    private final Queue<LiquidConfig> queue;

    public FillerLiquidQueue()
    {
        this.queue = new LinkedList<LiquidConfig>();
    }

    public void PopOneBottle()
    {
        if (this.queue.isEmpty())
            return;

        LiquidConfig temp = this.queue.peek();
        temp.PopOneBottleInCurrentCount();

        if (0 == queue.peek().GetCount())
            queue.poll();

        System.out.println("One bottle finished, " + temp.GetVolume() + " to queue, count = " + temp.GetCount());
    }

    public boolean PushOneQueue(String str)
    {
        LiquidConfig cfg = new LiquidConfig(str);
        System.out.println("Pushing " + cfg.GetVolume() + " to queue, count = " + cfg.GetCount());
        return this.queue.offer(cfg);
    }

    public int GetCurrentIngredient()
    {
        if (this.queue.isEmpty())
            return -1;

        return this.queue.peek().GetVolume();
    }
}
