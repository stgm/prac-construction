package nl.stgm.ql.ast.expr;

import nl.stgm.ql.ast.*;
import nl.stgm.ql.data.*;

public abstract class BinaryIntExpr extends BinaryExpr
{
	public BinaryIntExpr(ASTExpressionNode left, ASTExpressionNode right)
	{
		super(left, right);
	}

	public Type checkType(TypeCheckContext context)
	{
		if(!left.checkType(context).supportedAsInt() || !right.checkType(context).supportedAsInt())
			context.registerError(this, "Left or right is not of type int.");

		return new IntType();
	}
}
