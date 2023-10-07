package J1LP0021;

import J1LP0022.model.Candidate;

import java.util.*;
import java.util.function.Predicate;

/**
 * @author UyenNguyễn
 */
public class Manager {
    Display display = new Display();
    public static ArrayList<Student> students = new ArrayList<>();

    void getMenu() {
        int choice;
        do {
            display.displayMenu();
            choice = Input.enterInt("", 1, 5);
            switch (choice) {
                case 1:
                    createStudent();
                    break;
                case 2:
                    display.displayList(students, "student_list");
                    searchAndSort();
                    break;
                case 3:
                    updateOrDelete();
                    break;
                case 4:
                    report();
                    break;
            }

        }
        while (choice < 5);
    }

    String getCourse() {
        int choice;
        String course = "";
        display.displayCouseMenu();
        choice = Input.enterInt("", 1, 3);
        switch (choice) {
            case 1:
                course = "Java";
                break;
            case 2:
                course = ".Net";
                break;
            case 3:
                course = "C/C++";
                break;
        }
        return course;
    }

    //  Predicate<Student> isCollidedPredicate = student -> checkingID.equals(student.getId()) &&
//            checkingSemester.equals(student.getSemester()) &&
//            checkingCourseName.equals(student.getCourseName());
//    private boolean isCollided(String checkingID, String checkingSemester, String checkingCourseName, ArrayList<Student> studentList) {
//        return studentList.stream().anyMatch(isCollidedPredicate);
//    }
    public ArrayList<Student> search(Predicate<Student> p) {
        ArrayList<Student> students = new ArrayList<>();
        for (Student s : students) {
            if (p.test(s)) {
                students.add(s);
            }
        }
        return students;
    }

    public boolean isCorrect(String cID, String cSe, String cCour) {
        ArrayList<Student> searchId = search(i -> i.getId().equals(cID));
        ArrayList<Student> searchSe = search(i -> i.getSemester().equals(cSe));
        ArrayList<Student> searchCour = search(i -> i.getCourse().equals(cCour));
        if (searchId.isEmpty() && searchSe.isEmpty() && searchCour.isEmpty()) {
            return false;
        }
        return true;
    }

    public void createStudent() {
        do {
            try {
                int count = 0;
                String flag = "";
                String name;
                if (students.size() >= 10) {
                    System.out.print("Do you want to continue (Y/N): ");
                    boolean continueAdding = Input.checkInputYN("Enter y/Y to continue, n/N for back to screen.", Validator.REGEX_YN, "n");
                    if (continueAdding) {
                        break;
                    }

                }
                String id = Input.enterString("Id", Validator.REGEX_NOSPECIAL);

                for (Student st : students) {
                    if (st.getId().equals(id)) {
                        count++;
                        flag = st.getName();
                    }
                }
                if (count > 0) {
                    System.out.print("Do you want to continue (Y/N): ");
                    Boolean continueAdding = Input.checkInputYN("Enter y/Y to continue, n/N for back to screen.", Validator.REGEX_YN, "n");
                    if (continueAdding) {
                        break;
                    }
                    name = flag;
                } else {
                    name = Input.enterString("Name ", Validator.REGEX_FULL_NAME_VN);
                }
                String semester = Input.enterString("Semester", Validator.REGEX_NOSPECIAL);
                String course = getCourse();
                if (isCorrect(id, semester, course)) {
                    throw new Exception(name + " (ID: " + id + ") "
                            + "already registered " + course
                            + " for semester " + semester);
                } else {
                    students.add(new Student(id, name, semester, course));
                    System.out.println("Created new student successfully");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

        }
        while (true);
    }

    void searchAndSort() {
        String name = Input.enterString("Name", Validator.REGEX_NOSPECIAL);
        ArrayList<Student> searchResult = new ArrayList<>();
        students.forEach(i -> {
            if (i.getName().contains(name)) {
                searchResult.add(i);
            }
        });
        Collections.sort(searchResult, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getName().compareToIgnoreCase(o2.getName());
            }
        });
        if (searchResult.isEmpty()) {
            System.out.println("don't found the same name in list");
        } else {
            searchResult.forEach(i -> System.out.println(i));
        }
    }

