/**
 * 
 */
package javafinalproject;



/*** scenario 1 using abstract class*/
abstract class User {
	private String name;
	private String email;
	private int userID;
	
// using constructor for initialization
	public User(String name,String email,int userID)
	{
		this.name = name;
		this.email = email;
		this.userID = userID;
	}
	public abstract void viewProfile(); //abstract method
	
	public final void displayWelcome() //final method which cannot be overridden
	{  
		System.out.println("final method cannot be overridden");
	}
	//Using getters for all the fields declared
	public String getName() 
	{ 
		return name; 
	}
	public String getEmail() 
	{ 
		return email; 
	}
	public int getUserId() 
	{ 
		return userID; 
	}
	// using setters for all the fields declared
    public void setName(String name) 
    { 
    	this.name = name; 
    }
    public void setEmail(String email) 
    { 
    	this.email = email; 
    }
    public void setUserId(int userId) 
    { 
    	this.userID = userId; 
    }
}
/*** scenario 2 class Student extends User implements ProgressTrackable*/

class Student extends User implements ProgressTrackable
{
	private String EnrolledCourse1 ;
	private String EnrolledCourse2;
	
//constructor using super keyword
	public Student(String name, String email, int userId) {
        super(name, email, userId);
        this.EnrolledCourse1 = null;
        this.EnrolledCourse2 = null;
	}
	public void EnrolledCourse(String coursename)
	{
		if(this.EnrolledCourse1==null)
		{
			this.EnrolledCourse1= coursename;
			System.out.println("Student " + getName() + "has enrolled the course : "  + coursename + ".");
		}
		else if(this.EnrolledCourse2==null)
		{
			this.EnrolledCourse2= coursename;
			System.out.println("Student" + getName() + "has created the course : "  + coursename + ".");
	    }
		else {
			System.out.println("students" +getName() + "cannot enroll more than 2 courses" + ".");
		}
	}
		//getters and setters
		  public String getEnrolledCourse1() { return EnrolledCourse1; }
		  public void setEnrolledCourse1(String course) { this.EnrolledCourse1 = course; }
		  public String getEnrolledCourse2() { return EnrolledCourse2; }
		  public void setEnrolledCourse2(String course) { this.EnrolledCourse2 = course; }
//Overriding
	public void viewProfile() {
        System.out.println(" Student Profile :");
        System.out.println("name: " + getName());
        System.out.println("email: " + getEmail());
        System.out.println("userID: " + getUserId());
        System.out.println("Enrolled Course 1: " + (EnrolledCourse1 != null ? EnrolledCourse1 : "None"));
        System.out.println("Enrolled Course 2: " + (EnrolledCourse2 != null ? EnrolledCourse2 : "None"));
    }
	public void trackProgress() {
    System.out.println(getName() + " is tracking progress in enrolled courses.");
}
}
/*** scenario 3 class Instructor extends User **/

class Instructor extends User {
    private String createdCourse1;
    private String createdCourse2;

    public Instructor(String name, String email, int userId) {
        super(name, email, userId);
        this.createdCourse1 = null;
        this.createdCourse2 = null;
    }

    public void createCourse(String courseName) {
        if (createdCourse1 == null) {
            this.createdCourse1 = courseName;
        } else if (createdCourse2 == null) {
            this.createdCourse2 = courseName;
        } else {
            System.out.println("Cannot create more than 2 courses.");
        }
    }
  //getters and setters
	  public String getcreatedCourse1() { return createdCourse1; }
	  public void setcreatedCourse1(String course) { this.createdCourse1 = course; }
	  public String getcreatedCourse2() { return createdCourse2; }
	  public void setcreatedCourse2(String course) { this.createdCourse2 = course; }
//Overriding
public void viewProfile() {
  System.out.println(" Instructor Profile :");
  System.out.println("name: " + getName());
  System.out.println("email: " + getEmail());
  System.out.println("userID: " + getUserId());
  System.out.println("Created Course 1: " + (createdCourse1 != null ? createdCourse1 : "None"));
  System.out.println("Created Course 2: " + (createdCourse2 != null ? createdCourse2 : "None"));
}
}
/*** scenario  4 class Admin extends User **/
class Admin extends User {
    public Admin(String name, String email, int userID) {
        super(name, email, userID);
    }
    public void removeUser(User user) {
        System.out.println("User removed: " + user.getName());
    }
    // Override
    public void viewProfile() {
        System.out.println("Admin Profile:");
        System.out.println("Name: " + getName());
        System.out.println("Email: " + getEmail());
        System.out.println("UserID: " + getUserId());
    }
}
/*** scenario  5 interface ProgressTrackable**/
interface ProgressTrackable {
    void trackProgress();
 }
/*** scenario  6 class Course  **/
class Course {
    private String title;
    private int durationInHours;
    private final int maxStudents;

    public Course(String title, int durationInHours, int maxStudents) {
        this.title = title;
        this.durationInHours = durationInHours;
        this.maxStudents = maxStudents;
    }

    public Course(String title) {
        this(title, 20, 50); // default duration and students
    }

    public void showCourseDetails() {
        System.out.println("Course Title: " + title);
        System.out.println("Duration: " + durationInHours + " hours");
        System.out.println("Max Students: " + maxStudents);
    }
}
/*** Main Class **/
public class EduSmartLMS {

	public static void main(String[] args) {
		 Student student1 = new Student("ABC", "abc@gmail.com", 01);
	     Student student2 = new Student("XYZ", "xyz@gmail.com", 02);
        
	     Instructor instructor1 = new Instructor("Instructor .ABC", "abc@edusmart.com", 01);
	     Instructor instructor2 = new Instructor("Instructor. XYZ", "xyz@edusmart.com", 02);

	     Admin admin = new Admin("Miss. Admin", "admin@edusmart.com", 123);
	     
	  // Create Courses
	        instructor1.createCourse("Java");
	        instructor1.createCourse("DataStructures");
	        instructor2.createCourse("C++");
	        instructor2.createCourse("C programming");

	  // Enroll Students
	        student1.EnrolledCourse("C");
	        student1.EnrolledCourse("Java");
	        student2.EnrolledCourse("C++");
	        student2.EnrolledCourse("DataStructures");
	        
	     // View Profiles
	        student1.displayWelcome(); 
	        student1.viewProfile();
	        student2.displayWelcome(); 
	        student2.viewProfile();
	        instructor1.displayWelcome();
	        instructor1.viewProfile(); 
	        instructor1.displayWelcome();
	        instructor2.viewProfile(); 
	        admin.viewProfile();

	        // Track Progress
	        student1.trackProgress();
	        student2.trackProgress();

	        // Remove User
	        System.out.println( "Admin Removing a User :");
	        admin.removeUser(student2);
	        
	     // Show Course Details
	        Course c1 = new Course("Java", 40, 100);
	        Course c2 = new Course("DataStructures");
	        c1.showCourseDetails();
	        c2.showCourseDetails();
	    }
}
