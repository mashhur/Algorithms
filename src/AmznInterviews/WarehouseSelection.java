package AmznInterviews;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by mashhur on 1/14/17.
 */
public class WarehouseSelection {

    public static void main(String args[]) {
        Warehouse w1 = new Warehouse("W1");
        Warehouse w2 = new Warehouse("W2");
        Warehouse w3 = new Warehouse("W3");
        Warehouse w4 = new Warehouse("W4");

        // I1
        Product p1w1 = new Product("I1");
        p1w1.setPartnerCost("S1", 0.75);
        p1w1.setPartnerCost("S2", 0.74);
        p1w1.setPartnerCost("S3", 0.70);

        Product p3w1 = new Product("I1");
        p3w1.setPartnerCost("S1", 0.75);
        p3w1.setPartnerCost("S2", 0.74);
        p3w1.setPartnerCost("S3", 0.70);

        w1.addProduct(p1w1);
        System.out.println(w1.getMinCostProd("I1").getKey() + " " + w1.getMinCostProd("I1").getValue());

        /*
        mW2.add(new Product("I1", Arrays.asList(0.75, 0.74, 0.70)));
        mW3.add(new Product("I1", Arrays.asList(0.80, 0.74, 0.70)));

        // I2
        mW3.add(new Product("I2", Arrays.asList(0.80, 0.74, 0.70)));
        mW4.add(new Product("I2", Arrays.asList(0.85, 0.94, 0.30)));

        // I3
        mW1.add(new Product("I3", Arrays.asList(0.85, 0.55, 0.70)));
        mW2.add(new Product("I3", Arrays.asList(0.80, 0.54, 0.70)));

        // I4
        mW4.add(new Product("I4", Arrays.asList(0.74, 0.70, 0.30)));
        mW2.add(new Product("I4", Arrays.asList(0.85, 0.80, 0.70)));
        mW3.add(new Product("I4", Arrays.asList(0.80, 0.74, 0.70)));
        */

    }
}


class Product {
    String key;
    Map<String, Double> nCostList = new HashMap<String, Double>();

    Product(String key){
        if(this.key == null)
            this.key = key;
    }
    public void setPartnerCost(String partner, Double cost){
        if(!nCostList.containsKey(partner)) {
            nCostList.put(partner, cost);
        }
    }
    String getProdName(){
        return key;
    }

    public Map.Entry<String, Double> getMinCostPartner(){
        Map.Entry<String, Double> min_item = null;
        for (Map.Entry<String, Double> item : nCostList.entrySet()){
            if(min_item == null)
                min_item = item;
            else if(min_item.getValue() > item.getValue()){
                min_item = item;
            }
        }
        return min_item;
    }
}

class Warehouse {
    String name;
    List<Product> pList = new ArrayList<Product>();
    Warehouse(String name){
        this.name = name;
    }

    void addProduct(Product p){
        pList.add(p);
    }

    Map.Entry<String, Double> getMinCostProd(String prodName) {
        for (Product p :pList){
            if(p.getProdName() == prodName){
                return p.getMinCostPartner();
            }
        }
        return null;
    }
}