package com.github.CB2222124.connect4.player;

import com.github.CB2222124.connect4.Board;
import com.github.CB2222124.connect4.move.BasicMove;
import com.github.CB2222124.connect4.move.Move;
import com.github.CB2222124.connect4.token.TokenOwner;

import java.util.ArrayList;
import java.util.Random;


public class RandomAIPlayer extends Player {

    private final Random random;

    /**
     * Computer controlled player that makes a basic move into a random valid column each turn.
     *
     * @param token The token ownership associated with this player.
     * @param name  The display name for this player.
     */
    public RandomAIPlayer(TokenOwner token, String name) {
        super(token, name);
        random = new Random();
    }

    /**
     * Selects a completely random move.
     *
     * @param board The board to evaluate.
     * @return random valid column index.
     */
    @Override
    public Move getMove(Board board) {
        ArrayList<Integer> validColumns = new ArrayList<>();
        for (int column = 0; column < board.getBoard()[0].length; column++)
            if (board.getBoard()[0][column].owner() == TokenOwner.NONE) validColumns.add(column);
        int column = validColumns.get(random.nextInt(validColumns.size()));
        return new BasicMove(column, getToken());
    }
}
