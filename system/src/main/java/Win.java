import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.*;

import static java.awt.Color.RED;
import static java.awt.Color.blue;

public class Win {
    JFrame jf;

    public Win() {
        JFrame.setDefaultLookAndFeelDecorated(true);
        jf = new JFrame();
        initJFrame();
    }

    void initJFrame() {
        initMenu(jf);
        initMainText();
        JFrameSat(jf);
        jf.setTitle("学生信息管理系统");
    }

    private void JFrameSat(JFrame j) {

        j.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //设置界面宽高
        j.setSize(700, 448);

        //设置界面位置
        j.setLocationRelativeTo(null);
        j.setResizable(false);
        //设置界面置顶
        j.setAlwaysOnTop(true);
        //取消默认格式
        j.setLayout(null);
        //显示界面
        j.setVisible(true);
    }

    private void initMenu(JFrame jf) {
        JMenuBar jmb = new JMenuBar();
        JMenu jm1 = new JMenu("信息录入"),
                jm2 = new JMenu("信息查询"),
                jm3 = new JMenu("信息更新"),
                jm4 = new JMenu("信息删除"),
                jm5 = new JMenu("退出系统");

        JMenuItem jmi1 = new JMenuItem("录入"),
                jmi2 = new JMenuItem("查询"),
                jmi3 = new JMenuItem("更新"),
                jmi4 = new JMenuItem("删除"),
                jmi5 = new JMenuItem("退出");

        jmi1.addActionListener(j1());
        jmi2.addActionListener(j2());
        jmi3.addActionListener(j3());
        jmi4.addActionListener(j4());
        jmi5.addActionListener(j5());

        jm1.add(jmi1);
        jm2.add(jmi2);
        jm3.add(jmi3);
        jm4.add(jmi4);
        jm5.add(jmi5);

        jmb.add(jm1);
        jmb.add(jm2);
        jmb.add(jm3);
        jmb.add(jm4);
        jmb.add(jm5);


        jf.setJMenuBar(jmb);

    }

    private void initMainText() {
        JLabel jl1 = new JLabel("学生信息管理系统", SwingConstants.CENTER),
                jl2 = new JLabel("Student Information Management System", SwingConstants.CENTER);
        Font font1 = new Font(Font.SERIF, Font.BOLD, 30),
                font2 = new Font(Font.SERIF, Font.BOLD, 20);
        jl1.setBounds(200, 100, 300, 50);
        jl2.setBounds(150, 150, 400, 70);
        jl1.setFont(font1);
        jl2.setFont(font2);
        jl1.setForeground(blue);
        jl2.setForeground(blue);
        jf.getContentPane().add(jl1);
        jf.getContentPane().add(jl2);
    }

    private void setLabel(JFrame j, int num) {//num=1,录入 num=2,查询 num=3,删除
        JLabel jl1 = new JLabel(num == 1 ? "学号" : num == 2 ? "请输入学号" : num == 3 ? "输入修改学生的学号" : "输入要删除学生的学号"),
                jl2 = new JLabel("姓名"),
                jl3 = new JLabel("性别"),
                jl4 = new JLabel("地址"),
                jl5 = new JLabel("电话"),
                jl6 = new JLabel("专业");

        Font font = new Font("宋体", Font.BOLD, 20);
        jl1.setFont(font);
        jl2.setFont(font);
        jl3.setFont(font);
        jl4.setFont(font);
        jl5.setFont(font);
        jl6.setFont(font);

        jl1.setBounds(num == 1 ? 50 : 20, 30, num == 1 ? 70 : num == 2 ? 200 : 300, 30);
        jl2.setBounds(50, 80, 70, 30);
        jl3.setBounds(50, 130, 70, 30);
        jl4.setBounds(50, 180, 70, 30);
        jl5.setBounds(50, 230, 70, 30);
        jl6.setBounds(50, 280, 70, 30);

        j.getContentPane().add(jl1);
        j.getContentPane().add(jl2);
        j.getContentPane().add(jl3);
        j.getContentPane().add(jl4);
        j.getContentPane().add(jl5);
        j.getContentPane().add(jl6);
    }

