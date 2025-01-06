package Home;

import Components.InstructorEditProfile;
import Components.UtilityMethods.DefaultFocus;
import static Components.UtilityMethods.DefaultText2;
import Login.StartFrame;
import Signup.InstructorCreateAccount1Frame;
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
        title4 = new javax.swing.JLabel();
        title3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        recent_enrolled_table = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        top_performing_table = new javax.swing.JTable();
        total_enrolled_panel = new javax.swing.JPanel();
        title1 = new javax.swing.JLabel();
        total_result = new javax.swing.JLabel();
        recent_announcement_panel = new javax.swing.JPanel();
        announcement_recent = new javax.swing.JLabel();
        title2 = new javax.swing.JLabel();
        home_background = new javax.swing.JPanel();
        instructor_course = new javax.swing.JPanel();
        course_header = new javax.swing.JPanel();
        addcourse_btn = new javax.swing.JButton();
        viewcourse_btn = new javax.swing.JButton();
        instructor_course_panels = new javax.swing.JTabbedPane();
        addcourse_panel = new javax.swing.JPanel();
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
        addcourse_btn1 = new javax.swing.JButton();
        updatecourse_btn = new javax.swing.JButton();
        coursetitle_field = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        courses_table = new javax.swing.JPanel();
        searchyear_cbox = new javax.swing.JComboBox<>();
        searchsem_cbox = new javax.swing.JComboBox<>();
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
        instructor_class = new javax.swing.JPanel();
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
        school_info = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        instructor_email = new javax.swing.JLabel();
        instructor_ID = new javax.swing.JLabel();
        instructor_department = new javax.swing.JLabel();
        edit_btn = new javax.swing.JButton();
        delete_btn = new javax.swing.JButton();
        dept_field = new javax.swing.JLabel();
        name_field = new javax.swing.JLabel();
        age_field = new javax.swing.JLabel();
        sex_field = new javax.swing.JLabel();
        contactnum_field = new javax.swing.JLabel();
        address_field = new javax.swing.JLabel();
        bday_field = new javax.swing.JLabel();
        cvsum_field = new javax.swing.JLabel();
        id_field = new javax.swing.JLabel();
        instructor_about = new javax.swing.JPanel();
        header_element = new javax.swing.JLabel();
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
        header = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Learning Management System - Instructor Home");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        background.setBackground(new java.awt.Color(255, 255, 255));
        background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        instructor_home.setBackground(new java.awt.Color(255, 255, 255));
        instructor_home.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        title4.setFont(new java.awt.Font("Cascadia Mono", 1, 12)); // NOI18N
        title4.setForeground(new java.awt.Color(255, 255, 255));
        title4.setText("Top Performing Students");
        instructor_home.add(title4, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 150, 380, 30));

        title3.setFont(new java.awt.Font("Cascadia Mono", 1, 12)); // NOI18N
        title3.setForeground(new java.awt.Color(255, 255, 255));
        title3.setText("Recently Enrolled Students");
        instructor_home.add(title3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 380, 30));

        recent_enrolled_table.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(recent_enrolled_table);

        instructor_home.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 380, 280));

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

        instructor_home.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 180, 380, 280));

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
        total_result.setText("(number) Students");
        total_enrolled_panel.add(total_result, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 210, 70));

        instructor_home.add(total_enrolled_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 210, 100));

        recent_announcement_panel.setBackground(new java.awt.Color(81, 199, 135));
        recent_announcement_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        announcement_recent.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        announcement_recent.setForeground(new java.awt.Color(255, 255, 255));
        announcement_recent.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        announcement_recent.setText("(announcement)");
        recent_announcement_panel.add(announcement_recent, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 560, 70));

        title2.setFont(new java.awt.Font("Cascadia Mono", 1, 12)); // NOI18N
        title2.setForeground(new java.awt.Color(255, 255, 255));
        title2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title2.setText("Recent Announcement");
        recent_announcement_panel.add(title2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 560, 30));

        instructor_home.add(recent_announcement_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 30, 560, 100));

        home_background.setBackground(new java.awt.Color(202, 154, 221));
        home_background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        instructor_home.add(home_background, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 800, 450));

        instructor_panels.addTab("tab1", instructor_home);

        instructor_course.setBackground(new java.awt.Color(255, 255, 255));
        instructor_course.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        instructor_course.add(course_header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 820, 40));

        addcourse_panel.setBackground(new java.awt.Color(255, 255, 255));
        addcourse_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        course_form.setBackground(new java.awt.Color(81, 199, 135));
        course_form.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel19.setFont(new java.awt.Font("Cascadia Mono", 0, 10)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel19.setText("Semester:");
        course_form.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 90, 20));

        jLabel18.setFont(new java.awt.Font("Cascadia Mono", 0, 10)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel18.setText("Course Code:");
        course_form.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 90, 20));

        credits.setFont(new java.awt.Font("Cascadia Mono", 0, 10)); // NOI18N
        credits.setForeground(new java.awt.Color(255, 255, 255));
        credits.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        credits.setText("Credits:");
        course_form.add(credits, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 90, 20));

        jLabel21.setFont(new java.awt.Font("Cascadia Mono", 0, 10)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel21.setText("Year:");
        course_form.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 90, 20));

        coursecode_field.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        course_form.add(coursecode_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, 160, -1));

        credits_field.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        course_form.add(credits_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, 160, -1));

        sem_cbox.setBackground(new java.awt.Color(3, 159, 75));
        sem_cbox.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        sem_cbox.setForeground(new java.awt.Color(255, 255, 255));
        sem_cbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1st", "2nd" }));
        course_form.add(sem_cbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 200, 160, 20));

        year_cbox.setBackground(new java.awt.Color(3, 159, 75));
        year_cbox.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        year_cbox.setForeground(new java.awt.Color(255, 255, 255));
        year_cbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1st", "2nd", "3rd", "Midyear", "4th" }));
        course_form.add(year_cbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 170, 160, 20));

        jLabel22.setFont(new java.awt.Font("Cascadia Mono", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("Course Table");
        course_form.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 260, 40));

        deletecourse_btn.setBackground(new java.awt.Color(233, 82, 82));
        deletecourse_btn.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        deletecourse_btn.setForeground(new java.awt.Color(255, 255, 255));
        deletecourse_btn.setText("Delete Course");
        deletecourse_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletecourse_btnActionPerformed(evt);
            }
        });
        course_form.add(deletecourse_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 240, 30));

        addcourse_btn1.setBackground(new java.awt.Color(48, 150, 95));
        addcourse_btn1.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        addcourse_btn1.setForeground(new java.awt.Color(255, 255, 255));
        addcourse_btn1.setText("Add Course");
        addcourse_btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addcourse_btn1ActionPerformed(evt);
            }
        });
        course_form.add(addcourse_btn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 240, 30));

        updatecourse_btn.setBackground(new java.awt.Color(170, 170, 23));
        updatecourse_btn.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        updatecourse_btn.setForeground(new java.awt.Color(255, 255, 255));
        updatecourse_btn.setText("Update Course");
        updatecourse_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatecourse_btnActionPerformed(evt);
            }
        });
        course_form.add(updatecourse_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 240, 30));

        coursetitle_field.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        course_form.add(coursetitle_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, 160, -1));

        jLabel25.setFont(new java.awt.Font("Cascadia Mono", 0, 10)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel25.setText("Course Title:");
        course_form.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 90, 20));

        addcourse_panel.add(course_form, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 260, 410));

        courses_table.setBackground(new java.awt.Color(202, 154, 221));
        courses_table.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        searchyear_cbox.setFont(new java.awt.Font("Cascadia Mono", 0, 10)); // NOI18N
        searchyear_cbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "1st", "2nd", "3rd", "Midyear", "4th" }));
        searchyear_cbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchyear_cboxActionPerformed(evt);
            }
        });
        courses_table.add(searchyear_cbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 110, 20));

        searchsem_cbox.setFont(new java.awt.Font("Cascadia Mono", 0, 10)); // NOI18N
        searchsem_cbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "1st", "2nd" }));
        searchsem_cbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchsem_cboxActionPerformed(evt);
            }
        });
        courses_table.add(searchsem_cbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, 110, 20));

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
        courses_table.add(coursesearch_bar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 20, 230, 20));

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
        jScrollPane3.setViewportView(CoursesTable);

        courses_table.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 520, 360));

        jLabel4.setFont(new java.awt.Font("Cascadia Mono", 0, 8)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/icons/search-icon.png"))); // NOI18N
        courses_table.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 20, -1, 20));

        jLabel3.setFont(new java.awt.Font("Cascadia Mono", 0, 8)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Semester");
        jLabel3.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        courses_table.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 0, 110, 20));

        jLabel2.setFont(new java.awt.Font("Cascadia Mono", 0, 8)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Year");
        jLabel2.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        courses_table.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 110, 20));

        addcourse_panel.add(courses_table, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, 540, 410));

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
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(InstructorCoursesTable);

        viewcourse_background.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 780, 360));

        viewcourse_panel.add(viewcourse_background, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 800, 410));

        instructor_course_panels.addTab("tab2", viewcourse_panel);

        instructor_course.add(instructor_course_panels, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 820, 470));

        instructor_panels.addTab("tab2", instructor_course);

        instructor_class.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        instructor_panels.addTab("tab3", instructor_class);

        instructor_profile.setBackground(new java.awt.Color(255, 255, 255));
        instructor_profile.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        profile_background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        personal_info.setFont(new java.awt.Font("Cascadia Mono", 1, 18)); // NOI18N
        personal_info.setText("Personal Details");
        profile_background.add(personal_info, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));
        profile_background.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 780, 10));

        instructor_name.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        instructor_name.setText("Name:");
        profile_background.add(instructor_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 50, 30));

        instructor_age.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        instructor_age.setText("Age:");
        profile_background.add(instructor_age, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 40, 30));

        instructor_sex.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        instructor_sex.setText("Sex:");
        profile_background.add(instructor_sex, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 40, 30));

        instructor_number.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        instructor_number.setText("Contact Number:");
        profile_background.add(instructor_number, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 100, 30));

        instructor_address.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        instructor_address.setText("Address:");
        profile_background.add(instructor_address, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 60, 30));

        instructor_bday.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        instructor_bday.setText("Birthdate:");
        profile_background.add(instructor_bday, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 60, 30));

        school_info.setFont(new java.awt.Font("Cascadia Mono", 1, 18)); // NOI18N
        school_info.setText("School Details");
        profile_background.add(school_info, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, -1, -1));
        profile_background.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 780, 10));
        profile_background.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, 760, 10));
        profile_background.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 760, 10));

        instructor_email.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        instructor_email.setText("CvSU Email:");
        profile_background.add(instructor_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 80, 30));

        instructor_ID.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        instructor_ID.setText("Employee ID:");
        profile_background.add(instructor_ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 80, 30));

        instructor_department.setFont(new java.awt.Font("Cascadia Mono", 0, 12)); // NOI18N
        instructor_department.setText("Department:");
        profile_background.add(instructor_department, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, 80, 30));

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

        dept_field.setText("dept");
        profile_background.add(dept_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 380, 260, -1));

        name_field.setText("name");
        profile_background.add(name_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 60, 280, -1));

        age_field.setText("age");
        profile_background.add(age_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 80, -1));

        sex_field.setText("sex");
        profile_background.add(sex_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, 80, -1));

        contactnum_field.setText("cp num");
        profile_background.add(contactnum_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, 180, -1));

        address_field.setText("address");
        profile_background.add(address_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, 200, -1));

        bday_field.setText("bday");
        profile_background.add(bday_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 210, 180, -1));

        cvsum_field.setText("cvsu");
        profile_background.add(cvsum_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 320, 340, -1));

        id_field.setText("id");
        profile_background.add(id_field, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 350, 80, -1));

        instructor_profile.add(profile_background, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 800, 450));

        instructor_panels.addTab("tab4", instructor_profile);

        instructor_about.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        instructor_panels.addTab("tab5", instructor_about);

        background.add(instructor_panels, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 30, 820, 510));

        header_element.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/backgrounds/header-background.png"))); // NOI18N
        background.add(header_element, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

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

        header.setBackground(new java.awt.Color(202, 154, 221));
        header.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        navigation.add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 380, 980, -1));

        background.add(navigation, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 150, 450));

        jLabel1.setFont(new java.awt.Font("Cascadia Mono", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Welcome, (instructor name)!");
        background.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 890, 70));

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
            CourseTitle = coursetitle_field.getText().trim();
            Credit = credits_field.getText().trim(); // Store as String initiall         
            Year = (String) year_cbox.getSelectedItem();
            Sem = (String) sem_cbox.getSelectedItem();

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
    private javax.swing.JTable CoursesTable;
    private javax.swing.JTable InstructorCoursesTable;
    private javax.swing.JButton about_btn;
    private javax.swing.JLabel about_icon;
    private javax.swing.JPanel about_panel;
    private javax.swing.JButton addcourse_btn;
    private javax.swing.JButton addcourse_btn1;
    private javax.swing.JPanel addcourse_panel;
    private javax.swing.JLabel address_field;
    private javax.swing.JLabel age_field;
    private javax.swing.JLabel announcement_recent;
    private javax.swing.JPanel background;
    private javax.swing.JLabel bday_field;
    private javax.swing.JButton class_btn;
    private javax.swing.JLabel class_icon;
    private javax.swing.JPanel class_panel;
    private javax.swing.JLabel contactnum_field;
    private javax.swing.JButton course_btn;
    private javax.swing.JPanel course_form;
    private javax.swing.JPanel course_header;
    private javax.swing.JLabel course_icon;
    private javax.swing.JPanel course_panel;
    private javax.swing.JTextField coursecode_field;
    private javax.swing.JComboBox<String> courses_cbox;
    private javax.swing.JPanel courses_table;
    private javax.swing.JTextField coursesearch_bar;
    private javax.swing.JTextField coursetitle_field;
    private javax.swing.JLabel credits;
    private javax.swing.JTextField credits_field;
    private javax.swing.JLabel cvsum_field;
    private javax.swing.JButton delete_btn;
    private javax.swing.JButton deletecourse_btn;
    private javax.swing.JLabel dept_field;
    private javax.swing.JButton edit_btn;
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
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
    private javax.swing.JPanel recent_announcement_panel;
    private javax.swing.JTable recent_enrolled_table;
    private javax.swing.JLabel school_info;
    private javax.swing.JComboBox<String> searchsem_cbox;
    private javax.swing.JComboBox<String> searchyear_cbox;
    private javax.swing.JComboBox<String> sem_cbox;
    private javax.swing.JLabel sex_field;
    private javax.swing.JLabel title1;
    private javax.swing.JLabel title2;
    private javax.swing.JLabel title3;
    private javax.swing.JLabel title4;
    private javax.swing.JTable top_performing_table;
    private javax.swing.JPanel total_enrolled_panel;
    private javax.swing.JLabel total_result;
    private javax.swing.JButton updatecourse_btn;
    private javax.swing.JPanel viewcourse_background;
    private javax.swing.JButton viewcourse_btn;
    private javax.swing.JPanel viewcourse_panel;
    private javax.swing.JComboBox<String> year_cbox;
    // End of variables declaration//GEN-END:variables
}
