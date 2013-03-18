package nl.stgm.ql.ast.expr.binary;

import nl.stgm.ql.ast.expr.*;
import nl.stgm.ql.ast.expr.literal.*;
import nl.stgm.ql.inspectors.*;

public class And extends BinaryExpr
{
	public And(Expr left, Expr right)
	{
		this.left = left;
		this.right = right;
	}

	public String toString()
	{
		return "&&";
	}

	public LiteralExpr reduceValue(ValueContext context)
	{
		Bool leftValue = (Bool) this.left.reduceValue(context);
		Bool rightValue = (Bool) this.right.reduceValue(context);
		
		return new Bool(leftValue.getValue() && rightValue.getValue());
	}
}