    JTextField jt1 = new JTextField(),
            jt2 = new JTextField(),
            jt3 = new JTextField(),
            jt4 = new JTextField(),
            jt5 = new JTextField(),
            jt6 = new JTextField();

    private void setJTextField(JFrame j, int num) {


        jt1.setBounds(num == 1 ? 100 : num == 2 ? 150 : 250, 30, num == 1 ? 400 : 200, 30);
        jt2.setBounds(100, 80, 400, 30);
        jt3.setBounds(100, 130, 400, 30);
        jt4.setBounds(100, 180, 400, 30);
        jt5.setBounds(100, 230, 400, 30);
        jt6.setBounds(100, 280, 400, 30);

        clearJTextField();
        if (num != 1 && num != 3) {
            jt2.setEditable(false);
            jt3.setEditable(false);
            jt4.setEditable(false);
            jt5.setEditable(false);
            jt6.setEditable(false);
        } else {
            jt2.setEditable(true);
            jt3.setEditable(true);
            jt4.setEditable(true);
            jt5.setEditable(true);
            jt6.setEditable(true);
        }
        j.getContentPane().add(jt1);
        j.getContentPane().add(jt2);
        j.getContentPane().add(jt3);
        j.getContentPane().add(jt4);
        j.getContentPane().add(jt5);
        j.getContentPane().add(jt6);
    }

    private void clearJTextField() {
        jt1.setText("");
        jt2.setText("");
        jt3.setText("");
        jt4.setText("");
        jt5.setText("");
        jt6.setText("");
    }

    private void setButton(JFrame j, int num) {
        int width = 100,
                height = 40;
        switch (num) {
            case 1:
                JButton jb1 = new JButton("录入"),
                        jb2 = new JButton("重置");
                jb1.setBounds(170, 330, width, height);
                jb2.setBounds(290, 330, width, height);

                jb1.addActionListener(bt1());
                jb2.addActionListener(bt5());

                j.getContentPane().add(jb1);
                j.getContentPane().add(jb2);

                break;
            case 2:
                JButton jb3 = new JButton("查询");
                jb3.setBounds(370, 25, width, height);
                jb3.addActionListener(bt2());

                j.getContentPane().add(jb3);
                break;
            case 3:
                JButton jb4 = new JButton("查找"),
                        jb5 = new JButton("更新"),
                        jb6 = new JButton("重置");

                jb4.setBounds(490, 25, width, height);
                jb5.setBounds(170, 330, width, height);
                jb6.setBounds(290, 330, width, height);

                jb4.addActionListener(bt2());
                jb5.addActionListener(bt4());
                jb6.addActionListener(bt5());

                j.getContentPane().add(jb4);
                j.getContentPane().add(jb5);
                j.getContentPane().add(jb6);
                break;
            case 4:
                JButton jb7 = new JButton("删除");
                jb7.setBounds(490, 25, width, height);
                jb7.addActionListener(bt7());
                j.getContentPane().add(jb7);
                break;
        }
    }

    private void insertJFrame() {
        JFrame jf = new JFrame();
        jf.setTitle("学生信息管理系统 录入");
        JFrameSat(jf);
        initMenu(jf);
        setLabel(jf, 1);
        setJTextField(jf, 1);
        setButton(jf, 1);
        this.jf.setVisible(false);
        this.jf = jf;
    }

    private void selectJFrame() {
        JFrame jf = new JFrame();
        jf.setTitle("学生信息管理系统 查询");
        JFrameSat(jf);
        initMenu(jf);
        setLabel(jf, 2);
        setJTextField(jf, 2);
        setButton(jf, 2);
        this.jf.setVisible(false);
        this.jf = jf;
    }

    private void updateJFrame() {
        JFrame jf = new JFrame();
        jf.setTitle("学生信息管理系统 更新");
        JFrameSat(jf);
        initMenu(jf);
        setLabel(jf, 3);
        setJTextField(jf, 3);
        setButton(jf, 3);
        this.jf.setVisible(false);
        this.jf = jf;
    }

