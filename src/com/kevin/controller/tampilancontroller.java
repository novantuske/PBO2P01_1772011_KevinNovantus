package com.kevin.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.text.DecimalFormat;

public class tampilancontroller {
    public TextField textLength;
    public TextField textWidth;
    public TextField textRadius;
    public TextField textHeight;

    public void squareClicked(ActionEvent actionEvent) {
        textLength.setDisable(false);
        textWidth.setDisable(false);
        textRadius.setDisable(true);
        textHeight.setDisable(true);
    }

    public void ballClicked(ActionEvent actionEvent) {
        textLength.setDisable(true);
        textWidth.setDisable(true);
        textRadius.setDisable(false);
        textHeight.setDisable(true);
    }

    public void tubeClicked(ActionEvent actionEvent) {
        textLength.setDisable(true);
        textWidth.setDisable(true);
        textRadius.setDisable(false);
        textHeight.setDisable(false);
    }

    public void subClicked(ActionEvent actionEvent) {
        try {
            if (!textLength.isDisable() && !textWidth.isDisable()) {
                int w, l;
                w = Integer.valueOf(textWidth.getText());
                l = Integer.valueOf(textLength.getText());

                int luas, kel;
                luas = w * l;
                kel = 2 * (w + l);

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Square");

                alert.setContentText("Area : " + luas + ", Circumference : " + kel);
                alert.show();
            }

            else if (!textRadius.isDisable() && !textHeight.isDisable()) {
                double r, h;
                DecimalFormat df = new DecimalFormat("#.##");

                r = Integer.valueOf(textRadius.getText());
                h = Integer.valueOf(textHeight.getText());

                double luas, vol;
                luas = 2 * Math.PI * r * (r+h);
                vol = Math.PI * Math.pow(r,2) * h;

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Tube");

                alert.setContentText("Surface Area : " + df.format(luas) + ", Volume : " + df.format(vol));
                alert.show();
            }

            else if (!textRadius.isDisable()) {
                double r;
                DecimalFormat df = new DecimalFormat("#.##");

                r = Integer.valueOf(textRadius.getText());

                double luas, vol;
                luas = 4 * Math.PI * Math.pow(r,2);
                vol =  1.33 * Math.PI * Math.pow(r,3);

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Ball");

                alert.setContentText("Surface Area : " + df.format(luas) + ", Volume : " + df.format(vol));
                alert.show();
            }

        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("Tidak ada data");
            alert.show();
        }


    }
}
