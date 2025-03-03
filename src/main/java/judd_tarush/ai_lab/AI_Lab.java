/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package judd_tarush.ai_lab;

/**
 *
 * @author braujudd
 */
public class AI_Lab {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        
        Coordinate exp1Init = new Coordinate(0,0);
        Coordinate exp1Final = new Coordinate(0,0);
        
        Enviroment experiment1 = new Environment(3, 3, exp1Init, exp1Final);
        
        Experiment exp1 = new Experiement(experiment1, {new Agent(), new Agent()});
        
        experiment1.createAgent({0.3, 0.1, 0.2, 0.1, 0.3});
        
        experiment1.runExperiment(Strategy);
    }
}

class Experiement {
    
}




enum Moves {
    UP,
    DOWN,
    LEFT,
    RIGHT,
    STILL
}