# ms-mars-robots
A new rover to explore mars and record many images for science.

## Some topics about the application
 * The terrain starts with 5x5 positions;
 * The rover starts at coordinate (0,0,N);
 * The Rover cannot move outside the specified area;
 * Does not save rover state for another query.

## Input Movement Orientations description.

Type | Description
--:  | ----
 M   | Move
 R   | Right
 L   | Left
 
## Cardinal Points Output Directions description.

Type | Description
--:  | ----
 N   | North
 S   | South
 E   | East
 W   | West
 
 ## Type description.

Type | Description
--:  | ----
 C   | character
 N   | number
 
# Movement

## Movement Rover [/rest/mars/{typeInputMove}]
Request responsible for making the rover move.

### Movement [POST]

## Status code response 400
  Errors that may occur during request processing:

  Code | Message
  --:  | ----
  1    | Movement position not found.
  2    | Invalid movement command.
  3    | The rover has exceeded the bounded movement perimeter.
  
  ## Status code response 500
  Errors that may occur during request processing:
  
  Code | Message
  --:  | ----
  999  | An unidentified problem occurred while trying to move the Rover.
  
  
+ Parameters
  + typeInputMove : `MML` (required, string).
  + Exemple: `/rest/mars/MML`
  
+ Response 200 (application/json)

  (0, 2, W)
  
  ## Output description: (0, 2, W)

  Value | Type | size  | Occurrence |  Note
  --:   | ---- |   --  |    --      |  --
  0     |  N   |  1/1  |    1-1     |  x position.
  2     |  N   |  1/1  |    1-1     |  y position
  W     |  C   |  1/1  |    1-1     |  Cardinal Points Directions.

+ Response 400 (application/json)

  {
      "errors": [
          {
              "code": code,
              "message": "Error message."
          }
      ]
  }

+ Response 500 (application/json)

  {
      "errors": [
          {
              "code": -999,
              "message": "Error message."
          }
      ]
  }
