package Framework.Pojo;

import io.cucumber.datatable.DataTable;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Setter
@Getter
public class User {
    private String username, password;

    public User(DataTable dataTable) {
        Map<String, String> map = dataTable.asMap();
        this.username = map.get("username");
        this.password = map.get("password");
    }

}
