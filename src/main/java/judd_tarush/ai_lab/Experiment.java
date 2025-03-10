/*
* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
* Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
*/
package judd_tarush.ai_lab;

import java.util.List;

/**
 *
 * @author braujudd
 */
public class Experiment {
    private int experiment;
    private Environment env;
    private List<Agent> agents;
    private int episodes;

    
    public Experiment(int experiment, Environment env, List<Agent> agents, int episodes) {
        this.experiment = experiment;
        this.env = env;
        this.agents = agents;
        this.episodes = episodes;
    }
    
    public void run() {
        System.out.println("\nExperiment " + this.experiment + ": ");
        for(int i = 1; i <= this.episodes; i++) {
            System.out.println("\nEpisode " + i + ":\n");
            runEpisode();
            report();
        }
    }
    
    public void runEpisode() {
        this.env.reset();
        // Loop through agents until all at final
        while (!allAtFinalState()) {
            this.env.makeMoves();
        }
    }
    
    private boolean allAtFinalState() {
        for (Agent a : agents) {
            if (!a.getPosition().equals(this.env.getFinalState())) {
                return false;
            }
        }
        return true;
    }
    
    public void report() {
        int optimalDistance = Math.abs((this.env.getFinalState().x - this.env.getInitialState().x) + 
                (this.env.getFinalState().y - this.env.getInitialState().y));
        System.out.println("The optimal number of steps is "+ optimalDistance);
        
        int totalSteps = 0;
        for (Agent a : this.agents) {
            totalSteps+= a.getStepsTaken();
            System.out.println("Agent " + a.getName() + " took " + a.getStepsTaken() + " steps.");
            System.out.println("The accumulated reinforcement value was " + a.getReinforcementValue());
            System.out.println("The action steps for our agent were:");
            a.printActionCounts();
        }
        
        System.out.println("The average steps taken by our agents is " + (totalSteps/this.agents.size()));
        
        System.out.println("The number of conflicts by our agents was " + this.env.getConflictCount());  
    }
}
