package ui;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.chart.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class Controller {

    @FXML
    private GridPane gridPane;
    @FXML
    private Pane pane;


    public Controller(){
    }

    public void initialize(){
        pieChart();
        lineChart();
        areaChart();
        bubbleChart();
        scatterChart();
        barChart();
    }

    @FXML
    public void pieChart(){
        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                        new PieChart.Data("Grapefruit", 13),
                        new PieChart.Data("Oranges", 25),
                        new PieChart.Data("Plums", 10),
                        new PieChart.Data("Pears", 22),
                        new PieChart.Data("Apples", 30));
        final PieChart chart = new PieChart(pieChartData);
        chart.setTitle("Imported Fruits");
        final Label caption = new Label("");
        caption.setTextFill(Color.BLACK);
        caption.setStyle("-fx-font: 24 arial;");
        pane.getChildren().add(caption);
        for (final PieChart.Data data : chart.getData()) {
            data.getNode().addEventHandler(MouseEvent.MOUSE_PRESSED,
                    (EventHandler<MouseEvent>) e -> {
                        caption.setTranslateX(e.getSceneX());
                        caption.setTranslateY(e.getSceneY());
                        caption.setText(String.valueOf(data.getPieValue()) + "%");
                    });
        }
        gridPane.add(chart,0,0);
    }

    @FXML
    public void lineChart(){
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Month");
        final LineChart<String,Number> lineChart =
                new LineChart<String,Number>(xAxis,yAxis);
        lineChart.setTitle("Stock Monitoring, 2010");
        XYChart.Series series1 = new XYChart.Series();
        series1.setName("Portfolio 1");
        series1.getData().add(new XYChart.Data("Jan", 23));
        series1.getData().add(new XYChart.Data("Feb", 14));
        series1.getData().add(new XYChart.Data("Mar", 15));
        series1.getData().add(new XYChart.Data("Apr", 24));
        series1.getData().add(new XYChart.Data("May", 34));
        series1.getData().add(new XYChart.Data("Jun", 36));
        series1.getData().add(new XYChart.Data("Jul", 22));
        series1.getData().add(new XYChart.Data("Aug", 45));
        series1.getData().add(new XYChart.Data("Sep", 43));
        series1.getData().add(new XYChart.Data("Oct", 17));
        series1.getData().add(new XYChart.Data("Nov", 29));
        series1.getData().add(new XYChart.Data("Dec", 25));
        XYChart.Series series2 = new XYChart.Series();
        series2.setName("Portfolio 2");
        series2.getData().add(new XYChart.Data("Jan", 33));
        series2.getData().add(new XYChart.Data("Feb", 34));
        series2.getData().add(new XYChart.Data("Mar", 25));
        series2.getData().add(new XYChart.Data("Apr", 44));
        series2.getData().add(new XYChart.Data("May", 39));
        series2.getData().add(new XYChart.Data("Jun", 16));
        series2.getData().add(new XYChart.Data("Jul", 55));
        series2.getData().add(new XYChart.Data("Aug", 54));
        series2.getData().add(new XYChart.Data("Sep", 48));
        series2.getData().add(new XYChart.Data("Oct", 27));
        series2.getData().add(new XYChart.Data("Nov", 37));
        series2.getData().add(new XYChart.Data("Dec", 29));
        XYChart.Series series3 = new XYChart.Series();
        series3.setName("Portfolio 3");
        series3.getData().add(new XYChart.Data("Jan", 44));
        series3.getData().add(new XYChart.Data("Feb", 35));
        series3.getData().add(new XYChart.Data("Mar", 36));
        series3.getData().add(new XYChart.Data("Apr", 33));
        series3.getData().add(new XYChart.Data("May", 31));
        series3.getData().add(new XYChart.Data("Jun", 26));
        series3.getData().add(new XYChart.Data("Jul", 22));
        series3.getData().add(new XYChart.Data("Aug", 25));
        series3.getData().add(new XYChart.Data("Sep", 43));
        series3.getData().add(new XYChart.Data("Oct", 44));
        series3.getData().add(new XYChart.Data("Nov", 45));
        series3.getData().add(new XYChart.Data("Dec", 44));
        lineChart.getData().addAll(series1, series2, series3);
        gridPane.add(lineChart,1,0);
    }

    @FXML
    public void areaChart(){
        final NumberAxis xAxis = new NumberAxis(1, 31, 1);
        xAxis.setMinorTickCount(0);
        final NumberAxis yAxis = new NumberAxis(-5, 27, 5);
        yAxis.setMinorTickLength(yAxis.getTickLength());
        yAxis.setForceZeroInRange(false);

        final AreaChart<Number,Number> ac =
                new AreaChart<Number,Number>(xAxis,yAxis);
        ac.setTitle("Temperature Monitoring (in Degrees C)");

        XYChart.Series seriesApril= new XYChart.Series();
        seriesApril.setName("April");
        seriesApril.getData().add(new XYChart.Data(0, 4));
        seriesApril.getData().add(new XYChart.Data(3, 10));
        seriesApril.getData().add(new XYChart.Data(6, 15));
        seriesApril.getData().add(new XYChart.Data(9, 8));
        seriesApril.getData().add(new XYChart.Data(12, 5));
        seriesApril.getData().add(new XYChart.Data(15, 18));
        seriesApril.getData().add(new XYChart.Data(18, 15));
        seriesApril.getData().add(new XYChart.Data(21, 13));
        seriesApril.getData().add(new XYChart.Data(24, 19));
        seriesApril.getData().add(new XYChart.Data(27, 21));
        seriesApril.getData().add(new XYChart.Data(30, 21));

        XYChart.Series seriesMay = new XYChart.Series();
        seriesMay.setName("May");
        seriesMay.getData().add(new XYChart.Data(0, 20));
        seriesMay.getData().add(new XYChart.Data(3, 15));
        seriesMay.getData().add(new XYChart.Data(6, 13));
        seriesMay.getData().add(new XYChart.Data(9, 12));
        seriesMay.getData().add(new XYChart.Data(12, 14));
        seriesMay.getData().add(new XYChart.Data(15, 18));
        seriesMay.getData().add(new XYChart.Data(18, 25));
        seriesMay.getData().add(new XYChart.Data(21, 25));
        seriesMay.getData().add(new XYChart.Data(24, 23));
        seriesMay.getData().add(new XYChart.Data(27, 26));
        seriesMay.getData().add(new XYChart.Data(31, 26));

        XYChart.Series seriesMarch = new XYChart.Series();
        seriesMarch.setName("March");
        seriesMarch.getData().add(new XYChart.Data(0, -2));
        seriesMarch.getData().add(new XYChart.Data(3, -4));
        seriesMarch.getData().add(new XYChart.Data(6, 0));
        seriesMarch.getData().add(new XYChart.Data(9, 5));
        seriesMarch.getData().add(new XYChart.Data(12, -4));
        seriesMarch.getData().add(new XYChart.Data(15, 6));
        seriesMarch.getData().add(new XYChart.Data(18, 8));
        seriesMarch.getData().add(new XYChart.Data(21, 14));
        seriesMarch.getData().add(new XYChart.Data(24, 4));
        seriesMarch.getData().add(new XYChart.Data(27, 6));
        seriesMarch.getData().add(new XYChart.Data(31, 6));
        ac.getData().addAll(seriesMarch, seriesApril, seriesMay);
        gridPane.add(ac,2,0);
    }

    @FXML
    public void bubbleChart(){

        final NumberAxis xAxis = new NumberAxis(1, 53, 4);
        final NumberAxis yAxis = new NumberAxis(0, 80, 10);
        final BubbleChart<Number,Number> blc = new
                BubbleChart<>(xAxis,yAxis);
        xAxis.setLabel("Week");
        yAxis.setLabel("Product Budget");
        blc.setTitle("Budget Monitoring");
        yAxis.setTickLabelFormatter(new NumberAxis.DefaultFormatter(yAxis,"$ ",null));
        XYChart.Series series1 = new XYChart.Series();
        series1.setName("Product 1");
        series1.getData().add(new XYChart.Data(3, 35, 2));
        series1.getData().add(new XYChart.Data(12, 60, 1.8));
        series1.getData().add(new XYChart.Data(15, 15, 7));
        series1.getData().add(new XYChart.Data(22, 30, 2.5));
        series1.getData().add(new XYChart.Data(28, 20, 1));
        series1.getData().add(new XYChart.Data(35, 41, 5.5));
        series1.getData().add(new XYChart.Data(42, 17, 9));
        series1.getData().add(new XYChart.Data(49, 30, 1.8));

        XYChart.Series series2 = new XYChart.Series();
        series2.setName("Product 2");
        series2.getData().add(new XYChart.Data(8, 15, 2));
        series2.getData().add(new XYChart.Data(13, 23, 1));
        series2.getData().add(new XYChart.Data(15, 45, 3));
        series2.getData().add(new XYChart.Data(24, 30, 4.5));
        series2.getData().add(new XYChart.Data(38, 78, 1));
        series2.getData().add(new XYChart.Data(40, 41, 7.5));
        series2.getData().add(new XYChart.Data(45, 57, 2));
        series2.getData().add(new XYChart.Data(47, 23, 3.8));
        xAxis.setTickLabelFill(Color.CHOCOLATE);
        yAxis.setTickLabelFill(Color.CHOCOLATE);
        blc.getData().addAll(series1, series2);
        gridPane.add(blc,0,1);
    }

    @FXML
    public void scatterChart(){
        final NumberAxis xAxis = new NumberAxis(0, 10, 1);
        final NumberAxis yAxis = new NumberAxis(-100, 500, 100);
        final ScatterChart<Number,Number> sc =
                new ScatterChart<>(xAxis,yAxis);
        xAxis.setLabel("Age (years)");
        yAxis.setLabel("Returns to date");
        sc.setTitle("Investment Overview");
        final DropShadow shadow = new DropShadow();
        shadow.setOffsetX(2);
        shadow.setColor(Color.GREY);
        sc.setEffect(shadow);
        XYChart.Series series1 = new XYChart.Series();
        series1.setName("Option 1");
        series1.getData().add(new XYChart.Data(4.2, 193.2));
        series1.getData().add(new XYChart.Data(2.8, 33.6));
        series1.getData().add(new XYChart.Data(6.2, 24.8));
        series1.getData().add(new XYChart.Data(1, 14));
        series1.getData().add(new XYChart.Data(1.2, 26.4));
        series1.getData().add(new XYChart.Data(4.4, 114.4));
        series1.getData().add(new XYChart.Data(8.5, 323));
        series1.getData().add(new XYChart.Data(6.9, 289.8));
        series1.getData().add(new XYChart.Data(9.9, 287.1));
        series1.getData().add(new XYChart.Data(0.9, -9));
        series1.getData().add(new XYChart.Data(3.2, 150.8));
        series1.getData().add(new XYChart.Data(4.8, 20.8));
        series1.getData().add(new XYChart.Data(7.3, -42.3));
        series1.getData().add(new XYChart.Data(1.8, 81.4));
        series1.getData().add(new XYChart.Data(7.3, 110.3));
        series1.getData().add(new XYChart.Data(2.7, 41.2));

        sc.setPrefSize(500, 400);
        sc.getData().addAll(series1);
        final VBox vbox = new VBox();
        final HBox hbox = new HBox();
        final Button add = new Button("Add Series");
        add.setOnAction((ActionEvent e) -> {
            if (sc.getData() == null) {
                sc.setData(FXCollections.<XYChart.Series<Number,
                        Number>>observableArrayList());
            }
            ScatterChart.Series<Number, Number> series
                    = new ScatterChart.Series<>();
            series.setName("Option " + (sc.getData().size() + 1));
            for (int i = 0; i < 100; i++) {
                series.getData().add(
                        new ScatterChart.Data<>(Math.random() * 100,
                                Math.random() * 500));
            }
            sc.getData().add(series);
        });
        final Button remove = new Button("Remove Series");
        remove.setOnAction((ActionEvent e) -> {
            if (!sc.getData().isEmpty())
                sc.getData().remove((int)(
                        Math.random()*(sc.getData().size()-1)));
        });
        hbox.setSpacing(10);
        hbox.getChildren().addAll(add, remove);
        vbox.getChildren().addAll(sc, hbox);
        hbox.setPadding(new Insets(10, 10, 10, 50));
        gridPane.add(vbox,1,1);
    }

    @FXML
    public void barChart(){
        final String austria = "Austria";
        final String brazil = "Brazil";
        final String france = "France";
        final String italy = "Italy";
        final String usa = "USA";
        final NumberAxis xAxis = new NumberAxis();
        final CategoryAxis yAxis = new CategoryAxis();
        final BarChart<Number,String> bc =
                new BarChart<>(xAxis,yAxis);
        bc.setTitle("Country Summary");
        xAxis.setLabel("Value");
        xAxis.setTickLabelRotation(90);
        yAxis.setLabel("Country");
        XYChart.Series series1 = new XYChart.Series();
        series1.setName("2003");
        series1.getData().add(new XYChart.Data(25601.34, austria));
        series1.getData().add(new XYChart.Data(20148.82, brazil));
        series1.getData().add(new XYChart.Data(10000, france));
        series1.getData().add(new XYChart.Data(35407.15, italy));
        series1.getData().add(new XYChart.Data(12000, usa));

        XYChart.Series series2 = new XYChart.Series();
        series2.setName("2004");
        series2.getData().add(new XYChart.Data(57401.85, austria));
        series2.getData().add(new XYChart.Data(41941.19, brazil));
        series2.getData().add(new XYChart.Data(45263.37, france));
        series2.getData().add(new XYChart.Data(117320.16, italy));
        series2.getData().add(new XYChart.Data(14845.27, usa));

        XYChart.Series series3 = new XYChart.Series();
        series3.setName("2005");
        series3.getData().add(new XYChart.Data(45000.65, austria));
        series3.getData().add(new XYChart.Data(44835.76, brazil));
        series3.getData().add(new XYChart.Data(18722.18, france));
        series3.getData().add(new XYChart.Data(17557.31, italy));
        series3.getData().add(new XYChart.Data(92633.68, usa));
        bc.getData().addAll(series1, series2, series3);
        Timeline tl = new Timeline();
        tl.getKeyFrames().add(new KeyFrame(Duration.millis(500),
                (ActionEvent actionEvent) -> {
                    bc.getData().stream().forEach((series) -> {
                        series.getData().stream().forEach((data) -> {
                            data.setXValue(Math.random() * 1000);
                        });
                    });
                }
        ));
        tl.setCycleCount(Animation.INDEFINITE);
        tl.setAutoReverse(true);
        tl.play();
        gridPane.add(bc,2,1);

    }







}
