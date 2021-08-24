package gb.khavdey.service.impl;

import gb.khavdey.service.CartInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
@Component
public class Cart implements CartInterface {

    private ArrayList<Product> list;
    private ProductRepository productRepository;

    @Autowired
    public Cart(ArrayList<Product> list, ProductRepository productRepository) {
        this.list = list;
        this.productRepository = productRepository;
    }

    @Override
    public ArrayList<Product> add(int i) {
        if (i <= 5){
            for (Product product : productRepository.getList()){
                if (product.getId() == i){
                    list.add(product);
                }
            }
        }
        return null;
    }

    @Override
    public ArrayList<Product> remove(int i) {
        if (i <= 5){
            for (Product product : list){
                if (product.getId() == i){
                    list.remove(product);
                }
            }
        }
        return null;
    }
}
