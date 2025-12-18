package com.pack.api.common.serviceimplementation;

import com.pack.api.address.entity.Address;
import com.pack.api.address.repository.AddressRepository;
import com.pack.api.common.service.AppService;
import com.pack.api.student.entity.Student;
import com.pack.api.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class AppServiceImplementation implements AppService {


    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Override
    @Transactional
    public void saveData() {

        Address address = new Address("123 Main St", "New Town", "Jens", "62701");
        // Student student = new Student("Emily Wilson", "emily@gmail.com", "1231231234");
        Student student = new Student("Emily Wilson", "emily@gmail.com", "1231231234", address);
        // student.setAddress(address);

        // addressRepository.save(address); // this is not required because of CascadeType.PERSIST
        studentRepository.save(student);

        System.out.println("data for student and their address are now inserted on the database table");
    }


    @Override
    @Transactional
    public void fetchData() {

        //        Student student = studentRepository.findById(1L).orElse(null);
        //        if (student != null) {
        //            System.out.println("Student Name: " + student.getName());
        //            Address address = student.getAddress();
        //            if (address != null) {
        //                System.out.println("Address: " + address.getStreet() + ", " + address.getCity() + ", " + address.getState() + " - " + address.getPinCode());
        //            } else {
        //                System.out.println("No address found for this student.");
        //            }
        //        } else {
        //            System.out.println("Student not found.");
        //        }

        Student student = studentRepository.findById(1L).get();
        System.out.println(student);
        // Address address = student.getAddress();
        //        System.out.println(address);
        //        System.out.println(address.getCity());
        // System.out.println(address.getAddressId());
        System.out.println(student.getAddress().getState());
        System.out.println("fetched student and their address successfully");
    }

    @Override
    public void getStudentFromAddress() {
        Address address = addressRepository.findById(1L).get();
        System.out.println(address);
        System.out.println(address.getStudent());
        System.out.println("fetched student from address successfully");
    }

    @Override
    public void getStudentFromAddress1() {
        System.out.println("-----getStudentFromAddress1 method called start-----");
        Address address = addressRepository.findById(1L).get();
        System.out.println(address);
        System.out.println("-----getStudentFromAddress1 method called end-----");
    }


}
