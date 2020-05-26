package game.javafx.controller;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.DurationFormatUtils;
import game.result.GameResult;
import game.result.GameResultDao;

import javax.inject.Inject;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;


import static game.state.Matrix.startMatrix;
import static game.state.Operation.*;

@Slf4j
public class GameController {

    @Inject
    private FXMLLoader fxmlLoader;

    @Inject
    private GameResultDao gameResultDao;

    private String playerName;
    private IntegerProperty steps = new SimpleIntegerProperty();
    private Instant startTime;
    private boolean solv = false;

    @FXML
    private Label stepsLabel;

    @FXML
    private Label stopWatchLabel;

    private Timeline stopWatchTimeline;

    @FXML
    private Button resetButton;

    @FXML
    private Button exitButton;

    @FXML
    private Label label0;
    @FXML
    private Label label1;
    @FXML
    private Label label2;
    @FXML
    private Label label3;
    @FXML
    private Label label4;
    @FXML
    private Label label5;
    @FXML
    private Label label6;
    @FXML
    private Label label7;
    @FXML
    private Label label8;
    @FXML
    private Label label9;
    @FXML
    private Label label10;
    @FXML
    private Label label11;
    @FXML
    private Label label12;
    @FXML
    private Label label13;
    @FXML
    private Label label14;
    @FXML
    private Label label15;

    @FXML
    public BorderPane rootPane;


    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }


    public int actualMatrix[][] = startMatrix(4,4);

    ArrayList<Label> labels=new ArrayList<>();

    private void labelhozzadas(){
        for(int i=0;i<16;i++){
            labels.add(label0);
            labels.add(label1);
            labels.add(label2);
            labels.add(label3);
            labels.add(label4);
            labels.add(label5);
            labels.add(label6);
            labels.add(label7);
            labels.add(label8);
            labels.add(label9);
            labels.add(label10);
            labels.add(label11);
            labels.add(label12);
            labels.add(label13);
            labels.add(label14);
            labels.add(label15);
        }
    }

    private void konfiguracio() throws IOException {
        label0.setText("" + actualMatrix[0][0] + "");
        label1.setText("" + actualMatrix[0][1] + "");
        label2.setText("" + actualMatrix[0][2] + "");
        label3.setText("" + actualMatrix[0][3] + "");
        label4.setText("" + actualMatrix[1][0] + "");
        label5.setText("" + actualMatrix[1][1] + "");
        label6.setText("" + actualMatrix[1][2] + "");
        label7.setText("" + actualMatrix[1][3] + "");
        label8.setText("" + actualMatrix[2][0] + "");
        label9.setText("" + actualMatrix[2][1] + "");
        label10.setText("" + actualMatrix[2][2] + "");
        label11.setText("" + actualMatrix[2][3] + "");
        label12.setText("" + actualMatrix[3][0] + "");
        label13.setText("" + actualMatrix[3][1] + "");
        label14.setText("" + actualMatrix[3][2] + "");
        label15.setText("" + actualMatrix[3][3] + "");
        labelhatter();
        gameOver();
    }

    private void labelhatter() {
        for(int i=0;i<16;i++){
            if(null == labels.get(i).getText()){
                labels.get(i).setStyle("-fx-background-color: #ffffff");
            }else switch (labels.get(i).getText()) {
                case "2":
                    labels.get(i).setStyle("-fx-background-color: #635a57 ");
                    break;
                case "4":
                    labels.get(i).setStyle("-fx-background-color: #ad423d");
                    break;
                case "8":
                    labels.get(i).setStyle("-fx-background-color: #800f00");
                    break;
                case "16":
                    labels.get(i).setStyle("-fx-background-color:  #ff0000 ");
                    break;
                case "32":
                    labels.get(i).setStyle("-fx-background-color: #717d29 ");
                    break;
                case "64":
                    labels.get(i).setStyle("-fx-background-color:  #928707 ");
                    break;
                case "128":
                    labels.get(i).setStyle("-fx-background-color: #ffc200 ");
                    break;
                case "256":
                    labels.get(i).setStyle("-fx-background-color: #3aaf21 ");
                    break;
                case "512":
                    labels.get(i).setStyle("-fx-background-color: #174002");
                    break;
                case "1024":
                    labels.get(i).setStyle("-fx-background-color: #2444c1 ");
                    break;
                case "2048":
                    labels.get(i).setStyle("-fx-background-color: #00066f");
                    break;
                default:
                    labels.get(i).setStyle("-fx-background-color: #ffffff");
                    break;
            }
        }
    }

    @FXML
    private void fel() throws IOException{
        felhiv(actualMatrix);
        konfiguracio();
        steps.set(steps.get() + 1);
    }

    @FXML
    private void le() throws IOException{
        lehiv(actualMatrix);
        konfiguracio();
        steps.set(steps.get() + 1);

    }

    @FXML
    private void balra() throws IOException{
        balrahiv(actualMatrix);
        konfiguracio();
        steps.set(steps.get() + 1);
    }

    @FXML
    private void jobbra() throws IOException{
        jobbrahiv(actualMatrix);
        konfiguracio();
        steps.set(steps.get() + 1);
    }

    @FXML
    private void gameOver() throws IOException{
        for(int i=0;i<16;i++){
            if(labels.get(i).getText().equals("16")){
                solv = true;
                log.info("Game Over");
                log.info("You Win");
                log.debug("Saving result to database...");
                gameResultDao.persist(createGameResult());
                fxmlLoader.setLocation(getClass().getResource("/fxml/highscore.fxml"));
                Parent root = fxmlLoader.load();
                rootPane.getChildren().setAll(root);
            }
        }

        if(endLeft==true && endRight==true && endBottom==true && endTop==true){
            solv = false;
            log.info("Game Over");
            log.info("You Lose");
            fxmlLoader.setLocation(getClass().getResource("/fxml/highscore.fxml"));
            Parent root = fxmlLoader.load();
            rootPane.getChildren().setAll(root);
        }
    }

    @FXML
    public void initialize() throws IOException{
        labelhozzadas();
        konfiguracio();
        stepsLabel.textProperty().bind(steps.asString());
        resetGame();
    }


    @FXML
    private void resetGame() throws IOException{
        actualMatrix = startMatrix(4,4);
        steps.set(0);
        startTime = Instant.now();
        konfiguracio();
        createStopWatch();
    }

    public void handleResetButton(ActionEvent actionEvent) throws IOException {
        log.debug("{} is pressed", ((Button) actionEvent.getSource()).getText());
        log.info("Resetting game...");
        stopWatchTimeline.stop();
        resetGame();
    }

    public void handleExitButton(ActionEvent actionEvent) throws IOException {
        String buttonText = ((Button) actionEvent.getSource()).getText();
        log.debug("{} is pressed", buttonText);
        log.info("Exiting game...");
        Platform.exit();
    }

    private GameResult createGameResult() {
        GameResult result = GameResult.builder()
                .player(playerName)
                .solved(solv)
                .duration(Duration.between(startTime, Instant.now()))
                .steps(steps.get())
                .build();
        return result;
    }


    private void createStopWatch() {
        stopWatchTimeline = new Timeline(new KeyFrame(javafx.util.Duration.ZERO, e -> {
            long millisElapsed = startTime.until(Instant.now(), ChronoUnit.MILLIS);
            stopWatchLabel.setText(DurationFormatUtils.formatDuration(millisElapsed, "HH:mm:ss"));
        }), new KeyFrame(javafx.util.Duration.seconds(1)));
        stopWatchTimeline.setCycleCount(Animation.INDEFINITE);
        stopWatchTimeline.play();
    }




}
