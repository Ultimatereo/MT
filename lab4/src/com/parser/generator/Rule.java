package com.parser.generator;

import java.util.List;

import java.util.List;

public class Rule {
    private final NonTerminal leftPart;
    private final List<Element> rightPart;

    public Rule(NonTerminal leftPart, List<Element> rightPart) {
        this.leftPart = leftPart;
        this.rightPart = rightPart;
    }

    public Rule(NonTerminal leftPart, Element... rightPart) {
        this.leftPart = leftPart;
        this.rightPart = List.of(rightPart);
    }

    public NonTerminal leftPart() {
        return leftPart;
    }

    public List<Element> rightPart() {
        return rightPart;
    }
}

