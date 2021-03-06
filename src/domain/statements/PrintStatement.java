package domain.statements;

import domain.expressions.Expression;
import domain.state.State;
import exceptions.DivByZeroException;
import exceptions.InvalidOptionException;
import exceptions.VariableNotDefinedException;

public final class PrintStatement implements MyStatement {
    private static final long serialVersionUID = 3939065930029200827L;
    private final Expression expression;

    //Construct the printStatement depending on an Expression
    public PrintStatement(final Expression expression) {
        this.expression = expression;
    }

    @Override
    public State execute(final State programState)
        throws DivByZeroException, InvalidOptionException, VariableNotDefinedException {
        programState.addToOutput(programState.getEvaluation(expression).toString());
        return programState;
    }

    @Override
    public String toString() {
        return "print(" + expression.toString() + ')';
    }
}
