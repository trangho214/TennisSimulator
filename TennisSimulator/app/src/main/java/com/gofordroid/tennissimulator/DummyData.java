package com.gofordroid.tennissimulator;

import com.gofordroid.tennissimulator.Model.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TrangHo on 18-05-2015.
 */
public class DummyData {
    public static List<Player> getData(int n)
    {
      List<Player> players = new ArrayList<Player>();
        for (int i = 0; i<n; i++)
        {
            players.add(new Player(i,"Player" + i+1));
        }
        return players;
    }

}
