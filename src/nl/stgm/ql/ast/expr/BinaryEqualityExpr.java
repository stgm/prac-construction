package nl.stgm.ql.ast.expr;

import nl.stgm.ql.ast.*;
import nl.stgm.ql.data.*;

public abstract class BinaryEqualityExpr extends BinaryExpr
{
	public BinaryEqualityExpr(ASTExpressionNode left, ASTExpressionNode right)
	{
		super(left, right);
	}

	public Type getType(ValueContext context)
	{
		return new BoolType();
	}
	
	public void checkType(TypeCheckContext context)
	{
		if(!(left.getType(context).supportedAsBool() && right.getType(context).supportedAsBool()) ||
		   !(left.getType(context).supportedAsInt()  && right.getType(context).supportedAsInt()))
		{
			context.registerTypeError(this, "Left and right are not of the same type.");
		}
	}
}
