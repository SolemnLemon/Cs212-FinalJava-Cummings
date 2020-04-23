package hellofx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import liststacktemplate.MyStack;

public class Controller {

    @FXML
    private Label label;

    @FXML
    private Button btnClickMe;

  @FXML
    private Label lblEquation;

    @FXML
    private TextField txtField;

    @FXML
    void clicked(ActionEvent event) {

        String s = txtField.getText();
        System.out.println(s);
        Calculator equation = new Calculator();
      
lblEquation.setText(equation.calculate(s));
    }

    private int counter = 0;

    public void initialize() {
        String javaVersion = System.getProperty("java.version");
        String javafxVersion = System.getProperty("javafx.version");
      
    }
}
