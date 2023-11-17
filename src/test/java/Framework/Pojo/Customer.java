package Framework.Pojo;

import io.cucumber.datatable.DataTable;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class Customer {
    private String firstName, lastName, zipCode;

    public Customer(DataTable dataTable) {
        Map<String, String> map = dataTable.asMap();
        this.firstName = map.get("firstName");
        this.lastName = map.get("zipCode");
    }
}

