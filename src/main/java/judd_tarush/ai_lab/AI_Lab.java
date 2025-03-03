/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package judd_tarush.ai_lab;

import java.awt.Point;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 *
 * @author braujudd
 */
public class AI_Lab {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        
        Point init1 = new Point(0,0);
        Point final1 = new Point(2,2);
        Map<String, Double> strat1 = Map.of("UP", 0.3, "DOWN", 0.1, "LEFT", 0.2, "RIGHT", 0.1, "STILL", 0.3);
        Map<String, Double> strat2 = Map.of("UP", 0.1, "DOWN", 0.3, "LEFT", 0.1, "RIGHT", 0.3, "STILL", 0.2);

        Agent agent1 = new Agent("Agent1", strat1, init1);
        Agent agent2 = new Agent("Agent2", strat2, init1);
        List<Agent> agents = Arrays.asList(agent1, agent2);
        
        Environment env1 = new Environment(3, 3, null, agents, init1, final1);
        
        Experiment exp1 = new Experiment(env1, agents);
        exp1.runEpisode();
        exp1.report();
    }
}


enum Moves {
    UP,
    DOWN,
    LEFT,
    RIGHT,
    STILL
}