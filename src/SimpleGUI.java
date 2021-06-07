import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Arc2D;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class SimpleGUI extends JFrame {
    private JButton button1 = new JButton("1");
    private JButton button2 = new JButton("2");
    private JButton button3 = new JButton("3");
    private JButton button4 = new JButton("4");
    private JButton button5 = new JButton("5");
    private JButton button6 = new JButton("6");
    private JButton button7 = new JButton("7");
    private JButton button8 = new JButton("8");
    private JButton button9 = new JButton("9");
    private JButton button0 = new JButton("0");
    private JButton buttonMin = new JButton("-");
    private JButton buttonPlus = new JButton("+");
    private JButton buttonEqu = new JButton("=");
    private JButton buttonDiv = new JButton("÷");
    private JButton buttonMul = new JButton("×");
    private JButton buttonPow = new JButton("^");
    private JButton buttonRoot = new JButton("√");
    private JButton buttonDelete = new JButton("⌦");
    private JButton buttonReset = new JButton("C");
    private JButton buttonComma = new JButton(".");//23 кнопки
    private JTextField input = new JTextField("", 2000);




    public static void changeFont(Component component, Font font)
    {
        component.setFont(font);
        if (component instanceof Container) {
            for (Component child : ((Container) component).getComponents()) {
                changeFont(child, font);
            }
        }
    }

    public boolean isLetters(String name) {
        char[] chars = name.toCharArray();

        for (char c : chars) {
            if (Character.isLetter(c)) {
                return true;
            }
        }

        return false;
    }
    boolean signMin = false;
    char sign1= '?';
    char sign2;
    double oneNumber = Double.NaN;
    double twoNumber = Double.NaN;

    public void errorDot() {
        JOptionPane.showMessageDialog(input,
                "OШИБКА! точек слишком много ", "Error Message",
                JOptionPane.ERROR_MESSAGE);
    }
    public void errorEqu() {
        JOptionPane.showMessageDialog(input,
                "OШИБКА! равно вы поставили первым знаком", "Error Message",
                JOptionPane.ERROR_MESSAGE);
    }
    public void errorRoot() {
        JOptionPane.showMessageDialog(input,
                "OШИБКА! корень из отрицательного числа ", "Error Message",
                JOptionPane.ERROR_MESSAGE);
    }
    public void errorNull() {
        JOptionPane.showMessageDialog(input,
                "OШИБКА! на ноль деление ", "Error Message",
                JOptionPane.ERROR_MESSAGE);
    }





    public double Calculate() {
        double result=0;
    switch (sign1){
        case '+':
        {
          result=oneNumber+twoNumber;
          break;
        }
        case '-':
        {
            result=oneNumber-twoNumber;
            break;
        }
        case '÷':
        {
             result=oneNumber/twoNumber;
            break;
        }
        case '×':
        {
            result=oneNumber*twoNumber;
            break;
        }
        case '^':
        {
            result=Math.pow(oneNumber,twoNumber);
            break;
        }
        case '√':
        {
            result=Math.sqrt(oneNumber);
            break;
        }
    }
    return result;
    }


    public SimpleGUI() throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
        super("Calculator");
        this.setBounds(100, 100, 311, 419);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = this.getContentPane();
        container.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        // дизайн
        Font font = new Font("Courier New", Font.TRUETYPE_FONT, 22);

        Color дляциферок = new Color(160, 185, 198);
        Color дляфункций = new Color(154, 152, 181);
        Color дляуправляющихкнопок = new Color(165, 248, 211);


        c.weightx = 1;
        c.weighty = 1;
        c.insets = new Insets(2, 0, 0, 2);
        c.fill = GridBagConstraints.BOTH;

        c.gridx = 0;
        c.gridy = 3;
        buttonReset.setBackground(дляуправляющихкнопок);
        buttonReset.setForeground(Color.WHITE);
        container.add(buttonReset, c);
        c.gridx = 1;
        c.gridy = 3;
        buttonDelete.setBackground(дляуправляющихкнопок);
        buttonDelete.setForeground(Color.WHITE);
        container.add(buttonDelete, c);

        c.gridx = 0;
        c.gridy = 7;
        buttonComma.setBackground(дляфункций);
        buttonComma.setForeground(Color.WHITE);
        container.add(buttonComma, c);
        c.gridx = 0;
        c.gridy = 6;
        button1.setBackground(дляциферок);
        button1.setForeground(Color.WHITE);
        container.add(button1, c);
        c.gridx = 1;
        c.gridy = 6;
        button2.setBackground(дляциферок);
        button2.setForeground(Color.WHITE);
        container.add(button2, c);
        c.gridx = 2;
        c.gridy = 6;
        button3.setBackground(дляциферок);
        button3.setForeground(Color.WHITE);
        container.add(button3, c);
        c.gridx = 0;
        c.gridy = 5;
        button4.setBackground(дляциферок);
        button4.setForeground(Color.WHITE);
        container.add(button4, c);
        c.gridx = 1;
        c.gridy = 5;
        button5.setBackground(дляциферок);
        button5.setForeground(Color.WHITE);
        container.add(button5, c);
        c.gridx = 2;
        c.gridy = 5;
        button6.setBackground(дляциферок);
        button6.setForeground(Color.WHITE);
        container.add(button6, c);
        c.gridx = 0;
        c.gridy = 4;
        button7.setBackground(дляциферок);
        button7.setForeground(Color.WHITE);
        container.add(button7, c);
        c.gridx = 1;
        c.gridy = 4;
        button8.setBackground(дляциферок);
        button8.setForeground(Color.WHITE);
        container.add(button8, c);
        c.gridx = 2;
        c.gridy = 4;
        button9.setBackground(дляциферок);
        button9.setForeground(Color.WHITE);
        container.add(button9, c);
        c.gridx = 1;
        c.gridy = 7;
        button0.setBackground(дляциферок);
        button0.setForeground(Color.WHITE);
        container.add(button0, c);
        c.gridx = 3;
        c.gridy = 6;
        buttonMin.setBackground(дляфункций);
        buttonMin.setForeground(Color.WHITE);
        container.add(buttonMin, c);
        c.gridx = 3;
        c.gridy = 7;
        buttonPlus.setBackground(дляфункций);
        buttonPlus.setForeground(Color.WHITE);
        container.add(buttonPlus, c);
        c.gridx = 2;
        c.gridy = 7;
        buttonEqu.setBackground(дляфункций);
        buttonEqu.setForeground(Color.WHITE);
        container.add(buttonEqu, c);
        c.gridx = 3;
        c.gridy = 5;
        buttonMul.setBackground(дляфункций);
        buttonMul.setForeground(Color.WHITE);
        container.add(buttonMul, c);
        c.gridx = 3;
        c.gridy = 4;
        buttonDiv.setBackground(дляфункций);
        buttonDiv.setForeground(Color.WHITE);
        container.add(buttonDiv, c);
        c.gridx = 3;
        c.gridy = 3;
        buttonPow.setBackground(дляфункций);
        buttonPow.setForeground(Color.WHITE);
        container.add(buttonPow, c);
        c.gridx = 2;
        c.gridy = 3;
        buttonRoot.setBackground(дляфункций);
        buttonRoot.setForeground(Color.WHITE);
        container.add(buttonRoot, c);
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 4;

        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 4;
        c.gridheight = 2;
        c.ipady = 40;
        container.add(input, c);
      input.setHorizontalAlignment(JTextField.RIGHT);//выравнивание по правому краю

        changeFont(container, font);//меняем шрифт у всех компонентов
        changeFont(buttonDelete, new Font("Courier", Font.TRUETYPE_FONT, 20));//это для кнопки стирать потому что она в том шрифте уродская
        //конец части дизайна


        ActionListener actionListener = new ButtonsEventListener();
        ActionListener actionListenerFunc = new ButtonFuncEventListener();
        ActionListener actionListenerDelete = new ButtonDeleteEventListener();
        ActionListener actionListenerReset = new ButtonResetEventListener();



        button1.addActionListener(actionListener);
        button2.addActionListener(actionListener);
        button3.addActionListener(actionListener);
        button4.addActionListener(actionListener);
        button5.addActionListener(actionListener);
        button6.addActionListener(actionListener);
        button7.addActionListener(actionListener);
        button8.addActionListener(actionListener);
        button9.addActionListener(actionListener);
        button0.addActionListener(actionListener);
        buttonPow.addActionListener(actionListenerFunc);
        buttonPlus.addActionListener(actionListenerFunc);
        buttonMul.addActionListener(actionListenerFunc);
        buttonMin.addActionListener(actionListenerFunc);
        buttonDiv.addActionListener(actionListenerFunc);
        buttonRoot.addActionListener(actionListenerFunc);

        buttonEqu.addActionListener(actionListenerFunc);
        buttonComma.addActionListener(actionListener);
        buttonDelete.addActionListener(actionListenerDelete);
        buttonReset.addActionListener(actionListenerReset);


        input.addKeyListener(new KeyAdapter() {

            public void keyPressed(KeyEvent e) {

                switch (e.getKeyChar()){
                    case '0':{
                        button0.doClick();
                        break;
                    }
                    case '1':{
                        button1.doClick();
                        break;
                    } case '2':{
                        button2.doClick();
                        break;
                    }
                    case '3':{
                        button3.doClick();
                        break;
                    }
                    case '4':{
                        button4.doClick();
                        break;
                    }
                    case '5':{
                        button5.doClick();
                        break;
                    }
                    case '6':{
                        button6.doClick();
                        break;
                    }
                    case '7':{
                        button7.doClick();
                        break;
                    }
                    case '8':{
                        button8.doClick();
                        break;
                    }
                    case '9':{
                        button9.doClick();
                        break;
                    }
                    case '-':{
                        buttonMin.doClick();
                        break;
                    }
                    case '+':{
                        buttonPlus.doClick();
                        break;
                    }
                    case '=':{
                        buttonEqu.doClick();
                        break;
                    }
                    case '/':{
                        buttonDiv.doClick();
                        break;
                    } case '^':{
                        buttonPow.doClick();
                        break;
                    }
                    case '*':{
                        buttonMul.doClick();
                        break;
                    }
                    case '.':{
                        buttonComma.doClick();
                        break;
                    }
                    case '√':{
                        buttonRoot.doClick();
                        break;
                    }



                }

            }
            public void keyTyped(KeyEvent e) {

                   e.consume();//Метод consume использует это событие, так что оно не будет обработано по умолчанию источником, который его создал .



            }

        });

    }

    class ButtonsEventListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            AbstractButton EventSource = (AbstractButton) e.getSource();
            if ((input.getText().contains("."))&&(EventSource.getText().equals("."))){
                errorDot();
                input.setText("");
            }
             else {
                if (!input.getText().equals("")) {
                    if (input.getText().equals("-")) input.getText();//
                    else if ((Double.parseDouble(input.getText()) == oneNumber) && (sign2 == '?')) input.setText("");
                }
                input.setText(input.getText() + EventSource.getText());
            }

        }
    }

    class ButtonFuncEventListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if((isLetters(input.getText()))||(input.getText().contains(".."))){
                errorDot();
                input.setText("");
            }

            AbstractButton EventSource = (AbstractButton) e.getSource();
            if(sign1=='?')  sign1=EventSource.getText().toCharArray()[0];


            if((EventSource.getText().equals(String.valueOf('-')))&&(input.getText().equals(""))){
               // signMin=true;
                input.setText("-");}
            else{
                if(Double.isNaN(oneNumber)) {

                    oneNumber= Double.parseDouble(input.getText());
                    sign1=EventSource.getText().toCharArray()[0];
                    input.setText("");
                    if(sign1=='=')errorEqu();
                    if(sign1=='√'){
                        if(oneNumber>=0){
                            oneNumber=Calculate();
                            input.setText(String.valueOf(oneNumber));
                        }
                        else{
                            errorRoot();
                            input.setText("");
                            signMin = false;
                            oneNumber = Double.NaN;
                            twoNumber = Double.NaN;
                        }
                    }

                }else {
                    if (Double.isNaN(twoNumber)) {
                        //input.setText("");
                        twoNumber = Double.parseDouble(input.getText());
                        sign2 = EventSource.getText().toCharArray()[0];
                         if (Double.isNaN(Calculate()))errorRoot();
                        if ((Calculate() == Double.NEGATIVE_INFINITY) || (Calculate() == Double.POSITIVE_INFINITY)) {
                            errorNull();
                            input.setText("");
                            signMin = false;
                            oneNumber = Double.NaN;
                            twoNumber = Double.NaN;
                        } else {
                            input.setText(String.valueOf(Calculate()));
                            oneNumber = Calculate();
                            if (sign2 == '=') sign1 = '?';
                            else {
                                sign1 = sign2;
                                sign2 = '?';
                                twoNumber = Double.NaN;
                            }

                        }
                    } else {
                        twoNumber = Double.NaN;
                       if(sign1=='√') {
                           if(oneNumber>=0) {
                               oneNumber = Calculate();
                               input.setText(String.valueOf(oneNumber));
                           }
                           else{
                               errorNull();///////////
                               input.setText("");
                               signMin = false;
                               oneNumber = Double.NaN;
                               twoNumber = Double.NaN;
                           }
                       } else input.setText("");
                    }
                }
            }


        }
    }

    class ButtonDeleteEventListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            if (!(input.getText().contains("")))
                input.setText(input.getText().substring(0, input.getText().length() - 1));


        }
    }

    class ButtonResetEventListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            input.setText("");
             signMin = false;
             oneNumber = Double.NaN;
             twoNumber = Double.NaN;
        }
    }










}


