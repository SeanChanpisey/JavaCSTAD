package Homework;

import java.io.*;
import java.util.*;

class Course {
    private int courseId;
    private String courseTitle;
    private String courseStartedDate;
    private String courseEndedDate;
    private boolean isAvailable;

    public Course(int courseId, String courseTitle, String courseStartedDate, String courseEndedDate, boolean isAvailable) {
        this.courseId = courseId;
        this.courseTitle = courseTitle;
        this.courseStartedDate = courseStartedDate;
        this.courseEndedDate = courseEndedDate;
        this.isAvailable = isAvailable;
    }

    public Course() {
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public String getCourseStartedDate() {
        return courseStartedDate;
    }

    public void setCourseStartedDate(String courseStartedDate) {
        this.courseStartedDate = courseStartedDate;
    }

    public String getCourseEndedDate() {
        return courseEndedDate;
    }

    public void setCourseEndedDate(String courseEndedDate) {
        this.courseEndedDate = courseEndedDate;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}

interface CourseService {
    void addNewCourse();
    void getAllCourses();
    void getCourseById();
}

class CourseServiceImp implements CourseService {
    private List<Course> courseList;
    private static final String FILE_NAME = "course.csv";

    public CourseServiceImp() {
        courseList = new ArrayList<>();
    }

    @Override
    public void addNewCourse() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter course title: ");
        String title = scanner.nextLine();
        int courseId = courseList.size() + 1;
        String startDate = getCurrentDate();
        String endDate = "";
        boolean isAvailable = true;

        Course course = new Course(courseId, title, startDate, endDate, isAvailable);
        courseList.add(course);

        try {
            FileWriter writer = new FileWriter(FILE_NAME, true);
            writer.write(courseId + "," + title + "," + startDate + "," + endDate + "," + isAvailable + "\n");
            writer.close();
            System.out.println("Course added successfully!");
        } catch (IOException e) {
            System.out.println("Failed to add course.");
        }
    }

    @Override
    public void getAllCourses() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME));
            String line;
            System.out.println("==============================================================");
            System.out.println("Course ID\tCourse Title\tStart Date\tEnd Date\tIs Available");

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                System.out.println(data[0] + "\t\t" + data[1] + "\t\t" + data[2] + "\t" + data[3] + "\t" + data[4]);
                System.out.println("===============================================================");
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Failed to read courses.");
        }
    }

    @Override
    public void getCourseById() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter course ID: ");
        int courseId = scanner.nextInt();
        boolean found = false;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME));
            String line;
            System.out.println("Course ID\tCourse Title\tStart Date\tEnd Date\tIs Available");
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (Integer.parseInt(data[0]) == courseId) {
                    System.out.println(data[0] + "\t\t" + data[1] + "\t\t" + data[2] + "\t" + data[3] + "\t" + data[4]);
                    found = true;
                    break;
                }
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Failed to read courses.");
        }

        if (!found) {
            System.out.println("Course not found.");
        }
    }

    private String getCurrentDate() {
        Date date = new Date();
        return date.toString();
    }
}

class View {
    public static void menu() {
        CourseService courseService = new CourseServiceImp();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("====================================");
            System.out.println("||-- Course Management System --   ||");
            System.out.println("||1. Add New Course                ||");
            System.out.println("||2. Get All Courses               ||");
            System.out.println("||3. Get Course by ID              ||");
            System.out.println("||4.Exit                           ||");
            System.out.println("====================================");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    courseService.addNewCourse();
                    break;
                case 2:
                    courseService.getAllCourses();
                    break;
                case 3:
                    courseService.getCourseById();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        View.menu();
    }
}
