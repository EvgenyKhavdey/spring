package gb.spring.lesson4.model;

import com.fasterxml.jackson.annotation.JsonValue;
import gb.spring.lesson4.annotation.Company;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NewProduct {
    @NonNull
    private String title;
    @Company
    private String producer;

    public NewProduct(String both) {
        String[] pairs = both.split("and");
        this.title = pairs[0].trim();
        this.producer = pairs[1].trim();
    }

    @Override
    @JsonValue
    public String toString() {
        return title + " - " + producer;
    }
}
