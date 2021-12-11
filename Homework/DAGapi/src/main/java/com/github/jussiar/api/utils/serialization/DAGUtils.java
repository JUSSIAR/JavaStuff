package com.github.jussiar.api.utils.serialization;

import com.github.jussiar.api.core.coordinates.Coord2D;
import com.github.jussiar.api.core.nodes.origin.Origin;
import com.github.jussiar.api.core.nodes.point.Point;
import com.github.jussiar.api.core.nodes.space.Space;
import com.github.jussiar.api.core.nodes.vertex.Vertex;
import com.github.jussiar.api.utils.format.FormatDouble;

import java.util.*;

/**
 * @apiNote Serialization and Deserialization
 * @author Klokov Stas
 * @version 1.0.0
 * @see Vertex
 * @see Space
 * @see FormatDouble
 * @see Point
 * @see Origin
 * @see Coord2D
 */
public class DAGUtils {
    /**
     * Serialization
     * @param space Space type
     * @return string
     */
    public static String exportAsString(Space space) {
        HashMap<Vertex, Integer> idByVertex = new HashMap<>();
        TreeMap<Integer, Vertex> vertexById = new TreeMap<>();
        HashSet<Vertex> used = new HashSet<>();
        List<List<Integer>> graph = new ArrayList<>();

        DAGUtils.dfs(space, idByVertex, vertexById, used);

        for (int i = 0; i < used.size(); i++) {
            graph.add(new ArrayList<>());
            if (vertexById.get(i) instanceof Point) {
                continue;
            }
            for (Vertex vertex : ((Origin)vertexById.get(i)).getChildren()) {
                graph.get(i).add(idByVertex.get(vertex));
            }
        }

        StringBuilder serialized = new StringBuilder();
        serialized.append(used.size());
        serialized.append('\n');
        for (int i = 0; i < used.size(); i++) {
            if (vertexById.get(i) instanceof Point) {
                serialized.append('P');
            }
            if (vertexById.get(i) instanceof Origin) {
                serialized.append('O');
            }
            if (vertexById.get(i) instanceof Space) {
                serialized.append('S');
            }
            serialized.append(' ');
            serialized.append(i);
            serialized.append(' ');
            serialized.append(FormatDouble.format(vertexById.get(i).getPosition().x()));
            serialized.append(' ');
            serialized.append(FormatDouble.format(vertexById.get(i).getPosition().y()));
            serialized.append('\n');
        }
        for (int i = 0; i < used.size(); i++) {
            serialized.append(graph.get(i).size());
            for (Integer id : graph.get(i)) {
                serialized.append(' ');
                serialized.append(id);
            }
            serialized.append('\n');
        }
        return serialized.toString();
    }

    /**
     * Deserialization
     * @param string String type
     * @return space
     */
    public static Space importFromString(String string) {
        Space space = new Space();
        List<Vertex> list = new ArrayList<>();
        String[] rows = string.split("\n");
        int size = Integer.parseInt(rows[0]);
        for (int i = 1; i <= size; i++) {
            String[] row = rows[i].split(" ");
            double x = Double.parseDouble(row[2]);
            double y = Double.parseDouble(row[3]);
            if (row[0].equals("S")) {
                space = new Space();
                list.add(space);
            }
            if (row[0].equals("O")) {
                list.add(new Origin(new Coord2D(x, y)));
            }
            if (row[0].equals("S")) {
                list.add(new Point(new Coord2D(x, y)));
            }
        }
        for (int i = 1; i <= size; i++) {
            String[] row = rows[i + size].split(" ");
            int rowSize = Integer.parseInt(row[0]);
            for (int j = 1; j <= rowSize; j++) {
                int id = Integer.parseInt(row[i]);
                ((Origin)list.get(i - 1)).addChild(list.get(id));
            }
        }
        return space;
    }

    /**
     * Serialization recursive helper
     */
    private static void dfs(
            Vertex vertex,
            HashMap<Vertex, Integer> idByVertex,
            TreeMap<Integer, Vertex> vertexById,
            HashSet<Vertex> used
    ) {
        if (used.contains(vertex)) {
            return;
        }
        idByVertex.put(vertex, used.size());
        vertexById.put(used.size(), vertex);
        used.add(vertex);
        if (vertex instanceof Point) {
            return;
        }

        for (Vertex child : ((Origin)vertex).getChildren()) {
            dfs(child, idByVertex, vertexById, used);
        }
    }
}
