package com.gofordroid.tennissimulator.Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TrangHo on 18-05-2015.
 */

//round and appropriate matches and playerList of round
public class RoundAndMatches {
    public int total_match;
    public int round;
    List<Match> matches;
    List<Player> players;

    public RoundAndMatches( int round,int total_match) {
        this.total_match = total_match;
        this.round = round;
        players = new ArrayList<Player>();
        matches = new ArrayList<Match>();


    }
    public RoundAndMatches(int round,int total_match, List<Player> players, List<Match> matches) {
        this.total_match = total_match;
        this.round = round;
        this.players = players;
        this.matches = matches;
    }
}
