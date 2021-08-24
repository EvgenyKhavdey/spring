package gb.khavdey.client;

import gb.khavdey.service.config.ApplicationConfig;
import gb.khavdey.service.impl.Cart;
import gb.khavdey.service.impl.ProductRepository;;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class Client {
    public static void main(String[] args){

        final ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        final ProductRepository products = context.getBean(ProductRepository.class);
        final Cart cart = context.getBean(Cart.class);

        System.out.println(products.getRepository());
        System.out.println(products.getProduct(1));

        final Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Введите команду");
            String str = scanner.nextLine();
            if ("ADD".equals(str)) {
                System.out.println("Введите id товара");
                cart.add(scanner.nextInt());
            } else if ("REMOVE".equals(str)){
                System.out.println("Введите id товара");
                cart.remove(scanner.nextInt());
            } else if ("EXIT".equals(str)) {
                return;
            }
        }
    }
}
