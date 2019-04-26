package OOP;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mashhur on 2016-02-03.
 */
public class CarParking implements IParkable {

    private List<Car> nCarList;
    private int nCapacity;
    private int nPrice;

    void CarParking() {
        nCarList = new ArrayList<>();
    }

    public void SetCapacity(int nVal) {
        this.nCapacity = nVal;
    }

    public int GetCapacity() {
        return nCapacity;
    }

    public int GetFreeLots() {
        return nCapacity - nCarList.size();
    }

    public boolean isFull() {
        return nCapacity == nCarList.size();
    }

    public void SetPrice(int price) {
        this.nPrice = price;
    }

    public int GetPrice() {
        return nPrice;
    }
}

class Car {
    int numOfTire;
    int nModel;
    int nEngineProperty;

    boolean Pay() {
        // check price and pay
        return true;
    }

    void EnterPark() {
        // if parking lot is not full
    }

    void ExitPark() {
        // if after paying
    }
}