package gb.khavdey.service;

import gb.khavdey.service.impl.Product;

import java.util.ArrayList;

public interface CartInterface {

    ArrayList<Product> add(int i);

    ArrayList<Product> remove(int i);
}
