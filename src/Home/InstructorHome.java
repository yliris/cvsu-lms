package Home;

import Components.InstructorEditProfile;
import Components.UtilityMethods.DefaultFocus;
import static Components.UtilityMethods.DefaultText2;
import Login.StartFrame;
import Signup.InstructorCreateAccount1Frame;
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
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class InstructorHome extends javax.swing.JFrame {

    private static int userID;

    public InstructorHome(int userID) {
        InstructorHome.userID = userID;
        initComponents();
        displayDataInCoursesTable();
    }

    public static void setUserID(int userID) {
        InstructorHome.userID = userID;

//        System.out.println(userID);
    }

    private void filterData1(String selectedProgram, String selectedYear, String selectedSemester) {
        // Construct the query based on selected Year and Semester
        String query = "SELECT * FROM tb_subjects WHERE 1=1"; // Default query to show all records

        if (selectedProgram != null && !selectedProgram.isEmpty() && !selectedProgram.equals("All")) {
            // Add program filter
            query += " AND Program = '" + selectedProgram + "'";
        }
        if (selectedYear != null && !selectedYear.isEmpty() && !selectedYear.equals("All")) {
            // Add year filter if not "All"
            query += " AND Year = '" + selectedYear + "'";
        }
        if (selectedSemester != null && !selectedSemester.isEmpty() && !selectedSemester.equals("All")) {
            // Add semester filter if not "All"
            query += " AND Semester = '" + selectedSemester + "'";
        }

        // Now, apply the query to fetch filtered data from the database
        updateTable(query);
    }
    private void displayDataInCoursesTable() {
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
    
    public void refreshProfile(){
        String query = "SELECT * FROM tb_instructorinfo WHERE info_id = " + userID;

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

        query = "SELECT * FROM tb_createinstructor WHERE EmployeeID = " + userID;

        try (Connection con = DriverManager.getConnection(url, user, pass); PreparedStatement pst = con.prepareStatement(query); ResultSet rs = pst.executeQuery()) {
            if (rs.next()) {
                name_field.setText(rs.getString("Name"));
                cvsum_field.setText(rs.getString("CvSU_Mail"));
                dept_field.setText(rs.getString("Department"));
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
        instructor_panels = new javax.swing.JTabbedPane();
        instructor_home = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        top_performing_table = new javax.swing.JTable();
        total_enrolled_panel = new javax.swing.JPanel();
        title1 = new javax.swing.JLabel();
        total_result = new javax.swing.JLabel();
        home_background = new javax.swing.JPanel();
        post_announcement_panel = new javax.swing.JPanel();
        title2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        announcement_field = new javax.swing.JTextArea();
        delannounce_btn = new javax.swing.JButton();
        announce_btn = new javax.swing.JButton();
        jCalendar1 = new com.toedter.calendar.JCalendar();
        title4 = new javax.swing.JLabel();
        announcement_panel = new javax.swing.JPanel();
        announcement = new javax.swing.JLabel();
        announcement_post = new javax.swing.JLabel();
        instructor_course = new javax.swing.JPanel();
        instructor_course_panels = new javax.swing.JTabbedPane();
        addcourse_panel = new javax.swing.JPanel();
        course_form = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        credits = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        coursecode_field = new javax.swing.JTextField();
        credits_field = new javax.swing.JTextField();
        coursesem_cbox = new javax.swing.JComboBox<>();
        courseyear_cbox = new javax.swing.JComboBox<>();
        jLabel22 = new javax.swing.JLabel();
        deletecourse_btn = new javax.swing.JButton();
        addcourse_btn1 = new javax.swing.JButton();
        updatecourse_btn = new javax.swing.JButton();
        coursetitle_field = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        coursecode_field1 = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        courses_table = new javax.swing.JPanel();
        coursesearchyear_cbox = new javax.swing.JComboBox<>();
        coursesearchsem_cbox = new javax.swing.JComboBox<>();
        coursesearch_bar = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        CoursesTable = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        viewcourse_panel = new javax.swing.JPanel();
        viewcourse_background = new javax.swing.JPanel();
        courses_cbox = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        InstructorCoursesTable = new javax.swing.JTable();
        deleteclass_btn2 = new javax.swing.JButton();
        course_header = new javax.swing.JPanel();
        addcourse_btn = new javax.swing.JButton();
        viewcourse_btn = new javax.swing.JButton();
        instructor_class = new javax.swing.JPanel();
        instructor_class_panels = new javax.swing.JTabbedPane();
        addclass_panel = new javax.swing.JPanel();
        course_form1 = new javax.swing.JPanel();
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
        classes_table1 = new javax.swing.JPanel();
        classsearchyear_cbox = new javax.swing.JComboBox<>();
        classsearchsem_cbox = new javax.swing.JComboBox<>();
        classSearch_bar = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        ClassesTable = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        viewclass_panel = new javax.swing.JPanel();
        viewcourse_background1 = new javax.swing.JPanel();
        sem_cbox1 = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        InstructorCoursesTable1 = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        program_cbox2 = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        year_cbox3 = new javax.swing.JComboBox<>();
        searchfield = new javax.swing.JTextField();
        deleteclass_btn1 = new javax.swing.JButton();
        viewsection_panel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        section_table = new javax.swing.JTable();
        usersearch_bar = new javax.swing.JTextField();
        section_cbox = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        coursesearch = new javax.swing.JComboBox<>();
        jLabel29 = new javax.swing.JLabel();
        searchyear_cbox = new javax.swing.JComboBox<>();
        jLabel30 = new javax.swing.JLabel();
        searchsem_cbox = new javax.swing.JComboBox<>();
        studentgrade_field = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        studentname_field = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        studentnumber_field = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        course_cbox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        class_header = new javax.swing.JPanel();
        addclass_btn2 = new javax.swing.JButton();
        viewclass_btn1 = new javax.swing.JButton();
        viewsection_btn = new javax.swing.JButton();
        instructor_profile = new javax.swing.JPanel();
        profile_background = new javax.swing.JPanel();
        personal_info = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        instructor_name = new javax.swing.JLabel();
        instructor_age = new javax.swing.JLabel();
        instructor_sex = new javax.swing.JLabel();
        instructor_number = new javax.swing.JLabel();
        instructor_address = new javax.swing.JLabel();
        instructor_bday = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        edit_btn = new javax.swing.JButton();
        delete_btn = new javax.swing.JButton();
        name_field = new javax.swing.JLabel();
        age_field = new javax.swing.JLabel();
        sex_field = new javax.swing.JLabel();
        contactnum_field = new javax.swing.JLabel();
        address_field = new javax.swing.JLabel();
        bday_field = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        school_info = new javax.swing.JLabel();
        instructor_email = new javax.swing.JLabel();
        instructor_ID = new javax.swing.JLabel();
        instructor_department = new javax.swing.JLabel();
        cvsum_field = new javax.swing.JLabel();
        id_field = new javax.swing.JLabel();
        dept_field = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        instructor_about = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        navigation = new javax.swing.JPanel();
        home_panel = new javax.swing.JPanel();
        home_icon = new javax.swing.JLabel();
        home_btn = new javax.swing.JButton();
        course_panel = new javax.swing.JPanel();
        course_icon = new javax.swing.JLabel();
        course_btn = new javax.swing.JButton();
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
        jLabel1 = new javax.swing.JLabel();
        header = new javax.swing.JPanel();
        greetings = new javax.swing.JLabel();
        header_element = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Learning Management System - Instructor Home");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        background.setBackground(new java.awt.Color(255, 255, 255));
        background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        instructor_home.setBackground(new java.awt.Color(255, 255, 255));
        instructor_home.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        top_performing_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Name", "Student Number", "GWA"
            }
        ));
        jScrollPane2.setViewportView(top_performing_table);

        instructor_home.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 160, 380, 300));

        total_enrolled_panel.setBackground(new java.awt.Color(81, 199, 135));
        total_enrolled_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        title1.setFont(new java.awt.Font("Cascadia Mono", 1, 10)); // NOI18N
        title1.setForeground(new java.awt.Color(255, 255, 255));
        title1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title1.setText("Total Enrolled in your Class");
        total_enrolled_panel.add(title1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, 30));

        total_result.setFont(new java.awt.Font("Cascadia Mono", 1, 18)); // NOI18N
        total_result.setForeground(new java.awt.Color(255, 255, 255));
        total_result.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        total_result.setText("??");
        total_enrolled_panel.add(total_result, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, 90, 50));

        instructor_home.add(total_enrolled_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 210, 100));

        home_background.setBackground(new java.awt.Color(202, 154, 221));
        home_background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        post_announcement_panel.setBackground(new java.awt.Color(81, 199, 135));
        post_announcement_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        title2.setFont(new java.awt.Font("Cascadia Mono", 1, 12)); // NOI18N
        title2.setForeground(new java.awt.Color(255, 255, 255));
        title2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title2.setText("Post an Announcement");
        post_announcement_panel.add(title2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 390, 30));

        announcement_field.setBackground(new java.awt.Color(81, 199, 135));
        announcement_field.setColumns(20);
        announcement_field.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        announcement_field.setForeground(new java.awt.Color(255, 255, 255));
        announcement_field.setRows(5);
        jScrollPane1.setViewportView(announcement_field);

        post_announcement_panel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 370, -1));

        delannounce_btn.setBackground(new java.awt.Color(225, 70, 70));
        delannounce_btn.setFont(new java.awt.Font("Cascadia Mono", 0, 10)); // NOI18N
        delannounce_btn.setForeground(new java.awt.Color(255, 255, 255));
        delannounce_btn.setText("Delete");
        post_announcement_panel.add(delannounce_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 125, 80, 20));

        announce_btn.setBackground(new java.awt.Color(164, 83, 197));
        announce_btn.setFont(new java.awt.Font("Cascadia Mono", 0, 10)); // NOI18N
        announce_btn.setForeground(new java.awt.Color(255, 255, 255));
        announce_btn.setText("Announce");
        announce_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                announce_btnActionPerformed(evt);
            }
        });
        post_announcement_panel.add(announce_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 125, 80, 20));

        home_background.add(post_announcement_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 390, 150));

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

        announcement_panel.setBackground(new java.awt.Color(81, 199, 135));
        announcement_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        announcement.setFont(new java.awt.Font("Cascadia Mono", 1, 12)); // NOI18N
        announcement.setForeground(new java.awt.Color(255, 255, 255));
        announcement.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        announcement.setText("Announcement");
        announcement_panel.add(announcement, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 560, 30));

        announcement_post.setFont(new java.awt.Font("Cascadia Mono", 1, 12)); // NOI18N
        announcement_post.setForeground(new java.awt.Color(255, 255, 255));
        announcement_post.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        announcement_post.setText("(Announcement)");
        announcement_panel.add(announcement_post, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 560, 70));

        home_background.add(announcement_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, 560, 100));

        instructor_home.add(home_background, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 800, 450));

        instructor_panels.addTab("tab1", instructor_home);

        instructor_course.setBackground(new java.awt.Color(255, 255, 255));
        instructor_course.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        addcourse_panel.setBackground(new java.awt.Color(255, 255, 255));
        addcourse_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        course_form.setBackground(new java.awt.Color(81, 199, 135));
        course_form.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel19.setFont(new java.awt.Font("Cascadia Mono", 0, 10)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel19.setText("Semester:");
        course_form.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 230, 90, 20));

        jLabel18.setFont(new java.awt.Font("Cascadia Mono", 0, 10)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel18.setText("Program:");
        course_form.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 80, 90, 20));

        credits.setFont(new java.awt.Font("Cascadia Mono", 0, 10)); // NOI18N
        credits.setForeground(new java.awt.Color(255, 255, 255));
        credits.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        credits.setText("Credits:");
        course_form.add(credits, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 170, 90, 20));

        jLabel21.setFont(new java.awt.Font("Cascadia Mono", 0, 10)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel21.setText("Year:");
        course_form.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 200, 90, 20));

        coursecode_field.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        course_form.add(coursecode_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, 130, -1));

        credits_field.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        course_form.add(credits_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 170, 130, -1));

        coursesem_cbox.setBackground(new java.awt.Color(3, 159, 75));
        coursesem_cbox.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        coursesem_cbox.setForeground(new java.awt.Color(255, 255, 255));
        coursesem_cbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1st", "2nd" }));
        course_form.add(coursesem_cbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 230, 80, 20));

        courseyear_cbox.setBackground(new java.awt.Color(3, 159, 75));
        courseyear_cbox.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        courseyear_cbox.setForeground(new java.awt.Color(255, 255, 255));
        courseyear_cbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1st", "2nd", "3rd", "Midyear", "4th" }));
        course_form.add(courseyear_cbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, 80, 20));

        jLabel22.setFont(new java.awt.Font("Cascadia Mono", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("Course Form");
        course_form.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(-30, 10, 260, 40));

        deletecourse_btn.setBackground(new java.awt.Color(233, 82, 82));
        deletecourse_btn.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        deletecourse_btn.setForeground(new java.awt.Color(255, 255, 255));
        deletecourse_btn.setText("Delete Course");
        deletecourse_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletecourse_btnActionPerformed(evt);
            }
        });
        course_form.add(deletecourse_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 170, 30));

        addcourse_btn1.setBackground(new java.awt.Color(48, 150, 95));
        addcourse_btn1.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        addcourse_btn1.setForeground(new java.awt.Color(255, 255, 255));
        addcourse_btn1.setText("Add Course");
        addcourse_btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addcourse_btn1ActionPerformed(evt);
            }
        });
        course_form.add(addcourse_btn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 170, 30));

        updatecourse_btn.setBackground(new java.awt.Color(170, 170, 23));
        updatecourse_btn.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        updatecourse_btn.setForeground(new java.awt.Color(255, 255, 255));
        updatecourse_btn.setText("Update Course");
        updatecourse_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatecourse_btnActionPerformed(evt);
            }
        });
        course_form.add(updatecourse_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 170, 30));

        coursetitle_field.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        course_form.add(coursetitle_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, 130, -1));

        jLabel25.setFont(new java.awt.Font("Cascadia Mono", 0, 10)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel25.setText("Course Title:");
        course_form.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 140, 90, 20));

        coursecode_field1.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        course_form.add(coursecode_field1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, 130, -1));

        jLabel28.setFont(new java.awt.Font("Cascadia Mono", 0, 10)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel28.setText("Course Code:");
        course_form.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 110, 90, 20));

        addcourse_panel.add(course_form, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 210, 410));

        courses_table.setBackground(new java.awt.Color(202, 154, 221));
        courses_table.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        coursesearchyear_cbox.setFont(new java.awt.Font("Cascadia Mono", 0, 10)); // NOI18N
        coursesearchyear_cbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "1st", "2nd", "3rd", "Midyear", "4th" }));
        coursesearchyear_cbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                coursesearchyear_cboxActionPerformed(evt);
            }
        });
        courses_table.add(coursesearchyear_cbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 140, 20));

        coursesearchsem_cbox.setFont(new java.awt.Font("Cascadia Mono", 0, 10)); // NOI18N
        coursesearchsem_cbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "1st", "2nd" }));
        coursesearchsem_cbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                coursesearchsem_cboxActionPerformed(evt);
            }
        });
        courses_table.add(coursesearchsem_cbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, 130, 20));

        coursesearch_bar.setFont(new java.awt.Font("Cascadia Mono", 0, 10)); // NOI18N
        coursesearch_bar.setText("Enter Course Code / Title");
        coursesearch_bar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                coursesearch_barFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                coursesearch_barFocusLost(evt);
            }
        });
        coursesearch_bar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                coursesearch_barActionPerformed(evt);
            }
        });
        courses_table.add(coursesearch_bar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 20, 230, 20));

        CoursesTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(CoursesTable);

        courses_table.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 570, 360));

        jLabel4.setFont(new java.awt.Font("Cascadia Mono", 0, 8)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/icons/search-icon.png"))); // NOI18N
        courses_table.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 20, -1, 20));

        jLabel3.setFont(new java.awt.Font("Cascadia Mono", 0, 8)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Semester");
        jLabel3.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        courses_table.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 0, 110, 20));

        jLabel2.setFont(new java.awt.Font("Cascadia Mono", 0, 8)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Year");
        jLabel2.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        courses_table.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 110, 20));

        addcourse_panel.add(courses_table, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 20, 590, 410));

        instructor_course_panels.addTab("tab1", addcourse_panel);

        viewcourse_panel.setBackground(new java.awt.Color(255, 255, 255));
        viewcourse_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        viewcourse_background.setBackground(new java.awt.Color(81, 199, 135));
        viewcourse_background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        courses_cbox.setBackground(new java.awt.Color(164, 83, 197));
        courses_cbox.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        courses_cbox.setForeground(new java.awt.Color(255, 255, 255));
        courses_cbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        viewcourse_background.add(courses_cbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 230, -1));

        jLabel5.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Your Courses:");
        viewcourse_background.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 20));

        InstructorCoursesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Program", "Course Code", "Course Title", "Year", "Semester", "Class Section"
            }
        ));
        jScrollPane4.setViewportView(InstructorCoursesTable);

        viewcourse_background.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 780, 320));

        deleteclass_btn2.setBackground(new java.awt.Color(233, 82, 82));
        deleteclass_btn2.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        deleteclass_btn2.setForeground(new java.awt.Color(255, 255, 255));
        deleteclass_btn2.setText("Drop Class");
        deleteclass_btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteclass_btn2ActionPerformed(evt);
            }
        });
        viewcourse_background.add(deleteclass_btn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 370, 240, 30));

        viewcourse_panel.add(viewcourse_background, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 800, 410));

        instructor_course_panels.addTab("tab2", viewcourse_panel);

        instructor_course.add(instructor_course_panels, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 820, 470));

        course_header.setBackground(new java.awt.Color(255, 255, 255));
        course_header.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        addcourse_btn.setBackground(new java.awt.Color(164, 83, 197));
        addcourse_btn.setFont(new java.awt.Font("Cascadia Mono", 1, 12)); // NOI18N
        addcourse_btn.setForeground(new java.awt.Color(255, 255, 255));
        addcourse_btn.setText("Add Course");
        addcourse_btn.setBorderPainted(false);
        addcourse_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addcourse_btnActionPerformed(evt);
            }
        });
        course_header.add(addcourse_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 120, 30));

        viewcourse_btn.setBackground(new java.awt.Color(164, 83, 197));
        viewcourse_btn.setFont(new java.awt.Font("Cascadia Mono", 1, 12)); // NOI18N
        viewcourse_btn.setForeground(new java.awt.Color(255, 255, 255));
        viewcourse_btn.setText("View Course");
        viewcourse_btn.setBorderPainted(false);
        viewcourse_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewcourse_btnActionPerformed(evt);
            }
        });
        course_header.add(viewcourse_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 120, 30));

        instructor_course.add(course_header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 50));

        instructor_panels.addTab("tab2", instructor_course);

        instructor_class.setBackground(new java.awt.Color(255, 255, 255));
        instructor_class.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        addclass_panel.setBackground(new java.awt.Color(255, 255, 255));
        addclass_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        course_form1.setBackground(new java.awt.Color(202, 154, 221));
        course_form1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel27.setFont(new java.awt.Font("Cascadia Mono", 0, 10)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel27.setText("Sem:");
        course_form1.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 90, 20));

        jLabel20.setFont(new java.awt.Font("Cascadia Mono", 0, 10)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel20.setText("Year:");
        course_form1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 90, 20));

        jLabel23.setFont(new java.awt.Font("Cascadia Mono", 0, 10)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel23.setText("Class Section:");
        course_form1.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 90, 20));

        jLabel24.setFont(new java.awt.Font("Cascadia Mono", 0, 10)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel24.setText("Class Program:");
        course_form1.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 90, 20));

        classSem_cbox.setBackground(new java.awt.Color(164, 83, 197));
        classSem_cbox.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        classSem_cbox.setForeground(new java.awt.Color(255, 255, 255));
        classSem_cbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1st", "2nd" }));
        course_form1.add(classSem_cbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 210, 160, 20));

        classSection_field.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        classSection_field.setText("Add section.");
        course_form1.add(classSection_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 140, 160, -1));

        classyear_cbox.setBackground(new java.awt.Color(164, 83, 197));
        classyear_cbox.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        classyear_cbox.setForeground(new java.awt.Color(255, 255, 255));
        classyear_cbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1st", "2nd", "3rd", "Midyear", "4th" }));
        course_form1.add(classyear_cbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 180, 160, 20));

        course_cbox.setBackground(new java.awt.Color(164, 83, 197));
        course_cbox.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        course_cbox.setForeground(new java.awt.Color(255, 255, 255));
        course_cbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "BSCS", "BSIT" }));
        course_form1.add(course_cbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, 160, 20));

        jLabel26.setFont(new java.awt.Font("Cascadia Mono", 1, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("Class Form");
        course_form1.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 260, 40));

        addclass_btn.setBackground(new java.awt.Color(48, 150, 95));
        addclass_btn.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        addclass_btn.setForeground(new java.awt.Color(255, 255, 255));
        addclass_btn.setText("Add Class To Your Class");
        addclass_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addclass_btnActionPerformed(evt);
            }
        });
        course_form1.add(addclass_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 240, 30));

        addclass_panel.add(course_form1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 260, 410));

        classes_table1.setBackground(new java.awt.Color(81, 199, 135));
        classes_table1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        classsearchyear_cbox.setFont(new java.awt.Font("Cascadia Mono", 0, 10)); // NOI18N
        classsearchyear_cbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "1st", "2nd", "3rd", "Midyear", "4th" }));
        classsearchyear_cbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                classsearchyear_cboxActionPerformed(evt);
            }
        });
        classes_table1.add(classsearchyear_cbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 110, 20));

        classsearchsem_cbox.setFont(new java.awt.Font("Cascadia Mono", 0, 10)); // NOI18N
        classsearchsem_cbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "1st", "2nd" }));
        classsearchsem_cbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                classsearchsem_cboxActionPerformed(evt);
            }
        });
        classes_table1.add(classsearchsem_cbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, 110, 20));

        classSearch_bar.setFont(new java.awt.Font("Cascadia Mono", 0, 10)); // NOI18N
        classSearch_bar.setText("Search");
        classSearch_bar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                classSearch_barFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                classSearch_barFocusLost(evt);
            }
        });
        classes_table1.add(classSearch_bar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 20, 230, 20));

        ClassesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Program", "Course Code", "Course Title", "Year", "Semester"
            }
        ));
        ClassesTable.setToolTipText("");
        jScrollPane5.setViewportView(ClassesTable);

        classes_table1.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 520, 360));

        jLabel7.setFont(new java.awt.Font("Cascadia Mono", 0, 8)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/icons/search-icon.png"))); // NOI18N
        classes_table1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 20, -1, 20));

        jLabel8.setFont(new java.awt.Font("Cascadia Mono", 0, 8)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Semester");
        jLabel8.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel8.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        classes_table1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 0, 110, 20));

        jLabel9.setFont(new java.awt.Font("Cascadia Mono", 0, 8)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Year");
        jLabel9.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel9.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        classes_table1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 110, 20));

        addclass_panel.add(classes_table1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 20, 540, 410));

        instructor_class_panels.addTab("tab1", addclass_panel);

        viewclass_panel.setBackground(new java.awt.Color(255, 255, 255));
        viewclass_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        viewcourse_background1.setBackground(new java.awt.Color(81, 199, 135));
        viewcourse_background1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sem_cbox1.setBackground(new java.awt.Color(3, 159, 75));
        sem_cbox1.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        sem_cbox1.setForeground(new java.awt.Color(255, 255, 255));
        sem_cbox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "1st", "2nd", " " }));
        sem_cbox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sem_cbox1ActionPerformed(evt);
            }
        });
        viewcourse_background1.add(sem_cbox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 10, 60, -1));

        jLabel10.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Semester:");
        viewcourse_background1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 10, 70, 20));

        InstructorCoursesTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Program", "Course Code", "Course Title", "Year", "Semester", "Class Section"
            }
        ));
        jScrollPane6.setViewportView(InstructorCoursesTable1);

        viewcourse_background1.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 780, 320));

        jLabel11.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Your Classes:");
        viewcourse_background1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 20));

        jLabel12.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Program:");
        viewcourse_background1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, -1, 20));

        program_cbox2.setBackground(new java.awt.Color(3, 159, 75));
        program_cbox2.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        program_cbox2.setForeground(new java.awt.Color(255, 255, 255));
        program_cbox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "BSCE", "BSCS", "BSIT", "BSIS", "BSOA" }));
        program_cbox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                program_cbox2ActionPerformed(evt);
            }
        });
        viewcourse_background1.add(program_cbox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, 120, -1));

        jLabel13.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Year:");
        viewcourse_background1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, 40, 20));

        year_cbox3.setBackground(new java.awt.Color(3, 159, 75));
        year_cbox3.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        year_cbox3.setForeground(new java.awt.Color(255, 255, 255));
        year_cbox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "1st", "2nd", "3rd", "Midyear", "4th" }));
        year_cbox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                year_cbox3ActionPerformed(evt);
            }
        });
        viewcourse_background1.add(year_cbox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 10, 60, -1));

        searchfield.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        searchfield.setText("Search Courses");
        searchfield.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                searchfieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                searchfieldFocusLost(evt);
            }
        });
        searchfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchfieldActionPerformed(evt);
            }
        });
        searchfield.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchfieldKeyReleased(evt);
            }
        });
        viewcourse_background1.add(searchfield, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 10, 160, -1));

        deleteclass_btn1.setBackground(new java.awt.Color(233, 82, 82));
        deleteclass_btn1.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        deleteclass_btn1.setForeground(new java.awt.Color(255, 255, 255));
        deleteclass_btn1.setText("Drop Class");
        deleteclass_btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteclass_btn1ActionPerformed(evt);
            }
        });
        viewcourse_background1.add(deleteclass_btn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 370, 240, 30));

        viewclass_panel.add(viewcourse_background1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 800, 410));

        instructor_class_panels.addTab("tab2", viewclass_panel);

        viewsection_panel.setBackground(new java.awt.Color(255, 255, 255));
        viewsection_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(202, 154, 221));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        section_table.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane7.setViewportView(section_table);

        jPanel2.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 50, 590, 370));

        usersearch_bar.setText("Search Student");
        usersearch_bar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                usersearch_barFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                usersearch_barFocusLost(evt);
            }
        });
        usersearch_bar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                usersearch_barKeyReleased(evt);
            }
        });
        jPanel2.add(usersearch_bar, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 10, 190, 30));

        section_cbox.setBackground(new java.awt.Color(164, 83, 197));
        section_cbox.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        section_cbox.setForeground(new java.awt.Color(255, 255, 255));
        section_cbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "BSCE", "BSCS", "BSIT", "BSIS", "BSOA" }));
        section_cbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                section_cboxActionPerformed(evt);
            }
        });
        jPanel2.add(section_cbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 130, 30));

        jLabel14.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Section:");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 30));

        jLabel17.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel17.setText("Program:");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, 70, 30));

        coursesearch.setBackground(new java.awt.Color(164, 83, 197));
        coursesearch.setForeground(new java.awt.Color(255, 255, 255));
        coursesearch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "BSCS", "BSCE", "BSIT", "BSIS", "BSOA" }));
        coursesearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                coursesearchActionPerformed(evt);
            }
        });
        jPanel2.add(coursesearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, 110, 30));

        jLabel29.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel29.setText("Year:");
        jPanel2.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 10, 50, 30));

        searchyear_cbox.setBackground(new java.awt.Color(164, 83, 197));
        searchyear_cbox.setForeground(new java.awt.Color(255, 255, 255));
        searchyear_cbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "1st", "2nd", "3rd", "Midyear", "4th", " " }));
        searchyear_cbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchyear_cboxActionPerformed(evt);
            }
        });
        jPanel2.add(searchyear_cbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 10, 60, 30));

        jLabel30.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel30.setText("Sem:");
        jPanel2.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 10, 40, 30));

        searchsem_cbox.setBackground(new java.awt.Color(164, 83, 197));
        searchsem_cbox.setForeground(new java.awt.Color(255, 255, 255));
        searchsem_cbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "1st", "2nd" }));
        searchsem_cbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchsem_cboxActionPerformed(evt);
            }
        });
        jPanel2.add(searchsem_cbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 10, 50, 30));
        jPanel2.add(studentgrade_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 240, 130, -1));

        jLabel31.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("Grade:");
        jPanel2.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 50, 20));

        jLabel15.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Name:");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 180, 20));
        jPanel2.add(studentname_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 180, -1));

        jLabel16.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Student No.:");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 180, 20));
        jPanel2.add(studentnumber_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 180, -1));

        jLabel32.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("Program:");
        jPanel2.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 180, 20));

        course_cbox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "BS in Computer Science" }));
        jPanel2.add(course_cbox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 180, -1));

        jButton1.setBackground(new java.awt.Color(233, 82, 82));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("button");
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, 180, 30));

        jButton2.setBackground(new java.awt.Color(48, 150, 95));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("button");
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 180, 30));

        jButton3.setBackground(new java.awt.Color(170, 170, 23));
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("button");
        jPanel2.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 180, 30));

        viewsection_panel.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 800, 420));

        instructor_class_panels.addTab("tab3", viewsection_panel);

        instructor_class.add(instructor_class_panels, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 820, 470));

        class_header.setBackground(new java.awt.Color(255, 255, 255));
        class_header.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        addclass_btn2.setBackground(new java.awt.Color(3, 159, 75));
        addclass_btn2.setFont(new java.awt.Font("Cascadia Mono", 1, 12)); // NOI18N
        addclass_btn2.setForeground(new java.awt.Color(255, 255, 255));
        addclass_btn2.setText("Add Class");
        addclass_btn2.setBorderPainted(false);
        addclass_btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addclass_btn2ActionPerformed(evt);
            }
        });
        class_header.add(addclass_btn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 120, 30));

        viewclass_btn1.setBackground(new java.awt.Color(3, 159, 75));
        viewclass_btn1.setFont(new java.awt.Font("Cascadia Mono", 1, 12)); // NOI18N
        viewclass_btn1.setForeground(new java.awt.Color(255, 255, 255));
        viewclass_btn1.setText("View Class");
        viewclass_btn1.setBorderPainted(false);
        viewclass_btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewclass_btn1ActionPerformed(evt);
            }
        });
        class_header.add(viewclass_btn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 120, 30));

        viewsection_btn.setBackground(new java.awt.Color(3, 159, 75));
        viewsection_btn.setFont(new java.awt.Font("Cascadia Mono", 1, 12)); // NOI18N
        viewsection_btn.setForeground(new java.awt.Color(255, 255, 255));
        viewsection_btn.setText("View Section");
        viewsection_btn.setBorderPainted(false);
        viewsection_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewsection_btnActionPerformed(evt);
            }
        });
        class_header.add(viewsection_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, 120, 30));

        instructor_class.add(class_header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 50));

        instructor_panels.addTab("tab3", instructor_class);

        instructor_profile.setBackground(new java.awt.Color(255, 255, 255));
        instructor_profile.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        profile_background.setBackground(new java.awt.Color(81, 199, 135));
        profile_background.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        profile_background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        personal_info.setFont(new java.awt.Font("Cascadia Mono", 1, 18)); // NOI18N
        personal_info.setForeground(new java.awt.Color(255, 255, 255));
        personal_info.setText("Personal Details");
        profile_background.add(personal_info, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));
        profile_background.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 780, 10));

        instructor_name.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        instructor_name.setForeground(new java.awt.Color(255, 255, 255));
        instructor_name.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        instructor_name.setText("Name:");
        profile_background.add(instructor_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 110, 30));

        instructor_age.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        instructor_age.setForeground(new java.awt.Color(255, 255, 255));
        instructor_age.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        instructor_age.setText("Age:");
        profile_background.add(instructor_age, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 110, 30));

        instructor_sex.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        instructor_sex.setForeground(new java.awt.Color(255, 255, 255));
        instructor_sex.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        instructor_sex.setText("Sex:");
        profile_background.add(instructor_sex, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 110, 30));

        instructor_number.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        instructor_number.setForeground(new java.awt.Color(255, 255, 255));
        instructor_number.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        instructor_number.setText("Contact Number:");
        profile_background.add(instructor_number, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 110, 30));

        instructor_address.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        instructor_address.setForeground(new java.awt.Color(255, 255, 255));
        instructor_address.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        instructor_address.setText("Address:");
        profile_background.add(instructor_address, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 110, 30));

        instructor_bday.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        instructor_bday.setForeground(new java.awt.Color(255, 255, 255));
        instructor_bday.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        instructor_bday.setText("Birthdate:");
        profile_background.add(instructor_bday, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 110, 30));
        profile_background.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 760, 10));
        profile_background.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, 760, 10));

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
        profile_background.add(name_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 50, 640, 30));

        age_field.setForeground(new java.awt.Color(255, 255, 255));
        age_field.setText("age");
        profile_background.add(age_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, 640, 30));

        sex_field.setForeground(new java.awt.Color(255, 255, 255));
        sex_field.setText("sex");
        profile_background.add(sex_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, 640, 30));

        contactnum_field.setForeground(new java.awt.Color(255, 255, 255));
        contactnum_field.setText("cp num");
        profile_background.add(contactnum_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, 640, 30));

        address_field.setForeground(new java.awt.Color(255, 255, 255));
        address_field.setText("address");
        profile_background.add(address_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, 640, 30));

        bday_field.setForeground(new java.awt.Color(255, 255, 255));
        bday_field.setText("bday");
        profile_background.add(bday_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 200, 640, 30));

        jPanel1.setBackground(new java.awt.Color(202, 154, 221));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        school_info.setFont(new java.awt.Font("Cascadia Mono", 1, 18)); // NOI18N
        school_info.setForeground(new java.awt.Color(255, 255, 255));
        school_info.setText("School Details");
        jPanel1.add(school_info, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        instructor_email.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        instructor_email.setForeground(new java.awt.Color(255, 255, 255));
        instructor_email.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        instructor_email.setText("CvSU Email:");
        jPanel1.add(instructor_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 90, 30));

        instructor_ID.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        instructor_ID.setForeground(new java.awt.Color(255, 255, 255));
        instructor_ID.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        instructor_ID.setText("Employee ID:");
        jPanel1.add(instructor_ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 90, 30));

        instructor_department.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        instructor_department.setForeground(new java.awt.Color(255, 255, 255));
        instructor_department.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        instructor_department.setText("Department:");
        jPanel1.add(instructor_department, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 90, 30));

        cvsum_field.setForeground(new java.awt.Color(255, 255, 255));
        cvsum_field.setText("cvsu");
        jPanel1.add(cvsum_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 650, 30));

        id_field.setForeground(new java.awt.Color(255, 255, 255));
        id_field.setText("id");
        jPanel1.add(id_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, 650, 30));

        dept_field.setForeground(new java.awt.Color(255, 255, 255));
        dept_field.setText("dept");
        jPanel1.add(dept_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, 650, 30));

        profile_background.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 780, 170));
        profile_background.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 760, 10));

        instructor_profile.add(profile_background, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 800, 450));

        instructor_panels.addTab("tab4", instructor_profile);

        instructor_about.setBackground(new java.awt.Color(255, 255, 255));
        instructor_about.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/backgrounds/about-elements.png"))); // NOI18N
        instructor_about.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        instructor_panels.addTab("tab5", instructor_about);

        background.add(instructor_panels, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 30, 820, 510));

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

        course_icon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        course_icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/icons/courses-icon.png"))); // NOI18N
        course_panel.add(course_icon, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 20, 20));

        course_btn.setBackground(new java.awt.Color(164, 83, 197));
        course_btn.setFont(new java.awt.Font("Cascadia Mono", 1, 10)); // NOI18N
        course_btn.setForeground(new java.awt.Color(255, 255, 255));
        course_btn.setText("COURSE");
        course_btn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(162, 79, 195), 1, true));
        course_btn.setBorderPainted(false);
        course_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                course_btnActionPerformed(evt);
            }
        });
        course_panel.add(course_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 130, 40));

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

        jLabel1.setText("delete me");
        navigation.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 370, -1, -1));

        background.add(navigation, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 150, 450));

        header.setBackground(new java.awt.Color(202, 154, 221));
        header.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        greetings.setFont(new java.awt.Font("Cascadia Mono", 1, 18)); // NOI18N
        greetings.setForeground(new java.awt.Color(255, 255, 255));
        greetings.setText("Welcome, (instructor name)!");
        header.add(greetings, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 0, 880, 70));

        header_element.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/backgrounds/header-background.png"))); // NOI18N
        header.add(header_element, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 70));

        background.add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 980, 70));

        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 980, 540));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void home_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_home_btnActionPerformed
        instructor_panels.setSelectedIndex(0);
    }//GEN-LAST:event_home_btnActionPerformed

    private void course_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_course_btnActionPerformed
        instructor_panels.setSelectedIndex(1);
    }//GEN-LAST:event_course_btnActionPerformed

    private void class_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_class_btnActionPerformed
        instructor_panels.setSelectedIndex(2);
    }//GEN-LAST:event_class_btnActionPerformed

    private void profile_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profile_btnActionPerformed
        instructor_panels.setSelectedIndex(3);

        refreshProfile();
    }//GEN-LAST:event_profile_btnActionPerformed

    private void about_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_about_btnActionPerformed
        instructor_panels.setSelectedIndex(4);
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

    private void addcourse_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addcourse_btnActionPerformed
        instructor_course_panels.setSelectedIndex(0);
    }//GEN-LAST:event_addcourse_btnActionPerformed

    private void viewcourse_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewcourse_btnActionPerformed
        instructor_course_panels.setSelectedIndex(1);
    }//GEN-LAST:event_viewcourse_btnActionPerformed

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
        new InstructorEditProfile(userID, this).setVisible(true);
        InstructorEditProfile.setUserID(userID);
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

    private void addcourse_btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addcourse_btn1ActionPerformed
        String CourseCode;
        String CourseTitle;
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
        } else if (courseyear_cbox.getSelectedItem().toString().isEmpty()) {
            JOptionPane.showMessageDialog(new JFrame(), "Year Level is required", "Dialog", JOptionPane.ERROR_MESSAGE);
            isValid = false;
        } else if (coursesem_cbox.getSelectedItem().toString().isEmpty()) {
            JOptionPane.showMessageDialog(new JFrame(), "Semester is required", "Dialog", JOptionPane.ERROR_MESSAGE);
            isValid = false;

        }
        if (isValid) {
            // Retrieve input values
            CourseCode = coursecode_field.getText().trim();
            CourseTitle = coursetitle_field.getText().trim();
            Credit = credits_field.getText().trim(); // Store as String initiall         
            Year = (String) courseyear_cbox.getSelectedItem();
            Sem = (String) coursesem_cbox.getSelectedItem();

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
    }//GEN-LAST:event_addcourse_btn1ActionPerformed

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
            updYear = (String) courseyear_cbox.getSelectedItem();
            updSem = (String) coursesem_cbox.getSelectedItem();

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

    private void addclass_btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addclass_btn2ActionPerformed
        instructor_class_panels.setSelectedIndex(0);
    }//GEN-LAST:event_addclass_btn2ActionPerformed

    private void viewclass_btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewclass_btn1ActionPerformed
        instructor_class_panels.setSelectedIndex(1);
    }//GEN-LAST:event_viewclass_btn1ActionPerformed

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

    private void searchfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchfieldActionPerformed

    private void searchfieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchfieldFocusGained
        DefaultText2(searchfield, "Search Instructor", DefaultFocus.GAINED);
    }//GEN-LAST:event_searchfieldFocusGained

    private void searchfieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchfieldFocusLost
        DefaultText2(searchfield, "Search Instructor", DefaultFocus.LOST);
    }//GEN-LAST:event_searchfieldFocusLost

    private void program_cbox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_program_cbox2ActionPerformed
        String selectedProgram = (String) program_cbox2.getSelectedItem();
        String selectedYear = (String) year_cbox3.getSelectedItem();
        String selectedSemester = (String) sem_cbox1.getSelectedItem();

        filterData1(selectedProgram, selectedYear, selectedSemester);

    }//GEN-LAST:event_program_cbox2ActionPerformed

    private void year_cbox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_year_cbox3ActionPerformed
        String selectedProgram = (String) program_cbox2.getSelectedItem();
        String selectedYear = (String) year_cbox3.getSelectedItem();
        String selectedSemester = (String) sem_cbox1.getSelectedItem();

        filterData1(selectedProgram, selectedYear, selectedSemester);

    }//GEN-LAST:event_year_cbox3ActionPerformed

    private void sem_cbox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sem_cbox1ActionPerformed
        String selectedProgram = (String) program_cbox2.getSelectedItem();
        String selectedYear = (String) year_cbox3.getSelectedItem();
        String selectedSemester = (String) sem_cbox1.getSelectedItem();

        filterData1(selectedProgram, selectedYear, selectedSemester);

    }//GEN-LAST:event_sem_cbox1ActionPerformed

    private void searchfieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchfieldKeyReleased
        DefaultTableModel model = (DefaultTableModel) InstructorCoursesTable1.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        InstructorCoursesTable1.setRowSorter(sorter);

        // Apply a case-insensitive regex filter with the (?i) flag
        sorter.setRowFilter(RowFilter.regexFilter("(?i)" + searchfield.getText()));
    }//GEN-LAST:event_searchfieldKeyReleased

    private void announce_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_announce_btnActionPerformed
        
        
    }//GEN-LAST:event_announce_btnActionPerformed

    private void deleteclass_btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteclass_btn1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteclass_btn1ActionPerformed

    private void deleteclass_btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteclass_btn2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteclass_btn2ActionPerformed

    private void coursesearch_barActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_coursesearch_barActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_coursesearch_barActionPerformed

    private void viewsection_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewsection_btnActionPerformed
        instructor_class_panels.setSelectedIndex(2);
    }//GEN-LAST:event_viewsection_btnActionPerformed

    private void usersearch_barFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_usersearch_barFocusGained
        DefaultText2(usersearch_bar, "Search Student", DefaultFocus.GAINED);
    }//GEN-LAST:event_usersearch_barFocusGained

    private void usersearch_barFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_usersearch_barFocusLost
        DefaultText2(usersearch_bar, "Search Student", DefaultFocus.LOST);
    }//GEN-LAST:event_usersearch_barFocusLost

    private void usersearch_barKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_usersearch_barKeyReleased
        
    }//GEN-LAST:event_usersearch_barKeyReleased

    private void section_cboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_section_cboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_section_cboxActionPerformed

    private void coursesearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_coursesearchActionPerformed
        
    }//GEN-LAST:event_coursesearchActionPerformed

    private void searchyear_cboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchyear_cboxActionPerformed
        
    }//GEN-LAST:event_searchyear_cboxActionPerformed

    private void searchsem_cboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchsem_cboxActionPerformed
        
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
            java.util.logging.Logger.getLogger(InstructorHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InstructorHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InstructorHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InstructorHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InstructorHome(0).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable ClassesTable;
    private javax.swing.JTable CoursesTable;
    private javax.swing.JTable InstructorCoursesTable;
    private javax.swing.JTable InstructorCoursesTable1;
    private javax.swing.JButton about_btn;
    private javax.swing.JLabel about_icon;
    private javax.swing.JPanel about_panel;
    private javax.swing.JButton addclass_btn;
    private javax.swing.JButton addclass_btn2;
    private javax.swing.JPanel addclass_panel;
    private javax.swing.JButton addcourse_btn;
    private javax.swing.JButton addcourse_btn1;
    private javax.swing.JPanel addcourse_panel;
    private javax.swing.JLabel address_field;
    private javax.swing.JLabel age_field;
    private javax.swing.JButton announce_btn;
    private javax.swing.JLabel announcement;
    private javax.swing.JTextArea announcement_field;
    private javax.swing.JPanel announcement_panel;
    private javax.swing.JLabel announcement_post;
    private javax.swing.JPanel background;
    private javax.swing.JLabel bday_field;
    private javax.swing.JTextField classSearch_bar;
    private javax.swing.JTextField classSection_field;
    private javax.swing.JComboBox<String> classSem_cbox;
    private javax.swing.JButton class_btn;
    private javax.swing.JPanel class_header;
    private javax.swing.JLabel class_icon;
    private javax.swing.JPanel class_panel;
    private javax.swing.JPanel classes_table1;
    private javax.swing.JComboBox<String> classsearchsem_cbox;
    private javax.swing.JComboBox<String> classsearchyear_cbox;
    private javax.swing.JComboBox<String> classyear_cbox;
    private javax.swing.JLabel contactnum_field;
    private javax.swing.JButton course_btn;
    private javax.swing.JComboBox<String> course_cbox;
    private javax.swing.JComboBox<String> course_cbox1;
    private javax.swing.JPanel course_form;
    private javax.swing.JPanel course_form1;
    private javax.swing.JPanel course_header;
    private javax.swing.JLabel course_icon;
    private javax.swing.JPanel course_panel;
    private javax.swing.JTextField coursecode_field;
    private javax.swing.JTextField coursecode_field1;
    private javax.swing.JComboBox<String> courses_cbox;
    private javax.swing.JPanel courses_table;
    private javax.swing.JComboBox<String> coursesearch;
    private javax.swing.JTextField coursesearch_bar;
    private javax.swing.JComboBox<String> coursesearchsem_cbox;
    private javax.swing.JComboBox<String> coursesearchyear_cbox;
    private javax.swing.JComboBox<String> coursesem_cbox;
    private javax.swing.JTextField coursetitle_field;
    private javax.swing.JComboBox<String> courseyear_cbox;
    private javax.swing.JLabel credits;
    private javax.swing.JTextField credits_field;
    private javax.swing.JLabel cvsum_field;
    private javax.swing.JButton delannounce_btn;
    private javax.swing.JButton delete_btn;
    private javax.swing.JButton deleteclass_btn1;
    private javax.swing.JButton deleteclass_btn2;
    private javax.swing.JButton deletecourse_btn;
    private javax.swing.JLabel dept_field;
    private javax.swing.JButton edit_btn;
    private javax.swing.JLabel greetings;
    private javax.swing.JPanel header;
    private javax.swing.JLabel header_element;
    private javax.swing.JPanel home_background;
    private javax.swing.JButton home_btn;
    private javax.swing.JLabel home_icon;
    private javax.swing.JPanel home_panel;
    private javax.swing.JLabel id_field;
    private javax.swing.JLabel instructor_ID;
    private javax.swing.JPanel instructor_about;
    private javax.swing.JLabel instructor_address;
    private javax.swing.JLabel instructor_age;
    private javax.swing.JLabel instructor_bday;
    private javax.swing.JPanel instructor_class;
    private javax.swing.JTabbedPane instructor_class_panels;
    private javax.swing.JPanel instructor_course;
    private javax.swing.JTabbedPane instructor_course_panels;
    private javax.swing.JLabel instructor_department;
    private javax.swing.JLabel instructor_email;
    private javax.swing.JPanel instructor_home;
    private javax.swing.JLabel instructor_name;
    private javax.swing.JLabel instructor_number;
    private javax.swing.JTabbedPane instructor_panels;
    private javax.swing.JPanel instructor_profile;
    private javax.swing.JLabel instructor_sex;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private com.toedter.calendar.JCalendar jCalendar1;
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
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JButton logout_btn;
    private javax.swing.JLabel logout_icon;
    private javax.swing.JPanel logout_panel;
    private javax.swing.JLabel name_field;
    private javax.swing.JPanel navigation;
    private javax.swing.JLabel personal_info;
    private javax.swing.JPanel post_announcement_panel;
    private javax.swing.JPanel profile_background;
    private javax.swing.JButton profile_btn;
    private javax.swing.JLabel profile_icon;
    private javax.swing.JPanel profile_panel;
    private javax.swing.JComboBox<String> program_cbox2;
    private javax.swing.JLabel school_info;
    private javax.swing.JTextField searchfield;
    private javax.swing.JComboBox<String> searchsem_cbox;
    private javax.swing.JComboBox<String> searchyear_cbox;
    private javax.swing.JComboBox<String> section_cbox;
    private javax.swing.JTable section_table;
    private javax.swing.JComboBox<String> sem_cbox1;
    private javax.swing.JLabel sex_field;
    private javax.swing.JTextField studentgrade_field;
    private javax.swing.JTextField studentname_field;
    private javax.swing.JTextField studentnumber_field;
    private javax.swing.JLabel title1;
    private javax.swing.JLabel title2;
    private javax.swing.JLabel title4;
    private javax.swing.JTable top_performing_table;
    private javax.swing.JPanel total_enrolled_panel;
    private javax.swing.JLabel total_result;
    private javax.swing.JButton updatecourse_btn;
    private javax.swing.JTextField usersearch_bar;
    private javax.swing.JButton viewclass_btn1;
    private javax.swing.JPanel viewclass_panel;
    private javax.swing.JPanel viewcourse_background;
    private javax.swing.JPanel viewcourse_background1;
    private javax.swing.JButton viewcourse_btn;
    private javax.swing.JPanel viewcourse_panel;
    private javax.swing.JButton viewsection_btn;
    private javax.swing.JPanel viewsection_panel;
    private javax.swing.JComboBox<String> year_cbox3;
    // End of variables declaration//GEN-END:variables
}
