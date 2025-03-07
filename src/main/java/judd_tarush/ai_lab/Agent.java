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
    private Map<String, Integer> actionCounts;
    private Point initialState;
    private String nextMoveName;
    private Point nextMove;
   
    
    private static Random random = new Random(System.currentTimeMillis());
    
    static Map<String, Point> movesMap = Map.of("UP", new Point(0,-1),
            "DOWN", new Point(0,1),
            "LEFT", new Point(-1,0),
            "RIGHT", new Point(1,0),
            "STILL", new Point(0,0));
    
    public Agent(String name, Map<String, Double> strategy, Point initialState) {
        this.name = name;
        this.strategy = sumStrategies(strategy);
        this.initialState = initialState;
        this.reset();
    }
    
    private static Map<String, Double> sumStrategies(Map<String, Double> input) {
        
        System.out.println(input);
        Map<String, Double> output = new HashMap<>();
        
        output.put("UP", input.get("UP"));
        output.put("DOWN", input.get("DOWN") + output.get("UP"));
        output.put("LEFT", input.get("LEFT") + output.get("DOWN"));
        output.put("RIGHT", input.get("RIGHT") + output.get("LEFT"));
        output.put("STILL", input.get("STILL") + output.get("RIGHT"));

        return output;
    }
    
    public void reset() {
        this.position = new Point(initialState);
        this.stepsTaken = 0;
        this.reinforcementValue = 0;
        this.actionCounts = new HashMap<>(Map.of("UP", 0, "DOWN", 0, "LEFT", 0, "RIGHT", 0, "STILL", 0));
        this.nextMoveName = "";
    }
    
    public void resetNextMove() {
        this.nextMove = null;
        this.nextMoveName = "";
    }
    
    public void selectAction() {
        double check = random.nextDouble(1.0);
        
        if (check < this.strategy.get("UP")) {
            this.nextMoveName = "UP";
        } else if (check < this.strategy.get("DOWN")) {
            this.nextMoveName = "DOWN";
        } else if (check < this.strategy.get("LEFT")) {
            this.nextMoveName = "LEFT";
        } else if (check < this.strategy.get("RIGHT")) {
            this.nextMoveName = "RIGHT";
        } else {
            this.nextMoveName = "STILL";
        }
        
        this.setNextMove();
    }
    
    public Point getNextMove() {
        return this.nextMove;
    }
    
    public void setNextMove() {
        Point direction = movesMap.get(this.nextMoveName);
        this.nextMove = new Point(direction.x + this.position.x, direction.y + this.position.y);
    }
    
    public void move(boolean goodMove) {
        this.stepsTaken++;
        
        if (goodMove) {
            // good robot
            this.actionCounts.put(this.nextMoveName, this.actionCounts.get(this.nextMoveName)+1);
            this.setPosition(this.nextMove);
        } else {
            this.actionCounts.put("STILL", this.actionCounts.get("STILL")+1);
            this.reinforcementValue--;
        }
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
    
    public void printActionCounts() {
        // Or just print it
        for(String k : this.actionCounts.keySet()) {
            System.out.println(k + ": " + this.actionCounts.get(k));
        }
    }
    
}