package com.parser.generator.rule;

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

    @Override
    public String toString() {
        String rightPartString = getRightPartString();
        return leftPart.name() + " -> " + rightPartString;
    }

    private String getRightPartString() {
        StringBuilder sb = new StringBuilder();
        for (Element element : rightPart) {
            sb.append(element.name()).append(" ");
        }
        return sb.toString();
    }

    public NonTerminal leftPart() {
        return leftPart;
    }

    public List<Element> rightPart() {
        return rightPart;
    }
}

