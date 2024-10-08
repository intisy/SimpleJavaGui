package io.github.intisy.gui.javafx.presets;

import io.github.intisy.gui.javafx.Container;
import io.github.intisy.gui.javafx.SimpleSVGButton;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

import javax.swing.*;
import java.awt.*;

public class Title extends Container {
    int iconSize = 10;
    public Title(Frame frame, double width, double height) {
        super(width, height);
        double sizeMultiplier = height / 40;
        final Point[] clickPoint = new Point[1];
        setOnMousePressed(event -> clickPoint[0] = new Point((int) event.getX(), (int) event.getY()));
        setOnMouseDragged((event) -> {
            int xOffset = (int) (frame.getLocation().x - clickPoint[0].x + event.getX());
            int yOffset = (int) (frame.getLocation().y - clickPoint[0].y + event.getY());
            frame.setLocation(xOffset, yOffset);
        });
        Group closeShape = new Group(
                new Line(0, 0, iconSize, iconSize),
                new Line(0, iconSize, iconSize, 0)
        );
        closeShape.setLayoutX((50 * sizeMultiplier - iconSize) / 2);
        closeShape.setLayoutY((40 * sizeMultiplier - iconSize) / 2);
        closeShape.getChildren().forEach(line -> ((Line) line).setStroke(Color.WHITE));
        SimpleSVGButton jfxCloseButton = new SimpleSVGButton(closeShape, 50*sizeMultiplier, 40*sizeMultiplier);
        jfxCloseButton.setBackgroundColor(Color.rgb(201,79,79));
        jfxCloseButton.setOnAction(actionEvent -> frame.dispose());
        Line minimizeShape = new Line(0, 0, iconSize, 0);
        minimizeShape.setLayoutX((50 * sizeMultiplier - iconSize) / 2);
        minimizeShape.setLayoutY(40 * sizeMultiplier / 2);
        minimizeShape.setStroke(Color.WHITE);
        minimizeShape.setStrokeWidth(1.5);
        SimpleSVGButton jfxMinimizeButton = new SimpleSVGButton(minimizeShape, 50*sizeMultiplier, 40*sizeMultiplier);
        jfxMinimizeButton.setBackgroundColor(Color.rgb(72,75,77));
        jfxMinimizeButton.setOnAction(actionEvent -> frame.setState(JFrame.ICONIFIED));
        getChildren().addAll(jfxMinimizeButton, jfxCloseButton);
        addOnResize((SizeInterface) (w, h) -> {
            jfxCloseButton.setLayoutX((w - 50 * sizeMultiplier));
            jfxMinimizeButton.setLayoutX((w - 100 * sizeMultiplier));
        });
        callOnResize(width, height);
        setColor(Color.rgb(60,63,65));
    }
}
