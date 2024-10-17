package com.vysoka.tenis_vakuum;

import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.fxml.FXML;

public class HelloController {
    @FXML
    private Label label3;
    @FXML
    private Label label1;
    @FXML
    private Label label2;


    @FXML
    private TextField textField1 = new TextField();
    @FXML
    private TextField textField2 = new TextField();
    @FXML
    private TextField textField3 = new TextField();
    @FXML
    private TextField textField4 = new TextField();
    @FXML
    private TextField textField5 = new TextField();
    @FXML
    private TextField textField6 = new TextField();
    @FXML
    private TextField textField7 = new TextField();
    @FXML
    private TextField textField8 = new TextField();
    @FXML
    private Button button = new Button();

    private static final double g = -9.81;
    private static int N;

    private double dt;
    private double vx;
    private double vz;
    private double m;
    private static double[] xpole;
    private static double[] zpole;


    private double x;
    private double z;

    @FXML
    protected void action() {

        m = Double.parseDouble(textField3.getText());
        N = Integer.parseInt(textField2.getText());
        x = Double.parseDouble(textField4.getText());
        z = Double.parseDouble(textField5.getText());
        z = Double.parseDouble(textField5.getText());
        dt = Double.parseDouble(textField1.getText());
        vx = Double.parseDouble(textField6.getText());
        vz = Double.parseDouble(textField7.getText());
        xpole = new double[N+1];
        zpole = new double[N+1];
        xpole[0] = x;
        zpole[0] = z;


        for (int i = 1; i <= N; i++) {

            xpole[i] = x + vx * dt;
            x = x + vx * dt;
            zpole[i] = z + vz * dt;
            z = z + vz * dt;
            vx = vx; // stays constant in this scenario
            vz = vz + g * dt;


        }
        label1.setText("" + xpole[N]);
        label2.setText("" + zpole[N]);


        if (z == 0.0) {
            label3.setText("");
            label3.setText("lopticka sa dotkla zeme!");
        } else if (z < 0.0) {
            label3.setText("");
            label3.setText("lopticka presla zemou");
        } else if (z > 0.0) {
            label3.setText("");
        }
    }
}
