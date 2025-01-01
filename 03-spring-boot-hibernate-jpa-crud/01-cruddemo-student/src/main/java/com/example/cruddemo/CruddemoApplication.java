package com.example.cruddemo;

import com.example.cruddemo.dao.StudentDAO;
import com.example.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CruddemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return runner -> {
            // createStudent(studentDAO);
            // createMultipleStudents(studentDAO);
            // readStudent(studentDAO);
            // queryForStudents(studentDAO);
            // queryForStudentsByFirstName(studentDAO);
			// updateStudent(studentDAO);
			deleteStudent(studentDAO);
        };
    }

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 1;
		System.out.println("Deleting student with id: " + studentId);
		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {
		// retrieve a student based on the id: primary key
		int studentId = 1;
		System.out.println("Getting the student with id: " + studentId);
		Student myStudent = studentDAO.findById(studentId);

		// change first name to Shivanshu
		System.out.println("Updating student...");
		myStudent.setFirstName("Shivanshu");

		// update the student
		studentDAO.update(myStudent);

		// display the updated student
		System.out.println("Updated student: " + myStudent);

	}

	private void queryForStudentsByFirstName(StudentDAO studentDAO) {
        // get a list of students
        List<Student> theStudents = studentDAO.findByFirstName("Sudhanshu1");

        // display the list of students
        for (Student tempStudents : theStudents) {
            System.out.println(tempStudents);
        }
    }

    private void queryForStudents(StudentDAO studentDAO) {
        // get a list of students
        List<Student> theStudents = studentDAO.findAll();

        // display the list of students
        for (Student tempStudent : theStudents) {
            System.out.println(tempStudent);
        }

    }

    private void readStudent(StudentDAO studentDAO) {

        // create a student object
        System.out.println("Creating a new Student object...");
        Student tempStudent = new Student("Sudhanshu", "Tripathi", "sudhanshu@gmail.com");

        // save the student
        System.out.println("Saving the Student object...");
        studentDAO.save(tempStudent);

        // display the id of the saved student
        int tempStudentId = tempStudent.getId();
        System.out.println("Saved student. Generated Id: " + tempStudentId);

        // retrieve the student based on the id: primary key
        System.out.println("Retrieving student with id: " + tempStudentId);
        Student myStudent = studentDAO.findById(tempStudentId);

        // display student
        System.out.println("Found student: " + myStudent.toString());

    }

    private void createMultipleStudents(StudentDAO studentDAO) {

        // create multiple students
        System.out.println("Creating 3 new Student objects...");
        Student tempStudent1 = new Student("Sudhanshu1", "Tripathi", "sudhanshu1@gmail.com");
        Student tempStudent2 = new Student("Sudhanshu2", "Tripathi", "sudhanshu2@gmail.com");
        Student tempStudent3 = new Student("Sudhanshu3", "Tripathi", "sudhanshu3@gmail.com");

        // save the student objects
        System.out.println("Saving the students...");
        studentDAO.save(tempStudent1);
        studentDAO.save(tempStudent2);
        studentDAO.save(tempStudent3);

        //
    }

    private void createStudent(StudentDAO studentDAO) {

        // create the student object
        System.out.println("Creating a new Student object...");
        Student tempStudent = new Student("Sudhanshu", "Tripathi", "sudhanshu@gmail.com");

        // save the student object
        System.out.println("Saving the student...");
        studentDAO.save(tempStudent);

        // display the id of the saved student
        System.out.println("Saved student. Generated id: " + tempStudent.getId());
    }
}
