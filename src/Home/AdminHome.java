package Home;

import static Components.UtilityMethods.*;
import Components.UtilityMethods.DefaultFocus;
import static Components.UtilityMethods.DefaultText;
import static Components.UtilityMethods.TransparentField;
import Login.StartFrame;
import Signup.InstructorCreateAccount1Frame;
import java.awt.PopupMenu;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class AdminHome extends javax.swing.JFrame {

    public AdminHome() {
        initComponents();
        TransparentField2(coursesearch_bar);
        displayDataInTable();

    }

    private void displayDataInTable() {
        String query = "SELECT * FROM tb_subjects";

        String url = "jdbc:mysql://localhost:3306/lms_project";
        String user = "root";
        String pass = "";

        try (Connection con = DriverManager.getConnection(url, user, pass); PreparedStatement pst = con.prepareStatement(query); ResultSet rs = pst.executeQuery()) {

            // Create a DefaultTableModel to hold the data
            DefaultTableModel model = (DefaultTableModel) CoursesTable.getModel();

            // Clear the existing rows in the table model before adding new ones
            model.setRowCount(0);
            while (rs.next()) {

                String courseCode = rs.getString("CourseCode");
                String courseName = rs.getString("CourseName");
                String credits = rs.getString("Credits");
                String year = rs.getString("Year");
                String sem = rs.getString("Semester");

                model.addRow(new Object[]{courseCode, courseName, credits, year, sem});
            }

            // Refresh JTable UI
            CoursesTable.revalidate();
            CoursesTable.repaint();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(new JFrame(), "Error fetching data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void filterData(String selectedYear, String selectedSemester) {
        // Construct the query based on selected Year and Semester
        String query = "SELECT * FROM tb_subjects WHERE 1=1"; // Default query to show all records

        if (selectedYear != null && !selectedYear.isEmpty() && !selectedYear.equals("All")) {
            // Add year filter if not "All" (if you have a default "All" option in the combobox)
            query += " AND Year = '" + selectedYear + "'";
        }

        if (selectedSemester != null && !selectedSemester.isEmpty() && !selectedSemester.equals("All")) {
            // Add semester filter if not "All"
            query += " AND Semester = '" + selectedSemester + "'";
        }

        // Now, apply the query to fetch filtered data from the database
        updateTable(query);
    }

    private void updateTable(String query) {
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lms_project", "root", ""); PreparedStatement pst = con.prepareStatement(query); ResultSet rs = pst.executeQuery()) {

            // Get the table model
            DefaultTableModel model = (DefaultTableModel) CoursesTable.getModel();

            // Clear existing rows before inserting new filtered rows
            model.setRowCount(0);

            // Loop through result set and add rows to the table model
            while (rs.next()) {
                String courseCode = rs.getString("CourseCode");
                String courseName = rs.getString("CourseName");
                String credits = rs.getString("Credits");
                String year = rs.getString("Year");
                String semester = rs.getString("Semester");

                model.addRow(new Object[]{courseCode, courseName, credits, year, semester});
            }

            // Refresh the JTable to reflect new data
            CoursesTable.revalidate();
            CoursesTable.repaint();

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error fetching data: " + e.getMessage());
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panels = new javax.swing.JTabbedPane();
        users = new javax.swing.JPanel();
        user_tables = new javax.swing.JTabbedPane();
        student = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        student_form = new javax.swing.JPanel();
        addstudent_btn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        studentname_field = new javax.swing.JTextField();
        studentnumber_field = new javax.swing.JTextField();
        studentemail_field = new javax.swing.JTextField();
        course_cbox = new javax.swing.JComboBox<>();
        studentpass_field = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        usersearch_bar = new javax.swing.JTextField();
        instructor = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        instructor_form = new javax.swing.JPanel();
        addinstructor_btn = new javax.swing.JButton();
        updateinstructor_btn = new javax.swing.JButton();
        deleteinstructor_btn = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        instructorname_field = new javax.swing.JTextField();
        employeeID_field = new javax.swing.JTextField();
        studentemail_field1 = new javax.swing.JTextField();
        department_cbox = new javax.swing.JComboBox<>();
        instructorpass_field = new javax.swing.JPasswordField();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        search = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        student_btn = new javax.swing.JButton();
        instructor_btn = new javax.swing.JButton();
        courses = new javax.swing.JPanel();
        course_form = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        credits = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        coursecode_field = new javax.swing.JTextField();
        credits_field = new javax.swing.JTextField();
        sem_cbox = new javax.swing.JComboBox<>();
        year_cbox = new javax.swing.JComboBox<>();
        jLabel22 = new javax.swing.JLabel();
        deletecourse_btn = new javax.swing.JButton();
        addcourse_btn = new javax.swing.JButton();
        updatecourse_btn = new javax.swing.JButton();
        coursetitle_field = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        user_btn = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        course_btn = new javax.swing.JButton();
        logout_btn = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        CoursesTable = new javax.swing.JTable();
        coursesearch_bar = new javax.swing.JTextField();
        searchyear_cbox = new javax.swing.JComboBox<>();
        searchsem_cbox = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Learning Management System - Admin Home");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        users.setBackground(new java.awt.Color(153, 153, 153));
        users.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        student.setBackground(new java.awt.Color(204, 204, 204));
        student.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Student table");
        student.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 40));

        student_form.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        addstudent_btn.setText("Add Student");
        student_form.add(addstudent_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 260, -1));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel2.setText("Name:");
        student_form.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 80, 20));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel4.setText("Student No.:");
        student_form.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 80, 20));

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel5.setText("CvSU Mail:");
        student_form.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 80, 20));

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel6.setText("Course:");
        student_form.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 80, 20));

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel7.setText("Password:");
        student_form.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 80, 20));
        student_form.add(studentname_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, 180, -1));
        student_form.add(studentnumber_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, 180, -1));
        student_form.add(studentemail_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 150, 180, -1));

        course_cbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "BS in Computer Science" }));
        student_form.add(course_cbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 190, 180, -1));
        student_form.add(studentpass_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 230, 180, -1));

        jButton1.setText("Update Student");
        student_form.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 260, -1));

        jButton2.setText("Delete Student");
        student_form.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 260, -1));

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Student Form");
        student_form.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 280, 40));

        student.add(student_form, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 280, 370));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Name", "Student Number", "CvSU Email", "Course"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        student.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 50, 650, 370));

        usersearch_bar.setText("search bar");
        student.add(usersearch_bar, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 15, 260, 30));

        user_tables.addTab("tab1", student);

        instructor.setBackground(new java.awt.Color(204, 204, 204));
        instructor.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setText("Instructor table");
        instructor.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 40));

        instructor_form.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        addinstructor_btn.setText("Add Instructor");
        instructor_form.add(addinstructor_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 260, -1));

        updateinstructor_btn.setText("Update Instructor");
        instructor_form.add(updateinstructor_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 260, -1));

        deleteinstructor_btn.setText("Delete Instructor");
        instructor_form.add(deleteinstructor_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 260, -1));

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel9.setText("Name:");
        instructor_form.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 80, 20));

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel10.setText("CvSU Mail:");
        instructor_form.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 80, 20));

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel11.setText("Employee ID:");
        instructor_form.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 80, 20));

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel12.setText("Department:");
        instructor_form.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 80, 20));

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel13.setText("Password:");
        instructor_form.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 80, 20));
        instructor_form.add(instructorname_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, 180, -1));
        instructor_form.add(employeeID_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, 180, -1));
        instructor_form.add(studentemail_field1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 150, 180, -1));

        department_cbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "DIT" }));
        instructor_form.add(department_cbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 190, 180, -1));
        instructor_form.add(instructorpass_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 230, 180, -1));

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Instructor Form");
        instructor_form.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 280, 40));

        instructor.add(instructor_form, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 280, 370));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Name", "CvSU Email", "Employee ID", "Department"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        instructor.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 50, 650, 370));

        search.setText("search bar");
        instructor.add(search, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 15, 260, 30));

        jPanel3.setBackground(new java.awt.Color(204, 204, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        student_btn.setText("Students");
        student_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                student_btnActionPerformed(evt);
            }
        });
        jPanel3.add(student_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, -1, 40));

        instructor_btn.setText("Instructors");
        instructor_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                instructor_btnActionPerformed(evt);
            }
        });
        jPanel3.add(instructor_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 0, -1, 40));

        instructor.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 960, 40));

        user_tables.addTab("tab2", instructor);

        users.add(user_tables, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 960, 460));

        panels.addTab("tab1", users);

        courses.setBackground(new java.awt.Color(153, 153, 153));
        courses.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        course_form.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel19.setText("Semester:");
        course_form.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 90, 20));

        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel18.setText("Course Code:");
        course_form.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 90, 20));

        credits.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        credits.setText("Credits:");
        course_form.add(credits, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 90, 20));

        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel21.setText("Year:");
        course_form.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 90, 20));
        course_form.add(coursecode_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, 170, -1));
        course_form.add(credits_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, 170, -1));

        sem_cbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1st", "2nd" }));
        course_form.add(sem_cbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 210, 170, 20));

        year_cbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1st", "2nd", "3rd", "Midyear", "4th" }));
        course_form.add(year_cbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, 170, 20));

        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("Course Table");
        course_form.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 280, 40));

        deletecourse_btn.setText("Delete Course");
        deletecourse_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletecourse_btnActionPerformed(evt);
            }
        });
        course_form.add(deletecourse_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 260, -1));

        addcourse_btn.setText("Add Course");
        addcourse_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addcourse_btnActionPerformed(evt);
            }
        });
        course_form.add(addcourse_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 260, -1));

        updatecourse_btn.setText("Update Course");
        updatecourse_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatecourse_btnActionPerformed(evt);
            }
        });
        course_form.add(updatecourse_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 260, -1));
        course_form.add(coursetitle_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, 170, -1));

        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel25.setText("Course Title:");
        course_form.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 90, 20));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        user_btn.setText("Users");
        user_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                user_btnActionPerformed(evt);
            }
        });
        jPanel2.add(user_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, 220, 30));

        jLabel3.setFont(new java.awt.Font("Copperplate Gothic Light", 1, 18)); // NOI18N
        jLabel3.setText("Hello, Admin!");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 170, 30));

        course_btn.setText("Courses");
        course_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                course_btnActionPerformed(evt);
            }
        });
        jPanel2.add(course_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 10, 220, 30));

        logout_btn.setText("Logout");
        logout_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logout_btnActionPerformed(evt);
            }
        });
        jPanel2.add(logout_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(882, 10, 90, 30));

        course_form.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 360, 980, 60));

        courses.add(course_form, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 280, 460));

        CoursesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Course Code", "Course Title", "Credits", "Year", "Semester"
            }
        ));
        CoursesTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CoursesTableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(CoursesTable);

        courses.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 60, 670, 420));

        coursesearch_bar.setText("Enter Course Code / Title");
        coursesearch_bar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                coursesearch_barFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                coursesearch_barFocusLost(evt);
            }
        });
        coursesearch_bar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                coursesearch_barKeyReleased(evt);
            }
        });
        courses.add(coursesearch_bar, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 20, 230, 30));

        searchyear_cbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "1st", "2nd", "3rd", "4th" }));
        searchyear_cbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchyear_cboxActionPerformed(evt);
            }
        });
        courses.add(searchyear_cbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 20, 110, 30));

        searchsem_cbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "1st", "2nd" }));
        searchsem_cbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchsem_cboxActionPerformed(evt);
            }
        });
        courses.add(searchsem_cbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 20, 110, 30));

        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel16.setText("Search");
        courses.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 20, 40, 30));

        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel17.setText("Year");
        courses.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 20, 40, 30));

        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel23.setText("Sem");
        courses.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 20, 40, 30));

        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel24.setText("Sem");
        courses.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 20, 40, 30));

        panels.addTab("tab2", courses);

        jPanel1.add(panels, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 980, 530));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 980, 540));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void user_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_user_btnActionPerformed
        panels.setSelectedIndex(0);
    }//GEN-LAST:event_user_btnActionPerformed

    private void course_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_course_btnActionPerformed

        panels.setSelectedIndex(1);
    }//GEN-LAST:event_course_btnActionPerformed

    private void logout_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logout_btnActionPerformed
        int confirmLogout = JOptionPane.showConfirmDialog(null,
                "Are you sure you want to logout?",
                "Logout",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE);

        if (confirmLogout == JOptionPane.YES_OPTION) {
            dispose();
            new StartFrame().setVisible(true);
        }
    }//GEN-LAST:event_logout_btnActionPerformed

    private void student_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_student_btnActionPerformed
        user_tables.setSelectedIndex(0);
    }//GEN-LAST:event_student_btnActionPerformed

    private void instructor_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_instructor_btnActionPerformed
        user_tables.setSelectedIndex(1);
    }//GEN-LAST:event_instructor_btnActionPerformed

    private void addcourse_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addcourse_btnActionPerformed
        String CourseCode;
        String CourseName;
        String Credit;
        String Year;
        String Sem;
        String query;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InstructorCreateAccount1Frame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(new JFrame(), "Database connection failed: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        String url = "jdbc:mysql://localhost:3306/lms_project";
        String user = "root";
        String pass = "";

        boolean isValid = true;

        Connection con = null;
        try {
            con = DriverManager.getConnection(url, user, pass);
        } catch (SQLException ex) {
            Logger.getLogger(InstructorCreateAccount1Frame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(new JFrame(), "Database connection failed: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

// Validation for empty fields
        if (coursecode_field.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(new JFrame(), "Course Code is required", "Dialog", JOptionPane.ERROR_MESSAGE);
            isValid = false;
        } else if (coursetitle_field.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(new JFrame(), "Course Title is required", "Dialog", JOptionPane.ERROR_MESSAGE);
            isValid = false;
        } else if (credits_field.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(new JFrame(), "Credit is required", "Dialog", JOptionPane.ERROR_MESSAGE);
            isValid = false;
        } else if (year_cbox.getSelectedItem().toString().isEmpty()) {
            JOptionPane.showMessageDialog(new JFrame(), "Year Level is required", "Dialog", JOptionPane.ERROR_MESSAGE);
            isValid = false;
        } else if (sem_cbox.getSelectedItem().toString().isEmpty()) {
            JOptionPane.showMessageDialog(new JFrame(), "Semester is required", "Dialog", JOptionPane.ERROR_MESSAGE);
            isValid = false;
        }

        if (isValid) {
            // Retrieve input values
            CourseCode = coursecode_field.getText().trim();
            CourseName = coursetitle_field.getText().trim();
            Credit = credits_field.getText().trim(); // Store as String initially

            Year = (String) year_cbox.getSelectedItem();
            Sem = (String) sem_cbox.getSelectedItem();

            // Proceed if all inputs are valid
            if (isValid) {
                query = "INSERT INTO tb_subjects (CourseCode, CourseName, Credits, Year, Semester) VALUES (?, ?, ?, ?, ?)";
                try {
                    PreparedStatement pst = con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
                    pst.setString(1, CourseCode);
                    pst.setString(2, CourseName);
                    pst.setString(3, Credit);  // Store Credit as int (converted from String)
                    pst.setString(4, Year);
                    pst.setString(5, Sem);

                    pst.executeUpdate();

                    JOptionPane.showMessageDialog(new JFrame(), "Course added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);

                    displayDataInTable();  // Update the table with the newly added course

                } catch (SQLException e) {
                    System.out.println("Error " + e.getMessage());
                    JOptionPane.showMessageDialog(new JFrame(), "Database connection failed: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_addcourse_btnActionPerformed

    private void updatecourse_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatecourse_btnActionPerformed
        String updCode = null;
        String updTitle = null;
        String updCredits = null;
        String updYear = null;
        String updSem = null;

        DefaultTableModel model = (DefaultTableModel) CoursesTable.getModel();

        if (CoursesTable.getSelectedRowCount() == 1) {

            // kukunin yung nasa table tas ilalagay sa jtextfield para maedit
            updCode = coursecode_field.getText();
            updTitle = coursetitle_field.getText();
            updCredits = credits_field.getText();
            updYear = (String) year_cbox.getSelectedItem();
            updSem = (String) sem_cbox.getSelectedItem();

            if (updCode.isEmpty() || updTitle.isEmpty() || updCredits.isEmpty() || updYear == null || updSem == null) {
                JOptionPane.showMessageDialog(null, "Please fill in all fields!");
                return;
            }

            model.setValueAt(updCode, CoursesTable.getSelectedRow(), 0);
            model.setValueAt(updTitle, CoursesTable.getSelectedRow(), 1);
            model.setValueAt(updCredits, CoursesTable.getSelectedRow(), 2);
            model.setValueAt(updYear, CoursesTable.getSelectedRow(), 3);
            model.setValueAt(updSem, CoursesTable.getSelectedRow(), 4);

            JOptionPane.showMessageDialog(null, "Updated Successfully!");

        } else if (CoursesTable.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "The table has no values!");
        } else {
            JOptionPane.showMessageDialog(null, "Select a single row for update");
        }

        // Database connection parameters
        String dbUrl = "jdbc:mysql://localhost:3306/lms_project";
        String dbUser = "root";
        String dbPassword = "";

        // SQL Update query
        String updateQuery = "UPDATE tb_subjects SET CourseName = ?, Credits = ?, Year = ?, Semester = ? WHERE CourseCode = ?";

        try (Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword); PreparedStatement pst = conn.prepareStatement(updateQuery)) {

            // Set the parameters for the SQL update
            pst.setString(1, updTitle);
            pst.setString(2, updCredits);
            pst.setString(3, updYear);
            pst.setString(4, updSem);
            pst.setString(5, updCode);

            // Execute the update
            int rowsAffected = pst.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Database updated successfully.");
            } else {
                System.out.println("No records updated.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error updating the database!");
        }


    }//GEN-LAST:event_updatecourse_btnActionPerformed

    private void deletecourse_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletecourse_btnActionPerformed
        DefaultTableModel model = (DefaultTableModel) CoursesTable.getModel();

        // Get the selected row index
        int selectedRow = CoursesTable.getSelectedRow();

        // Check if a row is selected
        if (selectedRow != -1) {
            // Get the CourseCode from the selected row (assuming it's in the first column)
            String delCode = model.getValueAt(selectedRow, 0).toString();

            // Remove the row from the JTable
            model.removeRow(selectedRow);

            // Now delete the course from the database
            deleteCourseFromDatabase(delCode);

            // Show a success message
            JOptionPane.showMessageDialog(null, "Course deleted successfully!");
        } else {
            // Handle the case where no row is selected
            if (CoursesTable.getRowCount() == 0) {
                JOptionPane.showMessageDialog(null, "The table has no values.");
            } else {
                JOptionPane.showMessageDialog(null, "Select a single row for deletion.");
            }
        }
    }

    private void deleteCourseFromDatabase(String courseCode) {
        // Database connection parameters
        String dbUrl = "jdbc:mysql://localhost:3306/lms_project";
        String dbUser = "root";
        String dbPassword = "";

        // SQL Delete query
        String deleteQuery = "DELETE FROM tb_subjects WHERE CourseCode = ?";

        try (Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword); PreparedStatement pst = conn.prepareStatement(deleteQuery)) {

            // Set the parameters for the SQL delete
            pst.setString(1, courseCode);

            // Execute the delete query
            int rowsAffected = pst.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Database row deleted successfully.");
            } else {
                System.out.println("No records deleted.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error deleting the course from the database!");
        }


    }//GEN-LAST:event_deletecourse_btnActionPerformed

    private void coursesearch_barFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_coursesearch_barFocusGained
        DefaultText2(coursesearch_bar, "Enter Course Code / Title", DefaultFocus.GAINED);
    }//GEN-LAST:event_coursesearch_barFocusGained

    private void coursesearch_barFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_coursesearch_barFocusLost
        DefaultText2(coursesearch_bar, "Enter Course Code / Title", DefaultFocus.LOST);
    }//GEN-LAST:event_coursesearch_barFocusLost

    private void coursesearch_barKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_coursesearch_barKeyReleased
//        String yearFilter = (String) searchyear_cbox.getSelectedItem();
//        String semFilter = (String) searchsem_cbox.getSelectedItem();
//        String searchText = coursesearch_bar.getText();
//
//        applyFilters(searchText, yearFilter, semFilter);

        DefaultTableModel model = (DefaultTableModel) CoursesTable.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        CoursesTable.setRowSorter(sorter);

        // Apply a case-insensitive regex filter with the (?i) flag
        sorter.setRowFilter(RowFilter.regexFilter("(?i)" + coursesearch_bar.getText()));


    }//GEN-LAST:event_coursesearch_barKeyReleased

    private void CoursesTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CoursesTableMouseClicked
        DefaultTableModel model = (DefaultTableModel) CoursesTable.getModel();

        String Code = model.getValueAt(CoursesTable.getSelectedRow(), 0).toString();
        String Title = model.getValueAt(CoursesTable.getSelectedRow(), 1).toString();
        String Credits = model.getValueAt(CoursesTable.getSelectedRow(), 2).toString();
        String Year = model.getValueAt(CoursesTable.getSelectedRow(), 3).toString();
        String Sem = model.getValueAt(CoursesTable.getSelectedRow(), 4).toString();

        coursecode_field.setText(Code);
        coursetitle_field.setText(Title);
        credits_field.setText(Credits);
        year_cbox.setSelectedItem(Year);
        sem_cbox.setSelectedItem(Sem);


    }//GEN-LAST:event_CoursesTableMouseClicked

    private void searchyear_cboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchyear_cboxActionPerformed
        String selectedYear = (String) searchyear_cbox.getSelectedItem();
        String selectedSemester = (String) searchsem_cbox.getSelectedItem();

        filterData(selectedYear, selectedSemester);

    }//GEN-LAST:event_searchyear_cboxActionPerformed

    private void searchsem_cboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchsem_cboxActionPerformed
        String selectedYear = (String) searchyear_cbox.getSelectedItem();
        String selectedSemester = (String) searchsem_cbox.getSelectedItem();

        filterData(selectedYear, selectedSemester);

    }//GEN-LAST:event_searchsem_cboxActionPerformed

    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AdminHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminHome().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable CoursesTable;
    private javax.swing.JButton addcourse_btn;
    private javax.swing.JButton addinstructor_btn;
    private javax.swing.JButton addstudent_btn;
    private javax.swing.JButton course_btn;
    private javax.swing.JComboBox<String> course_cbox;
    private javax.swing.JPanel course_form;
    private javax.swing.JTextField coursecode_field;
    private javax.swing.JPanel courses;
    private javax.swing.JTextField coursesearch_bar;
    private javax.swing.JTextField coursetitle_field;
    private javax.swing.JLabel credits;
    private javax.swing.JTextField credits_field;
    private javax.swing.JButton deletecourse_btn;
    private javax.swing.JButton deleteinstructor_btn;
    private javax.swing.JComboBox<String> department_cbox;
    private javax.swing.JTextField employeeID_field;
    private javax.swing.JPanel instructor;
    private javax.swing.JButton instructor_btn;
    private javax.swing.JPanel instructor_form;
    private javax.swing.JTextField instructorname_field;
    private javax.swing.JPasswordField instructorpass_field;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JButton logout_btn;
    private javax.swing.JTabbedPane panels;
    private javax.swing.JTextField search;
    private javax.swing.JComboBox<String> searchsem_cbox;
    private javax.swing.JComboBox<String> searchyear_cbox;
    private javax.swing.JComboBox<String> sem_cbox;
    private javax.swing.JPanel student;
    private javax.swing.JButton student_btn;
    private javax.swing.JPanel student_form;
    private javax.swing.JTextField studentemail_field;
    private javax.swing.JTextField studentemail_field1;
    private javax.swing.JTextField studentname_field;
    private javax.swing.JTextField studentnumber_field;
    private javax.swing.JPasswordField studentpass_field;
    private javax.swing.JButton updatecourse_btn;
    private javax.swing.JButton updateinstructor_btn;
    private javax.swing.JButton user_btn;
    private javax.swing.JTabbedPane user_tables;
    private javax.swing.JPanel users;
    private javax.swing.JTextField usersearch_bar;
    private javax.swing.JComboBox<String> year_cbox;
    // End of variables declaration//GEN-END:variables
}
