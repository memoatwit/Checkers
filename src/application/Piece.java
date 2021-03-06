package application;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;

import static application.Board.SQUARE;

public class Piece extends StackPane implements Marker
{
	private PieceType type;
	
	public PieceType getTeam()
	{
		return type;
	}
	
	private double xPos, yPos;
	private double lastX, lastY;
	
	public double getX()
	{
		return xPos;
	}
	
	public double getY()
	{
		return yPos;
	}
	
	public double getLastX()
	{
		return lastX;
	}
	
	public double getLastY()
	{
		return lastY;
	}
	
	public Piece(PieceType type, int x, int y)
	{
		this.type = type;
		
		move(x, y);
		
		Ellipse ellipse = new Ellipse(45, 45);
		if (type == PieceType.RED) ellipse.setFill(Color.RED);
		else if (type == PieceType.BLACK) ellipse.setFill(Color.BLACK);
		else if (type == PieceType.REDKING) ellipse.setFill(Color.CRIMSON);
		else if (type == PieceType.BLACKKING) ellipse.setFill(Color.DARKSLATEGRAY);
		ellipse.setStroke(Color.BLACK);
		ellipse.setStrokeWidth(1);
		ellipse.setTranslateX(3);
		ellipse.setTranslateY(3);
		
		getChildren().add(ellipse);
		
		setOnMousePressed(e ->
		{
			xPos = e.getSceneX();
			yPos = e.getSceneY();
		});
			
		setOnMouseDragged(e ->
		{
			relocate(e.getSceneX()-30, e.getSceneY()-30);
		});
	}
	
	
	public void move(int x, int y)
	{
		lastX = x * SQUARE;
		lastY = y * SQUARE;
		
		relocate(lastX, lastY);
	}
	
	public void cancelMove()
	{
		relocate(lastX, lastY);
	}

	public void setTeam(PieceType p) {
		type = p;
	}

}