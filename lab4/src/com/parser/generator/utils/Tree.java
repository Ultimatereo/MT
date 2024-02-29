package com.parser.generator.utils;

import com.parser.generator.rule.Element;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tree<T> {
    static int counter = 0;
    T val;
    final Element node;
    final int id;
    List<Tree> children;

    public Tree(Element node, Tree... children) {
        this.node = node;
        this.children = Arrays.asList(children);
        this.id = counter++;
    }

    public Tree(Element node) {
        this.node = node;
        this.children = new ArrayList<>();
        this.id = counter++;
    }

    // TODO: Extract this to another class cuz it's a bad design (Single Responsibility)
    @Override
    public String toString() {
        return "\"" + node + "_" + id + "\"";
    }

    public void writeUsing(BufferedWriter writer) throws IOException {
        writeNode(this.toString(), node, writer);
        for (Tree child : children) {
            writeNode(child.toString(), child.node, writer);
            writeEdge(this.toString(), child.toString(), writer);
            child.writeUsing(writer);
        }
    }

    private void writeEdge(String parent, String childNode, BufferedWriter writer) throws IOException {
        writer.write(parent + "->" + childNode + ";\n");
    }

    private void writeNode(String v_name, Element label, BufferedWriter writer) throws IOException {
        writer.write(v_name + " [label=\"" + label.name() + "\"]\n");
    }

    public T val() {
        return val;
    }
}