    private void deleteJFrame() {
        JFrame jf = new JFrame();
        jf.setTitle("学生信息管理系统 删除");
        JFrameSat(jf);
        initMenu(jf);
        setLabel(jf, 4);
        setJTextField(jf, 4);
        setButton(jf, 4);
        this.jf.setVisible(false);
        this.jf = jf;
    }

    public ActionListener j1() {
        return e -> insertJFrame();
    }

    public ActionListener j2() {
        return e -> selectJFrame();
    }

    public ActionListener j3() {
        return e -> updateJFrame();
    }

    public ActionListener j4() {
        return e -> deleteJFrame();
    }

    public ActionListener j5() {
        return e -> System.exit(1);
    }

    public void doSQL(int num) {
        String url = "jdbc:mysql://localhost:3306/message?useUnicode=true&characterEncoding=utf-8&serverTimezone=UTC";
        String name = "root";
        String password = "123456";
        String sql = num == 1 ? "insert into student values(?,?,?,?,?,?)" :
                num == 2 ? "select * from student where sno=?" :
                        "update student set sname=?,ssex=?,address=?,phone=?,sdept=? where sno=?";
        try {
            Connection con = DriverManager.getConnection(url, name, password);
            PreparedStatement pre = con.prepareStatement(sql);
            switch (num) {
                case 1:
                    pre.setString(1, jt1.getText());
                    pre.setString(2, jt2.getText());
                    pre.setString(3, jt3.getText());
                    pre.setString(4, jt4.getText());
                    pre.setString(5, jt5.getText());
                    pre.setString(6, jt6.getText());
                    pre.executeUpdate();
                    break;
                case 2:
                    pre.setString(1, jt1.getText());
                    ResultSet rs = pre.executeQuery();

                    if (rs.next()) {
                        String[] s = {rs.getString("sname"),
                                rs.getString("Ssex"),
                                rs.getString("address"),
                                rs.getString("phone"),
                                rs.getString("Sdept")
                        };
                        jt2.setText(s[0]);
                        jt3.setText(s[1]);
                        jt4.setText(s[2]);
                        jt5.setText(s[3]);
                        jt6.setText(s[4]);
                    } else {
                        clearJTextField();
                        jt1.setText("不存在此记录");
                    }
                    break;
                case 3:
                    pre.setString(1, jt2.getText());
                    pre.setString(2, jt3.getText());
                    pre.setString(3, jt4.getText());
                    pre.setString(4, jt5.getText());
                    pre.setString(5, jt6.getText());
                    pre.setString(6, jt1.getText());
                    pre.executeUpdate();
                    break;
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    JLabel jl_sex = new JLabel("性别必须是‘男’或‘女’！！！");
    JLabel jl_len = new JLabel("输入信息长度过长！");

    private void showError() {
        System.err.println("error");

        Font font = new Font("黑体", Font.BOLD, 15);
        jl_sex.setForeground(RED);
        jl_sex.setFont(font);
        jl_sex.setBounds(150, 150, 300, 40);
        jf.getContentPane().add(jl_sex);
        jf.setVisible(false);
        jf.setVisible(true);
    }

    private boolean checkLength() {
        if (jt1.getText().length() > 11 || jt2.getText().length() > 20 || jt4.getText().length() > 50 || jt5.getText().length() > 11 || jt6.getText().length() > 10) {
            System.err.println("too long");
            Font font = new Font("黑体", Font.BOLD, 20);
            jl_len.setFont(font);
            jl_len.setBounds(500, 150, 300, 20);
            jl_len.setForeground(RED);
            jf.getContentPane().add(jl_len);
            jf.setVisible(false);
            jf.setVisible(true);
            return false;
        }
        return true;
    }

    public ActionListener bt1() {//录入
        return e -> {
            jf.remove(jl_sex);
            if (jt3.getText().equals("男") || jt3.getText().equals("女")) {
                if (checkLength()) {
                    doSQL(1);
                }
            } else {

                clearJTextField();
                showError();
            }
            if (jt1.getText().isEmpty()) {
                jt1.setText("必须有学号");
            }
        };
    }

    public ActionListener bt2() {//查询
        return e -> {
            jf.remove(jl_len);
            jf.setVisible(false);
            jf.setVisible(true);
            if (jt1.getText().isEmpty()) {
                jt1.setText("必须有学号");
            } else {
                if (checkLength()) {
                    doSQL(2);
                }
            }
        };
    }


    public ActionListener bt4() {//更新
        return e -> {
            jf.remove(jl_sex);
            if (jt1.getText().isEmpty()) {
                jt1.setText("必须有学号");
            }
            if (jt3.getText().equals("男") || jt3.getText().equals("女")) {
                if (checkLength()) {
                    doSQL(3);
                }
            } else {
                clearJTextField();
                showError();
            }
        };
    }

    public ActionListener bt5() {
        return e -> {
            jt1.setText("");
            jt2.setText("");
            jt3.setText("");
            jt4.setText("");
            jt5.setText("");
            jt6.setText("");
            jf.remove(jl_sex);
            jf.remove(jl_len);
            jf.setVisible(false);
            jf.setVisible(true);
        };
    }

    public ActionListener bt7() {
        return e -> {
            if (jt1.getText().isEmpty()) {
                jt1.setText("必须有学号");
            } else {
                JFrame j = new JFrame("确定");
                j.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                //设置界面宽高
                j.setSize(500, 200);
                //设置界面位置
                j.setLocationRelativeTo(null);
                j.setResizable(false);
                //设置界面置顶
                j.setAlwaysOnTop(true);
                //取消默认格式
                j.setLayout(null);
                JLabel jl = new JLabel("确定要删除该条记录？");
                Font font = new Font("宋体", Font.BOLD, 25);
                jl.setFont(font);
                jl.setBounds(120, 50, 300, 30);
                j.getContentPane().add(jl);

                JButton jb1 = new JButton("是"),
                        jb2 = new JButton("否");
                jb1.setBounds(170, 100, 50, 30);
                jb2.setBounds(270, 100, 50, 30);
                jb1.addActionListener(bt8(j));
                jb2.addActionListener(bt9(j));
                j.getContentPane().add(jb1);
                j.getContentPane().add(jb2);
                //显示界面
                j.setVisible(true);
            }
        };
    }

    private boolean SQLdelete() {
        String url = "jdbc:mysql://localhost:3306/message?useUnicode=true&characterEncoding=utf-8&serverTimezone=UTC";
        String name = "root";
        String password = "123456";
        String sql = "delete from student where sno=?";
        int b = 0;
        try {
            Connection con = DriverManager.getConnection(url, name, password);
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setString(1, jt1.getText());
            b = pre.executeUpdate();
        } catch (Exception e) {
            e.getStackTrace();
            return false;
        }
        return b == 1;
    }

    public ActionListener bt8(JFrame jf) {//删除
        return e -> {
            boolean b = SQLdelete();//是否删除成功
            jf.setVisible(false);
            JFrame j = new JFrame("提示对话框");
            j.setSize(500, 200);
            JLabel jl = new JLabel(b ? "删除成功" : "删除失败");
            Font font = new Font("宋体", Font.BOLD, 25);
            jl.setFont(font);
            jl.setBounds(190, 50, 300, 30);
            j.getContentPane().add(jl);
            JButton jb = new JButton("确定");
            jb.setBounds(190, 100, 100, 30);
            jb.addActionListener(bt9(j));
            j.getContentPane().add(jb);

            //设置界面位置
            j.setLocationRelativeTo(null);
            j.setResizable(false);
            //设置界面置顶
            j.setAlwaysOnTop(true);
            //取消默认格式
            j.setLayout(null);
            j.setVisible(true);
        };
    }

    public ActionListener bt9(JFrame jf) {
        return e -> jf.setVisible(false);
    }
}
