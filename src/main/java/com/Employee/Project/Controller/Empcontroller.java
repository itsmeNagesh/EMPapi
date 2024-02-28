
package com.Employee.Project.Controller;

import com.Employee.Project.Model.Emp;
import com.Employee.Project.Service.Empservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.NoSuchElementException;

@CrossOrigin("*")

@RestController
public class Empcontroller {

    @Autowired
    Empservice empService;

    @PostMapping("Create/Employee/")
    public String SaveEmp(@RequestBody Emp em1) {
        return empService.SaveEmp(em1);
    }

    @GetMapping("Show/all/Employee")
    public List<Emp> GetAllemp() {
        return empService.GetAllemp();
    }

    @GetMapping("Employee/Get/By/{Emp_Id}")
    public Emp EmpGetbyId(@PathVariable Integer Emp_Id) {
        return empService.EmpGetbyId(Emp_Id);
    }

    @PutMapping("Update/Employee/By/{Emp_Id}")
    public String UpdateEmp(@PathVariable Integer Emp_Id, @RequestBody Emp updateEmp) {
        return empService.UpdateEmp(Emp_Id, updateEmp);
    }
    @DeleteMapping("Remove/all/Data")
    public String Removeall(){
        return empService.Removeall();
    }


//         @DeleteMapping("Delete/by/{Emp_Id}")
//         public String deleterow(@PathVariable Integer Emp_Id)
//         {
//             return empService.deleterow(Emp_Id);
//         }

    @DeleteMapping("/Delete/by/{Emp_Id}")
    public ResponseEntity<String> deleterow(@PathVariable Integer Emp_Id) {
        try {
            String result = empService.deleterow(Emp_Id);
            return ResponseEntity.ok(result);
        } catch (NoSuchElementException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Emp_Id not found");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred during deletion");
        }
    }
}
