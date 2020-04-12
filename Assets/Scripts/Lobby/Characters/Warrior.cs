﻿using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Warrior : Character
{
    public Warrior(string name)
    {
        this.Name = name;
        this.Level = 0;
        this.Strength = Random.Range(0, 10);
        this.Dexterity = Random.Range(0, 10);
        this.Wisdom = Random.Range(0, 10);
        this.Inteligence = Random.Range(0, 10);
        this.Charisma = Random.Range(0, 10);
        this.Constiturion = Random.Range(0, 10);
    }

    public override string GetClassName()
    {
        return "Warrior";
    }
}
