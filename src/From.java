
//package LAB9;
//Flie t in ma 
import java.awt.event.*;
import java.awt.*;

import javax.swing.*;
import javax.swing.Timer;
import javax.swing.plaf.FontUIResource;

//File Text
import java.io.*;
import java.util.Scanner;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
//center Display
import java.awt.Toolkit;
import java.awt.Dimension;

//Table
import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class From extends JFrame implements ActionListener {
    // ตัวแปรร panel 1 วิชา
    JLabel labelcode, labelsubject, labelcredit, line;
    JTextField textcode, textsubject, textcredit;
    JButton btninput, btnedit, btndelete, btnclearSubject;
    // ตัวแปรร panel 2 อาจารย์
    JLabel labecodeprofessorr, labenameprofessorr, labelastnameprofessorr;
    JTextField textcodeprofessor, textnameprofessorr, textlastnameprofessorr;
    JButton btnaddProfessorr, btnEditProfessorr, btndeleteProfessorr;
    // ตัวแปรร panel 3 ตารางสอนอาจารย์
    JLabel labelNameCI, labelSubjectCI, labelSectionCI, labelDateCI, labelTimeCI, labelMaxpeople;
    JTextField textMaxpeople;
    JButton btnInputCI;
    JComboBox ComboboxSection, ComboboxDay, ComboboxTime, ComboboxNameCI, ComboboxSubjectCI;
    // ตัวแปรร panel 4 นักเรียน
    JLabel labelcodestudent, labeltitlestudent, labelnamestudent, labellastnamestudent;
    JTextField textcodestudent, texttitlestudent, textnamestudent, textlastnamestudent;
    JButton btninputstudent, btneditstudent, btndeletestudent, btnclearstudent;
    JComboBox Comboboxstudent;
    // ตัวแปร panle 5 เพิ่มตารางสอนให้เรียน
    JLabel labelnameSTSJ, labelsujectSTSJ;
    JComboBox ComboboxnameSTSJ, ComboboxsujectSTSJ;
    JButton btnaddSTSJ;
    JPanel graphicsPanel1, graphicsPanel2, graphicsPanel3, graphicsPanel4, graphicsPanel5, graphicsPanel6, paneControl;
    JTextArea textareaSTSJ;
    JLabel la1, la2, la3;
    JButton btnconaddSuject, btnOpenSubject;
    JButton btnconaddPr, btnconaddtablesorb, btnconStd, btnconaddtableStd;
    Timer time;
    JComboBox ComboBox, ComboBoxprofessorr;
    int count = 0, ceckError = 0, linear = 0, next = 0; // ให้นับค่าของ text || next ใช้นับวิชาที่เพิ่มเช้าไปใน TextArea
    JTextArea arsorb;

    JScrollPane scrollPane;// table
    JButton btnStudenttable;
    JTable table;
    Container c = getContentPane();
    JComboBox af;
    JButton btnprint;
    int comBoxNC = 0;
    String fille = "C:/Users/Az/OneDrive/Desktop/register/register_student/src/";// ถ้าเข้ามาเปลี่ยนบรรทัดที่ไฟล์ตัวเองที่เก็บไว้อยู่
    String fonts = "FC Lamoon";

    public From() {
        super("Register Student");
        // ไว้รับ text
        String a[] = new String[100];
        outputText(a);
        String b[] = new String[count];

        for (int i = 0; i < count; i++) {
            b[i] = a[i];
        }

        UIManager UI = new UIManager();
        UIManager.put("OptionPane.messageFont", new FontUIResource(new Font(fonts, Font.BOLD, 18)));
        // UI.put("OptionPane.background",new ColorUIResource(0,0,0));
        // UI.put("Panel.background",new ColorUIResource(17,255,0));
        // UI.put("Title.background",new ColorUIResource(17,255,0));
        paneControl = new JPanel();
        paneControl.setPreferredSize(new Dimension(1170, 600));
        paneControl.setBackground(new Color(0, 189, 5));
        paneControl.setBorder(BorderFactory.createLineBorder(new Color(6, 6, 6), 10));

        c.setLayout(new FlowLayout());

        line = new JLabel("__________________________________________________________________");
        paneControl.add(line);

        la1 = new JLabel("ระบบลงทะเบียนนักศึกษา");
        la1.setFont(new Font("FC Lamoon", Font.BOLD, 30));
        la1.setForeground(Color.white);
        paneControl.add(la1);

        line = new JLabel("__________________________________________________________________");
        paneControl.add(line);

        btnconaddSuject = new JButton("เพิ่มวิชา");
        btnconaddSuject.setFont(new Font("FC Lamoon", Font.BOLD, 25));
        btnconaddSuject.setFont(new Font(fonts, Font.BOLD, 25));
        btnconaddSuject.addActionListener(this);
        btnconaddSuject.setBackground(new Color(24, 105, 255));
        btnconaddSuject.setForeground(Color.white);

        paneControl.add(btnconaddSuject);

        btnconaddPr = new JButton("เพิ่มรายชื่ออาจารย์ผู้สอน");
        btnconaddPr.setFont(new Font(fonts, Font.BOLD, 25));
        btnconaddPr.addActionListener(this);
        btnconaddPr.setBackground(new Color(13, 107, 218));
        btnconaddPr.setForeground(Color.white);
        paneControl.add(btnconaddPr);

        btnconaddtablesorb = new JButton("เพิ่มอาจารย์ผู้สอนในตารางสอบ");
        btnconaddtablesorb.setFont(new Font(fonts, Font.BOLD, 25));
        btnconaddtablesorb.addActionListener(this);
        btnconaddtablesorb.setBackground(new Color(5, 130, 190));
        btnconaddtablesorb.setForeground(Color.white);
        paneControl.add(btnconaddtablesorb);

        btnconStd = new JButton("เพิ่มรายชื่อนักเรียน");
        btnconStd.setFont(new Font(fonts, Font.BOLD, 25));
        btnconStd.addActionListener(this);
        btnconStd.setBackground(new Color(255, 168, 7));
        btnconStd.setForeground(Color.white);
        paneControl.add(btnconStd);

        btnconaddtableStd = new JButton("เพิ่มตารางสอน");
        btnconaddtableStd.setFont(new Font(fonts, Font.BOLD, 25));
        btnconaddtableStd.addActionListener(this);
        btnconaddtableStd.setBackground(new Color(255, 120, 0));
        btnconaddtableStd.setForeground(Color.white);
        paneControl.add(btnconaddtableStd);
        c.add(paneControl);

        scrollPane = new JScrollPane();
        // ตำแหน่ง=กว้างxยาว ขนาด=กว้างxยาว
        scrollPane.setPreferredSize(new Dimension(800, 190));
        scrollPane.setBorder(BorderFactory.createLineBorder(Color.green));

        table = new JTable();
        scrollPane.setViewportView(table);

        btnStudenttable = new JButton("ดูตารางสอนนักเรียน");
        btnStudenttable.setFont(new Font(fonts, Font.BOLD, 25));
        btnStudenttable.addActionListener(this);
        btnStudenttable.setBackground(new Color(255, 83, 0));
        btnStudenttable.setForeground(Color.white);

        paneControl.add(btnStudenttable);
        paneControl.add(scrollPane);

        graphicsPanel1 = new JPanel();
        graphicsPanel1.setPreferredSize(new Dimension(850, 150));
        graphicsPanel1.setBackground(new Color(97, 248, 101));
        graphicsPanel1.setBorder(BorderFactory.createLineBorder(new Color(6, 6, 6), 10));

        labelcode = new JLabel("รหัสวิชา : ");
        labelcode.setFont(new Font(fonts, Font.BOLD, 25));
        graphicsPanel1.add(labelcode);
        textcode = new JTextField(8);
        textcode.setFont(new Font(fonts, Font.BOLD, 25));
        textcode.addActionListener(this);
        graphicsPanel1.add(textcode);

        labelsubject = new JLabel("วิชา : ");
        labelsubject.setFont(new Font(fonts, Font.BOLD, 25));
        graphicsPanel1.add(labelsubject);
        textsubject = new JTextField(27);
        textsubject.setFont(new Font(fonts, Font.BOLD, 25));
        textsubject.addActionListener(this);
        graphicsPanel1.add(textsubject);

        labelcredit = new JLabel("หน่วยกิต : ");
        labelcredit.setFont(new Font(fonts, Font.BOLD, 25));
        graphicsPanel1.add(labelcredit);
        textcredit = new JTextField(3);
        textcredit.setFont(new Font(fonts, Font.BOLD, 25));
        textcredit.addActionListener(this);
        graphicsPanel1.add(textcredit);

        btninput = new JButton("เพิ่มวิชา");
        btninput.setFont(new Font(fonts, Font.BOLD, 25));
        btninput.setBackground(Color.green);
        btninput.setForeground(Color.BLACK);
        btninput.addActionListener(this);

        graphicsPanel1.add(btninput);

        btnedit = new JButton("แก้ไขวิชา");
        btnedit.setFont(new Font(fonts, Font.BOLD, 25));
        btnedit.setEnabled(false);
        btnedit.addActionListener(this);
        btnedit.setBackground(Color.blue);
        btnedit.setForeground(Color.white);
        graphicsPanel1.add(btnedit);

        btndelete = new JButton("ลบวิชา");
        btndelete.setFont(new Font(fonts, Font.BOLD, 25));
        btndelete.setEnabled(false);
        btndelete.addActionListener(this);
        btndelete.setBackground(Color.red);
        btndelete.setForeground(Color.white);
        graphicsPanel1.add(btndelete);

        btnclearSubject = new JButton("ล้างข้อมูล");
        btnclearSubject.setFont(new Font(fonts, Font.BOLD, 25));
        btnclearSubject.setEnabled(false);
        btnclearSubject.addActionListener(this);
        btnclearSubject.setBackground(Color.yellow);
        btnclearSubject.setForeground(Color.BLACK);
        graphicsPanel1.add(btnclearSubject);

        ComboBox = new JComboBox(b);
        ComboBox.setFont(new Font(fonts, Font.BOLD, 25));
        ComboBox.addActionListener(this);
        graphicsPanel1.add(ComboBox);
        graphicsPanel1.setVisible(true);
        graphicsPanel1.setVisible(false);
        paneControl.add(graphicsPanel1);

        graphicsPanel2 = new JPanel();
        graphicsPanel2.setPreferredSize(new Dimension(1100, 200));
        graphicsPanel2.setBackground(new Color(102, 204, 143));
        graphicsPanel2.setBorder(BorderFactory.createLineBorder(new Color(6, 6, 6), 10));

        labecodeprofessorr = new JLabel("รหัสอาจารย์ผู้สอน:");
        labecodeprofessorr.setFont(new Font(fonts, Font.BOLD, 25));
        graphicsPanel2.add(labecodeprofessorr);
        textcodeprofessor = new JTextField(10);
        textcodeprofessor.setFont(new Font(fonts, Font.BOLD, 25));
        graphicsPanel2.add(textcodeprofessor);

        labenameprofessorr = new JLabel("ชื่ออาจารย์ผู้สอน: ");
        labenameprofessorr.setFont(new Font(fonts, Font.BOLD, 25));
        graphicsPanel2.add(labenameprofessorr);
        textnameprofessorr = new JTextField(17);
        textnameprofessorr.setFont(new Font(fonts, Font.BOLD, 25));
        graphicsPanel2.add(textnameprofessorr);

        labelastnameprofessorr = new JLabel("นามสกุล: ");
        labelastnameprofessorr.setFont(new Font(fonts, Font.BOLD, 25));
        graphicsPanel2.add(labelastnameprofessorr);
        textlastnameprofessorr = new JTextField(17);
        textlastnameprofessorr.setFont(new Font(fonts, Font.BOLD, 25));
        graphicsPanel2.add(textlastnameprofessorr);

        btnaddProfessorr = new JButton("เพิ่มอาจารย์ผู้สอน");
        btnaddProfessorr.setBackground(new Color(255, 87, 66));
        btnaddProfessorr.setForeground(Color.white);
        btnaddProfessorr.setFont(new Font(fonts, Font.BOLD, 25));
        btnaddProfessorr.addActionListener(this);
        graphicsPanel2.add(btnaddProfessorr);

        btnEditProfessorr = new JButton("แก้ไขอาจารย์ผู้สอน");
        btnEditProfessorr.setBackground(new Color(255, 49, 3));
        btnEditProfessorr.setForeground(Color.white);
        btnEditProfessorr.setFont(new Font(fonts, Font.BOLD, 25));
        btnEditProfessorr.addActionListener(this);
        btnEditProfessorr.setEnabled(false);
        graphicsPanel2.add(btnEditProfessorr);

        btndeleteProfessorr = new JButton("ลบไขอาจารย์ผู้สอน");
        btndeleteProfessorr.setBackground(new Color(163, 29, 0));
        btndeleteProfessorr.setForeground(Color.white);
        btndeleteProfessorr.setFont(new Font(fonts, Font.BOLD, 25));
        btndeleteProfessorr.setEnabled(false);
        btndeleteProfessorr.addActionListener(this);
        graphicsPanel2.add(btndeleteProfessorr);

        String proface[] = new String[100];
        outputTextProfessorr(proface);
        String bproface[] = new String[count];
        for (int i = 0; i < count; i++) {
            bproface[i] = proface[i];
        }

        ComboBoxprofessorr = new JComboBox(bproface);
        ComboBoxprofessorr.setFont(new Font(fonts, Font.BOLD, 25));
        ComboBoxprofessorr.addActionListener(this);
        graphicsPanel2.add(ComboBoxprofessorr);
        paneControl.add(graphicsPanel2);

        graphicsPanel3 = new JPanel();
        graphicsPanel3.setPreferredSize(new Dimension(900, 400));
        graphicsPanel3.setBackground(new Color(186, 253, 136));
        graphicsPanel3.setBorder(BorderFactory.createLineBorder(new Color(6, 6, 6), 10));

        labelNameCI = new JLabel("ชื่อ : ");
        labelNameCI.setFont(new Font(fonts, Font.BOLD, 25));
        graphicsPanel3.add(labelNameCI);
        String pr[] = new String[bproface.length];
        for (int i = 0; i < pr.length; i++) {
            pr[i] = bproface[i];
        }
        ComboboxNameCI = new JComboBox();
        ComboboxNameCI.addActionListener(this);
        ComboboxNameCI.setFont(new Font(fonts, Font.BOLD, 25));
        graphicsPanel3.add(ComboboxNameCI);

        labelSubjectCI = new JLabel("วิชา : ");
        labelSubjectCI.setFont(new Font(fonts, Font.BOLD, 25));
        graphicsPanel3.add(labelSubjectCI);
        String bSubect[] = new String[b.length];
        for (int i = 0; i < b.length; i++) {
            bSubect[i] = b[i].substring(b[i].indexOf("Subject:") + 9).trim();
        }
        ComboboxSubjectCI = new JComboBox(bSubect);
        ComboboxSubjectCI.setFont(new Font(fonts, Font.BOLD, 25));
        graphicsPanel3.add(ComboboxSubjectCI);

        labelSectionCI = new JLabel("ตอนเรียน : ");
        labelSectionCI.setFont(new Font(fonts, Font.BOLD, 25));
        graphicsPanel3.add(labelSectionCI);
        String sec[] = { "1", "2", "3", "4", "5", "6", "7", "8", "9" };
        ComboboxSection = new JComboBox(sec);
        labelSectionCI.setFont(new Font(fonts, Font.BOLD, 25));
        graphicsPanel3.add(ComboboxSection);

        labelMaxpeople = new JLabel("จำนวนคน : ");
        labelMaxpeople.setFont(new Font(fonts, Font.BOLD, 25));
        graphicsPanel3.add(labelMaxpeople);
        textMaxpeople = new JTextField(2);
        textMaxpeople.setFont(new Font(fonts, Font.BOLD, 25));
        graphicsPanel3.add(textMaxpeople);

        labelSectionCI = new JLabel("วัน : ");
        labelSectionCI.setFont(new Font(fonts, Font.BOLD, 25));
        graphicsPanel3.add(labelSectionCI);
        String day[] = { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday" };
        ComboboxDay = new JComboBox(day);
        ComboboxDay.setFont(new Font(fonts, Font.BOLD, 25));
        graphicsPanel3.add(ComboboxDay);

        labelTimeCI = new JLabel("เวลา : ");
        labelTimeCI.setFont(new Font(fonts, Font.BOLD, 25));
        graphicsPanel3.add(labelTimeCI);
        String timeCI[] = { "09.00-12.00", "13.00-16.00" };
        ComboboxTime = new JComboBox(timeCI);
        ComboboxTime.setFont(new Font(fonts, Font.BOLD, 25));
        graphicsPanel3.add(ComboboxTime);

        arsorb = new JTextArea(7, 70);
        arsorb.setFont(new Font(fonts, Font.BOLD, 20));
        arsorb.setEditable(false);
        graphicsPanel3.add(arsorb);
        paneControl.add(graphicsPanel3);
        JScrollPane scrollableTextArea = new JScrollPane(arsorb);
        scrollableTextArea.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollableTextArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        graphicsPanel3.add(scrollableTextArea);

        btnInputCI = new JButton("เพิ่ม");
        btnInputCI.setFont(new Font(fonts, Font.BOLD, 20));
        btnInputCI.setBackground(new Color(255, 91, 91));
        btnInputCI.setForeground(Color.BLACK);
        btnInputCI.addActionListener(this);
        graphicsPanel3.add(btnInputCI);
        ///////////////////////////////////////////////////////////////////////////
        graphicsPanel4 = new JPanel();
        graphicsPanel4.setPreferredSize(new Dimension(680, 200));
        graphicsPanel4.setBackground(new Color(0, 255, 140));
        graphicsPanel4.setBorder(BorderFactory.createLineBorder(new Color(6, 6, 6), 10));

        labelcodestudent = new JLabel("รหัสนักศึกษา: ");
        labelcodestudent.setFont(new Font(fonts, Font.BOLD, 20));
        graphicsPanel4.add(labelcodestudent);

        textcodestudent = new JTextField(10);
        textcodestudent.setFont(new Font(fonts, Font.BOLD, 20));
        textcodestudent.addActionListener(this);
        graphicsPanel4.add(textcodestudent);

        labeltitlestudent = new JLabel("คำนำหน้าชื่อ : ");
        labeltitlestudent.setFont(new Font(fonts, Font.BOLD, 20));
        graphicsPanel4.add(labeltitlestudent);

        texttitlestudent = new JTextField(5);
        texttitlestudent.setFont(new Font(fonts, Font.BOLD, 20));
        texttitlestudent.addActionListener(this);
        graphicsPanel4.add(texttitlestudent);

        labelnamestudent = new JLabel("ชื่อ : ");
        labelnamestudent.setFont(new Font(fonts, Font.BOLD, 20));
        graphicsPanel4.add(labelnamestudent);

        textnamestudent = new JTextField(15);
        textnamestudent.setFont(new Font(fonts, Font.BOLD, 20));
        textnamestudent.addActionListener(this);
        graphicsPanel4.add(textnamestudent);

        labellastnamestudent = new JLabel("นามสกุล : ");
        labellastnamestudent.setFont(new Font(fonts, Font.BOLD, 20));
        graphicsPanel4.add(labellastnamestudent);

        textlastnamestudent = new JTextField(20);
        textlastnamestudent.setFont(new Font(fonts, Font.BOLD, 20));
        textlastnamestudent.addActionListener(this);
        graphicsPanel4.add(textlastnamestudent);

        btninputstudent = new JButton("เพิ่มข้อมูลนักศึกษา");
        btninputstudent.setFont(new Font(fonts, Font.BOLD, 20));
        btninputstudent.setBackground(Color.green);
        btninputstudent.setForeground(Color.BLACK);
        btninputstudent.addActionListener(this);
        graphicsPanel4.add(btninputstudent);

        btneditstudent = new JButton("แก้ไขข้อมูลนักศึกษา");
        btneditstudent.setFont(new Font(fonts, Font.BOLD, 20));
        btneditstudent.setEnabled(false);
        btneditstudent.addActionListener(this);
        btneditstudent.setBackground(Color.blue);
        btneditstudent.setForeground(Color.white);
        graphicsPanel4.add(btneditstudent);

        btndeletestudent = new JButton("ลบข้อมูลมูลนักศึกษา");
        btndeletestudent.setFont(new Font(fonts, Font.BOLD, 20));
        btndeletestudent.setEnabled(false);
        btndeletestudent.addActionListener(this);
        btndeletestudent.setBackground(Color.red);
        btndeletestudent.setForeground(Color.white);
        graphicsPanel4.add(btndeletestudent);

        btnclearstudent = new JButton("ล้างข้อมูล");
        btnclearstudent.setFont(new Font(fonts, Font.BOLD, 20));
        btnclearstudent.setEnabled(false);
        btnclearstudent.addActionListener(this);
        btnclearstudent.setBackground(Color.yellow);
        btnclearstudent.setForeground(Color.BLACK);
        graphicsPanel4.add(btnclearstudent);

        String student[] = new String[100];
        outputTextstudent(student);
        String student2[] = new String[count];
        for (int i = 0; i < count; i++) {
            student2[i] = student[i];
        }
        Comboboxstudent = new JComboBox(student2);
        Comboboxstudent.setFont(new Font(fonts, Font.BOLD, 20));
        Comboboxstudent.addActionListener(this);
        graphicsPanel4.add(Comboboxstudent);
        graphicsPanel4.setVisible(true);
        paneControl.add(graphicsPanel4);
        ///////////////////////////////////////////////////////////////////////
        graphicsPanel5 = new JPanel();
        graphicsPanel5.setPreferredSize(new Dimension(1000, 400));
        graphicsPanel5.setBackground(new Color(28, 255, 194));
        graphicsPanel5.setBorder(BorderFactory.createLineBorder(new Color(6, 6, 6), 10));

        ComboboxnameSTSJ = new JComboBox(); // เลือกนักเรียน
        ComboboxnameSTSJ.setFont(new Font(fonts, Font.BOLD, 20));
        ComboboxnameSTSJ.addActionListener(this);
        graphicsPanel5.add(ComboboxnameSTSJ);
        c.add(graphicsPanel5);

        ComboboxsujectSTSJ = new JComboBox(); // ตารางสอน
        ComboboxsujectSTSJ.setFont(new Font(fonts, Font.BOLD, 20));
        ComboboxsujectSTSJ.addActionListener(this);
        graphicsPanel5.add(ComboboxsujectSTSJ);

        textareaSTSJ = new JTextArea(7, 60);
        textareaSTSJ.setFont(new Font(fonts, Font.BOLD, 25));
        textareaSTSJ.setEditable(false);
        graphicsPanel5.add(textareaSTSJ);
        paneControl.add(graphicsPanel5);
        JScrollPane scrollableTextAreaSTSJ = new JScrollPane(textareaSTSJ);
        scrollableTextAreaSTSJ.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollableTextAreaSTSJ.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        graphicsPanel5.add(scrollableTextAreaSTSJ);

        btnaddSTSJ = new JButton("เพิ่ม");
        btnaddSTSJ.setFont(new Font(fonts, Font.BOLD, 20));
        btnaddSTSJ.setBackground(new Color(255, 120, 0));
        btnaddSTSJ.addActionListener(this);
        graphicsPanel5.add(btnaddSTSJ);

        graphicsPanel6 = new JPanel();
        graphicsPanel6.setPreferredSize(new Dimension(1000, 300));
        graphicsPanel6.setBackground(new Color(19, 128, 57));
        graphicsPanel6.setBorder(BorderFactory.createLineBorder(new Color(6, 6, 6), 10));

        af = new JComboBox();
        af.addActionListener(this);
        af.setFont(new Font(fonts, Font.BOLD, 20));
        graphicsPanel6.add(af);
        graphicsPanel6.add(scrollPane);
        paneControl.add(graphicsPanel6);
        paneControl.setFont(new Font(fonts, Font.BOLD, 20));
        // btnprint = new JButton("Report");
        // btnprint.addActionListener(this);
        // graphicsPanel6.add(btnprint);
        graphicsPanel1.setVisible(false);
        graphicsPanel2.setVisible(false);
        graphicsPanel3.setVisible(false);
        graphicsPanel4.setVisible(false);
        graphicsPanel5.setVisible(false);
        graphicsPanel6.setVisible(false);

        time = new Timer(100, this);
        time.start();
    }

    public void outputTextSubject(String a[]) {
        count = 0;
        File file = new File(fille + "student_suject.txt");// ตำแหน่งไฟล์
        Scanner sc = new Scanner(System.in);
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String text[] = new String[100];// ขนาดของ file
        while (sc.hasNextLine()) { // loop text in file
            text[count] = sc.nextLine(); // เอาข้อความแต่ละบันทัดมาเก็บไว้ใน text array
            count++;
        }
        for (int i = 0; i < count; i++) {
            a[i] = text[i];
        }
    }

    public void paint(Graphics g) {

        super.paint(g);
        if (textcode.getText().equals("") && textcredit.getText().equals("") && textsubject.getText().equals("")) {
            btndelete.setEnabled(false);
            btnedit.setEnabled(false);
            btninput.setEnabled(false);
            btnclearSubject.setEnabled(false);
        } else {
            btnclearSubject.setEnabled(true);
            btninput.setEnabled(true);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
        // System.out.println(ComboBox.getSelectedIndex());
        // ตัวแปร
        String code = textcode.getText();
        String subject = textsubject.getText();
        String credit = textcredit.getText();
        String text = "Code: " + code + " Subject: " + subject + " Credit: " + credit;
        String checkcondition = "";
        int editeSubject = ComboBox.getSelectedIndex(); // ให้ value มีค่าเท่ากับ combobox ที่เราเลือก
        int editProfessorr = ComboBoxprofessorr.getSelectedIndex(); // ให้ value มีค่าเท่ากับ combobox ที่เราเลือก
        int edisutdeit = Comboboxstudent.getSelectedIndex();
        // --------------------------------------------------------------------------\\\\
        // ส่วนของตัวแปรการเพิ่มอาจารย์
        String codePr = textcodeprofessor.getText();
        String namePr = textnameprofessorr.getText();
        String lnamePr = textlastnameprofessorr.getText();
        String name = "Code: " + codePr + " name: " + namePr + " lname: " + lnamePr;
        // ส่วนชอง นักเรียน
        String codeST = textcodestudent.getText();
        String titleST = texttitlestudent.getText();
        String nameST = textnamestudent.getText();
        String lnameST = textlastnamestudent.getText();
        String inputST = "code: " + codeST + " title: " + titleST + " name: " + nameST + " lname: " + lnameST;
        int editestudent = Comboboxstudent.getSelectedIndex();
        // -----------------------------------------------------------------------------\\\\

        if (e.getSource() == btninput) {
            checkcondition = "input";
            // *********************************** *\\\\\\\\\
            // ใช้ตรวจสอบเงื่อนไข เอาตัว code ออก มา เช็คเงื่อนไข
            String z[] = new String[100];// ส่ง z ไปเก็บชื่อรายวิชาแต่ละตำแหน่งไว้ใน array
            outputText(z); // ส่ง z ไป
            String x[] = new String[count]; // แล้วเอา X มีค่าเท่า count ซึ่ง count ค่าจะอยู่ ใน method outputText
            for (int i = 0; i < count; i++) {
                x[i] = z[i]; // แล้วเอา x มาเก็บค่า z ในแต่ละตำแหน่ง array ตามจำ for loop ของ count
            }
            String Ccode[] = new String[count];// อันนี้ตัวสอบรหัสวิชาที่ซ้ำกัน
            for (int i = 0; i < count; i++) {
                Ccode[i] = x[i]; // แล้วเอา x มาเก็บค่า z ในแต่ละตำแหน่ง array ตามจำ for loop ของ count
            }
            charaddCode(Ccode);// ดึงตำแหน่งtext
            checksubject(code, subject, credit, Ccode, checkcondition);// ส่งเข้าไปตัวสอบเงื่อนไข
            // -------------------------------------------\\
            // ** ดึงแค่ ชื่อวิชา */
            String Ssubject[] = new String[count];
            charaddSubject(x, Ssubject);
            // fool loop สำหรับดึงชื่อวิชา
            for (int i = 0; i < Ssubject.length; i++) {
                // System.out.println(Ssubject[i]);
            }
            // **************************************************\\
            // input to file Txt
            if (ceckError == 0) { // ถ้าใช่ == 0 ; จะเพิ่มข้อความใน text file
                inputText(text);
                // --------------------------------------\\
                // show in comboBox
                String a[] = new String[100];
                outputText(a);
                String b[] = new String[count];
                for (int i = 0; i < count; i++) {
                    b[i] = a[i];
                }
                ComboBox.addItem(b[count - 1]);
                ComboboxSubjectCI.addItem(b[count - 1]);
                JOptionPane.showMessageDialog(null, "เพิ่มวิชาสำเร็จ", "เรียบร้อย", JOptionPane.INFORMATION_MESSAGE);
                textcode.setText("");
                textsubject.setText("");
                textcredit.setText("");
            }
            ceckError = 0;
            // ---------------------------------------------\\
            // Edit
        } else if (e.getSource() == btnclearSubject) {
            int dialogButton = JOptionPane.showConfirmDialog(null, "คุณต้องการจะเคลียร์ข้อมูลหรือไม่", "ล้างข้อมูล",
                    JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if (dialogButton == JOptionPane.YES_OPTION) {
                textcode.setText("");
                textsubject.setText("");
                textcredit.setText("");
            }
        } else if (e.getSource() == btnedit) {
            checkcondition = "edit";
            String z[] = new String[100];// ส่ง z ไปเก็บชื่อรายวิชาแต่ละตำแหน่งไว้ใน array
            outputText(z); // ส่ง z ไป
            String x[] = new String[count]; // แล้วเอา X มีค่าเท่า count ซึ่ง count ค่าจะอยู่ ใน method outputText
            for (int i = 0; i < count; i++) {
                x[i] = z[i]; // แล้วเอา x มาเก็บค่า z ในแต่ละตำแหน่ง array ตามจำ for loop ของ count
            }
            x[ComboBox.getSelectedIndex()] = "Code: " + code + " Subject: " + subject + " Credit: " + credit; // ให้ x
                                                                                                              // ในตำแหน่งของ
                                                                                                              // index
                                                                                                              // Combobox
            // ที่เราเลือกไว้
            // มีค่าเท่ากับ code + " " + subject + " " + credit ที่มาจาก Jtextfiled
            // ที่เราป้อนเข้าไป
            String textEdit[] = new String[x.length];
            for (int i = 0; i < textEdit.length; i++) {
                if (i < textEdit.length - 1) {
                    textEdit[i] = x[i] + "\n";
                } else {
                    textEdit[i] = x[i];
                }
            }
            charaddCode(x);
            checksubject(code, subject, credit, x, checkcondition);
            if (ceckError == 0) { // ถ้าใช่ == 0 ; จะเพิ่มข้อความใน text file
                int dialogButton = JOptionPane.showConfirmDialog(null, "คุณต้องการจะแก้ไขใช่หรือไม่?", "แก้ไขข้อมูล",
                        JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                if (dialogButton == JOptionPane.YES_OPTION) {
                    inputText(textEdit);
                    // --------------------------------------\\
                    // show in comboBox
                    String a[] = new String[100];
                    outputText(a);
                    String b[] = new String[count];
                    for (int i = 0; i < count; i++) {
                        b[i] = a[i];
                    }
                    ComboBox.removeItemAt(editeSubject);// ลบข้อมูลใน comboox ในตำแหน่ง index ที่เราเลือก
                    ComboBox.insertItemAt(b[editeSubject], editeSubject);// ให้ตัวแปร b[edite] คือเลือกข้อความในตำแหน่ง
                                                                         // index นี้
                    ComboboxSubjectCI.removeItemAt(editeSubject);// ลบข้อมูลใน comboox ในตำแหน่ง index ที่เราเลือก
                    ComboboxSubjectCI.insertItemAt(b[editeSubject], editeSubject);

                    // editle
                    // ให้ไปแทรกอยู่ใน combobox ที่ edite เลือกไว้
                    JOptionPane.showMessageDialog(null, "แก้ไขข้อมูลเรียบร้อย", "แก้ไขข้อมูลสำเร็จ",
                            JOptionPane.INFORMATION_MESSAGE);
                    textcode.setText("");
                    textsubject.setText("");
                    textcredit.setText("");
                    btndelete.setEnabled(false);
                    btnedit.setEnabled(false);
                }
            }
            ceckError = 0;
            // ลบข้อมูล
        } else if (e.getSource() == btndelete) {
            checkcondition = "delete";
            String z[] = new String[100];// ส่ง z ไปเก็บชื่อรายวิชาแต่ละตำแหน่งไว้ใน array
            outputText(z); // ส่ง z ไป
            String x[] = new String[count]; // แล้วเอา X มีค่าเท่า count ซึ่ง count ค่าจะอยู่ ใน method outputText
            for (int i = 0; i < count; i++) {
                x[i] = z[i]; // แล้วเอา x มาเก็บค่า z ในแต่ละตำแหน่ง array ตามจำ for loop ของ count
            }
            x[ComboBox.getSelectedIndex()] = "";
            String textDelete[] = new String[x.length - 1];// ที่ลบ 1 เพราะจะต้องมีตัวแปรถูกลบทิ้งไป
            int linedelete = 0;// ไว้ใช้เก็บข้อมูลในตัวแปรร array แทน i เพราะถ้าในตำแหน่งของ for
                               // มีเงื่อนไขใดไม่เป็นจริงจะไม่หรือเป็นจริง ค่า i ก็จะ +1 ตลอด และ
            // ถ้าในตำแหน่งที่ถูกลบไปก็จะเพิ่มค่าเข้าไปเป็น null เลยใช้ linedelete มาดักแทน
            // System.out.println(x.length);
            for (int i = 0; i < x.length; i++) {
                if (!x[i].equals("")) {// 1 ไม่เท่ากับ 1 F
                    if (i < x.length - 1 && linedelete + 1 < x.length - 1) {// ให้ค่า
                                                                            // ที่จะเก็บตัวตอนตัวสุดท้ายไปขึ้นบรรทัดใหม่
                        // && linedelete เกิน x.length จะให้ไปบวกค่าใหม่เพราะว่าค่า index
                        // ตัวสุดท้ายจะต้องไม่มี \n
                        // เพราะถ้าเราเลือกลบวิชาตัวท้ายค่า index มันจะรันไม่ไม่เห็นบรรทัดใหม่ทำให้เกิด
                        // Error ได้
                        textDelete[linedelete] = x[i] + "\n"; // อันนี้ +แบบขึ้นบรรทัดใหม้
                        ++linedelete;
                    } else {
                        textDelete[linedelete] = x[i]; // อันนี้ +แบบไม่ขึ้นบรรทัดใหม่ใช่ตอนสุดท้ายเพราะเดี๋ยวในไฟล์ txt
                                                       // มันขึ้นใหม่แล้วรันค่าไม่ได้
                    }
                }
            }
            int dialogButton = JOptionPane.showConfirmDialog(null, "คุณต้องการจะลบรายวิชานี้ใช่หรือไม่?", "ลบรายวิชา",
                    JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
            if (dialogButton == JOptionPane.YES_OPTION) {
                inputText(textDelete);
                ComboBox.removeItemAt(editeSubject);
                ComboboxSubjectCI.removeItemAt(editeSubject);
                textcode.setText("");
                textsubject.setText("");
                textcredit.setText("");
                btndelete.setEnabled(false);
                btnedit.setEnabled(false);
            }
            // ComboBox เมื่อมีการคลิีกที่ combobox
        } else if (e.getSource() == btnclearstudent) {
            textcodestudent.setText("");
            texttitlestudent.setText("");
            textnamestudent.setText("");
            textlastnamestudent.setText("");

        } else if (e.getSource() == ComboBox) {// เวลาเลือกแล้วจะเข้าอยู่ใน combobox เลย ไว้แก้ไขหรือลบจะได้ง่ายๆ
            btnedit.setEnabled(true);
            btndelete.setEnabled(true);
            String textSubject[] = new String[1];
            textSubject[0] = String.valueOf(ComboBox.getSelectedItem());
            textcode.setText(textSubject[0].substring(6, textSubject[0].indexOf("Subject:")).trim());// ดึงรายวิชา
            textsubject.setText(textSubject[0]
                    .substring(textSubject[0].indexOf("Subject:") + 8, textSubject[0].indexOf("Credit")).trim());// ดึงรายวิชาโดยเริ่มที่จากตำแหน่งรหัสวิชา
            textcredit.setText(textSubject[0].substring(textSubject[0].lastIndexOf(" ")).trim()); // ดึงตำแหน่งหน่วยกิตจากข้างหลัง
        } else if (e.getSource() == btnconaddSuject) {
            graphicsPanel1.setVisible(true);
            graphicsPanel2.setVisible(false);
            graphicsPanel3.setVisible(false);
            graphicsPanel4.setVisible(false);
            graphicsPanel5.setVisible(false);
            graphicsPanel6.setVisible(false);

            btnconaddSuject.setEnabled(false);
            btnconaddPr.setEnabled(true);
            btnconaddtablesorb.setEnabled(true);
            btnconaddtableStd.setEnabled(true);
            btnconStd.setEnabled(true);
            btnStudenttable.setEnabled(true);
        } else if (e.getSource() == btnconaddPr) {
            graphicsPanel1.setVisible(false);
            graphicsPanel2.setVisible(true);
            graphicsPanel3.setVisible(false);
            graphicsPanel4.setVisible(false);
            graphicsPanel5.setVisible(false);
            graphicsPanel6.setVisible(false);

            btnconaddSuject.setEnabled(true);
            btnconaddPr.setEnabled(false);
            btnconaddtablesorb.setEnabled(true);
            btnconaddtableStd.setEnabled(true);
            btnconStd.setEnabled(true);
            btnStudenttable.setEnabled(true);
        } else if (e.getSource() == btnconaddtablesorb) {
            comBoxNC = 0;
            display("1");
            graphicsPanel1.setVisible(false);
            graphicsPanel2.setVisible(false);
            graphicsPanel3.setVisible(true);
            graphicsPanel4.setVisible(false);
            graphicsPanel5.setVisible(false);
            graphicsPanel6.setVisible(false);

            btnconaddSuject.setEnabled(true);
            btnconaddPr.setEnabled(true);
            btnconaddtablesorb.setEnabled(false);
            btnconaddtableStd.setEnabled(true);
            btnconStd.setEnabled(true);
            btnStudenttable.setEnabled(true);

            String a[] = new String[100];
            outputTextProfessorr(a);
            String b[] = new String[count];

            int awtssss = ComboboxNameCI.getItemCount();
            for (int i = 0; i < awtssss; i++) {
                ComboboxNameCI.removeItemAt(0);
            }
            for (int i = 0; i < b.length; i++) {
                b[i] = a[i].substring(a[i].indexOf("name:") + 6, a[i].indexOf("lname:")).trim() + " "
                        + a[i].substring(a[i].indexOf("lname:") + 7).trim();
            }
            for (int i = 0; i < b.length; i++) {
                ComboboxNameCI.addItem(b[i]);
            }
            comBoxNC++;
        } else if (e.getSource() == btnconStd) {
            graphicsPanel1.setVisible(false);
            graphicsPanel2.setVisible(false);
            graphicsPanel3.setVisible(false);
            graphicsPanel4.setVisible(true);
            graphicsPanel5.setVisible(false);
            graphicsPanel6.setVisible(false);

            btnconaddSuject.setEnabled(true);
            btnconaddPr.setEnabled(true);
            btnconaddtablesorb.setEnabled(true);
            btnconStd.setEnabled(false);
            btnconaddtableStd.setEnabled(true);
            btnStudenttable.setEnabled(true);
        } else if (e.getSource() == btnconaddtableStd) {
            comBoxNC = 0;
            graphicsPanel1.setVisible(false);
            graphicsPanel2.setVisible(false);
            graphicsPanel3.setVisible(false);
            graphicsPanel4.setVisible(false);
            graphicsPanel5.setVisible(true);

            graphicsPanel6.setVisible(false);
            btnconaddSuject.setEnabled(true);
            btnconaddPr.setEnabled(true);
            btnconaddtablesorb.setEnabled(true);
            btnconaddtableStd.setEnabled(false);
            btnconStd.setEnabled(true);
            btnStudenttable.setEnabled(true);

            String tableSobr[] = new String[100];
            outputTexttableSobr(tableSobr);
            String tableSobr2[] = new String[count];
            for (int i = 0; i < count; i++) {
                tableSobr2[i] = tableSobr[i];
            }
            int awtssss = ComboboxsujectSTSJ.getItemCount(); // เปลี่ยน
            for (int i = 0; i < awtssss; i++) {
                ComboboxsujectSTSJ.removeItemAt(0);
            }
            for (int i = 0; i < tableSobr2.length; i++) {
                tableSobr2[i] = tableSobr2[i].substring(tableSobr2[i].indexOf("Subject:") + 9);
            }
            for (int i = 0; i < tableSobr2.length; i++) {
                ComboboxsujectSTSJ.addItem(tableSobr2[i]);
            }

            String student[] = new String[100];
            outputTextstudent(student);
            String student2[] = new String[count];
            for (int i = 0; i < count; i++) {
                student2[i] = student[i];
            }
            int awt = ComboboxnameSTSJ.getItemCount(); // เปลี่ยน
            for (int i = 0; i < awt; i++) {
                ComboboxnameSTSJ.removeItemAt(0);
            }
            // for (int i = 0; i < student2.length; i++) {
            // student2[i] = student2[i].substring();
            // }
            for (int i = 0; i < student2.length; i++) {
                ComboboxnameSTSJ.addItem(student2[i]);
            }

            comBoxNC++;
        } else if (e.getSource() == btnStudenttable) {
            comBoxNC = 0;
            graphicsPanel1.setVisible(false);
            graphicsPanel2.setVisible(false);
            graphicsPanel3.setVisible(false);
            graphicsPanel4.setVisible(false);
            graphicsPanel5.setVisible(false);
            graphicsPanel6.setVisible(true);
            // scrollPane.setVisible(true);

            btnconaddSuject.setEnabled(true);
            btnconaddPr.setEnabled(true);
            btnconaddtablesorb.setEnabled(true);
            btnconaddtableStd.setEnabled(true);
            btnconStd.setEnabled(true);
            btnStudenttable.setEnabled(false);

            String outputtext1[] = new String[100];
            outputTextstudent_subject(outputtext1);
            String outputtext2[] = new String[count];
            for (int i = 0; i < count; i++) {
                outputtext2[i] = outputtext1[i].substring(0, outputtext1[i].indexOf("Subject"));
            }

            int sum = 0;
            for (int i = 0; i < outputtext2.length; i++) {
                for (int j = i + 1; j < outputtext2.length; j++) {
                    if (outputtext2[i].equals(outputtext2[j])) {
                        outputtext2[j] = "";
                    }
                }
            }

            String outputtext3[] = new String[outputtext2.length];
            for (int i = 0; i < outputtext2.length; i++) {
                if (!outputtext2[i].equals("")) {
                    outputtext3[sum] = outputtext2[i];
                    sum++;
                }
            }

            for (int i = 0; i < sum; i++) {
                outputtext2[i] = outputtext3[i];
            }
            String outputtext4[] = new String[sum];
            for (int i = 0; i < sum; i++) {
                outputtext4[i] = outputtext2[i];
            }
            int awtssss = af.getItemCount(); // เปลี่ยน
            for (int i = 0; i < awtssss; i++) {
                af.removeItemAt(0);
            }

            for (int i = 0; i < outputtext4.length; i++) {
                af.addItem(outputtext4[i]);
            }
            comBoxNC++;
        } else if (e.getSource() == af && comBoxNC >= 1) {

            String subjecttable = af.getSelectedItem().toString();
            System.out.println("subjecttable: " + subjecttable);

            String etable[] = new String[100]; // ดึงไฟล์ ouptxt
            outputTextSubject(etable);
            String d[] = new String[count];
            for (int i = 0; i < count; i++) {
                d[i] = etable[i];
            }
            System.out.println("d: " + d[0]);

            String az[] = new String[d.length];
            for (int i = 0; i < d.length; i++) {
                az[i] = d[i].substring(0, d[i].indexOf("Subject")).trim(); // เอา subjecttable มาแปลงเหลือแค่ รหัส
                                                                           // คำนำหน้า ชื่อ และ นามสกุล
            }
            System.out.println("az: " + az[0]);// เอา subjecttable มาแปลงเหลือแค่ รหัส คำนำหน้า ชื่อ และ นามสกุล

            int lineinputSTSJ = 0;
            String inputSTSJ[] = new String[d.length];
            for (int i = 0; i < d.length; i++) {
                if (subjecttable.trim().equals(az[i].trim())) {
                    inputSTSJ[lineinputSTSJ] = d[i];
                    System.out.println("เข้า if แล้ว");
                    lineinputSTSJ++;
                }
            }
            System.out.println("inputSTSJ: " + inputSTSJ[0]);

            String test[] = new String[lineinputSTSJ];
            for (int i = 0; i < test.length; i++) {
                test[i] = inputSTSJ[i];
            }
            System.out.println("test[i]: " + test[0]);
            System.out.println("inputSTSJ[0]: " + inputSTSJ[0]
                    .substring(inputSTSJ[0].indexOf("time:") + 6, inputSTSJ[0].indexOf("people:")).trim());
            String onetime[] = new String[lineinputSTSJ];
            // System.out.println(inputSTSJ[0].substring(inputSTSJ[0].indexOf("time:") + 6,
            // inputSTSJ[0].indexOf("people:")).trim());
            // System.out.println(inputSTSJ[1].substring(inputSTSJ[1].indexOf("time:") + 6,
            // inputSTSJ[1].indexOf("people:")).trim());
            // System.out.println(inputSTSJ[2].substring(inputSTSJ[2].indexOf("time:") + 6,
            // inputSTSJ[2].indexOf("people:")).trim());
            // System.out.println(inputSTSJ[3].substring(inputSTSJ[3].indexOf("time:") + 6,
            // inputSTSJ[3].indexOf("people:")).trim());
            for (int i = 0; i < onetime.length; i++) {
                System.out.println("Error" + (i + 1));
                onetime[i] = inputSTSJ[i].substring(inputSTSJ[i].indexOf("time:") + 6, inputSTSJ[i].indexOf("people:"))
                        .trim();
            }
            System.out.println("Error2");
            System.out.println("awaw : "
                    + inputSTSJ[0].substring(inputSTSJ[0].indexOf("day:") + 5, inputSTSJ[0].indexOf("time:")).trim());
            for (int i = 0; i < lineinputSTSJ; i++) {
                inputSTSJ[i] = inputSTSJ[i].substring(inputSTSJ[i].indexOf("day:") + 5, inputSTSJ[i].indexOf("time:"))
                        .trim();
            }
            // for (int i = 0; i < inputSTSJ.length; i++) {
            // System.out.println("Time: " + onetime[i]);
            // System.out.println("ones: " + inputSTSJ[i]);

            // }
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.addColumn("วันที่/เวลา");
            model.setColumnCount(1);
            model.addColumn("09.00-12.00");
            model.addColumn("12.00-13.00");
            model.addColumn("13.00-16.00");
            // model.setColumnCount(1);
            model.setRowCount(1);
            // model.setRowCount();
            String dayTable[] = { "วันจันทร์", "อังคาร", "วันพุธ", "วันพฤหัสบดี", "วันศุกร์" };
            // Data Row แอดข้อมูล
            for (int i = 0; i < dayTable.length; i++) {
                model.addRow(new Object[0]);
                model.setValueAt(dayTable[i], i, 0);
                model.setValueAt("พักกลางวัน", i, 2);
            }
            System.out.println("xxxxx");
            for (int i = 0; i < lineinputSTSJ; i++) {
                // i,0 i=แถวแนวตั้ง 0=แถวแนวนอน
                if (onetime[i].equals("09.00-12.00")) {
                    System.out.println("เข้า 09.00-12.00");
                    if (inputSTSJ[i].equals("Monday")) {
                        model.setValueAt(test[i].substring(test[i].indexOf("Subject") + 8, test[i].indexOf("Credit:")),
                                0, 1);
                    } else if (inputSTSJ[i].equals("Tuesday")) {
                        model.setValueAt(test[i].substring(test[i].indexOf("Subject") + 8, test[i].indexOf("Credit:")),
                                1, 1);
                    } else if (inputSTSJ[i].equals("Wednesday")) {
                        model.setValueAt(test[i].substring(test[i].indexOf("Subject") + 8, test[i].indexOf("Credit:")),
                                2, 1);
                    } else if (inputSTSJ[i].equals("Thursday")) {
                        model.setValueAt(test[i].substring(test[i].indexOf("Subject") + 8, test[i].indexOf("Credit:")),
                                3, 1);
                    } else if (inputSTSJ[i].equals("Friday")) {
                        model.setValueAt(test[i].substring(test[i].indexOf("Subject") + 8, test[i].indexOf("Credit:")),
                                4, 1);
                    } else {
                        System.out.println("บัคเฉย"); // เงื่อนไขนี้มันไม่เข้าหรอกถ้ามันไฟล์ผิดจริงๆ
                    }
                } else if (onetime[i].equals("13.00-16.00")) {
                    System.out.println("เข้า 13.00-16.00");
                    if (inputSTSJ[i].equals("Monday")) {
                        model.setValueAt(test[i].substring(test[i].indexOf("Subject") + 8, test[i].indexOf("Credit:")),
                                0, 3);
                    } else if (inputSTSJ[i].equals("Tuesday")) {
                        model.setValueAt(test[i].substring(test[i].indexOf("Subject") + 8, test[i].indexOf("Credit:")),
                                1, 3);
                    } else if (inputSTSJ[i].equals("Wednesday")) {
                        model.setValueAt(test[i].substring(test[i].indexOf("Subject") + 8, test[i].indexOf("Credit:")),
                                2, 3);
                    } else if (inputSTSJ[i].equals("Thursday")) {
                        model.setValueAt(test[i].substring(test[i].indexOf("Subject") + 8, test[i].indexOf("Credit:")),
                                3, 3);
                    } else if (inputSTSJ[i].equals("Friday")) {
                        model.setValueAt(test[i].substring(test[i].indexOf("Subject") + 8, test[i].indexOf("Credit:")),
                                4, 3);
                    } else {
                        System.out.println("บัคเฉย"); // เงื่อนไขนี้มันไม่เข้าหรอกถ้าไฟล์มันไม่ผิดจริงๆ
                    }
                }
            }
            table.getTableHeader().setFont(new Font(fonts, Font.BOLD, 20));
            table.setFont(new Font(fonts, Font.HANGING_BASELINE, 20));
            table.setBackground(new Color(155, 255, 190));
            table.setForeground(Color.black);
            JTableHeader tableHeader = table.getTableHeader();
            tableHeader.setBackground(new Color(78, 78, 78));
            table.getTableHeader().setForeground(Color.white);
            table.setEnabled(false);
            // ส่วนในการแต่ง table ^^
            // Column Width สีใน table
            table.getColumnModel().getColumn(0).setPreferredWidth(10);
            table.getColumnModel().getColumn(1).setPreferredWidth(200);
            table.getColumnModel().getColumn(2).setPreferredWidth(10);
            table.getColumnModel().getColumn(3).setPreferredWidth(200);
            // table.setForeground(Color.black);
            // Row Height ความกว้างxยาวขนาดขนาดในตาราง
            table.setRowHeight(30);
            // Column Center ข้อมูลใน table อยู่ตรงกลาง
            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment(JLabel.CENTER);
            for (int i = 0; i < 4; i++)
                table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
            // table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
            // System.out.println("*******************************************************************");
            comBoxNC++;

        } else if (e.getSource() == btnaddProfessorr) {
            checkcondition = "inputPr";
            // System.out.println("name L : " + namePr);
            String z[] = new String[100];// ส่ง z ไปเก็บชื่อรายวิชาแต่ละตำแหน่งไว้ใน array
            outputTextProfessorr(z); // ส่ง z ไป
            String x[] = new String[count]; // แล้วเอา X มีค่าเท่า count ซึ่ง count ค่าจะอยู่ ใน method outputText
            for (int i = 0; i < count; i++) {
                x[i] = z[i]; // แล้วเอา x มาเก็บค่า z ในแต่ละตำแหน่ง array ตามจำ for loop ของ count
            }
            charaddCodePr(x);
            System.out.println("x : " + x[0]);
            checkprofessorr(codePr, namePr, lnamePr, x, checkcondition);
            if (ceckError == 0) { // ถ้าใช่ == 0 ; จะเพิ่มข้อความใน text file
                inputTextProfessorr(name);
                // --------------------------------------\\
                // show in comboBox
                String a[] = new String[100];
                outputTextProfessorr(a);
                String b[] = new String[count];
                for (int i = 0; i < count; i++) {
                    b[i] = a[i];
                }
                ComboBoxprofessorr.addItem(b[count - 1]);
                // ComboboxNameCI.addItem(b[count - 1]);
                JOptionPane.showMessageDialog(null, "เพิ่มข้อมูลอาจารย์ผู้สอนเรียบร้อยแล้ว", "เพิ่มข้อมูลอาจารย์ผู้สอน",
                        JOptionPane.INFORMATION_MESSAGE);
                textcodeprofessor.setText("");
                textnameprofessorr.setText("");
                textlastnameprofessorr.setText("");
            }
            ceckError = 0;
        } else if (e.getSource() == ComboBoxprofessorr) {
            btnEditProfessorr.setEnabled(true);
            btndeleteProfessorr.setEnabled(true);
            String textSubject[] = new String[1];
            textSubject[0] = String.valueOf(ComboBoxprofessorr.getSelectedItem());
            textcodeprofessor.setText(textSubject[0].substring(6, textSubject[0].indexOf("name:")).trim());// ดึงรหัสอาจารย์
                                                                                                           // index ที่
                                                                                                           // 0 ถึง 13

            textnameprofessorr.setText(textSubject[0]
                    .substring(textSubject[0].indexOf("name:") + 6, textSubject[0].indexOf("lname:")).trim());
            // subString 14 คือดึง value แต่ตำแหน่ง index ที่14 indexof ไปหาข้อความ " " แล้ว
            // return ค่ากลับมา ในตำแหน่งที่จะดึงถึง
            textlastnameprofessorr.setText(textSubject[0].substring((textSubject[0].lastIndexOf(" ") + 1))); // ดึงตำแหน่งหน่วยกิตจากข้างหลัง

        } else if (e.getSource() == btnEditProfessorr) {
            checkcondition = "editPr";
            String z[] = new String[100];// ส่ง z ไปเก็บชื่อรายวิชาแต่ละตำแหน่งไว้ใน array
            outputTextProfessorr(z); // ส่ง z ไป
            String x[] = new String[count]; // แล้วเอา X มีค่าเท่า count ซึ่ง count ค่าจะอยู่ ใน method outputText
            for (int i = 0; i < count; i++) {
                x[i] = z[i]; // แล้วเอา x มาเก็บค่า z ในแต่ละตำแหน่ง array ตามจำ for loop ของ count
            }
            x[ComboBoxprofessorr.getSelectedIndex()] = "Code: " + codePr + " name: " + namePr + " lname: " + lnamePr;
            ; // ให้ x ในตำแหน่งของ
              // index Combobox
            String textEdit[] = new String[x.length];
            for (int i = 0; i < textEdit.length; i++) {
                if (i < textEdit.length - 1) {
                    textEdit[i] = x[i] + "\n";
                } else {
                    textEdit[i] = x[i];
                }
            }
            charaddCodePr(x);
            checkprofessorr(codePr, namePr, lnamePr, x, checkcondition);
            if (ceckError == 0) { // ถ้าใช่ == 0 ; จะเพิ่มข้อความใน text file
                int dialogButton = JOptionPane.showConfirmDialog(null, "คุณแน่ใจต้องการจะแก้ข้อมูลนักศึกษา",
                        "แก้ไขอาจารย์ผู้สอน", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                if (dialogButton == JOptionPane.YES_OPTION) {
                    inputTextProfessorr(textEdit);
                    String a[] = new String[100];
                    outputTextProfessorr(a);
                    String b[] = new String[count];
                    for (int i = 0; i < count; i++) {
                        b[i] = a[i];
                    }
                    // System.out.println("b = " + b[editProfessorr]);
                    ComboBoxprofessorr.removeItemAt(editProfessorr);// ลบข้อมูลใน comboox ในตำแหน่ง index
                    // ที่เราเลือก
                    ComboBoxprofessorr.insertItemAt(b[editProfessorr], editProfessorr);// ให้ตัวแปร b[edite]
                    // คือเลือกข้อความในตำแหน่ง index นี้
                    // ComboboxNameCI.removeItemAt(editProfessorr);
                    // ComboboxNameCI.insertItemAt(b[editProfessorr], editProfessorr);
                    // editle
                    // ให้ไปแทรกอยู่ใน combobox ที่ edite เลือกไว้
                    JOptionPane.showMessageDialog(null, "แก้ไขข้อมูลอาจารย์ผู้สอนเรียบร้อยแล้ว", "แก้ไขอาจารย์ผู้สอน",
                            JOptionPane.INFORMATION_MESSAGE);
                    textcodeprofessor.setText("");
                    textnameprofessorr.setText("");
                    textlastnameprofessorr.setText("");
                    btnEditProfessorr.setEnabled(false);
                    btndeleteProfessorr.setEnabled(false);
                }
            }
            ceckError = 0;
        } else if (e.getSource() == btndeleteProfessorr) {
            checkcondition = "delete";
            String z[] = new String[100];// ส่ง z ไปเก็บชื่อรายวิชาแต่ละตำแหน่งไว้ใน array
            outputTextProfessorr(z); // ส่ง z ไป
            String x[] = new String[count]; // แล้วเอา X มีค่าเท่า count ซึ่ง count ค่าจะอยู่ ใน method outputText
            for (int i = 0; i < count; i++) {
                x[i] = z[i]; // แล้วเอา x มาเก็บค่า z ในแต่ละตำแหน่ง array ตามจำ for loop ของ count
            }
            x[ComboBoxprofessorr.getSelectedIndex()] = "";
            String textDelete[] = new String[x.length - 1];// ที่ลบ 1 เพราะจะต้องมีตัวแปรถูกลบทิ้งไป
            int linedelete = 0;// ไว้ใช้เก็บข้อมูลในตัวแปรร array แทน i เพราะถ้าในตำแหน่งของ for
                               // มีเงื่อนไขใดไม่เป็นจริงจะไม่หรือเป็นจริง ค่า i ก็จะ +1 ตลอด และ
            // ถ้าในตำแหน่งที่ถูกลบไปก็จะเพิ่มค่าเข้าไปเป็น null เลยใช้ linedelete มาดักแทน
            // System.out.println(x.length);
            for (int i = 0; i < x.length; i++) {
                if (!x[i].equals("")) {// 1 ไม่เท่ากับ 1 F
                    if (i < x.length - 1 && linedelete + 1 < x.length - 1) {// ให้ค่า
                                                                            // ที่จะเก็บตัวตอนตัวสุดท้ายไปขึ้นบรรทัดใหม่
                        // && linedelete เกิน x.length จะให้ไปบวกค่าใหม่เพราะว่าค่า index
                        // ตัวสุดท้ายจะต้องไม่มี \n
                        // เพราะถ้าเราเลือกลบวิชาตัวท้ายค่า index มันจะรันไม่ไม่เห็นบรรทัดใหม่ทำให้เกิด
                        // Error ได้
                        textDelete[linedelete] = x[i] + "\n"; // อันนี้ +แบบขึ้นบรรทัดใหม้
                        ++linedelete;
                    } else {
                        textDelete[linedelete] = x[i]; // อันนี้ +แบบไม่ขึ้นบรรทัดใหม่ใช่ตอนสุดท้ายเพราะเดี๋ยวในไฟล์ txt
                                                       // มันขึ้นใหม่แล้วรันค่าไม่ได้
                    }
                }
            }
            // System.out.println("x");
            int dialogButton = JOptionPane.showConfirmDialog(null, "คุณแน่ใจต้องการจะลบข้อมูลอาจารย์ผู้สอน",
                    "อาจารย์ผู้สอน", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
            if (dialogButton == JOptionPane.YES_OPTION) {
                inputTextProfessorr(textDelete);
                ComboBoxprofessorr.removeItemAt(editProfessorr);
                // ComboboxNameCI.removeItemAt(editProfessorr);
                JOptionPane.showMessageDialog(null, "คุณข้อมูลเรียบร้อยแล้ว", "ลบข้อมูล",
                        JOptionPane.INFORMATION_MESSAGE);
                textcodeprofessor.setText("");
                textnameprofessorr.setText("");
                textlastnameprofessorr.setText("");
                btndeleteProfessorr.setEnabled(false);
                btnEditProfessorr.setEnabled(false);
            }
        } else if (e.getSource() == btnInputCI) {
            // System.out.println("x");
            String nameCI = String.valueOf(ComboboxNameCI.getSelectedItem());
            String subjectCI = String.valueOf(ComboboxSubjectCI.getSelectedItem());
            String sec = String.valueOf(ComboboxSection.getSelectedItem());
            String people = textMaxpeople.getText();
            String day = String.valueOf(ComboboxDay.getSelectedItem());
            String time = String.valueOf(ComboboxTime.getSelectedItem());
            String inst_subject = "name: " + nameCI + " Subject: " + subjectCI + " Section: " + sec + " day: " + day
                    + " time: " + time + " people: " + people;

            String z[] = new String[100];
            outputTexttableSobr(z);
            String x[] = new String[count];
            for (int i = 0; i < count; i++) {
                x[i] = z[i];
            }
            int point = 0; // ให้นำค่าใน text ที่มีชื่อคนสอนซ้ำกัน
            String ckeck[] = new String[x.length];
            for (int i = 0; i < x.length; i++) {
                if (nameCI.equals(x[i].substring(6, x[0].indexOf("Subject:")).trim())) {// เงื่อนไขตรวจสอบโดยตรวจจาก
                                                                                        // combox
                    // // ที่เลือกชื่ออาจารย์ไปเปรียบเทียบกับ
                    // // ชื่ออาจารย์ในไฟล์ txt
                    ckeck[i] = x[i];
                    point++;
                }
            }
            if (point >= 9) {// ถ้ารายวิชามากกว่า 9 ก็จะไม่เพิ่มข้อมูล
                JOptionPane.showMessageDialog(null, "คุณเลือกวิชาได้ทั้งหมดแค่ 9 วิชาเท่านั้น", "รายวิชา",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                int love = 0;
                checkInstructor_table(nameCI, subjectCI, sec, people, day, time, inst_subject, x);
                if (ceckError == 0) {
                    arsorb.setText("");
                    inputInstructor_table(inst_subject);
                    JOptionPane.showMessageDialog(null, "เพิ่มข้อมูลสำเร็จ", "เพิ่มข้อมูล",
                            JOptionPane.INFORMATION_MESSAGE);
                    String cz[] = new String[100];// ส่ง cz ไปเก็บชื่อรายวิชาแต่ละตำแหน่งไว้ใน array
                    outputTexttableSobr(cz); // ส่ง cz ไป
                    String cd[] = new String[count]; // แล้วเอา cd มีค่าเท่า count ซึ่ง count ค่าจะอยู่ ใน method
                                                     // outputTecdt
                    for (int i = 0; i < count; i++) {
                        cd[i] = cz[i]; // แล้วเอา cd มาเก็บค่า z ในแต่ละตำแหน่ง array ตามจำ for loop ของ count
                    }
                    // cd คือค่าตารางสอนของ Instrucotr_table หรือตาสอนของอาจารย์
                    String checkprCI[] = new String[cd.length];
                    for (int i = 0; i < cd.length; i++) {
                        if (nameCI.equals(cd[i].substring(6, cd[i].indexOf("Subject")).trim())) {
                            checkprCI[love] = cd[i].substring(cd[i].indexOf("Subject") + 9);
                            love++;
                        }
                    }
                    for (int i = 0; i < love; i++) {// Loop
                                                    // นี้เอาชื่อและนามสกุลมาเก็บไว้ในตัวแปรไว้มาแสดงชื่อของอาจารย์ใน
                                                    // textaren
                        arsorb.append((i + 1) + ") " + checkprCI[i] + "\n");
                    }
                    String a[] = new String[100];
                    outputTexttableSobr(a);
                    String b[] = new String[count];
                    for (int i = 0; i < count; i++) {
                        b[i] = a[i];
                    }
                }
                ceckError = 0;
            }
        } else if (e.getSource() == ComboboxNameCI && comBoxNC >= 1) {
            display("2");
            // System.out.println("ค่าใน combobox : " +
            // ComboboxNameCI.getSelectedItem().toString());
            String nameComboboxNameCI = ComboboxNameCI.getSelectedItem().toString();
            int love = 0;
            arsorb.setText("");
            String cz[] = new String[100];// ส่ง cz ไปเก็บชื่อรายวิชาแต่ละตำแหน่งไว้ใน array
            outputTexttableSobr(cz); // ส่ง cz ไป
            String cd[] = new String[count]; // แล้วเอา cd มีค่าเท่า count ซึ่ง count ค่าจะอยู่ ใน method
                                             // outputTecdt
            for (int i = 0; i < count; i++) {
                cd[i] = cz[i]; // แล้วเอา cd มาเก็บค่า z ในแต่ละตำแหน่ง array ตามจำ for loop ของ count
            }
            String checkprCI[] = new String[cd.length];
            for (int i = 0; i < cd.length; i++) {
                if (nameComboboxNameCI.equals(cd[i].substring(6, cd[i].indexOf("Subject")).trim())) {
                    checkprCI[love] = cd[i].substring(cd[i].indexOf("Subject") + 9);
                    love++;
                }
            }
            for (int i = 0; i < love; i++) {// Loop
                // นี้เอาชื่อและนามสกุลมาเก็บไว้ในตัวแปรไว้มาแสดงชื่อของอาจารย์ใน
                // textaren
                arsorb.append((i + 1) + ") " + checkprCI[i] + "\n");
            }
            // comBoxNC--;

        } else if (e.getSource() == btninputstudent) {
            checkcondition = "inputstudent";
            // *********************************** *\\\\\\\\\
            // ใช้ตรวจสอบเงื่อนไข เอาตัว code ออก มา เช็คเงื่อนไข
            String z[] = new String[100];// ส่ง z ไปเก็บชื่อรายวิชาแต่ละตำแหน่งไว้ใน array
            outputTextstudent(z); // ส่ง z ไป
            String x[] = new String[count]; // แล้วเอา X มีค่าเท่า count ซึ่ง count ค่าจะอยู่ ใน method outputText
            for (int i = 0; i < count; i++) {
                x[i] = z[i]; // แล้วเอา x มาเก็บค่า z ในแต่ละตำแหน่ง array ตามจำ for loop ของ count
            }

            String CcodeStudent[] = new String[count];// อันนี้ตัวสอบรหัสวิชาที่ซ้ำกัน
            for (int i = 0; i < count; i++) {
                CcodeStudent[i] = x[i]; // แล้วเอา x มาเก็บค่า z ในแต่ละตำแหน่ง array ตามจำ for loop ของ count
            }
            charaddCodeStudent(CcodeStudent);// ดึงตำแหน่งtext
            // System.out.println(CcodeStudent[0]);
            checkstudent(codeST, titleST, nameST, lnameST, CcodeStudent, checkcondition);//
            String Ssubject[] = new String[count];
            charaddSubject(x, Ssubject);
            // **************************************************\\
            // input to file Txt
            if (ceckError == 0) { // ถ้าใช่ == 0 ; จะเพิ่มข้อความใน text file
                inputTextStunde(inputST);
                // --------------------------------------\\
                // show in comboBox
                String a[] = new String[100];
                outputTextstudent(a);
                String b[] = new String[count];
                for (int i = 0; i < count; i++) {
                    b[i] = a[i];
                }
                Comboboxstudent.addItem(b[count - 1]);
                ComboboxnameSTSJ.addItem(b[count - 1]);
                JOptionPane.showMessageDialog(null, "เพิ่มข้อมูลนักศึกษาเรียบร้อย", "เพิ่มข้อมูลสำเร็จ",
                        JOptionPane.INFORMATION_MESSAGE);
                textcodestudent.setText("");
                textnamestudent.setText("");
                textlastnamestudent.setText("");
                texttitlestudent.setText("");
            }
            ceckError = 0;
            // ---------------------------------------------\\
            // Edit
        } else if (e.getSource() == btneditstudent) {
            checkcondition = "editstudent";
            String z[] = new String[100];// ส่ง z ไปเก็บชื่อรายวิชาแต่ละตำแหน่งไว้ใน array
            outputTextstudent(z); // ส่ง z ไป
            String x[] = new String[count]; // แล้วเอา X มีค่าเท่า count ซึ่ง count ค่าจะอยู่ ใน method outputText
            for (int i = 0; i < count; i++) {
                x[i] = z[i]; // แล้วเอา x มาเก็บค่า z ในแต่ละตำแหน่ง array ตามจำ for loop ของ count
            }
            x[Comboboxstudent.getSelectedIndex()] = "code: " + codeST + " title: " + titleST + " name: " + nameST
                    + " lname: " + lnameST;
            ; // ให้ x
              // ในตำแหน่งของ
              // index
              // Combobox
              // ที่เราเลือกไว้
            String textEdit[] = new String[x.length];
            for (int i = 0; i < textEdit.length; i++) {
                if (i < textEdit.length - 1) {
                    textEdit[i] = x[i] + "\n";
                } else {
                    textEdit[i] = x[i];
                }
            }
            charaddCodeStudent(x);
            checkstudent(codeST, titleST, nameST, lnameST, x, checkcondition);//

            if (ceckError == 0) { // ถ้าใช่ == 0 ; จะเพิ่มข้อความใน text file
                int dialogButton = JOptionPane.showConfirmDialog(null, "คุณแน่ใจที่ต้องการจำแก้ไขข้อมูลนักศึกษา",
                        "แก้ไขข้อมูลนักศึกษา", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                if (dialogButton == JOptionPane.YES_OPTION) {
                    inputTextStunde(textEdit);
                    // --------------------------------------\\
                    // show in comboBox
                    String a[] = new String[100];
                    outputTextstudent(a);
                    String b[] = new String[count];
                    for (int i = 0; i < count; i++) {
                        b[i] = a[i];
                    }
                    Comboboxstudent.removeItemAt(editestudent);// ลบข้อมูลใน comboox ในตำแหน่ง index ที่เราเลือก
                    Comboboxstudent.insertItemAt(b[editestudent], editestudent);// ให้ตัวแปร b[edite]
                                                                                // คือเลือกข้อความในตำแหน่ง
                    // index นี้
                    // editle
                    // ให้ไปแทรกอยู่ใน combobox ที่ edite เลือกไว้
                    ComboboxnameSTSJ.removeItemAt(editestudent);// ลบข้อมูลใน comboox ในตำแหน่ง index ที่เราเลือก
                    ComboboxnameSTSJ.insertItemAt(b[editestudent], editestudent);

                    JOptionPane.showMessageDialog(null, "แก้ไขสำเร็จ", "แก้ไขข้อมูลนักศึกษา",
                            JOptionPane.INFORMATION_MESSAGE);
                    textcodestudent.setText("");
                    textnamestudent.setText("");
                    textlastnamestudent.setText("");
                    texttitlestudent.setText("");
                    btndeletestudent.setEnabled(false);
                    btneditstudent.setEnabled(false);
                }
            }
            ceckError = 0;
        } else if (e.getSource() == btndeletestudent) {
            checkcondition = "delete";
            String z[] = new String[100];// ส่ง z ไปเก็บชื่อรายวิชาแต่ละตำแหน่งไว้ใน array
            outputTextstudent(z); // ส่ง z ไป
            String x[] = new String[count]; // แล้วเอา X มีค่าเท่า count ซึ่ง count ค่าจะอยู่ ใน method outputText
            for (int i = 0; i < count; i++) {
                x[i] = z[i]; // แล้วเอา x มาเก็บค่า z ในแต่ละตำแหน่ง array ตามจำ for loop ของ count
            }
            x[Comboboxstudent.getSelectedIndex()] = "";
            String textDelete[] = new String[x.length - 1];// ที่ลบ 1 เพราะจะต้องมีตัวแปรถูกลบทิ้งไป
            int linedelete = 0;// ไว้ใช้เก็บข้อมูลในตัวแปรร array แทน i เพราะถ้าในตำแหน่งของ for
                               // มีเงื่อนไขใดไม่เป็นจริงจะไม่หรือเป็นจริง ค่า i ก็จะ +1 ตลอด และ
            // ถ้าในตำแหน่งที่ถูกลบไปก็จะเพิ่มค่าเข้าไปเป็น null เลยใช้ linedelete มาดักแทน
            // System.out.println(x.length);
            for (int i = 0; i < x.length; i++) {
                if (!x[i].equals("")) {// 1 ไม่เท่ากับ 1 F
                    if (i < x.length - 1 && linedelete + 1 < x.length - 1) {// ให้ค่า
                                                                            // ที่จะเก็บตัวตอนตัวสุดท้ายไปขึ้นบรรทัดใหม่
                        // && linedelete เกิน x.length จะให้ไปบวกค่าใหม่เพราะว่าค่า index
                        // ตัวสุดท้ายจะต้องไม่มี \n
                        // เพราะถ้าเราเลือกลบวิชาตัวท้ายค่า index มันจะรันไม่ไม่เห็นบรรทัดใหม่ทำให้เกิด
                        // Error ได้
                        textDelete[linedelete] = x[i] + "\n"; // อันนี้ +แบบขึ้นบรรทัดใหม้
                        ++linedelete;
                    } else {
                        textDelete[linedelete] = x[i]; // อันนี้ +แบบไม่ขึ้นบรรทัดใหม่ใช่ตอนสุดท้ายเพราะเดี๋ยวในไฟล์ txt
                                                       // มันขึ้นใหม่แล้วรันค่าไม่ได้
                    }
                }
            }
            int dialogButton = JOptionPane.showConfirmDialog(null, "คุณแน่ใจที่ต้องการจะลบรายชื่อนักศึกษาคนนี้",
                    "ลบรายชื่อนักศึกษา", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
            if (dialogButton == JOptionPane.YES_OPTION) {
                inputTextStunde(textDelete);
                Comboboxstudent.removeItemAt(edisutdeit);
                ComboboxnameSTSJ.removeItemAt(edisutdeit);
                textcodestudent.setText("");
                textnamestudent.setText("");
                textlastnamestudent.setText("");
                texttitlestudent.setText("");
                btndeletestudent.setEnabled(false);
                btneditstudent.setEnabled(false);
            }
        } else if (e.getSource() == btnaddSTSJ) {// ตารางแอดนักศึกษากับวิชาเข้าไป
            String nameSTSJ = String.valueOf(ComboboxnameSTSJ.getSelectedItem());
            String sujectSTSJ = String.valueOf(ComboboxsujectSTSJ.getSelectedItem());
            String allSTSJ = nameSTSJ + " Subject " + sujectSTSJ;
            String z[] = new String[100];// ส่ง z ไปเก็บชื่อรายวิชาแต่ละตำแหน่งไว้ใน array
            outputTextSubject(z); // ส่ง z ไป
            String x[] = new String[count]; // แล้วเอา X มีค่าเท่า count ซึ่ง count ค่าจะอยู่ ใน method outputText
            for (int i = 0; i < count; i++) {
                x[i] = z[i]; // แล้วเอา x มาเก็บค่า z ในแต่ละตำแหน่ง array ตามจำ for loop ของ count
            }
            student_table(nameSTSJ, sujectSTSJ, allSTSJ, x);
            if (ceckError == 0) {
                arsorb.setText("");
                inputstudent(allSTSJ); // ห้ามลบ
                JOptionPane.showMessageDialog(null, "เพิ่มตาเรียนสำเร็จ", "เพิ่มตามเรียน",
                        JOptionPane.INFORMATION_MESSAGE);
            }
            ceckError = 0;

        } else if (e.getSource() == ComboboxnameSTSJ && comBoxNC >= 1) {
            display("2");
            // System.out.println("ค่าใน combobox : " +
            // ComboboxnameSTSJ.getSelectedItem().toString());
            String nameComboboxNameCI = ComboboxnameSTSJ.getSelectedItem().toString();
            int love = 0;
            textareaSTSJ.setText("");
            String cz[] = new String[100];// ส่ง cz ไปเก็บชื่อรายวิชาแต่ละตำแหน่งไว้ใน array
            outputTextstudent_subject(cz);
            String cd[] = new String[count]; // แล้วเอา cd มีค่าเท่า count ซึ่ง count ค่าจะอยู่ ใน method
                                             // outputTecdt
            for (int i = 0; i < count; i++) {
                cd[i] = cz[i]; // แล้วเอา cd มาเก็บค่า z ในแต่ละตำแหน่ง array ตามจำ for loop ของ count
            }
            String checkprCI[] = new String[cd.length];
            System.out.println(cd[0].substring(0, cd[0].indexOf("Subject")));
            System.out.println(nameComboboxNameCI);
            for (int i = 0; i < cd.length; i++) {
                if (nameComboboxNameCI.trim().equals(cd[i].substring(0, cd[i].indexOf("Subject")).trim())) {
                    checkprCI[love] = cd[i].substring(cd[i].indexOf("Subject"));
                    System.out.println("x");
                    love++;
                }
            }
            for (int i = 0; i < love; i++) {// Loop
                // นี้เอาชื่อและนามสกุลมาเก็บไว้ในตัวแปรไว้มาแสดงชื่อของอาจารย์ใน
                // textaren
                textareaSTSJ.append((i + 1) + ") " + checkprCI[i] + "\n");
            }
        } else if (e.getSource() == Comboboxstudent) {
            btneditstudent.setEnabled(true);
            btndeletestudent.setEnabled(true);
            btnclearstudent.setEnabled(true);
            display("a");
            String textst = Comboboxstudent.getSelectedItem().toString();
            textcodestudent.setText(textst.substring(6, textst.indexOf("title:")).trim());
            texttitlestudent.setText(textst.substring(textst.indexOf("title:") + 7, textst.indexOf("name:")).trim());
            textnamestudent.setText(textst.substring(textst.indexOf("name:") + 6, textst.indexOf("lname:")).trim());
            textlastnamestudent.setText(textst.substring(textst.indexOf("lname:") + 7).trim());
        } else if (e.getSource() == btnprint) {

        }
    }// end

    public void inputstudent(String text) {
        try {
            Path file = Paths.get(fille + "student_suject.txt");
            BufferedWriter writer = Files.newBufferedWriter(file, StandardCharsets.UTF_8, StandardOpenOption.APPEND);
            writer.write(text);
            writer.newLine();
            writer.close();
        } catch (IOException g) {
            System.err.println("IOException: " + g.getMessage());
        }
    }

    public void student_table(String nameSTSJ, String sujectSTSJ, String allSTSJ, String x[]) {
        System.out.println("nameSTSJ: " + nameSTSJ);
        System.out.println("sujectSTSJ: " + sujectSTSJ);
        System.out.println("allSTSJ: " + allSTSJ);
        System.out.println("x[0]: " + x[0]);

        System.out.println(x[0].substring(x[0].indexOf("name:") + 6, x[0].indexOf("lname:")).trim());
        System.out.println((x[0].substring(x[0].indexOf("lname:") + 7, x[0].indexOf("Subject"))).trim());
        System.out.println((x[0].substring(x[0].indexOf("day:") + 5, x[0].indexOf("people:"))).trim());

        String checkdaytime[] = new String[x.length];
        String checkdaytimeinput = allSTSJ.substring(allSTSJ.indexOf("name:") + 6, allSTSJ.indexOf("lname:")).trim()
                + " " + allSTSJ.substring(allSTSJ.indexOf("lname:") + 7, allSTSJ.indexOf("Subject")) + ""
                + allSTSJ.substring(allSTSJ.indexOf("day:") + 5, allSTSJ.indexOf("people:")).trim();
        // System.out.println("nameTEST "+allSTSJ.substring(allSTSJ.indexOf("name:") +
        // 6, allSTSJ.indexOf("lname:")).trim() + " "
        // + allSTSJ.substring(allSTSJ.indexOf("lname:") + 7,
        // allSTSJ.indexOf("Subject")) + ""
        // + allSTSJ.substring(allSTSJ.indexOf("day:") + 5,
        // allSTSJ.indexOf("people:")).trim());

        for (int i = 0; i < x.length; i++) {
            checkdaytime[i] = x[i].substring(x[i].indexOf("name:") + 6, x[i].indexOf("lname:")).trim() + " "
                    + x[i].substring(x[i].indexOf("lname:") + 7, x[i].indexOf("Subject")) + ""
                    + x[i].substring(x[i].indexOf("day:") + 5, x[i].indexOf("people:")).trim();
        }
        // System.out.println(nameSTSJ.substring(6,nameSTSJ.indexOf("title:")).trim()+"
        // "+sujectSTSJ.substring(0,sujectSTSJ.indexOf("Credit:")).trim());
        // System.out.println(x[0].substring(6,x[0].indexOf("title:")).trim() +" "+
        // x[0].substring(x[0].indexOf("Subject")+8,x[0].trim().indexOf("Credit:")).trim());
        String checkNamesubjectar[] = new String[x.length];
        for (int i = 0; i < checkNamesubjectar.length; i++) {
            checkNamesubjectar[i] = x[i].substring(6, x[i].indexOf("title:")).trim() + " "
                    + x[i].substring(x[i].indexOf("Subject") + 8, x[i].trim().indexOf("Credit:")).trim();
        }
        String checkNamesubject = nameSTSJ.substring(6, nameSTSJ.indexOf("title:")).trim() + " "
                + sujectSTSJ.substring(0, sujectSTSJ.indexOf("Credit:")).trim();
        for (int i = 0; i < x.length; i++) {
            if (nameSTSJ.equals("")) {
                JOptionPane.showMessageDialog(null, "กรุณาเลือกรหัสนักศึกษา", "รหัสนักศึกษ",
                        JOptionPane.WARNING_MESSAGE);
                ceckError++;
                break;
            } else if (sujectSTSJ.equals("")) {
                JOptionPane.showMessageDialog(null, "กรุณาเลือกรายวิชา", "รายวิชา", JOptionPane.WARNING_MESSAGE);
                ceckError++;
                break;
            } else if (allSTSJ.trim().equals(x[i].trim())) {
                System.out.println("x");
                ceckError++;
                JOptionPane.showMessageDialog(null, "คุณเลือกรายวิชานี้ไปแล้ว", "Error", JOptionPane.ERROR_MESSAGE);
                break;
            } else if (checkNamesubject.equals(checkNamesubjectar[i])) {
                System.out.println("x");
                ceckError++;
                JOptionPane.showMessageDialog(null, "คุณเลือกวิชานี้ไปแล้ว", "วิชานี้ถูกเลือกไปแล้ว",
                        JOptionPane.WARNING_MESSAGE);
                break;
            } else if (checkdaytimeinput.equals(checkdaytime[i])) {
                System.out.println("y");
                ceckError++;
                JOptionPane.showMessageDialog(null,
                        "คุณไม่สามารถเพิ่มรายวิชาในวันนี้เหนื่องจากวันที่คุณเลือกตารางสอนเต็มแล้ว", "ตามสอนเต็ม",
                        JOptionPane.WARNING_MESSAGE);
                break;
            }
        }
    }

    public void charaddstudent_suject(String valueinput[]) {
        String nameT = "";
        for (int i = 0; i < valueinput.length; i++) {
            for (int j = 0; j < 13; j++) {
                nameT += valueinput[i].charAt(j);
            }
            valueinput[i] = nameT;
            nameT = "";
        }
    }

    public void outputTextstudent_subject(String a[]) {
        count = 0;
        File file = new File(fille + "student_suject.txt");// ตำแหน่งไฟล์
        Scanner sc = new Scanner(System.in);
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String text[] = new String[100];// ขนาดของ file
        while (sc.hasNextLine()) { // loop text in file
            text[count] = sc.nextLine(); // เอาข้อความแต่ละบันทัดมาเก็บไว้ใน text array
            count++;
        }
        for (int i = 0; i < count; i++) {
            a[i] = text[i];
        }
    }

    public void checkInstructor_table(String nameCI, String subjectCI, String sec, String people, String day,
            String time, String inst_subject, String x[]) {

        // display(nameCI); // nameCI ชื่อออาจารย์ผู้สอน
        // display(subjectCI); //ชือวิชา+กับหน่วยกิต
        // display(sec); // Section ที่ลงทะเบียน
        // display(people); //จำนวนคนที่ลงทะเบียนได้
        // display(day); //วันจันทร์-ศุกร์
        // display(time);// เวลา 09.00-12.00
        // display(inst_subject); // ค่าทุกอย่างมาบวกรวมกัน
        // display(x[0]);// ข้อมูลใน file text

        String checkPSDT = inst_subject;// ตรวจสอบ อาจารย์ วิชา วัน เวลา เวลาที่ไฟล์ input เข้ามา
        String checkPSDTxt[] = new String[x.length];// ตรวจสอบ อาจารย์ วิชา วัน เวลา เวลาที่ไฟล์ txt เข้ามา
        checkPSDT = checkPSDT.substring(6, checkPSDT.indexOf("Subject")).trim() + " "
                + checkPSDT.substring(checkPSDT.indexOf("day:") + 5, checkPSDT.indexOf("time:")).trim() + " "
                + checkPSDT.substring(checkPSDT.indexOf("time:") + 6, checkPSDT.indexOf("people:")).trim(); // ตรวจสอบ
                                                                                                            // อาจารย์
                                                                                                            // วัน
                                                                                                            // เวลา
                                                                                                            // เวลาที่ไฟล์
                                                                                                            // input
                                                                                                            // เข้ามา
        for (int i = 0; i < checkPSDTxt.length; i++) {
            checkPSDTxt[i] = x[i].substring(6, x[i].indexOf("Subject")).trim() + " "
                    + x[i].substring(x[i].indexOf("day:") + 5, x[i].indexOf("time:")).trim() + " "
                    + x[i].substring(x[i].indexOf("time:") + 6, x[i].indexOf("people:")).trim();// ตรวจสอบ อาจารย์
                                                                                                // วัน เวลา เวลาที่ไฟล์
                                                                                                // txt ที่เข้ามา
        }
        for (int i = 0; i < x.length; i++) {
            if (people.equals("")) {
                JOptionPane.showMessageDialog(null, "กรุณาใส่จำนวนคนต่อตอนเรียน", "นักเรียนในคลาสเรียน",
                        JOptionPane.WARNING_MESSAGE);
                ceckError++;
                break;
            } else if (Integer.parseInt(people) > 100 || Integer.parseInt(people) < 10) {
                JOptionPane.showMessageDialog(null,
                        "จำนวนของนักเรียนในตอนเรียนต้องมีตั้งแต่ 10 คนขึ้นไปจนถึง 100 เท่านั้น", "นักเรียนในคลาสเรียน",
                        JOptionPane.WARNING_MESSAGE);
                ceckError++;
                break;
            } else if (inst_subject.equals(x[i])) {
                JOptionPane.showMessageDialog(null, "คุณได้เลือกรายวิชาและเวลาของวันที่คุณเลือกไปแล้ว",
                        "วันและเวลาที่เลือกคุณเลือกสอนไปแล้ว.", JOptionPane.WARNING_MESSAGE);
                ceckError++;
                break;
            } else if (checkPSDT.equals(checkPSDTxt[i])) {
                JOptionPane.showMessageDialog(null, "วันที่คุณเลือกสอนเต็มตารางในวันสอนนั้นแล้ว กรุณาเลือกวันอื่นแทนเ",
                        "วันที่เลือกสอนเต็ม", JOptionPane.WARNING_MESSAGE); // วันที่สอนเต็มโปรดเลือกวันอื่น,วันที่สอนเต็มแล้ว
                ceckError++;
                break;
            }
        }
    }

    public void inputInstructor_table(String text) {
        try {
            Path file = Paths.get(fille + "Instructor_table.txt");
            BufferedWriter writer = Files.newBufferedWriter(file, StandardCharsets.UTF_8, StandardOpenOption.APPEND);
            writer.write(text);
            writer.newLine();
            writer.close();
        } catch (IOException g) {
            System.err.println("IOException: " + g.getMessage());
        }
    }

    // ----------------------------------- metod Edit Pr
    // ตรวจสอบรายชื่ออาจารย์
    public void checkprofessorr(String code, String name, String LastName, String checkcode[], String checkcondition) {

        if (code.equals("")) {// ถ้าไม่มีรหัสอาจารย์ให้ไปกรอกข้อมูลใหม่
            JOptionPane.showMessageDialog(null, "กรุณาใส่รหัสประจำตัวอาจารย์ผู้สอน", "รหัสประจำตัว",
                    JOptionPane.ERROR_MESSAGE);
            ceckError++;
        } else if (name.equals("")) { // เงื่อนไขตรวจสอบชื่อให้ใส่ค่า
            JOptionPane.showMessageDialog(null, "กรุณาใส่ชื่ออาจารย์ผู้สอน", "ชื่อ", JOptionPane.ERROR_MESSAGE);
            ceckError++;
        } else if (LastName.equals("")) {// ถ้าไม่ใส่ นามสกุลต้องใส่ก่อน
            JOptionPane.showMessageDialog(null, "กรุณาใส่นามสกุลอาจารย์ผู้สอน", "นามสกุล", JOptionPane.ERROR_MESSAGE);
            ceckError++;
        } else if (code.length() > 13 || code.length() < 13) { // ตรวจสอบรหัสวิชาต้องมีให้ครบ 13 ตัว
            JOptionPane.showMessageDialog(null,
                    "รหัสประจำตัวของอาจารย์ผู้สอนจะต้องมี 13 หลักเท่านั้น คุณใส่" + code.length() + " เลข",
                    "รหัสประจำตัว", JOptionPane.ERROR_MESSAGE);
            ceckError++;
        }
        if (checkcondition.equals("inputPr")) {
            for (int i = 0; i < checkcode.length; i++) {
                if (code.equals(checkcode[i])) { // ตรวจสอบเงื่อนห้ามรหัสรายวิชาซ้ำกันถ้าซ้ำกันจะไม่เพิ่มข้อมูลลงใน file
                                                 // text
                    JOptionPane.showMessageDialog(null, "รหัสอาจารย์ผู้สอนซ้ำกัน", "รหัสประจำตัวผู้สอน",
                            JOptionPane.ERROR_MESSAGE);
                    ceckError++;
                    break;
                }
            }
        } else if (checkcondition.equals("editPr")) {
            // System.out.println("xxxxx");
            String z[] = new String[100];// ส่ง z ไปเก็บชื่อรายวิชาแต่ละตำแหน่งไว้ใน array
            outputTextProfessorr(z); // ส่ง z ไป
            String x[] = new String[count]; // แล้วเอา X มีค่าเท่า count ซึ่ง count ค่าจะอยู่ ใน method outputText
            for (int i = 0; i < count; i++) {
                x[i] = z[i]; // แล้วเอา x มาเก็บค่า z ในแต่ละตำแหน่ง array ตามจำ for loop ของ count
            }
            charaddCodePr(x);// ส่ง x ไปเก็บแค่รหัสรายวิชา
            for (int i = 0; i < checkcode.length; i++) {
                if (code.equals(x[i]) && !code.equals(x[ComboBoxprofessorr.getSelectedIndex()])) { // ตรวจสอบเงื่อนห้ามรหัสรายวิชาซ้ำกันถ้าซ้ำกันจะไม่เพิ่มข้อมูลลงใน
                    // file text
                    // !code.equals(x[ComboBox.getSelectedIndex()] นี้คือเมื่อมีการคลิ๊ก combobox
                    // จะดึงตำแหน่ง index ของ combobox มาตรวจสอบ
                    JOptionPane.showMessageDialog(null,
                            "ไม่สามารถแก้ไขได้เหนื่องจากรหัสอาจารย์ผู้สอนที่คุณเปลี่ยนซ้ำกัน", "รหัสประจำตัวผู้สอน",
                            JOptionPane.ERROR_MESSAGE);
                    ceckError++;
                    break;
                }
            }
        }

    }

    // ---------------------------------------------------------------------------
    // method Overload
    // method ดึงรหัสวิชา
    public void charaddCodePr(String valueinput[]) {
        for (int i = 0; i < valueinput.length; i++) {
            valueinput[i] = valueinput[i].substring(5, valueinput[i].indexOf("name:")).trim();
        }
    }

    // ดึงรหัสวิชา+++++++++++++++++++++++++
    public void charaddCode(String valueinput[]) {
        for (int i = 0; i < valueinput.length; i++) {
            valueinput[i] = valueinput[i].substring(5, valueinput[i].indexOf("Subject:")).trim();
        }
    }

    // method ดึงรหัสวิชา ++++++++
    public void charaddCode(String valueinput[], String valueoutput[]) {
        String nameT = "";
        for (int i = 0; i < valueinput.length; i++) {
            for (int j = 0; j < 9; j++) {
                // System.out.println(valueinput[0]);
            }
            valueoutput[i] = nameT;
            nameT = "";
        }
    }

    // -----------------------------------------------------------------------------------
    // method ดึงวิชา ++++++++++++++++
    public void charaddSubject(String valueinput[], String valueoutput[]) {
        // System.out.println("test1");
        for (int i = 0; i < valueinput.length; i++) {
            valueoutput[i] = valueinput[i].substring(10, valueinput[i].length() - 2);
        }
    }

    // เป็น method เช็คเงื่อนไขของวิชา ++++++++++++++++++++++++
    public void checksubject(String code, String subject, String credit, String a[], String checkcondition) {
        if (code.equals("")) {// ถ้า รหัส วิชาไม่ใส่ให้กรอกข้อมูล
            JOptionPane.showMessageDialog(null, "กรุณาใส่รหัสนักศึกษา", "ใส่รหัสนักศึกษา", JOptionPane.ERROR_MESSAGE);
            ceckError++;
        } else if (subject.equals("")) { // ถ้าวิชาให้ใส่ข้อมูลก่อน
            JOptionPane.showMessageDialog(null, "กรุณาใส่ชื่อวิชา", "ใส่รหัสวิชา", JOptionPane.ERROR_MESSAGE);
            ceckError++;
        } else if (credit.trim().equals("")) {// ถ้าไม่ใส่ หน่วยกิตต้องใส่ก่อน
            JOptionPane.showMessageDialog(null, "กรุณาใส่หน่วยกิตของวิชา", "ใส่หน่วกิต", JOptionPane.ERROR_MESSAGE);
            ceckError++;
        } else if (code.length() > 9 || code.length() < 9) { // ตรวจสอบรหัสวิชาต้องมีให้ครบ 9 ตัว
            JOptionPane.showMessageDialog(null,
                    "รหัสวิชาจะต้องมีแค่ 9 ตัวเท่านั้น คุณใส่รหัสไป " + code.length() + " เลข", "ใส่โค้ดให้ถูกต้อง",
                    JOptionPane.ERROR_MESSAGE);
            ceckError++;
        } else if (Integer.parseInt(credit.trim()) > 3 || Integer.parseInt(credit.trim()) < 1) {// หน่วยกิตต้องมี 1
                                                                                                // หน่วยกิต
            // และห้ามเกิน 3 หน่วยกิต
            JOptionPane.showMessageDialog(null, "รายวิชาหน่อยกิตจะต้องไม่เกิน 3 หน่วยกิต และไม่น้อยกว่า 2 หน่วยกิต",
                    "ใส่หน่วยกิตให้ถูกต้อง", JOptionPane.ERROR_MESSAGE);
            ceckError++;
        }
        System.out.println("code : " + code);
        System.out.println("a[0] : " + a[0]);
        // อันนี้จะเป็นเงื่อนไขเมื่อคลิ๊กที่ปุ่ม input
        if (checkcondition.equals("input")) {
            for (int i = 0; i < a.length; i++) {
                if (code.trim().equals(a[i])) { // ตรวจสอบเงื่อนห้ามรหัสรายวิชาซ้ำกันถ้าซ้ำกันจะไม่เพิ่มข้อมูลลงใน file
                                                // text
                    JOptionPane.showMessageDialog(null, "รหัสรายวิชาห้ามซ้ำกัน", "กรุณาใส่รหัสวิชาให้ถูกต้องห้ามซ้ำกัน",
                            JOptionPane.ERROR_MESSAGE);
                    ceckError++;
                    break;
                }
            }
            // อันนี้จะเป็นเงื่อนไขเมื่อคลิ๊กที่ปุ่ม edit
        } else if (checkcondition.equals("edit")) {
            String z[] = new String[100];// ส่ง z ไปเก็บชื่อรายวิชาแต่ละตำแหน่งไว้ใน array
            outputText(z); // ส่ง z ไป
            String x[] = new String[count]; // แล้วเอา X มีค่าเท่า count ซึ่ง count ค่าจะอยู่ ใน method outputText
            for (int i = 0; i < count; i++) {
                x[i] = z[i]; // แล้วเอา x มาเก็บค่า z ในแต่ละตำแหน่ง array ตามจำ for loop ของ count
            }
            charaddCode(x);// ส่ง x ไปเก็บแค่รหัสรายวิชา
            for (int i = 0; i < a.length; i++) {
                if (code.trim().equals(x[i]) && !code.equals(x[ComboBox.getSelectedIndex()])) { // ตรวจสอบเงื่อนห้ามรหัสรายวิชาซ้ำกันถ้าซ้ำกันจะไม่เพิ่มข้อมูลลงใน
                    // file text
                    // !code.equals(x[ComboBox.getSelectedIndex()] นี้คือเมื่อมีการคลิ๊ก combobox
                    // จะดึงตำแหน่ง index ของ combobox มาตรวจสอบ
                    JOptionPane.showMessageDialog(null, "ไม่สามารถเพิ่มได้รหัสวิชาซ้ำกัน", "รหัสวิชาซ้ำกัน",
                            JOptionPane.ERROR_MESSAGE);
                    ceckError++;
                    break;
                }
            }
        }
    }

    // ----------------------------------------------Over
    // load----------------------------------------------------------------
    public void inputText(String text[]) {
        try {
            Path file = Paths.get(fille + "Subject.txt");
            BufferedWriter writer = Files.newBufferedWriter(file, StandardCharsets.UTF_8);
            for (int i = 0; i < text.length; i++) {
                // System.out.println("ข้อความ"+text[i]);
                writer.write(text[i]);
            }

            writer.newLine();
            writer.close();
        } catch (IOException g) {
            System.err.println("IOException: " + g.getMessage());
        }
    }

    public void inputText(String text) {
        try {
            Path file = Paths.get(fille + "Subject.txt");
            BufferedWriter writer = Files.newBufferedWriter(file, StandardCharsets.UTF_8, StandardOpenOption.APPEND);
            writer.write(text);
            writer.newLine();
            writer.close();
        } catch (IOException g) {
            System.err.println("IOException: " + g.getMessage());
        }
    }

    // --------+++++++++++++++++++++++-----------------------------------------------------------
    public void outputText(String a[]) {
        count = 0;
        File file = new File(fille + "Subject.txt");// ตำแหน่งไฟล์
        Scanner sc = new Scanner(System.in);
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String text[] = new String[100];// ขนาดของ file
        while (sc.hasNextLine()) { // loop text in file
            text[count] = sc.nextLine(); // เอาข้อความแต่ละบันทัดมาเก็บไว้ใน text array
            count++;
        }
        for (int i = 0; i < count; i++) {
            a[i] = text[i];
        }
    }

    // -----------------------------------------------------------------------------------------------------------
    public void inputTextProfessorr(String text) {
        try {
            Path file = Paths.get(fille + "Professorr.txt");
            BufferedWriter writer = Files.newBufferedWriter(file, StandardCharsets.UTF_8, StandardOpenOption.APPEND);
            writer.write(text);
            writer.newLine();
            writer.close();
        } catch (IOException g) {
            System.err.println("IOException: " + g.getMessage());
        }
    }

    public void inputTextProfessorr(String text[]) {
        try {
            Path file = Paths.get(fille + "Professorr.txt");
            BufferedWriter writer = Files.newBufferedWriter(file, StandardCharsets.UTF_8);
            for (int i = 0; i < text.length; i++) {
                // System.out.println("ข้อความ"+text[i]);
                writer.write(text[i]);
            }

            writer.newLine();
            writer.close();
        } catch (IOException g) {
            System.err.println("IOException: " + g.getMessage());
        }
    }

    public void outputTextProfessorr(String a[]) {
        count = 0;
        File file = new File(fille + "Professorr.txt");// ตำแหน่งไฟล์
        Scanner sc = new Scanner(System.in);
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String text[] = new String[100];// ขนาดของ file
        while (sc.hasNextLine()) { // loop text in file
            text[count] = sc.nextLine(); // เอาข้อความแต่ละบันทัดมาเก็บไว้ใน text array
            count++;
        }
        for (int i = 0; i < count; i++) {
            a[i] = text[i];
        }
    }

    //////////////////////////////////////////////// ไฟล์ text ตามรางสอบ
    public void outputTexttableSobr(String a[]) {
        count = 0;
        File file = new File(fille + "Instructor_table.txt");// ตำแหน่งไฟล์
        Scanner sc = new Scanner(System.in);
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String text[] = new String[100];// ขนาดของ file
        while (sc.hasNextLine()) { // loop text in file
            text[count] = sc.nextLine(); // เอาข้อความแต่ละบันทัดมาเก็บไว้ใน text array
            count++;
        }
        for (int i = 0; i < count; i++) {
            a[i] = text[i];
        }
    }

    ////////////////////// นักเรียน/////////////////
    public void outputTextstudent(String a[]) {
        count = 0;
        File file = new File(fille + "student.txt");// ตำแหน่งไฟล์
        Scanner sc = new Scanner(System.in);
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String text[] = new String[100];// ขนาดของ file
        while (sc.hasNextLine()) { // loop text in file
            text[count] = sc.nextLine(); // เอาข้อความแต่ละบันทัดมาเก็บไว้ใน text array
            count++;
        }
        for (int i = 0; i < count; i++) {
            a[i] = text[i];
        }
    }

    public void charaddCodeStudent(String valueinput[], String valueoutput[]) {
        String nameT = "";
        for (int i = 0; i < valueinput.length; i++) {
            for (int j = 0; j < 13; j++) {
                nameT += valueinput[i].charAt(j);
            }
            valueoutput[i] = nameT;
            nameT = "";
        }
    }

    public void checkstudent(String codeCT, String title, String name, String lastname, String a[],
            String checkcondition) {
        System.out.println("code:" + codeCT);
        if (codeCT.equals("")) {// ถ้า รหัส วิชาไม่ใส่ให้กรอกข้อมูล
            JOptionPane.showMessageDialog(null, "กรุณาใส่รหัสนักศึกษา", "Input Code", JOptionPane.ERROR_MESSAGE);
            ceckError++;
        } else if (title.equals("")) { // ถ้าวิชาให้ใส่ข้อมูลก่อน
            JOptionPane.showMessageDialog(null, "กรุณาใส่คำนำหน้าชื่อ", "Input title", JOptionPane.ERROR_MESSAGE);
            ceckError++;
        } else if (name.equals("")) {// ถ้าไม่ใส่ หน่วยกิตต้องใส่ก่อน
            JOptionPane.showMessageDialog(null, "กรุณาใส่ชื่อ", "Input name", JOptionPane.ERROR_MESSAGE);
            ceckError++;
        } else if (lastname.equals("")) {// ถ้าไม่ใส่ หน่วยกิตต้องใส่ก่อน
            JOptionPane.showMessageDialog(null, "กรุณาใส่นามสกุล", "Input name", JOptionPane.ERROR_MESSAGE);
            ceckError++;
        } else if (codeCT.length() < 13 || codeCT.length() > 13) {
            JOptionPane.showMessageDialog(null, "รหัสนักศึกษาจะต้องมีแค่ 13 หลักเท่านั้น", "Input name",
                    JOptionPane.ERROR_MESSAGE);
            ceckError++;
        }

        // อันนี้จะเป็นเงื่อนไขเมื่อคลิ๊กที่ปุ่ม input
        if (checkcondition.equals("inputstudent")) {
            for (int i = 0; i < a.length; i++) {
                if (codeCT.equals(a[i])) { // ตรวจสอบเงื่อนห้ามรหัสรายวิชาซ้ำกันถ้าซ้ำกันจะไม่เพิ่มข้อมูลลงใน file text
                    JOptionPane.showMessageDialog(null, "รหัสนักศึกษาซ้ำกัน", "รหัสนักศึกาา",
                            JOptionPane.ERROR_MESSAGE);
                    ceckError++;
                    break;
                }
            }
            // อันนี้จะเป็นเงื่อนไขเมื่อคลิ๊กที่ปุ่ม edit
        } else if (checkcondition.equals("editstudent")) {
            String z[] = new String[100];// ส่ง z ไปเก็บชื่อรายวิชาแต่ละตำแหน่งไว้ใน array
            outputTextstudent(z); // ส่ง z ไป
            String x[] = new String[count]; // แล้วเอา X มีค่าเท่า count ซึ่ง count ค่าจะอยู่ ใน method outputText
            for (int i = 0; i < count; i++) {
                x[i] = z[i]; // แล้วเอา x มาเก็บค่า z ในแต่ละตำแหน่ง array ตามจำ for loop ของ count
            }
            charaddCodeStudent(x);// ส่ง x ไปเก็บแค่รหัสรายวิชา
            for (int i = 0; i < a.length; i++) {
                if (codeCT.equals(x[i]) && !codeCT.equals(x[Comboboxstudent.getSelectedIndex()])) { // ตรวจสอบเงื่อนห้ามรหัสรายวิชาซ้ำกันถ้าซ้ำกันจะไม่เพิ่มข้อมูลลงใน
                    // file text
                    // !code.equals(x[ComboBox.getSelectedIndex()] นี้คือเมื่อมีการคลิ๊ก combobox
                    // จะดึงตำแหน่ง index ของ combobox มาตรวจสอบ
                    JOptionPane.showMessageDialog(null, "ไม่สามารถแก้ไขได้เหนื่องจากมีการใช้รหัสนักศึกษานี้ไปแล้ว",
                            "รหัสนักศึกษา", JOptionPane.ERROR_MESSAGE);
                    ceckError++;
                    break;
                }
            }
        }
    }

    public void inputTextStunde(String text) {
        try {
            Path file = Paths.get(fille + "student.txt");
            BufferedWriter writer = Files.newBufferedWriter(file, StandardCharsets.UTF_8, StandardOpenOption.APPEND);
            writer.write(text);
            writer.newLine();
            writer.close();
        } catch (IOException g) {
            System.err.println("IOException: " + g.getMessage());
        }
    }

    public void inputTextStunde(String text[]) {
        try {
            Path file = Paths.get(fille + "student.txt");
            BufferedWriter writer = Files.newBufferedWriter(file, StandardCharsets.UTF_8);
            for (int i = 0; i < text.length; i++) {
                // System.out.println("ข้อความ"+text[i]);
                writer.write(text[i]);
            }

            writer.newLine();
            writer.close();
        } catch (IOException g) {
            System.err.println("IOException: " + g.getMessage());
        }
    }

    public void charaddCodeStudent(String valueinput[]) {
        for (int i = 0; i < valueinput.length; i++) {
            valueinput[i] = valueinput[i].substring(5, valueinput[i].indexOf("title:")).trim();
        }
    }

    public static void main(String[] args) {
        From win = new From(); // obj method constructor
        win.setSize(1200, 700); // set ขนาดหน้าจอ
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width - win.getWidth()) / 2;
        int y = (screenSize.height - win.getHeight()) / 2;
        win.setVisible(true);//
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        win.setLocation(x, y);
    }











    

    // ใช้ test print
    public void display(String a) {
        System.out.println(a);
    }

    public void display(String a[]) {
        System.out.println(a);
    }

    public void display(int a[]) {
        System.out.println(a);
    }

    public void display(int a) {
        System.out.println(a);
    }

    public void display(Double a) {
        System.out.println(a);
    }

    public void display(Double a[]) {
        System.out.println(a);
    }
}

// 01) พรุ่งนี้มาต่อ แค่ใน lengt มันลดแล้วแต่ ใน combox ตัวแปรรมันไม่หาย
// 27/04/64
// 03:15 แก้ไขได้แล้ว 27/04/64 17:11

// 02) เดี๋ยวมาแก้ไขโดยเข้าข้อมูลเพิ่มเข้าไปใน text แล้วให้มันเพิ่มใน combobox
// 27/04/64 17:12 ทำได้แล้ว 27/04/64 20:03 อันนี้ Ez จัด

// 03) ทำข้อมูลที่ซ้ำกันเพิ่มเข้าไปใน text ไม่ได้ 27/04/64 20:05 // ทำได้แล้ว
// 28/04/64 03:51 ทำเสร็จทุกเงื่อนไข
// ตั้งแต่ไม่ใส่ รหัสวิชา ชื่อวิชา หน่วย ให้ขึ้น message error ดักไว้

// 04)ไปดูส่วนของ method ที่ดึงชื่อวิชาด้วยเอาไปทำไรต่อดี และต่อไปลองทำลบแก้ไขดู
// // 28/04/64 03:53

// 05)พึ่งทำในส่วนของ edit เสร็จทำตั้ง 3-4 ทุ่ม จนตอนนี้ 3:31 พึ่งได้
// // 09/05/64 03:53

// 06)ทำลบได้ละใช้เวลาแปปเดียวจากปุ่ม Edit เดี๋ยวเอามาใช้เงื่อนไขเวลาลบอีกที่
// // 09/05/64 04:17

// 07)ตอนนี้ เพิ่ม ลบ แก้ไข ได้หมดแล้วเสร็จเรียบร้อย
// เหลือเอาข้อมูลมาเพิ่มเรื่อยๆ
// // 09/05/64 06:01

// 08) ทำในส่วนของการเพิ่มอาจารย์ผู้สอบได้ละ เหลือ ลบ แก้ไข
// ไว้ค่อยมาทำใหม่ง่วงนอน
/// 09/5/64 8:00 พอดีเปะ

// 09) เดะมาลบอาจารย์ และ แยก Obj

// 10) ลบชื่ออาจารย์ได้แล้ว แยก method เดี๋ยวมาดูอีกที่โคตรจะงงจะแยกดีไหม
// 10/05/64 12:54

// 11) เดี๋ยวมาทำในส่วนของ text area
// เวลาเราเลือกชื่ออาจารย์ให้มันมาแสดงแค่รายการสอนอาจารย์แค่คนนั้นใน textarea
// ตอนนนี้เริ่มงงกับ code ที่จะหลายรรทัดและโคตรจะงง ตายลายไปหมด code จะเกือบ
// 1000 บรรทัดแล้ว นี้ขนาดใช้เป็น method
/// ถ้าไม่ใช้ method คงกระโดนไปเกือบ 2000+ 11/05/64 18:26

// 12) ค่อยไปแก้บรรทัดที่ 594 595มันจำกัด 9 วิชาลงใน area
// ยังไม่ได้เดี๋ยวค่อยไปแก้นิดหน่อย
// 12/05/64 16:20

// 13) ตอนนี้เพิ่มรายชื่อนักเรียนได้แล้วเหลือแต่แก้ไขลบ clear
// เดี๋ยวมาทำต่อกินข้าวก่อน
// 13/05/64 17:57

// 14) ตอนนี้เอาตารางสอนนักเรียนออกมาแสดงได้ละแต่ยังมีบัคเล็กน้อย ก็นี้ปาไป 1829
// บรรทัดแล้วไม่ได้แยกคลาสแยกแค่ method ถ้าไม่แยก method คงกระโดนไป 3000+ ได้
// 14/05/64 05:59 อีก 1 นาที 6 โมง ทำมาตั้งแต่ บ่าย3

// 15) เดี๋ยวมาดูตอนที่บรรทัด 842 แก้ไขเวลาเลือก combox แล้วตำแหน่ง
// ตารางสอนแสดงรายบุคคล
// 14/05/64 18:25

// 16) แก้ไขโครงสร้าง txtfile ใหม่ดีไหม 16/05/64
// 01:41 เริ่มแก้โครงสร้าง ไฟล์ txt ใหม่ มาดูกันจะเสร็จกี่โมง คาดไว้ประมาณ 6-7
// ขั่วโมง
// 1. แก้ไขโคร้งสร้างไฟล์ Subject ได้ละ ต่อ Professorr 02:22
// 2. แก้ไฟล์ Professorr ได้ละ 3:12
// 3. แก้ไฟล์ student ได้ละ 3:58

// 17) แก้โครงสร้างมาได้เยอะพอสำควรแหละ
// แล้วตอนนี้ก็เพิ่มรายวิชาของอาจารย์ห้ามซ้ำกันด้วยได้แล้วโดยห้าม เวลาซ้ำกัน
// เดี๋ยวมาทำในส่วนเอาข้อมูลอาจารย์มาโชว์ใน textarea ให้ได้ 16/05/64 08:18
//