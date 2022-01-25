package person.customer;

import market.Market;
import person.Person;
import person.seller.Seller;
import product.Product;

import java.util.ArrayList;
import java.util.List;

public class Customer extends Person {
    private List<Product> expectedPurchaseList;
    private List<Product> purchaseList;

    public Customer(List<Product> expectedPurchaseList, int cash) {
        this.purchaseList = new ArrayList<>();
        this.expectedPurchaseList = expectedPurchaseList;
        this.setCash(cash);
    }

    public void addPurchase(Product product) {
        if (purchaseList == null) {
            purchaseList = new ArrayList<>();
        }

        purchaseList.add(product);
    }

    public void findProductOnMarket(Market market, String name, String lastName) {
        for (Product product : getExpectedPurchaseList()) {
            boolean isBought;
            boolean checked = false;
            for (Seller seller : market.getSellers()){
                if (seller.getName().equals(name) && seller.getLastName().equals(lastName)) {
                    isBought = seller.sellProducts(this, product);
                    if(isBought) {
                        checked = true;
                        System.out.println(seller.getName() + " " + seller.getLastName() + " продал " + product.getName()
                                + " в количестве " + product.getQuantity() + "шт");
                    }
                }
            }
            for (Seller seller : market.getSellers()) {
                if (!checked) {
                    isBought = seller.sellProducts(this, product);
                    if (isBought) {
                        System.out.println(seller.getName() + " " + seller.getLastName() + " продал " + product.getName()
                                + " в количестве " + product.getQuantity() + "шт");
                        break;

                    }
                }
            }
        }
    }

    public void info() {
        StringBuilder result = new StringBuilder("Я купил ");
        if (purchaseList.size() == 0) {
            result.append("ничего");
        } else {
            for (Product product : purchaseList) {
                result.append(product.getName());
                result.append(" в количестве ");
                result.append(product.getQuantity());
                result.append(" шт. ");
            }
        }

        result.append(" У меня осталось: ");
        result.append(getCash());
        result.append(" рублей");

        System.out.println(result);
    }

    public List<Product> getExpectedPurchaseList() {
        return expectedPurchaseList;
    }

    public List<Product> getPurchaseList() {
        return purchaseList;
    }

    public void setPurchaseList(List<Product> purchaseList) {
        this.purchaseList = purchaseList;
    }
}



