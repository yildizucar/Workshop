package Framework.Pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;

// Used in demo.feature

@Getter
@AllArgsConstructor
public class Cucumber {
    private int count;

    public void eat(int amount) {
        count -= amount;
    }
}
