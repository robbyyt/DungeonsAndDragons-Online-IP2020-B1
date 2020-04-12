using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class DemoScene : MonoBehaviour {

	//public Animator animator;
	public Text text;
	//public Animator animator;

	private int _index = 0;

	// Use this for initialization
	void Start () {

		ChangeAnimation();
	}
	
	// Update is called once per frame
	void Update () {

		if (Input.GetKeyUp(KeyCode.LeftArrow))
		{
			_index -= 1;
			if (_index < 0)
			{
				_index = 8;
			}
			ChangeAnimation();
		}
		else if (Input.GetKeyUp(KeyCode.RightArrow))
		{
			_index += 1;
			if (_index > 8)
			{
				_index = 0;
			}
			ChangeAnimation();
		}

		
	}

	void ChangeAnimation ()
	{

		Animator animator1 = GameObject.Find("girl1/girl_hair_01").GetComponent<Animator>();
		animator1.SetInteger("index", _index);

		animator1 = GameObject.Find("girl1/girl_face_01").GetComponent<Animator>();
		animator1.SetInteger("index", _index);

		animator1 = GameObject.Find("girl1/girl_arms_01").GetComponent<Animator>();
		animator1.SetInteger("index", _index);

		animator1 = GameObject.Find("girl1/clothingSet_04_body").GetComponent<Animator>();
		animator1.SetInteger("index", _index);

		animator1 = GameObject.Find("girl1/clothingSet_04_boots").GetComponent<Animator>();
		animator1.SetInteger("index", _index);

		animator1 = GameObject.Find("girl1/clothingSet_04_pants").GetComponent<Animator>();
		animator1.SetInteger("index", _index);

		string name = "";
		switch (_index)
		{
			case 0:
				name = "idle";
				break;
			/*
			case 1:
				name = "walk";
				break;
			case 2:
				name = "attackBite1";
				break;
			case 3:
				name = "attackBite2";
				break;
			case 4:
				name = "attackFireball";
				break;
			case 5:
				name = "attackSpell";
				break;
			case 6:
				name = "attackTail";
				break;
			case 7:
				name = "getDamage";
				break;
			case 8:
				name = "death";
				break;
*/

		}

		//text.text = string.Concat(_index.ToString(), ". ", name);
	}
}
