import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class UI extends Application {

    private Button start;
    private Button stop;
    private Label sourceLabel;
    private TextField source;

    public UI() {
        start = new Button("Iniciar");
        stop = new Button("Parar");
        sourceLabel = new Label("Origem");
        source = new TextField();
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        start.setOnAction(e -> {
            final Dialog dialog = new Dialog();
            dialog.setContentText("Botão Iniciar clicado!");
            dialog.show();
        });
        stop.setOnAction(e -> {
            final Dialog dialog = new Dialog();
            dialog.setContentText("Botão Para clicado!");
            dialog.show();
        });
        StackPane layout = new StackPane();
        layout.getChildren().add(0, sourceLabel);
        layout.getChildren().add(1, source);
        layout.getChildren().add(2, start);
        layout.getChildren().add(3, stop);
        //layout.getChildren().addAll(sourceLabel, source, start, stop);
        Scene scene = new Scene(layout);
        primaryStage.setScene(scene);
        primaryStage.setTitle("File Splitter");
        primaryStage.setMinHeight(400);
        primaryStage.setMinWidth(400);
        //primaryStage.sizeToScene();
        primaryStage.show();
    }
}