import java.io.*;
import java.util.*;

class StudentRecords {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public void addRecords() throws IOException {
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("st.txt", true)));
        String studentName, address;
        int studentId, rollNo, studentClass;
        float marks;
        boolean addMore = false;
        String s;

        do {
            try {
                System.out.print("Enter Student Name: ");
                studentName = br.readLine();
                System.out.print("Student Id: ");
                studentId = Integer.parseInt(br.readLine());
                System.out.print("Roll no: ");
                rollNo = Integer.parseInt(br.readLine());
                System.out.print("Address: ");
                address = br.readLine();
                System.out.print("Class: ");
                studentClass = Integer.parseInt(br.readLine());
                System.out.print("Marks: ");
                marks = Float.parseFloat(br.readLine());
                pw.println(studentName + " " + studentId + " " + rollNo + " " + address + " " + studentClass + " " + marks);
                System.out.println("Record added successfully!");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter the correct data type.");
                continue;
            }
            System.out.print("Do you want to add more records? (y/n): ");
            s = br.readLine();
            addMore = s.equalsIgnoreCase("y");
        } while (addMore);

        pw.close();
        showMenu();
    }

    public void readRecords() throws IOException {
        try (BufferedReader file = new BufferedReader(new FileReader("st.txt"))) {
            String name;
            while ((name = file.readLine()) != null) {
                System.out.println(name);
            }
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: File not Found!");
        }
        showMenu();
    }

    public void searchRecords() throws IOException {
        try (BufferedReader file = new BufferedReader(new FileReader("st.txt"))) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter the ID of the student you want to search: ");
            String searchId = sc.next();
            String record;
            boolean found = false;
            while ((record = file.readLine()) != null) {
                String[] line = record.split(" ");
                if (searchId.equalsIgnoreCase(line[1])) {
                    System.out.println("Record found: " + record);
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("Record not found.");
            }
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: File not Found!");
        }
        showMenu();
    }

    public void deleteRecords() throws IOException {
        try (BufferedReader file1 = new BufferedReader(new FileReader("st.txt"));
             PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("st1.txt", true)))) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter the name of the student you want to delete: ");
            String searchName = sc.next();
            String record;
            boolean found = false;
            while ((record = file1.readLine()) != null) {
                String[] line = record.split(" ");
                if (!searchName.equalsIgnoreCase(line[0])) {
                    pw.println(record);
                } else {
                    System.out.println("Record found and deleted.");
                    found = true;
                }
            }
            if (!found) {
                System.out.println("Record not found.");
            }
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: File not Found!");
        }
        replaceOldFile();
        showMenu();
    }

    public void updateRecords() throws IOException {
        try (BufferedReader file1 = new BufferedReader(new FileReader("st.txt"));
             PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("st1.txt", true)))) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter the name of the student you want to update: ");
            String searchName = sc.next();
            String record;
            boolean found = false;
            while ((record = file1.readLine()) != null) {
                String[] line = record.split(" ");
                if (!searchName.equalsIgnoreCase(line[0])) {
                    pw.println(record);
                } else {
                    System.out.println("Record found.");
                    System.out.print("Enter updated marks: ");
                    float updatedMarks = Float.parseFloat(sc.next());
                    pw.println(line[0] + " " + line[1] + " " + line[2] + " " + line[3] + " " + line[4] + " " + updatedMarks);
                    found = true;
                }
            }
            if (!found) {
                System.out.println("Record not found.");
            }
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: File not Found!");
        }
        replaceOldFile();
        showMenu();
    }

    private void replaceOldFile() {
        File delName = new File("st.txt");
        File oldName = new File("st1.txt");
        if (delName.delete()) {
            oldName.renameTo(delName);
        }
    }

    public void clear(String filename) throws IOException {
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(filename)));
        pw.close();
        System.out.println("All Records cleared successfully!");
        showMenu();
    }

    public void showMenu() throws IOException {
        System.out.println("You have following operations to perform on File:");
        System.out.println("1. Add Records");
        System.out.println("2. Display Records");
        System.out.println("3. Clear All Records");
        System.out.println("4. Search Records");
        System.out.println("5. Delete Records");
        System.out.println("6. Update Records");
        System.out.println("7. Exit");
        System.out.print("Enter your choice: ");
        int choice = Integer.parseInt(br.readLine());
        switch (choice) {
            case 1: addRecords(); break;
            case 2: readRecords(); break;
            case 3: clear("st.txt"); break;
            case 4: searchRecords(); break;
            case 5: deleteRecords(); break;
            case 6: updateRecords(); break;
            case 7: System.exit(0); break;
            default: System.out.println("Invalid choice!"); showMenu(); break;
        }
    }

    public static void main(String[] args) throws IOException {
        StudentRecords call = new StudentRecords();
        call.showMenu();
    }
}
//save file as= StudentRecords.java
//compile commond= javac StudentRecords.java
//run commond= java StudentRecords
