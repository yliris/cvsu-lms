package Home;

import Components.StudentEditProfile;
import Components.UtilityMethods.DefaultFocus;
import static Components.UtilityMethods.DefaultText2;
import Login.StartFrame;
import Signup.StudentCreateAccount1Frame;
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class StudentHome extends javax.swing.JFrame {

    private static int userID;

    public StudentHome(int userID) {
        StudentHome.userID = userID;
        initComponents();
        displayDataInCoursesTable();
    }

    public static void setUserID(int userID) {
        StudentHome.userID = userID;

//        System.out.println(userID);
    }

    private void displayDataInCoursesTable() {
        String query = "SELECT * FROM tb_subjects";

        String url = "jdbc:mysql://localhost:3306/lms_project";
        String user = "root";
        String pass = "";

        try (Connection con = DriverManager.getConnection(url, user, pass); PreparedStatement pst = con.prepareStatement(query); ResultSet rs = pst.executeQuery()) {

            // Create a DefaultTableModel to hold the data
            DefaultTableModel model = (DefaultTableModel) SubjectsTable.getModel();

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
            SubjectsTable.revalidate();
            SubjectsTable.repaint();

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
            DefaultTableModel model = (DefaultTableModel) SubjectsTable.getModel();

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
            SubjectsTable.revalidate();
            SubjectsTable.repaint();

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error fetching data: " + e.getMessage());
        }

    }
    
    public void refreshProfile(){
        String query = "SELECT * FROM tb_studentinfo WHERE info_id = " + userID;

        String url = "jdbc:mysql://localhost:3306/lms_project";
        String user = "root";
        String pass = "";

        try (Connection con = DriverManager.getConnection(url, user, pass); PreparedStatement pst = con.prepareStatement(query); ResultSet rs = pst.executeQuery()) {
            if (rs.next()) {
                age_field.setText(rs.getString("info_age"));
                sex_field.setText(rs.getString("info_sex"));
                contactnum_field.setText(rs.getString("info_contact_number"));
                address_field.setText(rs.getString("info_address"));
                bday_field.setText(rs.getString("info_birthday"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(new JFrame(), "Error fetching data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        query = "SELECT * FROM tb_createstudent WHERE StudentNumber = " + userID;

        try (Connection con = DriverManager.getConnection(url, user, pass); PreparedStatement pst = con.prepareStatement(query); ResultSet rs = pst.executeQuery()) {
            if (rs.next()) {
                name_field.setText(rs.getString("Name"));
                cvsum_field.setText(rs.getString("CvSU_Email"));
                course_field.setText(rs.getString("Course"));
                id_field.setText(String.valueOf(userID));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(new JFrame(), "Error fetching data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        student_panels = new javax.swing.JTabbedPane();
        student_home = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        top_performing_table = new javax.swing.JTable();
        grades_panel = new javax.swing.JPanel();
        title1 = new javax.swing.JLabel();
        total_grade = new javax.swing.JLabel();
        grades_cbox = new javax.swing.JComboBox<>();
        home_background = new javax.swing.JPanel();
        jCalendar1 = new com.toedter.calendar.JCalendar();
        title4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        announcement = new javax.swing.JLabel();
        announcement_post = new javax.swing.JLabel();
        reminder_panel = new javax.swing.JPanel();
        title2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        reminder_field = new javax.swing.JTextArea();
        updatereminder_btn = new javax.swing.JButton();
        clearreminder_btn = new javax.swing.JButton();
        savereminder_btn = new javax.swing.JButton();
        student_subject = new javax.swing.JPanel();
        student_subject_panels = new javax.swing.JTabbedPane();
        addsubject_panel = new javax.swing.JPanel();
        addsubject_form = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        credits = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        subjectcode_field = new javax.swing.JTextField();
        credits_field = new javax.swing.JTextField();
        subjectsem_cbox = new javax.swing.JComboBox<>();
        subjectyear_cbox = new javax.swing.JComboBox<>();
        jLabel22 = new javax.swing.JLabel();
        addsubject_btn1 = new javax.swing.JButton();
        subjecttitle_field = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        addsubjects_table = new javax.swing.JPanel();
        coursesearchyear_cbox = new javax.swing.JComboBox<>();
        coursesearchsem_cbox = new javax.swing.JComboBox<>();
        coursesearch_bar = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        SubjectsTable = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        viewsubject_panel = new javax.swing.JPanel();
        viewsubject_form = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        credits1 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        subjectcode_field1 = new javax.swing.JTextField();
        credits_field1 = new javax.swing.JTextField();
        subjectsem_cbox1 = new javax.swing.JComboBox<>();
        subjectyear_cbox1 = new javax.swing.JComboBox<>();
        jLabel31 = new javax.swing.JLabel();
        subjecttitle_field1 = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        removecourse_btn = new javax.swing.JButton();
        viewsubjects_table1 = new javax.swing.JPanel();
        coursesearchyear_cbox1 = new javax.swing.JComboBox<>();
        coursesearchsem_cbox1 = new javax.swing.JComboBox<>();
        coursesearch_bar1 = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        SubjectsTable1 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        subject_header = new javax.swing.JPanel();
        addsubject_btn = new javax.swing.JButton();
        viewsubject_btn = new javax.swing.JButton();
        student_class = new javax.swing.JPanel();
        instructor_class_panels = new javax.swing.JTabbedPane();
        addclass_panel = new javax.swing.JPanel();
        addclass_form = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        classSem_cbox = new javax.swing.JComboBox<>();
        classSection_field = new javax.swing.JTextField();
        classyear_cbox = new javax.swing.JComboBox<>();
        course_cbox = new javax.swing.JComboBox<>();
        jLabel26 = new javax.swing.JLabel();
        addclass_btn = new javax.swing.JButton();
        addclasses_table = new javax.swing.JPanel();
        classsearchyear_cbox = new javax.swing.JComboBox<>();
        classsearchsem_cbox = new javax.swing.JComboBox<>();
        classSearch_bar = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        AddClassesTable = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        viewclass_panel = new javax.swing.JPanel();
        viewclass_form = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        classSem_cbox1 = new javax.swing.JComboBox<>();
        classyear_cbox1 = new javax.swing.JComboBox<>();
        course_cbox1 = new javax.swing.JComboBox<>();
        jLabel37 = new javax.swing.JLabel();
        removeclass_btn = new javax.swing.JButton();
        viewclass_table = new javax.swing.JPanel();
        classsearchyear_cbox1 = new javax.swing.JComboBox<>();
        classsearchsem_cbox1 = new javax.swing.JComboBox<>();
        classSearch_bar1 = new javax.swing.JTextField();
        jScrollPane7 = new javax.swing.JScrollPane();
        ViewClassesTable = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        class_header = new javax.swing.JPanel();
        addclass_btn1 = new javax.swing.JButton();
        viewclass_btn = new javax.swing.JButton();
        student_profile = new javax.swing.JPanel();
        profile_background = new javax.swing.JPanel();
        personal_info = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        student_name = new javax.swing.JLabel();
        student_age = new javax.swing.JLabel();
        student_sex = new javax.swing.JLabel();
        student_number = new javax.swing.JLabel();
        student_address = new javax.swing.JLabel();
        student_bday = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        edit_btn = new javax.swing.JButton();
        delete_btn = new javax.swing.JButton();
        name_field = new javax.swing.JLabel();
        age_field = new javax.swing.JLabel();
        sex_field = new javax.swing.JLabel();
        contactnum_field = new javax.swing.JLabel();
        address_field = new javax.swing.JLabel();
        bday_field = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        school_info = new javax.swing.JLabel();
        student_email = new javax.swing.JLabel();
        student_studNumber = new javax.swing.JLabel();
        student_section = new javax.swing.JLabel();
        student_course = new javax.swing.JLabel();
        cvsum_field = new javax.swing.JLabel();
        id_field = new javax.swing.JLabel();
        section_field = new javax.swing.JLabel();
        course_field = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        student_about = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        navigation = new javax.swing.JPanel();
        home_panel = new javax.swing.JPanel();
        home_icon = new javax.swing.JLabel();
        home_btn = new javax.swing.JButton();
        course_panel = new javax.swing.JPanel();
        subject_icon = new javax.swing.JLabel();
        subject_btn = new javax.swing.JButton();
        class_panel = new javax.swing.JPanel();
        class_icon = new javax.swing.JLabel();
        class_btn = new javax.swing.JButton();
        profile_panel = new javax.swing.JPanel();
        profile_icon = new javax.swing.JLabel();
        profile_btn = new javax.swing.JButton();
        about_panel = new javax.swing.JPanel();
        about_icon = new javax.swing.JLabel();
        about_btn = new javax.swing.JButton();
        logout_panel = new javax.swing.JPanel();
        logout_icon = new javax.swing.JLabel();
        logout_btn = new javax.swing.JButton();
        header = new javax.swing.JPanel();
        greetings = new javax.swing.JLabel();
        header_element = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Learning Management System - Instructor Home");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        background.setBackground(new java.awt.Color(255, 255, 255));
        background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        student_home.setBackground(new java.awt.Color(255, 255, 255));
        student_home.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        top_performing_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(top_performing_table);

        student_home.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 160, 380, 300));

        grades_panel.setBackground(new java.awt.Color(81, 199, 135));
        grades_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        title1.setFont(new java.awt.Font("Cascadia Mono", 1, 10)); // NOI18N
        title1.setForeground(new java.awt.Color(255, 255, 255));
        title1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title1.setText("Your grade for:");
        grades_panel.add(title1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 110, 40));

        total_grade.setFont(new java.awt.Font("Cascadia Mono", 1, 18)); // NOI18N
        total_grade.setForeground(new java.awt.Color(255, 255, 255));
        total_grade.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        total_grade.setText("(number)");
        grades_panel.add(total_grade, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 210, 70));

        grades_cbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "courses" }));
        grades_panel.add(grades_cbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 90, -1));

        student_home.add(grades_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 210, 100));

        home_background.setBackground(new java.awt.Color(202, 154, 221));
        home_background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jCalendar1.setBackground(new java.awt.Color(202, 154, 221));
        jCalendar1.setToolTipText("");
        jCalendar1.setDecorationBackgroundColor(new java.awt.Color(212, 175, 227));
        jCalendar1.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jCalendar1.setTodayButtonVisible(true);
        home_background.add(jCalendar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 285, 390, 150));

        title4.setFont(new java.awt.Font("Cascadia Mono", 1, 12)); // NOI18N
        title4.setForeground(new java.awt.Color(255, 255, 255));
        title4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title4.setText("Top Performing Students");
        home_background.add(title4, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 110, 380, 30));

        jPanel1.setBackground(new java.awt.Color(81, 199, 135));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        announcement.setFont(new java.awt.Font("Cascadia Mono", 1, 12)); // NOI18N
        announcement.setForeground(new java.awt.Color(255, 255, 255));
        announcement.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        announcement.setText("Instructor's Announcement");
        jPanel1.add(announcement, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 560, 30));

        announcement_post.setFont(new java.awt.Font("Cascadia Mono", 1, 12)); // NOI18N
        announcement_post.setForeground(new java.awt.Color(255, 255, 255));
        announcement_post.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        announcement_post.setText("(Announcement)");
        jPanel1.add(announcement_post, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 560, 70));

        home_background.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, 560, 100));

        reminder_panel.setBackground(new java.awt.Color(81, 199, 135));
        reminder_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        title2.setFont(new java.awt.Font("Cascadia Mono", 1, 12)); // NOI18N
        title2.setForeground(new java.awt.Color(255, 255, 255));
        title2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title2.setText("Reminder");
        reminder_panel.add(title2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 390, 30));

        reminder_field.setBackground(new java.awt.Color(81, 199, 135));
        reminder_field.setColumns(20);
        reminder_field.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        reminder_field.setForeground(new java.awt.Color(255, 255, 255));
        reminder_field.setRows(5);
        jScrollPane1.setViewportView(reminder_field);

        reminder_panel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 370, -1));

        updatereminder_btn.setBackground(new java.awt.Color(105, 105, 210));
        updatereminder_btn.setFont(new java.awt.Font("Cascadia Mono", 0, 10)); // NOI18N
        updatereminder_btn.setForeground(new java.awt.Color(255, 255, 255));
        updatereminder_btn.setText("Edit");
        reminder_panel.add(updatereminder_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 125, 80, 20));

        clearreminder_btn.setBackground(new java.awt.Color(225, 70, 70));
        clearreminder_btn.setFont(new java.awt.Font("Cascadia Mono", 0, 10)); // NOI18N
        clearreminder_btn.setForeground(new java.awt.Color(255, 255, 255));
        clearreminder_btn.setText("Clear");
        reminder_panel.add(clearreminder_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 125, 80, 20));

        savereminder_btn.setBackground(new java.awt.Color(164, 83, 197));
        savereminder_btn.setFont(new java.awt.Font("Cascadia Mono", 0, 10)); // NOI18N
        savereminder_btn.setForeground(new java.awt.Color(255, 255, 255));
        savereminder_btn.setText("Save");
        reminder_panel.add(savereminder_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 125, 80, 20));

        home_background.add(reminder_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 390, 150));

        student_home.add(home_background, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 800, 450));

        student_panels.addTab("tab1", student_home);

        student_subject.setBackground(new java.awt.Color(255, 255, 255));
        student_subject.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        addsubject_panel.setBackground(new java.awt.Color(255, 255, 255));
        addsubject_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        addsubject_form.setBackground(new java.awt.Color(202, 154, 221));
        addsubject_form.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel19.setFont(new java.awt.Font("Cascadia Mono", 0, 10)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel19.setText("Semester:");
        addsubject_form.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 90, 20));

        jLabel18.setFont(new java.awt.Font("Cascadia Mono", 0, 10)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel18.setText("Course Code:");
        addsubject_form.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 90, 20));

        credits.setFont(new java.awt.Font("Cascadia Mono", 0, 10)); // NOI18N
        credits.setForeground(new java.awt.Color(255, 255, 255));
        credits.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        credits.setText("Credits:");
        addsubject_form.add(credits, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 90, 20));

        jLabel21.setFont(new java.awt.Font("Cascadia Mono", 0, 10)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel21.setText("Year:");
        addsubject_form.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 90, 20));

        subjectcode_field.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        addsubject_form.add(subjectcode_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, 160, -1));

        credits_field.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        addsubject_form.add(credits_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, 160, -1));

        subjectsem_cbox.setBackground(new java.awt.Color(164, 83, 197));
        subjectsem_cbox.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        subjectsem_cbox.setForeground(new java.awt.Color(255, 255, 255));
        subjectsem_cbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1st", "2nd" }));
        addsubject_form.add(subjectsem_cbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 200, 160, 20));

        subjectyear_cbox.setBackground(new java.awt.Color(164, 83, 197));
        subjectyear_cbox.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        subjectyear_cbox.setForeground(new java.awt.Color(255, 255, 255));
        subjectyear_cbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1st", "2nd", "3rd", "Midyear", "4th" }));
        addsubject_form.add(subjectyear_cbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 170, 160, 20));

        jLabel22.setFont(new java.awt.Font("Cascadia Mono", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("Subject Form");
        addsubject_form.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 260, 40));

        addsubject_btn1.setBackground(new java.awt.Color(164, 83, 197));
        addsubject_btn1.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        addsubject_btn1.setForeground(new java.awt.Color(255, 255, 255));
        addsubject_btn1.setText("Enroll To This Subject");
        addsubject_btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addsubject_btn1ActionPerformed(evt);
            }
        });
        addsubject_form.add(addsubject_btn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 240, 30));

        subjecttitle_field.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        addsubject_form.add(subjecttitle_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, 160, -1));

        jLabel25.setFont(new java.awt.Font("Cascadia Mono", 0, 10)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel25.setText("Course Title:");
        addsubject_form.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 90, 20));

        addsubject_panel.add(addsubject_form, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 260, 410));

        addsubjects_table.setBackground(new java.awt.Color(81, 199, 135));
        addsubjects_table.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        coursesearchyear_cbox.setFont(new java.awt.Font("Cascadia Mono", 0, 10)); // NOI18N
        coursesearchyear_cbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "1st", "2nd", "3rd", "Midyear", "4th" }));
        coursesearchyear_cbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                coursesearchyear_cboxActionPerformed(evt);
            }
        });
        addsubjects_table.add(coursesearchyear_cbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 110, 20));

        coursesearchsem_cbox.setFont(new java.awt.Font("Cascadia Mono", 0, 10)); // NOI18N
        coursesearchsem_cbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "1st", "2nd" }));
        coursesearchsem_cbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                coursesearchsem_cboxActionPerformed(evt);
            }
        });
        addsubjects_table.add(coursesearchsem_cbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, 110, 20));

        coursesearch_bar.setFont(new java.awt.Font("Cascadia Mono", 0, 10)); // NOI18N
        coursesearch_bar.setText("Enter Subject Code / Title");
        coursesearch_bar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                coursesearch_barFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                coursesearch_barFocusLost(evt);
            }
        });
        addsubjects_table.add(coursesearch_bar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 20, 230, 20));

        SubjectsTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(SubjectsTable);

        addsubjects_table.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 520, 360));

        jLabel4.setFont(new java.awt.Font("Cascadia Mono", 0, 8)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/icons/search-icon.png"))); // NOI18N
        addsubjects_table.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 20, -1, 20));

        jLabel3.setFont(new java.awt.Font("Cascadia Mono", 0, 8)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Semester");
        jLabel3.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        addsubjects_table.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 0, 110, 20));

        jLabel2.setFont(new java.awt.Font("Cascadia Mono", 0, 8)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Year");
        jLabel2.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        addsubjects_table.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 110, 20));

        addsubject_panel.add(addsubjects_table, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 20, 540, 410));

        student_subject_panels.addTab("tab1", addsubject_panel);

        viewsubject_panel.setBackground(new java.awt.Color(255, 255, 255));
        viewsubject_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        viewsubject_form.setBackground(new java.awt.Color(202, 154, 221));
        viewsubject_form.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel28.setFont(new java.awt.Font("Cascadia Mono", 0, 10)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel28.setText("Semester:");
        viewsubject_form.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 90, 20));

        jLabel29.setFont(new java.awt.Font("Cascadia Mono", 0, 10)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel29.setText("Course Code:");
        viewsubject_form.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 90, 20));

        credits1.setFont(new java.awt.Font("Cascadia Mono", 0, 10)); // NOI18N
        credits1.setForeground(new java.awt.Color(255, 255, 255));
        credits1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        credits1.setText("Credits:");
        viewsubject_form.add(credits1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 90, 20));

        jLabel30.setFont(new java.awt.Font("Cascadia Mono", 0, 10)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel30.setText("Year:");
        viewsubject_form.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 90, 20));

        subjectcode_field1.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        viewsubject_form.add(subjectcode_field1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, 160, -1));

        credits_field1.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        viewsubject_form.add(credits_field1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, 160, -1));

        subjectsem_cbox1.setBackground(new java.awt.Color(164, 83, 197));
        subjectsem_cbox1.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        subjectsem_cbox1.setForeground(new java.awt.Color(255, 255, 255));
        subjectsem_cbox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1st", "2nd" }));
        viewsubject_form.add(subjectsem_cbox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 200, 160, 20));

        subjectyear_cbox1.setBackground(new java.awt.Color(164, 83, 197));
        subjectyear_cbox1.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        subjectyear_cbox1.setForeground(new java.awt.Color(255, 255, 255));
        subjectyear_cbox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1st", "2nd", "3rd", "Midyear", "4th" }));
        viewsubject_form.add(subjectyear_cbox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 170, 160, 20));

        jLabel31.setFont(new java.awt.Font("Cascadia Mono", 1, 14)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel31.setText("Subject Form");
        viewsubject_form.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 260, 40));

        subjecttitle_field1.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        viewsubject_form.add(subjecttitle_field1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, 160, -1));

        jLabel32.setFont(new java.awt.Font("Cascadia Mono", 0, 10)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel32.setText("Course Title:");
        viewsubject_form.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 90, 20));

        removecourse_btn.setBackground(new java.awt.Color(233, 82, 82));
        removecourse_btn.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        removecourse_btn.setForeground(new java.awt.Color(255, 255, 255));
        removecourse_btn.setText("Remove Course");
        removecourse_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removecourse_btnActionPerformed(evt);
            }
        });
        viewsubject_form.add(removecourse_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 240, 30));

        viewsubject_panel.add(viewsubject_form, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 260, 410));

        viewsubjects_table1.setBackground(new java.awt.Color(81, 199, 135));
        viewsubjects_table1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        coursesearchyear_cbox1.setFont(new java.awt.Font("Cascadia Mono", 0, 10)); // NOI18N
        coursesearchyear_cbox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "1st", "2nd", "3rd", "Midyear", "4th" }));
        coursesearchyear_cbox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                coursesearchyear_cbox1ActionPerformed(evt);
            }
        });
        viewsubjects_table1.add(coursesearchyear_cbox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 110, 20));

        coursesearchsem_cbox1.setFont(new java.awt.Font("Cascadia Mono", 0, 10)); // NOI18N
        coursesearchsem_cbox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "1st", "2nd" }));
        coursesearchsem_cbox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                coursesearchsem_cbox1ActionPerformed(evt);
            }
        });
        viewsubjects_table1.add(coursesearchsem_cbox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, 110, 20));

        coursesearch_bar1.setFont(new java.awt.Font("Cascadia Mono", 0, 10)); // NOI18N
        coursesearch_bar1.setText("Enter Subject Code / Title");
        coursesearch_bar1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                coursesearch_bar1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                coursesearch_bar1FocusLost(evt);
            }
        });
        viewsubjects_table1.add(coursesearch_bar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 20, 230, 20));

        SubjectsTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Program", "Course Code", "Course Title", "Credits", "Year", "Semester"
            }
        ));
        jScrollPane4.setViewportView(SubjectsTable1);
        if (SubjectsTable1.getColumnModel().getColumnCount() > 0) {
            SubjectsTable1.getColumnModel().getColumn(0).setResizable(false);
            SubjectsTable1.getColumnModel().getColumn(3).setResizable(false);
            SubjectsTable1.getColumnModel().getColumn(4).setResizable(false);
        }

        viewsubjects_table1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 520, 360));

        jLabel5.setFont(new java.awt.Font("Cascadia Mono", 0, 8)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/icons/search-icon.png"))); // NOI18N
        viewsubjects_table1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 20, -1, 20));

        jLabel11.setFont(new java.awt.Font("Cascadia Mono", 0, 8)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Semester");
        jLabel11.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel11.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        viewsubjects_table1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 0, 110, 20));

        jLabel12.setFont(new java.awt.Font("Cascadia Mono", 0, 8)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Year");
        jLabel12.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel12.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        viewsubjects_table1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 110, 20));

        viewsubject_panel.add(viewsubjects_table1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 20, 540, 410));

        student_subject_panels.addTab("tab2", viewsubject_panel);

        student_subject.add(student_subject_panels, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 820, 470));

        subject_header.setBackground(new java.awt.Color(255, 255, 255));
        subject_header.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        addsubject_btn.setBackground(new java.awt.Color(48, 150, 95));
        addsubject_btn.setFont(new java.awt.Font("Cascadia Mono", 1, 12)); // NOI18N
        addsubject_btn.setForeground(new java.awt.Color(255, 255, 255));
        addsubject_btn.setText("Add Subject");
        addsubject_btn.setBorderPainted(false);
        addsubject_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addsubject_btnActionPerformed(evt);
            }
        });
        subject_header.add(addsubject_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 120, 30));

        viewsubject_btn.setBackground(new java.awt.Color(48, 150, 95));
        viewsubject_btn.setFont(new java.awt.Font("Cascadia Mono", 1, 12)); // NOI18N
        viewsubject_btn.setForeground(new java.awt.Color(255, 255, 255));
        viewsubject_btn.setText("View Subject");
        viewsubject_btn.setBorderPainted(false);
        viewsubject_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewsubject_btnActionPerformed(evt);
            }
        });
        subject_header.add(viewsubject_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 120, 30));

        student_subject.add(subject_header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 50));

        student_panels.addTab("tab2", student_subject);

        student_class.setBackground(new java.awt.Color(255, 255, 255));
        student_class.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        addclass_panel.setBackground(new java.awt.Color(255, 255, 255));
        addclass_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        addclass_form.setBackground(new java.awt.Color(202, 154, 221));
        addclass_form.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel27.setFont(new java.awt.Font("Cascadia Mono", 0, 10)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel27.setText("Sem:");
        addclass_form.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 90, 20));

        jLabel20.setFont(new java.awt.Font("Cascadia Mono", 0, 10)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel20.setText("Year:");
        addclass_form.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 90, 20));

        jLabel23.setFont(new java.awt.Font("Cascadia Mono", 0, 10)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel23.setText("Class Section:");
        addclass_form.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 90, 20));

        jLabel24.setFont(new java.awt.Font("Cascadia Mono", 0, 10)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel24.setText("Class Course:");
        addclass_form.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 90, 20));

        classSem_cbox.setBackground(new java.awt.Color(164, 83, 197));
        classSem_cbox.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        classSem_cbox.setForeground(new java.awt.Color(255, 255, 255));
        classSem_cbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1st", "2nd" }));
        addclass_form.add(classSem_cbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 160, 160, 20));

        classSection_field.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        addclass_form.add(classSection_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, 160, -1));

        classyear_cbox.setBackground(new java.awt.Color(164, 83, 197));
        classyear_cbox.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        classyear_cbox.setForeground(new java.awt.Color(255, 255, 255));
        classyear_cbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1st", "2nd", "3rd", "Midyear", "4th" }));
        addclass_form.add(classyear_cbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, 160, 20));

        course_cbox.setBackground(new java.awt.Color(164, 83, 197));
        course_cbox.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        course_cbox.setForeground(new java.awt.Color(255, 255, 255));
        course_cbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "BSCS", "BSIT" }));
        addclass_form.add(course_cbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, 160, 20));

        jLabel26.setFont(new java.awt.Font("Cascadia Mono", 1, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("Class Form");
        addclass_form.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 260, 40));

        addclass_btn.setBackground(new java.awt.Color(48, 150, 95));
        addclass_btn.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        addclass_btn.setForeground(new java.awt.Color(255, 255, 255));
        addclass_btn.setText("Add Class");
        addclass_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addclass_btnActionPerformed(evt);
            }
        });
        addclass_form.add(addclass_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 240, 30));

        addclass_panel.add(addclass_form, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 260, 410));

        addclasses_table.setBackground(new java.awt.Color(81, 199, 135));
        addclasses_table.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        classsearchyear_cbox.setFont(new java.awt.Font("Cascadia Mono", 0, 10)); // NOI18N
        classsearchyear_cbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "1st", "2nd", "3rd", "Midyear", "4th" }));
        classsearchyear_cbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                classsearchyear_cboxActionPerformed(evt);
            }
        });
        addclasses_table.add(classsearchyear_cbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 110, 20));

        classsearchsem_cbox.setFont(new java.awt.Font("Cascadia Mono", 0, 10)); // NOI18N
        classsearchsem_cbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "1st", "2nd" }));
        classsearchsem_cbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                classsearchsem_cboxActionPerformed(evt);
            }
        });
        addclasses_table.add(classsearchsem_cbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, 110, 20));

        classSearch_bar.setFont(new java.awt.Font("Cascadia Mono", 0, 10)); // NOI18N
        classSearch_bar.setText("Enter Class");
        classSearch_bar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                classSearch_barFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                classSearch_barFocusLost(evt);
            }
        });
        addclasses_table.add(classSearch_bar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 20, 230, 20));

        AddClassesTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane5.setViewportView(AddClassesTable);

        addclasses_table.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 520, 360));

        jLabel7.setFont(new java.awt.Font("Cascadia Mono", 0, 8)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/icons/search-icon.png"))); // NOI18N
        addclasses_table.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 20, -1, 20));

        jLabel8.setFont(new java.awt.Font("Cascadia Mono", 0, 8)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Semester");
        jLabel8.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel8.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        addclasses_table.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 0, 110, 20));

        jLabel9.setFont(new java.awt.Font("Cascadia Mono", 0, 8)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Year");
        jLabel9.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel9.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        addclasses_table.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 110, 20));

        addclass_panel.add(addclasses_table, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 20, 540, 410));

        instructor_class_panels.addTab("tab1", addclass_panel);

        viewclass_panel.setBackground(new java.awt.Color(255, 255, 255));
        viewclass_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        viewclass_form.setBackground(new java.awt.Color(202, 154, 221));
        viewclass_form.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel33.setFont(new java.awt.Font("Cascadia Mono", 0, 10)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel33.setText("Sem:");
        viewclass_form.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 90, 20));

        jLabel34.setFont(new java.awt.Font("Cascadia Mono", 0, 10)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel34.setText("Year:");
        viewclass_form.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 90, 20));

        jLabel36.setFont(new java.awt.Font("Cascadia Mono", 0, 10)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel36.setText("Class Program:");
        viewclass_form.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 90, 20));

        classSem_cbox1.setBackground(new java.awt.Color(164, 83, 197));
        classSem_cbox1.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        classSem_cbox1.setForeground(new java.awt.Color(255, 255, 255));
        classSem_cbox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1st", "2nd" }));
        viewclass_form.add(classSem_cbox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 160, 160, 20));

        classyear_cbox1.setBackground(new java.awt.Color(164, 83, 197));
        classyear_cbox1.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        classyear_cbox1.setForeground(new java.awt.Color(255, 255, 255));
        classyear_cbox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1st", "2nd", "3rd", "Midyear", "4th" }));
        viewclass_form.add(classyear_cbox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, 160, 20));

        course_cbox1.setBackground(new java.awt.Color(164, 83, 197));
        course_cbox1.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        course_cbox1.setForeground(new java.awt.Color(255, 255, 255));
        course_cbox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "BSCS", "BSIT" }));
        viewclass_form.add(course_cbox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, 160, 20));

        jLabel37.setFont(new java.awt.Font("Cascadia Mono", 1, 14)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel37.setText("Class Form");
        viewclass_form.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 260, 40));

        removeclass_btn.setBackground(new java.awt.Color(233, 82, 82));
        removeclass_btn.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        removeclass_btn.setForeground(new java.awt.Color(255, 255, 255));
        removeclass_btn.setText("Remove Course");
        removeclass_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeclass_btnActionPerformed(evt);
            }
        });
        viewclass_form.add(removeclass_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 240, 30));

        viewclass_panel.add(viewclass_form, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 260, 410));

        viewclass_table.setBackground(new java.awt.Color(81, 199, 135));
        viewclass_table.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        classsearchyear_cbox1.setFont(new java.awt.Font("Cascadia Mono", 0, 10)); // NOI18N
        classsearchyear_cbox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "1st", "2nd", "3rd", "Midyear", "4th" }));
        classsearchyear_cbox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                classsearchyear_cbox1ActionPerformed(evt);
            }
        });
        viewclass_table.add(classsearchyear_cbox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 110, 20));

        classsearchsem_cbox1.setFont(new java.awt.Font("Cascadia Mono", 0, 10)); // NOI18N
        classsearchsem_cbox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "1st", "2nd" }));
        classsearchsem_cbox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                classsearchsem_cbox1ActionPerformed(evt);
            }
        });
        viewclass_table.add(classsearchsem_cbox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, 110, 20));

        classSearch_bar1.setFont(new java.awt.Font("Cascadia Mono", 0, 10)); // NOI18N
        classSearch_bar1.setText("Enter Class");
        classSearch_bar1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                classSearch_bar1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                classSearch_bar1FocusLost(evt);
            }
        });
        viewclass_table.add(classSearch_bar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 20, 230, 20));

        ViewClassesTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane7.setViewportView(ViewClassesTable);

        viewclass_table.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 520, 360));

        jLabel13.setFont(new java.awt.Font("Cascadia Mono", 0, 8)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(102, 102, 102));
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/icons/search-icon.png"))); // NOI18N
        viewclass_table.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 20, -1, 20));

        jLabel14.setFont(new java.awt.Font("Cascadia Mono", 0, 8)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Semester");
        jLabel14.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel14.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        viewclass_table.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 0, 110, 20));

        jLabel15.setFont(new java.awt.Font("Cascadia Mono", 0, 8)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Year");
        jLabel15.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel15.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        viewclass_table.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 110, 20));

        viewclass_panel.add(viewclass_table, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 20, 540, 410));

        instructor_class_panels.addTab("tab2", viewclass_panel);

        student_class.add(instructor_class_panels, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 820, 470));

        class_header.setBackground(new java.awt.Color(255, 255, 255));
        class_header.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        addclass_btn1.setBackground(new java.awt.Color(3, 159, 75));
        addclass_btn1.setFont(new java.awt.Font("Cascadia Mono", 1, 12)); // NOI18N
        addclass_btn1.setForeground(new java.awt.Color(255, 255, 255));
        addclass_btn1.setText("Add Class");
        addclass_btn1.setBorderPainted(false);
        addclass_btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addclass_btn1ActionPerformed(evt);
            }
        });
        class_header.add(addclass_btn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 120, 30));

        viewclass_btn.setBackground(new java.awt.Color(3, 159, 75));
        viewclass_btn.setFont(new java.awt.Font("Cascadia Mono", 1, 12)); // NOI18N
        viewclass_btn.setForeground(new java.awt.Color(255, 255, 255));
        viewclass_btn.setText("View Class");
        viewclass_btn.setBorderPainted(false);
        viewclass_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewclass_btnActionPerformed(evt);
            }
        });
        class_header.add(viewclass_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 120, 30));

        student_class.add(class_header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 50));

        student_panels.addTab("tab3", student_class);

        student_profile.setBackground(new java.awt.Color(255, 255, 255));
        student_profile.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        profile_background.setBackground(new java.awt.Color(81, 199, 135));
        profile_background.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        profile_background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        personal_info.setFont(new java.awt.Font("Cascadia Mono", 1, 18)); // NOI18N
        personal_info.setForeground(new java.awt.Color(255, 255, 255));
        personal_info.setText("Personal Details");
        profile_background.add(personal_info, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));
        profile_background.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 780, 10));

        student_name.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        student_name.setForeground(new java.awt.Color(255, 255, 255));
        student_name.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        student_name.setText("Name:");
        profile_background.add(student_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 110, 30));

        student_age.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        student_age.setForeground(new java.awt.Color(255, 255, 255));
        student_age.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        student_age.setText("Age:");
        profile_background.add(student_age, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 110, 30));

        student_sex.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        student_sex.setForeground(new java.awt.Color(255, 255, 255));
        student_sex.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        student_sex.setText("Sex:");
        profile_background.add(student_sex, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 110, 30));

        student_number.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        student_number.setForeground(new java.awt.Color(255, 255, 255));
        student_number.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        student_number.setText("Contact Number:");
        profile_background.add(student_number, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 110, 30));

        student_address.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        student_address.setForeground(new java.awt.Color(255, 255, 255));
        student_address.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        student_address.setText("Address:");
        profile_background.add(student_address, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 110, 30));

        student_bday.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        student_bday.setForeground(new java.awt.Color(255, 255, 255));
        student_bday.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        student_bday.setText("Birthdate:");
        profile_background.add(student_bday, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 110, 30));
        profile_background.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 760, 10));
        profile_background.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 760, 10));

        edit_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/icons/user-edit-idle-icon.png"))); // NOI18N
        edit_btn.setBorder(null);
        edit_btn.setBorderPainted(false);
        edit_btn.setContentAreaFilled(false);
        edit_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                edit_btnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                edit_btnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                edit_btnMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                edit_btnMouseReleased(evt);
            }
        });
        edit_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edit_btnActionPerformed(evt);
            }
        });
        profile_background.add(edit_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 10, -1, -1));

        delete_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/icons/user-delete-idle-icon.png"))); // NOI18N
        delete_btn.setBorder(null);
        delete_btn.setBorderPainted(false);
        delete_btn.setContentAreaFilled(false);
        delete_btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                delete_btnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                delete_btnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                delete_btnMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                delete_btnMouseReleased(evt);
            }
        });
        delete_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_btnActionPerformed(evt);
            }
        });
        profile_background.add(delete_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 10, -1, -1));

        name_field.setForeground(new java.awt.Color(255, 255, 255));
        name_field.setText("name");
        profile_background.add(name_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 50, 630, 30));

        age_field.setForeground(new java.awt.Color(255, 255, 255));
        age_field.setText("age");
        profile_background.add(age_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, 630, 30));

        sex_field.setForeground(new java.awt.Color(255, 255, 255));
        sex_field.setText("sex");
        profile_background.add(sex_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, 630, 30));

        contactnum_field.setForeground(new java.awt.Color(255, 255, 255));
        contactnum_field.setText("cp num");
        profile_background.add(contactnum_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, 630, 30));

        address_field.setForeground(new java.awt.Color(255, 255, 255));
        address_field.setText("address");
        profile_background.add(address_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, 630, 30));

        bday_field.setForeground(new java.awt.Color(255, 255, 255));
        bday_field.setText("bday");
        profile_background.add(bday_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 200, 630, 30));

        jPanel2.setBackground(new java.awt.Color(202, 154, 221));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        school_info.setFont(new java.awt.Font("Cascadia Mono", 1, 18)); // NOI18N
        school_info.setForeground(new java.awt.Color(255, 255, 255));
        school_info.setText("School Details");
        jPanel2.add(school_info, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        student_email.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        student_email.setForeground(new java.awt.Color(255, 255, 255));
        student_email.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        student_email.setText("CvSU Email:");
        jPanel2.add(student_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 110, 30));

        student_studNumber.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        student_studNumber.setForeground(new java.awt.Color(255, 255, 255));
        student_studNumber.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        student_studNumber.setText("Student Number:");
        jPanel2.add(student_studNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 110, 30));

        student_section.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        student_section.setForeground(new java.awt.Color(255, 255, 255));
        student_section.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        student_section.setText("Section:");
        jPanel2.add(student_section, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 110, 30));

        student_course.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        student_course.setForeground(new java.awt.Color(255, 255, 255));
        student_course.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        student_course.setText("Course:");
        jPanel2.add(student_course, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 110, 30));

        cvsum_field.setForeground(new java.awt.Color(255, 255, 255));
        cvsum_field.setText("cvsu");
        jPanel2.add(cvsum_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 40, 620, 30));

        id_field.setForeground(new java.awt.Color(255, 255, 255));
        id_field.setText("id");
        jPanel2.add(id_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 620, 30));

        section_field.setForeground(new java.awt.Color(255, 255, 255));
        section_field.setText("sec");
        jPanel2.add(section_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 620, 30));

        course_field.setForeground(new java.awt.Color(255, 255, 255));
        course_field.setText("dept");
        jPanel2.add(course_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 100, 620, 30));
        jPanel2.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 760, 10));

        profile_background.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 780, 180));

        student_profile.add(profile_background, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 800, 450));

        student_panels.addTab("tab4", student_profile);

        student_about.setBackground(new java.awt.Color(255, 255, 255));
        student_about.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/backgrounds/about-elements.png"))); // NOI18N
        student_about.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        student_panels.addTab("tab5", student_about);

        background.add(student_panels, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 30, 820, 510));

        navigation.setBackground(new java.awt.Color(202, 154, 221));
        navigation.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        home_panel.setOpaque(false);
        home_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        home_icon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        home_icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/icons/home-icon.png"))); // NOI18N
        home_panel.add(home_icon, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 20, 20));

        home_btn.setBackground(new java.awt.Color(164, 83, 197));
        home_btn.setFont(new java.awt.Font("Cascadia Mono", 1, 10)); // NOI18N
        home_btn.setForeground(new java.awt.Color(255, 255, 255));
        home_btn.setText("HOME");
        home_btn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(162, 79, 195), 1, true));
        home_btn.setBorderPainted(false);
        home_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                home_btnActionPerformed(evt);
            }
        });
        home_panel.add(home_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 130, 40));

        navigation.add(home_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 130, 40));

        course_panel.setOpaque(false);
        course_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        subject_icon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        subject_icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/icons/subject-icon.png"))); // NOI18N
        course_panel.add(subject_icon, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 20, 20));

        subject_btn.setBackground(new java.awt.Color(164, 83, 197));
        subject_btn.setFont(new java.awt.Font("Cascadia Mono", 1, 10)); // NOI18N
        subject_btn.setForeground(new java.awt.Color(255, 255, 255));
        subject_btn.setText("SUBJECT");
        subject_btn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(162, 79, 195), 1, true));
        subject_btn.setBorderPainted(false);
        subject_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subject_btnActionPerformed(evt);
            }
        });
        course_panel.add(subject_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 130, 40));

        navigation.add(course_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 130, 40));

        class_panel.setOpaque(false);
        class_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        class_icon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        class_icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/icons/classes-icon.png"))); // NOI18N
        class_panel.add(class_icon, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 20, 20));

        class_btn.setBackground(new java.awt.Color(164, 83, 197));
        class_btn.setFont(new java.awt.Font("Cascadia Mono", 1, 10)); // NOI18N
        class_btn.setForeground(new java.awt.Color(255, 255, 255));
        class_btn.setText("CLASS");
        class_btn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(162, 79, 195), 1, true));
        class_btn.setBorderPainted(false);
        class_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                class_btnActionPerformed(evt);
            }
        });
        class_panel.add(class_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 130, 40));

        navigation.add(class_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 130, 40));

        profile_panel.setOpaque(false);
        profile_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        profile_icon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        profile_icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/icons/profile-icon.png"))); // NOI18N
        profile_panel.add(profile_icon, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 20, 20));

        profile_btn.setBackground(new java.awt.Color(164, 83, 197));
        profile_btn.setFont(new java.awt.Font("Cascadia Mono", 1, 10)); // NOI18N
        profile_btn.setForeground(new java.awt.Color(255, 255, 255));
        profile_btn.setText("PROFILE");
        profile_btn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(162, 79, 195), 1, true));
        profile_btn.setBorderPainted(false);
        profile_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profile_btnActionPerformed(evt);
            }
        });
        profile_panel.add(profile_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 130, 40));

        navigation.add(profile_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 130, 40));

        about_panel.setOpaque(false);
        about_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        about_icon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        about_icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/icons/about-icon.png"))); // NOI18N
        about_panel.add(about_icon, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 20, 20));

        about_btn.setBackground(new java.awt.Color(164, 83, 197));
        about_btn.setFont(new java.awt.Font("Cascadia Mono", 1, 10)); // NOI18N
        about_btn.setForeground(new java.awt.Color(255, 255, 255));
        about_btn.setText("ABOUT");
        about_btn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(162, 79, 195), 1, true));
        about_btn.setBorderPainted(false);
        about_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                about_btnActionPerformed(evt);
            }
        });
        about_panel.add(about_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 130, 40));

        navigation.add(about_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 130, 40));

        logout_panel.setOpaque(false);
        logout_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        logout_icon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logout_icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/icons/logout-icon.png"))); // NOI18N
        logout_panel.add(logout_icon, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 20, 20));

        logout_btn.setBackground(new java.awt.Color(164, 83, 197));
        logout_btn.setFont(new java.awt.Font("Cascadia Mono", 1, 10)); // NOI18N
        logout_btn.setForeground(new java.awt.Color(255, 255, 255));
        logout_btn.setText("LOGOUT");
        logout_btn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(162, 79, 195), 1, true));
        logout_btn.setBorderPainted(false);
        logout_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logout_btnActionPerformed(evt);
            }
        });
        logout_panel.add(logout_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 130, 40));

        navigation.add(logout_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 130, 40));

        background.add(navigation, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 150, 450));

        header.setBackground(new java.awt.Color(202, 154, 221));
        header.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        greetings.setFont(new java.awt.Font("Cascadia Mono", 1, 18)); // NOI18N
        greetings.setForeground(new java.awt.Color(255, 255, 255));
        greetings.setText("Welcome, (student name)!");
        header.add(greetings, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 0, 880, 70));

        header_element.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/backgrounds/header-background.png"))); // NOI18N
        header.add(header_element, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 70));

        background.add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 980, 70));

        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 980, 540));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void home_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_home_btnActionPerformed
        student_panels.setSelectedIndex(0);
    }//GEN-LAST:event_home_btnActionPerformed

    private void subject_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subject_btnActionPerformed
        student_panels.setSelectedIndex(1);
    }//GEN-LAST:event_subject_btnActionPerformed

    private void class_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_class_btnActionPerformed
        student_panels.setSelectedIndex(2);
    }//GEN-LAST:event_class_btnActionPerformed

    private void profile_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profile_btnActionPerformed
        student_panels.setSelectedIndex(3);

        refreshProfile();
    }//GEN-LAST:event_profile_btnActionPerformed

    private void about_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_about_btnActionPerformed
        student_panels.setSelectedIndex(4);
    }//GEN-LAST:event_about_btnActionPerformed

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

    private void addsubject_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addsubject_btnActionPerformed
        student_subject_panels.setSelectedIndex(0);
    }//GEN-LAST:event_addsubject_btnActionPerformed

    private void viewsubject_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewsubject_btnActionPerformed
        student_subject_panels.setSelectedIndex(1);
    }//GEN-LAST:event_viewsubject_btnActionPerformed

    private void coursesearch_barFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_coursesearch_barFocusGained
        DefaultText2(coursesearch_bar, "Enter Course Code / Title", DefaultFocus.GAINED);
    }//GEN-LAST:event_coursesearch_barFocusGained

    private void coursesearch_barFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_coursesearch_barFocusLost
        DefaultText2(coursesearch_bar, "Enter Course Code / Title", DefaultFocus.LOST);
    }//GEN-LAST:event_coursesearch_barFocusLost

    private void edit_btnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_edit_btnMouseEntered
        edit_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/icons/user-edit-hover-icon.png")));
    }//GEN-LAST:event_edit_btnMouseEntered

    private void edit_btnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_edit_btnMouseExited
        edit_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/icons/user-edit-idle-icon.png")));
    }//GEN-LAST:event_edit_btnMouseExited

    private void edit_btnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_edit_btnMousePressed
        edit_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/icons/user-edit-idle-icon.png")));
    }//GEN-LAST:event_edit_btnMousePressed

    private void edit_btnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_edit_btnMouseReleased
        edit_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/icons/user-edit-hover-icon.png")));
    }//GEN-LAST:event_edit_btnMouseReleased

    private void delete_btnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_delete_btnMouseEntered
        delete_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/icons/user-delete-hover-icon.png")));
    }//GEN-LAST:event_delete_btnMouseEntered

    private void delete_btnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_delete_btnMouseExited
        delete_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/icons/user-delete-idle-icon.png")));
    }//GEN-LAST:event_delete_btnMouseExited

    private void delete_btnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_delete_btnMousePressed
        delete_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/icons/user-delete-idle-icon.png")));
    }//GEN-LAST:event_delete_btnMousePressed

    private void delete_btnMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_delete_btnMouseReleased
        delete_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/icons/user-delete-hover-icon.png")));
    }//GEN-LAST:event_delete_btnMouseReleased

    private void edit_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edit_btnActionPerformed
        new StudentEditProfile(userID, this).setVisible(true);
        StudentEditProfile.setUserID(userID);
    }//GEN-LAST:event_edit_btnActionPerformed

    private void delete_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_btnActionPerformed
        int confirmLogout = JOptionPane.showConfirmDialog(null,
                "Are you sure you want to delete your account?\n(wala pa function)",
                "Account Deletion",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE);

        if (confirmLogout == JOptionPane.YES_OPTION) {
            //InputDialog, then ask for password. If password is correct, proceed to deletion.
        }
    }//GEN-LAST:event_delete_btnActionPerformed

    private void addsubject_btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addsubject_btn1ActionPerformed
        String CourseCode;
        String CourseTitle;
        String Credit;
        String Year;
        String Sem;
        String query;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(StudentCreateAccount1Frame.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(StudentCreateAccount1Frame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(new JFrame(), "Database connection failed: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

// Validation for empty fields
        if (subjectcode_field.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(new JFrame(), "Course Code is required", "Dialog", JOptionPane.ERROR_MESSAGE);
            isValid = false;
        } else if (subjecttitle_field.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(new JFrame(), "Course Title is required", "Dialog", JOptionPane.ERROR_MESSAGE);
            isValid = false;
        } else if (credits_field.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(new JFrame(), "Credit is required", "Dialog", JOptionPane.ERROR_MESSAGE);
            isValid = false;
        } else if (subjectyear_cbox.getSelectedItem().toString().isEmpty()) {
            JOptionPane.showMessageDialog(new JFrame(), "Year Level is required", "Dialog", JOptionPane.ERROR_MESSAGE);
            isValid = false;
        } else if (subjectsem_cbox.getSelectedItem().toString().isEmpty()) {
            JOptionPane.showMessageDialog(new JFrame(), "Semester is required", "Dialog", JOptionPane.ERROR_MESSAGE);
            isValid = false;

        }
        if (isValid) {
            // Retrieve input values
            CourseCode = subjectcode_field.getText().trim();
            CourseTitle = subjecttitle_field.getText().trim();
            Credit = credits_field.getText().trim(); // Store as String initiall         
            Year = (String) subjectyear_cbox.getSelectedItem();
            Sem = (String) subjectsem_cbox.getSelectedItem();

            // Proceed if all inputs are valid
            if (isValid) {
                query = "INSERT INTO tb_subjects (CourseCode, CourseName, Credits, Year, Semester) VALUES (?, ?, ?, ?, ?)";
                try {
                    PreparedStatement pst = con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
                    pst.setString(1, CourseCode);
                    pst.setString(2, CourseTitle);
                    pst.setString(3, Credit);
                    pst.setString(4, Year);
                    pst.setString(5, Sem);

                    pst.executeUpdate();

                    JOptionPane.showMessageDialog(new JFrame(), "Course added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);

                    displayDataInCoursesTable();  // Update the table with the newly added course

                } catch (SQLException e) {
                    System.out.println("Error " + e.getMessage());
                    JOptionPane.showMessageDialog(new JFrame(), "Database connection failed: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_addsubject_btn1ActionPerformed

    private void coursesearchyear_cboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_coursesearchyear_cboxActionPerformed

        String selectedYear = (String) coursesearchyear_cbox.getSelectedItem();
        String selectedSemester = (String) coursesearchsem_cbox.getSelectedItem();

        filterData(selectedYear, selectedSemester);

    }//GEN-LAST:event_coursesearchyear_cboxActionPerformed

    private void coursesearchsem_cboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_coursesearchsem_cboxActionPerformed

        String selectedYear = (String) coursesearchyear_cbox.getSelectedItem();
        String selectedSemester = (String) coursesearchsem_cbox.getSelectedItem();

        filterData(selectedYear, selectedSemester);
    }//GEN-LAST:event_coursesearchsem_cboxActionPerformed

    private void addclass_btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addclass_btn1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addclass_btn1ActionPerformed

    private void viewclass_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewclass_btnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_viewclass_btnActionPerformed

    private void addclass_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addclass_btnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addclass_btnActionPerformed

    private void classsearchyear_cboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_classsearchyear_cboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_classsearchyear_cboxActionPerformed

    private void classsearchsem_cboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_classsearchsem_cboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_classsearchsem_cboxActionPerformed

    private void classSearch_barFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_classSearch_barFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_classSearch_barFocusGained

    private void classSearch_barFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_classSearch_barFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_classSearch_barFocusLost

    private void coursesearchyear_cbox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_coursesearchyear_cbox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_coursesearchyear_cbox1ActionPerformed

    private void coursesearchsem_cbox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_coursesearchsem_cbox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_coursesearchsem_cbox1ActionPerformed

    private void coursesearch_bar1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_coursesearch_bar1FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_coursesearch_bar1FocusGained

    private void coursesearch_bar1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_coursesearch_bar1FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_coursesearch_bar1FocusLost

    private void removecourse_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removecourse_btnActionPerformed
        DefaultTableModel model = (DefaultTableModel) ViewClassesTable.getModel();

        // Get the selected row index
        int selectedRow = ViewClassesTable.getSelectedRow();

        // Check if a row is selected
        if (selectedRow != -1) {
            // Get the CourseCode from the selected row (assuming it's in the first column)
            String delCode = model.getValueAt(selectedRow, 0).toString();

            int confirmDelete = JOptionPane.showConfirmDialog(null,
                "Are you sure you want to delete this course?",
                "Delete Course",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE);

            // If the user confirms the deletion
            if (confirmDelete == JOptionPane.YES_OPTION) {
                // Remove the row from the JTable
                model.removeRow(selectedRow);

                // Now delete the course from the database
                deleteCourseFromDatabase(delCode);
                // Show a success message
                JOptionPane.showMessageDialog(null, "Course deleted successfully!");
            } else {
                // If the user cancels, you can add any additional logic here (optional)
                JOptionPane.showMessageDialog(null, "Course deletion cancelled.");
            }

        } else {
            // Handle the case where no row is selected
            if (ViewClassesTable.getRowCount() == 0) {
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
    }//GEN-LAST:event_removecourse_btnActionPerformed

    private void classsearchyear_cbox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_classsearchyear_cbox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_classsearchyear_cbox1ActionPerformed

    private void classsearchsem_cbox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_classsearchsem_cbox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_classsearchsem_cbox1ActionPerformed

    private void classSearch_bar1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_classSearch_bar1FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_classSearch_bar1FocusGained

    private void classSearch_bar1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_classSearch_bar1FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_classSearch_bar1FocusLost

    private void removeclass_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeclass_btnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_removeclass_btnActionPerformed

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
            java.util.logging.Logger.getLogger(StudentHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentHome(0).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable AddClassesTable;
    private javax.swing.JTable SubjectsTable;
    private javax.swing.JTable SubjectsTable1;
    private javax.swing.JTable ViewClassesTable;
    private javax.swing.JButton about_btn;
    private javax.swing.JLabel about_icon;
    private javax.swing.JPanel about_panel;
    private javax.swing.JButton addclass_btn;
    private javax.swing.JButton addclass_btn1;
    private javax.swing.JPanel addclass_form;
    private javax.swing.JPanel addclass_panel;
    private javax.swing.JPanel addclasses_table;
    private javax.swing.JLabel address_field;
    private javax.swing.JButton addsubject_btn;
    private javax.swing.JButton addsubject_btn1;
    private javax.swing.JPanel addsubject_form;
    private javax.swing.JPanel addsubject_panel;
    private javax.swing.JPanel addsubjects_table;
    private javax.swing.JLabel age_field;
    private javax.swing.JLabel announcement;
    private javax.swing.JLabel announcement_post;
    private javax.swing.JPanel background;
    private javax.swing.JLabel bday_field;
    private javax.swing.JTextField classSearch_bar;
    private javax.swing.JTextField classSearch_bar1;
    private javax.swing.JTextField classSection_field;
    private javax.swing.JComboBox<String> classSem_cbox;
    private javax.swing.JComboBox<String> classSem_cbox1;
    private javax.swing.JButton class_btn;
    private javax.swing.JPanel class_header;
    private javax.swing.JLabel class_icon;
    private javax.swing.JPanel class_panel;
    private javax.swing.JComboBox<String> classsearchsem_cbox;
    private javax.swing.JComboBox<String> classsearchsem_cbox1;
    private javax.swing.JComboBox<String> classsearchyear_cbox;
    private javax.swing.JComboBox<String> classsearchyear_cbox1;
    private javax.swing.JComboBox<String> classyear_cbox;
    private javax.swing.JComboBox<String> classyear_cbox1;
    private javax.swing.JButton clearreminder_btn;
    private javax.swing.JLabel contactnum_field;
    private javax.swing.JComboBox<String> course_cbox;
    private javax.swing.JComboBox<String> course_cbox1;
    private javax.swing.JLabel course_field;
    private javax.swing.JPanel course_panel;
    private javax.swing.JTextField coursesearch_bar;
    private javax.swing.JTextField coursesearch_bar1;
    private javax.swing.JComboBox<String> coursesearchsem_cbox;
    private javax.swing.JComboBox<String> coursesearchsem_cbox1;
    private javax.swing.JComboBox<String> coursesearchyear_cbox;
    private javax.swing.JComboBox<String> coursesearchyear_cbox1;
    private javax.swing.JLabel credits;
    private javax.swing.JLabel credits1;
    private javax.swing.JTextField credits_field;
    private javax.swing.JTextField credits_field1;
    private javax.swing.JLabel cvsum_field;
    private javax.swing.JButton delete_btn;
    private javax.swing.JButton edit_btn;
    private javax.swing.JComboBox<String> grades_cbox;
    private javax.swing.JPanel grades_panel;
    private javax.swing.JLabel greetings;
    private javax.swing.JPanel header;
    private javax.swing.JLabel header_element;
    private javax.swing.JPanel home_background;
    private javax.swing.JButton home_btn;
    private javax.swing.JLabel home_icon;
    private javax.swing.JPanel home_panel;
    private javax.swing.JLabel id_field;
    private javax.swing.JTabbedPane instructor_class_panels;
    private com.toedter.calendar.JCalendar jCalendar1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JButton logout_btn;
    private javax.swing.JLabel logout_icon;
    private javax.swing.JPanel logout_panel;
    private javax.swing.JLabel name_field;
    private javax.swing.JPanel navigation;
    private javax.swing.JLabel personal_info;
    private javax.swing.JPanel profile_background;
    private javax.swing.JButton profile_btn;
    private javax.swing.JLabel profile_icon;
    private javax.swing.JPanel profile_panel;
    private javax.swing.JTextArea reminder_field;
    private javax.swing.JPanel reminder_panel;
    private javax.swing.JButton removeclass_btn;
    private javax.swing.JButton removecourse_btn;
    private javax.swing.JButton savereminder_btn;
    private javax.swing.JLabel school_info;
    private javax.swing.JLabel section_field;
    private javax.swing.JLabel sex_field;
    private javax.swing.JPanel student_about;
    private javax.swing.JLabel student_address;
    private javax.swing.JLabel student_age;
    private javax.swing.JLabel student_bday;
    private javax.swing.JPanel student_class;
    private javax.swing.JLabel student_course;
    private javax.swing.JLabel student_email;
    private javax.swing.JPanel student_home;
    private javax.swing.JLabel student_name;
    private javax.swing.JLabel student_number;
    private javax.swing.JTabbedPane student_panels;
    private javax.swing.JPanel student_profile;
    private javax.swing.JLabel student_section;
    private javax.swing.JLabel student_sex;
    private javax.swing.JLabel student_studNumber;
    private javax.swing.JPanel student_subject;
    private javax.swing.JTabbedPane student_subject_panels;
    private javax.swing.JButton subject_btn;
    private javax.swing.JPanel subject_header;
    private javax.swing.JLabel subject_icon;
    private javax.swing.JTextField subjectcode_field;
    private javax.swing.JTextField subjectcode_field1;
    private javax.swing.JComboBox<String> subjectsem_cbox;
    private javax.swing.JComboBox<String> subjectsem_cbox1;
    private javax.swing.JTextField subjecttitle_field;
    private javax.swing.JTextField subjecttitle_field1;
    private javax.swing.JComboBox<String> subjectyear_cbox;
    private javax.swing.JComboBox<String> subjectyear_cbox1;
    private javax.swing.JLabel title1;
    private javax.swing.JLabel title2;
    private javax.swing.JLabel title4;
    private javax.swing.JTable top_performing_table;
    private javax.swing.JLabel total_grade;
    private javax.swing.JButton updatereminder_btn;
    private javax.swing.JButton viewclass_btn;
    private javax.swing.JPanel viewclass_form;
    private javax.swing.JPanel viewclass_panel;
    private javax.swing.JPanel viewclass_table;
    private javax.swing.JButton viewsubject_btn;
    private javax.swing.JPanel viewsubject_form;
    private javax.swing.JPanel viewsubject_panel;
    private javax.swing.JPanel viewsubjects_table1;
    // End of variables declaration//GEN-END:variables
}
