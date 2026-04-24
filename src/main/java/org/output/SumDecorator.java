package org.output;

public abstract class SumDecorator implements Sum {
    protected Sum wrappedSummary;

    public SumDecorator(Sum sum) {
        this.wrappedSummary = sum;
    }

    @Override
    public void print() {
        wrappedSummary.print();
    }
}