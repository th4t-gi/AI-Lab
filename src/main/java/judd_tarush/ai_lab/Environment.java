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
 */
public class Environment {
    private int rows, cols;
    private Map<Point, Double> walls;
    private Point initialState;
    private Point finalState;
    private static Random random = new Random(System.currentTimeMillis());
    
    public Environment(int rows, int cols, Map<Point, Double> walls, Point initialState, Point finalState) {
        this.rows = rows;
        this.cols = cols;
        this.walls = walls != null ? walls : new HashMap<>();
        this.initialState = new Point (initialState);
        this.finalState = new Point (finalState);
    }
    
    public boolean isValidMove(Point move) {
        if (move.getX() < 0 || move.getX() >= rows || move.getY() < 0 || move.getY() >= cols) {
            return false;
        }
        
        for (Agent other : agents) {
            if (!a.equals(other) && move.equals(other.position)) {
                return false;
            }
        }
        
        return true;
    }
    
    public Point getInitialState() {
        return initialState.getLocation();
    }
    
    public Point getFinalState() {
        return finalState.getLocation();
    }
    
}

