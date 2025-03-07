/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package judd_tarush.ai_lab;

import java.awt.Point;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import javafx.util.Pair;

/**
 *
 * @author braujudd
 */
public class AI_Lab {

    public static void main(String[] args) {
        
        int episodes = 2;
        
       Map<String, Double> strat1 = Map.of("UP", 0.3, "DOWN", 0.1, "LEFT", 0.2, "RIGHT", 0.1, "STILL", 0.3);
       Map<String, Double> strat2 = Map.of("UP", 0.1, "DOWN", 0.3, "LEFT", 0.1, "RIGHT", 0.3, "STILL", 0.2);

        Agent agent1 = new Agent("Agent1", strat1, new Point(0, 0));
        Agent agent2 = new Agent("Agent2", strat2, new Point(0, 0));
        List<Agent> agents = Arrays.asList(agent1, agent2);
        
        Environment env1 = new Environment(3, 3, null, agents, new Point(0, 0), new Point(2, 2));
        
        Experiment exp1 = new Experiment(1, env1, agents, episodes);
        exp1.run();
        
        
        Map<Pair<Point, Point>, Wall> walls = Map.of(new Pair(new Point(0, 0), new Point(0, 1)), new Wall(0.5), new Pair(new Point(0, 0), new Point(1, 0)), new Wall(0.5));
        Environment env2 = new Environment(3, 3, walls, agents, new Point(0, 0), new Point(2, 2));
        
        Experiment exp2 = new Experiment(2, env2, agents, episodes);
        exp2.run();
        
        
        Environment env3 = new Environment(10, 3, null, agents, new Point(0, 0), new Point(2, 9));
        
        Experiment exp3 = new Experiment(3, env3, agents, episodes);
        exp3.run();
        
      
        /* 
        Agents = 4;
        Agent 1 = ("UP", 0.3, "DOWN", 0.1, "LEFT", 0.2, "RIGHT", 0.1, "STILL", 0.3)
        Agent 2 = ("UP", 0.1, "DOWN", 0.3, "LEFT", 0.1, "RIGHT", 0.3, "STILL", 0.2)
        Agent 3 = ("UP", 0.05, "DOWN", 0.4, "LEFT", 0.05, "RIGHT", 0.4, "STILL", 0.1)
        Agent 4 = ("UP", 0.1, "DOWN", 0.1, "LEFT", 0.1, "RIGHT", 0.1, "STILL", 0.6)
        
        TODO: ASCII Map of grid
        */
        Map<String, Double> strat3 = Map.of("UP", 0.05, "DOWN", 0.4, "LEFT", 0.05, "RIGHT", 0.4, "STILL", 0.1);
        Map<String, Double> strat4 = Map.of("UP", 0.1, "DOWN", 0.1, "LEFT", 0.1, "RIGHT", 0.1, "STILL", 0.6);
        
        Agent agent3 = new Agent("Agent1", strat1, new Point(1, 2));
        Agent agent4 = new Agent("Agent2", strat2, new Point(1, 1));
        Agent agent5 = new Agent("Agent3", strat3, new Point(1, 0));
        Agent agent6 = new Agent("Agent4", strat4, new Point(0, 2));
        List<Agent> agentsExp4 = Arrays.asList(agent3, agent4, agent5, agent6);
        Map<Pair<Point, Point>, Wall> wallsExp4 = Map.of(new Pair(new Point (2, 0), new Point(2, 1)), new Wall(1), 
        new Pair(new Point(3, 1), new Point(4, 1)), new Wall(0.69),
        new Pair(new Point(1, 3), new Point(2, 3)), new Wall(0.2),
        new Pair(new Point(4, 4), new Point(5, 4)), new Wall(0.5));
        
        Environment env4 = new Environment(6, 5, wallsExp4, agentsExp4, new Point(1, 2), new Point (4, 5));
        
        Experiment exp4 = new Experiment(4, env4, agentsExp4, episodes);
        exp4.run();
    }
}