    private void updateStudent(Student updatingStudent) {
        int count = 0;
        boolean isUsingStudent = false;
        String inputID, inputName = null, inputCourse, inputSemester;
        String studentCourse, studentSemester;
        System.out.println("(+) Updating for:");
        System.out.format("\t%5s%20s%10s%10s\n", "ID", "Name", "Semester", "Course");
        System.out.println("\t" + updatingStudent);

        inputID = Input.enterString("Id", Validator.REGEX_ID);
        for (Student st : students) {
            if (st.getId().equals(inputID)) {
                count++;
            }
        }
        if (inputID.equals(updatingStudent.getId())) {
            isUsingStudent = true;
        }

        if (isUsingStudent) {
            inputName = updatingStudent.getName();
        } else {
            if (count >= 0) {
                inputName = students.get(count).getName();
            } else {
                inputName = Input.enterString("Enter name: ", Validator.REGEX_FULL_NAME_VN);
            }
        }
        inputSemester = Input.enterString("Semester: ", Validator.REGEX_NOSPECIAL);
        inputCourse = getCourse();

        studentCourse = updatingStudent.getName();
        studentSemester = updatingStudent.getSemester();

        if (isUsingStudent && inputSemester.equals(studentSemester)
                && inputCourse.equals(studentCourse)) {

            System.out.println("Update student successfully !");
        } else {

            if (!isCorrect(inputID, inputSemester, inputCourse)) {
                updatingStudent.setId(inputID);
                updatingStudent.setName(inputName);
                updatingStudent.setSemester(inputSemester);
                updatingStudent.setName(inputCourse);
                System.out.println("Update student successfully !");
            } else {
                System.out.println("These input information above is collided "
                        + "with another record !");
            }
        }
    }


    private void deleteStudent(Student deletingStudent) {
        students.remove(deletingStudent);
        System.out.println("Remove student successfully !");
    }

    void updateOrDelete() {
        String searchingID, userChoice;
        Student studentChoice;
        int count = 0;
        ArrayList<Student> studentResults = new ArrayList<>();
        do {
            try {
                display.displayList(students, "student_list");
                searchingID = Input.enterString("Id", Validator.REGEX_ID);

                for (Student st : students) {
                    if (st.getId().equals(searchingID)) {
                        count++;
                        studentResults.add(st);
                    }
                }
                if (count == 0) {
                    System.out.println("There is no student has this ID !");
                }
                display.displayList(studentResults, "update_or_delete_list");

                //Check if student result list size greater than 1
                if (studentResults.size() > 1) {

                    int userRowChoice = Input.enterInt("Enter student row number: ",
                            1, studentResults.size());

                    studentChoice = studentResults.get(userRowChoice - 1);
                } else {
                    studentChoice = studentResults.get(0);
                }

                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (true); //Loop while true

        userChoice = Input.enterString("Do you want to update (U) or delete (D) "
                + "student: ", Validator.REGEX_UD);

        //Check if user choice equals "U"
        if (userChoice.equals("U")) {
            updateStudent(studentChoice);
        } else {
            deleteStudent(studentChoice);
        }

        display.displayList(students, "student_list");
    }

    void report() {
        ArrayList<String> list = new ArrayList<>();
        Set<String> set = null;
        if (students.isEmpty()) {
            System.out.println("Student list is empty!");
            return;
        }

        //Loop to get each student in student list
        students.forEach(student -> {
            list.add(String.format("%10s - %15s | %10s", student.getId(), student.getName(),
                    student.getCourse()));
        });

        set = new HashSet<>(list);
        set.forEach((row) -> {
            System.out.println(row.split("-")[1] + " | " + Collections.frequency(list, row));
        });
    }
}
