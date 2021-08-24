package gb.khavdey.service.impl;

import gb.khavdey.ProductRepositoryInterface;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class ProductRepository implements ProductRepositoryInterface {
    private ArrayList<Product> list;

    public ProductRepository(ArrayList<Product> list) {
        this.list = list;
        list.add(new Product(1,"Хлеб", 19));
        list.add(new Product(2,"Мясо", 312));
        list.add(new Product(3,"Рыба", 780));
        list.add(new Product(4,"Картошка", 32));
        list.add(new Product(5,"Молоко", 61));
    }


    @Override
    public String getRepository() {
        String a = "";
        for (Product product : getList()){
            a += product.getName() + " ";
        }
        return a;
    }

    @Override
    public String getProduct(int i) {
        if(i <= 5) {
            for (Product product : getList())
                if (product.getId() == i) {
                    return product.getName();
                }
        }
        return null;
    }
}

