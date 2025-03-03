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

/**
 *
 * @author braujudd
 */
public class Environment {
    private int rows, cols;
    private Map<Point, Double> walls;
    private List<Agent> agents;
    private Point initialState;
    private Point finalState;
    
    private int conflictCount;
    private static Random random = new Random(System.currentTimeMillis());
    
    public Environment(int rows, int cols, Map<Point, Double> walls, List<Agent> agents, Point initialState, Point finalState) {
        this.rows = rows;
        this.cols = cols;
        this.walls = walls != null ? walls : new HashMap<>();
        this.agents = agents;
        this.initialState = new Point (initialState);
        this.finalState = new Point (finalState);
        
        this.conflictCount = 0;
    }
    
    public void makeMoves() {        
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
    
    public boolean isValidMove(Agent agent) {
        Point move = agent.getNextMove();
        //make sure this agents move are in the bounds
        if (move.x < 0 || move.y < 0 || move.x >= cols || move.y >= rows) {
            return false;
        }
        
        //make sure this agent isn't moving anywhere that someone else is
        for (Agent other : this.agents) {
            if (other.getNextMove().equals(move) && !agent.equals(other)) {
                conflictCount++;
                return false;
            }
        }
        
        //TODO: Check for walls
        
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

