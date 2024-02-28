package com.Employee.Project.Model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Emp {
    @Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Emp_Id;
    private String Emp_FirstName;
    private String Emp_LastName;
    private String Emp_EmailId;
}
