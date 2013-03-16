package nl.stgm.ql.ast.terminals;

import nl.stgm.ql.ast.*;
import nl.stgm.ql.inspectors.*;

public class Bool extends TerminalExpr
{
	private final boolean value;

	public Bool(boolean b)
	{
		this.value = b;
	}

	public boolean getValue()
	{
		return value;
	}
	
	public String prettyString()
	{
		return("bool: " + String.valueOf(value));
	}

	public void check(SemanticChecker context)
	{
		System.out.println("Check 1 element!" + this.toString());
	}

	public Class getType(SemanticChecker context)
	{
		return(Bool.class);
	}
}
