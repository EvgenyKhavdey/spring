package gb.khavdey.service.impl;

import lombok.Getter;

@Getter
public class Product {
    private int id;
    private String name;
    private int prise;

    public Product(int id, String name, int prise) {
        this.id = id;
        this.name = name;
        this.prise = prise;
    }
}
