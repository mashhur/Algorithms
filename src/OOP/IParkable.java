package OOP;

/**
 * Created by mashhur on 2/7/16.
 */
public interface IParkable {

    public void SetCapacity(int nVal);
    public int GetCapacity();
    public int GetFreeLots();
    public boolean isFull();

    public void SetPrice(int price); // per hour
    public int GetPrice(); // per hour
}