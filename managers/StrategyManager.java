package Spotify.managers;

import Spotify.enums.PlayStrategyType;
import Spotify.strategies.CustomStrategy;
import Spotify.strategies.PlayStrategy;
import Spotify.strategies.RandomStrategy;
import Spotify.strategies.SequentialStrategy;

public class StrategyManager {
    private static StrategyManager instance = null;
    private SequentialStrategy sequentialStrategy;
    private RandomStrategy randomStrategy;
    private CustomStrategy customQueueStrategy;

    private StrategyManager() {
        sequentialStrategy = new SequentialStrategy();
        randomStrategy = new RandomStrategy();
        customQueueStrategy = new CustomStrategy();
    }

    public static synchronized StrategyManager getInstance() {
        if (instance == null) {
            instance = new StrategyManager();
        }
        return instance;
    }

    public PlayStrategy getStrategy(PlayStrategyType type) {
        if (type == PlayStrategyType.SEQUENTIAL) {
            return sequentialStrategy;
        } else if (type == PlayStrategyType.RANDOM) {
            return randomStrategy;
        } else {
            return customQueueStrategy;
        }
    }
}
