package domain.business;

import data.DBFacade;
import domain.entity.OrderDetail;
import domain.exception.ItemException;
import java.util.ArrayList;

public class Calc {

    DOFacade dof = new DOFacade();

    public Calc() {
    }

    // It shall ofcourse not just add to it.
    public double getTotalPrice(ArrayList<OrderDetail> alod) throws ItemException {
        double res = 0.0;

        for (int i = 0; i < alod.size(); i++) {
            int measurement = alod.get(i).getOrderMeasurement();
            int quantity = alod.get(i).getOrderQuantity();
            int itemId = alod.get(i).getFkItemId();
            double itemPrice = dof.getItem(itemId).getItem_price();

            res += (((measurement / 30) * quantity) * itemPrice);
        }

        return res;
    }

    public double getMomsPrice(double totalPrice){
        
        double res = 0.0;
        
        res = (totalPrice / 100) * 25;
        
        return res;
        
    }
    
    // gets the measurement for the woodpillars
    public int getMeasurementForWoodPillar(int orderHeight) {
        int measurement = (orderHeight + 90);

        return measurement;
    }

    // Gets the Measurement for the roof
    // Calc for roof, takes width and shorten it with 1.4
    public int getMeasurementForRoof(int orderWidth) {
        int measurement = (int) (orderWidth / 1.4);

        return measurement;
    }

    // Gets the Measurement for the roof
    // Calc for roof, spidstag, quantity wood neeeded, 2 sides....
    public int getQuantityForRoof(int orderLength) {
        int measurement = ((orderLength / 30) * 2);

        return measurement;
    }

    // Gets the Measurement for the sides
    // First part is sides and calculatet so we know how many wood things we need and 2 x because there is 2 sides. Second part is width of the carport (bagbeklædning).
    public int getQuantityForSide(int orderLength, int orderWidth) {
        int measurement = ((orderLength / 30) * 2) + (orderWidth / 30);

        return measurement;
    }
    
    // gets the measurement for the floor
    // Calc for floor
    public int getMeasurementForFloor(int orderLength) {
        int measurement = (orderLength / 30);

        return measurement;
    }

}
