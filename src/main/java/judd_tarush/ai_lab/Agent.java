/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package judd_tarush.ai_lab;

import java.awt.Point;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author braujudd
 * 
 */
public class Agent {
    private String name;
    private Map<String, Double> strategy;
    private Point position;
    private int stepsTaken;
    private int reinforcementValue;
    private Map<String, int> actionCounts;
    private static Random random = new Random(System.currentTimeMillis());
    
    public Agent(String name, Map<String, Double> strategy, Point initialState) {
        this.name = name;
        this.strategy = sumStrategies(strategy);
        this.position = new Point (initialState);
        this.stepsTaken = 0;
        this.reinforcementValue = 0;
        this.actionCounts = new HashMap<>();
    }
    
    private Map<String, Double> sumStrategies(Map<String, Double> input) {
        Map<String, Double> output = input;
        output.put("DOWN", output.get("DOWN") + output.get("UP"));
        output.put("LEFT", output.get("LEFT") + output.get("DOWN"));
        output.put("RIGHT", output.get("RIGHT") + output.get("LEFT"));
        output.put("STILL", output.get("STILL") + output.get("RIGHT"));

        return output;
    }
    
    public Point selectAction() {
        double check = random.nextDouble(1.0);
        
        if (check < this.strategy.get("UP")) {
            return new Point(0,1);
        } else if (check < this.strategy.get("DOWN")) {
            return new Point(0,-1);
        } else if (check < this.strategy.get("LEFT")) {
            return new Point(-1, 0);
        } else if (check < this.strategy.get("RIGHT")) {
            return new Point(1,0);
        } else {
            return new Point(0,0);
        }
    }
    
    public Point getNextMove() {
        Point action = this.selectAction();
        return new Point(action.x + this.position.x, action.y + this.position.y);
    }
   
    
    public String getName() {
        return this.name;
    }
    
    public Point getPosition() {
        return position.getLocation();
    }
    
    public void setPosition(Point p) {
        position = new Point(p);
    }
    
    public int getStepsTaken() {
        return stepsTaken;
    }
    
    public int getReinforcementValue() {
        return reinforcementValue;
    }
    
    public Map<String, int> getActionCounts() {
        return actionCounts;
        // Or just print it
    }
    
}

//class Coordinate {
//    private int x;
//    private int y;
//    private walls;
//    
//    public Coordinate(int x, int y) {
//        this.x = x;
//        this.y = y;
//    }
//    
//    public boolean equals(Coordinate point) {
//        return point.x == this.x && point.y == this.y;
//    }
//    
//    public int getX() {
//        return this.x;
//    }
//    
//    public int getY() {
//        return this.y;
//    }
//    
//    public void set(int x, int y) {
//        this.x += x;
//        this.y += y;
//    }
//    
//    
//}
