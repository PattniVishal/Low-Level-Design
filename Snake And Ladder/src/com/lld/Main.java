package com.lld;

/*
E
Example - Snake and Ladder
1. https://github.com/gopalbala/snake-and-ladder
2. https://workat.tech/machine-coding/editorial/how-to-design-snake-and-ladder-machine-coding-ehskk9c40x2w
 */

import com.lld.service.GameService;
import com.lld.model.Ladder;
import com.lld.model.Player;
import com.lld.model.Snake;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        File file = new File("src/com/lld/input/GameInput.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));

        // add snakes
        int numberOfSnakes = Integer.parseInt(br.readLine());
        List<Snake> snakes = new ArrayList<>();
        for (int i = 0; i < numberOfSnakes; i++) {
            String[] snake = br.readLine().split(" ");
            int start = Integer.parseInt(snake[0]);
            int end = Integer.parseInt(snake[1]);
            snakes.add(new Snake(start, end));
        }

        // add ladders
        int numberOfLadders = Integer.parseInt(br.readLine());
        List<Ladder> ladders = new ArrayList<>();
        for (int i = 0; i < numberOfLadders; i++) {
            String[] ladder = br.readLine().split(" ");
            int start = Integer.parseInt(ladder[0]);
            int end = Integer.parseInt(ladder[1]);
            ladders.add(new Ladder(start, end));
        }

        // add players
        int numberOfPlayers = Integer.parseInt(br.readLine());
        Queue<Player> players = new LinkedList<>();
        for (int i = 0; i < numberOfPlayers; i++) {
            String name = br.readLine();
            players.add(new Player(name));
        }

        GameService game = new GameService();
        game.setBoard(snakes, ladders);
        game.setPlayers(players);

        game.initGame();
    }
}
