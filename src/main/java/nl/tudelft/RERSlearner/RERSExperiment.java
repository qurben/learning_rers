package nl.tudelft.RERSlearner;

import de.learnlib.api.SUL;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

/**
 * Created by rick on 17/03/2017.
 */
public class RERSExperiment {
    /**
     * Example of how to learn a Mealy machine model from one of the compliled RERS programs.
     *
     * First argument is the alphabet, as a single string
     * Second argument is the file to process
     *
     * @param args
     * @throws IOException
     */
    public static void main(String [] args) throws IOException {
        if (args.length != 2) {
            System.out.println("Not enough arguments");
            return;
        }

        // Load the System Under Learning (SUL)
        SUL<String,String> sul = new ProcessSUL(args[1]);


        // the input alphabet
        Collection<String> inputAlphabet = Arrays.asList(args[0].split(","));

        // runControlledExperiment for detailed statistics, runSimpleExperiment for just the result
        //BasicLearner.runControlledExperiment(sul, BasicLearner.LearningMethod.TTT, BasicLearner.TestingMethod.RandomWalk, inputAlphabet);
        BasicLearner.runControlledExperiment(sul, BasicLearner.LearningMethod.TTT, BasicLearner.TestingMethod.WpMethod, inputAlphabet);
    }
}