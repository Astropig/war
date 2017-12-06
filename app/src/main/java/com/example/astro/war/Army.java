package com.example.astro.war;

import android.util.Log;

import java.util.Random;

/**
 * Created by Astro on 12/5/2017.
 */

public class Army {
    private int damage;
    private int level;
    private int men;
    private int cost;
    String message;
    Random rnd = new Random();

    public Army(int damage,int level, int men, int cost)
    {
        this.cost = cost;
        this.damage = damage;
        this.level = level;
        this.men = men;
    }

    public int attack(int damage)
    {
        damage += this.damage;

        Log.d("damage",Integer.toString(damage));

        return damage;
    }

    public int battle(int damage)
    {
        this.men -= damage;
        if(this.men > 0)
        {
            Log.d("battle",Integer.toString(damage) + " men have been lost");
            Log.d("battle",Integer.toString(this.men) + " men left");
            //this.message = damage + " has ben lost";
            return 1;
        }
        else
            return -1;
    }

    public int getMen() {
        return men;
    }
}
