using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class CharacterTypePanel : MonoBehaviour
{
    public Role role;
    public NewCharacterManager NewCharacterManager;

    public void SelectRole()
    {
        NewCharacterManager.SetNewCharacterRole(role);
    }
}
