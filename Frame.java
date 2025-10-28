import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class QuizFrame extends JFrame implements ActionListener {
    ArrayList<Question> questions;
    int index = 0, score = 0;
    JLabel qLabel;
    JRadioButton opt1, opt2, opt3, opt4;
    ButtonGroup bg;
    JButton nextBtn;

    public QuizFrame(ArrayList<Question> qList) {
        questions = qList;
        setTitle("Quiz Application");
        setSize(500, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 1));

        qLabel = new JLabel("", JLabel.CENTER);
        add(qLabel);
        opt1 = new JRadioButton(); opt2 = new JRadioButton();
        opt3 = new JRadioButton(); opt4 = new JRadioButton();
        bg = new ButtonGroup();
        bg.add(opt1); bg.add(opt2); bg.add(opt3); bg.add(opt4);
        add(opt1); add(opt2); add(opt3); add(opt4);

        nextBtn = new JButton("Next");
        nextBtn.addActionListener(this);
        add(nextBtn);

        loadQuestion();
        setVisible(true);
    }

    void loadQuestion() {
        if (index < questions.size()) {
            Question q = questions.get(index);
            qLabel.setText("Q" + (index + 1) + ": " + q.question);
            opt1.setText(q.option1);
            opt2.setText(q.option2);
            opt3.setText(q.option3);
            opt4.setText(q.option4);
            bg.clearSelection();
        } else {
            dispose();
            new ResultFrame(score, questions.size());
        }
    }

    public void actionPerformed(ActionEvent e) {
        Question q = questions.get(index);
        String selected = null;
        if (opt1.isSelected()) selected = opt1.getText();
        else if (opt2.isSelected()) selected = opt2.getText();
        else if (opt3.isSelected()) selected = opt3.getText();
        else if (opt4.isSelected()) selected = opt4.getText();

        if (selected != null && selected.equals(q.correct)) score++;
        index++;
        loadQuestion();
    }
}
