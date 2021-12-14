package project;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

// Just a test class to check whether the data is read or not.

public class TestClass {
	 
	public static void main(String[] args) {
		//CommonClass.loadBinaryData();
		System.out.println(getStudents());
		getCourses();
		
	}
	
	public static ArrayList<String> getCourseNames(){
	 try (
		      FileInputStream fos = new FileInputStream("res\\Registration.dat");
		      ObjectInputStream oos = new ObjectInputStream(fos);
		      ){
			  CommonClass.courseList = (ArrayList<Course> ) oos.readObject();
			  CommonClass.studentList = (ArrayList<Student> ) oos.readObject();
  

	 	} catch (IOException | ClassNotFoundException  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

	}
	 ArrayList<String> courseNames = new ArrayList<>();
	 	for(int i = 0; i<CommonClass.courseList.size();i++) {
	 		courseNames.add(CommonClass.courseList.get(i).getCourseID());
	 		
	 	}
	 	return courseNames;
}
	
	public static ArrayList<Course> getCourses(){
		
			      FileInputStream fos = null;
				try {
					fos = new FileInputStream("res\\Registration.dat");
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			      ObjectInputStream oos = null;
				try {
					oos = new ObjectInputStream(fos);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				  ArrayList<Course> courses = null;
				try {
					courses = (ArrayList<Course> ) oos.readObject();
				} catch (ClassNotFoundException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				return courses;
	}
	
	public static ArrayList<Student> getStudents(){
	      FileInputStream fos = null;
					try {
						fos = new FileInputStream("res\\Registration.dat");
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				      ObjectInputStream oos = null;
					try {
						oos = new ObjectInputStream(fos);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				      
					  ArrayList<Course> courses = null;
					  ArrayList<Student> students = null;
					try {
						courses = (ArrayList<Course> ) oos.readObject();
						students = (ArrayList<Student> ) oos.readObject();
					} catch (ClassNotFoundException | IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					  return students;
	}
	
	public static void save() {
		  try (
				  FileOutputStream fos = new FileOutputStream("res\\\\Registration.dat");
			      ObjectOutputStream oos = new ObjectOutputStream(fos);
			      ){
				  oos.writeObject(CommonClass.courseList);
				  oos.writeObject(CommonClass.studentList) ;
				  for ( int i = 0 ; i<  CommonClass.courseList.size(); i++)
					  System.out.println(CommonClass.courseList.get(i));
				  
			  }   
			  
			  
			  catch (FileNotFoundException  ex) {
			      System.out.println(ex.getMessage());
			  }

			  catch (IOException ex) {
			      System.out.println(ex.getMessage());
			      
		  
		  
			  }
	}
	
	
	//public static ArrayList<String> getRegisteredId(Course course){
		//for(Course e:)
	//}
}