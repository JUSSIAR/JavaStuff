# DAG api

> Structure:

```
.
└── DAGapi
    ├── README.md
    ├── SerializationAndCoverage.pdf
    ├── pom.xml
    └── src
        ├── main
        │   ├── java
        │   │   └── com
        │   │       └── github
        │   │           └── jussiar
        │   │               └── api
        │   │                   ├── core
        │   │                   │   ├── bounds
        │   │                   │   │   └── BoundBox.java
        │   │                   │   ├── coordinates
        │   │                   │   │   └── Coord2D.java
        │   │                   │   └── nodes
        │   │                   │       ├── origin
        │   │                   │       │   └── Origin.java
        │   │                   │       ├── point
        │   │                   │       │   └── Point.java
        │   │                   │       ├── space
        │   │                   │       │   └── Space.java
        │   │                   │       └── vertex
        │   │                   │           └── Vertex.java
        │   │                   ├── exceptions
        │   │                   │   ├── AddSpaceException.java
        │   │                   │   ├── CycleException.java
        │   │                   │   ├── DAGException.java
        │   │                   │   └── RemoveNodeException.java
        │   │                   └── utils
        │   │                       ├── checker
        │   │                       │   ├── Color.java
        │   │                       │   └── Cycled.java
        │   │                       ├── format
        │   │                       │   └── FormatDouble.java
        │   │                       └── serialization
        │   │                           └── DAGUtils.java
        │   └── resources
        └── test
            └── java
                └── com
                    └── github
                        └── jussiar
                            └── api
                                ├── core
                                │   ├── bounds
                                │   │   └── BoundBoxTest.java
                                │   ├── coordinates
                                │   │   └── Coord2DTest.java
                                │   └── nodes
                                │       ├── origin
                                │       │   └── OriginTest.java
                                │       ├── point
                                │       │   └── PointTest.java
                                │       └── space
                                │           └── SpaceTest.java
                                └── utils
                                    └── format
                                        └── FormatDoubleTest.java
```