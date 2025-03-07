/*
* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
* Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
*/
package judd_tarush.ai_lab;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javafx.util.Pair;

/**
 *
 * @author braujudd
 */
public class Environment {
    private int rows, cols;
    private Map<Pair<Point, Point>, Wall> walls;
    private List<Agent> agents;
    private Point initialState;
    private Point finalState;
    
    private int conflictCount;
    
    public Environment(int rows, int cols, Map<Pair<Point, Point>, Wall> walls, List<Agent> agents, Point initialState, Point finalState) {
        this.rows = rows;
        this.cols = cols;
        this.walls = walls != null ? walls : new HashMap<>();
        this.agents = agents;
        this.initialState = new Point (initialState);
        this.finalState = new Point (finalState);
        
        this.reset();
    }
    
    public void makeMoves() {   
        for(Wall wall : this.walls.values()) {
            wall.checkIfClose();
        }
        
        //get everyones move that they want
        for (Agent a : agents) {
            
            // Check if each agent is to be run
            if (!a.getPosition().equals(this.finalState)) {
                // If to be run, get next move
                a.selectAction();
            }
        }
        
        for (Agent a : agents) {
            // Check if each agent is to be run
            if (!a.getPosition().equals(this.finalState)) {
                //checks valid move
                a.move(isValidMove(a));
            }
        }
    }
    
    public void reset() {
        for (Agent a : agents) {
            a.reset();
        }
        this.conflictCount = 0;
    }
    
    public boolean isValidMove(Agent agent) {
        //make sure this agents move are in the bounds
        Point move = agent.getNextMove();
        if (move.x < 0 || move.y < 0 || move.x >= cols || move.y >= rows) {
            return false;
        }
        
        //make sure this agent isn't moving anywhere that someone else is
        for (Agent other : this.agents) {
            if (!move.equals(finalState) && other.getNextMove().equals(move) && !agent.equals(other)) {
                conflictCount++;
                return false;
            }
        }
        
        //check for walls
        Wall wallCheck1 = this.walls.get(new Pair(agent.getPosition(), move));
        Wall wallCheck2 = this.walls.get(new Pair(move, agent.getPosition()));
        if((wallCheck1 != null && wallCheck1.getClose()) || (wallCheck2 != null && wallCheck2.getClose())) {
            return false;
        }
      
        return true;
    }
    
    public Point getInitialState() {
        return initialState.getLocation();
    }
    
    public Point getFinalState() {
        return finalState.getLocation();
    }
    
    public int getConflictCount() {
        return conflictCount;
    }
    
}

class Wall {
    
    private boolean close = false;
    private static Random random = new Random(System.currentTimeMillis());
    private double wallCloseProb; 
    
    public Wall(double prob) {
        this.wallCloseProb = prob;
    }
    
    public void checkIfClose() {
        if(wallCloseProb > random.nextDouble()) {
            this.close = true;
        }
        else {
            this.close = false;
        }
    }
    
    public boolean getClose() {
        return this.close;
    }
}

