package entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@Data
@ToString
public class Employee {
    private Long id;
    private String firstName;
    private String lastName;
    private String role;

    public Employee(String firstName, String lastName, String role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
    }
}
