using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public abstract class Character 
{
    public string Name { get; protected set; }
    public int Level { get; protected set; }
    public int Strength { get; protected set; }
    public int Dexterity { get; protected set; }
    public int Constiturion { get; protected set; }
    public int Inteligence { get; protected set; }
    public int Wisdom { get; protected set; }
    public int Charisma { get; protected set; }
    public abstract Role GetRole();
    public abstract string GetClassName();
}
