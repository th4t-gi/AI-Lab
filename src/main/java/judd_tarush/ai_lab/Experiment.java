/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package judd_tarush.ai_lab;

import java.util.List;
import java.awt.Point;

/**
 *
 * @author braujudd
 */
public class Experiment {
    private Environment env;
    private List<Agent> agents;
    private int conflictCount;
    
    public Experiment(Environment env, List<Agent> agents) {
        this.env = env;
        this.agents = agents;
        this.conflictCount = 0;
    }
    
    public void runEpisode() {
        // Loop through agents until all at final
        // Check if each agent is to be run
        // If to be run, get next move
        // Check if valid move
        // Finalize move
        
    }
    
    public void report() {
        
    }
}
