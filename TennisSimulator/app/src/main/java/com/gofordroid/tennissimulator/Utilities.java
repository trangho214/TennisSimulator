package com.gofordroid.tennissimulator;

import com.gofordroid.tennissimulator.Model.Player;
import com.gofordroid.tennissimulator.Model.PointCount;
import com.gofordroid.tennissimulator.Model.RoundAndMatches;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by TrangHo on 18-05-2015.
 */

public class Utilities  {

    public static boolean isPowerOfTwo(int n)
    {
        return (n & (n-1)) == 0;
    }

    public int findPower(int n)
    {
        int i = 1;
        while (n/2 != 1)
        {
            n = n/2;
            i = i+1;
        }
        return i;
    }


    public  double theNearestNumber(int n)
    {
        int power = 1;
        double powerOfTwo = 0;
        while (n> powerOfTwo)
        {
            power = power +1;
            powerOfTwo = Math.pow(2,power);
        }
        return powerOfTwo;
    }


    public  int numberWorkOver(int n)
    {
        double theNearestNumber = theNearestNumber(n);
        return (int)theNearestNumber -n;
    }

    public int numberOfNonWorkOver(int n)
    {
      return  n - numberWorkOver(n);
    }

    private int totalMatch(int n)
    {
        if(isPowerOfTwo(n))
            return n-1;
        else
        {
            int non_WorkOver = n -numberWorkOver(n);
            return non_WorkOver/2 + totalMatch(non_WorkOver/2 + numberWorkOver(n));
        }
    }

    public double totalRound(int n)
    {
        if(isPowerOfTwo(n))
            return findPower(n);
        else
        {
            double noneOver = n -numberWorkOver(n);
            return 1 + findPower((int) (noneOver / 2 + numberWorkOver(n)));
        }
    }


    //
    public List<RoundAndMatches> getRoundAndMatch(int n)
    {
        List<RoundAndMatches> roundAndMatches = new ArrayList<RoundAndMatches>();

        if(isPowerOfTwo(n))
        {
            int match = n;
            for (int i = 1; i<= totalRound(n); i++)
            {
                match = match/2;
                roundAndMatches.add(new RoundAndMatches(i, match));
            }
            return roundAndMatches;
        }
        else
        {
            roundAndMatches.add(new RoundAndMatches(1,numberOfNonWorkOver(n)/2 ));
            int match = numberOfNonWorkOver(n)/2 + numberWorkOver(n);
            for(int i = 2; i < totalRound(n); i++)
            {
                match = match/2;
                roundAndMatches.add(new RoundAndMatches(i, match));
            }
            return roundAndMatches;
        }
    }

    private boolean random()
    {
        return (new Random()).nextBoolean();
    }



    private Player MatchWinner(Player a, Player b, int round)
    {
        int winSetCountA = 0, winSetCountB = 0;
        a.nameOfCompetitor = b.name;
        b.nameOfCompetitor = a.name;
        //who reach 3 first is winner of match
        while (winSetCountA <3 || winSetCountB<3 ) {
            int countA = 0, countB = 0;
            //Who reach 6 first is winner of set
            while (countA < 6 || countB < 6) {
                if (random()) countA += 1;
                if (random()) countB += 1;
            }

            if (countA > countB) {
                a.pointCounts.add(new PointCount(countA, countB));
                b.pointCounts.add(new PointCount(countB, countA));
                winSetCountA +=1;
            }
            else {
                a.pointCounts.add(new PointCount(countA, countB));
                b.pointCounts.add(new PointCount(countB, countA));
                winSetCountB +=1;
            }
        }
        if(a.countWinningSet>b.countWinningSet)
        {
            a.round = round;
            return a;
        }
        else
        {
            b.round = round;
            return b;
        }
    }


}
