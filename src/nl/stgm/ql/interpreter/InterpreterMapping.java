package nl.stgm.ql.interpreter;

import nl.stgm.ql.ast.*;

import java.util.Map;
import java.util.HashMap;

public class InterpreterMapping
{
	private Map<ASTDocumentNode,UIElement> map = new HashMap<ASTDocumentNode,UIElement>();

	public void put(ASTDocumentNode astNode, UIElement uiElt)
	{
		map.put(astNode, uiElt);
	}
	
	public boolean has(ASTDocumentNode astNode)
	{
		return map.containsKey(astNode);
	}
	
	public UIElement get(ASTDocumentNode astNode)
	{
		return map.get(astNode);
	}
	
	public void clear()
	{
		map.clear();
	}
}
