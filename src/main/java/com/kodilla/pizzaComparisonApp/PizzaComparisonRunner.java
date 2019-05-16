package com.kodilla.pizzaComparisonApp;

import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

public class PizzaComparisonRunner extends Application {

    private Image imageBack = new Image("file:resources/Background.png");
    private Image buttonPizza = new Image("file:resources/Button.png");

    @Override
    public void start(Stage myStage) {
        myStage.setTitle("Pizza Value Comparison");
        myStage.setResizable(false);

        BackgroundSize backgroundSize = new BackgroundSize(100,100,
                true,true,true,true);
        BackgroundImage backgroundImage = new BackgroundImage(imageBack, BackgroundRepeat.REPEAT,
                BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);

        Text welcomeMessage = new Text("Pizza Value Comparison");
        welcomeMessage.setFont(Font.font("Helvetica", FontWeight.BOLD, 30));
        welcomeMessage.setFill(Color.WHITESMOKE);
        welcomeMessage.setStroke(Color.BLACK);
        welcomeMessage.setStrokeWidth(1);
        welcomeMessage.setLayoutY(50);

        Text pizza1Pizza2 = new Text("Pizza A            X            Pizza B");
        pizza1Pizza2.setFont(Font.font("Helvetica", FontWeight.BOLD, 25));
        pizza1Pizza2.setFill(Color.WHITESMOKE);
        pizza1Pizza2.setStroke(Color.BLACK);
        pizza1Pizza2.setStrokeWidth(1);

        GridPane rootNode = new GridPane();
        rootNode.setPadding(new Insets(5));
        rootNode.setHgap(5);
        rootNode.setVgap(5);
        rootNode.setAlignment(Pos.CENTER);

        Text diameter1 = new Text("Diameter");
        diameter1.setFont(Font.font("Helvetica", FontWeight.BOLD, 20));
        diameter1.setFill(Color.WHITESMOKE);
        diameter1.setStroke(Color.BLACK);
        diameter1.setStrokeWidth(1);
        rootNode.add(diameter1, 0 ,0);

        TextField diameter1Input = new TextField();
        diameter1Input.setMaxWidth(60);
        rootNode.add(diameter1Input, 1, 0);

        Text cm = new Text("cm");
        cm.setFont(Font.font("Helvetica", FontWeight.BOLD, 20));
        cm.setFill(Color.WHITESMOKE);
        cm.setStroke(Color.BLACK);
        cm.setStrokeWidth(1);
        rootNode.add(cm, 2, 0);

        Text blankText = new Text("        ");
        rootNode.add(blankText,3, 0);

        Text quantity1 = new Text("Quantity");
        quantity1.setFont(Font.font("Helvetica", FontWeight.BOLD, 20));
        quantity1.setFill(Color.WHITESMOKE);
        quantity1.setStroke(Color.BLACK);
        quantity1.setStrokeWidth(1);
        rootNode.add(quantity1, 0, 1);

        TextField quantity1Input = new TextField();
        quantity1Input.setMaxWidth(60);
        rootNode.add(quantity1Input, 1, 1);

        Text price1 = new Text("Price");
        price1.setFont(Font.font("Helvetica", FontWeight.BOLD, 20));
        price1.setFill(Color.WHITESMOKE);
        price1.setStroke(Color.BLACK);
        price1.setStrokeWidth(1);
        rootNode.add(price1, 0, 2);

        TextField price1Input = new TextField();
        price1Input.setMaxWidth(60);
        rootNode.add(price1Input, 1, 2);

        Text zl = new Text("zl");
        zl.setFont(Font.font("Helvetica", FontWeight.BOLD, 20));
        zl.setFill(Color.WHITESMOKE);
        zl.setStroke(Color.BLACK);
        zl.setStrokeWidth(1);
        rootNode.add(zl, 2, 2);

        Text diameter2 = new Text("Diameter");
        diameter2.setFont(Font.font("Helvetica", FontWeight.BOLD, 20));
        diameter2.setFill(Color.WHITESMOKE);
        diameter2.setStroke(Color.BLACK);
        diameter2.setStrokeWidth(1);
        rootNode.add(diameter2, 4, 0);

        TextField diameter2Input = new TextField();
        diameter2Input.setMaxWidth(60);
        rootNode.add(diameter2Input, 5, 0);

        Text cm2 = new Text("cm");
        cm2.setFont(Font.font("Helvetica", FontWeight.BOLD, 20));
        cm2.setFill(Color.WHITESMOKE);
        cm2.setStroke(Color.BLACK);
        cm2.setStrokeWidth(1);
        rootNode.add(cm2, 6, 0);

        Text quantity2 = new Text("Quantity");
        quantity2.setFont(Font.font("Helvetica", FontWeight.BOLD, 20));
        quantity2.setFill(Color.WHITESMOKE);
        quantity2.setStroke(Color.BLACK);
        quantity2.setStrokeWidth(1);
        rootNode.add(quantity2, 4, 1);

        TextField quantity2Input = new TextField();
        quantity2Input.setMaxWidth(60);
        rootNode.add(quantity2Input, 5, 1);

        Text price2 = new Text("Price");
        price2.setFont(Font.font("Helvetica", FontWeight.BOLD, 20));
        price2.setFill(Color.WHITESMOKE);
        price2.setStroke(Color.BLACK);
        price2.setStrokeWidth(1);
        rootNode.add(price2, 4, 2);

        TextField price2Input = new TextField();
        price2Input.setMaxWidth(60);
        rootNode.add(price2Input, 5, 2);

        Text zl2 = new Text("zl");
        zl2.setFont(Font.font("Helvetica", FontWeight.BOLD, 20));
        zl2.setFill(Color.WHITESMOKE);
        zl2.setStroke(Color.BLACK);
        zl2.setStrokeWidth(1);
        rootNode.add(zl2, 6, 2);

        Button button = new Button(null, new ImageView(buttonPizza));
        button.setStyle("-fx-background-color: transparent;");

        Text deal = new Text();
        Text result = new Text();

        button.setOnAction(e -> {
            PizzaComparisonLogic pc = new PizzaComparisonLogic();
            int diameter1pc = Integer.parseInt(diameter1Input.getText());
            int diameter2pc = Integer.parseInt(diameter2Input.getText());

            double price1pc = Double.parseDouble(price1Input.getText());
            double price2pc = Double.parseDouble(price2Input.getText());

            double quantity1pc = Double.parseDouble(quantity1Input.getText());
            double quantity2pc = Double.parseDouble(quantity2Input.getText());

            Pizza pizza1 = new Pizza(diameter1pc, price1pc);
            Pizza pizza2 = new Pizza(diameter2pc, price2pc);

            String finalDeal = pc.dealPizzas(pizza1, pizza2, quantity1pc, quantity2pc);

            String finalResult = pc.comparePizzas(pizza1, pizza2, quantity1pc, quantity2pc);

            deal.setText(finalDeal);
            deal.setFont(Font.font("Helvetica", FontWeight.BOLD, 30));
            deal.setFill(Color.WHITESMOKE);
            deal.setStroke(Color.BLACK);
            deal.setStrokeWidth(1);

            result.setText(finalResult);
            result.setFont(Font.font("Helvetica", FontWeight.BOLD, 20));
            result.setFill(Color.WHITESMOKE);
            result.setStroke(Color.BLACK);
            result.setStrokeWidth(1);
        });

        button.setOnMouseEntered(e -> {
            FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1), button);
            fadeTransition.setFromValue(1.0);
            fadeTransition.setToValue(0.2);
            fadeTransition.setCycleCount(Animation.INDEFINITE);
            fadeTransition.setAutoReverse(true);
            fadeTransition.play();

            button.setOnMouseExited(a -> {
                button.setOpacity(1);
                fadeTransition.stop();
            });
        });

        VBox vBox = new VBox();
        vBox.setBackground(new Background(backgroundImage));
        vBox.setPadding(new Insets(15,15, 15, 15));
        vBox.setSpacing(15);
        vBox.setAlignment(Pos.TOP_CENTER);
        vBox.getChildren().add(welcomeMessage);
        vBox.getChildren().add(pizza1Pizza2);
        vBox.getChildren().add(rootNode);
        vBox.getChildren().add(deal);
        vBox.getChildren().add(result);
        vBox.getChildren().add(button);

        Scene myScene = new Scene(vBox, 500, 500);
        myScene.fillProperty();

        myStage.setScene(myScene);
        myStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}