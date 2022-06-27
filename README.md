# ms-mars-robots
A new rover to explore mars and record many images for science.

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
 
 ## Type description

Tipo | Descrição
--:  | ----
 C   | character
 N   | number
 
# Movement

## Movement Rover [/rest/mars/{typeInputMove}]
Request responsible for making the rover move.

### Movement [POST]

## Description output: (0, 2, W)

  Value | Type | size  | Occurrence |  Note
  --:   | ---- |   --  |    --      |  --
  0     |  N   |  1/1  |    1-1     |  x position.
  2     |  N   |  1/1  |    1-1     |  y position
  W     |  C   |  1/1  |    1-1     |  Cardinal Points Directions.


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
  
+ Response 200 (application/json)

  (0, 2, W)

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
