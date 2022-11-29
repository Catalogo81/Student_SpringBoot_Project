package com.example.Student_SpringBoot_Project;

import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * StudentController Class that uses REST API to access and expose the application on the internet
 */

@RestController //annotation - Rest API to expose and access it via the internet
public class StudentController
{
    // initialization of our global student hashmap
    // this hashmap saves the student fullName as the key,
    // and Student object as the value
    final private HashMap<String, Student> studentDetails = new HashMap<>();

    /* REST methods used for accessing and exposing our app */
    //creates or adds a student
    @PostMapping("/addStudent")
    public Student addStudentDetails(@RequestParam Integer idNo, @RequestParam String fullName, @RequestParam String city)
    {
        //creating the student object
        Student student = new Student(idNo, fullName, city);

        //adds the student into the HashMap
        studentDetails.put(student.getFullName(), student);

        return student;
    }

    //reads all student data
    @GetMapping("/readAll")
    public Collection<Student> getStudentDetails()
    {
        //gets all the student details (id : fullName)
        for(Map.Entry<String, Student> s : studentDetails.entrySet())
            System.out.println("Student: "+ s.getKey() +
                    "\nID Number: " + s.getValue().getIdNo() + ", FullName: " +  s.getValue().getFullName() +
                    ", City: " +  s.getValue().getCity() + "\n");

        return studentDetails.values();
    }

    //reads specific student data by name
    @GetMapping("/read/{fullName}")
    public Student readStudentDetailsByName(@PathVariable String fullName)
    {
        //gets specific student details by fullName
        Student student = studentDetails.get(fullName);

        //if student fullName exists, return the student details
        if(studentDetails.containsKey(student.getFullName()))
            return student;
        else
            return null;
    }

    //updates student details
    @PutMapping("/update/{fullName}") //uses RequestBody since its PutMapping
    public Collection<Student> updateStudentDetailsByName(@PathVariable String fullName, @RequestBody Student student)
    {
        //gets specific student details by fullName
        Student studentToUpdate = studentDetails.get(fullName);

        if(studentDetails.containsKey(studentToUpdate.getFullName()))
            studentDetails.put(student.getFullName(), student);
        else
            throw new RuntimeException("No data with specified name to update");

        return studentDetails.values();
    }

    //deletes a student
    @DeleteMapping("/delete/{fullName}")
    public String deleteStudentDetailsByName(@PathVariable String fullName)
    {
        //gets specific student details by fullName
        Student studentToDelete = studentDetails.get(fullName);

        if(studentDetails.containsKey(studentToDelete.getFullName()))
            studentDetails.remove(fullName);
        else
            throw new RuntimeException("No data with specified name to update");

        return "Student successfully deleted!";
    }
}
