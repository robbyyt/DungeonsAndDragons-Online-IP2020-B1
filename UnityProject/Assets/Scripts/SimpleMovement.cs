using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using System.Linq;

public class SimpleMovement : MonoBehaviour
{
    public Vector3 cameraOffset;
    public float speed;
    public float lateralSpeed;
    public float movementSpeed { get; private set; }
    private GameObject camera;  
    private CharacterController characterController;

    // Start is called before the first frame update
    void Start()
    {
        camera = Camera.main.gameObject;
        characterController = GetComponent<CharacterController>();
    }

    private void MoveCamera()
    {
        Vector3 wantedPosition =  transform.position + transform.forward * cameraOffset.z + new Vector3(0, cameraOffset.y, 0);
        if(Vector3.Distance(wantedPosition, camera.transform.position) >= 0.2)
        {
            Debug.Log(wantedPosition + " " + camera.transform.position + " " + Vector3.Distance(wantedPosition, camera.transform.position));
            float speed = Vector3.Distance(wantedPosition, camera.transform.position) * 2;
            camera.transform.position =  Vector3.MoveTowards(camera.transform.position, wantedPosition, Mathf.Min(10*Time.deltaTime, speed*Time.deltaTime));
            camera.transform.LookAt(transform.position);
        }
    }
    // Update is called once per frame
    void Update()
    {
        Ray ray = Camera.main.ScreenPointToRay(Input.mousePosition);
        foreach(RaycastHit hit in Physics.RaycastAll(ray, 1000))
        {
            if (hit.transform.tag == "Terrain")
            {
                if (Vector3.Distance(transform.position, hit.point) >= 1)
                {
                    this.transform.LookAt(hit.point);
                    transform.rotation = Quaternion.Euler(0, transform.rotation.eulerAngles.y, 0);
                }
            }
        }

        Vector3 movement = new Vector3(Input.GetAxis("Horizontal") * speed, 0, Input.GetAxis("Vertical") * lateralSpeed);
        movement = transform.rotation * movement;
        characterController.SimpleMove(movement);
        movementSpeed = movement.magnitude;
        MoveCamera();

        
    }
}
