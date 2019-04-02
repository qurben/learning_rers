package nl.tudelft.RERSlearner;

import de.learnlib.api.SUL;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

/**
 * Created by ramon on 13-12-16.
 */
public class ExampleExperiment {
    /**
     * Example of how to call a learner in a simple way with this class. Learns the ExampleSUL.
     * @param args
     * @throws IOException
     */
    public static void main(String [] args) throws IOException {
        // Load the actual SUL-class
        // For a SUL over a socket, use the SocketSUL-class
        // You can also program an own SUL-class if you extend SUL<String,String> (or SUL<S,T> in
        // general, with S and T the input and output types - but this class assumes strings)
        SUL<String,String> sul = new ExampleSUL();

        // the input alphabet
        Collection<String> inputAlphabet = Arrays.asList(args[0].split(""));

        // runControlledExperiment for detailed statistics, runSimpleExperiment for just the result
        BasicLearner.runControlledExperiment(sul, BasicLearner.LearningMethod.TTT, BasicLearner.TestingMethod.RandomWalk, inputAlphabet);
    }
}
