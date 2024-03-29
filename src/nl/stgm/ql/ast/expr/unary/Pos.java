package nl.stgm.ql.ast.expr.unary;

import nl.stgm.ql.ast.*;
import nl.stgm.ql.ast.expr.*;
import nl.stgm.ql.data.*;

public class Pos extends UnaryExpr
{
	public Pos(ASTExpressionNode arg)
	{
		super(arg);
	}

	public String toString()
	{
		return "+";
	}

	public Type checkType(TypeCheckContext context)
	{
		if(!arg.checkType(context).supportedAsInt())
		{
			context.registerError(this, "Argument to + should be an int.");
		}

		return new IntType();
	}

	public Value getValue(ValueContext context)
	{
		Value v = this.arg.getValue(context);
		
		if(v.getType().supportedAsInt())
		{
			return new Int(((Int) v).getValue());
		}
		else
		{
			return new Unknown();
		}
	}
}
