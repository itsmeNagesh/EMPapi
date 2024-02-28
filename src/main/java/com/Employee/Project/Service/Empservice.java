package com.Employee.Project.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import com.Employee.Project.Model.Emp;
import com.Employee.Project.Repo.Emprepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class Empservice {

    @Autowired
    Emprepo empRepo;

    public String SaveEmp(Emp em1) {
        empRepo.save(em1);
        return "Successfully Saved in Database";
    }

    public List<Emp> GetAllemp() {
        return empRepo.findAll();
    }

    public Emp EmpGetbyId(Integer empId) {
        return empRepo.findById(empId)
                .orElseThrow(() -> new NoSuchElementException("Employee not found with ID: " + empId));
    }

    public String UpdateEmp(Integer Emp_Id, Emp updateEmp) {
        return empRepo.findById(Emp_Id).map(Emp -> {
           Emp.setEmp_FirstName(updateEmp.getEmp_FirstName());
            Emp.setEmp_LastName(updateEmp.getEmp_LastName());
            Emp.setEmp_EmailId(updateEmp.getEmp_EmailId());

            empRepo.save(Emp);
            return "Now updated";
        }).orElseThrow(() -> new NoSuchElementException("Not found"));
    }

    public String Removeall() {
        empRepo.deleteAll();
        return "All Data Deleted ";
    }

//    public String deleterow(Integer emp_Id) {
//        empRepo.deleteById(emp_Id);
//        return "deleted now";
//    }

public String deleterow(Integer emp_Id) {
    // Use Optional to handle the case where the specified ID is not found
    Optional<Emp> empOptional = empRepo.findById(emp_Id);
    if (empOptional.isPresent()) {
        empRepo.deleteById(emp_Id);
        return "Deleted successfully";
    } else {
        throw new NoSuchElementException("Emp_Id not found");
    }
}
}

