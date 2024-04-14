package com.example.fx_paper_rock;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.Random;

public class HelloController {

    Button player;
    Button cpu;
    int playerClicks = 0;
    int cpuClicks = 0;
    String cpuMove;
    Boolean isStartClicked = false;

    @FXML
    private Button btn1, btn2, btn3, btn4, btn5;

    @FXML
    private Label lbl1, lbl2, lbl3, lbl4;

    @FXML
    void start(ActionEvent event) {
       reset();

    }
    @FXML
    void clicks(ActionEvent event) {
        player = (Button) event.getSource();
        if( player.getId().equals("btn1") && playerClicks < 1 && isStartClicked ) {
            lbl1.setText("ROCK");
            playerClicks++;
            lbl4.setText("CPUs turn!");
        }else if (player.getId().equals("btn2") && playerClicks < 1 && isStartClicked){
            lbl1.setText("PAPER");
            playerClicks++;
            lbl4.setText("CPUs turn!");
        }else if (player.getId().equals("btn3") && playerClicks < 1 && isStartClicked){
            lbl1.setText("SCISSORS");
            playerClicks++;
            lbl4.setText("CPUs turn!");
        }check();
        if(!isStartClicked){
            lbl4.setText("PRESS START");
        }
    }

    @FXML
    void cpuClick(ActionEvent event) {

        try {

            cpu = (Button) event.getSource();
            String[] arr = {"btn1", "btn2", "btn3"};
            if (cpuClicks < 1 && isStartClicked && playerClicks == 1) {
                cpuMove = arr[new Random().nextInt(arr.length)];

                switch (cpuMove) {
                    case "btn1" -> {
                        lbl2.setText("ROCK");
                        cpuClicks++;
                        lbl4.setText("");
                    }
                    case "btn2" -> {
                        lbl2.setText("PAPER");
                        cpuClicks++;
                        lbl4.setText("");
                    }
                    case "btn3" -> {
                        lbl2.setText("SCISSORS");
                        cpuClicks++;
                        lbl4.setText("");
                    }
                }lbl4.setText("Play again!");
            }
            check();
            if(cpuClicks == 0) {
                lbl4.setText("Its Players turn!");
            }

        }catch (Exception e) {
            lbl4.setText("PRESS START");
        }

    }
    public void check(){
        if(lbl1.getText().equals("ROCK") && lbl2.getText().equals("PAPER")){
            lbl3.setText("CPU WON!");

        }else if (lbl1.getText().equals("ROCK") && lbl2.getText().equals("ROCK")) {
            lbl3.setText("ITS A TIE!");

        }else if (lbl1.getText().equals("ROCK") && lbl2.getText().equals("SCISSORS")) {
            lbl3.setText("YOU WON!");

        }else if (lbl1.getText().equals("PAPER") && lbl2.getText().equals("PAPER")) {
            lbl3.setText("ITS A TIE!");

        }else if (lbl1.getText().equals("SCISSORS") && lbl2.getText().equals("SCISSORS")) {
            lbl3.setText("ITS A TIE!");

        }else if (lbl1.getText().equals("PAPER") && lbl2.getText().equals("ROCK")) {
            lbl3.setText("YOU WIN!");
        }else if (lbl1.getText().equals("PAPER") && lbl2.getText().equals("SCISSORS")) {
            lbl3.setText("CPU WON!");
        }else if (lbl1.getText().equals("SCISSORS") && lbl2.getText().equals("PAPER")) {
            lbl3.setText("YOU WON!");
        }else if (lbl1.getText().equals("SCISSORS") && lbl2.getText().equals("ROCK")) {
            lbl3.setText("CPU WON!");
        }


    }
    public void reset(){
        isStartClicked = true;
        lbl1.setText("");
        lbl2.setText("");
        lbl3.setText("");
        lbl4.setText("GAME ON!!");
        playerClicks = 0;
        cpuClicks = 0;
    }




}//END