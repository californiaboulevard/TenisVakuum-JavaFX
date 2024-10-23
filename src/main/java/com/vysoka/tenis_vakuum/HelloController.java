package com.vysoka.tenis_vakuum;

import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.fxml.FXML;

import javax.lang.model.type.NullType;
import java.util.Arrays;

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
    private Button button = new Button();

    private static final double g = -9.81;
    private static int N = 500;

    private double dt = 0.001;
    private double vx = 35.0;
    private double vz = 0.0;
    private double m = 10.0;
    private static double[] xpole;
    private static double[] zpole;

    private double x = 0.0;
    private double z = 1.5;

    @FXML
    protected void action() {

        if (!textField3.getText().isEmpty()) {
            m = Double.parseDouble(textField3.getText());
        }
        if (!textField1.getText().isEmpty()) {
            dt = Double.parseDouble(textField1.getText());
        }
        if (!textField2.getText().isEmpty()) {
            N = Integer.parseInt(textField2.getText());
        }
        if (!textField4.getText().isEmpty()) {
            x = Double.parseDouble(textField4.getText());
        }
        if (!textField5.getText().isEmpty()) {
            z = Double.parseDouble(textField5.getText());
        }
        if (!textField6.getText().isEmpty()) {
            vx = Double.parseDouble(textField6.getText());
        }
        if (!textField7.getText().isEmpty()) {
            vz = Double.parseDouble(textField7.getText());
        }
        xpole = new double[N + 1];
        zpole = new double[N + 1];
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

        x = 0.0;
        z = 1.5;
        vx = 35.0;
        vz = 0.0;

        if (z == 0.0) {
            label3.setText("");
            label3.setText("lopticka sa dotkla zeme!");
        } else if (z < 0.0) {
            label3.setText("");
            label3.setText("lopticka uz presla zemou!");
        } else if (z > 0.0) {
            label3.setText("");
        }


    }

}
