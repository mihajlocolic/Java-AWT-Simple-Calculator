import java.awt.*;
import java.awt.event.*;
import java.awt.font.TextLayout;


public class Main extends Frame {

    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.white);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        TextLayout tl1 = new TextLayout("Enter first number:", new Font("Arial", Font.PLAIN, 15), g2.getFontRenderContext());
        tl1.draw(g2, 20, 50);
        TextLayout tl2 = new TextLayout("Enter second number:", new Font("Arial", Font.PLAIN, 15), g2.getFontRenderContext());
        tl2.draw(g2, 20, 120);
        TextLayout tl3 = new TextLayout("Select the operation:", new Font("Arial", Font.PLAIN, 15), g2.getFontRenderContext());
        tl3.draw(g2, 20, 200);

    }


    public static void main(String[] args) {
        Main frame = new Main();
        frame.setTitle("Simple Calculator");
        frame.setSize(300, 300);
        frame.setLocation(550, 250);
        frame.setBackground(Color.DARK_GRAY);
        frame.setLayout(null);


        //Ikonica za aplikaciju.
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Image icon = toolkit.getImage("src//calculator_icon.png");
        frame.setIconImage(icon);

        TextField tfr = new TextField();
        tfr.setBounds(170, 230, 90, 40);
        tfr.setEditable(false);
        frame.add(tfr);


        //Polja za prvi i drugi broj
        TextField tf1 = new TextField();
        tf1.setBounds(150, 35, 100, 20);
        frame.add(tf1);


        TextField tf2 = new TextField();
        tf2.setBounds(175, 105, 100, 20);
        frame.add(tf2);


        //Operacije
        Choice operations = new Choice();
        operations.add("add");
        operations.add("subtract");
        operations.add("multiply");
        operations.add("divide");

        operations.setBackground(Color.WHITE);
        operations.setBounds(170, 185, 75, 75);

        frame.add(operations);


        //Dugme za izvrsenje operacije nad brojevima.
        Button calculate = new Button();
        calculate.setLabel("Calculate");
        calculate.setSize(new Dimension(10, 10));
        calculate.setBackground(Color.LIGHT_GRAY);
        calculate.setBounds(50, 230, 80, 40);
        frame.add(calculate);
        calculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String selectedItem = operations.getSelectedItem();
                int num1 = Integer.parseInt(tf1.getText());
                int num2 = Integer.parseInt(tf2.getText());
                int result;

                if (selectedItem.equals("add")) {
                    result = num1 + num2;
                    tfr.setText(String.valueOf(result));
                } else if (selectedItem.equals("subtract")) {
                    result = num1 - num2;
                    tfr.setText(String.valueOf(result));
                } else if (selectedItem.equals("multiply")) {
                    result = num1 * num2;
                    tfr.setText(String.valueOf(result));
                } else if (selectedItem.equals("divide")) {
                    //Umesto int dodao sam double kako bi rezultat bio precizniji, i umesto try, catch-a dodao if naredbu za proveru nule.
                    double n1 = Double.parseDouble(tf1.getText());
                    double n2 = Double.parseDouble(tf2.getText());
                    double divisionResult = n1 / n2;
                    tfr.setText(String.valueOf(divisionResult));
                    if(n2 == 0) {
                        tfr.setText("Error: / by 0.");
                    }

                }
            }
        });


        //Slusac za zatvaranje aplikacije klikom na dugme za izlaz.
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        frame.setVisible(true);
    }

}
