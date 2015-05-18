package com.gofordroid.tennissimulator.Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TrangHo on 18-05-2015.
 */
public class Player {
    public int id;
    public String name;

    //Save pointCounts for print-out
    public List<PointCount> pointCounts;
    public String nameOfCompetitor;
    public int countWinningSet;
    public boolean isWinner;
    public int round;

    public Player(int id,String name )
    {
        this.id = id;
        this.name = name;
        pointCounts = new ArrayList<>();
        countWinningSet = 0;
        isWinner = false;
        round = 0;
    }
    public Player(int id,String name, int round )
    {
        this.id = id;
        this.name = name;
        pointCounts = new ArrayList<>();
        countWinningSet = 0;
        isWinner = false;
        this.round = round;
    }

}
