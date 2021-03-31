package com.assignment.springboot.assignementboot.repository;

import com.assignment.springboot.assignementboot.model.Employee;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class EmployeeRepositoryImpl extends AbstractJpaDAO<Employee> implements EmployeeRepository{


    public Session getSession() {
        Session session = entityManager.unwrap(Session.class);
        return session;
    }

    @Override
    public Employee findById(int employeeId) {

        Employee employee;
        Query query =
                super.entityManager.createQuery("SELECT U FROM Employee U WHERE U.id=:employeeId");
        query.setParameter("employeeId", employeeId);

        try {
            employee = (Employee) query.getSingleResult();
        } catch (Exception e) {
           return null;
        }
        return employee;
    }

    @Override
    public Employee createEmployee(Employee employee) {
        return (Employee) super.save(employee);
    }

    @Override
    public List<Employee> getSortedEmployeeData(String column) {
        StringBuilder stringBuilder =  new StringBuilder();
        stringBuilder.append("SELECT U FROM Employee U");
        if(column.equalsIgnoreCase("dob")){
            stringBuilder.append(" order by U.dob asc");
        }else {
            stringBuilder.append(" order by U.joiningDate asc");
        }
        TypedQuery<Employee> query = super.entityManager.createQuery(stringBuilder.toString(), Employee.class);
        try {
            return query.getResultList();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Employee> searchEmployeeData(String searchValue) {
        StringBuilder queryStr = new StringBuilder( "select U from Employee U where U.firstName like  :searchValue or U.surName like  :searchValue or  U.pincode like  :searchValue");
        TypedQuery<Employee> query = entityManager.createQuery(queryStr.toString(), Employee.class);
        query.setParameter("searchValue", "%" + searchValue + "%");
        return query.getResultList();
    }

    @Override
    public void deleteUserById(int id) {
        Query query = super.entityManager.createQuery("DELETE from Employee where id=:id");
        query.setParameter("id", id);
        query.executeUpdate();
    }
}
